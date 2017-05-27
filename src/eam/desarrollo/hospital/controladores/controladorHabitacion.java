package eam.desarrollo.hospital.controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import eam.desarollo.hospital.vistas.VentanaHabitacion;

import eam.desarrollo.hospital.DAO.DAOHabitacion;
import eam.desarrollo.hospital.entidades.Cama;
import eam.desarrollo.hospital.entidades.Consultorio;
import eam.desarrollo.hospital.entidades.EstadoCama;
import eam.desarrollo.hospital.entidades.EstadoConsultorio;
import eam.desarrollo.hospital.entidades.Habitacion;

public class controladorHabitacion implements ActionListener,MouseListener {

	public VentanaHabitacion ventanahabitacion;
	public Habitacion nueva_habitacion = null;
	public Consultorio consultorio = null;
	public DAOHabitacion Midao = new DAOHabitacion();
	public ArrayList<Consultorio> listaConsultorio;
	public EstadoConsultorio estadoConsultorio = null;
	
	
	
	
	public controladorHabitacion(VentanaHabitacion ventanahabitacion) {
		super();
		this.ventanahabitacion = ventanahabitacion;
		listarEstado();
		listenerbotones();
	}
	
	
	
	
	public void listarEstado() {
		listaConsultorio = Midao.listarConsultorio();
		for (int i = 0; i < listaConsultorio.size(); i++) {
			String item = listaConsultorio.get(i).getDescripcionConsultorio();
			ventanahabitacion.JCBConsultorio.addItem(item);
		}
	}
	
	private void listenerbotones() {
		// TODO Auto-generated method stub
		try {
			this.ventanahabitacion.btnRegistrar.addActionListener(this);
			this.ventanahabitacion.btnBuscar.addActionListener(this);
			this.ventanahabitacion.btnEliminar.addActionListener(this);
			this.ventanahabitacion.btnModificar.addActionListener(this);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	public boolean verificarformulario() {

		if (this.ventanahabitacion.JTFId.getText().equals("") && this.ventanahabitacion.JCBConsultorio.getSelectedItem()=="SELECCIONE OPCION") {
			return false;
		}
		return true;
	}

	public boolean verificarVacio() {

		if (this.ventanahabitacion.JTFId.getText().equals("") ) {
			return true;
		}
		return false;
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

				String consultorios = ventanahabitacion.JCBConsultorio.getSelectedItem().toString();
				estadoConsultorio = new EstadoConsultorio();
				String id = ventanahabitacion.JTFId.getText();
				String descripcion = ventanahabitacion.TPDescripcion.getText();
				consultorio = new Consultorio(
						Integer.toString(ventanahabitacion.JCBConsultorio.getSelectedIndex()), consultorios, estadoConsultorio);
				nueva_habitacion = new Habitacion(id,descripcion,consultorio);
				System.out.println(nueva_habitacion.getIdHabitacion());

				try {
					Midao.crear(nueva_habitacion);
				} catch (Exception e1) {

				}
				ventanahabitacion.JCBConsultorio.setSelectedIndex(0);
				// ventanapaciente.dateChooser.setDate(null);
				//Limpiarformulario();
				
			} else {
				JOptionPane.showMessageDialog(null, "Por favor ingrese sus datos", "Info",
						JOptionPane.INFORMATION_MESSAGE);
			}

			break;
			
		case "ELIMINAR":
			try {
				if (!verificarVacio()) {
					Midao.eliminar(ventanahabitacion.JTFId.getText());
					ventanahabitacion.JCBConsultorio.setSelectedIndex(0);
					
					JOptionPane.showMessageDialog(null, "Habitacion eliminada", "Info",
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
			String consultorios = ventanahabitacion.JCBConsultorio.getSelectedItem().toString();
			String id = ventanahabitacion.JTFId.getText();
			String descripcion = ventanahabitacion.TPDescripcion.getText();
			
			consultorio = new Consultorio(
					Integer.toString(ventanahabitacion.JCBConsultorio.getSelectedIndex()), consultorios, estadoConsultorio);
			nueva_habitacion = new Habitacion(id,descripcion,consultorio);
			try {
				Midao.actualizar(nueva_habitacion);
				ventanahabitacion.JCBConsultorio.setSelectedIndex(0);
				
				JOptionPane.showMessageDialog(null, "Habitacion actualizada", "Info", JOptionPane.INFORMATION_MESSAGE);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			break;
			
		case "BUSCAR":
			try {
				nueva_habitacion = Midao.buscar(ventanahabitacion.JTFId.getText());
				if (nueva_habitacion != null) {
					ventanahabitacion.JCBConsultorio.setSelectedIndex(
							Integer.parseInt(nueva_habitacion.getConsultorio().getIdConsultario()));
					ventanahabitacion.TPDescripcion.setText(nueva_habitacion.getDescripcionHabitacion());
					
					JOptionPane.showMessageDialog(null, "Habitacion encontrada", "Info", JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "Habitacion no encontrada", "Info",
							JOptionPane.INFORMATION_MESSAGE);
				}
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				System.out.println(e1.getMessage());
			}
			
		
	}
	}

}
