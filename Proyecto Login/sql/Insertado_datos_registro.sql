create or replace procedure "INSERTADO_DATOS_REGISTRO"
(usuario_ingreso IN VARCHAR2,
nombre_ingresado IN VARCHAR2,
correo_ingresado IN VARCHAR2,
password_ingresado IN VARCHAR2)
is
begin

   INSERT INTO USUARIOS_REGISTRADOS (USUARIO , NOMBRE_COMPLETO , CORREO_ELECTRONICO , PASSWORD ) VALUES (usuario_ingreso , nombre_ingresado , correo_ingresado , password_ingresado);

end;​