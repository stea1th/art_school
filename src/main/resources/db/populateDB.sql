delete from unterricht;
delete from zahlung;
delete from kind;
alter sequence global_seq restart with 1000;

insert into kind (name, adresse, aktiv) values
  ('Осипов', 'Schobertweg 5', true),
  ('Власов', 'Hauptstrasse', false),
  ('Тупулявичус', 'Sedulinos al', true);

insert into zahlung (name, preis, dauer, aktiv) values
  ('Сорок пять минут', 24.69, '00:45', true),
  ('Полтора часа', 48.34, '01:30', true);

insert into unterricht (k_id, z_id, datum, bezahlt, notiz) values
  (1001, 1003, now(), true, 'Segodnia zaplatil'),
  (1001, 1003, '04.11.2018 13:15:00', false, 'Zaplatit v sledujushij raz'),
  (1002, 1003, '05-11-2018', true, 'Заплатил'),
  (1000, 1004, '2018-11-07 09:00:00', true, 'Заплатил, даже больше :))'),
  (1000, 1003, '10.11.2018', false, 'Забыл заплатить.. гад'),
  (1001, 1003, '11.11.2018', false, 'Привет пукешка!!')