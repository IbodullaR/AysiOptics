package uz.kuponbot.kupon.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cashbacks")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cashback {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    
    @Column(nullable = false)
    private Integer purchaseAmount; // Harid miqdori (so'm)
    
    @Column(nullable = false)
    private Integer cashbackAmount; // Keshbek miqdori (so'm)
    
    @Column(nullable = false)
    private Double cashbackPercentage; // Keshbek foizi (5%)
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CashbackType type;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CashbackStatus status;
    
    @Column(length = 500)
    private String description; // Izoh
    
    @Column(nullable = false)
    private LocalDateTime createdAt;
    
    private LocalDateTime usedAt; // Ishlatilgan vaqt
    
    public enum CashbackType {
        EARNED,    // Harid orqali olingan
        USED,      // Ishlatilgan
        REFUNDED   // Qaytarilgan
    }
    
    public enum CashbackStatus {
        ACTIVE,    // Faol
        USED,      // Ishlatilgan
        EXPIRED    // Muddati o'tgan
    }
}
