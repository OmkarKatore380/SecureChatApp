package com.example.SecureChatApp.repository;

import com.example.SecureChatApp.entities.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {
    List<Message> findByReceiverIdOrderByTimeStampAsc(String receiverId);
}