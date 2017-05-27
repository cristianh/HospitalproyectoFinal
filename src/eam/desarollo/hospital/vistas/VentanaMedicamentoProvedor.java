package eam.desarollo.hospital.vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;

import eam.desarrollo.hospital.DAO.DAOMedicamentoProveedor;
import eam.desarrollo.hospital.controladores.controladorMedicamentoProveedor;
import eam.desarrollo.hospital.entidades.MedicamentoProveedor;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class VentanaMedicamentoProvedor {

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaMedicamentoProvedor window = new VentanaMedicamentoProvedor();
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
	public VentanaMedicamentoProvedor() {
		initialize();
		micontroladormedicamentoproveedor= new controladorMedicamentoProveedor(this);
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
		lblId.setBounds(10, 29, 33, 14);
		frame.getContentPane().add(lblId);
		
		
		JTFId.setBounds(34, 28, 105, 20);
		frame.getContentPane().add(JTFId);
		JTFId.setColumns(10);
		
		JLabel lblLote = new JLabel("Lote");
		lblLote.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLote.setBounds(161, 29, 39, 14);
		frame.getContentPane().add(lblLote);
		
		
		JTFLote.setBounds(210, 28, 179, 20);
		frame.getContentPane().add(JTFLote);
		JTFLote.setColumns(10);
		
		JLabel lblMedicamento = new JLabel("Medicamento");
		lblMedicamento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMedicamento.setBounds(10, 75, 92, 14);
		frame.getContentPane().add(lblMedicamento);
		
		JCBMedicamento.setModel(new DefaultComboBoxModel(new String[] {"SELECIONE"}));
		JCBMedicamento.setBounds(100, 74, 289, 20);
		frame.getContentPane().add(JCBMedicamento);
		
		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCantidad.setBounds(10, 118, 76, 14);
		frame.getContentPane().add(lblCantidad);
		
		
		JTFCantidad.setBounds(74, 117, 105, 20);
		frame.getContentPane().add(JTFCantidad);
		JTFCantidad.setColumns(10);
		
		JLabel lblVencimiento = new JLabel("Vencimiento");
		lblVencimiento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblVencimiento.setBounds(189, 120, 76, 14);
		frame.getContentPane().add(lblVencimiento);
		
		
		dateChooser.setBounds(268, 118, 121, 20);
		frame.getContentPane().add(dateChooser);
		
		JLabel lblProveedor = new JLabel("Proveedor");
		lblProveedor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblProveedor.setBounds(10, 162, 76, 14);
		frame.getContentPane().add(lblProveedor);
		
		JCBProveedor.setModel(new DefaultComboBoxModel(new String[] {"SELECIONE"}));
		JCBProveedor.setBounds(100, 161, 289, 20);
		frame.getContentPane().add(JCBProveedor);
		
		
		btnRegistrar.setBounds(10, 208, 89, 23);
		frame.getContentPane().add(btnRegistrar);
		
		
		btnBuscar.setBounds(110, 208, 89, 23);
		frame.getContentPane().add(btnBuscar);
		
		
		btnModificar.setBounds(209, 208, 100, 23);
		frame.getContentPane().add(btnModificar);
		
		
		btnEliminar.setBounds(319, 208, 89, 23);
		frame.getContentPane().add(btnEliminar);
	}
	public JFrame frame ;
	public JTextField JTFId = new JTextField();
	public JTextField JTFLote = new JTextField();
	public JTextField JTFCantidad = new JTextField();
	public JComboBox JCBMedicamento = new JComboBox();
	public JComboBox JCBProveedor = new JComboBox();
	public JDateChooser dateChooser = new JDateChooser();
	public JButton btnRegistrar = new JButton("REGISTRAR");
	public JButton btnBuscar = new JButton("BUSCAR");
	public JButton btnModificar = new JButton("ACTUALIZAR");
	public JButton btnEliminar = new JButton("ELIMINAR");
	public controladorMedicamentoProveedor micontroladormedicamentoproveedor;
	public DAOMedicamentoProveedor midaoMedicamentoProveedor = new DAOMedicamentoProveedor();
	public MedicamentoProveedor nuevo_medicamento_proveedor =null;
}
