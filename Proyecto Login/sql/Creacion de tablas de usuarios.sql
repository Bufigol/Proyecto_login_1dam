CREATE table "USUARIOS_REGISTRADOS" (
    "USUARIO"            VARCHAR2(30) NOT NULL,
    "NOMBRE_COMPLETO"    VARCHAR2(100) NOT NULL,
    "CORREO_ELECTRONICO" VARCHAR2(200) NOT NULL,
    "PASSWORD"           VARCHAR2(60) NOT NULL,
    constraint  "USUARIOS_REGISTRADOS_PK" primary key ("USUARIO")
)
/

CREATE sequence "USUARIOS_REGISTRADOS_SEQ" 
/

CREATE trigger "BI_USUARIOS_REGISTRADOS"  
  before insert on "USUARIOS_REGISTRADOS"              
  for each row 
begin  
  if :NEW."USUARIO" is null then
    select "USUARIOS_REGISTRADOS_SEQ".nextval into :NEW."USUARIO" from dual;
  end if;
end;
/   