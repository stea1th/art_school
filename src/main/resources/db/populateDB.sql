delete from unterricht;
delete from zahlung;
delete from kind;
alter sequence global_seq restart with 1000;

insert into kind (name, adresse) values
  ('Osipov', 'Schobertweg 5'),
  ('Vlasov', 'Hauptstrasse'),
  ('Tupuliavichius', 'Sedulinos al');

insert into zahlung (preis, dauer) values
  (24.69, '00:45'),
  (48.34, '01:30');

insert into unterricht (k_id, z_id, datum, bezahlt, notiz) values
  (1001, 1003, now(), true, 'Segodnia zaplatil'),
  (1001, 1003, '04.08.2018', false, 'Zaplatit v sledujushij raz'),
  (1002, 1003, '05.08.2018', true, 'Заплатил'),
  (1000, 1004, '07.08.2018', true, 'Заплатил, даже больше :))'),
  (1000, 1003, '10.08.2018', false, 'Забыл заплатить.. гад')