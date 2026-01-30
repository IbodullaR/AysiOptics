# 🚀 Railway'ga Spring Boot Loyihani Deploy Qilish (0 dan)

## 📋 **1. Railway Account Yaratish**

### **1.1 Railway.app ga kirish:**
1. **https://railway.app** ga o'ting
2. **"Start a New Project"** tugmasini bosing
3. **GitHub** orqali ro'yxatdan o'ting

### **1.2 GitHub Repository tayyorlash:**
1. **GitHub.com** ga o'ting
2. **New Repository** yarating
3. **Repository nomi:** `kupon-bot` (yoki boshqa nom)
4. **Public** yoki **Private** tanlang
5. **Create repository** bosing

## 📁 **2. Loyihani GitHub'ga yuklash**

### **2.1 Git initialize qilish:**
```bash
cd C:\BOTK\bott-master
git init
git add .
git commit -m "Initial commit - Kupon Bot"
```

### **2.2 GitHub'ga push qilish:**
```bash
git remote add origin https://github.com/[USERNAME]/kupon-bot.git
git branch -M main
git push -u origin main
```

## ⚙️ **3. Production konfiguratsiya**

### **3.1 Production properties yaratish:**
`src/main/resources/application-prod.properties` fayli allaqachon mavjud va to'g'ri sozlangan.

### **3.2 Dockerfile yaratish (ixtiyoriy):**
Railway avtomatik Java loyihalarni aniqlaydi, lekin Dockerfile ham yaratishingiz mumkin:

```dockerfile
FROM openjdk:21-jdk-slim

WORKDIR /app

COPY target/*.jar app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar", "--spring.profiles.active=prod"]
```

## 🗄️ **4. Railway'da PostgreSQL Database yaratish**

### **4.1 Database Service qo'shish:**
1. Railway dashboard'da **"New"** tugmasini bosing
2. **"Database"** ni tanlang
3. **"PostgreSQL"** ni tanlang
4. Database yaratilishini kuting

### **4.2 Database ma'lumotlarini olish:**
1. PostgreSQL service'ni oching
2. **"Variables"** tab'ga o'ting
3. Quyidagi ma'lumotlarni ko'ring:
   - `DATABASE_URL`
   - `PGDATABASE`
   - `PGHOST`
   - `PGPASSWORD`
   - `PGPORT`
   - `PGUSER`

## 🚀 **5. Spring Boot loyihani deploy qilish**

### **5.1 GitHub Repository'ni ulash:**
1. Railway dashboard'da **"New"** tugmasini bosing
2. **"Deploy from GitHub repo"** ni tanlang
3. GitHub repository'ni tanlang (`kupon-bot`)
4. **"Deploy Now"** tugmasini bosing

### **5.2 Environment Variables sozlash:**
Railway loyiha yaratilgandan keyin:

1. **"Variables"** tab'ga o'ting
2. Quyidagi o'zgaruvchilarni qo'shing:

```
SPRING_PROFILES_ACTIVE=prod
TELEGRAM_BOT_TOKEN=8567911447:AAGGOpjupFR9NyEsWmgHer9PFrnwb0n9q3E
TELEGRAM_BOT_USERNAME=kuponnnnnbot
TELEGRAM_CHANNEL_USERNAME=@fqfsafawfasf
TELEGRAM_CHANNEL_ID=-1003820141567
DATABASE_URL=${{Postgres.DATABASE_URL}}
```

**Muhim:** `DATABASE_URL` qiymatini PostgreSQL service'dan oling.

### **5.3 Build va Deploy:**
1. Railway avtomatik build qiladi
2. **"Deployments"** tab'da jarayonni kuzating
3. Build muvaffaqiyatli bo'lsa, loyiha ishga tushadi

## 🔗 **6. Domain va URL sozlash**

### **6.1 Public URL olish:**
1. **"Settings"** tab'ga o'ting
2. **"Networking"** bo'limida
3. **"Generate Domain"** tugmasini bosing
4. URL paydo bo'ladi: `https://kupon-bot-production.up.railway.app`

### **6.2 Custom Domain (ixtiyoriy):**
1. **"Custom Domain"** qo'shing
2. DNS sozlamalarini yangilang

## 🔧 **7. Database jadvallarini yaratish**

### **7.1 Railway Console orqali:**
1. PostgreSQL service'ni oching
2. **"Query"** tab'ga o'ting
3. `create-tables.sql` faylidan SQL kodlarni nusxalang va ishga tushiring

### **7.2 Yoki loyiha orqali avtomatik:**
`application-prod.properties` da `spring.jpa.hibernate.ddl-auto=update` sozlangan, shuning uchun jadvallar avtomatik yaratiladi.

## 📊 **8. Monitoring va Logs**

### **8.1 Logs ko'rish:**
1. Railway loyiha dashboard'da
2. **"Deployments"** tab'ga o'ting
3. **"View Logs"** tugmasini bosing

### **8.2 Health Check:**
Loyiha URL'iga `/actuator/health` qo'shing:
```
https://kupon-bot-production.up.railway.app/actuator/health
```

## 🛠️ **9. Troubleshooting**

### **9.1 Keng tarqalgan muammolar:**

**Build xatosi:**
```bash
# Java versiyasini tekshiring
java.version=21
```

**Database ulanish xatosi:**
- `DATABASE_URL` to'g'ri sozlanganini tekshiring
- PostgreSQL service ishlab turganini tekshiring

**Bot ishlamayapti:**
- `TELEGRAM_BOT_TOKEN` to'g'ri ekanini tekshiring
- Webhook sozlamalarini tekshiring

### **9.2 Webhook sozlash:**
Bot ishga tushgandan keyin Telegram webhook'ni yangilang:
```
https://api.telegram.org/bot8567911447:AAGGOpjupFR9NyEsWmgHer9PFrnwb0n9q3E/setWebhook?url=https://kupon-bot-production.up.railway.app/webhook
```

## ✅ **10. Yakuniy tekshiruv**

### **10.1 Bot ishlashini tekshirish:**
1. Telegram'da botni toping: `@kuponnnnnbot`
2. `/start` buyrug'ini yuboring
3. Ro'yxatdan o'tish jarayonini tekshiring

### **10.2 Admin panel:**
```
https://kupon-bot-production.up.railway.app/admin.html
```

### **10.3 Notification tizimi:**
- 3 daqiqalik test notification
- Tug'ilgan kun notification'lari
- 6 oylik notification'lar

## 💰 **11. Narxlar va Limitlar**

### **11.1 Railway narxlari:**
- **Hobby Plan:** $5/oy (500 soat execution time)
- **Pro Plan:** $20/oy (unlimited)

### **11.2 Database:**
- PostgreSQL: $5/oy (1GB storage)
- Backup'lar avtomatik

## 🔄 **12. Yangilanishlar**

### **12.1 Kod yangilash:**
```bash
git add .
git commit -m "Update: yangi funksiya"
git push origin main
```

Railway avtomatik yangi deploy qiladi.

### **12.2 Environment Variables yangilash:**
Railway dashboard'da **"Variables"** tab'dan yangilang.

---

## 📞 **Yordam**

Muammo bo'lsa:
1. Railway logs'ni tekshiring
2. Database connection'ni tekshiring  
3. Environment variables'ni tekshiring
4. Telegram webhook'ni yangilang

**Muvaffaqiyatli deploy!** 🎉