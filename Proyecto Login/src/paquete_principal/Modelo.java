package paquete_principal;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.table.DefaultTableModel;

public class Modelo implements Int_Modelo {
	private Vis_Bienvenida bienvenida;
	private Vis_Login login;
	private Vis_Registro registro;

	// Los siguientes datos los pasa el controlador
	private String nombre_registro;
	private String password_registro;
	private String repetir_password_registro;
	private String usuario;
	private String password_login;
	private String mail_registro;
	// Listas para el trabajo de datos de manera local
	private Map<String, String> listaUsuarios;

	// Conexion con la base de datos
	private String url_conexion_BD;
	private Connection conexion_BD;
	private String Usuario_BD;
	private String password_BD;
	private Statement stmt_BD;

	/**
	 * @param bienvenida
	 * @param login
	 * @param registro
	 * @param url_conexion_BD
	 * @param conexion_BD
	 * @param usuario_BD
	 * @param password_BD
	 */
	public Modelo(Vis_Bienvenida bienvenida, Vis_Login login,
			Vis_Registro registro, String usuario_BD, String password_BD) {
		this.bienvenida = bienvenida;
		this.login = login;
		this.registro = registro;
		this.url_conexion_BD = "jdbc:oracle:thin:@localhost:1521:XE";
		conexion_BD(usuario_BD, password_BD);
		this.listaUsuarios = new HashMap<String, String>();
		importar_usuarios_y_passwords();
		agregar_datos_tabla();

	}

	public void conexion_BD(String Usuario, String password) {
		try {
			this.Usuario_BD = Usuario;
			this.password_BD = password;
			Class.forName("oracle.jdbc.driver.OracleDriver");
			this.conexion_BD = DriverManager.getConnection(
					this.url_conexion_BD, this.Usuario_BD, this.password_BD);
			this.stmt_BD = conexion_BD.createStatement();
			System.out.println(" - Conexión con ORACLE ABIERTA -");
		} catch (Exception e) {
			System.out.println(" – Error de Conexión con ORACLE-");
			e.printStackTrace();
		}
	}

	/**
	 * @return the bienvenida
	 */
	public Vis_Bienvenida getBienvenida() {
		return bienvenida;
	}

	/**
	 * @param bienvenida
	 *            the bienvenida to set
	 */
	public void setBienvenida(Vis_Bienvenida bienvenida) {
		this.bienvenida = bienvenida;
	}

	/**
	 * @return the login
	 */
	public Vis_Login getLogin() {
		return login;
	}

	/**
	 * @param login
	 *            the login to set
	 */
	public void setLogin(Vis_Login login) {
		this.login = login;
	}

	/**
	 * @return the registro
	 */
	public Vis_Registro getRegistro() {
		return registro;
	}

	/**
	 * @param registro
	 *            the registro to set
	 */
	public void setRegistro(Vis_Registro registro) {
		this.registro = registro;
	}

	/**
	 * @return the nombre_registro
	 */
	public String getNombre_registro() {
		return nombre_registro;
	}

	/**
	 * @param nombre_registro
	 *            the nombre_registro to set
	 */
	public void setNombre_registro(String nombre_registro) {
		this.nombre_registro = nombre_registro;
	}

	/**
	 * @return the password_registro
	 */
	public String getPassword_registro() {
		return password_registro;
	}

	/**
	 * @param password_registro
	 *            the password_registro to set
	 */
	public void setPassword_registro(String password_registro) {
		this.password_registro = password_registro;
	}

	/**
	 * @return the repetir_password_registro
	 */
	public String getRepetir_password_registro() {
		return repetir_password_registro;
	}

	/**
	 * @param repetir_password_registro
	 *            the repetir_password_registro to set
	 */
	public void setRepetir_password_registro(String repetir_password_registro) {
		this.repetir_password_registro = repetir_password_registro;
	}

	/**
	 * @return the usuario
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario
	 *            the usuario to set
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return the password_login
	 */
	public String getPassword_login() {
		return password_login;
	}

	/**
	 * @param password_login
	 *            the password_login to set
	 */
	public void setPassword_login(String password_login) {
		this.password_login = password_login;
	}

	/**
	 * @return the mail_registro
	 */
	public String getMail_registro() {
		return mail_registro;
	}

	/**
	 * @param mail_registro
	 *            the mail_registro to set
	 */
	public void setMail_registro(String mail_registro) {
		this.mail_registro = mail_registro;
	}

