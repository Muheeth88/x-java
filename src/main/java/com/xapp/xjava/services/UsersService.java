package com.xapp.xjava.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xapp.xjava.entities.UserEntity;
import com.xapp.xjava.repositories.UsersRepository;

@Service
public class UsersService {

    @Autowired
    private UsersRepository usersRepository;

    // ------------- create user
    public UserEntity createUser(UserEntity req) {

        UserEntity newUser = new UserEntity();
        newUser.setUserName(req.getUserName());
        newUser.setEmail(req.getEmail());
        newUser.setRole(req.getRole());
        newUser.setPassword(req.getPassword());
        newUser.setDateOfBirth(req.getDateOfBirth());

        return usersRepository.save(newUser);
    }

    // ----------------- get all users
    public List<UserEntity> getAllUsers() {
        List<UserEntity> allUsers = usersRepository.findAll();
        return allUsers;
    }

    // ----------------- get user
    public Optional<UserEntity> getUser(Long userId) {
        Optional<UserEntity> user = usersRepository.findById(userId);
        return user;
    }

}
