# 🚀 Railway'ga Bot Deploy Qilish - Juda Oddiy Qo'llanma

## ❓ Railway nima?
Railway - bu sizning botingizni internetga qo'yib, 24/7 ishlatish uchun xizmat. Xuddi hosting kabi, lekin juda oson.

---

## 📋 **QADAM 1: Railway Account Ochish**

### **1.1 Railway saytiga kirish:**
1. Brauzeringizda **https://railway.app** ni oching
2. Sahifa ochilganda **"Login"** tugmasini bosing
3. **"Continue with GitHub"** tugmasini bosing

### **1.2 GitHub account kerak:**
Agar GitHub accountingiz yo'q bo'lsa:
1. **https://github.com** ga o'ting
2. **"Sign up"** tugmasini bosing
3. Email, parol kiriting va account yarating

### **1.3 Railway'ga kirish:**
1. GitHub accountingiz bilan Railway'ga kiring
2. **"Authorize Railway"** tugmasini bosing
3. Railway dashboard ochiladi

---

## 📁 **QADAM 2: Loyihangizni GitHub'ga yuklash**

### **2.1 GitHub'da yangi repository yaratish:**

**A) GitHub.com ga o'ting:**
1. **https://github.com** ni oching
2. Yuqori o'ng burchakda **"+"** belgisini bosing
3. **"New repository"** ni tanlang

**B) Repository sozlamalari:**
1. **Repository name:** `kupon-bot` deb yozing
2. **Description:** `Telegram kupon bot` deb yozing
3. **Public** ni tanlang (bepul)
4. **"Create repository"** tugmasini bosing

### **2.2 Loyihangizni GitHub'ga yuklash:**

**A) Kompyuteringizda terminal oching:**
- Windows'da: `Win + R` bosing, `cmd` yozing, Enter bosing

**B) Loyiha papkasiga o'ting:**
```bash
cd C:\BOTK\bott-master
```

**C) Git sozlamalari (birinchi marta):**
```bash
git config --global user.name "Sizning ismingiz"
git config --global user.email "sizning@email.com"
```

**D) Loyihani Git'ga tayyorlash:**
```bash
git init
git add .
git commit -m "Birinchi yuklash"
```

**E) GitHub'ga ulash:**
```bash
git remote add origin https://github.com/SIZNING-USERNAME/kupon-bot.git
git branch -M main
git push -u origin main
```

**Eslatma:** `SIZNING-USERNAME` o'rniga o'zingizning GitHub username'ingizni yozing.

---

## 🗄️ **QADAM 3: Railway'da Database Yaratish**

### **3.1 PostgreSQL Database qo'shish:**

**A) Railway dashboard'da:**
1. **"New Project"** tugmasini bosing
2. **"Provision PostgreSQL"** ni tanlang
3. Database yaratilishini kuting (2-3 daqiqa)

**B) Database ma'lumotlarini saqlash:**
1. PostgreSQL service'ni oching
2. **"Variables"** tab'ni bosing
3. Quyidagi ma'lumotlarni ko'rib, yozib oling:
   - `DATABASE_URL` - bu muhim!
   - `PGHOST`
   - `PGPORT`
   - `PGDATABASE`
   - `PGUSER`
   - `PGPASSWORD`

---

## 🚀 **QADAM 4: Bot Loyihasini Deploy Qilish**

### **4.1 GitHub Repository'ni Railway'ga ulash:**

**A) Railway dashboard'da:**
1. **"New Project"** tugmasini bosing
2. **"Deploy from GitHub repo"** ni tanlang
3. `kupon-bot` repository'ni tanlang
4. **"Deploy Now"** tugmasini bosing

### **4.2 Environment Variables (Muhim sozlamalar):**

**A) Variables tab'ga o'ting:**
1. Loyiha yaratilgandan keyin **"Variables"** tab'ni oching
2. Quyidagi barcha o'zgaruvchilarni qo'shing:

**B) Har birini alohida qo'shing:**

```
SPRING_PROFILES_ACTIVE
```
Qiymati: `prod`

```
TELEGRAM_BOT_TOKEN
```
Qiymati: `8567911447:AAGGOpjupFR9NyEsWmgHer9PFrnwb0n9q3E`

