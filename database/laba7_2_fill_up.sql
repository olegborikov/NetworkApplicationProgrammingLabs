INSERT INTO users(name, surname, patronymic, birthday)
VALUES ('Oleg', 'Borikov', 'Viktorovich', '11111111111111');
INSERT INTO users(name, surname, patronymic, birthday)
VALUES ('Alexei', 'Zhygadlo', 'Alexsandrovich', '11111111111161');
INSERT INTO users(name, surname, patronymic, birthday)
VALUES ('Roman', 'Vanzonok', 'Viktorovich', '11111111112111');
INSERT INTO users(name, surname, patronymic, birthday)
VALUES ('Anna', 'Rusakovich', 'Antonovna', '11111111212111');
INSERT INTO users(name, surname, patronymic, birthday)
VALUES ('Yuri', 'Kopilec', 'Denosovich', '11111111112161');
INSERT INTO letters(theme, text, departure_date, sender_users_id_fk, receiver_users_id_fk)
VALUES ('PSP', 'Hello, did you do all labas on psp?', '11111111111161', 1, 5);
INSERT INTO letters(theme, text, departure_date, sender_users_id_fk, receiver_users_id_fk)
VALUES ('PSP', 'Hello, no', '11111111111701', 5, 1);
INSERT INTO letters(theme, text, departure_date, sender_users_id_fk, receiver_users_id_fk)
VALUES ('Mood', 'How are you?', '11111111111161', 2, 3);
INSERT INTO letters(theme, text, departure_date, sender_users_id_fk, receiver_users_id_fk)
VALUES ('Mood', 'I am fine, and you?', '11111111111161', 3, 2);
INSERT INTO letters(theme, text, departure_date, sender_users_id_fk, receiver_users_id_fk)
VALUES ('Mood', 'I am ok too, thanks', '11111111111161', 2, 3);
