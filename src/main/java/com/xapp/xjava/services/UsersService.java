package com.xapp.xjava.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xapp.xjava.entities.User;
import com.xapp.xjava.repositories.UsersRepository;

@Service
public class UsersService {

    @Autowired
    private UsersRepository usersRepository;

    // ------------- create user
    public User createUser(User user) {
        User newUser = usersRepository.save(user);
        return newUser;
    }

    // ----------------- get all users
    public List<User> getAllUsers() {
        List<User> allUsers = usersRepository.findAll();
        return allUsers;
    }

    // ----------------- get user
    public Optional<User> getUser(Long userId) {
        Optional<User> user = usersRepository.findById(userId);
        // UserEntity user = usersRepository.findByUserId();
        return user;
    }

    public Optional<User> getUser(String userName) {
        Optional<User> user = usersRepository.findByUserName(userName);
        return user;
    }

    public User editUser(Long userId, User user) {
        Optional<User> currentUserOp = getUser(userId);
        if (currentUserOp.isPresent()) {
            User currentUser = currentUserOp.get();
            currentUser.setUserName(user.getUserName());
            currentUser.setDateOfBirth(user.getDateOfBirth());
            currentUser.setEmail(user.getEmail());
            currentUser.setPassword(user.getPassword());
            currentUser.setRole(user.getRole());

            User modifiedUser = createUser(currentUser);
            return modifiedUser;
        }

        return null;

    }
}
