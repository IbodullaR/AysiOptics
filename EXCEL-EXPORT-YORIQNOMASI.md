# 📊 Excel Export Funksiyasi

## ✅ **Qo'shilgan funksiya:**

### **📥 Foydalanuvchilar ro'yxatini Excel fayl qilib yuklab olish**

## 🌐 **Qanday ishlatish:**

### **1. Admin panelga kirish:**
1. **URL:** http://localhost:8080/admin.html
2. **Login kodi:** ADMIN2024

### **2. Excel yuklab olish:**
1. **"👥 Foydalanuvchilar"** bo'limiga o'ting
2. **"📊 Excel yuklab olish"** tugmasini bosing
3. **"foydalanuvchilar.xlsx"** fayli avtomatik yuklab olinadi

## 📋 **Excel fayldagi ustunlar:**

| Ustun | Ma'lumot | Misol |
|-------|----------|-------|
| **ID** | Telegram ID | 1807166165 |
| **Ism** | Foydalanuvchi ismi | Ibodulla |
| **Familiya** | Foydalanuvchi familiyasi | Rahmonov |
| **Username** | Telegram username | @IbodullaR |
| **Telefon** | Telefon raqam | +998901234567 |
| **Tug'ilgan kun** | Tug'ilgan sana | 15.03.1995 |
| **Holat** | Ro'yxatdan o'tish holati | Ro'yxatdan o'tgan |
| **Ro'yxatdan o'tgan** | Ro'yxatdan o'tgan sana | 30.01.2026 |
| **Jami kuponlar** | Jami kuponlar soni | 5 |
| **Faol kuponlar** | Faol kuponlar soni | 3 |

## 🎨 **Excel fayl xususiyatlari:**

### **Dizayn:**
- **Sarlavha qatori:** Ko'k rangda, qalin shrift
- **Ma'lumotlar:** Chegaralar bilan ajratilgan
- **Avtomatik kenglik:** Barcha ustunlar ma'lumotga mos ravishda kengaytirilgan

### **Holatlar tarjimasi:**
- `START` → "Boshlangan"
- `WAITING_CONTACT` → "Telefon kutilmoqda"
- `WAITING_FIRST_NAME` → "Ism kutilmoqda"
- `WAITING_LAST_NAME` → "Familiya kutilmoqda"
- `WAITING_BIRTH_DATE` → "Tug'ilgan sana kutilmoqda"
- `WAITING_CHANNEL_SUBSCRIPTION` → "Kanal obunasi kutilmoqda"
- `REGISTERED` → "Ro'yxatdan o'tgan"

### **Bo'sh qiymatlar:**
- **Username yo'q:** "Username yo'q"
- **Tug'ilgan kun kiritilmagan:** "Kiritilmagan"
- **Boshqa bo'sh qiymatlar:** "-"

## 🔧 **Texnik tafsilotlar:**

### **Backend:**
- **Apache POI** kutubxonasi ishlatilgan
- **ExcelExportService** - Excel yaratish xizmati
- **AdminController** - `/api/admin/export-users` endpoint

### **Frontend:**
- **JavaScript** - fayl yuklab olish funksiyasi
- **Blob API** - fayl yuklab olish uchun
- **Avtomatik yuklab olish** - brauzer orqali

## 📱 **Foydalanish misoli:**

1. Admin panelga kiring
2. "📊 Excel yuklab olish" tugmasini bosing
3. Fayl avtomatik yuklab olinadi
4. Excel'da oching va ma'lumotlarni ko'ring

## ⚡ **Tezlik:**
- **Kichik ma'lumotlar** (100 foydalanuvchi): ~1 soniya
- **O'rta ma'lumotlar** (1000 foydalanuvchi): ~3 soniya
- **Katta ma'lumotlar** (10000+ foydalanuvchi): ~10 soniya

## 🎯 **Foyda:**

### **Admin uchun:**
- Barcha foydalanuvchi ma'lumotlarini bir faylda olish
- Excel'da qo'shimcha tahlil qilish imkoniyati
- Ma'lumotlarni boshqa tizimlarga import qilish
- Backup sifatida saqlash

### **Hisobot uchun:**
- Statistik tahlillar
- Grafik va diagrammalar yaratish
- Ma'lumotlarni filtrlash va saralash
- Print qilish imkoniyati

Excel fayl to'liq formatda va professional ko'rinishda yaratiladi! 📊✨