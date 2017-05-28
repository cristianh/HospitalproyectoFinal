package eam.desarollo.hospital.vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import eam.desarrollo.hospital.entidades.Medicamento;
import eam.desarrollo.hospital.DAO.DAOMedicamento;
import eam.desarrollo.hospital.controladores.controladorMedicamento;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class VentanaMedicamento {

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaMedicamento window = new VentanaMedicamento();
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
	public VentanaMedicamento() {
		initialize();
		micontroladormedicamento = new controladorMedicamento(this);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblId.setBounds(10, 26, 36, 14);
		frame.getContentPane().add(lblId);
		
		
		JTFId.setBounds(43, 25, 72, 20);
		frame.getContentPane().add(JTFId);
		JTFId.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombre.setBounds(10, 69, 66, 14);
		frame.getContentPane().add(lblNombre);
		
		
		JTFNombreMedicamento.setBounds(67, 68, 134, 20);
		frame.getContentPane().add(JTFNombreMedicamento);
		JTFNombreMedicamento.setColumns(10);
		
		JLabel lblMarca = new JLabel("Marca");
		lblMarca.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMarca.setBounds(211, 71, 55, 14);
		frame.getContentPane().add(lblMarca);
		
		
		JTFMarcaMedicamento.setBounds(253, 68, 171, 20);
		frame.getContentPane().add(JTFMarcaMedicamento);
		JTFMarcaMedicamento.setColumns(10);
		
		JLabel lblFarmacia = new JLabel("Farmacia");
		lblFarmacia.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFarmacia.setBounds(10, 109, 66, 14);
		frame.getContentPane().add(lblFarmacia);
		
		JCBFarmacia.setModel(new DefaultComboBoxModel(new String[] {"SELECIONE"}));
		JCBFarmacia.setBounds(67, 108, 357, 20);
		frame.getContentPane().add(JCBFarmacia);
		
		
		btnRegistrar.setBounds(10, 167, 89, 23);
		frame.getContentPane().add(btnRegistrar);
		
		
		btnBuscar.setBounds(110, 167, 89, 23);
		frame.getContentPane().add(btnBuscar);
		
		
		btnModificar.setBounds(209, 167, 100, 23);
		frame.getContentPane().add(btnModificar);
		
		
		btnEliminar.setBounds(319, 167, 89, 23);
		frame.getContentPane().add(btnEliminar);
	}
	public JFrame frame;
	public JButton btnRegistrar= new JButton("REGISTRAR");
	public JButton btnBuscar= new JButton("BUSCAR");
	public JButton btnEliminar = new JButton("ELIMINAR");
	public JButton btnModificar = new JButton("ACTUALIZAR");
	public JTextField JTFId = new JTextField();
	public JTextField JTFNombreMedicamento = new JTextField();
	public JTextField JTFMarcaMedicamento = new JTextField();
	public JComboBox JCBFarmacia = new JComboBox();
	public controladorMedicamento micontroladormedicamento;
	public DAOMedicamento midaomedicamento = new DAOMedicamento();
	public Medicamento nuevo_medicamento = null;
}
