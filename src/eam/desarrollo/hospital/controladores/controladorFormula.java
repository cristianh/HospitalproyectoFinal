package eam.desarrollo.hospital.controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import eam.desarollo.hospital.vistas.VentanaFormula;
import eam.desarrollo.hospital.DAO.DAOFormula;
import eam.desarrollo.hospital.entidades.Formula;
import eam.desarrollo.hospital.entidades.Medico;
import eam.desarrollo.hospital.entidades.Paciente;

public class controladorFormula implements ActionListener{
	public VentanaFormula ventanaformula;
	public Formula nueva_formula=null;
	public DAOFormula Midao = new DAOFormula();
	public ArrayList<Medico> listaMedico;
	public ArrayList<Paciente> listaPaciente;
	public Medico medico=null;
	public Paciente paciente=null;
	
	
	
	public controladorFormula(VentanaFormula ventanaformula) {
		super();
		this.ventanaformula = ventanaformula;
		listarPaciente();
		listarMedico();
		listenerbotones();
	}
	public void listarPaciente(){
		listaPaciente = Midao.listarPaciente();
		for (int i = 0; i < listaPaciente.size(); i++) {
			String item = listaPaciente.get(i).getNombrePaciente();
			ventanaformula.JCBPaciente.addItem(item);
		}
	}
	
	public void listarMedico(){
		listaMedico = Midao.listarMedico();
		for (int i = 0; i < listaMedico.size(); i++) {
			String item = listaMedico.get(i).getNombreMedico();
			ventanaformula.JCBMedico.addItem(item);
		}
	}
	
	public void listenerbotones(){
		this.ventanaformula.btnRegistrar.addActionListener(this);
		this.ventanaformula.btnBuscar.addActionListener(this);
		this.ventanaformula.btnActualizar.addActionListener(this);
		this.ventanaformula.btnEliminar.addActionListener(this);
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		switch(e.getActionCommand()){
		case "REGISTRAR":
			if(verificarformulario()){
				String medicos=ventanaformula.JCBMedico.getSelectedItem().toString();
				String pacientes=ventanaformula.JCBPaciente.getSelectedItem().toString();
				Date fecha = ventanaformula.dateChooser.getDate();
				String id=ventanaformula.JTFID.getText();
				
				medico = new Medico(Integer.toString(ventanaformula.JCBMedico.getSelectedIndex()),medicos,null,null,null,null,null,null,null,null);
				paciente=new Paciente(Integer.toString(ventanaformula.JCBPaciente.getSelectedIndex()),pacientes,null,null,null,null,null,null,null,null,null);
				nueva_formula=new Formula(id,fecha,medico, paciente);
				try{
					Midao.crear(nueva_formula);
					Limpiarformulario();
					
				}catch (Exception e1) {
					// TODO: handle exception
				}
			}else{
				JOptionPane.showMessageDialog(null, "Por favor ingrese sus datos", "Info",
						JOptionPane.INFORMATION_MESSAGE);
			}
			break;
			
			
		case "ELIMINAR":
			try {
				if (!verificarVacio()) {
					Midao.eliminar(ventanaformula.JTFID.getText());
					Limpiarformulario();
					JOptionPane.showMessageDialog(null, "Formula eliminada", "Info",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "Llene el campo requerido");
				}

			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			break;
			
		case "BUSCAR":
			try {
				nueva_formula = Midao.buscar(ventanaformula.JTFID.getText());
				if (nueva_formula != null) {
					ventanaformula.JCBMedico.setSelectedIndex(
							Integer.parseInt(nueva_formula.getMedico().getIdMedico()));
					ventanaformula.JCBPaciente.setSelectedIndex(Integer.parseInt(nueva_formula.getPaciente().getIdPaciente()));
					ventanaformula.dateChooser.setDate(nueva_formula.getFechaFormula());
					
					JOptionPane.showMessageDialog(null, "Formula encontrada", "Info", JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "Formula no encontrada", "Info",
							JOptionPane.INFORMATION_MESSAGE);
				}
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				System.out.println(e1.getMessage());
			}
			break;
			
		case "ACTUALIZAR":
			if(verificarformulario()){
				String medicos=ventanaformula.JCBMedico.getSelectedItem().toString();
				String pacientes=ventanaformula.JCBPaciente.getSelectedItem().toString();
				Date fecha = ventanaformula.dateChooser.getDate();
				String id=ventanaformula.JTFID.getText();
				
				medico = new Medico(Integer.toString(ventanaformula.JCBMedico.getSelectedIndex()),medicos,null,null,null,null,null,null,null,null);
				paciente=new Paciente(Integer.toString(ventanaformula.JCBPaciente.getSelectedIndex()),pacientes,null,null,null,null,null,null,null,null,null);
				nueva_formula=new Formula(id,fecha,medico, paciente);
			try {
				Midao.actualizar(nueva_formula);
				
				Limpiarformulario();
				JOptionPane.showMessageDialog(null, "Formula actualizada", "Info", JOptionPane.INFORMATION_MESSAGE);
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

		if (this.ventanaformula.JTFID.getText().equals("") || this.ventanaformula.JCBMedico.getSelectedItem()=="SELECCIONE OPCION" || this.ventanaformula.JCBPaciente.getSelectedItem()=="SELECCIONE OPCION") {
			return false;
		}
		return true;
	}
	public boolean verificarVacio() {

		if (this.ventanaformula.JTFID.getText().equals("") ) {
			return true;
		}
		return false;
	}
	
	public void Limpiarformulario() {
		this.ventanaformula.JTFID.setText("");
		this.ventanaformula.JCBMedico.setSelectedIndex(0);
		this.ventanaformula.JCBPaciente.setSelectedIndex(0);
		
	}

}
