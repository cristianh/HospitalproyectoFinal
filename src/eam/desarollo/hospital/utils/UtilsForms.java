/**
 * 
 */
package eam.desarollo.hospital.utils;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.BorderFactory;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.Border;

/**
 * @author Casa1
 *
 */
public  class UtilsForms {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static Boolean validaremail(String email) {
		String pattheremail = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		// Compiles the given regular expression into a pattern.
		Pattern pattern = Pattern.compile(pattheremail);

		// Match the given input against this pattern
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}

	public static void Solo_letras(JTextField input) {
		input.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				System.out.println(input.getName());
				char c = e.getKeyChar();
				if (Character.isDigit(c)) {
					e.consume();
				}
			}
		});
	}
	
	public static void Solo_letrasTexPane(JTextPane input) {
		input.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				System.out.println(input.getName());
				char c = e.getKeyChar();
				if (Character.isDigit(c)) {
					e.consume();
				}
			}
		});
	}

	public static void Solo_numeros(JTextField input) {
		input.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
				
				/*if(e.getComponent()){
					
				}*/
				char c = e.getKeyChar();
				if (!Character.isDigit(c)) {
					e.consume();
				}
			}
		});
	}

	public static void validarVacio(JTextField inputpresholder) {
		inputpresholder.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				
				if (inputpresholder.getText().equals("Falta este campo")) {
					inputpresholder.setText("");
				}
				else
				{
					Border border = BorderFactory.createLineBorder(Color.GRAY);
					inputpresholder.setBorder(border);
					inputpresholder.setForeground(Color.BLACK);
					
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (inputpresholder.getText().isEmpty() || inputpresholder.getText().equals("")) {
					Border border = BorderFactory.createLineBorder(Color.RED);
					inputpresholder.setForeground(Color.RED);
					inputpresholder.setBorder(border);
					inputpresholder.setForeground(Color.RED);
					inputpresholder.setText("Falta este campo");
				} else {
					Border border = BorderFactory.createLineBorder(Color.GRAY);
					inputpresholder.setBorder(border);
					inputpresholder.setForeground(Color.BLACK);
				}
			}
		});
	}
}
