/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete_principal;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author 21414215
 */
public interface Int_Modelo {

	public void setVis_Login(Vis_Login Login);

	public void setVis_Registro(Vis_Registro Registro);

	public void setVis_Bienvenida(Vis_Bienvenida bienvenida);

	/**
	 * Metodo implementado para poder trabajar con los nombres de usuarios y sus
	 * respectivas contrase�as de manera local y poder hacer las comprobaciones
	 * pernitentes de registros de nuevos usuarios y de inicio de sesion.
	 */
	public void importar_usuarios_y_passwords();

	/**
	 * Metodo que le indica a la base de datos que hay que insertar un nuevo
	 * registro a la tabla USUARIOS_REGISTRADOS.Los parametros utilizados para
	 * este fin son los almacenados como atributos de la clase Modelo.
	 */
	public void registrar_usuario_tabla();

	public boolean comprobar_Pasword_login();

	/**
	 * Metodo para la comprobaci�n del ingreso de la contrase�a en el proceso de
	 * registro.
	 * 
	 * @return true si la comprobaci�n de la contrase�a es correcta, y falso si
	 *         la primera contrase�a ingresada no coincide con la ingresada en
	 *         el campo de comprobacion.
	 */
	public boolean comprobar_password_registro();

	/**
	 * Metodo que comprueba la longitud de la contrase�a ingresada. Se espera
	 * que tenga como minimo 8 caracteres y como maximo 60 caracteres
	 * 
	 * @return Verdadero si la longitud de la contrase�a no esta en el rango y
	 *         falso si la contrase�a es de la longitud deseada.
	 */
	public boolean comprobar_password_longitud();

	/**
	 * Metodo que comprueba que se ha ingresado bien la constrase�a y es de la
	 * longitud adecuada.
	 * 
	 * @return true si esta todo correcto y false si hay algun error.
	 */
	public boolean comprobacion_completa_password_registro();

	/**
	 * Metodo para comprobar errores en el ingreso de datos del campo usuario en
	 * el registro.
	 * 
	 * @return True esta todo correcto y false si hay algun error.
	 */
	public boolean comprobacion_completa_usuario();

	/**
	 * Metdo para la comprobacion de ingreso de un correo electronico valido.
	 * 
	 * @return True si se ingreso un correo electronico valido y false en
	 *         cualquier otro caso.
	 */
	public boolean comprobar_correo_registro();

	/**
	 * Metodo que comprueba si es que se ha ingresado algo en el campo Nombre
	 * del registro. Comprueba que la longitud coincide con el maximo permitido
	 * de la tabla Usuarios regitrados
	 * 
	 * @return True si la longitud es estrictamente mayor que cero y
	 *         estrictamente menor que 100. Falso en caso contrario.
	 */
	public boolean comprobar_ingreso_nombre();

	public boolean comprobar_ingreso_usuario();

	/**
	 * Metodo que comprueba la longitud de lo ingresado en el campo Usuario del
	 * registro.
	 * 
	 * @return True si se ha ingresado algo y su longitud es menor o igual que
	 *         30. Falso en caso contrario.
	 */
	public boolean comprobar_longitud_Usuario();

	/**
	 * Metodo que comprueba que se han ingresado todos los campos en el registro
	 * 
	 * @return True si se han ingresado todos los campos y false si falta al
	 *         menos un campo por ingresar.
	 */
	public boolean todos_campos_ingresados_registro();

	public void insertar_dato_edificio(String NOMBRE_ingreso,
			String PAIS_ingreso, String CIUDAD_ingreso,
			String ARQUITECTO_ingreso, String LOCALIZACION_ingreso);

	public void actualizar_dato_edificio(String NOMBRE_ORIGINAL,
			String NOMBRE_ingreso, String PAIS_ingreso, String CIUDAD_ingreso,
			String ARQUITECTO_ingreso, String LOCALIZACION_ingreso);

	public void borrar_dato_edificio(String NOMBRE_ORIGINAL);

	public void agregar_datos_tabla();

	public void agregar_datos_usuaionuevo_local(String Usuario,
			String Contrase�a);

	public void Cerrarconexion();
}
