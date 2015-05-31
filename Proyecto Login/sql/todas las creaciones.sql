CREATE TABLE "USUARIOS_REGISTRADOS"
(
   "USUARIO"              VARCHAR2 (30) NOT NULL,
   "NOMBRE_COMPLETO"      VARCHAR2 (100) NOT NULL,
   "CORREO_ELECTRONICO"   VARCHAR2 (200) NOT NULL,
   "PASSWORD"             VARCHAR2 (60) NOT NULL,
   CONSTRAINT "USUARIOS_REGISTRADOS_PK" PRIMARY KEY ("USUARIO")
)
/

CREATE SEQUENCE "USUARIOS_REGISTRADOS_SEQ"
/

CREATE TRIGGER "BI_USUARIOS_REGISTRADOS"
   BEFORE INSERT
   ON "USUARIOS_REGISTRADOS"
   FOR EACH ROW
BEGIN
   IF :NEW."USUARIO" IS NULL
   THEN
      SELECT "USUARIOS_REGISTRADOS_SEQ".NEXTVAL INTO :NEW."USUARIO" FROM DUAL;
   END IF;
END;
/

CREATE TABLE "EDIFICIOS"
(
   "NOMBRE"         VARCHAR2 (30) NOT NULL,
   "PAIS"           VARCHAR2 (100),
   "CIUDAD"         VARCHAR2 (200),
   "ARQUITECTO"     VARCHAR2 (60),
   "LOCALIZACION"   VARCHAR2 (60),
   CONSTRAINT "EDIFICIOS_PK" PRIMARY KEY ("NOMBRE")
);

CREATE OR REPLACE PROCEDURE "ACTUALIZAR_DATO_EDIFICIO" (
   NOMBRE_ORIGINAL        IN VARCHAR2,
   NOMBRE_ingreso         IN VARCHAR2,
   PAIS_ingreso           IN VARCHAR2,
   CIUDAD_ingreso         IN VARCHAR2,
   ARQUITECTO_ingreso     IN VARCHAR2,
   LOCALIZACION_ingreso   IN VARCHAR2)
IS
BEGIN
   UPDATE EDIFICIOS
      SET NOMBRE = NOMBRE_ingreso,
          PAIS = PAIS_ingreso,
          CIUDAD = CIUDAD_ingreso,
          ARQUITECTO = ARQUITECTO_ingreso,
          LOCALIZACION = LOCALIZACION_ingreso
    WHERE NOMBRE = NOMBRE_ORIGINAL;
END;

CREATE OR REPLACE PROCEDURE "BORRAR_EDIFICIO" (NOMBRE_ingreso IN VARCHAR2)
IS
BEGIN
   DELETE FROM EDIFICIOS
         WHERE NOMBRE = NOMBRE_ingreso;
END;
/

CREATE OR REPLACE PROCEDURE "INSERTADO_DATOS_EDIFICIO" (
   NOMBRE_ingreso         IN VARCHAR2,
   PAIS_ingreso           IN VARCHAR2,
   CIUDAD_ingreso         IN VARCHAR2,
   ARQUITECTO_ingreso     IN VARCHAR2,
   LOCALIZACION_ingreso   IN VARCHAR2)
IS
BEGIN
   INSERT INTO EDIFICIOS (NOMBRE,
                          PAIS,
                          CIUDAD,
                          ARQUITECTO,
                          LOCALIZACION)
        VALUES (NOMBRE_ingreso,
                PAIS_ingreso,
                CIUDAD_ingreso,
                ARQUITECTO_ingreso,
                LOCALIZACION_ingreso);
END;
/

CREATE OR REPLACE PROCEDURE "INSERTADO_DATOS_REGISTRO" (
   usuario_ingreso      IN VARCHAR2,
   nombre_ingresado     IN VARCHAR2,
   correo_ingresado     IN VARCHAR2,
   password_ingresado   IN VARCHAR2)
IS
BEGIN
   INSERT INTO USUARIOS_REGISTRADOS (USUARIO,
                                     NOMBRE_COMPLETO,
                                     CORREO_ELECTRONICO,
                                     PASSWORD)
        VALUES (usuario_ingreso,
                nombre_ingresado,
                correo_ingresado,
                password_ingresado);
END;

â€‹â€‹