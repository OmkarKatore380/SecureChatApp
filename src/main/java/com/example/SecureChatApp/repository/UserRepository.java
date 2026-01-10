package com.example.SecureChatApp.repository;

import com.example.SecureChatApp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByMilitaryId(String militaryId);
}