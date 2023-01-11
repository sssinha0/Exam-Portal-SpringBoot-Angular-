package com.exam.service;

import com.exam.entity.login.User;
import com.exam.entity.login.UserRole;
import org.springframework.http.ResponseEntity;

import java.util.Set;

public interface UserService {

    public ResponseEntity<Object> createUser(User user, Set<UserRole> role);

    public User getUser(String userName);

    public void deleteUser(Long userId);

    public User updateUser(User user);
}
