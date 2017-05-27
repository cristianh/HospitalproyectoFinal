package eam.desarrollo.hospital.controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import eam.desarollo.hospital.vistas.VentanaDiagnostico;
import eam.desarrollo.hospital.DAO.DAODiagnostico;
import eam.desarrollo.hospital.entidades.Cama;
import eam.desarrollo.hospital.entidades.Diagnostico;
import eam.desarrollo.hospital.entidades.EstadoCama;
import eam.desarrollo.hospital.entidades.Habitacion;
import eam.desarrollo.hospital.entidades.Medico;
import eam.desarrollo.hospital.entidades.Paciente;

public class controladorDiagnostico implements ActionListener {
	public VentanaDiagnostico ventanadiagnostico;
	public Diagnostico nuevo_diagnostico=null;
	public DAODiagnostico Midao = new DAODiagnostico();
	public ArrayList<Medico> listaMedico;
	public ArrayList<Paciente> listaPaciente;
	public Medico medico=null;
	public Paciente paciente=null;
	
	
	
	public controladorDiagnostico(VentanaDiagnostico ventanadiagnostico) {
		super();
		this.ventanadiagnostico = ventanadiagnostico;
		listarPaciente();
		listarMedico();
		listenerbotones();
	}
	
	public void listarPaciente(){
		listaPaciente = Midao.listarPaciente();
		for (int i = 0; i < listaPaciente.size(); i++) {
			String item = listaPaciente.get(i).getNombrePaciente();
			ventanadiagnostico.JCBPaciente.addItem(item);
		}
	}
	
	public void listarMedico(){
		listaMedico = Midao.listarMedico();
		for (int i = 0; i < listaMedico.size(); i++) {
			String item = listaMedico.get(i).getNombreMedico();
			ventanadiagnostico.JCBMedico.addItem(item);
		}
	}

	public void listenerbotones(){
		this.ventanadiagnostico.Registrar.addActionListener(this);
		this.ventanadiagnostico.Buscar.addActionListener(this);
		this.ventanadiagnostico.Eliminar.addActionListener(this);
		this.ventanadiagnostico.Actualizar.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	switch(e.getActionCommand()){
	case "Registrar":
		if(verificarformulario()){
			String medicos=ventanadiagnostico.JCBMedico.getSelectedItem().toString();
			String pacientes=ventanadiagnostico.JCBPaciente.getSelectedItem().toString();
			String id=ventanadiagnostico.JTFID.getText();
			String nombre=ventanadiagnostico.JTFNombre.getText();
			String descripcion=ventanadiagnostico.JTPDescripcion.getText();
			medico = new Medico(Integer.toString(ventanadiagnostico.JCBMedico.getSelectedIndex()),medicos,null,null,null,null,null,null,null,null);
			paciente=new Paciente(Integer.toString(ventanadiagnostico.JCBPaciente.getSelectedIndex()),pacientes,null,null,null,null,null,null,null,null,null);
			nuevo_diagnostico=new Diagnostico(id, nombre, descripcion, medico, paciente);
			try{
				Midao.crear(nuevo_diagnostico);
				Limpiarformulario();
				
			}catch (Exception e1) {
				// TODO: handle exception
			}
		}else{
			JOptionPane.showMessageDialog(null, "Por favor ingrese sus datos", "Info",
					JOptionPane.INFORMATION_MESSAGE);
		}
		break;
		
	case "Eliminar":
		try {
			if (!verificarVacio()) {
				Midao.eliminar(ventanadiagnostico.JTFID.getText());
				
		
				Limpiarformulario();
				JOptionPane.showMessageDialog(null, "Diagnostico eliminado", "Info",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "Llene el campo requerido");
			}

		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		break;
		
	case "Buscar":
		try {
			nuevo_diagnostico = Midao.buscar(ventanadiagnostico.JTFID.getText());
			if (nuevo_diagnostico != null) {
				ventanadiagnostico.JCBMedico.setSelectedIndex(
						Integer.parseInt(nuevo_diagnostico.getMedico().getIdMedico()));
				ventanadiagnostico.JCBPaciente.setSelectedIndex(Integer.parseInt(nuevo_diagnostico.getPaciente().getIdPaciente()));
				ventanadiagnostico.JTFNombre.setText(nuevo_diagnostico.getNombreDiagnostico());
				ventanadiagnostico.JTPDescripcion.setText(nuevo_diagnostico.getDescripcionDiagnostico());
				JOptionPane.showMessageDialog(null, "Diagnostico encontrado", "Info", JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "Diagnostico no encontrado", "Info",
						JOptionPane.INFORMATION_MESSAGE);
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			System.out.println(e1.getMessage());
		}
		break;
		
	case "Actualizar":
		if(verificarformulario()){
			String medicos=ventanadiagnostico.JCBMedico.getSelectedItem().toString();
			String pacientes=ventanadiagnostico.JCBPaciente.getSelectedItem().toString();
			String id=ventanadiagnostico.JTFID.getText();
			String nombre=ventanadiagnostico.JTFNombre.getText();
			String descripcion=ventanadiagnostico.JTPDescripcion.getText();
			medico = new Medico(Integer.toString(ventanadiagnostico.JCBMedico.getSelectedIndex()),medicos,null,null,null,null,null,null,null,null);
			paciente=new Paciente(Integer.toString(ventanadiagnostico.JCBPaciente.getSelectedIndex()),pacientes,null,null,null,null,null,null,null,null,null);
			nuevo_diagnostico=new Diagnostico(id, nombre, descripcion, medico, paciente);
		try {
			Midao.actualizar(nuevo_diagnostico);
			
			Limpiarformulario();
			JOptionPane.showMessageDialog(null, "Diagnostico actualizada", "Info", JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		}
		else{
			JOptionPane.showMessageDialog(null, "Por favor ingrese sus datos", "Info",
					JOptionPane.INFORMATION_MESSAGE);
		}

		break;
	}
		
	}
		
	
	
	public boolean verificarformulario() {

		if (this.ventanadiagnostico.JTFID.getText().equals("") || this.ventanadiagnostico.JCBMedico.getSelectedItem()=="SELECCIONE OPCION" || this.ventanadiagnostico.JCBPaciente.getSelectedItem()=="SELECCIONE OPCION"||this.ventanadiagnostico.JTFNombre.getText().equals("")||this.ventanadiagnostico.JTPDescripcion.getText().equals("")) {
			return false;
		}
		return true;
	}
	public boolean verificarVacio() {

		if (this.ventanadiagnostico.JTFID.getText().equals("") ) {
			return true;
		}
		return false;
	}
	
	public void Limpiarformulario() {
		this.ventanadiagnostico.JTFID.setText("");
		this.ventanadiagnostico.JTFNombre.setText("");
		this.ventanadiagnostico.JTPDescripcion.setText("");
		this.ventanadiagnostico.JCBMedico.setSelectedIndex(0);
		this.ventanadiagnostico.JCBPaciente.setSelectedIndex(0);
		
	}


}
