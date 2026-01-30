-- User jadvaliga birth_date ustuni qo'shish
ALTER TABLE users ADD COLUMN birth_date VARCHAR(10);

-- Mavjud foydalanuvchilar uchun default qiymat
UPDATE users SET birth_date = NULL WHERE birth_date IS NULL;

-- Izoh: birth_date formati DD.MM.YYYY (masalan: 15.03.1995)