```
TELEGRAM_BOT_USERNAME
```
Qiymati: `kuponnnnnbot`

```
TELEGRAM_CHANNEL_USERNAME
```
Qiymati: `@fqfsafawfasf`

```
TELEGRAM_CHANNEL_ID
```
Qiymati: `-1003820141567`

```
DATABASE_URL
```
Qiymati: PostgreSQL service'dan olingan `DATABASE_URL` ni nusxalang

### **4.3 Deploy jarayonini kuzatish:**
1. **"Deployments"** tab'ga o'ting
2. Build jarayonini kuzating
3. Yashil "Success" ko'rsatkichi paydo bo'lishini kuting

---

## 🔗 **QADAM 5: Public URL Olish**

### **5.1 Domain yaratish:**
1. **"Settings"** tab'ga o'ting
2. **"Networking"** bo'limini toping
3. **"Generate Domain"** tugmasini bosing
4. URL paydo bo'ladi, masalan: `https://kupon-bot-production.up.railway.app`

### **5.2 URL'ni saqlang:**
Bu URL sizning botingizning manzili. Uni yozib oling!

---

## 🔧 **QADAM 6: Telegram Webhook Sozlash**

### **6.1 Webhook URL'ni yangilash:**
Brauzeringizda quyidagi manzilni oching (o'zingizning URL'ingizni qo'ying):

```
https://api.telegram.org/bot8567911447:AAGGOpjupFR9NyEsWmgHer9PFrnwb0n9q3E/setWebhook?url=https://SIZNING-RAILWAY-URL.up.railway.app/webhook
```

**Masalan:**
```
https://api.telegram.org/bot8567911447:AAGGOpjupFR9NyEsWmgHer9PFrnwb0n9q3E/setWebhook?url=https://kupon-bot-production.up.railway.app/webhook
```

### **6.2 Webhook muvaffaqiyatli o'rnatilganini tekshirish:**
Sahifada `{"ok":true,"result":true,"description":"Webhook was set"}` ko'rinishi kerak.

---

## ✅ **QADAM 7: Bot Ishlashini Tekshirish**

### **7.1 Telegram'da bot tekshirish:**
1. Telegram'da `@kuponnnnnbot` ni qidiring
2. `/start` buyrug'ini yuboring
3. Bot javob berishi kerak

### **7.2 Admin panel tekshirish:**
Brauzeringizda ochib ko'ring:
```
https://SIZNING-RAILWAY-URL.up.railway.app/admin.html
```

---

## 🛠️ **Muammolar va Yechimlar**

### **Agar bot javob bermasa:**

**1. Logs tekshiring:**
- Railway'da **"Deployments"** tab
- **"View Logs"** tugmasini bosing
- Xatolarni o'qing

**2. Variables tekshiring:**
- Barcha environment variables to'g'ri kiritilganini tekshiring
- `DATABASE_URL` to'g'ri ekanini tekshiring

**3. Database ulanishini tekshiring:**
- PostgreSQL service ishlab turganini tekshiring

### **Agar build muvaffaqiyatsiz bo'lsa:**
1. GitHub'da kodlar to'g'ri yuklanganini tekshiring
2. `pom.xml` fayli mavjudligini tekshiring
3. Java versiyasi to'g'ri ekanini tekshiring

---

## 💰 **Narxlar**

### **Railway narxlari:**
- **Hobby Plan:** $5/oy
- **Database:** $5/oy
- **Jami:** $10/oy

### **Bepul muddat:**
Railway yangi foydalanuvchilarga $5 kredit beradi.

---

## 🎉 **Yakuniy Natija**

Agar hamma narsa to'g'ri bo'lsa:
- ✅ Bot 24/7 ishlaydi
- ✅ Foydalanuvchilar ro'yxatdan o'ta oladi
- ✅ Admin panel ishlaydi
- ✅ Notification'lar yuboriladi
- ✅ Excel export ishlaydi
- ✅ Broadcast xabarlar yuboriladi

---

## 📞 **Yordam Kerak Bo'lsa**

Agar qayerdadir tushunmagan bo'lsangiz:
1. Railway logs'ni tekshiring
2. Har bir qadamni qaytadan bajaring
3. Environment variables'ni tekshiring

**Omad tilayman!** 🚀