package eam.desarrollo.hospital.controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import eam.desarollo.hospital.utils.UtilsForms;
import eam.desarollo.hospital.vistas.VentanaCita;
import eam.desarrollo.hospital.DAO.DAOCita;
import eam.desarrollo.hospital.DAO.DAOConsultorio;
import eam.desarrollo.hospital.DAO.DAOEstadoCita;
import eam.desarrollo.hospital.DAO.DAOMedico;
import eam.desarrollo.hospital.DAO.DAOPaciente;
import eam.desarrollo.hospital.DAO.DAOTipoCita;
import eam.desarrollo.hospital.entidades.Cita;
import eam.desarrollo.hospital.entidades.Citas;
import eam.desarrollo.hospital.entidades.Consultorio;
import eam.desarrollo.hospital.entidades.EstadoCita;
import eam.desarrollo.hospital.entidades.EstadoConsultorio;
import eam.desarrollo.hospital.entidades.Genero;
import eam.desarrollo.hospital.entidades.Medico;
import eam.desarrollo.hospital.entidades.Municipio;
import eam.desarrollo.hospital.entidades.Paciente;
import eam.desarrollo.hospital.entidades.TipoCita;
import eam.desarrollo.hospital.entidades.Tipodocumento;

public class controladorCita implements ActionListener, MouseListener, ItemListener {
	public VentanaCita ventanacita;
	public Cita nueva_cita = null;
	public DAOCita Midao = new DAOCita();
	public DAOPaciente MidaoPaciente = new DAOPaciente();
	public DAOMedico MidaoMedico = new DAOMedico();
	public DAOTipoCita MidaoTipoCita = new DAOTipoCita();
	public DAOEstadoCita MidaoEstadoCita = new DAOEstadoCita();
	public DAOConsultorio MidaoConsultorio = new DAOConsultorio();
	public ArrayList<TipoCita> listartipoCita;
	public ArrayList<EstadoCita> listarEstadoCita;
	public ArrayList<Consultorio> listarConsultorio;
	public Vector<Medico> listarMedicos;

	/**
	 * 
	 * @param ventanacita
	 */
	public controladorCita(VentanaCita ventanacita) {
		this.ventanacita = ventanacita;
		listarTipoCita();
		listarEstadoCita();
		listarMedicos();
		listarConsultorios();
		listenerbotones();
		validarInputs();
	}

	private void listenerbotones() {
		// TODO Auto-generated method stub
		try {
			this.ventanacita.btnRegistrar.addActionListener(this);
			this.ventanacita.btnBuscar.addActionListener(this);
			this.ventanacita.btnEliminar.addActionListener(this);
			this.ventanacita.btnActualizar.addActionListener(this);
			this.ventanacita.btnBuscarPaciente.addActionListener(this);
		} catch (Exception e) {
			// System.out.println(e.getMessage());
		}
	}

