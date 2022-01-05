-- Insert some books
INSERT INTO book (id, isbn, title, author, year, price, stock)
VALUES (1, 4871324261932, 'Tютюн', 'Димитър Димов', 1951, 19, 3),
       (2, 2391625487326, 'Под игото', 'Иван Вазов', 1893, 24, 3),
       (3, 1987452363251, 'Елин Пелин', 'Ян Бибиян', 1933, 12, 1);

-- Insert some roles
INSERT INTO role (id, ROLE_NAME)
VALUES (1, 'LIBRARIAN'),
       (2, 'USER'),
       (3, 'ADMIN');

-- Insert some users
INSERT INTO user (id, FIRST_NAME, LAST_NAME, email, password)
VALUES (1, 'Pesho', 'Geshev', 'pesho@startit.bg',
        '$2a$12$.3R2QqLCG31rkH7Y20sP0eb/g3T4jo.vOlH5uUA1CNNoo1Z.MniYW'),
       (2, 'Ana', 'Ananieva', 'ana@startit.bg',
        '$2a$12$Wq6KTFUU8vWkM7EXGxqTJutTAArA6Vqarzv87Bm65AmC6clp6/n0e'),
       (3, 'Gosho', 'Peshev', 'admin@startit.bg',
        '$2a$10$PJ1ANugRUczYKnPjnN.P5OTzG33pIHFFXtIfT7LogdFwfDpQCIo62');

-- Insert user roles
INSERT INTO user_role (user_id, role_id)
VALUES (1, 1),
       (2, 2),
       (3, 3);