package eam.desarrollo.hospital.controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

import eam.desarollo.hospital.vistas.VentanaProveedor;
import eam.desarrollo.hospital.DAO.DAOProveedor;
import eam.desarrollo.hospital.entidades.Consultorio;
import eam.desarrollo.hospital.entidades.EstadoConsultorio;
import eam.desarrollo.hospital.entidades.Proveedor;

public class controladorProveedor implements ActionListener,MouseListener{
	public VentanaProveedor ventanaproveedor;
	public Proveedor nuevo_proveedor = null;
	public DAOProveedor Midao= new DAOProveedor();
	
	public controladorProveedor(VentanaProveedor ventanaproveedor) {
		super();
		this.ventanaproveedor = ventanaproveedor;
		listenerbotones();
	}
	
	
	
	
	
	
	
	
	private void listenerbotones() {
		// TODO Auto-generated method stub
		try {
			this.ventanaproveedor.Registrar.addActionListener(this);
			this.ventanaproveedor.Buscar.addActionListener(this);
			this.ventanaproveedor.Eliminar.addActionListener(this);
			this.ventanaproveedor.Actualizar.addActionListener(this);
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
		case "Registrar":
			if (verificarformulario()) {

				
				String id = ventanaproveedor.JTFID.getText();
				String nombre = ventanaproveedor.JTFNombre.getText();
				String empresa = ventanaproveedor.JTFEmpresa.getText();
				String direccion= ventanaproveedor.JTFDireccion.getText();
				String email=ventanaproveedor.JTFEmail.getText();
				String telefono=ventanaproveedor.JTFTelefono.getText();
				nuevo_proveedor = new Proveedor(id, empresa, nombre, direccion, telefono, email);
				
				

				try {
					Midao.crear(nuevo_proveedor);
				} catch (Exception e1) {

				}
				
				Limpiarformulario();
				
			} else {
				JOptionPane.showMessageDialog(null, "Por favor ingrese sus datos", "Info",
						JOptionPane.INFORMATION_MESSAGE);
			}

			break;
			

		case "Eliminar":
			try {
				if (!verificarVacio()) {
					Midao.eliminar(ventanaproveedor.JTFID.getText());
					Limpiarformulario();
					JOptionPane.showMessageDialog(null, "Proveedor eliminado", "Info",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "Llene el campo requerido");
				}

			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			break;
			
		case "Actualizar":
			String id = ventanaproveedor.JTFID.getText();
			String nombre = ventanaproveedor.JTFNombre.getText();
			String empresa = ventanaproveedor.JTFEmpresa.getText();
			String direccion= ventanaproveedor.JTFDireccion.getText();
			String email=ventanaproveedor.JTFEmail.getText();
			String telefono=ventanaproveedor.JTFTelefono.getText();
			nuevo_proveedor = new Proveedor(id, empresa, nombre, direccion, telefono, email);
			try {
				Midao.actualizar(nuevo_proveedor);
				
				Limpiarformulario();
				JOptionPane.showMessageDialog(null, "Proveedor actualizado", "Info", JOptionPane.INFORMATION_MESSAGE);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			break;
			
		case "Buscar":
			try {
				nuevo_proveedor = Midao.buscar(ventanaproveedor.JTFID.getText());
				if (nuevo_proveedor != null) {
					ventanaproveedor.JTFNombre.setText(nuevo_proveedor.getNombre());
					ventanaproveedor.JTFEmpresa.setText(nuevo_proveedor.getEmpresa());
					ventanaproveedor.JTFDireccion.setText(nuevo_proveedor.getDireccion());
					ventanaproveedor.JTFEmail.setText(nuevo_proveedor.getEmail());
					ventanaproveedor.JTFTelefono.setText(nuevo_proveedor.getTelefono());
					JOptionPane.showMessageDialog(null, "Proveedor encontrado", "Info", JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "Proveedor no encontrado", "Info",
							JOptionPane.INFORMATION_MESSAGE);
				}
			} catch (Exception e1) {
				// TODO Auto-generated catch block
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
		this.ventanaproveedor.JTFDireccion.setText("");
		this.ventanaproveedor.JTFEmail.setText("");
		this.ventanaproveedor.JTFEmpresa.setText("");
		this.ventanaproveedor.JTFNombre.setText("");
		this.ventanaproveedor.JTFTelefono.setText("");
		this.ventanaproveedor.JTFID.setText("");
		
	}
	
	public boolean verificarformulario() {

		if (this.ventanaproveedor.JTFDireccion.getText().equals("") || this.ventanaproveedor.JTFID.getText().equals("") 
				|| this.ventanaproveedor.JTFEmail.getText().equals("")|| this.ventanaproveedor.JTFEmpresa.getText().equals("") || this.ventanaproveedor.JTFNombre.getText().equals("") || this.ventanaproveedor.JTFTelefono.getText().equals("")) {
			return false;
		}
		return true;
	}

	public boolean verificarVacio() {

		if(this.ventanaproveedor.JTFID.getText().equals("")){
			return true;
		}
		return false;
	}
	
}
