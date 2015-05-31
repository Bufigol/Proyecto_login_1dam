package paquete_principal;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.FlowLayout;
import java.awt.BorderLayout;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Vis_Bienvenida extends JFrame implements Int_Bienvenida {

	private JFrame frmWelcome;
	private JTable tblEdificios;
	private JButton btnAlta;
	private JButton btnBaja;
	private JButton btnModificacion;
	private JButton btnSalir;
	private JTextField txfNombre;
	private JTextField txfPais;
	private JTextField txfCiudad;
	private JLabel lblMensaje;
	private Modelo modelo;
	private Controlador controlador;
	private JScrollPane scrollPane;
	private JLabel lblNombre;
	private JLabel lblPais;
	private JLabel lblCiudad;
	private JTextField txfArquitecto;
	private JLabel lblArquitecto;
	private JTextField txfLocalizacion;
	private JLabel lblLocalizacion;
	private String NombreAntiguo;

	/**
	 * Create the application.
	 */
	public Vis_Bienvenida() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setFrmWelcome(new JFrame());
		getFrmWelcome().setTitle("Bienvenido");
		getFrmWelcome().setBounds(50, 100, 850, 600);
		getFrmWelcome().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		scrollPane = new JScrollPane();

		scrollPane.setBounds(90, 33, 633, 220);

		tblEdificios = new JTable();
		tblEdificios.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				DefaultTableModel model = (DefaultTableModel) tblEdificios
						.getModel();
				NombreAntiguo = model.getValueAt(tblEdificios.getSelectedRow(),
						0).toString();
				txfNombre.setText(model.getValueAt(
						tblEdificios.getSelectedRow(), 0).toString());
				txfPais.setText(model.getValueAt(tblEdificios.getSelectedRow(),
						1).toString());
				txfCiudad.setText(model.getValueAt(
						tblEdificios.getSelectedRow(), 2).toString());
				txfArquitecto.setText(model.getValueAt(
						tblEdificios.getSelectedRow(), 3).toString());
				txfLocalizacion.setText(model.getValueAt(
						tblEdificios.getSelectedRow(), 3).toString());

			}
		});
		tblEdificios.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Nombre", "Pais", "Ciudad", "Arquitecto",
						"Localizacion" }));
		tblEdificios.getColumnModel().getColumn(0).setPreferredWidth(60);
		scrollPane.setViewportView(tblEdificios);
		getFrmWelcome().getContentPane().setLayout(null);
		getFrmWelcome().getContentPane().add(scrollPane);

		// Btn ALTA

		btnAlta = new JButton("Alta");
		btnAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblMensaje.setText("");
				DefaultTableModel model = (DefaultTableModel) tblEdificios
						.getModel();
				if (!txfNombre.getText().trim().equals("")) {
					model.addRow(new Object[] { txfNombre.getText(),
							txfPais.getText(), txfCiudad.getText() });
					controlador.nuevo_registro_edificio();
				} else {
					lblMensaje.setText("El campo nombre no puede estar vacio");
				}
			}
		});
		btnAlta.setBounds(90, 403, 71, 40);
		getFrmWelcome().getContentPane().add(btnAlta);

		// Btn BAJA

		btnBaja = new JButton("Baja");
		btnBaja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) tblEdificios
						.getModel();
				int fila_selected = tblEdificios.getSelectedRow();
				if (tblEdificios.getSelectedRow() == -1) {
					if (tblEdificios.getRowCount() == 0) {
						lblMensaje.setText("La tabla está vacia");
					} else {
						lblMensaje
								.setText("Seleccione algún registro primero para modificarlo");
					}
				} else {
					model.removeRow(fila_selected);
					controlador.baja_edificio();
				}

			}
		});
		btnBaja.setBounds(317, 403, 71, 40);
		getFrmWelcome().getContentPane().add(btnBaja);

		// Btn MODIFICACIÓN
		btnModificacion = new JButton("Modificación ");
		btnModificacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblMensaje.setText("");
				DefaultTableModel model = (DefaultTableModel) tblEdificios
						.getModel();
				if (tblEdificios.getSelectedRow() == -1) {
					if (tblEdificios.getRowCount() == 0) {
						lblMensaje.setText("La tabla está vacia");
					} else {
						lblMensaje
								.setText("Seleccione algún registro primero para modificarlo");
					}
				}
				model.setValueAt(txfNombre.getText(),
						tblEdificios.getSelectedRow(), 0);
				model.setValueAt(txfPais.getText(),
						tblEdificios.getSelectedRow(), 1);
				model.setValueAt(txfCiudad.getText(),
						tblEdificios.getSelectedRow(), 2);
				model.setValueAt(txfArquitecto.getText(),
						tblEdificios.getSelectedRow(), 3);
				model.setValueAt(txfLocalizacion.getText(),
						tblEdificios.getSelectedRow(), 4);
				controlador.baja_edificio();
			}
		});

		btnModificacion.setBounds(187, 403, 107, 40);
		getFrmWelcome().getContentPane().add(btnModificacion);

		// Btn SALIR
		btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);

			}
		});
		btnSalir.setBounds(629, 479, 125, 50);
		getFrmWelcome().getContentPane().add(btnSalir);

		// Etiequetas y cuadros de Texto
		txfNombre = new JTextField();
		txfNombre.setBounds(90, 347, 112, 33);
		getFrmWelcome().getContentPane().add(txfNombre);
		txfNombre.setColumns(10);

		txfPais = new JTextField();
		txfPais.setColumns(10);
		txfPais.setBounds(212, 347, 112, 33);
		getFrmWelcome().getContentPane().add(txfPais);

		txfCiudad = new JTextField();
		txfCiudad.setColumns(10);
		txfCiudad.setBounds(334, 347, 112, 33);
		getFrmWelcome().getContentPane().add(txfCiudad);

		lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(90, 322, 56, 16);
		getFrmWelcome().getContentPane().add(lblNombre);

		lblPais = new JLabel("Pais");
		lblPais.setBounds(212, 322, 56, 16);
		getFrmWelcome().getContentPane().add(lblPais);

		lblCiudad = new JLabel("Ciudad");
		lblCiudad.setBounds(334, 322, 56, 16);
		getFrmWelcome().getContentPane().add(lblCiudad);

		lblMensaje = new JLabel("");
		lblMensaje.setForeground(Color.RED);
		lblMensaje.setBounds(90, 266, 633, 40);
		getFrmWelcome().getContentPane().add(lblMensaje);

		txfArquitecto = new JTextField();
		txfArquitecto.setBounds(456, 347, 112, 33);
		frmWelcome.getContentPane().add(txfArquitecto);
		txfArquitecto.setColumns(10);

		lblArquitecto = new JLabel("Arquitecto");
		lblArquitecto.setBounds(456, 323, 81, 14);
		frmWelcome.getContentPane().add(lblArquitecto);

		txfLocalizacion = new JTextField();
		txfLocalizacion.setBounds(578, 347, 112, 33);
		frmWelcome.getContentPane().add(txfLocalizacion);
		txfLocalizacion.setColumns(10);

		lblLocalizacion = new JLabel("Localizacion");
		lblLocalizacion.setBounds(578, 323, 112, 14);
		frmWelcome.getContentPane().add(lblLocalizacion);
	}

	public JFrame getFrmWelcome() {
		return frmWelcome;
	}

	public void setFrmWelcome(JFrame frmWelcome) {
		this.frmWelcome = frmWelcome;
	}

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

	/**
	 * @return the tblEdificios
	 */
	public JTable getTblEdificios() {
		return tblEdificios;
	}

	/**
	 * @return the txfNombre
	 */
	public String getTxfNombre() {
		return txfNombre.getText();
	}

	/**
	 * @return the txfPais
	 */
	public String getTxfPais() {
		return txfPais.getText();
	}

	/**
	 * @return the txfCiudad
	 */
	public String getTxfCiudad() {
		return txfCiudad.getText();
	}

	/**
	 * @return the txfArquitecto
	 */
	public String getTxfArquitecto() {
		return txfArquitecto.getText();
	}

	/**
	 * @return the txfLocalizacion
	 */
	public String getTxfLocalizacion() {
		return txfLocalizacion.getText();
	}

	public String getNombreAntiguo() {
		return this.NombreAntiguo;
	}
}