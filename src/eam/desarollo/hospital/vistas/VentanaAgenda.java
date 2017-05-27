package eam.desarollo.hospital.vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import com.toedter.calendar.JCalendar;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.SpinnerListModel;
import com.toedter.calendar.JDateChooser;

import eam.desarrollo.hospital.controladores.controladorAgenda;
import eam.desarrollo.hospital.controladores.controladorCita;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Component;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.JScrollPane;

public class VentanaAgenda {

	private JFrame frmAgendaMedico;
	public JTextField JTFIdagenda;
	public JComboBox JCBMedicoagenda = new JComboBox();
	public JButton btnRegistrar = new JButton("REGISTRAR");
	public static controladorAgenda micontroladorAgenda;
	public JButton btnBuscar = new JButton("BUSCAR");
	public JButton btnEliminar = new JButton("ELIMINAR");
	public JButton btnActualizar = new JButton("ACTUALIZAR");
	public JDateChooser dateChooser = new JDateChooser();
	public JSpinner JSPHora2 = new JSpinner();
	public JSpinner JSPHora1 = new JSpinner();
	private final JScrollPane scrollPane = new JScrollPane();
	public  final JTable JTBAgenda = new JTable();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaAgenda window = new VentanaAgenda();
					window.frmAgendaMedico.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VentanaAgenda() {
		initialize();
		micontroladorAgenda = new controladorAgenda(this);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAgendaMedico = new JFrame();
		frmAgendaMedico.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Casa1\\Documents\\GitHub\\Hospitalproyecto\\Imagenes\\hombre-de-negocios.png"));
		frmAgendaMedico.setTitle("Ventana Agenda Medico");
		frmAgendaMedico.setBounds(100, 100, 651, 378);
		frmAgendaMedico.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblNewLabel = new JLabel("Id agenda:");
		
		JTFIdagenda = new JTextField();
		JTFIdagenda.setColumns(10);
		
		JLabel lblFecha = new JLabel("Fecha:");
		
		JLabel lblHora = new JLabel("Hora:");
		
		JSPHora1.setModel(new SpinnerListModel(new String[] {"7:00", "7:30", "8:00", "8:30", "9:00", "9:30", "10:00", "10:30", "11:00", "11:30", "12:00", "12:30", "13:00", "13:30", "14:00", "14:30", "15:00", "15:30", "16:00", "16:30", "17:00", "17:30", "18:30"}));
		
		JLabel lblNewLabel_1 = new JLabel("am  a");
		
		
		JSPHora2.setModel(new SpinnerListModel(new String[] {"7:00", "7:30", "8:00", "8:30", "9:00", "9:30", "10:00", "10:30", "11:00", "11:30", "12:00", "12:30", "13:00", "13:30", "14:00", "14:30", "15:00", "15:30", "16:00", "16:30", "17:00", "17:30", "18:30"}));
		
		
		
		JLabel lblMedico = new JLabel("Medico:");
		
		JLabel lblNewLabel_2 = new JLabel("pm");
		
		
		btnRegistrar.setIcon(new ImageIcon("C:\\Users\\Casa1\\Documents\\GitHub\\Hospitalproyecto\\Imagenes\\usuario (3).png"));
		
		btnBuscar.setIcon(new ImageIcon("C:\\Users\\Casa1\\Documents\\GitHub\\Hospitalproyecto\\Imagenes\\usuario (2).png"));
		
		
		btnEliminar.setIcon(new ImageIcon("C:\\Users\\Casa1\\Documents\\GitHub\\Hospitalproyecto\\Imagenes\\usuario.png"));
		
		
		btnActualizar.setIcon(new ImageIcon("C:\\Users\\Casa1\\Documents\\GitHub\\Hospitalproyecto\\Imagenes\\usuario (1).png"));
		GroupLayout groupLayout = new GroupLayout(frmAgendaMedico.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(JTFIdagenda, GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblFecha)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(dateChooser, GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)))
					.addGap(102)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblMedico)
							.addGap(18)
							.addComponent(JCBMedicoagenda, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblHora)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(JSPHora1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(JSPHora2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel_2)))
					.addGap(37))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(21)
					.addComponent(btnRegistrar, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
					.addGap(20)
					.addComponent(btnBuscar)
					.addGap(18)
					.addComponent(btnEliminar)
					.addGap(18)
					.addComponent(btnActualizar)
					.addGap(23))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 606, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(19, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(39)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(JTFIdagenda, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblMedico)
						.addComponent(JCBMedicoagenda, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblFecha)
						.addComponent(dateChooser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblHora)
							.addComponent(JSPHora1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblNewLabel_1)
							.addComponent(JSPHora2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblNewLabel_2)))
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
					.addGap(13)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnRegistrar, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnBuscar)
							.addComponent(btnEliminar)
							.addComponent(btnActualizar)))
					.addGap(34))
		);
		btnBuscar.setVisible(false);
		scrollPane.setViewportView(JTBAgenda);
		groupLayout.linkSize(SwingConstants.VERTICAL, new Component[] {btnRegistrar, btnBuscar, btnEliminar, btnActualizar});
		groupLayout.linkSize(SwingConstants.HORIZONTAL, new Component[] {btnRegistrar, btnBuscar, btnEliminar, btnActualizar});
		frmAgendaMedico.getContentPane().setLayout(groupLayout);
	}
}
