package paquete_principal;
import javax.swing.table.DefaultTableModel;

import java.awt.FlowLayout;
import java.awt.BorderLayout;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;

public class Vis_VerEdificios extends JFrame implements Int_Bienvenida {

	private JFrame frmWelcome;
	private JTable tblUsuario;
	private JButton btnAlta;
	private JButton btnBaja;
	private JButton btnModificacion;
	private JButton btnSalir;
	private JTextField txfNick;
	private JTextField txfNombre;
	private JTextField txfApellidos;
	private JLabel lblMensaje;
	private Modelo modelo;
	private Controlador controlador;
	private JTable tblEdificio; // nuevo
	ResultSet rs;

	/**
	 * Create the application.
	 */
	public Vis_VerEdificios() {
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

		JScrollPane scrollPane = new JScrollPane();

		scrollPane.setBounds(90, 33, 633, 220);

		tblUsuario = new JTable();

		// Evento mouseClicked sobre registro selecciona toda la fila
		
		tblUsuario.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				DefaultTableModel model = (DefaultTableModel) tblUsuario
						.getModel();
				txfNick.setText(model
						.getValueAt(tblUsuario.getSelectedRow(), 0).toString());
				txfNombre.setText(model.getValueAt(tblUsuario.getSelectedRow(),
						1).toString());
				txfApellidos.setText(model.getValueAt(
						tblUsuario.getSelectedRow(), 2).toString());

			}
		});

		// **********************************************************

		DefaultTableModel dfm = new DefaultTableModel();
		tblEdificio = this.tblEdificio;
		tblEdificio.setModel(dfm);

		dfm.setColumnIdentifiers(new Object[] { "NOMBRE", "PAIS", "CIUDAD",
				"ARQUITECTO", "LOCALIZACION" });
		rs = modelo.SeleccTodosEdificios();
		try {
			while (rs.next()) {
				dfm.addRow(new Object[] { rs.getInt("NOMBRE"),
						rs.getString("PAIS"), rs.getString("CIUDAD"),
						rs.getString("ARQUITECTO"),
						rs.getString("LOCALIZACION") });
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

		// tblUsuario.setModel(new DefaultTableModel(new Object[][] {},
		// new String[] { "Nick", "Nombre", "Apellidos" }));
		// tblUsuario.getColumnModel().getColumn(0).setPreferredWidth(60);
		// scrollPane.setViewportView(tblUsuario);
		// getFrmWelcome().getContentPane().setLayout(null);
		// getFrmWelcome().getContentPane().add(scrollPane);

		// **********************************************************

		// Btn ALTA

		btnAlta = new JButton("Alta");
		btnAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblMensaje.setText("");
				DefaultTableModel model = (DefaultTableModel) tblUsuario
						.getModel();
				if (!txfNick.getText().trim().equals("")) {
					model.addRow(new Object[] { txfNick.getText(),
							txfNombre.getText(), txfApellidos.getText() });
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
				DefaultTableModel model = (DefaultTableModel) tblUsuario
						.getModel();
				int fila_selected = tblUsuario.getSelectedRow();
				if (tblUsuario.getSelectedRow() == -1) {
					if (tblUsuario.getRowCount() == 0) {
						lblMensaje.setText("La tabla está vacia");
					} else {
						lblMensaje
								.setText("Seleccione algún registro primero para modificarlo");
					}
				} else {
					model.removeRow(fila_selected);

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
				DefaultTableModel model = (DefaultTableModel) tblUsuario
						.getModel();
				if (tblUsuario.getSelectedRow() == -1) {
					if (tblUsuario.getRowCount() == 0) {
						lblMensaje.setText("La tabla está vacia");
					} else {
						lblMensaje
								.setText("Seleccione algún registro primero para modificarlo");
					}
				}
				model.setValueAt(txfNick.getText(),
						tblUsuario.getSelectedRow(), 0);
				model.setValueAt(txfNombre.getText(),
						tblUsuario.getSelectedRow(), 1);
				model.setValueAt(txfApellidos.getText(),
						tblUsuario.getSelectedRow(), 2);
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
		txfNick = new JTextField();
		txfNick.setBounds(90, 347, 207, 33);
		getFrmWelcome().getContentPane().add(txfNick);
		txfNick.setColumns(10);

		txfNombre = new JTextField();
		txfNombre.setColumns(10);
		txfNombre.setBounds(303, 347, 207, 33);
		getFrmWelcome().getContentPane().add(txfNombre);

		txfApellidos = new JTextField();
		txfApellidos.setColumns(10);
		txfApellidos.setBounds(516, 347, 207, 33);
		getFrmWelcome().getContentPane().add(txfApellidos);

		JLabel lblNewLabel = new JLabel("Nick");
		lblNewLabel.setBounds(90, 322, 56, 16);
		getFrmWelcome().getContentPane().add(lblNewLabel);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(303, 322, 56, 16);
		getFrmWelcome().getContentPane().add(lblNombre);

		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setBounds(516, 322, 56, 16);
		getFrmWelcome().getContentPane().add(lblApellidos);

		lblMensaje = new JLabel("");
		lblMensaje.setForeground(Color.RED);
		lblMensaje.setBounds(90, 266, 633, 40);
		getFrmWelcome().getContentPane().add(lblMensaje);
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

}