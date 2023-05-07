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
    public UserEntity createUser(UserEntity user) {
        UserEntity newUser = usersRepository.save(user);
        return newUser;
    }

    // ----------------- get all users
    public List<UserEntity> getAllUsers() {
        List<UserEntity> allUsers = usersRepository.findAll();
        return allUsers;
    }

    // ----------------- get user
    public Optional<UserEntity> getUser(Long userId) {
        Optional<UserEntity> user = usersRepository.findById(userId);
        // UserEntity user = usersRepository.findByUserId();
        return user;
    }

    public Optional<UserEntity> getUser(String userName) {
        Optional<UserEntity> user = usersRepository.findByUserName(userName);
        return user;
    }

    public UserEntity editUser(Long userId, UserEntity user) {
        Optional<UserEntity> currentUserOp = getUser(userId);
        if (currentUserOp.isPresent()) {
            UserEntity currentUser = currentUserOp.get();
            currentUser.setUserName(user.getUserName());
            currentUser.setDateOfBirth(user.getDateOfBirth());
            currentUser.setEmail(user.getEmail());
            currentUser.setPassword(user.getPassword());
            currentUser.setRole(user.getRole());

            UserEntity modifiedUser = createUser(currentUser);
            return modifiedUser;
        }

        return null;

    }
}
