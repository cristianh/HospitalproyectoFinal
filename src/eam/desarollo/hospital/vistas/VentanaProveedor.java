package eam.desarollo.hospital.vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import eam.desarrollo.hospital.controladores.controladorProveedor;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaProveedor {

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaProveedor window = new VentanaProveedor();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VentanaProveedor() {
		initialize();
		micontroladorProvedor = new controladorProveedor(this);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblEmpresa = new JLabel("Empresa:");
		lblEmpresa.setBounds(10, 79, 57, 14);
		frame.getContentPane().add(lblEmpresa);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(224, 79, 55, 14);
		frame.getContentPane().add(lblNombre);
		
		JLabel lblDireccion = new JLabel("Direccion:");
		lblDireccion.setBounds(10, 118, 57, 14);
		frame.getContentPane().add(lblDireccion);
		
		JLabel lblTelefono = new JLabel("Telefono:");
		lblTelefono.setBounds(224, 118, 55, 14);
		frame.getContentPane().add(lblTelefono);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(10, 157, 46, 14);
		frame.getContentPane().add(lblEmail);
		
		
		JTFEmpresa.setBounds(77, 76, 137, 20);
		frame.getContentPane().add(JTFEmpresa);
		JTFEmpresa.setColumns(10);
		
		
		JTFNombre.setBounds(289, 76, 123, 20);
		frame.getContentPane().add(JTFNombre);
		JTFNombre.setColumns(10);
		
		
		JTFDireccion.setBounds(77, 115, 137, 20);
		frame.getContentPane().add(JTFDireccion);
		JTFDireccion.setColumns(10);
		
		
		JTFTelefono.setBounds(289, 115, 123, 20);
		frame.getContentPane().add(JTFTelefono);
		JTFTelefono.setColumns(10);
		
		
		JTFEmail.setBounds(77, 154, 137, 20);
		frame.getContentPane().add(JTFEmail);
		JTFEmail.setColumns(10);
		
		
	
		Registrar.setBounds(10, 206, 89, 23);
		frame.getContentPane().add(Registrar);
		
		
		Buscar.setBounds(114, 206, 89, 23);
		frame.getContentPane().add(Buscar);
		
		
		Eliminar.setBounds(236, 206, 89, 23);
		frame.getContentPane().add(Eliminar);
		
		
		Actualizar.setBounds(335, 206, 89, 23);
		frame.getContentPane().add(Actualizar);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setBounds(10, 36, 46, 14);
		frame.getContentPane().add(lblId);
		
		JTFID = new JTextField();
		JTFID.setBounds(77, 33, 137, 20);
		frame.getContentPane().add(JTFID);
		JTFID.setColumns(10);
	}
	private JFrame frame;
	public controladorProveedor micontroladorProvedor;
	
	public JTextField JTFEmpresa= new JTextField();
	public JTextField JTFNombre= new JTextField();
	public JTextField JTFDireccion= new JTextField();
	public JTextField JTFTelefono= new JTextField();
	public JTextField JTFEmail= new JTextField();
	public	JButton Registrar = new JButton("Registrar");
	public	JButton Buscar = new JButton("Buscar");
	public	JButton Eliminar = new JButton("Eliminar");
	public	JButton Actualizar = new JButton("Actualizar");
	public JTextField JTFID = new JTextField();
}
