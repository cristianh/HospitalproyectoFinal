package eam.desarrollo.hospital.controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

import eam.desarollo.hospital.vistas.ventanaFarmacia;
import eam.desarrollo.hospital.DAO.DAOFarmacia;
import eam.desarrollo.hospital.entidades.Farmacia;



public class controladorFarmacia implements ActionListener,MouseListener{
	public ventanaFarmacia ventanaFarmacia;
	public Farmacia farmacia = null;
	public DAOFarmacia Midao = new DAOFarmacia();
	
	
	
	public controladorFarmacia(ventanaFarmacia ventanaFarmacia) {
		super();
		this.ventanaFarmacia = ventanaFarmacia;
		listenerbotones();
	}
	private void listenerbotones() {
		// TODO Auto-generated method stub
		try {
			this.ventanaFarmacia.btnRegistrar.addActionListener(this);
			this.ventanaFarmacia.btnBuscar.addActionListener(this);
			this.ventanaFarmacia.btnEliminar.addActionListener(this);
			this.ventanaFarmacia.btnModificar.addActionListener(this);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		switch (e.getActionCommand()) {
		case "REGISTRAR":
			if (verificarformulario()) {

				String id = ventanaFarmacia.JTFId.getText();
				String nombre = ventanaFarmacia.JTFNombreFarmacia.getText();
				String persona = ventanaFarmacia.JTFPersona.getText();
				String telefono = ventanaFarmacia.JTFTelefono.getText();
				farmacia = new Farmacia(id, nombre, persona, telefono);
				

				try {
					Midao.crear(farmacia);
				} catch (Exception e1) {

				}
				
				Limpiarformulario();
				
			} else {
				JOptionPane.showMessageDialog(null, "Por favor ingrese sus datos", "Info",
						JOptionPane.INFORMATION_MESSAGE);
			}

			break;
			
		case "ELIMINAR":
			try {
				if (!verificarVacio()) {
					Midao.eliminar(ventanaFarmacia.JTFId.getText());
					Limpiarformulario();
					JOptionPane.showMessageDialog(null, "Farmacia eliminada", "Info",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "Llene el campo requerido");
				}

			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			break;
			

		case "ACTUALIZAR":
			String id = ventanaFarmacia.JTFId.getText();
			String nombre = ventanaFarmacia.JTFNombreFarmacia.getText();
			String persona = ventanaFarmacia.JTFPersona.getText();
			String telefono = ventanaFarmacia.JTFTelefono.getText();
			farmacia = new Farmacia(id, nombre, persona, telefono);
			try {
				Midao.actualizar(farmacia);
				
				Limpiarformulario();
				JOptionPane.showMessageDialog(null, "Farmacia actualizada", "Info", JOptionPane.INFORMATION_MESSAGE);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			break;
			
		case "BUSCAR":
			try {
				farmacia = Midao.buscar(ventanaFarmacia.JTFId.getText());
				if (farmacia != null) {
					ventanaFarmacia.JTFTelefono.setText(farmacia.getTelefonoFarmacia());
					ventanaFarmacia.JTFNombreFarmacia.setText(farmacia.getNombreFarmacia());
					ventanaFarmacia.JTFPersona.setText(farmacia.getPersonaACargo());
					
					JOptionPane.showMessageDialog(null, "Farmacia encontrada", "Info", JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "Farmacia no encontrada", "Info",
							JOptionPane.INFORMATION_MESSAGE);
				}
			} catch (Exception e1) {
				
				System.out.println(e1.getMessage());
			}
			break;
			/**
		case "Actualizar tabla":
			try {
			CargarTabla();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
			break;
**/
		}
		
	}
	
	public void Limpiarformulario() {
		this.ventanaFarmacia.JTFId.setText("");
		this.ventanaFarmacia.JTFNombreFarmacia.setText("");
		this.ventanaFarmacia.JTFPersona.setText("");
		this.ventanaFarmacia.JTFTelefono.setText("");
		
	}
	
	
	public boolean verificarformulario() {

		if (this.ventanaFarmacia.JTFId.getText().equals("") && this.ventanaFarmacia.JTFNombreFarmacia.getText().equals("") && this.ventanaFarmacia.JTFPersona.getText().equals("") && this.ventanaFarmacia.JTFTelefono.getText().equals("")) {
			return false;
		}
		return true;
	}

	public boolean verificarVacio() {

		if (this.ventanaFarmacia.JTFId.getText().equals("") && this.ventanaFarmacia.JTFNombreFarmacia.getText().equals("") && this.ventanaFarmacia.JTFPersona.getText().equals("") && this.ventanaFarmacia.JTFTelefono.getText().equals("") ) {
			return true;
		}
		return false;
	}

}
