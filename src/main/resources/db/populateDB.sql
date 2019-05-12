delete
from user_roles;
delete
from block;
delete
from unterricht;
delete
from zahlung;
delete
from users;
alter sequence global_seq
  restart with 1000;

insert into users (name, email, adresse, admin_passwort, passwort)
values ('Müller', 'a@a.de', 'Schobertweg 5', '1', '$2a$10$h3Kx2bbcXcNDK2ZabTGqUuO1k8iZ1T1YPOZQ7cq5rptIpGHf30prO'),
       ('Herbert', 'b@b.de', 'Hauptstrasse', '1', '$2a$10$h3Kx2bbcXcNDK2ZabTGqUuO1k8iZ1T1YPOZQ7cq5rptIpGHf30prO'),
       ('Hahn', 'c@c.de', 'Sedulinos al', '1', '$2a$10$h3Kx2bbcXcNDK2ZabTGqUuO1k8iZ1T1YPOZQ7cq5rptIpGHf30prO');

insert into zahlung (name, preis, dauer, aktiv)
values ('Сорок пять минут', 24.69, '00:45', true),
       ('Полтора часа', 48.34, '01:30', true);

insert into users (name, email, adresse, admin_passwort, passwort)
values ('Merkl', 'svet@ok.ru', 'Taikos', '123', '$2a$10$dc2vjd2c7rQYLPHCaKdml.N3XPY2rTmccrTo/F8r9ifJdQEQB1Hkq'),
       ('Vadim', '1@1.de', 'Einsteinring', '1', '$2a$10$h3Kx2bbcXcNDK2ZabTGqUuO1k8iZ1T1YPOZQ7cq5rptIpGHf30prO');

insert into user_roles (role, user_id)
values ('ROLE_USER', 1005),
       ('ROLE_USER', 1000),
       ('ROLE_USER', 1001),
       ('ROLE_USER', 1002),
       ('ROLE_MODERATOR', 1005),
       ('ROLE_MODERATOR', 1006),
       ('ROLE_ADMIN', 1006),
       ('ROLE_USER', 1006);

insert into unterricht (u_id, z_id, datum, bezahlt, notiz)
values (1001, 1003, now(), true, 'Segodnia zaplatil'),
       (1001, 1003, '04.11.2018 13:15:00', false, 'Zaplatit v sledujushij raz'),
       (1002, 1003, '05-10-2018', true, 'Заплатил'),
       (1000, 1004, '2018-11-07 09:00:00', true, 'Заплатил, даже больше :))'),
       (1000, 1003, '10.11.2018', false, 'Забыл заплатить.. гад'),
       (1001, 1003, '25.10.2018', false, 'Привет пукешка!!'),
       (1001, 1003, '26.10.2018', false, 'Привет пукешка!!'),
       (1001, 1003, '28.10.2018', false, 'Привет пукешка!!');

insert into thema (titel, gepinnt)
values ('Manchmal reicht ein Kreuzzeichen', false),
       ('Im Schatten des Oligarchen', true),
       ('So profitiert München', false);

insert into nachricht (u_id, t_id, text)
values (1005, 1015, 'Immer wieder sind Kirchen Angriffsziele von Fanatikern - in Ägypten, im Irak aber auch auf den Philippinen.'),
       (1006, 1015, ' Die Attentäter haben am Ostersonntag auf der Weltkarte einen weiteren Schauplatz mörderischer Gewalt gegen Christen hinzugefügt'),
       (1005, 1015, 'In mindestens 21 Ländern, so hat vergangenes Jahr die päpstliche Stiftung "Hilfe für die leidende Kirche" in ihrem Bericht gezählt'),
       (1001, 1015, ' Und manchmal reicht ein Kreuzzeichen für eine Aggression.');


insert into nachricht (u_id, t_id, text, datum)
values (1006, 1016, 'Wolodymyr Selensky verdankt seinen Wahlsieg auch der Unterstützung durch einen umstrittenen Geschäftsmann', now() - interval '4 day'),
       (1005, 1016, 'Jurij Luzenko darf sich schon einmal auf die Arbeitssuche machen', now() - interval '1 day'),
       (1006, 1016, 'Denn der Präsident bestimmt nur über den Generalstaatsanwalt und Geheimdienstchef, den Außen- und Verteidigungsminister sowie den Direktor der Nationalbank' ||
                    'Vergleichsweise einfach ist für den kommenden Präsidenten die Außenpolitik. ', now()),
       (1005, 1017, 'Soziale Organisationen bekommen ebenso Unterstützung wie die Stadtverwaltung, Forscher oder Münchner Unternehmen. Eine Auswahl der von Brüssel geförderten Projekte.', '2019-01-30 09:00:00');

insert into block (u_id, adm_id, datum,  reason)
values (1001, 1006, now() + interval '1 hour', 'Schlechter Junge'),
       (1001, 1006, '2019-03-22 09:00:00', 'Охуевший не то слово'),
       (1001, 1005, '2019-03-22 15:00:00', 'Опухший'),
       (1001, 1006, '2019-03-23 15:00:00', 'Опухший в край');









