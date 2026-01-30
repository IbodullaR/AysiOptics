# 🚨 Database Ulanish Muammosi va Yechimi

## ❌ **Muammo nima?**
Sizning botingiz hali ham `localhost:5432` ga ulanishga harakat qilmoqda, lekin Railway'da database boshqa manzilda joylashgan.

**Xato sababi:**
```
Connection to localhost:5432 refused
```

---

## ✅ **YECHIM - Qadamlar**

### **QADAM 1: Railway'da Database URL'ni topish**

**A) Railway dashboard'ga o'ting:**
1. **https://railway.app** ga kiring
2. PostgreSQL service'ni oching
3. **"Variables"** tab'ni bosing

**B) DATABASE_URL'ni nusxalang:**
```
DATABASE_URL=postgresql://postgres:password@hostname:5432/database
```
Bu URL'ni to'liq nusxalab oling!

### **QADAM 2: Bot Service'da Environment Variables tekshirish**

**A) Bot service'ni oching:**
1. Railway'da bot loyihasini oching (kupon-bot)
2. **"Variables"** tab'ni bosing

**B) Quyidagi o'zgaruvchilar borligini tekshiring:**

```
SPRING_PROFILES_ACTIVE = prod
DATABASE_URL = postgresql://postgres:password@hostname:5432/database
TELEGRAM_BOT_TOKEN = 8567911447:AAGGOpjupFR9NyEsWmgHer9PFrnwb0n9q3E
TELEGRAM_BOT_USERNAME = kuponnnnnbot
TELEGRAM_CHANNEL_USERNAME = @fqfsafawfasf
TELEGRAM_CHANNEL_ID = -1003820141567
```

### **QADAM 3: DATABASE_URL'ni to'g'ri sozlash**

**A) Agar DATABASE_URL yo'q bo'lsa:**
1. **"New Variable"** tugmasini bosing
2. **Name:** `DATABASE_URL`
3. **Value:** PostgreSQL service'dan olingan to'liq URL'ni kiriting

**B) Agar DATABASE_URL noto'g'ri bo'lsa:**
1. DATABASE_URL'ni oching
2. **"Edit"** tugmasini bosing
3. To'g'ri URL'ni kiriting

### **QADAM 4: Service Reference ishlatish (Eng oson usul)**

**A) DATABASE_URL o'rniga:**
```
DATABASE_URL = ${{Postgres.DATABASE_URL}}
```

Bu Railway avtomatik ravishda PostgreSQL service'dan URL'ni oladi.

### **QADAM 5: Redeploy qilish**

**A) O'zgarishlarni saqlash:**
1. Variables'ni saqlang
2. **"Deployments"** tab'ga o'ting
3. **"Redeploy"** tugmasini bosing

**B) Yoki avtomatik:**
Variables o'zgarganda Railway avtomatik redeploy qiladi.

---

## 🔍 **Tekshirish**

### **Logs'ni kuzatish:**
1. **"Deployments"** tab'da
2. **"View Logs"** tugmasini bosing
3. Quyidagi xabarni kutish:
```
Started KuponApplication in X.XXX seconds
```

### **Database ulanish muvaffaqiyatli bo'lsa:**
```
HikariPool-1 - Start completed
Hibernate: create table if not exists users...
```

---

## 🛠️ **Agar hali ham ishlamasa**

### **1. PostgreSQL service tekshirish:**
- PostgreSQL service ishlab turganini tekshiring
- Status "Running" bo'lishi kerak

### **2. Variables'ni qayta tekshirish:**
```
SPRING_PROFILES_ACTIVE = prod  ✅
DATABASE_URL = to'liq PostgreSQL URL  ✅
```

### **3. Manual URL yaratish:**
Agar service reference ishlamasa, manual URL yarating:
```
postgresql://username:password@hostname:port/database
```

PostgreSQL Variables'dan:
- username = PGUSER
- password = PGPASSWORD  
- hostname = PGHOST
- port = PGPORT
- database = PGDATABASE

---

## 📋 **To'liq Variables ro'yxati**

Railway bot service'da bo'lishi kerak:

```
SPRING_PROFILES_ACTIVE=prod
DATABASE_URL=${{Postgres.DATABASE_URL}}
TELEGRAM_BOT_TOKEN=8567911447:AAGGOpjupFR9NyEsWmgHer9PFrnwb0n9q3E
TELEGRAM_BOT_USERNAME=kuponnnnnbot
TELEGRAM_CHANNEL_USERNAME=@fqfsafawfasf
TELEGRAM_CHANNEL_ID=-1003820141567
```

---

## 🎯 **Qisqa yechim:**

1. **Railway'ga kiring**
2. **Bot service → Variables**
3. **DATABASE_URL = ${{Postgres.DATABASE_URL}}** qo'shing
4. **Redeploy qiling**
5. **Logs'ni kuzating**

**Bu muammoni 100% hal qiladi!** 🚀