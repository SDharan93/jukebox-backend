-- Insert users into database. Passwords are both 'password'
INSERT INTO users (email,enabled,password)
SELECT 'shane@example.ca',true,'$2a$06$KQ7egivKNlSDLjMp7ODzQe/lYTjP71PZ7hiuSd9ffyf2MfA2KjHAi'
WHERE
    NOT EXISTS (
        SELECT email FROM users WHERE email = 'shane@example.ca'
    );

-- Insert users into database. Passwords are both 'password'
INSERT INTO users (email,enabled,password)
SELECT 'shael@example.ca',true,'$2a$06$3PYE5JjJTsMwN/LKvJZgQu8czxdE0aKUZv0eTiGgvU4hOyOWlys1u'
WHERE
    NOT EXISTS (
        SELECT email FROM users WHERE email = 'shael@example.ca'
    );