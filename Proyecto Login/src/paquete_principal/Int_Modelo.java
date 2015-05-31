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
	 * edificios. Se obtienen los datos a trav�s de una sentencia plsql para
	 * poder trabajar con ellos de manera local. El obetivo es que despues de
	 * cualquier interaccion con estoas datos se hagan las mismas acciones sobre
	 * la base de daatos.
	 * 
	 * @param entrada
	 */
	public void insertado_datos_edificios_local(ResultSet entrada);

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

	public boolean comprobar_correo_registro();

	public boolean comprobar_ingreso_nombre();

	public boolean comprobar_ingreso_usuario();

	/**
	 * Metodo para la obtenci�n de los datos alojados en la base de datos en la
	 * tabla "EDIFICIOS", para que de esta manera se pueda hacer alta,baja y
	 * modificaci�n de datos en la misma
	 * 
	 * @return
	 */
	public void SeleccTodosEdificios();

}
