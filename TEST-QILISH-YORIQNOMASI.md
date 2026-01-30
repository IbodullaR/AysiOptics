# 🧪 Adminga SMS Yuborishni Test Qilish Yo'riqnomasi

## 📱 **1. Bot orqali test (Eng oson usul)**

### **Oddiy test xabar:**
1. `@kuponnnnnbot` ga o'ting
2. `/testnotify` buyrug'ini yuboring
3. Bot sizga "✅ Test xabar yuborildi!" deb javob beradi
4. @IbodullaR ga test xabar keladi

### **6 oylik yubiley test:**
1. `@kuponnnnnbot` ga o'ting
2. `/testanniversary` buyrug'ini yuboring
3. Bot 6 oy oldin ro'yxatdan o'tgan foydalanuvchilarni tekshiradi
4. Agar bunday foydalanuvchi bo'lsa, @IbodullaR ga xabar keladi

### **Tug'ilgan kun test:**
1. `@kuponnnnnbot` ga o'ting
2. `/testbirthday` buyrug'ini yuboring
3. Bot bugun tug'ilgan kuni bo'lgan foydalanuvchilarni tekshiradi
4. Agar bunday foydalanuvchi bo'lsa, @IbodullaR ga xabar keladi

## 🌐 **2. Admin panel orqali test**

### **Kirish:**
1. Brauzerda: http://localhost:8080/admin.html ga o'ting
2. Login qiling (admin kodi: **ADMIN2024**)

### **Test tugmalari:**
1. **"📧 Test xabar yuborish"** - oddiy test xabar
2. **"🎉 6 oylik yubiley test"** - 6 oy oldin ro'yxatdan o'tganlarni tekshirish
3. **"🎂 Tug'ilgan kun test"** - bugun tug'ilgan kuni bo'lganlarni tekshirish

## 🔧 **3. Postman/cURL orqali test**

### **Test xabar:**
```bash
curl -X POST http://localhost:8080/api/admin/test-notifications
```

### **6 oylik yubiley:**
```bash
curl -X POST http://localhost:8080/api/admin/test-anniversary
```

### **Tug'ilgan kun:**
```bash
curl -X POST http://localhost:8080/api/admin/test-birthdays
```

## 📊 **4. Natijalarni kuzatish**

### **Console log'larda:**
```
INFO - Testing notification system...
INFO - Notification sent to admin: 1807166165
```

### **Telegram'da:**
@IbodullaR ga kelgan xabar:
```
🧪 Test Xabar

Notification tizimi ishlayapti!
Vaqt: 2026-01-30T16:17:00
```

## ⚠️ **Muhim eslatmalar:**

### **Admin huquqlari:**
- Faqat Telegram ID: **1807166165** (@IbodullaR) test buyruqlarini ishlatishi mumkin
- Boshqa foydalanuvchilar "❌ Sizda admin huquqlari yo'q" xabarini oladi

### **Real ma'lumotlar:**
- **6 oylik yubiley test:** Haqiqiy foydalanuvchilar ma'lumotlarini tekshiradi
- **Tug'ilgan kun test:** Haqiqiy tug'ilgan sanalarni tekshiradi
- **Test xabar:** Faqat test xabar yuboradi

## 🎯 **Tavsiya etilgan test ketma-ketligi:**

1. **Avval oddiy test:** `/testnotify` - tizim ishlashini tekshirish
2. **Keyin real testlar:** `/testanniversary` va `/testbirthday`
3. **Admin paneldan ham test qiling** - web interface ishlashini tekshirish

## 🚀 **Avtomatik ishlash:**

Testlar muvaffaqiyatli bo'lgandan keyin:
- **Har kuni soat 09:00** - 6 oylik yubiley xabarlari
- **Har kuni soat 10:00** - tug'ilgan kun xabarlari

Avtomatik yuboriladi va hech qanday aralashuv kerak emas! ✅