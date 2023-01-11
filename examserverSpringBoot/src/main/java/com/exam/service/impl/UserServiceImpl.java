package com.exam.service.impl;

import com.exam.dao.ErrorResponse;
import com.exam.entity.login.User;
import com.exam.entity.login.UserRole;
import com.exam.repo.RoleRepository;
import com.exam.repo.UserRepository;
import com.exam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    @Override
    public ResponseEntity<Object> createUser(User user, Set<UserRole> role) {
        //if user exists
        User local=userRepository.findByUsername(user.getUsername());
        if(local!=null){
            System.out.println("User is already exists");
            ErrorResponse errorResponse=new ErrorResponse("User already exists","404");
           return ResponseEntity.badRequest().body(errorResponse);
//            throw new Exception("User Already Present");
        }
        else{
            for(UserRole r:role){
                roleRepository.save(r.getRole());
            }
            user.setUserRole(role);
            local=userRepository.save(user);

        }

        return ResponseEntity.accepted().body(local);
    }

    @Override
    public User getUser(String userName) {
        return userRepository.findByUsername(userName);
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public User updateUser(User user) {
        User local=userRepository.findByUsername(user.getUsername());
        User resUser=null;
        if(local!=null){
            System.out.println("User is already exists");
        }
        else{
            local.setProfile(user.getProfile());
            local.setUsername(user.getUsername());
            local.setPassword(user.getPassword());
            local.setPhone(user.getPhone());
            local.setEnabled(user.isEnabled());
            local.setEmail(user.getEmail());
            local.setLastName(user.getLastName());
            local.setFirstName(user.getFirstName());
            local.setAbout(user.getAbout());
            local.setUserRole(user.getUserRole());
            local.setId(user.getId());
            resUser=userRepository.save(local);

        }

        return resUser;
    }
}
