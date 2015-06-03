package paquete_principal;

import java.sql.Connection;

import javax.swing.JFrame;

/**
 * Esta clase corresponde al inicio de las interfaces graficas para la
 * interaccion con el usuario. El objetivo de esta clase es inicializar todas
 * las clases, establecer la conexion con la base de datos y dejar como ventana
 * visible para el usuario la correspondiente al inicio de sesion.
 * 
 * @author FelipeAndrés
 *
 */
@SuppressWarnings("serial")
public class Launcher extends JFrame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Controlador controlador = new Controlador();
		Vis_Login PantallaInicial = new Vis_Login();
		Vis_Bienvenida pantallaBienvenida = new Vis_Bienvenida();
		Vis_Registro pantallaRegistro = new Vis_Registro();

		Modelo modelo = new Modelo(pantallaBienvenida, PantallaInicial,
				pantallaRegistro);

		modelo.setVis_Login(PantallaInicial);
		modelo.setVis_Registro(pantallaRegistro);
		modelo.setVis_Bienvenida(pantallaBienvenida);

		controlador.setModelo(modelo);
		controlador.setVis_LogIn(PantallaInicial);
		controlador.setVis_Registro(pantallaRegistro);
		controlador.setVis_Bienvenida(pantallaBienvenida);

		PantallaInicial.setControlador(controlador);
		PantallaInicial.setModelo(modelo);

		pantallaRegistro.setControlador(controlador);
		pantallaRegistro.setModelo(modelo);

		pantallaBienvenida.setControlador(controlador);
		pantallaBienvenida.setModelo(modelo);

		PantallaInicial.setVisible(true);

	}

}
