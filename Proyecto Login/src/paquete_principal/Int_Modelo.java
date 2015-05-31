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

	public void importar_usuarios_y_passwords();

	public void registrar_usuario_tabla();

	/**
	 * Metodo que tiene como objetivo la obtencion de datos de la tabla
	 * edificios. Se obtienen los datos a través de una sentencia plsql para
	 * poder trabajar con ellos de manera local. El obetivo es que despues de
	 * cualquier interaccion con estoas datos se hagan las mismas acciones sobre
	 * la base de daatos.
	 * 
	 * @param entrada
	 */
	public void insertado_datos_edificios_local(ResultSet entrada);

	public boolean comprobar_Pasword_login();

	/**
	 * Metodo para la comprobación del ingreso de la contraseña en el proceso de
	 * registro.
	 * 
	 * @return true si la comprobación de la contraseña es correcta, y falso si
	 *         la primera contraseña ingresada no coincide con la ingresada en
	 *         el campo de comprobacion.
	 */
	public boolean comprobar_password_registro();

	/**
	 * Metodo que comprueba la longitud de la contraseña ingresada. Se espera
	 * que tenga como minimo 8 caracteres y como maximo 60 caracteres
	 * 
	 * @return Verdadero si la longitud de la contraseña no esta en el rango y
	 *         falso si la contraseña es de la longitud deseada.
	 */
	public boolean comprobar_password_longitud();

	/**
	 * Metodo que comprueba que se ha ingresado bien la constraseña y es de la
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

	/**
	 * Metodo para la obtención de los datos alojados en la base de datos en la
	 * tabla "EDIFICIOS", para que de esta manera se pueda hacer alta,baja y
	 * modificación de datos en la misma
	 * 
	 * @return
	 */
	public void SeleccTodosEdificios();

}
