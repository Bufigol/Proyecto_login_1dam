/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete_principal;

/**
 *
 * @author 21414215
 */
public interface Int_Controlador {

	public void setModelo(Modelo modelo);

	public void setVis_LogIn(Vis_Login LogIn);

	public void setVis_Registro(Vis_Registro Registro);

	public void setVis_Bienvenida(Vis_Bienvenida Bienvenida);

	public void LogIn_A_Bienvenido();

	public void Ir_A_Registro();

	public void Registro_A_Bienvenido();

	public void Cerrar();

	public void cancelar_Registro();

	public void set_Datos_en_modelo();

	/**
	 * Metodo que comprueba los errores que hay en el registro para mostrar un
	 * mensaje por cada posibilidad de error que se tiene implementada.
	 */
	public void informar_errores_registro();

	public boolean iniciar_sesion_login();

	public boolean registrar_nuevo_usuario();

}