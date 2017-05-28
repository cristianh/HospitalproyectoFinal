/**
 * 
 */
package eam.desarrollo.hospital.controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;

import eam.desarollo.hospital.vistas.VentanaAgenda;
import eam.desarollo.hospital.vistas.VentanaCama;
import eam.desarollo.hospital.vistas.VentanaCita;
import eam.desarollo.hospital.vistas.VentanaConsultorio;
import eam.desarollo.hospital.vistas.VentanaFormulaMedicamento;
import eam.desarollo.hospital.vistas.VentanaHabitacion;
import eam.desarollo.hospital.vistas.VentanaMedicamento;
import eam.desarollo.hospital.vistas.VentanaMedicamentoProvedor;
import eam.desarollo.hospital.vistas.VentanaMedico;
import eam.desarollo.hospital.vistas.VentanaPacientes;
import eam.desarollo.hospital.vistas.VentanaPrincipal;
import eam.desarollo.hospital.vistas.VentanaProveedor;
import eam.desarrollo.hospital.conexion.Conexion;
import eam.desarrollo.hospital.entidades.Medico;
import eam.desarrollo.hospital.entidades.Tipodocumento;
import eam.desarrollo.hospital.reports.ReportExporter;
import net.sf.jasperreports.engine.JRException;

/**
 * @author Casa1
 *
 */
public class controladorVPrincipal extends javax.swing.JFrame implements ActionListener {

	public VentanaPrincipal ventanapricipal;
	public VentanaPacientes ventanapaciente;
	public VentanaAgenda ventanaagenda;
	public VentanaMedico ventanamedico;
	public VentanaCama ventanacama;
	public VentanaCita ventanacita;
	public VentanaConsultorio ventanaconsultorio;
	public VentanaHabitacion ventanahabitacion;
	public VentanaMedicamento ventanamedicamento;
	public VentanaProveedor ventanaproveedor;
	public VentanaMedicamentoProvedor ventanamedicamentoproveedor;
	public VentanaFormulaMedicamento ventanaformulamedicamento;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public controladorVPrincipal(VentanaPrincipal ventanapricipal) {
		super();
		this.ventanapricipal = ventanapricipal;
		listenerbotones();
	}

