# Telegram Kanal Sozlash Yo'riqnomasi

## 1. Kanal yaratish

1. Telegram'da yangi kanal yarating
2. Kanalga nom bering (masalan: "Kupon Bot Kanali")
3. Kanal username'ini belgilang (masalan: @kupon_bot_channel)

## 2. Kanal ID'sini olish

### Usul 1: @userinfobot orqali
1. @userinfobot'ga o'ting
2. Kanalingizni forward qiling
3. Bot sizga kanal ID'sini beradi

### Usul 2: Web Telegram orqali
1. web.telegram.org'ga kiring
2. Kanalingizni oching
3. URL'dan ID'ni oling: https://web.telegram.org/k/#-1001234567890

## 3. Bot'ni kanal adminiga qo'shish

1. Kanalingizga o'ting
2. "Manage Channel" > "Administrators"
3. "Add Admin" tugmasini bosing
4. Bot username'ini qidiring: @kuponnnnnbot
5. Bot'ni admin qilib qo'shing
6. "Get Chat Members" huquqini bering

## 4. application.properties'ni yangilash

```properties
# Channel configuration
telegram.channel.username=@kupon_bot_channel
telegram.channel.id=-1001234567890
```

**Muhim:** 
- `telegram.channel.username` - @ belgisi bilan
- `telegram.channel.id` - minus belgisi bilan boshlanadi

## 5. Test qilish

1. Bot'ni ishga tushiring
2. Yangi foydalanuvchi sifatida ro'yxatdan o'ting
3. Kanal obunasi bosqichida test qiling

## Xatoliklar

Agar "Forbidden: bot was blocked by the user" xatoligi chiqsa:
- Bot kanal adminimi tekshiring
- Bot'ga "Get Chat Members" huquqi berilganmi tekshiring
- Kanal ID to'g'ri kiritilganmi tekshiring