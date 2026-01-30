package uz.kuponbot.kupon.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(unique = true, nullable = false)
    private Long telegramId;
    
    @Column(nullable = true)
    private String telegramUsername; // @username
    
    @Column(nullable = true)
    private String phoneNumber;
    
    private String firstName;
    
    private String lastName;
    
    private String birthDate; // Format: DD.MM.YYYY
    
    @Enumerated(EnumType.STRING)
    private UserState state = UserState.START;
    
    private LocalDateTime createdAt = LocalDateTime.now();
    
    private LocalDateTime updatedAt = LocalDateTime.now();
    
    public enum UserState {
        START,
        WAITING_CONTACT,
        WAITING_FIRST_NAME,
        WAITING_LAST_NAME,
        WAITING_BIRTH_DATE,
        WAITING_CHANNEL_SUBSCRIPTION,
        REGISTERED
    }
}