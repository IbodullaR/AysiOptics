# Kupon Bot - Vercel Deploy (Updated: 2026-01-30 23:20)

Bu papka Vercel'da deploy qilish uchun mo'ljallangan static fayllarni o'z ichiga oladi.

## ⚠️ Muhim eslatma:
Bu fayllar localhost:8080 da ishlaydigan backend'ga ulanadi. Vercel'da to'liq ishlashi uchun backend ham deploy qilinishi kerak.

## Fayllar:
- `admin.html` - Admin panel (localhost:8080 ga ulangan) ✅ YANGILANDI
- `login.html` - Admin login sahifasi
- `shop.html` - Do'kon sahifasi (localhost:8080 ga ulangan) ✅ YANGILANDI
- `test-admin.html` - Test admin sahifasi (localhost:8080 ga ulangan) ✅ YANGILANDI
- `vercel.json` - Vercel konfiguratsiyasi

## Linklar:
- **Admin Panel:** https://bott-ondv.vercel.app/admin.html
- **Login:** https://bott-ondv.vercel.app/login.html
- **Do'kon:** https://bott-ondv.vercel.app/shop.html

## Ishlash tartibi:
1. **Local backend ishga tushiring:** `mvn spring-boot:run` (localhost:8080)
2. **Vercel sahifalarini oching** - ular localhost:8080 ga API so'rovlar yuboradi
3. **CORS sozlangan** - Vercel domain'dan localhost:8080 ga so'rovlar ishlaydi
4. **Cache tozalash:** Ctrl+F5 yoki Hard Refresh qiling

## Yangilanishlar:
- ✅ API URL'lar localhost:8080 ga o'zgartirildi (2026-01-30 23:20)
- ✅ CORS konfiguratsiyasi sozlangan
- ✅ Profil xatoligi tuzatildi
- ✅ Test mahsulotlar o'chirildi
- ✅ Adminlar foydalanuvchilar ro'yxatidan yashirildi
- ✅ Database persistence tuzatildi
- ✅ Cache busting timestamp qo'shildi

## Production uchun:
Backend'ni ham deploy qiling (Railway, Heroku, etc.) va API URL'larni production URL'ga o'zgartiring.

## Cache muammosi bo'lsa:
1. Browser'da Ctrl+F5 (Hard Refresh)
2. Developer Tools → Network → Disable cache
3. Incognito/Private mode'da oching