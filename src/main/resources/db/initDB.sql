drop table if exists nachricht_updater;
drop table if exists user_roles;
drop table if exists block;
drop table if exists nachricht;
drop table if exists thema;
drop table if exists unterricht;
drop table if exists zahlung;
drop table if exists users;
-- drop table if exists kind;



drop sequence if exists global_seq;

create sequence global_seq start 1000;

create table zahlung
(
  id integer primary key default nextval('global_seq'),
  name varchar not null,
  preis numeric not null,
  dauer time not null,
  aktiv bool default true not null,
  constraint zahlung_unique_preis_dauer_idx unique(preis, dauer)
);

create table users
(
  id integer primary key default nextval('global_seq'),
  name              VARCHAR                 NOT NULL,
  adresse           varchar                 not null,
  email             VARCHAR                 NOT NULL,
  admin_passwort    VARCHAR                 NOT NULL,
  passwort          VARCHAR                 NOT NULL,
  registriert       TIMESTAMP DEFAULT now() NOT NULL,
  aktiv             BOOL DEFAULT TRUE       NOT NULL
);
create unique index user_unique_email_index on users(email);

create table unterricht
(
  id integer primary key default nextval('global_seq'),
  datum timestamp default now() not null,
  bezahlt bool default false not null,
  notiz text,
  u_id integer not null,
  z_id integer not null,
  foreign key (u_id) references users(id) on delete cascade,
  foreign key (z_id) references zahlung(id) on delete cascade
);


create table thema
(
  id integer primary key default nextval('global_seq'),
  titel varchar not null,
  views integer default 0 not null,
  aktiv bool default true not null,
  gepinnt bool default false not null,
  u_id integer,
  foreign key (u_id) references users(id) on delete cascade
);

create table nachricht
(
  id integer primary key default nextval('global_seq'),
  text varchar not null,
  datum timestamp default now() not null,
  u_id integer not null,
  t_id integer not null,
  n_id integer,
  foreign key (u_id) references users(id) on delete cascade,
  foreign key (t_id) references thema(id) on delete cascade,
  foreign key (n_id) references nachricht(id) on delete cascade
);

create table block
(
  id integer primary key default nextval('global_seq'),
  reason varchar not null,
  datum timestamp default now() + interval '1 hour' not null,
  accepted bool default false not null,
  u_id integer not null,
  adm_id integer not null,
  foreign key (u_id) references users(id) on delete cascade,
  foreign key (adm_id) references users(id) on delete cascade

);

create table user_roles
(
  user_id INTEGER NOT NULL,
  role    VARCHAR,
  CONSTRAINT user_roles_idx UNIQUE (user_id, role),
  FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);

create table nachricht_updater
(
  user_id integer not null,
  nachricht_id integer not null,
  datum timestamp default now() not null,
  action varchar not null,
  primary key(user_id, nachricht_id)
);
-- create unique index user_nachricht_unique_index on nachricht_updater(u_id, n_id);




