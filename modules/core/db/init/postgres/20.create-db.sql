-- begin PROFILE
alter table profile add constraint FK_PROFILE_ON_IMAGE_FILE foreign key (IMAGE_FILE_ID) references SYS_FILE(ID)^
create unique index IDX_profile_UK_username on profile (username) where DELETE_TS is null ^
create index IDX_PROFILE_ON_IMAGE_FILE on profile (IMAGE_FILE_ID)^
-- end PROFILE
