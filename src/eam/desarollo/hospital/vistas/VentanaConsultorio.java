package eam.desarollo.hospital.vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextPane;

import eam.desarrollo.hospital.DAO.DAOConsultorio;
import eam.desarrollo.hospital.controladores.controladorConsultorio;
import eam.desarrollo.hospital.controladores.controladorPaciente;
import eam.desarrollo.hospital.entidades.Consultorio;
import eam.desarrollo.hospital.entidades.EstadoConsultorio;

import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VentanaConsultorio {

	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaConsultorio window = new VentanaConsultorio();
					window.frmConsultorios.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws Exception 
	 */
	public VentanaConsultorio() throws Exception {
		initialize();
		micontroladorconsultorio =  new controladorConsultorio(this);
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmConsultorios = new JFrame();
		frmConsultorios.setTitle("Consultorios");
		frmConsultorios.setBounds(100, 100, 563, 370);
		frmConsultorios.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmConsultorios.getContentPane().setLayout(null);
		
		
		lblConsultorio.setBounds(10, 24, 86, 14);
		frmConsultorios.getContentPane().add(lblConsultorio);
		
		
		lblNewLabel.setBounds(10, 81, 74, 14);
		frmConsultorios.getContentPane().add(lblNewLabel);
		
		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setBounds(214, 21, 46, 14);
		frmConsultorios.getContentPane().add(lblEstado);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"SELECIONE"}));
		
		
		comboBox.setBounds(270, 18, 211, 20);
		frmConsultorios.getContentPane().add(comboBox);
		
		
		
		btnRegistrar.setBounds(38, 298, 89, 23);
		frmConsultorios.getContentPane().add(btnRegistrar);
		
		
		btnBuscar.setBounds(419, 298, 89, 23);
		frmConsultorios.getContentPane().add(btnBuscar);
		
		
		btnActualizar.setBounds(292, 298, 105, 23);
		frmConsultorios.getContentPane().add(btnActualizar);
		
		
		btnEliminar.setBounds(165, 298, 89, 23);
		frmConsultorios.getContentPane().add(btnEliminar);
		
		
		textPane.setBounds(81, 67, 456, 48);
		frmConsultorios.getContentPane().add(textPane);
		JTFConsultorio.setBounds(106, 21, 86, 20);
		frmConsultorios.getContentPane().add(JTFConsultorio);
		JTFConsultorio.setColumns(10);
		JTBConsultorio.setCellSelectionEnabled(true);
		JTBConsultorio.setColumnSelectionAllowed(true);
		
		JTBConsultorio.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id consultorio", "descripcion consultorio", "estado"
			}
		));
		
		
		JTBConsultorio.setBounds(10, 162, 527, 89);
		frmConsultorios.getContentPane().add(JTBConsultorio);
		btnActualizarTabla.setBounds(392, 262, 145, 23);
		
		frmConsultorios.getContentPane().add(btnActualizarTabla);
	}
	
	private JFrame frmConsultorios;
	public JTextField JTFConsultorio = new JTextField();
	public JLabel lblConsultorio = new JLabel("Consultorio");
	public JLabel lblNewLabel = new JLabel("Descripcion");
	public JLabel lblEstado = new JLabel("Estado");
	public JComboBox comboBox = new JComboBox();
	public JButton btnRegistrar = new JButton("Registrar");
	public JButton btnBuscar = new JButton("Buscar");
	public JButton btnActualizar = new JButton("Actualizar");
	public JButton btnEliminar = new JButton("Eliminar");
	public JTextPane textPane = new JTextPane();
	public controladorConsultorio micontroladorconsultorio;
	public DAOConsultorio Midaoconsultorio = new DAOConsultorio();
	public Consultorio nuevo_consultorio = null;
	public EstadoConsultorio estado_consultorio = null;
	public JTable JTBConsultorio = new JTable();
	public JButton btnActualizarTabla = new JButton("Actualizar Tabla");
}
