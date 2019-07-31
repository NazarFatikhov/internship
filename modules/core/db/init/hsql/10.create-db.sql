-- begin USER
create table user (
    ID varchar(36) not null,
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
    --
    primary key (ID)
)^
-- end USER
