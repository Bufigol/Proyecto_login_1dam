package paquete_principal;

import java.sql.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Modelo implements Int_Modelo {
	private Vis_Bienvenida bienvenida;
	private Vis_Login login;
	private Vis_Registro registro;
	private String nombre_registro;
	private String password_registro;
	private String repetir_password_registro;
	private String usuario;
	private String password_login;
	private String mail_registro;
	// patron para comprobar que el correo electronico esta bien ingresado
	private static final String PATTERN_EMAIL = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

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
		if (usuario.equals(password)) {
			return true;
		} else {
			return false;
		}

	}

	@Override
	public void registrar_usuario_tabla() {
		// TODO Auto-generated method stub
		try {
			Statement stmt = conexion_BD.createStatement();
			String sentenciaINSERT = "";
			ResultSet rset = stmt.executeQuery(sentenciaINSERT);
			rset.close();
			stmt.close();
		} catch (SQLException s) {
			s.printStackTrace();
		}
	}

	@Override
	public boolean comprobar_correo_registro() {
		// TODO Auto-generated method stub
		// Se "compila" el patron para poder compararlo con algo
		Pattern patron_correo = Pattern.compile(PATTERN_EMAIL);
		// Match the given input against this pattern
		Matcher comprobador = patron_correo.matcher(this.mail_registro);
		return comprobador.matches();
	}
}
