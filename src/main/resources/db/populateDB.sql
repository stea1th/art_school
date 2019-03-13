delete from user_roles;
delete from unterricht;
delete from zahlung;
-- delete from kind;
delete from users;
alter sequence global_seq restart with 1000;

insert into users (name, email, adresse, admin_passwort, passwort) values
  ('Осипов', 'a@a.de', 'Schobertweg 5', 'a', '$2y$12$XTRZxQIpuCqmohLAEfWR1egfVA6zV.XYSCpmX7PZ2xWi0wjQb5d5O'),
  ('Власов', 'b@b.de', 'Hauptstrasse', 'b', '$2y$12$cxBk.GQ6EMCMEhtP6phMeOv3JIPI50D5MihCG.DHzm0f2pUWjrB3'),
  ('Тупулявичус','c@c.de', 'Sedulinos al', 'c', '$2y$12$hi808bq2qvKa/MAYkopSme/El6rqnM7C7Mz1iIStoPlkBm56.Q0Vq');

insert into zahlung (name, preis, dauer, aktiv) values
  ('Сорок пять минут', 24.69, '00:45', true),
  ('Полтора часа', 48.34, '01:30', true);

insert into users (name, email, adresse,  admin_passwort, passwort) values
  ('Светлана', 'svet@ok.ru', 'Taikos', '123', '$2a$10$dc2vjd2c7rQYLPHCaKdml.N3XPY2rTmccrTo/F8r9ifJdQEQB1Hkq'),
  ('Вадим', '1@1.de', 'Einsteinring', '1', '$2a$10$h3Kx2bbcXcNDK2ZabTGqUuO1k8iZ1T1YPOZQ7cq5rptIpGHf30prO');

insert into user_roles (role, user_id) values
  ('ROLE_USER', 1005),
  ('ROLE_ADMIN', 1006),
  ('ROLE_USER', 1006);

insert into unterricht (u_id, z_id, datum, bezahlt, notiz) values
  (1001, 1003, now(), true, 'Segodnia zaplatil'),
  (1001, 1003, '04.11.2018 13:15:00', false, 'Zaplatit v sledujushij raz'),
  (1002, 1003, '05-10-2018', true, 'Заплатил'),
  (1000, 1004, '2018-11-07 09:00:00', true, 'Заплатил, даже больше :))'),
  (1000, 1003, '10.11.2018', false, 'Забыл заплатить.. гад'),
  (1001, 1003, '25.10.2018', false, 'Привет пукешка!!'),
  (1001, 1003, '26.10.2018', false, 'Привет пукешка!!'),
  (1001, 1003, '28.10.2018', false, 'Привет пукешка!!');

insert into thema (titel, gepinnt) values
  ('В мире животных', false),
  ('Как молоды мы были', true),
  ('Облака, белокрылые лошадки', false );

insert into nachricht(u_id, t_id, text) values
  (1005, 1015, 'Какие прекрасные звери, как вам кажется? Есть ли в них достаточная грациозность?'),
  (1006, 1015, 'Думаю, что это не сложно увидеть тому, у кого есть глаза :)'),
  (1005, 1015, 'А вы хитры :))');



insert into nachricht(u_id, t_id, text, datum) values
  (1006, 1016, 'Как оно было у вас?', '2019-01-25 09:00:00'),
  (1005, 1016, 'Прекрасно, это было просто прекрасно!!', '2019-02-15 12:35'),
  (1006, 1016, 'А почему так?' ||
               'Я не знаю', now()),
  (1005, 1017, 'Где можно покататься на лошадках?', '2019-01-30 09:00:00');







