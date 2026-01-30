# ⚡ Tezkor Yechim - Database URL Sozlash

## 🎯 **Sizning DATABASE_URL:**
```
postgresql://postgres:OsCmDtHxGoEskfWkAjEFTYJXAUgpoDvV@postgres.railway.internal:5432/railway
```

---

## 📋 **ANIQ QADAMLAR:**

### **1. Railway'ga kiring:**
- **https://railway.app** ga o'ting
- Bot loyihasini oching (kupon-bot)

### **2. Variables sozlash:**
- **"Variables"** tab'ni bosing
- Quyidagi barcha variables'ni qo'shing/tekshiring:

```
SPRING_PROFILES_ACTIVE
```
**Qiymati:** `prod`

```
DATABASE_URL
```
**Qiymati:** `postgresql://postgres:OsCmDtHxGoEskfWkAjEFTYJXAUgpoDvV@postgres.railway.internal:5432/railway`

```
TELEGRAM_BOT_TOKEN
```
**Qiymati:** `8567911447:AAGGOpjupFR9NyEsWmgHer9PFrnwb0n9q3E`

```
TELEGRAM_BOT_USERNAME
```
**Qiymati:** `kuponnnnnbot`

```
TELEGRAM_CHANNEL_USERNAME
```
**Qiymati:** `@fqfsafawfasf`

```
TELEGRAM_CHANNEL_ID
```
**Qiymati:** `-1003820141567`

### **3. Saqlash va Deploy:**
- Variables'ni saqlang
- Railway avtomatik redeploy qiladi
- **"Deployments"** tab'da jarayonni kuzating

### **4. Logs tekshirish:**
- **"View Logs"** tugmasini bosing
- Quyidagi xabarni kutish:
```
Started KuponApplication in X.XXX seconds
```

---

## ✅ **Muvaffaqiyat belgilari:**

**Logs'da ko'rinishi kerak:**
```
✅ HikariPool-1 - Start completed
✅ Hibernate: create table if not exists users
✅ Started KuponApplication
```

**Ko'rinmasligi kerak:**
```
❌ Connection to localhost:5432 refused
❌ Connection refused
```

---

## 🚀 **Keyingi qadamlar:**

### **1. Bot tekshirish:**
- Telegram'da `@kuponnnnnbot` ga `/start` yuboring

### **2. Admin panel:**
- `https://SIZNING-RAILWAY-URL.up.railway.app/admin.html`

### **3. Webhook sozlash:**
```
https://api.telegram.org/bot8567911447:AAGGOpjupFR9NyEsWmgHer9PFrnwb0n9q3E/setWebhook?url=https://SIZNING-RAILWAY-URL.up.railway.app/webhook
```

---

## 🎉 **Natija:**
Bu sozlamalardan keyin botingiz:
- ✅ 24/7 ishlaydi
- ✅ Database'ga ulanadi
- ✅ Foydalanuvchilarni ro'yxatga oladi
- ✅ Notification'lar yuboradi

**Omad!** 🚀