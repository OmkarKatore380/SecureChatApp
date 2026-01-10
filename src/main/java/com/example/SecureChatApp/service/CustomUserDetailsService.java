package com.example.SecureChatApp.service;

import com.example.SecureChatApp.entities.User;
import com.example.SecureChatApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String militaryId) throws UsernameNotFoundException {
        User user = userRepository.findByMilitaryId(militaryId)
                .orElseThrow(() -> new UsernameNotFoundException("ID not found: " + militaryId));

        return new org.springframework.security.core.userdetails.User(
                user.getMilitaryId(),
                user.getPassword(),
                new ArrayList<>()
        );
    }
}