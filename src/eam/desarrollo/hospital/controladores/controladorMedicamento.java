package eam.desarrollo.hospital.controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import eam.desarollo.hospital.vistas.VentanaCama;
import eam.desarollo.hospital.vistas.VentanaMedicamento;
import eam.desarrollo.hospital.DAO.DAOCamas;
import eam.desarrollo.hospital.DAO.DAOMedicamento;
import eam.desarrollo.hospital.entidades.Cama;
import eam.desarrollo.hospital.entidades.EstadoCama;
import eam.desarrollo.hospital.entidades.Farmacia;
import eam.desarrollo.hospital.entidades.Habitacion;
import eam.desarrollo.hospital.entidades.Medicamento;

public class controladorMedicamento implements ActionListener,MouseListener {

	public VentanaMedicamento ventanamedicamento;
	public Medicamento nuevo_medicamento = null;
	public Farmacia farmacia = null;
	public DAOMedicamento Midao = new DAOMedicamento();
	public ArrayList<Farmacia> listaFarmacia;
	
	
	
	public controladorMedicamento(VentanaMedicamento ventanamedicamento) {
		super();
		this.ventanamedicamento = ventanamedicamento;
		listenerbotones();
		listarFarmacia();
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

				String farmacias = ventanamedicamento.JCBFarmacia.getSelectedItem().toString();

				String id = ventanamedicamento.JTFId.getText();
				String nombre=ventanamedicamento.JTFNombreMedicamento.getText();
				String marca=ventanamedicamento.JTFMarcaMedicamento.getText();
				
				farmacia = new Farmacia(
						Integer.toString(ventanamedicamento.JCBFarmacia.getSelectedIndex()),farmacias,null,null);
				
						
				nuevo_medicamento = new Medicamento(id, nombre, marca, farmacia);
				System.out.println(nuevo_medicamento.getIdMedicamento());

				try {
					Midao.crear(nuevo_medicamento);
				} catch (Exception e1) {

				}
				ventanamedicamento.JCBFarmacia.setSelectedIndex(0);
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
					Midao.eliminar(ventanamedicamento.JTFId.getText());
					ventanamedicamento.JCBFarmacia.setSelectedIndex(0);
					
			
					Limpiarformulario();
					JOptionPane.showMessageDialog(null, "Medicamento eliminado", "Info",
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
			String farmacias = ventanamedicamento.JCBFarmacia.getSelectedItem().toString();

			String id = ventanamedicamento.JTFId.getText();
			String nombre=ventanamedicamento.JTFNombreMedicamento.getText();
			String marca=ventanamedicamento.JTFMarcaMedicamento.getText();
			
			farmacia = new Farmacia(
					Integer.toString(ventanamedicamento.JCBFarmacia.getSelectedIndex()),farmacias,null,null);
			
					
			nuevo_medicamento = new Medicamento(id, nombre, marca, farmacia);
			System.out.println(nuevo_medicamento.getIdMedicamento());
			
			try {
				Midao.actualizar(nuevo_medicamento);
				ventanamedicamento.JCBFarmacia.setSelectedIndex(0);
				Limpiarformulario();
				JOptionPane.showMessageDialog(null, "Medicamento actualizado", "Info", JOptionPane.INFORMATION_MESSAGE);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			break;
			
		case "BUSCAR":
			try {
				nuevo_medicamento = Midao.buscar(ventanamedicamento.JTFId.getText());
				if (nuevo_medicamento != null) {
					ventanamedicamento.JCBFarmacia.setSelectedIndex(
							Integer.parseInt(nuevo_medicamento.getFarmacia().getIdFarmacia()));
					ventanamedicamento.JTFNombreMedicamento.setText(nuevo_medicamento.getNombreMedicamento());
					ventanamedicamento.JTFMarcaMedicamento.setText(nuevo_medicamento.getMarcaMedicamento());
					
					JOptionPane.showMessageDialog(null, "Medicamento encontrado", "Info", JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "Medicamento no encontrado", "Info",
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
	
	public void listarFarmacia() {
		listaFarmacia = Midao.listarFarmacias();
		for (int i = 0; i < listaFarmacia.size(); i++) {
			String item = listaFarmacia.get(i).getNombreFarmacia();
			ventanamedicamento.JCBFarmacia.addItem(item);
		}
	}
	
	public void Limpiarformulario() {
		this.ventanamedicamento.JTFId.setText("");
		this.ventanamedicamento.JTFNombreMedicamento.setText("");
		this.ventanamedicamento.JTFMarcaMedicamento.setText("");
		
	}
	
	private void listenerbotones() {
		// TODO Auto-generated method stub
		try {
			this.ventanamedicamento.btnRegistrar.addActionListener(this);
			this.ventanamedicamento.btnBuscar.addActionListener(this);
			this.ventanamedicamento.btnEliminar.addActionListener(this);
			this.ventanamedicamento.btnModificar.addActionListener(this);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public boolean verificarformulario() {

		if (this.ventanamedicamento.JTFId.getText().equals("") || this.ventanamedicamento.JCBFarmacia.getSelectedItem()=="SELECCIONE OPCION"|| this.ventanamedicamento.JTFMarcaMedicamento.getText().equals("") || this.ventanamedicamento.JTFNombreMedicamento.getText().equals("")) {
			return false;
		}
		return true;
	}

	public boolean verificarVacio() {

		if (this.ventanamedicamento.JTFId.getText().equals("") ) {
			return true;
		}
		return false;
	}

}
