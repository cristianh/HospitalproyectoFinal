/**
 * 
 */
package eam.desarrollo.hospital.controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import eam.desarollo.hospital.utils.UtilsForms;
import eam.desarollo.hospital.vistas.VentanaAgenda;
import eam.desarrollo.hospital.DAO.DAOAgenda;
import eam.desarrollo.hospital.DAO.DAOMedico;
import eam.desarrollo.hospital.entidades.Agenda;
import eam.desarrollo.hospital.entidades.Medico;

/**
 * @author Casa1
 *
 */
public class controladorAgenda implements ActionListener, MouseListener, ItemListener {

	public VentanaAgenda ventanaagenda;
	public Agenda nueva_agenda = null;
	public DAOAgenda Midao = new DAOAgenda();
	public DAOMedico MidaoMedico = new DAOMedico();
	public Vector<Medico> listarMedicos;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * 
	 * @param ventanaagenda
	 */
	public controladorAgenda(VentanaAgenda ventanaagenda) {
		this.ventanaagenda = ventanaagenda;
		listarMedicos();
		listenerbotones();
		validarInputs();
		try {
			CargarTablaAgenda();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void listenerbotones() {
		// TODO Auto-generated method stub
		try {
			this.ventanaagenda.btnRegistrar.addActionListener(this);
			//this.ventanaagenda.btnBuscar.addActionListener(this);
			this.ventanaagenda.btnEliminar.addActionListener(this);
			this.ventanaagenda.btnActualizar.addActionListener(this);
			// this.ventanaagenda.btnBuscarPaciente.addActionListener(this);
		} catch (Exception e) {
			// System.out.println(e.getMessage());
		}
	}

	@Override
	public void itemStateChanged(ItemEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent evento) {
		// TODO Auto-generated method stub
		System.out.println(evento.getActionCommand());
		switch (evento.getActionCommand()) {
		case "REGISTRAR":
			if (verificarformulario() && verificarCombo()) {
				String idAgenda = ventanaagenda.JTFIdagenda.getText();
				Date fechaAgenda = ventanaagenda.dateChooser.getDate();
				String horaAgenda = ventanaagenda.JSPHora1.getValue() + "-" + ventanaagenda.JSPHora2.getValue();
				Medico Medico = (eam.desarrollo.hospital.entidades.Medico) ventanaagenda.JCBMedicoagenda
						.getSelectedItem();
				nueva_agenda = new Agenda(idAgenda, fechaAgenda, horaAgenda, Medico);
				try {
					Midao.crear(nueva_agenda);
					CargarTablaAgenda();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			break;
		case "Buscar":
			/*try {

				if (!ventanacita.JTFIdcita.getText().isEmpty()) {
					CargarTablaResultadoBusqueda();
				} else {
					JOptionPane.showMessageDialog(null, "Debe ingresar algun parametro de busqueda", "Info",
							JOptionPane.INFORMATION_MESSAGE);
				}
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}*/

			break;
		case "ELIMINAR":
			try {
				Midao.eliminar(ventanaagenda.JTFIdagenda.getText());
				//Limpiarformulario();
				CargarTablaAgenda();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "ACTUALIZAR":
			String idAgenda = ventanaagenda.JTFIdagenda.getText();
			Date fechaAgenda = ventanaagenda.dateChooser.getDate();
			String horaAgenda = ventanaagenda.JSPHora1.getValue() + "-" + ventanaagenda.JSPHora2.getValue();
			Medico Medico = (eam.desarrollo.hospital.entidades.Medico) ventanaagenda.JCBMedicoagenda
					.getSelectedItem();
			nueva_agenda = new Agenda(idAgenda, fechaAgenda, horaAgenda, Medico);
			try {
				Midao.actualizar(nueva_agenda);
				CargarTablaAgenda();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case "Buscar paciente":
			/*try {
				Paciente paciente = MidaoPaciente.buscar(ventanacita.JTFDocumentoPaciente.getText());
				ventanacita.JTFIdPaciente.setText(paciente.getIdPaciente());
				ventanacita.JTFNombre.setText(paciente.getNombrePaciente());
				ventanacita.JTFApellido.setText(paciente.getApellidoPaciente());
				// ventanacita.J.setText(paciente.getApellidoPaciente());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			break;

		}
	}

	public void CargarformularioCita() {
		/*try {
			this.ventanacita.JTFIdcita.setText(cita.getIdCita());
			// this.ventanacita.JTFIdMedico.setText(cita.getMedico().getNombreMedico());
			this.ventanacita.JTFIdPaciente.setText(cita.getPaciente().getNombrePaciente());
			this.ventanacita.JCBConsultorio
					.setSelectedIndex(Integer.parseInt(cita.getConsultorio().getIdConsultario()));
			this.ventanacita.JCBTipo.setSelectedIndex(Integer.parseInt(cita.getTipoCita().getIdTipoCita()));
			this.ventanacita.JCBEstado.setSelectedIndex(Integer.parseInt(cita.getEstadoCita().getIdEstadoCita()));
			this.ventanacita.Fecha.setDate(cita.getFechaCita());
		} catch (Exception e) {
			// System.out.println("Mensaje" + e.getLocalizedMessage());
		}*/
	}

	public void Limpiarformulario() {
		/*this.ventanacita.JTFIdcita.setText("");
		// this.ventanacita.JTFIdMedico.setText("");
		this.ventanacita.JCBConsultorio.setSelectedIndex(0);
		this.ventanacita.JCBTipo.setSelectedIndex(0);
		this.ventanacita.JCBEstado.setSelectedIndex(0);
		((JTextField) this.ventanacita.Fecha.getDateEditor().getUiComponent()).setText("");*/
	}

	public boolean verificarformulario() {
		/*
		 * if (this.ventanacita.JTFIdcita.getText().toString().length() < 3) {
		 * JOptionPane.showMessageDialog(null,
		 * "El numero de documento es muy corto por favor verifiquelo", "Info",
		 * JOptionPane.INFORMATION_MESSAGE); return false; } else {
		 * 
		 * }
		 */
		return true;
	}

	public boolean verificarCombo() {
		String selectedValue1 = this.ventanaagenda.JCBMedicoagenda.getSelectedItem().toString();
		try {

			if (selectedValue1 != "SELECCIONE") {
				return true;
			}
		} catch (Exception e) {
			// System.out.println("Mensaje" + e.getMessage());
		}

		return false;
	}

	public void listarMedicos() {
		listarMedicos = MidaoMedico.listarMedico();
		for (int i = 0; i < listarMedicos.size(); i++) {
			// String item = listarMedicos.get(i).getNombreMedico() + " " +
			// listarMedicos.get(i).getApellidoMedico();
			ventanaagenda.JCBMedicoagenda.addItem(new Medico(listarMedicos.get(i).getIdMedico(),
					listarMedicos.get(i).getNombreMedico(), listarMedicos.get(i).getApellidoMedico(),
					listarMedicos.get(i).getTelefonoMedico(), listarMedicos.get(i).getDireccionMedico(),
					listarMedicos.get(i).getEmailMedico(), listarMedicos.get(i).getTelefonoEmergenciaMedico(),
					listarMedicos.get(i).getFechaNacimientoMedico(), listarMedicos.get(i).getNumeroDocumentoMedico(),
					listarMedicos.get(i).getTipodocumento()));
			// ventanacita.JCBMedico.setSelectedIndex(Integer.parseInt(listarMedicos.get(i).getIdMedico()));
		}
	}
	
	public void CargarTablaAgenda() throws Exception {
		// TODO Auto-generated method stub
		DefaultTableModel TbmodelC = new DefaultTableModel();
		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
		tcr.setHorizontalAlignment(SwingConstants.CENTER);

		// DefaultTableModel TbmodelC = new DefaultTableModel();
		ventanaagenda.JTBAgenda.setModel(TbmodelC);
		TbmodelC.setColumnIdentifiers(new Object[] { "Id agenda", "fecha", "horario medico", "nombre medico", "apellido medico"});
		// ventanaconsultorio.JTBConsultorio.getColumnModel().getColumn(0).setCellRenderer(ventanaconsultorio.JTBConsultorio.getTableHeader().getDefaultRenderer());
		ResultSet resultado = Midao.listarAgenda();

		try {
			while (resultado.next()) {
				try {
					TbmodelC.addRow(new Object[] { resultado.getString("id_agenda_medico"), resultado.getString("fecha_agenda"),
							resultado.getString("hora_agenda"), resultado.getString("nombre_medico"),resultado.getString("apellido_medico")});

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			for (int i = 0; i < 5; i++) {
				ventanaagenda.JTBAgenda.getColumnModel().getColumn(i).setCellRenderer(tcr);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void validarInputs(){
		//Valicar numeros
		UtilsForms.Solo_numeros(this.ventanaagenda.JTFIdagenda);
		//Validar si vacio
		UtilsForms.validarVacio(this.ventanaagenda.JTFIdagenda);
	}

}
