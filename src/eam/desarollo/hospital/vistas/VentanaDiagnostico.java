package eam.desarollo.hospital.vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import eam.desarrollo.hospital.controladores.controladorDiagnostico;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Font;

public class VentanaDiagnostico {

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaDiagnostico window = new VentanaDiagnostico();
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
	public VentanaDiagnostico() {
		initialize();
		micontroladordiagnostico = new controladorDiagnostico(this);
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 416, 341);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 27, 28, 14);
		frame.getContentPane().add(lblNewLabel);
		
		
		JTFID.setBounds(47, 24, 86, 20);
		frame.getContentPane().add(JTFID);
		JTFID.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(155, 27, 66, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		
		JTFNombre.setBounds(231, 24, 159, 20);
		frame.getContentPane().add(JTFNombre);
		JTFNombre.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Descripcion");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(8, 94, 80, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		
		JTPDescripcion.setBounds(86, 72, 304, 66);
		frame.getContentPane().add(JTPDescripcion);
		
		JLabel lblNewLabel_3 = new JLabel("Medico");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(10, 164, 57, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		JCBMedico.setModel(new DefaultComboBoxModel(new String[] {"SELECIONE"}));
		JCBMedico.setBounds(77, 161, 313, 20);
		frame.getContentPane().add(JCBMedico);
		
		JLabel lblPaciente = new JLabel("Paciente");
		lblPaciente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPaciente.setBounds(10, 215, 57, 14);
		frame.getContentPane().add(lblPaciente);
		
		JCBPaciente.setModel(new DefaultComboBoxModel(new String[] {"SELECIONE"}));
		JCBPaciente.setBounds(77, 212, 313, 20);
		frame.getContentPane().add(JCBPaciente);
		
		
		Registrar.setBounds(10, 268, 89, 23);
		frame.getContentPane().add(Registrar);
		
		
		Buscar.setBounds(109, 268, 89, 23);
		frame.getContentPane().add(Buscar);
		
		
		Eliminar.setBounds(208, 268, 89, 23);
		frame.getContentPane().add(Eliminar);
		
		
		Actualizar.setBounds(307, 268, 89, 23);
		frame.getContentPane().add(Actualizar);
	}
	private JFrame frame;
	public JTextField JTFID= new JTextField();
	public JTextField JTFNombre= new JTextField();
	public JButton Registrar = new JButton("Registrar");
	public JButton Buscar = new JButton("Buscar");
	public JButton Eliminar = new JButton("Eliminar");
	public JButton Actualizar = new JButton("Actualizar");
	public JComboBox JCBPaciente = new JComboBox();
	public JComboBox JCBMedico = new JComboBox();
	public JTextPane JTPDescripcion = new JTextPane();
	public controladorDiagnostico micontroladordiagnostico;
	
}
