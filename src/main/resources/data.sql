
-- SELECT TOP (1000) [completed]
--       ,[id]
--       ,[description]
--       ,[title]
--   FROM [java6N_fa26_sd20305].[dbo].[todos]


insert into todos (title,description,completed)
values ('Buy groceries','Milk, Bread, Eggs',0);

insert into todos (title,description,completed)
values ('Finish project','Complete the Java project by Friday',1);


insert into todos (title,description,completed)
values ('Call mom','Check in with mom and see how she is doing',0);


--
-- SELECT TOP (1000) [price]
--       ,[id]
--       ,[author]
--       ,[isbn]
--       ,[title]
--   FROM [java6N_fa26_sd20305].[dbo].[book]


insert into book (title,author,isbn,price)
values ('The Great Gatsby','F. Scott Fitzgerald','978-0743273565',10.99);

insert into book (title,author,isbn,price)
values ('To Kill a Mockingbird','Harper Lee','978-0061120084',7.99);

insert into book (title,author,isbn,price)
values ('1984','George Orwell','978-0451524935',8.99);









INSERT INTO users(name, username, email, password) VALUES('user', 'user', 'user@gmail.com', '$2a$10$ZJ95pqs8zJVEaXMiyXR49unS/21S.BoDd/yfNXXtkWeJ627r5eLWm'); -- password = 123456
INSERT INTO users(name, username, email, password) VALUES('admin', 'admin', 'admin@gmail.com', '$2a$10$ZJ95pqs8zJVEaXMiyXR49unS/21S.BoDd/yfNXXtkWeJ627r5eLWm');

INSERT INTO roles(name) VALUES('ROLE_USER');
INSERT INTO roles(name) VALUES('ROLE_ADMIN');

INSERT INTO user_roles (user_id, role_id) VALUES (1, 1);
INSERT INTO user_roles (user_id, role_id) VALUES (2, 2);
