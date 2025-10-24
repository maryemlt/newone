package com.example.projetmpisi2.service;

import com.example.projetmpisi2.entity.User;
import java.util.List;

public interface IUserService {
    User saveUser(User user);
    List<User> getAllUsers();
    User getUserById(Long id);
    User updateUser(User user);
    void deleteUser(Long id);
}
