alter table profile add constraint FK_PROFILE_ON_IMAGE_FILE foreign key (IMAGE_FILE_ID) references SYS_FILE(ID);
create index IDX_PROFILE_ON_IMAGE_FILE on profile (IMAGE_FILE_ID);
