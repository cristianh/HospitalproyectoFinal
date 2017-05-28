package eam.desarrollo.hospital.controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;

import eam.desarollo.hospital.vistas.VentanaProveedor;
import eam.desarrollo.hospital.DAO.DAOProveedor;
import eam.desarrollo.hospital.conexion.Conexion;
import eam.desarrollo.hospital.entidades.Consultorio;
import eam.desarrollo.hospital.entidades.EstadoConsultorio;
import eam.desarrollo.hospital.entidades.Farmacia;
import eam.desarrollo.hospital.entidades.Proveedor;
import eam.desarrollo.hospital.reports.ReportExporter;
import net.sf.jasperreports.engine.JRException;

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
			this.ventanaproveedor.mntmGenerarReporte.addActionListener(this);
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
				JOptionPane.showMessageDialog(ventanaproveedor.frame, "Por favor ingrese sus datos", "Info",
						JOptionPane.INFORMATION_MESSAGE);
			}

			break;
			

		case "Eliminar":
			try {
				if (!verificarVacio()) {
					Midao.eliminar(ventanaproveedor.JTFID.getText());
					Limpiarformulario();
					JOptionPane.showMessageDialog(ventanaproveedor.frame, "Proveedor eliminado", "Info",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(ventanaproveedor.frame, "Llene el campo requerido");
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
				JOptionPane.showMessageDialog(ventanaproveedor.frame, "Proveedor actualizado", "Info", JOptionPane.INFORMATION_MESSAGE);
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
					JOptionPane.showMessageDialog(ventanaproveedor.frame, "Proveedor encontrado", "Info", JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(ventanaproveedor.frame, "Proveedor no encontrado", "Info",
							JOptionPane.INFORMATION_MESSAGE);
				}
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				System.out.println(e1.getMessage());
			}
			break;
			
		case "Generar reporte":
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setDialogTitle("Specify a file to save");
			
			fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			int userSelection = fileChooser.showSaveDialog(ventanaproveedor.frame);
			File fileToSave = fileChooser.getSelectedFile();
			if (userSelection == JFileChooser.APPROVE_OPTION) {
				
				try {
			    	Proveedor proveedor = null;
			    	
			    	java.sql.ResultSet rs = null;
			    	Connection con = Conexion.getConexion();
					java.sql.PreparedStatement stm;
					String sql = "SELECT id_proveedor,nombre_proveedor,persona_contacto,direccion_proveedor,telefono_proveedor,email_preveedor from proveedor";
					stm = con.prepareStatement(sql);
					rs = stm.executeQuery();
					
					ArrayList<Proveedor> listMed = new ArrayList<>();
					
					while (rs.next()) {
						listMed.add(new Proveedor(rs.getString("id_proveedor"),rs.getString("nombre_proveedor"),rs.getString("persona_contacto"),rs.getString("direccion_proveedor"),rs.getString("telefono_proveedor"),rs.getString("email_preveedor")));
						
						
					}
					
					System.out.println(listMed);
					
					Map<String, Object> parameters = new HashMap<String, Object>();
//					
					ReportExporter reportExporter = new ReportExporter();
					reportExporter.export("C:/Users/Paula/Pictures/Camera Roll/HospitalproyectoFinal/reportes/ReporteProveedor4.jasper", fileToSave.getAbsolutePath(), parameters,listMed,"Reporte proveedor");

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					System.out.println(e1.getMessage());
				} catch (JRException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
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
