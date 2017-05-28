package eam.desarrollo.hospital.controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import eam.desarollo.hospital.vistas.VentanaMedicamentoProvedor;
import eam.desarrollo.hospital.entidades.Cama;
import eam.desarrollo.hospital.entidades.EstadoCama;
import eam.desarrollo.hospital.entidades.Habitacion;
import eam.desarrollo.hospital.entidades.Medicamento;
import eam.desarrollo.hospital.entidades.MedicamentoProveedor;
import eam.desarrollo.hospital.entidades.Proveedor;
import eam.desarrollo.hospital.DAO.DAOMedicamentoProveedor;

public class controladorMedicamentoProveedor implements ActionListener {
	public VentanaMedicamentoProvedor ventanamedicamentoproveedor;
	public MedicamentoProveedor nuevo_medicamento_proveedor;
	public DAOMedicamentoProveedor Midao = new DAOMedicamentoProveedor();
	public ArrayList<Medicamento> listaMedicamento;
	public ArrayList<Proveedor> listaProveedor;
	
	
	
	
	public controladorMedicamentoProveedor(VentanaMedicamentoProvedor ventanamedicamentoproveedor) {
		super();
		this.ventanamedicamentoproveedor = ventanamedicamentoproveedor;
		listenerbotones();
		listarMedicamento();
		listarProveedor();
		
	}
	

