# 🔔 Avtomatik Bildirishnoma Tizimi

## ✅ **Qo'shilgan funksiyalar:**

### 📅 **6 Oylik Yubiley Xabarlari**
- **Vaqt:** Har kuni soat 09:00
- **Shart:** Foydalanuvchi 6 oy oldin ro'yxatdan o'tgan bo'lsa
- **Xabar mazmuni:**
  - Ism va familiya
  - **Telegram username (@username)** ✨ YANGI
  - Telefon raqam
  - Tug'ilgan sana
  - Ro'yxatdan o'tgan sana
  - Telegram ID

### 🎂 **Tug'ilgan Kun Xabarlari**
- **Vaqt:** Har kuni soat 10:00
- **Shart:** Bugun foydalanuvchining tug'ilgan kuni
- **Xabar mazmuni:**
  - Ism va familiya
  - **Telegram username (@username)** ✨ YANGI
  - Telefon raqam
  - Tug'ilgan sana
  - Ro'yxatdan o'tgan sana
  - Telegram ID

## 🎯 **Xabar yuborilish manzili:**
- **Admin Telegram ID:** 1807166165 (@IbodullaR)

## 🛠️ **Texnik tafsilotlar:**

### **Database yangilanishi:**
```sql
ALTER TABLE users ADD COLUMN telegram_username VARCHAR(255);
```

### **Yangi funksiyalar:**
- `NotificationService` - avtomatik xabar yuborish
- `@Scheduled` - vaqt bo'yicha ishga tushish
- Username avtomatik saqlash va yangilash
- Circular dependency hal qilish

### **Scheduler vaqtlari:**
- **6 oylik yubiley:** `@Scheduled(cron = "0 0 9 * * *")` - har kuni 09:00
- **Tug'ilgan kunlar:** `@Scheduled(cron = "0 0 10 * * *")` - har kuni 10:00

## 🧪 **Test qilish:**

### **Bot orqali:**
```
/testnotify - Admin uchun test xabar yuborish
```

### **Admin panel orqali:**
- http://localhost:8080/admin.html
- "📧 Test xabar yuborish" tugmasi

### **Manual test:**
```java
notificationService.testNotifications();
```

## 📱 **Xabar namunasi:**

### **6 Oylik Yubiley:**
```
🎉 6 Oylik Yubiley!

👤 Foydalanuvchi: Ibodulla Rahmonov
👤 Username: @IbodullaR
📱 Telefon: +998901234567
🎂 Tug'ilgan sana: 15.03.1995
📅 Ro'yxatdan o'tgan: 2025-07-30
🆔 Telegram ID: 1807166165

Bu foydalanuvchi 6 oy oldin botga ro'yxatdan o'tgan!
```

### **Tug'ilgan Kun:**
```
🎂 Tug'ilgan Kun!

👤 Foydalanuvchi: Ibodulla Rahmonov
👤 Username: @IbodullaR
📱 Telefon: +998901234567
🎂 Tug'ilgan sana: 15.03.1995
📅 Ro'yxatdan o'tgan: 2025-07-30
🆔 Telegram ID: 1807166165

Bugun bu foydalanuvchining tug'ilgan kuni!
```

## 🔧 **Sozlamalar:**

### **application.properties:**
```properties
admin.telegram.ids=1807166165
```

### **Spring Boot:**
```java
@EnableScheduling // KuponApplication.java da
```

## ✅ **Natija:**

Endi bot avtomatik ravishda:
1. **Har kuni soat 09:00** da 6 oy oldin ro'yxatdan o'tgan foydalanuvchilar haqida xabar yuboradi
2. **Har kuni soat 10:00** da tug'ilgan kuni bo'lgan foydalanuvchilar haqida xabar yuboradi
3. Barcha xabarlarda **Telegram username (@username)** ham ko'rsatiladi
4. Xabarlar **@IbodullaR** ga yuboriladi

Tizim 24/7 ishlaydi va hech qanday qo'shimcha aralashuv talab qilmaydi! 🚀