package eam.desarollo.hospital.vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.SwingConstants;
import javax.swing.LayoutStyle.ComponentPlacement;

import eam.desarrollo.hospital.controladores.controladorMedico;
import eam.desarrollo.hospital.controladores.controladorVPrincipal;
import java.awt.Toolkit;

public class VentanaPrincipal extends javax.swing.JFrame {

	
	public static controladorVPrincipal micontroladorventanaprincipal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal window = new VentanaPrincipal();
					window.frmVentanaPrincipal.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VentanaPrincipal() {
		initialize();
		micontroladorventanaprincipal =  new controladorVPrincipal(this);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frmVentanaPrincipal.setTitle("Ventana Principal");
		frmVentanaPrincipal.setBounds(100, 100, 680, 403);
		frmVentanaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frmVentanaPrincipal.setJMenuBar(menuBar);
		
		
		mnPaciente.setIcon(new ImageIcon("C:\\Users\\Casa1\\Documents\\GitHub\\HospitalproyectoFinal\\Imagenes\\male.png"));
		menuBar.add(mnPaciente);
		
		mntmNuevoPaciente.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
		mnPaciente.add(mntmNuevoPaciente);
		
		
		menuBar.add(mnMedico);
		
		
		mntmNuevoMedico.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
		mnMedico.add(mntmNuevoMedico);
		
		
		menuBar.add(mnAgenda);
		mntmNuevaAgenda.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
		
		
		mnAgenda.add(mntmNuevaAgenda);
		
		
		menuBar.add(mnCama);
		mntmIngresarCama.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
		
		
		mnCama.add(mntmIngresarCama);
		
		JMenu mnConsultorio = new JMenu("Consultorio");
		menuBar.add(mnConsultorio);
		mntmNuevaConsultorio.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
		
		
		mnConsultorio.add(mntmNuevaConsultorio);
		
		
		
		menuBar.add(mnFarmacia);
		mntmNuevoRegistro.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
		
	
		mnFarmacia.add(mntmNuevoRegistro);
		
		
		menuBar.add(mnHabitacion);
		mntmNuevaHabitacion.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
		
		
		
		mnHabitacion.add(mntmNuevaHabitacion);
		
		
		menuBar.add(mnMedicamento);
		mntmReguistrarMedicamento.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
		
		
		mnMedicamento.add(mntmReguistrarMedicamento);
		mntmFormulaMedicamento.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, InputEvent.CTRL_MASK));
		
		mnMedicamento.add(mntmFormulaMedicamento);
		
		
		menuBar.add(mnProveedor);
		mntmMedicamentoProveedor.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
		
		
		mnProveedor.add(mntmMedicamentoProveedor);
		mntmMedicamentoProveedor_1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, InputEvent.CTRL_MASK));
		
		mnProveedor.add(mntmMedicamentoProveedor_1);
		String sourceFileName = this.getClass().getClassLoader().getResource("MedicoBannerReporte.png").getPath();
		System.out.println(sourceFileName);
		ImageIcon imagenicono = new ImageIcon(sourceFileName);
		frmVentanaPrincipal.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		String sourceFileName2 = this.getClass().getClassLoader().getResource("Untitled.png").getPath();
		lblNewLabel_1.setIcon(new ImageIcon(sourceFileName2));
		frmVentanaPrincipal.getContentPane().add(lblNewLabel_1, BorderLayout.NORTH);
	}
	
	
	public JFrame frmVentanaPrincipal = new JFrame();
	public JMenu mnProveedor = new JMenu("Proveedor");
	public JMenu mnPaciente = new JMenu("Paciente");
	public JMenuItem mntmNuevoPaciente = new JMenuItem("Nuevo paciente");
	public JMenu mnMedico = new JMenu("Medico");
	public JMenuItem mntmNuevoMedico = new JMenuItem("Nuevo medico");
	public JMenu mnAgenda = new JMenu("Agenda");
	public JMenuItem mntmNuevaAgenda = new JMenuItem("Nueva agenda");
	public JMenu mnCama = new JMenu("Cama");
	public JMenuItem mntmIngresarCama = new JMenuItem("Ingresar Cama");
	public JMenuItem mntmNuevaConsultorio = new JMenuItem("Nueva  consultorio");
	public JMenu mnFarmacia = new JMenu("Farmacia");
	public JMenuItem mntmNuevoRegistro = new JMenuItem("Nuevo registro");
	public JMenu mnHabitacion = new JMenu("Habitacion");
	public JMenuItem mntmNuevaHabitacion = new JMenuItem("Nueva habitacion");
	public JMenu mnMedicamento = new JMenu("Medicamento");
	public JMenuItem mntmReguistrarMedicamento = new JMenuItem("Registrar medicamento");
	public JMenuItem mntmMedicamentoProveedor = new JMenuItem("Registar Proveedor");
	public JMenuItem mntmMedicamentoProveedor_1 = new JMenuItem("Medicamento Proveedor");
	public JMenuItem mntmFormulaMedicamento = new JMenuItem("Formula medicamento");
}
