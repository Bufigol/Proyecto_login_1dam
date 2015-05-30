CREATE table "EDIFICIOS" ( 
    "NOMBRE"       VARCHAR2(30)  NOT NULL,
    "PAIS"         VARCHAR2(100),
    "CIUDAD"       VARCHAR2(200),
    "ARQUITECTO"   VARCHAR2(60),
    "LOCALIZACION" VARCHAR2(60),
    constraint  "EDIFICIOS_PK" primary key ("NOMBRE")
);