drop table if exists unterricht;
drop table if exists zahlung;
drop table if exists kind;

drop sequence if exists global_seq;

create sequence global_seq start 1000;

create table kind
(
  id integer primary key default nextval('global_seq'),
  name varchar not null,
  adresse varchar not null,
  aktiv bool default true not null
);

create table zahlung
(
  id integer primary key default nextval('global_seq'),
  preis numeric not null,
  dauer time not null,
  constraint preis_dauer_idx unique(preis, dauer)
);

create table unterricht
(
  id integer primary key default nextval('global_seq'),
  datum timestamp default now() not null,
  bezahlt bool default true not null,
  notiz text,
  k_id integer not null,
  z_id integer not null,
  foreign key (k_id) references kind(id) on delete cascade,
  foreign key (z_id) references zahlung(id) on delete cascade
);


