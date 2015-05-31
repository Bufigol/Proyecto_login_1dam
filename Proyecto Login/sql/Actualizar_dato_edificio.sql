create or replace procedure "ACTUALIZAR_DATO_EDIFICIO"
(NOMBRE_ORIGINAL IN VARCHAR2,
NOMBRE_ingreso IN VARCHAR2,
PAIS_ingreso IN VARCHAR2,
CIUDAD_ingreso IN VARCHAR2,
ARQUITECTO_ingreso IN VARCHAR2,
LOCALIZACION_ingreso IN VARCHAR2)

is
begin

   UPDATE EDIFICIOS SET NOMBRE = NOMBRE_ingreso , 
                        PAIS = PAIS_ingreso ,
                        CIUDAD = CIUDAD_ingreso , 
                        ARQUITECTO = ARQUITECTO_ingreso ,  
                        LOCALIZACION=LOCALIZACION_ingreso 
   WHERE NOMBRE=NOMBRE_ORIGINAL;

end;