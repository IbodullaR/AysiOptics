# 🚨 MUAMMO HAL QILISH - Profile Ishlamayapti

## ❌ **Muammo:**
Logs'da ko'rinib turibdiki:
- `No active profile set, falling back to 1 default profile: "default"`
- `Connection to localhost:5432 refused`

Bu degani **SPRING_PROFILES_ACTIVE** environment variable ishlamayapti!

---

## ✅ **YECHIM - Qadamlar:**

### **1. Railway Variables'ni qayta tekshiring:**

**A) Railway dashboard'ga o'ting:**
- Bot service'ni oching
- **"Variables"** tab'ni bosing

**B) ANIQ tekshiring:**
```
SPRING_PROFILES_ACTIVE
```
**Qiymati:** `prod` (kichik harflar, tirnoqsiz)

### **2. Agar variable yo'q bo'lsa:**
1. **"New Variable"** tugmasini bosing
2. **Name:** `SPRING_PROFILES_ACTIVE` (aynan shunday yozing)
3. **Value:** `prod` (aynan shunday yozing)
4. **"Add"** tugmasini bosing

### **3. Agar variable mavjud bo'lsa:**
1. SPRING_PROFILES_ACTIVE'ni oching
2. **"Edit"** tugmasini bosing
3. Value'ni `prod` ga o'zgartiring
4. **"Save"** tugmasini bosing

### **4. Barcha variables ro'yxati:**
Quyidagilar bo'lishi SHART:

```
SPRING_PROFILES_ACTIVE = prod
DATABASE_URL = postgresql://postgres:OsCmDtHxGoEskfWkAjEFTYJXAUgpoDvV@postgres.railway.internal:5432/railway
TELEGRAM_BOT_TOKEN = 8567911447:AAGGOpjupFR9NyEsWmgHer9PFrnwb0n9q3E
TELEGRAM_BOT_USERNAME = kuponnnnnbot
TELEGRAM_CHANNEL_USERNAME = @fqfsafawfasf
TELEGRAM_CHANNEL_ID = -1003820141567
```

### **5. Redeploy qiling:**
- Variables saqlangandan keyin Railway avtomatik redeploy qiladi
- Yoki **"Deployments"** → **"Redeploy"** tugmasini bosing

---

## 🔍 **Yangi logs'da ko'rish kerak:**

**✅ Muvaffaqiyatli bo'lsa:**
```
The following 1 profile is active: "prod"
HikariPool-1 - Start completed
Started KuponApplication in X.XXX seconds
```

**❌ Hali ham xato bo'lsa:**
```
No active profile set, falling back to 1 default profile: "default"
Connection to localhost:5432 refused
```

---

## 🎯 **Muhim eslatma:**

**SPRING_PROFILES_ACTIVE** variable nomi va qiymati:
- **Name:** `SPRING_PROFILES_ACTIVE` (aynan shunday, katta harflar)
- **Value:** `prod` (aynan shunday, kichik harflar, tirnoqsiz)

Bu o'zgarishdan keyin bot `application-prod.properties` faylini ishlatadi va to'g'ri database'ga ulanadi!

---

## 📞 **Agar hali ham ishlamasa:**

1. **Variables'ni screenshot qiling** - nima yozilganini ko'rish uchun
2. **Logs'ni qayta tekshiring** - profile active bo'lganini tekshirish uchun
3. **Manual redeploy qiling** - ba'zan avtomatik ishlamaydi

**Bu muammoni 100% hal qiladi!** 🚀