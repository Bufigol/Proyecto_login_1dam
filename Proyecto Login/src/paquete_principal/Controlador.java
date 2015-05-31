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
			return true;
		} else {
			return false;
		}
	}

	public void LogIn_A_Bienvenido() {
		this.LogIn.setVisible(false);
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
	}

	/**
	 * MÃ©todo aplicable a botones de cerrar ventanas
	 */
	@Override
	public void Cerrar() {
		this.modelo.Cerrarconexion();
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
				&& this.modelo.comprobar_correo_registro()
				&& this.modelo.todos_campos_ingresados_registro()) {
			this.modelo.registrar_usuario_tabla();
			this.modelo.agregar_datos_usuaionuevo_local(
					this.modelo.getUsuario(),
					this.modelo.getPassword_registro());
			return true;
		} else {
			informar_errores_registro();
			borrar_errores_registro();
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

	public void informar_errores_registro() {
		// Si hay errores en el registro se entra en la sentencia if.
		if (!this.modelo.todos_campos_ingresados_registro()) {
			// comprobaciones de usuario
			if (!modelo.comprobacion_completa_password_registro()) {
				if (!modelo.comprobar_password_registro()) {
					this.Registro
							.setLblErroresPassword("Las contraseñas no coinciden.");
				} else {
					if (!modelo.comprobar_password_longitud()) {
						this.Registro
								.setLblErroresPassword("La contraseña debe ser de una longitud de entre 8 y 30 caracteres.");
					} else {
						this.Registro.setLblErroresPassword("");
					}
				}
			}
			// comprobaciones de usuario
			if (!this.modelo.comprobacion_completa_usuario()) {
				if (!this.modelo.comprobar_ingreso_usuario()) {
					this.Registro
							.setLblErroresUsuario("Ese nombre de usuario ya estat registrado.");
				} else {
					if (!this.modelo.comprobar_longitud_Usuario()) {
						this.Registro
								.setLblErroresUsuario("Por favor ingrese un nombre de usuario de hasta 30 caracteres.");
					} else {
						this.Registro.setLblErroresUsuario("");
					}
				}
			}
			// comprobar que se ha ingresado algo en el nombre
			if (!this.modelo.comprobar_ingreso_nombre()) {
				this.Registro
						.setLblErroresNombre("Por favor ingrese su nombre.");
			}
			// comprobacion de correo electronico
			if (!this.modelo.comprobar_correo_registro()) {
				this.Registro
						.setLblErroresCorreo("Por favor ingrese un correo electronico valido.");
			}

		}
	}

	public void borrar_errores_registro() {
		if (!this.modelo.todos_campos_ingresados_registro()) {
			// comprobaciones de usuario
			if (modelo.comprobacion_completa_password_registro()) {
				this.Registro.setLblErroresPassword(".");
			}
			// comprobaciones de usuario
			if (this.modelo.comprobacion_completa_usuario()) {
				this.Registro.setLblErroresUsuario("");
			}
			// comprobar que se ha ingresado algo en el nombre
			if (this.modelo.comprobar_ingreso_nombre()) {
				this.Registro.setLblErroresNombre("");
			}
			// comprobacion de correo electronico
			if (this.modelo.comprobar_correo_registro()) {
				this.Registro.setLblErroresCorreo("");
			}
		}
	}

	public void nuevo_registro_edificio() {
		this.modelo.insertar_dato_edificio(this.Bienvenida.getTxfNombre(),
				this.Bienvenida.getTxfPais(), this.Bienvenida.getTxfCiudad(),
				this.Bienvenida.getTxfArquitecto(),
				this.Bienvenida.getTxfLocalizacion());
	}

	public void baja_edificio() {
		this.modelo.borrar_dato_edificio(this.Bienvenida.getTxfNombre());
	}

	public void actualizacion_edificio() {
		this.modelo.actualizar_dato_edificio(
				this.Bienvenida.getNombreAntiguo(),
				this.Bienvenida.getTxfNombre(), this.Bienvenida.getTxfPais(),
				this.Bienvenida.getTxfCiudad(),
				this.Bienvenida.getTxfArquitecto(),
				this.Bienvenida.getTxfLocalizacion());
	}

	public void Bienvenido_A_Inicio() {
		this.Bienvenida.setVisible(false);
		this.Bienvenida.getFrmWelcome().setVisible(false);
		this.LogIn.setVisible(true);
	}

}