	private void listenerbotones() {
		// TODO Auto-generated method stub
		this.ventanapricipal.mntmIngresarCama.addActionListener(this);
		this.ventanapricipal.mntmMedicamentoProveedor.addActionListener(this);
		this.ventanapricipal.mntmNuevaAgenda.addActionListener(this);
		this.ventanapricipal.mntmNuevaConsultorio.addActionListener(this);
		this.ventanapricipal.mntmNuevaHabitacion.addActionListener(this);
		this.ventanapricipal.mntmNuevoMedico.addActionListener(this);
		this.ventanapricipal.mntmNuevoPaciente.addActionListener(this);
		this.ventanapricipal.mntmReguistrarMedicamento.addActionListener(this);
		this.ventanapricipal.mntmMedicamentoProveedor_1.addActionListener(this);
		this.ventanapricipal.mntmFormulaMedicamento.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent evento) {
		// TODO Auto-generated method stub
		System.out.println(evento.getActionCommand());
		/*
		 * Nueva agenda Ingresar Cama Nueva consultorio Nueva habitacion
		 * Registrar medicamento Registar Proveedor
		 */
		switch (evento.getActionCommand()) {
		case "Nuevo paciente":
			ventanapaciente = new VentanaPacientes();
			ventanapaciente.frmVentanaPaciente.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			ventanapaciente.frmVentanaPaciente.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
					// System.out.println("Bye");
					ventanaPrincipalVisible();
				}
			});
			ventanapaciente.frmVentanaPaciente.setVisible(true);
			this.ventanapricipal.frmVentanaPrincipal.setVisible(false);
			break;
		case "Nuevo medico":
			ventanamedico = new VentanaMedico();
			ventanamedico.frmMedico.setVisible(true);
			ventanamedico.frmMedico.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			ventanamedico.frmMedico.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
					// System.out.println("Bye");
					ventanaPrincipalVisible();
				}
			});
			ventanamedico.frmMedico.setVisible(true);
			this.ventanapricipal.frmVentanaPrincipal.setVisible(false);
			break;
		case "Nueva agenda":
			ventanaagenda = new VentanaAgenda();
			ventanaagenda.frmAgendaMedico.setVisible(true);
			ventanaagenda.frmAgendaMedico.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			ventanaagenda.frmAgendaMedico.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
					// System.out.println("Bye");
					ventanaPrincipalVisible();
				}
			});
			ventanaagenda.frmAgendaMedico.setVisible(true);
			this.ventanapricipal.frmVentanaPrincipal.setVisible(false);
			break;
		case "Ingresar Cama":
			try {
				ventanacama = new VentanaCama();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			ventanacama.frmCama.setVisible(true);
			ventanacama.frmCama.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			ventanacama.frmCama.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
					// System.out.println("Bye");
					ventanaPrincipalVisible();
				}
			});
			ventanacama.frmCama.setVisible(true);
			this.ventanapricipal.frmVentanaPrincipal.setVisible(false);
			break;
		case "Nueva  consultorio":
			try {
				ventanaconsultorio = new VentanaConsultorio();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			ventanaconsultorio.frmConsultorios.setVisible(true);
			ventanaconsultorio.frmConsultorios.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			ventanaconsultorio.frmConsultorios.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
					// System.out.println("Bye");
					ventanaPrincipalVisible();
				}
			});
			ventanaconsultorio.frmConsultorios.setVisible(true);
			this.ventanapricipal.frmVentanaPrincipal.setVisible(false);
			break;
		case "Nueva habitacion":
			try {
				ventanahabitacion = new VentanaHabitacion();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			ventanahabitacion.frmHabitacion.setVisible(true);
			ventanahabitacion.frmHabitacion.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			ventanahabitacion.frmHabitacion.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
					// System.out.println("Bye");
					ventanaPrincipalVisible();
				}
			});
			ventanahabitacion.frmHabitacion.setVisible(true);
			this.ventanapricipal.frmVentanaPrincipal.setVisible(false);
			break;
		case "Registrar medicamento":
			ventanamedicamento = new VentanaMedicamento();
			ventanamedicamento.frame.setVisible(true);
			ventanamedicamento.frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			ventanamedicamento.frame.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
					// System.out.println("Bye");
					ventanaPrincipalVisible();
				}
			});
			ventanamedicamento.frame.setVisible(true);
			this.ventanapricipal.frmVentanaPrincipal.setVisible(false);

			break;
		case "Registar Proveedor":
			ventanaproveedor = new VentanaProveedor();
			ventanaproveedor.frame.setVisible(true);
			ventanaproveedor.frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			ventanaproveedor.frame.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
					// System.out.println("Bye");
					ventanaPrincipalVisible();
				}
			});
			ventanaproveedor.frame.setVisible(true);
			this.ventanapricipal.frmVentanaPrincipal.setVisible(false);

			break;
		case "Medicamento Proveedor":
			ventanamedicamentoproveedor = new VentanaMedicamentoProvedor();
			ventanamedicamentoproveedor.frame.setVisible(true);
			ventanamedicamentoproveedor.frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			ventanamedicamentoproveedor.frame.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
					// System.out.println("Bye");
					ventanaPrincipalVisible();
				}
			});
			ventanamedicamentoproveedor.frame.setVisible(true);
			this.ventanapricipal.frmVentanaPrincipal.setVisible(false);

			break;
		case "Formula medicamento":
			ventanaformulamedicamento = new VentanaFormulaMedicamento();
			ventanaformulamedicamento.frame.setVisible(true);
			ventanaformulamedicamento.frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			ventanaformulamedicamento.frame.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
					// System.out.println("Bye");
					ventanaPrincipalVisible();
				}
			});
			ventanaformulamedicamento.frame.setVisible(true);
			this.ventanapricipal.frmVentanaPrincipal.setVisible(false);
			break;
		}
	}

	public void ventanaPrincipalVisible() {
		this.ventanapricipal.frmVentanaPrincipal.setVisible(true);
	}

}
