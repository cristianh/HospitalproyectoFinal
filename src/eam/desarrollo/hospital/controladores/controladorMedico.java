package eam.desarrollo.hospital.controladores;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.jws.Oneway;
import javax.swing.BorderFactory;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.Border;

import com.mysql.jdbc.Connection;

import eam.desarollo.hospital.utils.UtilsForms;
import eam.desarollo.hospital.vistas.VentanaMedico;
import eam.desarrollo.hospital.DAO.DAOMedico;
import eam.desarrollo.hospital.conexion.Conexion;
import eam.desarrollo.hospital.entidades.EstadoConsultorio;
import eam.desarrollo.hospital.entidades.Genero;
import eam.desarrollo.hospital.entidades.Medico;
import eam.desarrollo.hospital.entidades.Municipio;
import eam.desarrollo.hospital.entidades.Medico;
import eam.desarrollo.hospital.entidades.Tipodocumento;
import eam.desarrollo.hospital.reports.ReportExporter;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

public class controladorMedico  implements ActionListener{

	public VentanaMedico ventanamedico;
	public Medico nuevo_medico = null;
	public DAOMedico Midao = new DAOMedico();
	public ArrayList<Tipodocumento> listaDoc;
	public ArrayList<Medico> listaMedico;
	public UtilsForms ultisforms = new UtilsForms();
	
	
	public controladorMedico(VentanaMedico ventanamedico) {
		super();
		this.ventanamedico = ventanamedico;
		listenerbotones();
		listarTipoDocumento();
		validarInputs();
	}



	private void listenerbotones() {
		// TODO Auto-generated method stub
		this.ventanamedico.btnRegistrar.addActionListener(this);
		this.ventanamedico.btnBuscar.addActionListener(this);
		this.ventanamedico.btnEliminar.addActionListener(this);
		this.ventanamedico.btnActualizar.addActionListener(this);
		this.ventanamedico.JBTReporte.addActionListener(this);
	}
	
	public void CargarformularioMedico(Medico medico) {
		try {
			this.ventanamedico.JTFIdmedico.setText(medico.getIdMedico());
			this.ventanamedico.JTFNombremedico.setText(medico.getNombreMedico());
			this.ventanamedico.JTFApellidomedico.setText(medico.getApellidoMedico());
			this.ventanamedico.JTFDireccionmedico.setText(medico.getDireccionMedico());
			this.ventanamedico.JTFNumerodocumento.setText(medico.getNumeroDocumentoMedico());
			this.ventanamedico.JTFTelefonoemergencia.setText(medico.getTelefonoEmergenciaMedico());
			this.ventanamedico.JTFTelefonomedico.setText(medico.getTelefonoMedico());
			this.ventanamedico.JTFEmailmedico.setText(medico.getEmailMedico());
		} catch (Exception e) {
			System.out.println("Mensaje" + e.getLocalizedMessage());
		}
	}
	
	public void Limpiarformulario() {
		this.ventanamedico.JTFIdmedico.setText("");
		this.ventanamedico.JTFNombremedico.setText("");
		this.ventanamedico.JTFApellidomedico.setText("");
		this.ventanamedico.JTFDireccionmedico.setText("");
		this.ventanamedico.JTFNumerodocumento.setText("");
		this.ventanamedico.JTFTelefonoemergencia.setText("");
		this.ventanamedico.JTFTelefonomedico.setText("");
		this.ventanamedico.JTFEmailmedico.setText("");
		this.ventanamedico.JCBTipodocumentomedico.setSelectedIndex(0);
		((JTextField) this.ventanamedico.dateChooser.getDateEditor().getUiComponent()).setText("");
	}
	
	public boolean verificarformulario() {
		 if(this.ventanamedico.JTFNumerodocumento.getText().toString().length()<10){
			 JOptionPane.showMessageDialog(null, "El numero de documento es muy corto por favor verifiquelo", "Info",
						JOptionPane.INFORMATION_MESSAGE);
			 return false;
		 }
		 else if(this.ventanamedico.JTFTelefonomedico.getText().toString().length()<7){
			 JOptionPane.showMessageDialog(null, "El numero de telefono es muy corto por favor verifiquelo", "Info",
						JOptionPane.INFORMATION_MESSAGE);
			 return false;
		 }else
		 {
			 return true; 
		 }
	}
	
	public boolean verificarCombo() {
		String selectedValue1 = this.ventanamedico.JCBTipodocumentomedico.getSelectedItem().toString();
		

		try {

			if (selectedValue1 != "SELECCIONE") {
				return true;
			}
		} catch (Exception e) {
			System.out.println("Mensaje" + e.getMessage());
		}

		return false;
	}



