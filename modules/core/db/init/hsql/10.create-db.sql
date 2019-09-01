-- begin PETCLINIC_PET
create table PETCLINIC_PET (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    NAME varchar(255),
    --
    IDENTIFICATION_NUMBER varchar(255) not null,
    BIRTH_DATE date,
    TYPE_ID varchar(36),
    OWNER_ID varchar(36),
    PROPERTIES_ID varchar(36),
    --
    primary key (ID)
)^
-- end PETCLINIC_PET
-- begin PETCLINIC_PET_TYPE
create table PETCLINIC_PET_TYPE (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    NAME varchar(255),
    --
    PROPERTIES_ENTITY_NAME varchar(255),
    PROPERTIES_FRAGMENT varchar(255),
    --
    primary key (ID)
)^
-- end PETCLINIC_PET_TYPE
-- begin PETCLINIC_OWNER
create table PETCLINIC_OWNER (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    FIRST_NAME varchar(255) not null,
    LAST_NAME varchar(255),
    --
    ADDRESS varchar(255) not null,
    CITY varchar(255) not null,
    EMAIL varchar(255),
    TELEPHONE varchar(255),
    --
    primary key (ID)
)^
-- end PETCLINIC_OWNER
-- begin PETCLINIC_VET
create table PETCLINIC_VET (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    FIRST_NAME varchar(255) not null,
    LAST_NAME varchar(255),
    --
    primary key (ID)
)^
-- end PETCLINIC_VET
-- begin PETCLINIC_SPECIALTY
create table PETCLINIC_SPECIALTY (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    NAME varchar(255),
    --
    primary key (ID)
)^
-- end PETCLINIC_SPECIALTY
-- begin PETCLINIC_VISIT
create table PETCLINIC_VISIT (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    VISIT_DATE date not null,
    DESCRIPTION varchar(4000),
    PET_ID varchar(36) not null,
    --
    primary key (ID)
)^
-- end PETCLINIC_VISIT
-- begin PETCLINIC_VET_SPECIALTY_LINK
create table PETCLINIC_VET_SPECIALTY_LINK (
    VET_ID varchar(36) not null,
    SPECIALTY_ID varchar(36) not null,
    primary key (VET_ID, SPECIALTY_ID)
)^
-- end PETCLINIC_VET_SPECIALTY_LINK
-- begin PETCLINIC_PET_PROPERTIES
create table PETCLINIC_PET_PROPERTIES (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    DTYPE varchar(31),
    --
    primary key (ID)
)^
-- end PETCLINIC_PET_PROPERTIES

-- begin PETCLINIC_FLYING_PROPERTIES
create table PETCLINIC_FLYING_PROPERTIES (
    ID varchar(36) not null,
    --
    WING_WIDTH double precision,
    --
    primary key (ID)
)^
-- end PETCLINIC_FLYING_PROPERTIES
-- begin PETCLINIC_WATER_PROPERTIES
create table PETCLINIC_WATER_PROPERTIES (
    ID varchar(36) not null,
    --
    MAX_DEPTH double precision,
    --
    primary key (ID)
)^
-- end PETCLINIC_WATER_PROPERTIES
