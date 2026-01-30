package uz.kuponbot.kupon.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import uz.kuponbot.kupon.entity.User;

@Service
@RequiredArgsConstructor
@Slf4j
public class NotificationService {
    
    private final UserService userService;
    private final ApplicationContext applicationContext;
    
    @Value("${admin.telegram.ids}")
    private String adminTelegramIds;
    
    // Har daqiqada tekshirish (test uchun)
    @Scheduled(fixedRate = 60000) // 60 soniya = 1 daqiqa
    public void checkThreeMinuteRegistrations() {
        log.info("Checking 3-minute registrations...");
        
        LocalDateTime threeMinutesAgo = LocalDateTime.now().minusMinutes(3);
        List<User> allUsers = userService.getAllUsers();
        
        for (User user : allUsers) {
            if (user.getCreatedAt() != null && user.getState() == User.UserState.REGISTERED) {
                // 3 daqiqa oldin ro'yxatdan o'tgan foydalanuvchilarni topish
                if (user.getCreatedAt().isAfter(threeMinutesAgo.minusMinutes(1)) && 
                    user.getCreatedAt().isBefore(threeMinutesAgo.plusMinutes(1))) {
                    sendThreeMinuteRegistrationNotification(user);
                }
            }
        }
    }
    @Scheduled(cron = "0 0 9 * * *")
    public void checkRegistrationAnniversary() {
        log.info("Checking 6-month registration anniversaries...");
        
        LocalDate sixMonthsAgo = LocalDate.now().minusMonths(6);
        List<User> allUsers = userService.getAllUsers();
        
        for (User user : allUsers) {
            if (user.getCreatedAt() != null && user.getState() == User.UserState.REGISTERED) {
                LocalDate registrationDate = user.getCreatedAt().toLocalDate();
                
                // 6 oy to'lgan foydalanuvchilarni topish
                if (registrationDate.equals(sixMonthsAgo)) {
                    sendRegistrationAnniversaryNotification(user);
                }
            }
        }
    }
    
    // Har kuni soat 10:00 da tug'ilgan kunlarni tekshirish
    @Scheduled(cron = "0 0 10 * * *")
    public void checkBirthdays() {
        log.info("Checking user birthdays...");
        
        LocalDate today = LocalDate.now();
        List<User> allUsers = userService.getAllUsers();
        
        for (User user : allUsers) {
            if (user.getBirthDate() != null && user.getState() == User.UserState.REGISTERED) {
                try {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
                    LocalDate birthDate = LocalDate.parse(user.getBirthDate(), formatter);
                    
                    // Bugungi kun tug'ilgan kun bilan mos kelishini tekshirish (kun va oy)
                    if (birthDate.getDayOfMonth() == today.getDayOfMonth() && 
                        birthDate.getMonth() == today.getMonth()) {
                        sendBirthdayNotification(user);
                    }
                } catch (Exception e) {
                    log.error("Error parsing birth date for user {}: {}", user.getTelegramId(), e.getMessage());
                }
            }
        }
    }
    
    private void sendRegistrationAnniversaryNotification(User user) {
        String usernameInfo = user.getTelegramUsername() != null ? 
            user.getTelegramUsername() : "Username yo'q";
            
        String message = String.format(
            """
            🎉 6 Oylik Yubiley!
            
            👤 Foydalanuvchi: %s %s
            👤 Username: %s
            📱 Telefon: %s
            🎂 Tug'ilgan sana: %s
            📅 Ro'yxatdan o'tgan: %s
            🆔 Telegram ID: %d
            
            Bu foydalanuvchi 6 oy oldin botga ro'yxatdan o'tgan!
            """,
            user.getFirstName(),
            user.getLastName(),
            usernameInfo,
            user.getPhoneNumber(),
            user.getBirthDate(),
            user.getCreatedAt().toLocalDate(),
            user.getTelegramId()
        );
        
        sendNotificationToAdmin(message);
        log.info("Sent 6-month anniversary notification for user: {}", user.getTelegramId());
    }
    