	@Override
	public void actionPerformed(ActionEvent evento) {
		// TODO Auto-generated method stub
		System.out.println(evento.getActionCommand());
		switch (evento.getActionCommand()) {
		case "REGISTRAR":
			if (verificarformulario() && verificarCombo()) {
				String idmedico = ventanamedico.JTFIdmedico.getText();
				String nombreMedico = ventanamedico.JTFNombremedico.getText();
				String apellidoMedico = ventanamedico.JTFApellidomedico.getText();
				String direccionMedico = ventanamedico.JTFDireccionmedico.getText();
				Date fechaNacimientoMedico = ventanamedico.dateChooser.getDate();
				String telefonoMedico = ventanamedico.JTFTelefonomedico.getText();
				String telefonoEmergenciaMedico = ventanamedico.JTFTelefonoemergencia.getText();
				String emailMedico = ventanamedico.JTFEmailmedico.getText();
				String numeroDocumentoMedico = ventanamedico.JTFNumerodocumento.getText();
				Tipodocumento tipodocumento = new Tipodocumento(
						Integer.toString(ventanamedico.JCBTipodocumentomedico.getSelectedIndex()),
						ventanamedico.JCBTipodocumentomedico.getSelectedItem().toString());
				nuevo_medico = new Medico(idmedico, nombreMedico, apellidoMedico, telefonoMedico, direccionMedico, emailMedico, telefonoEmergenciaMedico, fechaNacimientoMedico, numeroDocumentoMedico, tipodocumento);
				
				try {
					Midao.crear(nuevo_medico);
				} catch (Exception e1) {

				}
				Limpiarformulario();
			} 

			break;
		case "BUSCAR":
			try {
				nuevo_medico = Midao.buscar(ventanamedico.JTFNumerodocumento.getText());
				if (nuevo_medico != null) {
					ventanamedico.JCBTipodocumentomedico
							.setSelectedIndex(Integer.parseInt(nuevo_medico.getTipodocumento().getIdTipoDocumento()));
					ventanamedico.dateChooser.setDate(nuevo_medico.getFechaNacimientoMedico());
					CargarformularioMedico(nuevo_medico);
					JOptionPane.showMessageDialog(null, "Usuario encontrado", "Info", JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "Usuario no encontrado", "Info",
							JOptionPane.INFORMATION_MESSAGE);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
			break;
		case "ELIMINAR":
			try {
				Midao.eliminar(ventanamedico.JTFIdmedico.getText());
				Limpiarformulario();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			break;
		case "ACTUALIZAR":
			String idmedico = ventanamedico.JTFIdmedico.getText();
			String nombreMedico = ventanamedico.JTFNombremedico.getText();
			String apellidoMedico = ventanamedico.JTFApellidomedico.getText();
			String direccionMedico = ventanamedico.JTFDireccionmedico.getText();
			Date fechaNacimientoMedico = ventanamedico.dateChooser.getDate();
			String telefonoMedico = ventanamedico.JTFTelefonomedico.getText();
			String telefonoEmergenciaMedico = ventanamedico.JTFTelefonoemergencia.getText();
			String emailMedico = ventanamedico.JTFEmailmedico.getText();
			String numeroDocumentoMedico = ventanamedico.JTFNumerodocumento.getText();
			Tipodocumento tipodocumento = new Tipodocumento(
					Integer.toString(ventanamedico.JCBTipodocumentomedico.getSelectedIndex()),
					ventanamedico.JCBTipodocumentomedico.getSelectedItem().toString());
			nuevo_medico = new Medico(idmedico, nombreMedico, apellidoMedico, telefonoMedico, direccionMedico, emailMedico, telefonoEmergenciaMedico, fechaNacimientoMedico, numeroDocumentoMedico, tipodocumento);
			try {
				Midao.actualizar(nuevo_medico);
				Limpiarformulario();
				JOptionPane.showMessageDialog(null, "Usuario actualizado", "Info", JOptionPane.INFORMATION_MESSAGE);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			break;
		case "Generar Reporte":
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setDialogTitle("Specify a file to save");
			
			fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			int userSelection = fileChooser.showSaveDialog(ventanamedico.frmMedico);
			File fileToSave = fileChooser.getSelectedFile();
			if (userSelection == JFileChooser.APPROVE_OPTION) {
				
				try {
			    	Medico medico = null;
			    	Tipodocumento tipodoc = null;
			    	java.sql.ResultSet rs = null;
			    	Connection con = Conexion.getConexion();
					java.sql.PreparedStatement stm;
					String sql = "SELECT  m.id_medico,m.nombre_medico,m.apellido_medico,m.telefono_medico,m.direccion_medico,m.email_medico,m.telefono_emergencia_medico,m.fecha_nacimiento_medico,m.numero_documento_medico,t.id_tipo_documento,t.tipo_documento from medico as m "
					+ "join tipodocumento as t on t.id_tipo_documento = m.id_tipo_documento";
					stm = con.prepareStatement(sql);
					rs = stm.executeQuery();
					
					ArrayList<Medico> listMed = new ArrayList<>();
					
					while (rs.next()) {
						tipodoc= new Tipodocumento(rs.getString("id_tipo_documento"), rs.getString("tipo_documento"));
						//medico = new Medico(rs.getString("id_medico"),rs.getString("nombre_medico"),rs.getString("apellido_medico"),rs.getString("telefono_medico"),rs.getString("direccion_medico"),rs.getString("email_medico"),rs.getString("telefono_emergencia_medico"),rs.getDate("fecha_nacimiento_medico"),rs.getString("numero_documento_medico"),tipodoc);
						listMed.add(new Medico(rs.getString("id_medico"),rs.getString("nombre_medico"),rs.getString("apellido_medico"),rs.getString("telefono_medico"),rs.getString("direccion_medico"),rs.getString("email_medico"),rs.getString("telefono_emergencia_medico"),rs.getDate("fecha_nacimiento_medico"),rs.getString("numero_documento_medico"),tipodoc));
						/*try {
							list.add(new Medico(rs.getString("id_medico"),rs.getString("nombre_medico"),rs.getString("apellido_medico"),rs.getString("telefono_medico"),rs.getString("direccion_medico"),rs.getString("email_medico"),rs.getString("telefono_emergencia_medico"),rs.getDate("fecha_nacimiento_medico"),rs.getString("numero_documento_medico"),tipodoc));	
						} catch (Exception e) {
							// TODO: handle exception
							System.out.println(e.getMessage());
						}*/
						
					}
					
					System.out.println(listMed);
					
					Map<String, Object> parameters = new HashMap<String, Object>();
//					INICIO
					/*ArrayList<DataBean> beans = new ArrayList<DataBean>();
					beans.add(new DataBean("2010", "enero", 10.1));
					beans.add(new DataBean("2010", "febrero", 15.9));
					beans.add(new DataBean("2010", "marzo", 17.1));
					beans.add(new DataBean("2011", "enero", 9.0));
					beans.add(new DataBean("2011", "febrero", 3.7));
					beans.add(new DataBean("2011", "marzo", 4.3));
					parameters.put("CHART_DATASET", new JRBeanCollectionDataSource(beans));*/
								
//					FIN
					ReportExporter reportExporter = new ReportExporter();
					reportExporter.export("ReporteMedicos2.jasper", fileToSave.getAbsolutePath(), parameters,listMed);

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				} catch (JRException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			    /*try {
			    	Connection con = Conexion.getConexion();
			    	String sourceFileXml = "C:/Users/Casa1/Documents/GitHub/Hospitalproyecto/src/reportes/ReporteMedicos2.jrxml";
					String sql = "SELECT  m.id_medico,m.nombre_medico,m.apellido_medico,m.telefono_medico,m.direccion_medico,m.email_medico,m.telefono_emergencia_medico,m.fecha_nacimiento_medico,m.numero_documento_medico,t.id_tipo_documento,t.tipo_documento from medico as m "
							+ "join tipodocumento as t on t.id_tipo_documento = m.id_tipo_documento";
				    String con_where;
				    String class_source="/Medico/";
				    Map paremetersMap= new HashMap();
				    InputStream is = getClass().getResourceAsStream(sourceFileXml);
				    
				    JRDesignQuery jrDesingQuery = new JRDesignQuery();
				    jrDesingQuery.setText(sql);
				    
				    JasperDesign jasperDesing= JRXmlLoader.load(is);
				    jasperDesing.setQuery(jrDesingQuery);
					JasperReport jaspertReport = JasperCompileManager.compileReport(jasperDesing);
					JasperPrint jasperprint = JasperFillManager.fillReport(jaspertReport, paremetersMap,con);
					JasperViewer.viewReport(jasperprint,false);
					JasperExportManager.exportReportToPdfFile(jasperprint,fileToSave.getAbsolutePath());
					
				} catch (JRException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
			   
			}
			break;

		}
	}
	
	
	public void listarTipoDocumento() {
		listaDoc = Midao.listarDocumento();
		System.out.println(listaDoc);
		for (int i = 0; i < listaDoc.size(); i++) {
			String item = listaDoc.get(i).getTipoDocumento();
			ventanamedico.JCBTipodocumentomedico.addItem(item);
		}
	}
	
	public void validarInputs(){
		
		UtilsForms.Solo_letras(this.ventanamedico.JTFNombremedico);
		UtilsForms.Solo_letras(this.ventanamedico.JTFApellidomedico);
		//Valicar Letras
		UtilsForms.Solo_numeros(this.ventanamedico.JTFIdmedico);
		UtilsForms.Solo_numeros(this.ventanamedico.JTFNumerodocumento);
		UtilsForms.Solo_numeros(this.ventanamedico.JTFTelefonoemergencia);
		UtilsForms.Solo_numeros(this.ventanamedico.JTFTelefonomedico);
		//Validar si vacio
		UtilsForms.validarVacio(ventanamedico.JTFIdmedico);
		UtilsForms.validarVacio(ventanamedico.JTFNombremedico);
		UtilsForms.validarVacio(ventanamedico.JTFApellidomedico);
		UtilsForms.validarVacio(ventanamedico.JTFDireccionmedico);
		UtilsForms.validarVacio(ventanamedico.JTFNumerodocumento);
		UtilsForms.validarVacio(ventanamedico.JTFTelefonoemergencia);
		UtilsForms.validarVacio(ventanamedico.JTFTelefonomedico);
		UtilsForms.validarVacio(ventanamedico.JTFEmailmedico);
		//Validar email
		UtilsForms.validaremail(ventanamedico.JTFEmailmedico.getText());
	
	}

}
