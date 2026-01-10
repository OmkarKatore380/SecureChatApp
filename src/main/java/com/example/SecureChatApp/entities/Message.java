package com.example.SecureChatApp.entities;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "messages")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;
    private String sender;
    private String receiverId;
    private LocalDateTime timeStamp;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;
}