    private void sendBirthdayNotification(User user) {
        String usernameInfo = user.getTelegramUsername() != null ? 
            user.getTelegramUsername() : "Username yo'q";
            
        String message = String.format(
            """
            🎂 Tug'ilgan Kun!
            
            👤 Foydalanuvchi: %s %s
            👤 Username: %s
            📱 Telefon: %s
            🎂 Tug'ilgan sana: %s
            📅 Ro'yxatdan o'tgan: %s
            🆔 Telegram ID: %d
            
            Bugun bu foydalanuvchining tug'ilgan kuni!
            """,
            user.getFirstName(),
            user.getLastName(),
            usernameInfo,
            user.getPhoneNumber(),
            user.getBirthDate(),
            user.getCreatedAt().toLocalDate(),
            user.getTelegramId()
        );
        
        sendNotificationToAdmin(message);
        log.info("Sent birthday notification for user: {}", user.getTelegramId());
    }
    
    private void sendNotificationToAdmin(String message) {
        String[] adminIds = adminTelegramIds.split(",");
        
        // ApplicationContext orqali KuponBot'ni olish (circular dependency'dan qochish uchun)
        TelegramLongPollingBot bot = applicationContext.getBean("kuponBot", TelegramLongPollingBot.class);
        
        for (String adminIdStr : adminIds) {
            try {
                Long adminId = Long.parseLong(adminIdStr.trim());
                
                SendMessage sendMessage = new SendMessage();
                sendMessage.setChatId(adminId);
                sendMessage.setText(message);
                
                bot.execute(sendMessage);
                log.info("Notification sent to admin: {}", adminId);
                
            } catch (NumberFormatException e) {
                log.error("Invalid admin ID format: {}", adminIdStr);
            } catch (TelegramApiException e) {
                log.error("Error sending notification to admin {}: {}", adminIdStr, e.getMessage());
            }
        }
    }
    
    // Manual test uchun
    public void testNotifications() {
        log.info("Testing notification system...");
        
        String testMessage = """
            🧪 Test Xabar
            
            Notification tizimi ishlayapti!
            Vaqt: %s
            """.formatted(LocalDateTime.now());
        
        sendNotificationToAdmin(testMessage);
    }
    
    private void sendThreeMinuteRegistrationNotification(User user) {
        String usernameInfo = user.getTelegramUsername() != null ? 
            user.getTelegramUsername() : "Username yo'q";
            
        String message = String.format(
            """
            🆕 3 Daqiqalik Test Notification!
            
            👤 Yangi foydalanuvchi: %s %s
            👤 Username: %s
            📱 Telefon: %s
            🎂 Tug'ilgan sana: %s
            📅 Ro'yxatdan o'tgan: %s
            🆔 Telegram ID: %d
            ⏰ 3 daqiqa oldin ro'yxatdan o'tdi!
            
            Bu test notification - haqiqiy tizimda 6 oy va tug'ilgan kunlar uchun ishlaydi.
            """,
            user.getFirstName(),
            user.getLastName(),
            usernameInfo,
            user.getPhoneNumber(),
            user.getBirthDate() != null ? user.getBirthDate() : "Kiritilmagan",
            user.getCreatedAt().format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm")),
            user.getTelegramId()
        );
        
        sendNotificationToAdmin(message);
        log.info("Sent 3-minute registration notification for user: {}", user.getTelegramId());
    }
    
    // 6 oylik yubiley test uchun
    public void testSixMonthAnniversary() {
        log.info("Testing 6-month anniversary notifications...");
        checkRegistrationAnniversary();
    }
    
    // Tug'ilgan kun test uchun  
    public void testBirthdays() {
        log.info("Testing birthday notifications...");
        checkBirthdays();
    }
    
    // Test 3 daqiqalik registration uchun
    public void testThreeMinuteRegistrations() {
        log.info("Testing 3-minute registration notifications...");
        checkThreeMinuteRegistrations();
    }
}