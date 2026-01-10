A real-time, end-to-end secure chat application built with Spring Boot, WebSocket (STOMP), and RSA Encryption. 
This application features a military-style terminal interface for private messaging between authenticated agents.

 1)Features
Tactical ID Generation: Randomized 6-character Military IDs for every recruit.

Real-time Messaging: Instant private communication using WebSocket and SockJS.

Secure Authentication: Custom Spring Security implementation with BCrypt password hashing.

Encrypted Foundation: RSA KeyPair generation for every user (Ready for E2EE content encryption).

Persistent Storage: MySQL integration for user profiles and message history.

Terminal UI: Immersive 'Matrix/Fallout' style green-on-black terminal interface.

2) Tech Stack
Backend: Java 21, Spring Boot 3.5.9

Database: MySQL

Security: Spring Security, JWT (API), RSA

Frontend: Thymeleaf, CSS3, Vanilla JS

Communication: Spring WebSocket, STOMP, SockJS
