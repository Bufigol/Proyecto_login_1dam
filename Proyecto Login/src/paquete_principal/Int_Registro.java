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
public interface Int_Registro {
	public void setControlador(Controlador controlador);

	public void setModelo(Modelo modelo);

	/**
	 * Metodo utiliazdo por el controlador, segun los datos de errores dados por
	 * el modelo que cambian una etiqueta en la pantalla de registro informando
	 * al usuario de que error hay en el registro.
	 * 
	 * @param mensaje
	 *            Parametro que guarda el mensaje a mostrar al usuario.
	 */
	public void setLblErrores(String mensaje);

	public String getTxF_Usuario();

	public String getTxF_Pass();

	public String getTxF_RepPass();

	public String getTxF_Correo();

}
