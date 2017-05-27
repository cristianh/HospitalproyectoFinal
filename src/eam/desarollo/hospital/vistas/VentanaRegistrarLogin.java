package eam.desarollo.hospital.vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.Toolkit;
import java.awt.Window.Type;
import javax.swing.JButton;
import java.awt.Component;

public class VentanaRegistrarLogin {

	private JFrame frmRegistrarLogin;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaRegistrarLogin window = new VentanaRegistrarLogin();
					window.frmRegistrarLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VentanaRegistrarLogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRegistrarLogin = new JFrame();
		frmRegistrarLogin.setTitle("Registrar login");
		frmRegistrarLogin.setType(Type.POPUP);
		frmRegistrarLogin.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Casa1\\Documents\\GitHub\\Hospitalproyecto\\Imagenes\\images.jpg"));
		frmRegistrarLogin.setBounds(100, 100, 644, 390);
		frmRegistrarLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Casa1\\Documents\\GitHub\\Hospitalproyecto\\Imagenes\\images.jpg"));
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel lblConfirmarPassword = new JLabel("Confirmar password:");
		lblConfirmarPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		passwordField = new JPasswordField();
		
		passwordField_1 = new JPasswordField();
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JButton btnGuardar = new JButton("GUARDAR");
		
		JButton btnCancelar = new JButton("CANCELAR");
		
		JLabel lblAdministracionLogin = new JLabel("ADMINISTRACION LOGIN");
		lblAdministracionLogin.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		GroupLayout groupLayout = new GroupLayout(frmRegistrarLogin.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 292, GroupLayout.PREFERRED_SIZE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblUsuario)
									.addGap(18)
									.addComponent(textField, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblPassword)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(passwordField_1, GroupLayout.PREFERRED_SIZE, 207, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblConfirmarPassword)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(passwordField, GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
										.addComponent(btnCancelar))))
							.addGap(77))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(41)
							.addComponent(btnGuardar, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)))
					.addGap(13))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(185)
					.addComponent(lblAdministracionLogin, GroupLayout.PREFERRED_SIZE, 277, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(240, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(20)
					.addComponent(lblAdministracionLogin)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 265, GroupLayout.PREFERRED_SIZE)
							.addGap(42))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(40)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblUsuario)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
							.addGap(34)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblPassword)
								.addComponent(passwordField_1, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
							.addGap(34)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblConfirmarPassword)
								.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
							.addGap(54)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnGuardar, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnCancelar))
							.addContainerGap(55, Short.MAX_VALUE))))
		);
		groupLayout.linkSize(SwingConstants.VERTICAL, new Component[] {passwordField, passwordField_1, textField});
		groupLayout.linkSize(SwingConstants.VERTICAL, new Component[] {btnGuardar, btnCancelar});
		groupLayout.linkSize(SwingConstants.HORIZONTAL, new Component[] {passwordField_1, textField});
		frmRegistrarLogin.getContentPane().setLayout(groupLayout);
	}

	

}
