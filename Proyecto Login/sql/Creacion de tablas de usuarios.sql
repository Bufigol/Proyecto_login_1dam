CREATE TABLE PROYECTO_LOGIN."usuarios_registrados"
(
   "Usuario"              VARCHAR2 (20) NOT NULL,
   "Nombre_Completo"      VARCHAR2 (100) NOT NULL,
   "correo_electronico"   VARCHAR2 (100) NOT NULL,
   "password"             VARCHAR2 (30) NOT NULL,
   PRIMARY KEY ("Usuario")
);

COMMENT ON TABLE PROYECTO_LOGIN."usuarios_registrados" IS
   'En esta tabla se encuentran los datos de los usuarios que pueden ingresar a la base de datos paraa ineteracturar con ella.';
COMMENT ON COLUMN PROYECTO_LOGIN."usuarios_registrados"."Usuario" IS
   'Se da por supuesto que todos los nombres de usuarios tienen que ser diferentes, por lo cual se ocupa como primary Key';
COMMENT ON COLUMN PROYECTO_LOGIN."usuarios_registrados"."Nombre_Completo" IS
   'Nombre real del usuario';
COMMENT ON COLUMN PROYECTO_LOGIN."usuarios_registrados"."correo_electronico" IS
   'Correo principal de contacto del usuario';
COMMENT ON COLUMN PROYECTO_LOGIN."usuarios_registrados"."password" IS
   'Contraseña para el ingreso del usuario'