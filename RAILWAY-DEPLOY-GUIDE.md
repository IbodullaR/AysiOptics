# 🚂 Railway'ga Deploy qilish - Batafsil yo'riqnoma

## 1. Railway.app ga ro'yxatdan o'tish

1. **https://railway.app** ga o'ting
2. **"Start a New Project"** tugmasini bosing
3. **"Login with GitHub"** tugmasini bosing
4. GitHub akkauntingiz bilan kiring
5. **$5 kredit** avtomatik hisobingizga qo'shiladi

## 2. GitHub Repository yaratish

1. **GitHub.com** ga o'ting
2. **"New repository"** tugmasini bosing
3. Repository nomi: `kupon-bot-backend`
4. **Public** yoki **Private** tanlang
5. **"Create repository"** tugmasini bosing

## 3. Loyiha fayllarini GitHub'ga yuklash

### A) GitHub Desktop orqali (Oson usul):
1. **GitHub Desktop** dasturini yuklab oling
2. **"Clone repository"** → yangi yaratgan repository'ni tanlang
3. Loyiha fayllarini repository papkasiga ko'chiring:
   - Barcha `.java` fayllar
   - `pom.xml`
   - `src/` papkasi
   - `railway.json` (yangi yaratilgan)
   - `Dockerfile` (yangi yaratilgan)
4. **"Commit to main"** tugmasini bosing
5. **"Push origin"** tugmasini bosing

### B) Git command line orqali:
```bash
cd C:\BOTK\bott-master
git init
git add .
git commit -m "Initial commit"
git branch -M main
git remote add origin https://github.com/YOUR_USERNAME/kupon-bot-backend.git
git push -u origin main
```

## 4. Railway'da loyiha yaratish

1. **Railway.app** ga qayting
2. **"New Project"** tugmasini bosing
3. **"Deploy from GitHub repo"** ni tanlang
4. `kupon-bot-backend` repository'ni tanlang
5. **"Deploy Now"** tugmasini bosing

## 5. PostgreSQL Database qo'shish

1. Railway dashboard'da loyihangizni oching
2. **"New"** tugmasini bosing
3. **"Database"** → **"Add PostgreSQL"** ni tanlang
4. Database avtomatik yaratiladi
5. **"Connect"** tabida `DATABASE_URL` ni ko'ring

## 6. Environment Variables sozlash

Railway dashboard'da **"Variables"** tabiga o'ting va quyidagilarni qo'shing:

```
DATABASE_URL=postgresql://username:password@host:port/database
TELEGRAM_BOT_TOKEN=your_bot_token_here
TELEGRAM_BOT_USERNAME=your_bot_username
TELEGRAM_CHANNEL_USERNAME=@fqfsafawfasf
TELEGRAM_CHANNEL_ID=-1003820141567
SPRING_PROFILES_ACTIVE=prod
```

**Muhim:** `DATABASE_URL` avtomatik to'ldiriladi, faqat Telegram ma'lumotlarini qo'shing.

## 7. Deploy jarayonini kuzatish

1. **"Deployments"** tabida build jarayonini kuzating
2. **"Logs"** tabida xatoliklarni tekshiring
3. Build muvaffaqiyatli bo'lsa, **"View Logs"** da "Started KuponApplication" yozuvini ko'rasiz

## 8. Domain olish

1. **"Settings"** → **"Domains"** ga o'ting
2. **"Generate Domain"** tugmasini bosing
3. Domain: `https://your-app-name.up.railway.app`
4. Bu domain'ni saqlang

## 9. Vercel fayllarini yangilash

Railway domain'ni olganingizdan keyin, Vercel fayllaridagi API URL'larni yangilang:

### vercel-deploy/admin.html:
```javascript
const API_BASE = 'https://your-app-name.up.railway.app/api/admin';
```

### vercel-deploy/shop.html:
```javascript
const response = await fetch('https://your-app-name.up.railway.app/api/shop/products');
const response = await fetch('https://your-app-name.up.railway.app/api/shop/orders', {
```

## 10. Test qilish

1. **Railway domain'ni** brauzerda oching: `https://your-app-name.up.railway.app`
2. **Health check:** `https://your-app-name.up.railway.app/actuator/health`
3. **Admin API:** `https://your-app-name.up.railway.app/api/admin/stats`
4. **Vercel admin panel:** https://bott-ondv.vercel.app/admin.html

## 11. Bot'dagi URL'ni yangilash

`src/main/java/uz/kuponbot/kupon/bot/KuponBot.java` faylida:

```java
// Production Vercel HTTPS domain
shopButton.setUrl("https://bott-ondv.vercel.app/shop.html");
```

## Xarajatlar hisob-kitobi:

- **$5 kredit** - 2-3 oy yetadi
- **PostgreSQL** - ~$5/oy
- **Backend hosting** - ~$5/oy
- **Jami:** $10/oy (kredit tugagandan keyin)

## Afzalliklari:

- ✅ **Avtomatik HTTPS** - SSL sertifikat
- ✅ **PostgreSQL database** - to'liq SQL database
- ✅ **GitHub integration** - kod o'zgarsa avtomatik deploy
- ✅ **Environment variables** - xavfsiz konfiguratsiya
- ✅ **Logs va monitoring** - real-time logs
- ✅ **Custom domains** - o'z domeningizni ulash mumkin
- ✅ **Auto-scaling** - yuklama oshsa avtomatik scale qiladi

## Keyingi qadamlar:

1. Railway'ga deploy qiling
2. Domain oling
3. Vercel fayllarini yangilang
4. Bot'ni test qiling
5. Production'da ishlatishni boshlang!

Savollar bo'lsa, so'rang! 🚀