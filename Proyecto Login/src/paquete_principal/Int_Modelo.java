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

	public boolean comprobar_Pasword_login();

	public boolean comprobar_password_registro();

	public boolean comprobar_correo_registro();

	public boolean comprobar_ingreso_nombre();

	public boolean comprobar_ingreso_usuario();

	/**
	 * Metodo para la obtención de los datos alojados en la base de datos en la
	 * tabla "EDIFICIOS", para que de esta manera se pueda hacer alta,baja y
	 * modificación de datos en la misma
	 * 
	 * @return
	 */
	public ResultSet SeleccTodosEdificios();

}
