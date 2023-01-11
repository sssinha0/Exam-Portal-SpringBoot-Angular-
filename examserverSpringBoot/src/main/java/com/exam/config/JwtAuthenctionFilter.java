package com.exam.config;

import com.exam.service.impl.UserDetailsImpl;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtAuthenctionFilter extends OncePerRequestFilter {

    @Autowired
    private UserDetailsImpl userDetails;
    @Autowired
    private JwtUtils jwtutils;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {


        final String requestTokenHeader=request.getHeader("Authorization");
        System.out.println("shashi"+requestTokenHeader);
        System.out.println(requestTokenHeader);
        String username=null;
        String jwtToken=null;
        if(requestTokenHeader!=null&&requestTokenHeader.startsWith("Bearer ")){
            //yes

            jwtToken=requestTokenHeader.substring(7);

            try {
                username = this.jwtutils.extractUsername(jwtToken);
                System.out.println("something happen ="+jwtToken+" username="+username);
            }catch (ExpiredJwtException e){
                e.printStackTrace();
                System.out.println("Jwt token has expired");
            }catch (Exception e){
                e.printStackTrace();
                System.out.println("error");
            }
        }else{
            System.out.println("Invalid token,not start with bearer string");
        }
        //validate
        if(username!=null&& SecurityContextHolder.getContext().getAuthentication()==null){
            final UserDetails userDetails1=this.userDetails.loadUserByUsername(username);
            if(this.jwtutils.validateToken(jwtToken,userDetails1)){
                //token vlaid
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken=new UsernamePasswordAuthenticationToken(userDetails1,null,userDetails1.getAuthorities());
                usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }
        }else {
            System.out.println("Token is not valid");
        }
        filterChain.doFilter(request,response);
    }
}
