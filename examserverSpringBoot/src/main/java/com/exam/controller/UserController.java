package com.exam.controller;

import com.exam.entity.login.Role;
import com.exam.entity.login.User;
import com.exam.entity.login.UserRole;
import com.exam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;


import java.util.HashSet;
import java.util.Set;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/")
    public ResponseEntity<Object> createUser(@RequestBody User user){
        Role role=new Role();
        role.setRoleId(45L);
        role.setRoleName("Normal");
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        UserRole userRole=new UserRole();
        userRole.setRole(role);
        userRole.setUser(user);
        Set<UserRole> userroleSet=new HashSet<>();
        userroleSet.add(userRole);
        return userService.createUser(user,userroleSet);
    }
    @GetMapping("/{username}")
    public  User getUser(@PathVariable("username") String userName){
        return  userService.getUser(userName);
    }
    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable("userId") Long userId){
        userService.deleteUser(userId);
    }
    @PutMapping("/")
    public User updateUser(@RequestBody User user){
       return userService.updateUser(user);

    }
}
