package eam.desarollo.hospital.vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

import eam.desarrollo.hospital.controladores.controladorDiagnostico;
import eam.desarrollo.hospital.controladores.controladorFormula;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class VentanaFormula {

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaFormula window = new VentanaFormula();
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
	public VentanaFormula() {
		initialize();
		micontroladorformula=new controladorFormula(this);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 429, 291);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblId.setBounds(10, 35, 30, 14);
		frame.getContentPane().add(lblId);
		
		
		JTFID.setBounds(36, 34, 109, 20);
		frame.getContentPane().add(JTFID);
		JTFID.setColumns(10);
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFecha.setBounds(196, 35, 46, 14);
		frame.getContentPane().add(lblFecha);
		
		
		dateChooser.setBounds(244, 34, 159, 20);
		frame.getContentPane().add(dateChooser);
		
		JLabel lblMedico = new JLabel("Medico");
		lblMedico.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMedico.setBounds(10, 75, 53, 14);
		frame.getContentPane().add(lblMedico);
		
		JCBMedico.setModel(new DefaultComboBoxModel(new String[] {"SELECIONE"}));
		JCBMedico.setBounds(73, 74, 330, 20);
		frame.getContentPane().add(JCBMedico);
		
		JLabel lblPaciente = new JLabel("Paciente");
		lblPaciente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPaciente.setBounds(10, 111, 53, 14);
		frame.getContentPane().add(lblPaciente);
		
		JCBPaciente.setModel(new DefaultComboBoxModel(new String[] {"SELECIONE"}));
		JCBPaciente.setBounds(73, 110, 330, 20);
		frame.getContentPane().add(JCBPaciente);
		
		
		btnRegistrar.setBounds(10, 156, 89, 23);
		frame.getContentPane().add(btnRegistrar);
		
		
		btnBuscar.setBounds(109, 156, 89, 23);
		frame.getContentPane().add(btnBuscar);
		
		
		btnActualizar.setBounds(208, 156, 102, 23);
		frame.getContentPane().add(btnActualizar);
		
		
		btnEliminar.setBounds(314, 156, 89, 23);
		frame.getContentPane().add(btnEliminar);
	}
	
	private JFrame frame;
	public JTextField JTFID = new JTextField();
	public JDateChooser dateChooser = new JDateChooser();
	public JComboBox JCBMedico = new JComboBox();
	public JComboBox JCBPaciente = new JComboBox();
	public JButton btnRegistrar = new JButton("REGISTRAR");
	public JButton btnBuscar = new JButton("BUSCAR");
	public JButton btnActualizar = new JButton("ACTUALIZAR");
	public JButton btnEliminar = new JButton("ELIMINAR");
	public controladorFormula micontroladorformula;
	
	
}
