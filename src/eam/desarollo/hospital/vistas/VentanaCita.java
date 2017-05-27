package eam.desarollo.hospital.vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import com.toedter.calendar.JDateChooser;

import eam.desarrollo.hospital.controladores.controladorCita;
import eam.desarrollo.hospital.controladores.controladorPaciente;

import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.TitledBorder;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.JList;
import javax.swing.JScrollPane;

public class VentanaCita {

	public JFrame frmVentanaCitas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaCita window = new VentanaCita();
					window.frmVentanaCitas.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VentanaCita() {
		initialize();
		micontroladorCita = new controladorCita(this);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmVentanaCitas = new JFrame();
		frmVentanaCitas.setIconImage(Toolkit.getDefaultToolkit().getImage("../Imagenes\\bloc.png"));
		frmVentanaCitas.setTitle("Ventana CItas");
		frmVentanaCitas.setBounds(100, 100, 791, 574);
		frmVentanaCitas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmVentanaCitas.getContentPane().setLayout(null);

		JPanel JpanelPaciente = new JPanel();
		JpanelPaciente.setBorder(
				new TitledBorder(null, "Datos Paciente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		JpanelPaciente.setBounds(21, 83, 361, 247);
		frmVentanaCitas.getContentPane().add(JpanelPaciente);

		JLabel lblPaciente = new JLabel("Id paciente");
		lblPaciente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		JTFIdPaciente.setEditable(false);
		JTFIdPaciente.setColumns(10);

		JLabel lblNewLabel = new JLabel("Nombre ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JTFNombre = new JTextField();
		JTFNombre.setEditable(false);
		JTFNombre.setColumns(10);

		JTFApellido = new JTextField();
		JTFApellido.setEditable(false);
		JTFApellido.setColumns(10);

		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel lblNewLabel_1 = new JLabel("Documento");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JTFDocumentoPaciente = new JTextField();
		JTFDocumentoPaciente.setColumns(10);
		GroupLayout gl_JpanelPaciente = new GroupLayout(JpanelPaciente);
		gl_JpanelPaciente.setHorizontalGroup(
				gl_JpanelPaciente.createParallelGroup(Alignment.TRAILING).addGroup(gl_JpanelPaciente
						.createSequentialGroup().addContainerGap().addGroup(gl_JpanelPaciente
								.createParallelGroup(Alignment.LEADING).addGroup(
										gl_JpanelPaciente.createSequentialGroup()
												.addGroup(gl_JpanelPaciente.createParallelGroup(Alignment.LEADING)
														.addComponent(lblPaciente).addComponent(lblNewLabel)
														.addComponent(lblApellido))
												.addGap(5)
												.addGroup(gl_JpanelPaciente.createParallelGroup(Alignment.LEADING)
														.addComponent(JTFApellido, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addComponent(JTFNombre, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addComponent(JTFIdPaciente, GroupLayout.PREFERRED_SIZE, 183,
																GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_JpanelPaciente.createParallelGroup(Alignment.TRAILING)
										.addComponent(btnBuscarPaciente, GroupLayout.PREFERRED_SIZE, 134,
												GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_JpanelPaciente.createSequentialGroup().addComponent(lblNewLabel_1)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(JTFDocumentoPaciente, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
						.addGap(128)));
		gl_JpanelPaciente.setVerticalGroup(gl_JpanelPaciente.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_JpanelPaciente.createSequentialGroup().addGroup(gl_JpanelPaciente
						.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_JpanelPaciente.createSequentialGroup().addGap(12).addComponent(lblPaciente))
						.addGroup(gl_JpanelPaciente.createSequentialGroup().addContainerGap().addComponent(
								JTFIdPaciente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_JpanelPaciente.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel)
								.addComponent(JTFNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_JpanelPaciente.createParallelGroup(Alignment.BASELINE)
								.addComponent(JTFApellido, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblApellido))
						.addGap(27)
						.addGroup(gl_JpanelPaciente.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_1)
								.addComponent(JTFDocumentoPaciente, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(18).addComponent(btnBuscarPaciente).addContainerGap(36, Short.MAX_VALUE)));
		gl_JpanelPaciente.linkSize(SwingConstants.HORIZONTAL,
				new Component[] { JTFIdPaciente, JTFNombre, JTFApellido, JTFDocumentoPaciente });
		JpanelPaciente.setLayout(gl_JpanelPaciente);
		JpanelMedico.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Medicos",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		JpanelMedico.setBounds(422, 83, 310, 247);

		frmVentanaCitas.getContentPane().add(JpanelMedico);

		GroupLayout gl_JpanelMedico = new GroupLayout(JpanelMedico);
		gl_JpanelMedico.setHorizontalGroup(
				gl_JpanelMedico.createParallelGroup(Alignment.LEADING).addGroup(gl_JpanelMedico.createSequentialGroup()
						.addContainerGap().addComponent(JCBMedico, 0, 278, Short.MAX_VALUE).addContainerGap()));
		gl_JpanelMedico.setVerticalGroup(gl_JpanelMedico.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_JpanelMedico
						.createSequentialGroup().addContainerGap().addComponent(JCBMedico, GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(193, Short.MAX_VALUE)));
		JpanelMedico.setLayout(gl_JpanelMedico);

		JLabel lblNumero = new JLabel("Numero");
		lblNumero.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNumero.setBounds(21, 19, 63, 14);
		frmVentanaCitas.getContentPane().add(lblNumero);
		JTFIdcita.setBounds(79, 18, 69, 20);
		JTFIdcita.setColumns(10);

		frmVentanaCitas.getContentPane().add(JTFIdcita);

		btnRegistrar.setIcon(
				new ImageIcon("C:\\Users\\Casa1\\Documents\\GitHub\\Hospitalproyecto\\Imagenes\\usuario (3).png"));
		btnRegistrar.setBounds(61, 475, 123, 38);
		frmVentanaCitas.getContentPane().add(btnRegistrar);

		btnActualizar.setIcon(
				new ImageIcon("C:\\Users\\Casa1\\Documents\\GitHub\\Hospitalproyecto\\Imagenes\\usuario (1).png"));
		btnActualizar.setBounds(420, 475, 123, 38);
		frmVentanaCitas.getContentPane().add(btnActualizar);

		btnBuscar.setIcon(
				new ImageIcon("C:\\Users\\Casa1\\Documents\\GitHub\\Hospitalproyecto\\Imagenes\\usuario (2).png"));
		btnBuscar.setBounds(244, 475, 116, 38);
		frmVentanaCitas.getContentPane().add(btnBuscar);
		btnEliminar
				.setIcon(new ImageIcon("C:\\Users\\Casa1\\Documents\\GitHub\\Hospitalproyecto\\Imagenes\\usuario.png"));
		btnEliminar.setBounds(603, 475, 112, 39);

		frmVentanaCitas.getContentPane().add(btnEliminar);
		Fecha.setBounds(354, 52, 112, 20);
		frmVentanaCitas.getContentPane().add(Fecha);

		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(313, 53, 36, 17);
		frmVentanaCitas.getContentPane().add(lblFecha);
		lblFecha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		JCBEstado.setBounds(239, 18, 86, 20);
		frmVentanaCitas.getContentPane().add(JCBEstado);

		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setBounds(187, 18, 42, 17);
		frmVentanaCitas.getContentPane().add(lblEstado);
		lblEstado.setFont(new Font("Tahoma", Font.PLAIN, 14));
		JCBConsultorio.setBounds(448, 18, 78, 20);
		frmVentanaCitas.getContentPane().add(JCBConsultorio);

		JLabel lblConsultorio = new JLabel("Consultorio");
		lblConsultorio.setBounds(369, 18, 69, 17);
		frmVentanaCitas.getContentPane().add(lblConsultorio);
		lblConsultorio.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JCBTipo.setBounds(602, 18, 78, 20);
		frmVentanaCitas.getContentPane().add(JCBTipo);

		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setBounds(566, 18, 26, 17);
		frmVentanaCitas.getContentPane().add(lblTipo);
		lblTipo.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel lblHora = new JLabel("Hora");
		lblHora.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHora.setBounds(21, 52, 46, 20);
		frmVentanaCitas.getContentPane().add(lblHora);

		JSPHora1.setModel(new SpinnerListModel(new String[] { "7:00", "7:30", "8:00", "8:30", "9:00", "9:30", "10:00",
				"10:30", "11:00", "11:30", "12:00", "12:30", "13:00", "13:30", "14:00", "14:30", "15:00", "15:30",
				"16:00", "16:30", "17:00", "17:30", "18:00", "18:30" }));
		JSPHora1.setBounds(79, 52, 69, 20);
		frmVentanaCitas.getContentPane().add(JSPHora1);

		JLabel lblA = new JLabel("a");
		lblA.setHorizontalAlignment(SwingConstants.CENTER);
		lblA.setBounds(148, 52, 46, 20);
		frmVentanaCitas.getContentPane().add(lblA);

		JSPHora2.setModel(new SpinnerListModel(new String[] { "7:00", "7:30", "8:00", "8:30", "9:00", "9:30", "10:00",
				"10:30", "11:00", "11:30", "12:00", "12:30", "13:00", "13:30", "14:00", "14:30", "15:00", "15:30",
				"16:00", "16:30", "17:00", "17:30", "18:00", "18:30" }));
		JSPHora2.setBounds(199, 52, 69, 20);
		frmVentanaCitas.getContentPane().add(JSPHora2);
		
		JLabel lblResultadoBusqueda = new JLabel("Resultado busqueda:");
		lblResultadoBusqueda.setBounds(21, 341, 173, 14);
		frmVentanaCitas.getContentPane().add(lblResultadoBusqueda);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 366, 712, 91);
		frmVentanaCitas.getContentPane().add(scrollPane);
		JTBresultado.setFillsViewportHeight(true);
		JTBresultado.setColumnSelectionAllowed(true);
		JTBresultado.setCellSelectionEnabled(true);
		JTBresultado.setEnabled(false);
		scrollPane.setViewportView(JTBresultado);
	}

	public static controladorCita micontroladorCita;
	public JTextField JTFIdPaciente = new JTextField();
	public JButton btnBuscar = new JButton("Buscar");
	public JButton btnActualizar = new JButton("Actualizar");
	public JButton btnRegistrar = new JButton("Registrar");
	public JComboBox JCBTipo = new JComboBox();
	public JDateChooser Fecha = new JDateChooser();
	public JButton btnBuscarPaciente = new JButton("Buscar paciente");
	public JComboBox JCBConsultorio = new JComboBox();
	public JComboBox JCBEstado = new JComboBox();
	public JButton btnEliminar = new JButton("Eliminar");
	public JTextField JTFIdcita = new JTextField();
	public JTextField JTFNombre;
	public JTextField JTFApellido;
	public JTextField JTFDocumentoPaciente;
	private final JPanel JpanelMedico = new JPanel();
	public JSpinner JSPHora2 = new JSpinner();
	public JSpinner JSPHora1 = new JSpinner();
	public JComboBox JCBMedico = new JComboBox();
	public JTable JTBresultado = new JTable();
}
