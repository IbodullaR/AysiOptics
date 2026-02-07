package uz.kuponbot.kupon.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CashbackDto {
    private Long id;
    private Long userId;
    private Long telegramId;
    private String fullName;
    private String phoneNumber;
    private Integer purchaseAmount;
    private Integer cashbackAmount;
    private Double cashbackPercentage;
    private String type;
    private String status;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime usedAt;
}
