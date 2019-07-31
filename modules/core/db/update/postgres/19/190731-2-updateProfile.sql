alter table profile add column HASH_PASSWORD text ^
update profile set HASH_PASSWORD = '' where HASH_PASSWORD is null ;
alter table profile alter column HASH_PASSWORD set not null ;