	@Override
	public void actionPerformed(ActionEvent evento) {
		// TODO Auto-generated method stub

		switch (evento.getActionCommand()) {
		case "Registrar":
			if (verificarformulario() && verificarCombo()) {
				String idCita = ventanacita.JTFIdcita.getText();
				TipoCita tipocita = (TipoCita) ventanacita.JCBTipo.getSelectedItem();
				Paciente Paciente = null;
				try {
					Paciente = MidaoPaciente.buscar(ventanacita.JTFDocumentoPaciente.getText());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				EstadoCita EstadoCita = (EstadoCita) ventanacita.JCBEstado.getSelectedItem();
				Consultorio Consultorio = (eam.desarrollo.hospital.entidades.Consultorio) ventanacita.JCBConsultorio
						.getSelectedItem();
				Medico Medico = (eam.desarrollo.hospital.entidades.Medico) ventanacita.JCBMedico.getSelectedItem();
				Date fechaCita = ventanacita.Fecha.getDate();
				String HoraCita = ventanacita.JSPHora1.getValue().toString() + "-"
						+ ventanacita.JSPHora2.getValue().toString();
				nueva_cita = new Cita(idCita, fechaCita, HoraCita, Paciente, tipocita, EstadoCita, Consultorio, Medico);
				try {
					Midao.crear(nueva_cita);
					Limpiarformulario();
				} catch (Exception e) {
					// TODO: handle exception
				}
			}

			break;
		case "Buscar":
			try {

				if (!ventanacita.JTFIdcita.getText().isEmpty()) {
					CargarTablaResultadoBusqueda();
				} else {
					JOptionPane.showMessageDialog(null, "Debe ingresar algun parametro de busqueda", "Info",
							JOptionPane.INFORMATION_MESSAGE);
				}
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			break;
		case "Eliminar":
			try {
				Midao.eliminar(ventanacita.JTFIdcita.getText());
				Limpiarformulario();
				JOptionPane.showMessageDialog(null, "Cita eliminado", "Info", JOptionPane.INFORMATION_MESSAGE);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "Actualizar":
			System.out.println("Actualizar");
			String idCita = ventanacita.JTFIdcita.getText();
			TipoCita tipocita = (TipoCita) ventanacita.JCBTipo.getSelectedItem();
			Paciente Paciente = null;
			try {
				Paciente = MidaoPaciente.buscar(ventanacita.JTFDocumentoPaciente.getText());
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			EstadoCita EstadoCita = (EstadoCita) ventanacita.JCBEstado.getSelectedItem();
			Consultorio Consultorio = (eam.desarrollo.hospital.entidades.Consultorio) ventanacita.JCBConsultorio
					.getSelectedItem();
			Medico Medico = (eam.desarrollo.hospital.entidades.Medico) ventanacita.JCBMedico.getSelectedItem();
			Date fechaCita = ventanacita.Fecha.getDate();
			String HoraCita = ventanacita.JSPHora1.getValue().toString() + "-"
					+ ventanacita.JSPHora2.getValue().toString();
			nueva_cita = new Cita(idCita, fechaCita, HoraCita, Paciente, tipocita, EstadoCita, Consultorio, Medico);
			try {
				Midao.actualizar(nueva_cita);
				Limpiarformulario();
				JOptionPane.showMessageDialog(null, "Cita actualizada", "Info", JOptionPane.INFORMATION_MESSAGE);
			} catch (Exception e) {
				// TODO: handle exception
			}
			break;
		case "Buscar paciente":
			try {
				Paciente paciente = MidaoPaciente.buscar(ventanacita.JTFDocumentoPaciente.getText());
				ventanacita.JTFIdPaciente.setText(paciente.getIdPaciente());
				ventanacita.JTFNombre.setText(paciente.getNombrePaciente());
				ventanacita.JTFApellido.setText(paciente.getApellidoPaciente());
				// ventanacita.J.setText(paciente.getApellidoPaciente());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		}
	}

	public void CargarformularioCita(Cita cita) {
		try {
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
		}
	}

	public void Limpiarformulario() {
		this.ventanacita.JTFIdcita.setText("");
		// this.ventanacita.JTFIdMedico.setText("");
		this.ventanacita.JCBConsultorio.setSelectedIndex(0);
		this.ventanacita.JCBTipo.setSelectedIndex(0);
		this.ventanacita.JCBEstado.setSelectedIndex(0);
		((JTextField) this.ventanacita.Fecha.getDateEditor().getUiComponent()).setText("");
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
		String selectedValue1 = this.ventanacita.JCBConsultorio.getSelectedItem().toString();
		String selectedValue2 = this.ventanacita.JCBTipo.getSelectedItem().toString();
		String selectedValue3 = this.ventanacita.JCBEstado.getSelectedItem().toString();

		try {

			if (selectedValue1 != "SELECCIONE" && selectedValue2 != "SELECCIONE" && selectedValue3 != "SELECCIONE") {
				return true;
			}
		} catch (Exception e) {
			// System.out.println("Mensaje" + e.getMessage());
		}

		return false;
	}

	public void listarTipoCita() {
		listartipoCita = MidaoTipoCita.listarTipocita();
		for (int i = 0; i < listartipoCita.size(); i++) {
			ventanacita.JCBTipo.addItem(new TipoCita(listartipoCita.get(i).getIdTipoCita(),
					listartipoCita.get(i).getDescripcionTipoCita()));
		}
	}

	public void listarEstadoCita() {
		listarEstadoCita = MidaoEstadoCita.listarEstadoCita();
		for (int i = 0; i < listarEstadoCita.size(); i++) {
			// String item = listarEstadoCita.get(i).getDescripcionEstadoCita();
			ventanacita.JCBEstado.addItem(new EstadoCita(listarEstadoCita.get(i).getIdEstadoCita(),
					listarEstadoCita.get(i).getDescripcionEstadoCita()));
		}
	}

	public void listarConsultorios() {
		listarConsultorio = MidaoConsultorio.listarConsultorioCita();
		for (int i = 0; i < listarConsultorio.size(); i++) {
			// String item = listarConsultorio.get(i).getIdConsultario();
			ventanacita.JCBConsultorio.addItem(new Consultorio(listarConsultorio.get(i).getIdConsultario(),
					listarConsultorio.get(i).getDescripcionConsultorio(),
					listarConsultorio.get(i).getEstadoConsultorio()));
		}
	}

	public void listarMedicos() {
		listarMedicos = MidaoMedico.listarMedico();
		for (int i = 0; i < listarMedicos.size(); i++) {
			// String item = listarMedicos.get(i).getNombreMedico() + " " +
			// listarMedicos.get(i).getApellidoMedico();
			ventanacita.JCBMedico.addItem(new Medico(listarMedicos.get(i).getIdMedico(),
					listarMedicos.get(i).getNombreMedico(), listarMedicos.get(i).getApellidoMedico(),
					listarMedicos.get(i).getTelefonoMedico(), listarMedicos.get(i).getDireccionMedico(),
					listarMedicos.get(i).getEmailMedico(), listarMedicos.get(i).getTelefonoEmergenciaMedico(),
					listarMedicos.get(i).getFechaNacimientoMedico(), listarMedicos.get(i).getNumeroDocumentoMedico(),
					listarMedicos.get(i).getTipodocumento()));
			// ventanacita.JCBMedico.setSelectedIndex(Integer.parseInt(listarMedicos.get(i).getIdMedico()));
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
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
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void itemStateChanged(ItemEvent event) {
		// TODO Auto-generated method stub
		// System.out.println(event.getStateChange());
		// System.out.println(ItemEvent.SELECTED);
		if (event.getStateChange() == ItemEvent.SELECTED) {
			Object item = event.getItem();
			// do something with object
		}

	}

	public void CargarTablaResultadoBusqueda() throws Exception {
		// TODO Auto-generated method stub
		DefaultTableModel TbmodelC = new DefaultTableModel();
		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
		tcr.setHorizontalAlignment(SwingConstants.CENTER);

		// DefaultTableModel TbmodelC = new DefaultTableModel();
		ventanacita.JTBresultado.setModel(TbmodelC);
		TbmodelC.setColumnIdentifiers(new Object[] { "Id cita", "fecha cita", "hora cita", "paciente", "tipo cita",
				"estado cita", "consultorio", "medico" });
		// ventanaconsultorio.JTBConsultorio.getColumnModel().getColumn(0).setCellRenderer(ventanaconsultorio.JTBConsultorio.getTableHeader().getDefaultRenderer());
		ResultSet resultado = Midao.buscar(ventanacita.JTFIdcita.getText());

		try {
			while (resultado.next()) {
				try {
					TbmodelC.addRow(new Object[] { resultado.getString("id_cita"), resultado.getString("fecha_cita"),
							resultado.getString("hora_cita"), resultado.getString("nombre_paciente")+ " "+ resultado.getString("apellido_paciente"),
							resultado.getString("descripcion_tipo_cita"),
							resultado.getString("descripcion_estado_cita"), resultado.getString("id_consultario"),
							resultado.getString("nombre_medico") + " " + resultado.getString("apellido_medico") });

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			for (int i = 0; i < 8; i++) {
				ventanacita.JTBresultado.getColumnModel().getColumn(i).setCellRenderer(tcr);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void validarInputs(){
		//Solo Numeros
		UtilsForms.Solo_numeros(this.ventanacita.JTFDocumentoPaciente);
	}

}
