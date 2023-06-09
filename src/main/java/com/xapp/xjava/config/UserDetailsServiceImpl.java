package com.xapp.xjava.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.xapp.xjava.entities.User;
import com.xapp.xjava.repositories.UsersRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
       User user = usersRepository.findByEmail(username);
       if(user == null) {
        throw new UsernameNotFoundException("User Not Found!");
       }
       
        return new CustomUserDetails(user);
    }

}
