package uz.kuponbot.kupon.dto;

import java.time.LocalDateTime;

public record UserDto(
    Long id,
    Long telegramId,
    String firstName,
    String lastName,
    String telegramUsername,
    String phoneNumber,
    String birthDate,
    String state,
    LocalDateTime createdAt,
    long totalCoupons,
    long activeCoupons
) {
}