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
				&& this.modelo.comprobar_ingreso_usuario()
				&& this.modelo.todos_campos_ingresados_registro()) {
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
		if (!this.modelo.todos_campos_ingresados_registro()) {
			// comprobaciones de contraseña
			if (!this.modelo.comprobacion_completa_password_registro()) {
				this.Registro.setLblErrores(comprobaciones_contraseña());
			} else {
				if (!this.modelo.comprobacion_completa_usuario()) {
					this.Registro.setLblErrores(comprobaciones_usuario());
				}
			}
		}

	}

	@Override
	public String comprobaciones_contraseña() {
		// TODO Auto-generated method stub
		if (!modelo.comprobar_password_registro()) {
			return "Las contraseñas no coinciden";
		} else {
			if (modelo.comprobar_password_longitud()) {
				return "La contraseña debe ser mayor a 8 caracteres y menor que 30";
			} else {
				return null;
			}
		}

	}

	@Override
	public String comprobaciones_usuario() {
		if (!this.modelo.comprobar_longitud_Usuario()) {
			return "El nombre de usuaio debe ser de una longitud de entre 1 y 30 caracteres";
		} else {
			if (!this.modelo.comprobar_ingreso_usuario()) {
				return "Ese nombre de usuario ya esta registrado";
			} else {
				return null;
			}
		}

	}
}
