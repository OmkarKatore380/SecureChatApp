package com.example.SecureChatApp.controller;

import com.example.SecureChatApp.entities.Message;
import com.example.SecureChatApp.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;

@RestController
public class ChatController {
    @Autowired private SimpMessagingTemplate messagingTemplate;
    @Autowired private MessageRepository messageRepository;

    @MessageMapping("/private-message")
    public void receiveMessage(Message message) {
        message.setTimeStamp(LocalDateTime.now());
        messageRepository.save(message);
        messagingTemplate.convertAndSend("/topic/user/" + message.getReceiverId(), message);
    }

    @GetMapping("/api/messages/{myId}")
    public List<Message> getHistory(@PathVariable String myId) {
        return messageRepository.findByReceiverIdOrderByTimeStampAsc(myId);
    }
}