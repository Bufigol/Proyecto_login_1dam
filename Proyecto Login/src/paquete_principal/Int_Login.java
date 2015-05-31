/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete_principal;

import javax.swing.JLabel;

/**
 *
 * @author 21414215
 */
public interface Int_Login {

	public void setControlador(Controlador controlador);

	public void setModelo(Modelo modelo);

	public String getUsuario();

	public String getPassword();

	public JLabel getLblErrores();
}
