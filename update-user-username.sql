-- User jadvaliga telegram_username ustuni qo'shish
ALTER TABLE users ADD COLUMN telegram_username VARCHAR(255);

-- Izoh: telegram_username formati @username (masalan: @IbodullaR)