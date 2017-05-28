package eam.desarollo.hospital.vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import eam.desarrollo.hospital.controladores.controladorFarmacia;

import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class ventanaFarmacia {

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ventanaFarmacia window = new ventanaFarmacia();
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
	public ventanaFarmacia() {
		initialize();
		micontroladorfarmacia = new controladorFarmacia(this);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblId.setBounds(10, 27, 46, 14);
		frame.getContentPane().add(lblId);
		
		
		JTFId.setBounds(30, 26, 86, 20);
		frame.getContentPane().add(JTFId);
		JTFId.setColumns(10);
		
		JLabel lblNomFarmacia = new JLabel("Nombre Farmacia");
		lblNomFarmacia.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNomFarmacia.setBounds(10, 79, 136, 14);
		frame.getContentPane().add(lblNomFarmacia);
		
		
		JTFNombreFarmacia.setBounds(144, 78, 261, 20);
		frame.getContentPane().add(JTFNombreFarmacia);
		JTFNombreFarmacia.setColumns(10);
		
		JLabel lblPersonaACargo = new JLabel("Persona a Cargo");
		lblPersonaACargo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPersonaACargo.setBounds(10, 112, 136, 19);
		frame.getContentPane().add(lblPersonaACargo);
		
		
		JTFPersona.setBounds(144, 113, 261, 20);
		frame.getContentPane().add(JTFPersona);
		JTFPersona.setColumns(10);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTelefono.setBounds(126, 24, 80, 20);
		frame.getContentPane().add(lblTelefono);
		
		
		JTFTelefono.setBounds(196, 26, 209, 20);
		frame.getContentPane().add(JTFTelefono);
		JTFTelefono.setColumns(10);
		
		
		btnRegistrar.setBounds(7, 170, 89, 23);
		frame.getContentPane().add(btnRegistrar);
		
		
		btnBuscar.setBounds(107, 170, 89, 23);
		frame.getContentPane().add(btnBuscar);
		
		
		btnModificar.setBounds(206, 170, 100, 23);
		frame.getContentPane().add(btnModificar);
		
		
		btnEliminar.setBounds(316, 170, 89, 23);
		frame.getContentPane().add(btnEliminar);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnReportes = new JMenu("Reportes");
		menuBar.add(mnReportes);
		
		
		mnReportes.add(mntmGenerarReporte);
	}
	
	
	public JFrame frame = new JFrame();;
	public controladorFarmacia micontroladorfarmacia;
	public JButton btnRegistrar= new JButton("REGISTRAR");
	public JButton btnBuscar= new JButton("BUSCAR");
	public JButton btnEliminar = new JButton("ELIMINAR");
	public JButton btnModificar = new JButton("ACTUALIZAR");
	public JTextField JTFId = new JTextField();
	public JTextField JTFNombreFarmacia = new JTextField();
	public JTextField JTFPersona = new JTextField();
	public JTextField JTFTelefono = new JTextField();
	public JMenuItem mntmGenerarReporte = new JMenuItem("Generar reporte");
}
