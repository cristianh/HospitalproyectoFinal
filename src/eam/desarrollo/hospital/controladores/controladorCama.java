package eam.desarrollo.hospital.controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import eam.desarollo.hospital.vistas.VentanaCama;

import eam.desarrollo.hospital.DAO.DAOCamas;
import eam.desarrollo.hospital.entidades.Cama;
import eam.desarrollo.hospital.entidades.Consultorio;
import eam.desarrollo.hospital.entidades.EstadoCama;
import eam.desarrollo.hospital.entidades.Habitacion;



public class controladorCama  implements ActionListener,MouseListener{
	public VentanaCama ventanacama;
	public Cama nueva_cama = null;
	public EstadoCama estado_cama = null;
	
	public Habitacion habitacion = null;
	public DAOCamas Midao = new DAOCamas();
	public ArrayList<EstadoCama> listaEstado;
	public ArrayList<Habitacion> listaHabitacion;
	
	
	
	public controladorCama(VentanaCama ventanacama) {
		super();
		this.ventanacama = ventanacama;
		listarEstado();
		listarHabitacion();
		listenerbotones();
	}

	
	
	@Override
	public void actionPerformed(ActionEvent evento) {
		// TODO Auto-generated method stub
		switch (evento.getActionCommand()) {
		case "REGISTRAR":
			if (verificarformulario()) {

				String estado = ventanacama.JCBEstado.getSelectedItem().toString();

				String id = ventanacama.JTFId.getText();
				String habitaciones= ventanacama.JCBHabitacion.getSelectedItem().toString();
				estado_cama = new EstadoCama(
						Integer.toString(ventanacama.JCBEstado.getSelectedIndex()), estado);
				habitacion = new Habitacion(Integer.toString(ventanacama.JCBHabitacion.getSelectedIndex()),habitaciones,null);
						
				nueva_cama = new Cama(id,estado_cama,habitacion);
				System.out.println(nueva_cama.getIdCama());

				try {
					Midao.crear(nueva_cama);
				} catch (Exception e1) {

				}
				ventanacama.JCBEstado.setSelectedIndex(0);
				// ventanapaciente.dateChooser.setDate(null);
				Limpiarformulario();
				
			} else {
				JOptionPane.showMessageDialog(null, "Por favor ingrese sus datos", "Info",
						JOptionPane.INFORMATION_MESSAGE);
			}

			break;

		case "ELIMINAR":
			try {
				if (!verificarVacio()) {
					Midao.eliminar(ventanacama.JTFId.getText());
					ventanacama.JCBEstado.setSelectedIndex(0);
					ventanacama.JCBHabitacion.setSelectedIndex(0);
			
					Limpiarformulario();
					JOptionPane.showMessageDialog(null, "Cama eliminada", "Info",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "Llene el campo requerido");
				}

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			break;

		case "ACTUALIZAR":
			String estado = ventanacama.JCBEstado.getSelectedItem().toString();
			String habitaciones= ventanacama.JCBHabitacion.getSelectedItem().toString();
			String id = ventanacama.JTFId.getText();
			
			
			estado_cama = new EstadoCama(Integer.toString(ventanacama.JCBEstado.getSelectedIndex()),
					estado);
			habitacion = new Habitacion(Integer.toString(ventanacama.JCBHabitacion.getSelectedIndex()),habitaciones,null);
			
			nueva_cama = new Cama(id,estado_cama,habitacion);
			try {
				Midao.actualizar(nueva_cama);
				ventanacama.JCBEstado.setSelectedIndex(0);
				Limpiarformulario();
				JOptionPane.showMessageDialog(null, "Cama actualizada", "Info", JOptionPane.INFORMATION_MESSAGE);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			break;
			
		case "BUSCAR":
			try {
				nueva_cama = Midao.buscar(ventanacama.JTFId.getText());
				if (nueva_cama != null) {
					ventanacama.JCBEstado.setSelectedIndex(
							Integer.parseInt(nueva_cama.getEstadoCama().getIdEstadoCama()));
					ventanacama.JCBHabitacion.setSelectedIndex(Integer.parseInt(nueva_cama.getHabitacion().getIdHabitacion()));
					
					JOptionPane.showMessageDialog(null, "Cama encontrada", "Info", JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "Cama no encontrada", "Info",
							JOptionPane.INFORMATION_MESSAGE);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
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
		this.ventanacama.JTFId.setText("");
		
	}
	
	private void listenerbotones() {
		// TODO Auto-generated method stub
		try {
			this.ventanacama.btnRegistrar.addActionListener(this);
			this.ventanacama.btnBuscar.addActionListener(this);
			this.ventanacama.btnEliminar.addActionListener(this);
			this.ventanacama.btnModificar.addActionListener(this);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void listarEstado() {
		listaEstado = Midao.listarEstadoCama();
		for (int i = 0; i < listaEstado.size(); i++) {
			String item = listaEstado.get(i).getDescripcionEstadoCama();
			ventanacama.JCBEstado.addItem(item);
		}
	}
	
	public void listarHabitacion() {
		listaHabitacion = Midao.listarHabitacion();
		for (int i = 0; i < listaHabitacion.size(); i++) {
			String item = listaHabitacion.get(i).getDescripcionHabitacion();
			ventanacama.JCBHabitacion.addItem(item);
		}
	}
	
	public boolean verificarformulario() {

		if (this.ventanacama.JTFId.getText().equals("") || this.ventanacama.JCBEstado.getSelectedItem()=="SELECCIONE OPCION" || this.ventanacama.JCBHabitacion.getSelectedItem()=="SELECCIONE OPCION") {
			return false;
		}
		return true;
	}

	public boolean verificarVacio() {

		if (this.ventanacama.JTFId.getText().equals("") ) {
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

	

}
