package com.stackroute.authenticationserver.service;

import com.stackroute.authenticationserver.model.User;
import com.stackroute.authenticationserver.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userDao;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("loadUserByUsername");
        User user = userDao.findByUsername(username);
        System.out.println("ahem");
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                new ArrayList<>());
    }

    public User save(User user) throws Exception {
        user.setPassword(bcryptEncoder.encode(user.getPassword()));
        if (userDao.existsById(user.getId()))
            throw new Exception("User already exists");
        if (userDao.findByUsername(user.getUsername()) != null)
            throw new Exception("Username already exists");
        else
            return userDao.save(user);
    }


}
