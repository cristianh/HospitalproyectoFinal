package eam.desarollo.hospital.vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import eam.desarrollo.hospital.DAO.DAOCamas;
import eam.desarrollo.hospital.DAO.DAOHabitacion;
import eam.desarrollo.hospital.controladores.controladorCama;
import eam.desarrollo.hospital.controladores.controladorHabitacion;
import eam.desarrollo.hospital.entidades.Cama;
import eam.desarrollo.hospital.entidades.Habitacion;

import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class VentanaHabitacion {

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaHabitacion window = new VentanaHabitacion();
					window.frmHabitacion.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VentanaHabitacion() throws Exception{
		initialize();
		micontroladorhabitacion = new controladorHabitacion(this);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmHabitacion = new JFrame();
		frmHabitacion.setBounds(100, 100, 432, 277);
		frmHabitacion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmHabitacion.getContentPane().setLayout(null);
		
		JLabel lblId = new JLabel("ID ");
		lblId.setBounds(10, 22, 33, 19);
		frmHabitacion.getContentPane().add(lblId);
		
		
		JTFId.setBounds(33, 21, 86, 20);
		frmHabitacion.getContentPane().add(JTFId);
		JTFId.setColumns(10);
		
		JLabel lblDes = new JLabel("DESCRIPCION");
		lblDes.setBounds(10, 52, 69, 14);
		frmHabitacion.getContentPane().add(lblDes);
		
		
		TPDescripcion.setBounds(10, 77, 336, 57);
		frmHabitacion.getContentPane().add(TPDescripcion);
		
		JLabel lblConsultorio = new JLabel("CONSULTORIO");
		lblConsultorio.setBounds(146, 24, 86, 14);
		frmHabitacion.getContentPane().add(lblConsultorio);
		
		JCBConsultorio.setModel(new DefaultComboBoxModel(new String[] {"SELECIONE"}));
		JCBConsultorio.setBounds(234, 21, 112, 20);
		frmHabitacion.getContentPane().add(JCBConsultorio);
		
		
		btnRegistrar.setBounds(0, 160, 103, 23);
		frmHabitacion.getContentPane().add(btnRegistrar);
		
		
		btnBuscar.setBounds(108, 160, 89, 23);
		frmHabitacion.getContentPane().add(btnBuscar);
		
		
		btnModificar.setBounds(207, 160, 100, 23);
		frmHabitacion.getContentPane().add(btnModificar);
		
		
		btnEliminar.setBounds(317, 160, 89, 23);
		frmHabitacion.getContentPane().add(btnEliminar);
	}
	public JFrame frmHabitacion;
	public JButton btnRegistrar= new JButton("REGISTRAR");
	public JButton btnBuscar= new JButton("BUSCAR");
	public JButton btnEliminar = new JButton("ELIMINAR");
	public JButton btnModificar = new JButton("ACTUALIZAR");
	public JComboBox JCBConsultorio = new JComboBox();
	public JTextField JTFId = new JTextField();
	public JTextPane TPDescripcion = new JTextPane();
	public controladorHabitacion micontroladorhabitacion ;
	public DAOHabitacion MidaoHabitacion = new DAOHabitacion();
	public Habitacion nueva_habitacion = null;
}
