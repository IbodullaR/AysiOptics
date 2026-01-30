# 📊 Filter va Excel Export Funksiyasi - Yo'riqnoma

## ✅ YANGI FUNKSIYALAR QO'SHILDI

### 🎯 Nima Qo'shildi:
Admin panelga foydalanuvchilarni filter qilib ko'rish va Excel shaklida yuklab olish imkoniyati qo'shildi.

### 📋 Filter Turlari:

#### 1. **📊 Barcha Foydalanuvchilar**
- Barcha ro'yxatdan o'tgan foydalanuvchilarni ko'rsatadi
- Excel fayl nomi: `foydalanuvchilar.xlsx`

#### 2. **📅 Bugungi Foydalanuvchilar** 
- Bugun ro'yxatdan o'tgan foydalanuvchilarni ko'rsatadi
- Excel fayl nomi: `bugungi-foydalanuvchilar.xlsx`

#### 3. **📆 Oylik Foydalanuvchilar**
- Joriy oyda ro'yxatdan o'tgan foydalanuvchilarni ko'rsatadi  
- Excel fayl nomi: `oylik-foydalanuvchilar.xlsx`

#### 4. **📈 Yillik Foydalanuvchilar**
- Joriy yilda ro'yxatdan o'tgan foydalanuvchilarni ko'rsatadi
- Excel fayl nomi: `yillik-foydalanuvchilar.xlsx`

### 🖥️ Admin Panel Interfeysi:

#### Excel Yuklab Olish Tugmalari:
```
📊 Barcha foydalanuvchilar    📅 Bugungi foydalanuvchilar
📆 Oylik foydalanuvchilar     📈 Yillik foydalanuvchilar
```

#### Ko'rish Tugmalari:
```
👁️ Barchasini ko'rish        👁️ Bugungilarni ko'rish  
👁️ Oyliklarni ko'rish        👁️ Yilliklarni ko'rish
```

### 🔧 Texnik Tafsilotlar:

#### Backend Endpointlar:
1. **GET** `/api/admin/export-users` - Barcha foydalanuvchilar Excel
2. **GET** `/api/admin/export-users-filtered?filter={filter}` - Filterlangan Excel
3. **GET** `/api/admin/users` - Barcha foydalanuvchilar JSON
4. **GET** `/api/admin/users-filtered?filter={filter}` - Filterlangan JSON

#### Filter Parametrlari:
- `all` - Barcha foydalanuvchilar
- `today` - Bugungi foydalanuvchilar
- `this_month` - Oylik foydalanuvchilar  
- `this_year` - Yillik foydalanuvchilar

#### Database Query:
```java
// UserRepository.java
List<User> findByCreatedAtBetween(LocalDateTime startDate, LocalDateTime endDate);

// UserService.java
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
            return getAllUsers();
    }
    
    return userRepository.findByCreatedAtBetween(startDate, endDate);
}
```

### 📱 Foydalanish:

#### 1. Excel Yuklab Olish:
1. Admin panelga kiring: http://localhost:8080/admin.html
2. "Foydalanuvchilar" bo'limiga o'ting
3. Kerakli filter tugmasini bosing:
   - 📊 Barcha foydalanuvchilar
   - 📅 Bugungi foydalanuvchilar  
   - 📆 Oylik foydalanuvchilar
   - 📈 Yillik foydalanuvchilar
4. Excel fayl avtomatik yuklab olinadi

#### 2. Foydalanuvchilarni Ko'rish:
1. "Ko'rish" tugmalaridan birini bosing
2. Jadval yangilanadi va filter qo'llaniladi
3. Sarlavhada filter nomi va soni ko'rsatiladi

### 📊 Excel Fayl Tarkibi:
- **ID** - Telegram ID
- **Ism** - Foydalanuvchi ismi
- **Familiya** - Foydalanuvchi familiyasi
- **Username** - Telegram username (@bilan)
- **Telefon** - Telefon raqami
- **Tug'ilgan kun** - Tug'ilgan sanasi (DD.MM.YYYY)
- **Holat** - Ro'yxatdan o'tish holati
- **Ro'yxatdan o'tgan** - Ro'yxatdan o'tgan sanasi

### 🎉 Afzalliklar:
- ✅ Tez va oson filter qilish
- ✅ Turli vaqt oraliqlarida statistika
- ✅ Professional Excel formatda export
- ✅ Avtomatik fayl nomlash
- ✅ Real-time ma'lumotlar
- ✅ Responsive interfeys

### 🔄 Yangilanish:
Admin panel sahifasini yangilab, yangi tugmalar va funksiyalardan foydalaning!