package com.example.SecureChatApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.SecureChatApp.entities.Room;

// Changed String to Long to match Room.java @Id
public interface RoomRepository extends JpaRepository<Room, Long> {
    Room findByRoomId(String roomId);
}