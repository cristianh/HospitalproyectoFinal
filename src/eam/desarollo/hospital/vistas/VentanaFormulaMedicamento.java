package eam.desarollo.hospital.vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.JButton;

public class VentanaFormulaMedicamento {

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaFormulaMedicamento window = new VentanaFormulaMedicamento();
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
	public VentanaFormulaMedicamento() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 426, 384);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblId.setBounds(30, 22, 32, 14);
		frame.getContentPane().add(lblId);
		
		
		JTFID.setBounds(59, 21, 59, 20);
		frame.getContentPane().add(JTFID);
		JTFID.setColumns(10);
		
		JLabel lblFormula = new JLabel("Formula");
		lblFormula.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFormula.setBounds(128, 24, 59, 14);
		frame.getContentPane().add(lblFormula);
		
		
		JCBFormula.setBounds(183, 21, 185, 20);
		frame.getContentPane().add(JCBFormula);
		
		JLabel lblMedicamento = new JLabel("Medicamento");
		lblMedicamento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMedicamento.setBounds(30, 63, 88, 14);
		frame.getContentPane().add(lblMedicamento);
		
		JComboBox JCBMedicamento = new JComboBox();
		JCBMedicamento.setBounds(128, 62, 240, 20);
		frame.getContentPane().add(JCBMedicamento);
		
		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCantidad.setBounds(30, 102, 59, 14);
		frame.getContentPane().add(lblCantidad);
		
		JTFCantidad = new JTextField();
		JTFCantidad.setBounds(89, 101, 107, 20);
		frame.getContentPane().add(JTFCantidad);
		JTFCantidad.setColumns(10);
		
		JLabel lblDescrpcion = new JLabel("Descripcion");
		lblDescrpcion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDescrpcion.setBounds(30, 136, 81, 20);
		frame.getContentPane().add(lblDescrpcion);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(30, 161, 338, 58);
		frame.getContentPane().add(textPane);
		
		JButton btnRegistrar = new JButton("REGISTRAR");
		btnRegistrar.setBounds(10, 241, 89, 23);
		frame.getContentPane().add(btnRegistrar);
		
		JButton btnBuscar = new JButton("BUSCAR");
		btnBuscar.setBounds(108, 241, 89, 23);
		frame.getContentPane().add(btnBuscar);
		
		JButton btnActualizar = new JButton("ACTUALIZAR");
		btnActualizar.setBounds(202, 241, 107, 23);
		frame.getContentPane().add(btnActualizar);
		
		JButton btnEliminar = new JButton("ELIMINAR");
		btnEliminar.setBounds(319, 241, 89, 23);
		frame.getContentPane().add(btnEliminar);
	}
	public JFrame frame;
	public JTextField JTFID = new JTextField();
	public JTextField JTFCantidad = new JTextField();
	public JComboBox JCBFormula = new JComboBox();
	
}
