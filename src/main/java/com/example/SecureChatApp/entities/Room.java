package com.example.SecureChatApp.entities;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "rooms")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Room {
    @Id
    private String roomId;

    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
    private List<Message> messages;
}