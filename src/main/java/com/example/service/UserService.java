package com.example.service;

import com.example.dto.UserUpsertDto;
import com.example.model.User;

import java.util.List;

public interface UserService {

    User saveUser(UserUpsertDto dto);

    User getUserById(String id);

    List<User> getAllUsers();

    void deleteUserById(String id);

    User updateUserById(String id, UserUpsertDto dto);
}
