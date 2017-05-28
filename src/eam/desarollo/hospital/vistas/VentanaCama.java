package eam.desarollo.hospital.vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import eam.desarrollo.hospital.DAO.DAOCamas;
import eam.desarrollo.hospital.controladores.controladorCama;
import eam.desarrollo.hospital.entidades.Cama;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaCama {




	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaCama window = new VentanaCama();
					window.frmCama.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VentanaCama() throws Exception {
		initialize();
		micontroladorcama =  new controladorCama(this);
	}

	/**
	 * Initialize the contents of the frmCama.
	 */
	private void initialize() {
		frmCama = new JFrame();
		frmCama.setBounds(100, 100, 450, 300);
		frmCama.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCama.getContentPane().setLayout(null);
		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblId.setBounds(10, 26, 27, 14);
		frmCama.getContentPane().add(lblId);
		
		
		JTFId.setBounds(35, 25, 86, 20);
		frmCama.getContentPane().add(JTFId);
		JTFId.setColumns(10);
		
		JLabel lblEstadoCama = new JLabel("ESTADO CAMA");
		lblEstadoCama.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEstadoCama.setBounds(132, 26, 131, 14);
		frmCama.getContentPane().add(lblEstadoCama);
		
		JCBEstado.setModel(new DefaultComboBoxModel(new String[] {"SELECIONE"}));
		JCBEstado.setBounds(267, 25, 100, 20);
		frmCama.getContentPane().add(JCBEstado);
		
		
			
		btnRegistrar.setBounds(10, 95, 89, 23);
		frmCama.getContentPane().add(btnRegistrar);
		
		
		btnBuscar.setBounds(110, 95, 89, 23);
		frmCama.getContentPane().add(btnBuscar);
		
		
		btnModificar.setBounds(209, 95, 100, 23);
		frmCama.getContentPane().add(btnModificar);
		
		
		btnEliminar.setBounds(319, 95, 89, 23);
		frmCama.getContentPane().add(btnEliminar);
		
		JLabel lblNewLabel = new JLabel("HABITACION");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(10, 56, 111, 14);
		frmCama.getContentPane().add(lblNewLabel);
		
		JCBHabitacion.setModel(new DefaultComboBoxModel(new String[] {"SELECIONE"}));
		JCBHabitacion.setBounds(142, 55, 121, 20);
		frmCama.getContentPane().add(JCBHabitacion);
	}
	public JFrame frmCama;
	public JButton btnRegistrar= new JButton("REGISTRAR");
	public JButton btnBuscar= new JButton("BUSCAR");
	public JButton btnEliminar = new JButton("ELIMINAR");
	public JButton btnModificar = new JButton("ACTUALIZAR");
	public JComboBox JCBEstado = new JComboBox();
	public JComboBox JCBHabitacion = new JComboBox();
	public JTextField JTFId = new JTextField();
	public controladorCama micontroladorcama ;
	public DAOCamas MidaoCamas = new DAOCamas();
	public Cama nueva_cama = null;
}
