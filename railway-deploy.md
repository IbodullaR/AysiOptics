# Railway Deploy Yo'riqnomasi

## 1. Railway.app ga ro'yxatdan o'tish

1. https://railway.app ga o'ting
2. **Login with GitHub** tugmasini bosing
3. GitHub akkauntingiz bilan kiring
4. **$5 kredit** avtomatik beriladi

## 2. Loyihani tayyorlash

### A) GitHub repository yaratish:
1. GitHub'da yangi repository yarating: `kupon-bot-backend`
2. Loyiha fayllarini upload qiling

### B) Yoki Railway CLI ishlatish:
```bash
npm install -g @railway/cli
railway login
railway init
railway up
```

## 3. Database sozlash

Railway'da PostgreSQL database yaratish:
1. **New Project** → **Provision PostgreSQL**
2. Database URL'ni oling
3. Environment variables'ga qo'shing

## 4. Environment Variables

Railway'da quyidagi o'zgaruvchilarni qo'shing:
- `DATABASE_URL` - PostgreSQL connection string
- `TELEGRAM_BOT_TOKEN` - Bot token
- `TELEGRAM_BOT_USERNAME` - Bot username
- `TELEGRAM_CHANNEL_USERNAME` - Kanal username
- `TELEGRAM_CHANNEL_ID` - Kanal ID

## 5. Deploy qilish

1. **Deploy from GitHub** tanlang
2. Repository'ni tanlang
3. **Deploy** tugmasini bosing
4. Avtomatik build va deploy bo'ladi

## 6. Domain olish

Railway avtomatik HTTPS domain beradi:
- `https://your-app-name.up.railway.app`

## 7. Vercel fayllarini yangilash

Railway domain'ni Vercel fayllariga qo'shing:
- Admin: `https://your-app.up.railway.app/admin.html`
- API: `https://your-app.up.railway.app/api/admin/...`

## Xarajatlar:
- **$5 kredit** - 2-3 oy yetadi
- **Database** - $5/oy (kredit bilan)
- **Backend** - $5/oy (kredit bilan)

## Afzalliklari:
- ✅ Avtomatik HTTPS
- ✅ PostgreSQL database
- ✅ GitHub integration
- ✅ Automatic deployments
- ✅ Environment variables
- ✅ Logs va monitoring