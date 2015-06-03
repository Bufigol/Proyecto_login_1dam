/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete_principal;

import java.awt.Window;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import java.awt.Rectangle;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 *
 * @author 21414215
 */
public class Vis_Login extends JFrame implements Int_Login {
	private JFrame frame;
	private JButton btnLogIn;
	private JButton btnSingUp;
	private JButton btnExit;
	private JLabel lblUsuario;
	private JLabel lblPassword;
	private JPasswordField pswIngresoPassword;
	private JTextField txtIngresoUsuario;
	private Modelo modelo;
	private Controlador controlador;
	private JLabel lblErrores;

	/**
	 * 
	 * @param modelo
	 * @param controlador
	 */
	public Vis_Login() {
		setResizable(false);
		setPreferredSize(new Dimension(350, 300));
		setBounds(new Rectangle(0, 0, 350, 300));
		setSize(new Dimension(600, 278));
		setTitle("Log In");
		initComponents();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed"
	// desc="Generated Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		pack();

		lblUsuario = new JLabel("User Name:");

		txtIngresoUsuario = new JTextField();
		txtIngresoUsuario.setColumns(10);

		lblPassword = new JLabel("Password:");

		pswIngresoPassword = new JPasswordField();

		btnLogIn = new JButton("Log In");
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Prueba de etrada a login");
				if (controlador.iniciar_sesion_login()
						&& (!pswIngresoPassword.getText().isEmpty())
						&& (!txtIngresoUsuario.getText().isEmpty())) {
					controlador.LogIn_A_Bienvenido();
				} else {
					lblErrores.setText("Error");
				}

			}
		});

		btnSingUp = new JButton("Sign Up");
		btnSingUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.Ir_A_Registro();
			}
		});

		btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.Cerrar();
			}
		});

		lblErrores = new JLabel("  ");
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout
				.setHorizontalGroup(groupLayout
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								groupLayout
										.createSequentialGroup()
										.addGap(44)
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.LEADING)
														.addComponent(
																lblErrores)
														.addGroup(
																groupLayout
																		.createSequentialGroup()
																		.addComponent(
																				btnLogIn)
																		.addPreferredGap(
																				ComponentPlacement.UNRELATED)
																		.addComponent(
																				btnSingUp)
																		.addPreferredGap(
																				ComponentPlacement.UNRELATED)
																		.addComponent(
																				btnExit))
														.addGroup(
																groupLayout
																		.createSequentialGroup()
																		.addGroup(
																				groupLayout
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addComponent(
																								lblUsuario,
																								GroupLayout.PREFERRED_SIZE,
																								63,
																								GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								lblPassword))
																		.addGap(18)
																		.addGroup(
																				groupLayout
																						.createParallelGroup(
																								Alignment.LEADING,
																								false)
																						.addComponent(
																								pswIngresoPassword)
																						.addComponent(
																								txtIngresoUsuario,
																								GroupLayout.DEFAULT_SIZE,
																								141,
																								Short.MAX_VALUE))))
										.addContainerGap(78, Short.MAX_VALUE)));
		groupLayout
				.setVerticalGroup(groupLayout
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								groupLayout
										.createSequentialGroup()
										.addGap(45)
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																lblUsuario)
														.addComponent(
																txtIngresoUsuario,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addGap(18)
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																lblPassword)
														.addComponent(
																pswIngresoPassword,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addGap(19)
										.addComponent(lblErrores)
										.addGap(18)
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(btnLogIn)
														.addComponent(btnSingUp)
														.addComponent(btnExit))
										.addContainerGap(94, Short.MAX_VALUE)));
		getContentPane().setLayout(groupLayout);

	}// </editor-fold>//GEN-END:initComponents

	@Override
	public void setControlador(Controlador controlador) {
		// TODO Auto-generated method stub
		this.controlador = controlador;
	}

	@Override
	public void setModelo(Modelo modelo) {
		// TODO Auto-generated method stub
		this.modelo = modelo;
	}

	@Override
	public String getUsuario() {
		// TODO Auto-generated method stub
		return this.txtIngresoUsuario.getText().toString();
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.pswIngresoPassword.getText().toString();
	}

	public JLabel getLblErrores() {
		return this.lblErrores;
	}
}
