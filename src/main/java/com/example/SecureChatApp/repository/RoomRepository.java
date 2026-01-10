package com.example.SecureChatApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.SecureChatApp.entities.Room;

public interface RoomRepository extends JpaRepository<Room, String> { 
    // Changed Long to String ^ here
    Room findByRoomId(String roomId);
}