	private void listenerbotones() {
		// TODO Auto-generated method stub
		try {
			this.ventanamedicamentoproveedor.btnRegistrar.addActionListener(this);
			this.ventanamedicamentoproveedor.btnBuscar.addActionListener(this);
			this.ventanamedicamentoproveedor.btnEliminar.addActionListener(this);
			this.ventanamedicamentoproveedor.btnModificar.addActionListener(this);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	


	@Override
	public void actionPerformed(ActionEvent e) {
	
		switch (e.getActionCommand()) {
		case "REGISTRAR":
			if (verificarformulario()) {

				
				String id = ventanamedicamentoproveedor.JTFId.getText();
				String lote=ventanamedicamentoproveedor.JTFLote.getText();
				Integer cantidad=Integer.parseInt(ventanamedicamentoproveedor.JTFCantidad.getText());
				String medicamento= ventanamedicamentoproveedor.JCBMedicamento.getSelectedItem().toString();
				
				String proveedor = ventanamedicamentoproveedor.JCBProveedor.getSelectedItem().toString();
				Date fechavencimiento = ventanamedicamentoproveedor.dateChooser.getDate();
				Medicamento medicamentos = new Medicamento(
						Integer.toString(ventanamedicamentoproveedor.JCBMedicamento.getSelectedIndex()), medicamento,null,null);
				Proveedor proveedores = new Proveedor(Integer.toString(ventanamedicamentoproveedor.JCBProveedor.getSelectedIndex()),proveedor,null,null,null,null);
				nuevo_medicamento_proveedor = new MedicamentoProveedor(id,cantidad,lote,fechavencimiento,proveedores,medicamentos);
						
				

				try {
					Midao.crear(nuevo_medicamento_proveedor);
				} catch (Exception e1) {

				}
				
				
				Limpiarformulario();
				
			} else {
				JOptionPane.showMessageDialog(ventanamedicamentoproveedor.frame, "Por favor ingrese sus datos", "Info",
						JOptionPane.INFORMATION_MESSAGE);
			}

			break;
		

		case "ELIMINAR":
			try {
				if (!verificarVacio()) {
					Midao.eliminar(ventanamedicamentoproveedor.JTFId.getText());
					Limpiarformulario();
					JOptionPane.showMessageDialog(ventanamedicamentoproveedor.frame, "Medicamento eliminado", "Info",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(ventanamedicamentoproveedor.frame, "Llene el campo requerido");
				}

			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			break;
			

		case "ACTUALIZAR":
			String id = ventanamedicamentoproveedor.JTFId.getText();
			String lote=ventanamedicamentoproveedor.JTFLote.getText();
			Integer cantidad=Integer.parseInt(ventanamedicamentoproveedor.JTFCantidad.getText());
			String medicamento= ventanamedicamentoproveedor.JCBMedicamento.getSelectedItem().toString();
			
			String proveedor = ventanamedicamentoproveedor.JCBProveedor.getSelectedItem().toString();
			Date fechavencimiento = ventanamedicamentoproveedor.dateChooser.getDate();
			Medicamento medicamentos = new Medicamento(
					Integer.toString(ventanamedicamentoproveedor.JCBMedicamento.getSelectedIndex()), medicamento,null,null);
			Proveedor proveedores = new Proveedor(Integer.toString(ventanamedicamentoproveedor.JCBProveedor.getSelectedIndex()),proveedor,null,null,null,null);
			nuevo_medicamento_proveedor = new MedicamentoProveedor(id,cantidad,lote,fechavencimiento,proveedores,medicamentos);
			try {
				Midao.actualizar(nuevo_medicamento_proveedor);
			
				Limpiarformulario();
				JOptionPane.showMessageDialog(ventanamedicamentoproveedor.frame, "Medicamento actualizado", "Info", JOptionPane.INFORMATION_MESSAGE);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			break;
			
		case "BUSCAR":
			try {
				nuevo_medicamento_proveedor=Midao.buscar(ventanamedicamentoproveedor.JTFId.getText());
				
				if (nuevo_medicamento_proveedor != null) {
					
					ventanamedicamentoproveedor.JTFCantidad.setText(Integer.toString(nuevo_medicamento_proveedor.getCantidadMedicamento()));
					ventanamedicamentoproveedor.JTFLote.setText(nuevo_medicamento_proveedor.getLoteMedicamento());
					ventanamedicamentoproveedor.dateChooser.setDate(nuevo_medicamento_proveedor.getFechaVencimento());
					ventanamedicamentoproveedor.JCBMedicamento.setSelectedIndex(
							Integer.parseInt(nuevo_medicamento_proveedor.getMedicamento().getIdMedicamento()));
					ventanamedicamentoproveedor.JCBProveedor.setSelectedIndex(Integer.parseInt(nuevo_medicamento_proveedor.getProveedor().getIdProveedor()));
					
					JOptionPane.showMessageDialog(ventanamedicamentoproveedor.frame, "Medicamento encontrado", "Info", JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(ventanamedicamentoproveedor.frame, "Medicamento no encontrado", "Info",
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
	public void listarMedicamento(){
		listaMedicamento=Midao.listarMedicamento();
		for(int i=0;i<listaMedicamento.size();i++){
			String item=listaMedicamento.get(i).getNombreMedicamento();
			ventanamedicamentoproveedor.JCBMedicamento.addItem(item);
		}
		
	}
	public void listarProveedor(){
		listaProveedor=Midao.listarProveedor();
		for(int i=0;i<listaProveedor.size();i++){
			String item=listaProveedor.get(i).getEmpresa();
			ventanamedicamentoproveedor.JCBProveedor.addItem(item);
			
		}
	}
	
	public boolean verificarformulario() {

		if (this.ventanamedicamentoproveedor.JTFId.getText().equals("") || this.ventanamedicamentoproveedor.JCBMedicamento.getSelectedItem()=="SELECCIONE OPCION" || this.ventanamedicamentoproveedor.JCBProveedor.getSelectedItem()=="SELECCIONE OPCION"||this.ventanamedicamentoproveedor.JTFCantidad.getText().equals("")||this.ventanamedicamentoproveedor.JTFLote.getText().equals("")) {
			return false;
		}
		return true;
	}

	public boolean verificarVacio() {

		if (this.ventanamedicamentoproveedor.JTFId.getText().equals("") ) {
			return true;
		}
		return false;
	}
	
	public void Limpiarformulario(){
		this.ventanamedicamentoproveedor.JCBMedicamento.setSelectedIndex(0);
		this.ventanamedicamentoproveedor.JCBProveedor.setSelectedIndex(0);
		this.ventanamedicamentoproveedor.JTFId.setText("");
		this.ventanamedicamentoproveedor.JTFLote.setText("");
		this.ventanamedicamentoproveedor.JTFCantidad.setText("");
		((JTextField) this.ventanamedicamentoproveedor.dateChooser.getDateEditor().getUiComponent()).setText("");
	}

}
