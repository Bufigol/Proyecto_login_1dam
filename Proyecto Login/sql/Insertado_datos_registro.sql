CREATE OR REPLACE PROCEDURE PROYECTO_LOGIN."Insertado_datos_registro" (
   "mail"              IN VARCHAR2,
   "nombre"            IN VARCHAR2,
   "passwordentrada"   IN VARCHAR2,
   "Usuarioentrada"           IN VARCHAR2
   )
AS
BEGIN
   INSERT INTO PROYECTO_LOGIN.usuarios_registrados (correo_electronico , Nombre_Completo , passwprd , Usuario ) VALUES ( mail,nombre,passwordentrada,Usuarioentrada);
END;