	@Override
	public void setVis_Login(Vis_Login login) {
		this.login = login;
	}

	@Override
	public void setVis_Registro(Vis_Registro registro) {
		this.registro = registro;
	}

	@Override
	public void setVis_Bienvenida(Vis_Bienvenida bienvenida) {
		this.bienvenida = bienvenida;
	}

	public boolean comprobar_password_registro() {
		String contraseña = this.registro.getTxF_Pass();
		String repetir = this.registro.getTxF_RepPass();
		if (contraseña.equals(repetir)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Metodo utilizado para comprobar que el nombre y la contraseña ingresada
	 * en Vis_LogIn son iguales
	 */
	public boolean comprobar_Pasword_login() {
		String usuario = this.login.getUsuario();
		String password = this.login.getPassword();
		if (!this.listaUsuarios.isEmpty()) {
			if ((!usuario.isEmpty()) && (!password.isEmpty())) {
				if (this.listaUsuarios.get(usuario).toString().equals(password)) {
					return true;
				} else {
					return false;
				}
			} else {
				return false;
			}
		} else {
			return false;
		}

	}

	public boolean comprobar_password_longitud() {
		int longitud = this.password_registro.length();
		if ((longitud > 8) && (longitud < 60)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean comprobar_longitud_Usuario() {
		int longitud = this.usuario.length();
		if ((longitud > 0) && (longitud <= 30)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void registrar_usuario_tabla() {
		String procedimiento = "{call PROYECTO_LOGIN.INSERTADO_DATOS_REGISTRO (?,?,?,?)}";
		try {
			CallableStatement insertado = conexion_BD
					.prepareCall(procedimiento);
			String usuario = this.usuario;
			String nombre = this.nombre_registro;
			String mail = this.mail_registro;
			String password = this.password_registro;
			insertado.setString(1, usuario);
			insertado.setString(2, nombre);
			insertado.setString(3, mail);
			insertado.setString(4, password);
			insertado.execute();
			insertado.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private boolean buscar_espacios() {
		boolean salida = true;
		int letra = 0;
		Character paso;
		if (this.mail_registro.length() > 0) {
			do {
				paso = this.mail_registro.charAt(letra);
				if (paso.toString().equals(" ")) {
					salida = false;
				}
				letra++;
			} while (salida && (letra < this.mail_registro.length()));
		} else {
			salida = false;
		}

		return salida;
	}

	private boolean solo_una_arroba() {
		boolean salida = true;
		Character arroba = "@".charAt(0);
		if (this.mail_registro.length() > 0) {
			int contador = 0;
			for (int i = 0; i < this.mail_registro.length(); i++) {
				if (this.mail_registro.charAt(i) == arroba) {
					contador++;
				}
			}
			if (contador != 1) {
				salida = false;
			} else {
				salida = true;
			}
		} else {
			salida = false;
		}
		return salida;
	}

	private boolean puntos_despues() {
		boolean salida = false;
		if (solo_una_arroba() && (this.mail_registro.length() > 0)) {
			int inicio = this.mail_registro.indexOf("@".charAt(0));
			int contador = 0;
			Character punto = ".".charAt(0);
			for (int i = inicio; i < this.mail_registro.length(); i++) {
				if (punto.equals(this.mail_registro.charAt(i))) {
					contador++;
				}
			}
			if (contador == 1) {
				salida = true;
			} else {
				salida = false;
			}
		}
		return salida;
	}

	@Override
	public boolean comprobar_correo_registro() {
		boolean salida = false;
		if (buscar_espacios() && puntos_despues()
				&& (this.mail_registro.length() > 0)) {
			salida = true;
		} else {
			salida = false;
		}
		return salida;
	}

	@Override
	public boolean comprobar_ingreso_nombre() {
		String nombre = this.nombre_registro;
		int longitud = nombre.length();
		if ((longitud > 0) && (longitud < 100)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean comprobar_ingreso_usuario() {
		// TODO Auto-generated method stub
		boolean salida;
		if (!this.listaUsuarios.containsKey(this.usuario)) {
			salida = true;
		} else {
			salida = false;
		}
		return salida;
	}

	@Override
	public void importar_usuarios_y_passwords() {
		// TODO Auto-generated method stub
		try {
			Statement stmt = conexion_BD.createStatement();
			ResultSet resultados = stmt
					.executeQuery("SELECT USUARIO , PASSWORD FROM PROYECTO_LOGIN.USUARIOS_REGISTRADOS");
			while (resultados.next()) {
				this.listaUsuarios.put(resultados.getString(1).toString(),
						resultados.getString(2).toString());
			}
			resultados.close();
			stmt.close();
		} catch (SQLException s) {
			s.printStackTrace();
		}
	}

	// mostrar registros de la tabla Edificios

	@Override
	public boolean todos_campos_ingresados_registro() {
		int longitud_usuario = this.usuario.length();
		int longitud_nombre = this.nombre_registro.length();
		int longitud_pass = this.password_registro.length();
		int longitud_rep_pass = this.repetir_password_registro.length();
		int longitud_mail = this.mail_registro.length();

		if ((longitud_usuario > 0) && (longitud_nombre > 0)
				&& (longitud_pass > 0) && (longitud_rep_pass > 0)
				&& (longitud_mail > 0)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean comprobacion_completa_password_registro() {
		// TODO Auto-generated method stub
		if (comprobar_password_registro() && comprobar_password_longitud()) {
			return true;
		} else {
			return false;
		}

	}

	@Override
	public boolean comprobacion_completa_usuario() {
		if (comprobar_ingreso_usuario() && comprobar_longitud_Usuario()) {
			return true;
		} else {
			return false;
		}

	}

	@Override
	public void insertar_dato_edificio(String NOMBRE_ingreso,
			String PAIS_ingreso, String CIUDAD_ingreso,
			String ARQUITECTO_ingreso, String LOCALIZACION_ingreso) {
		String procedimiento = "{call PROYECTO_LOGIN.INSERTADO_DATOS_EDIFICIO (?,?,?,?,?)}";
		try {
			CallableStatement insertado = conexion_BD
					.prepareCall(procedimiento);
			insertado.setString(1, NOMBRE_ingreso);
			insertado.setString(2, PAIS_ingreso);
			insertado.setString(3, CIUDAD_ingreso);
			insertado.setString(4, ARQUITECTO_ingreso);
			insertado.setString(5, LOCALIZACION_ingreso);
			insertado.execute();
			insertado.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void actualizar_dato_edificio(String NOMBRE_ORIGINAL,
			String NOMBRE_ingreso, String PAIS_ingreso, String CIUDAD_ingreso,
			String ARQUITECTO_ingreso, String LOCALIZACION_ingreso) {
		// TODO Auto-generated method stub
		String procedimiento = "{call PROYECTO_LOGIN.ACTUALIZAR_DATO_EDIFICIO (?,?,?,?,?,?)}";
		try {
			CallableStatement actualizar = conexion_BD
					.prepareCall(procedimiento);
			actualizar.setString(1, NOMBRE_ORIGINAL);
			actualizar.setString(2, NOMBRE_ingreso);
			actualizar.setString(3, PAIS_ingreso);
			actualizar.setString(4, CIUDAD_ingreso);
			actualizar.setString(5, ARQUITECTO_ingreso);
			actualizar.setString(6, LOCALIZACION_ingreso);
			actualizar.execute();
			actualizar.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void borrar_dato_edificio(String NOMBRE_ORIGINAL) {
		// TODO Auto-generated method stub
		String procedimiento = "{call PROYECTO_LOGIN.BORRAR_EDIFICIO (?)}";
		try {
			CallableStatement borrado = conexion_BD.prepareCall(procedimiento);
			borrado.setString(1, NOMBRE_ORIGINAL);
			borrado.execute();
			borrado.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void agregar_datos_tabla() {
		try {
			DefaultTableModel model = (DefaultTableModel) this.bienvenida
					.getTblEdificios().getModel();
			Statement stmt = conexion_BD.createStatement();
			ResultSet resultados = stmt
					.executeQuery("SELECT * FROM PROYECTO_LOGIN.EDIFICIOS");
			while (resultados.next()) {
				model.addRow(new Object[] { resultados.getString(1),
						resultados.getString(2), resultados.getString(3),
						resultados.getString(4), resultados.getString(5) });
			}
			resultados.close();
			stmt.close();
		} catch (SQLException s) {
			s.printStackTrace();
		}
	}

	public void Cerrarconexion() {
		try {
			conexion_BD.close();
			System.out.println(" - Conexión con ORACLE CERRADA -");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(" – Error de al Cerrar la Conexión con ORACLE-");
		}
	}

	public void agregar_datos_usuaionuevo_local(String Usuario,
			String Contraseña) {
		this.listaUsuarios.put(Usuario, Contraseña);
	}
}
