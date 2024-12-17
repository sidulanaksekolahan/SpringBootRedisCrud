package com.example.service;

import com.example.dto.UserUpsertDto;
import com.example.handler.UserNotFoundExc;
import com.example.model.User;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User saveUser(UserUpsertDto dto) {
        User user = new User(dto.getName(), dto.getAge());

        return userRepository.save(user);
    }

    @Override
    public User getUserById(String id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundExc("user with id: " + id + " not found!"));
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();

        Iterator<User> userIterator = userRepository.findAll().iterator();
        while (userIterator.hasNext()) {
            users.add(userIterator.next());
        }

        return users;
    }

    @Override
    public void deleteUserById(String id) {
        User user = getUserById(id);

        userRepository.delete(user);
    }

    @Override
    public User updateUserById(String id, UserUpsertDto dto) {
        User theUser = getUserById(id);

        // update user
        theUser.setName(dto.getName());
        theUser.setAge(dto.getAge());

        // save user and return it
        return userRepository.save(theUser);
    }
}
