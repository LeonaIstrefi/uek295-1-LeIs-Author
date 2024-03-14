INSERT INTO author (name, birthday, profile_picture)
VALUES ('Ana Huang', '7. March 1991', 'www.Ana Huang/author.com' ),
       ('J.K. Rowling', '31. July 1965', 'www.J.K. Rowling/author.com'),
       ('Jennifer Lynn Barnes', '19. October 1984','www.Jennifer Lynn Barnes/author.com' ),
       ('Holly Black', '10. November 1971','www.Holly Black/author.com' ),
       ('Friedrich Duerrenmatt', '5. January 1921','www.Friedrich Duerrenmatt/author.com' ),
       ('Stephen King', '21. September 1947','www.Stephen King/author.com' ),
       ('William Shakespeare', '26. April 1564', 'www.William Shakespeare/author.com' ),
       ('Charles Dickens', '7. February 1812','www.Charles Dickens/author.com' ),
       ('Sarah J. Maas','5. March 1986', 'www.Sarah J. Maas/author.com'),
       ('Rick Riordan', '5. June 1964','www.Rick Riordan/author.com' );

INSERT INTO role (role_id, name)
VALUES (1, 'ADMIN'),
       (2, 'USER');

INSERT INTO authority (authority_id, name)
VALUES (1, 'CREATE'),
       (2, 'READ'),
       (3, 'UPDATE'),
       (4, 'DELETE');

INSERT INTO author_role_authority (id_role, id_authority)
VALUES (1, 1),
       (1, 2),
       (1, 3),
       (1, 4),
       (2, 1);

INSERT INTO author_user (user_id, name, password, id_role)
VALUES (1, 'Leona', '1234', 1),
       (2, 'Max', '1234', 1),
       (3, 'Aryan', '1234', 2),
       (4, 'Naima', '1234', 2),
       (5, 'Gabriel', '1234', 2);



