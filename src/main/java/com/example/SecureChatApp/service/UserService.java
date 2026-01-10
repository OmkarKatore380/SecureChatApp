package com.example.SecureChatApp.service;

import com.example.SecureChatApp.entities.User;
import com.example.SecureChatApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.security.*;
import java.util.Base64;
import java.util.Random;

@Service
public class UserService {
    @Autowired private UserRepository userRepository;
    @Autowired private BCryptPasswordEncoder encoder;

    public User registerUser(String rawPassword, String displayName) throws Exception {
        User user = new User();
        user.setMilitaryId(generateId());
        user.setPassword(encoder.encode(rawPassword));
        user.setDisplayName(displayName);
        
        KeyPairGenerator kg = KeyPairGenerator.getInstance("RSA");
        kg.initialize(2048);
        user.setPublicKey(Base64.getEncoder().encodeToString(kg.generateKeyPair().getPublic().getEncoded()));
        return userRepository.save(user);
    }

    private String generateId() {
        return new Random().ints(48, 122)
            .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
            .limit(6)
            .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
            .toString().toUpperCase();
    }
}