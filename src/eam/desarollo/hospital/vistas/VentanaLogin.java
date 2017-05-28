package eam.desarollo.hospital.vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Panel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import eam.desarrollo.hospital.DAO.DAOLogin;
import eam.desarrollo.hospital.entidades.Login;

import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.UIManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaLogin {

	private JFrame frmLogin;
	private JPasswordField JTFPassword;
	private JTextField JTFUsuario;
	public DAOLogin daologin= new DAOLogin();
	public VentanaPrincipal ventanaprincipal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaLogin window = new VentanaLogin();
					window.frmLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VentanaLogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLogin = new JFrame();
		frmLogin.setTitle("LOGIN");
		frmLogin.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Casa1\\Documents\\GitHub\\Hospitalproyecto\\Imagenes\\lock.png"));
		frmLogin.setBounds(100, 100, 625, 433);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Login", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(128, 128, 128)));
		GroupLayout groupLayout = new GroupLayout(frmLogin.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 586, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(13, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(8)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 382, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Casa1\\Documents\\GitHub\\Hospitalproyecto\\Imagenes\\lock.png"));
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JButton btnIngresar = new JButton("INGRESAR");
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String password = new String(JTFPassword.getPassword());
				
				Login login=daologin.ingresarSistema(JTFUsuario.getText(),password);
				System.out.println(login);
				
				if(login!=null){
					JOptionPane.showMessageDialog(frmLogin, "BIENVENIDO", "Info", JOptionPane.INFORMATION_MESSAGE);
					
					
					switch(login.getIdTipoUsuario().tipoUsuario){
					case "admin":
						ventanaprincipal=new VentanaPrincipal();
						ventanaprincipal.frmVentanaPrincipal.setVisible(true);
					break;
					case "medico":
						ventanaprincipal=new VentanaPrincipal();
						ventanaprincipal.frmVentanaPrincipal.setVisible(true);
						ventanaprincipal.mnPaciente.setVisible(false);
						ventanaprincipal.mnCama.setVisible(false);
					break;
					case "usuario":
						ventanaprincipal=new VentanaPrincipal();
						ventanaprincipal.frmVentanaPrincipal.setVisible(true);
						ventanaprincipal.mnFarmacia.setVisible(false);
					break;
					}
				}else
				{
					JOptionPane.showMessageDialog(frmLogin, "Eror al ingresar", "Error", JOptionPane.INFORMATION_MESSAGE);
				}
				
				frmLogin.dispose();
				
			}
		});
		
		JTFUsuario = new JTextField();
		JTFUsuario.setColumns(10);
		
		JTFPassword = new JPasswordField();
		
		JLabel lblBienvenido = new JLabel("BIENVENIDO");
		lblBienvenido.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 19));
		
		JLabel lblRegistrarme = new JLabel("Registrarme");
		lblRegistrarme.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				VentanaRegistrarLogin ventanaregistarlogin = new VentanaRegistrarLogin();		
			}
		});
		lblRegistrarme.setForeground(Color.BLUE);
		lblRegistrarme.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblolvideMiClave = new JLabel("\u00BFOlvide mi clave?");
		lblolvideMiClave.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblolvideMiClave.setForeground(Color.BLUE);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblRegistrarme)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblolvideMiClave)
					.addContainerGap(386, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblBienvenido, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(2)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 221, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblPassword)
								.addComponent(lblUsuario))))
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(10)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(JTFPassword, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
								.addComponent(JTFUsuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(33)
							.addComponent(btnIngresar)))
					.addGap(78))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblBienvenido)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(33)
									.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 234, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
									.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblUsuario)
										.addComponent(JTFUsuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGap(73)
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(lblPassword, Alignment.TRAILING)
										.addComponent(JTFPassword, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGap(79)))
							.addGap(26)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblRegistrarme)
								.addComponent(lblolvideMiClave)))
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addComponent(btnIngresar)
							.addGap(36))))
		);
		gl_panel.linkSize(SwingConstants.HORIZONTAL, new Component[] {JTFUsuario, JTFPassword});
		panel.setLayout(gl_panel);
		frmLogin.getContentPane().setLayout(groupLayout);
	}
}
