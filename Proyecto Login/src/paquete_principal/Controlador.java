package paquete_principal;

public class Controlador extends javax.swing.JFrame implements Int_Controlador {
	private Vis_Bienvenida Bienvenida;
	private Vis_Login LogIn;
	private Vis_Registro Registro;
	private Modelo modelo;

	@Override
	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}

	@Override
	public void setVis_LogIn(Vis_Login LogIn) {
		this.LogIn = LogIn;
	}

	@Override
	public void setVis_Registro(Vis_Registro Registro) {
		this.Registro = Registro;
	}

	@Override
	public void setVis_Bienvenida(Vis_Bienvenida Bienvenida) {
		this.Bienvenida = Bienvenida;
	}

	@Override
	public boolean iniciar_sesion_login() {
		// TODO Auto-generated method stub
		if (this.modelo.comprobar_Pasword_login()) {
			System.out.println("Entro a la bienvenida");
			return true;
		} else {
			return false;
		}
	}

	public void LogIn_A_Bienvenido() {
		this.LogIn.setVisible(false);
		this.Bienvenida.setVisible(true);
		this.Bienvenida.getFrmWelcome().setVisible(true);
	}

	/**
	 * Btn Registarse en ventana de Login: modificado el parametro para que
	 * cambie de false a true la ventana de Bienvenida y pasa a false la ventana
	 * de Login
	 */
	public void Ir_A_Registro() {
		this.LogIn.setVisible(false);
		this.Registro.setVisible(true);
	}

	/**
	 * Btn Registro en ventana de Registrarse: Pasa la ventana de Registrarse a
	 * false y abre ventana de Bienvenida poniendola en true
	 */
	public void Registro_A_Bienvenido() {
		this.Registro.setVisible(false);
		this.Bienvenida.setVisible(true);
		this.Bienvenida.getFrmWelcome().setVisible(true);
	}

	/**
	 * MÃ©todo aplicable a botones de cerrar ventanas
	 */
	@Override
	public void Cerrar() {
		System.exit(0);
	}

	public void cancelar_Registro() {
		Registro.setVisible(false);
		LogIn.setVisible(true);
	}

	@Override
	public boolean registrar_nuevo_usuario() {
		// TODO Auto-generated method stub
		set_Datos_en_modelo();
		if (this.modelo.comprobar_password_registro()
				&& this.modelo.comprobar_ingreso_nombre()
				&& this.modelo.comprobar_ingreso_usuario()) {
			this.modelo.registrar_usuario_tabla();
			return true;
		} else {
			cambiar_LblError_registro();
			return false;
		}
	}

	@Override
	public void set_Datos_en_modelo() {
		// TODO Auto-generated method stub
		this.modelo
				.setPassword_registro(this.Registro.getTxF_Pass().toString());
		this.modelo.setRepetir_password_registro(this.Registro.getTxF_RepPass()
				.toString());
		this.modelo.setMail_registro(this.Registro.getTxF_Correo().toString());
		this.modelo
				.setNombre_registro(this.Registro.getTxF_Nombre().toString());
		this.modelo.setUsuario(this.Registro.getTxF_Usuario().toString());
	}

	public void cambiar_LblError_registro() {
		if (!this.modelo.comprobar_password_registro()) {
			this.Registro.setLblErrores("Las contraseñas no coinciden");
		} else {
			if (this.modelo.comprobar_password_longitud()) {

			} else {
				if (!this.modelo.comprobar_ingreso_nombre()) {
					if (this.modelo.getNombre_registro().length() == 0) {
						this.Registro.setLblErrores("Debe ingresar un nombre");
					}
					if (this.modelo.getNombre_registro().length() > 100) {
						this.Registro
								.setLblErrores("El nombre ingresado es demasiado largo");
					}
				} else {

				}
			}

		}

	}
}
