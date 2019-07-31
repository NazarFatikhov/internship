-- begin PROFILE
create table profile (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    username varchar(255) not null,
    nickname varchar(255) not null,
    first_name varchar(255),
    last_name varchar(255),
    display_name varchar(50),
    image_file_id uuid,
    biographical_info varchar(1023),
    website varchar(255),
    email varchar(255),
    hash_password text not null,
    IS_HR_MANAGER boolean,
    IS_RECRUITER boolean,
    IS_CRM_MANAGER boolean,
    IS_CRM_AGENT boolean,
    IS_ACCOUNTING_MANAGER boolean,
    IS_NOTIFIABLE boolean,
    IS_CHOOSING_VISUAL_EDITOR boolean,
    IS_CHOOSING_SYNTAX_HIGHLIGHTING boolean,
    admin_color_scheme varchar(50),
    IS_CHOOSING_KEYBOARD_STRUCTS boolean,
    IS_CHOOSING_TOOLBAR boolean,
    --
    primary key (ID)
)^
-- end PROFILE
