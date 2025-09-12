package com.example.JWTProject.service;


import com.example.JWTProject.model.AuthResponse;
import com.example.JWTProject.model.User;
import com.example.JWTProject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JWTService jwtService;

    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(12);


    public User addUser(User user) {
        System.out.println("addUser2");
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public User findById(int id){
        return userRepository.findById(id).orElse(null);
    }

    public User updateUser(User user, int id) {
        return userRepository.save(user);
    }
    public void deleteUser(int id){
        userRepository.deleteById(id);
    }


    public AuthResponse verify(User user){

        User usrid = userRepository.findByUsername(user.getUsername());
        Integer id = usrid.getId();
        Authentication authentication =
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword()));
        if(authentication.isAuthenticated())




            return new AuthResponse(jwtService.generateToken(user.getUsername()), id);
        return new AuthResponse("fail",0);

    }
}

