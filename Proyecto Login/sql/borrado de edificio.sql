create or replace procedure "BORRAR_EDIFICIO"
(NOMBRE_ingreso IN VARCHAR2)
is
begin
   DELETE FROM EDIFICIOS WHERE NOMBRE=NOMBRE_ingreso ;
end;
/ 