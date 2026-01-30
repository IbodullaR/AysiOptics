package uz.kuponbot.kupon.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import uz.kuponbot.kupon.entity.User;
import uz.kuponbot.kupon.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService {
    
    private final UserRepository userRepository;
    
    public Optional<User> findByTelegramId(Long telegramId) {
        return userRepository.findByTelegramId(telegramId);
    }
    
    public User save(User user) {
        user.setUpdatedAt(LocalDateTime.now());
        return userRepository.save(user);
    }
    
    public User createUser(Long telegramId) {
        User user = new User();
        user.setTelegramId(telegramId);
        user.setState(User.UserState.WAITING_CONTACT);
        return save(user);
    }
    
    public boolean existsByTelegramId(Long telegramId) {
        return userRepository.existsByTelegramId(telegramId);
    }
    
    public List<User> getAllUsers() {
        // Admin ID'larini belgilash
        List<Long> adminIds = List.of(1807166165L, 7543576887L);
        
        // Barcha userlarni olish va adminlarni chiqarib tashlash
        return userRepository.findAll().stream()
            .filter(user -> !adminIds.contains(user.getTelegramId()))
            .collect(Collectors.toList());
    }
    
    public long getTotalUsersCount() {
        // Admin ID'larini belgilash
        List<Long> adminIds = List.of(1807166165L, 7543576887L);
        
        // Barcha userlarni sanash va adminlarni chiqarib tashlash
        return userRepository.findAll().stream()
            .filter(user -> !adminIds.contains(user.getTelegramId()))
            .count();
    }
    
    public List<User> getUsersByDateFilter(String filter) {
        LocalDateTime startDate;
        LocalDateTime endDate = LocalDateTime.now();
        
        switch (filter) {
            case "today":
                startDate = LocalDate.now().atStartOfDay();
                break;
            case "this_month":
                startDate = LocalDate.now().withDayOfMonth(1).atStartOfDay();
                break;
            case "this_year":
                startDate = LocalDate.now().withDayOfYear(1).atStartOfDay();
                break;
            default:
                return getAllUsers(); // Bu allaqachon adminlarsiz
        }
        
        // Admin ID'larini belgilash
        List<Long> adminIds = List.of(1807166165L, 7543576887L);
        
        // Filterlangan userlarni olish va adminlarni chiqarib tashlash
        return userRepository.findByCreatedAtBetween(startDate, endDate).stream()
            .filter(user -> !adminIds.contains(user.getTelegramId()))
            .collect(Collectors.toList());
    }
}