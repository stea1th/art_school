drop table if exists user_roles;
drop table if exists unterricht;
drop table if exists zahlung;
drop table if exists kind;
drop table if exists users;


drop sequence if exists global_seq;

create sequence global_seq start 1000;

create table kind
(
  id integer primary key default nextval('global_seq'),
  name varchar not null,
  adresse varchar not null,
  aktiv bool default true not null,
  registriert timestamp default now() not null,
  constraint kind_unique_name_adresse_idx unique(name, adresse)
);


create table zahlung
(
  id integer primary key default nextval('global_seq'),
  name varchar not null,
  preis numeric not null,
  dauer time not null,
  aktiv bool default true not null,
  constraint zahlung_unique_preis_dauer_idx unique(preis, dauer)
);

create table unterricht
(
  id integer primary key default nextval('global_seq'),
  datum timestamp default now() not null,
  bezahlt bool default false not null,
  notiz text,
  k_id integer not null,
  z_id integer not null,
  foreign key (k_id) references kind(id) on delete cascade,
  foreign key (z_id) references zahlung(id) on delete cascade
);

create table users
(
  id integer primary key default nextval('global_seq'),
  name              VARCHAR                 NOT NULL,
  email             VARCHAR                 NOT NULL,
  passwort          VARCHAR                 NOT NULL,
  registriert       TIMESTAMP DEFAULT now() NOT NULL,
  aktiv             BOOL DEFAULT TRUE       NOT NULL
);
create unique index user_unique_email_index on users(email);

create table user_roles
(
  user_id INTEGER NOT NULL,
  role    VARCHAR,
  CONSTRAINT user_roles_idx UNIQUE (user_id, role),
  FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
)




