--
--    Copyright 2018-2022 the original author or authors.
--
--    Licensed under the Apache License, Version 2.0 (the "License");
--    you may not use this file except in compliance with the License.
--    You may obtain a copy of the License at
--
--       https://www.apache.org/licenses/LICENSE-2.0
--
--    Unless required by applicable law or agreed to in writing, software
--    distributed under the License is distributed on an "AS IS" BASIS,
--    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
--    See the License for the specific language governing permissions and
--    limitations under the License.
--

drop table if exists names;
drop table if exists names2;
drop table if exists persons;
drop table if exists person_mails;

create table names (
  id int generated by default as identity,
  firstName varchar(20),
  lastName varchar(20)
);

create table names2 (
   id int generated by default as identity,
   firstName varchar(20),
   lastName varchar(20)
);

create table persons (
  id int generated by default as identity,
  name varchar(40)
);

create table person_mails (
  id int generated by default as identity,
  person_id int,
  address varchar(256)
);

insert into names (id, firstName, lastName) values(1, 'Fred', 'Flintstone');
insert into names (id, firstName, lastName) values(2, 'Wilma', 'Flintstone');
insert into names (id, firstName, lastName) values(3, 'Pebbles', 'Flintstone');
insert into names (id, firstName, lastName) values(4, 'Barney', 'Rubble');
insert into names (id, firstName, lastName) values(5, 'Betty', 'Rubble');
insert into names (id, firstName, lastName) values(6, 'Be%ty', 'Ab_le');
insert into names (id, firstName, lastName) values(7, 'Be\ty', 'Abble');

insert into names2 (id, firstName, lastName) values(1, 'MyBatis', 'Thymeleaf');

insert into persons (id, name) values(100, 'Name 1');
insert into persons (id, name) values(101, 'Name 2');

insert into person_mails (id, person_id, address) values(1000, 100, 'mybatis1.main@test.net');
insert into person_mails (id, person_id, address) values(1001, 100, 'mybatis1.sub@test.net');
insert into person_mails (id, person_id, address) values(1002, 101, 'mybatis2.main@test.net');
insert into person_mails (id, person_id, address) values(1003, 101, 'mybatis2.sub@test.net');
