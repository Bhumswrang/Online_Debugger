package com.user.User.service;

import com.user.User.entity.User;

import java.util.List;

public interface UserService {
    public List<User> getAllUsers();
    public User getUserById(Long uid);
    public User addUser(User user);
    public User updateUser(User user);
    public String deleteUser(Long uid);
    public boolean validateUserId(Long uid);
}
