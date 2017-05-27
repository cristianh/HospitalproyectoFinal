/**
 * 
 */
package eam.desarrollo.hospital.DAO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import javax.management.Query;
import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;

import eam.desarrollo.hospital.conexion.Conexion;
import eam.desarrollo.hospital.entidades.Genero;
import eam.desarrollo.hospital.entidades.Medico;
import eam.desarrollo.hospital.entidades.Municipio;
import eam.desarrollo.hospital.entidades.Paciente;
import eam.desarrollo.hospital.entidades.Tipodocumento;
import eam.desarrollo.hospital.interfaces.IntMedico;


/**
 * @author Casa1
 *
 */
public class DAOMedico implements IntMedico {

	@Override
	public void crear(Medico medico) throws Exception {
		// TODO Auto-generated method stub
		try {

			String sql = "INSERT INTO  medico(id_medico, nombre_medico, apellido_medico, telefono_medico,direccion_medico, email_medico, telefono_emergencia_medico, fecha_nacimiento_medico, numero_documento_medico, id_tipo_documento) VALUES(?,?,?,?,?,?,?,?,?,?)";
			// System.out.println(sql);

			Connection con = Conexion.getConexion();
			PreparedStatement stm = con.prepareStatement(sql);

			/*
			 * Tipodocumento tipo_documento= paciente.getTipodocumento();
			 * Municipio municipio = paciente.getMunicipio(); Genero genero=
			 * paciente.getGenero();
			 */

			stm.setString(1, medico.getIdMedico());
			stm.setString(2, medico.getNombreMedico());
			stm.setString(3, medico.getApellidoMedico());
			stm.setString(4, medico.getTelefonoMedico());
			stm.setString(5, medico.getDireccionMedico());
			stm.setString(6, medico.getEmailMedico());
			stm.setString(7, medico.getTelefonoEmergenciaMedico());
			stm.setObject(8, medico.getFechaNacimientoMedico());
			stm.setObject(9, medico.getNumeroDocumentoMedico());
			stm.setObject(10, medico.getTipodocumento().getIdTipoDocumento());
			stm.executeUpdate();

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			// Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE,
			// null, ex);
		} finally {
			JOptionPane.showMessageDialog(null, "Usuario registrado", "Info", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	@Override
	public Medico buscar(String documentomedico) throws Exception {
		// TODO Auto-generated method stub
		Connection con = Conexion.getConexion();
		// String sql = "SELECT * from paciente WHERE
		// numero_documento_paciente=?";
		String sql = "SELECT  m.id_medico,m.nombre_medico,m.apellido_medico,m.telefono_medico,m.direccion_medico,m.email_medico,m.telefono_emergencia_medico,m.fecha_nacimiento_medico,m.numero_documento_medico,t.id_tipo_documento,t.tipo_documento from medico as m "
				+ "join tipodocumento as t on t.id_tipo_documento = m.id_tipo_documento where m.numero_documento_medico = ?";

		// String sql2 = "SELECT tipo_documento from tipodocumento WHERE
		// id_documento=?";
		java.sql.PreparedStatement pstmt = con.prepareStatement(sql);
		// java.sql.PreparedStatement pstmt2 = con.prepareStatement(sql2);
		pstmt.setString(1, documentomedico);
		// ejecutar consulta
		java.sql.ResultSet res = pstmt.executeQuery();
		// java.sql.ResultSet res = pstmt.executeQuery();
		Medico medico = null;
		// hubo un registro....
		if (res.next()) {
			String idmedico = res.getString(1);
			String nombreMedico = res.getString(2);
			String apellidoMedico = res.getString(3);
			String telefonoMedico = res.getString(4);
			String direccionMedico = res.getString(5);
			String emailMedico = res.getString(6);
			String telefonoEmergenciaMedico = res.getString(7);
			Date fechaNacimientoMedico = res.getDate(8);
			String numeroDocumentoMedico = res.getString(9);
			Tipodocumento tipodocumento = new Tipodocumento(res.getString(10), res.getString(11));
			medico = new Medico(idmedico, nombreMedico, apellidoMedico, telefonoMedico, direccionMedico, emailMedico,
					telefonoEmergenciaMedico, fechaNacimientoMedico, numeroDocumentoMedico, tipodocumento);

		}
		con.close();
		return medico;

	}

	@Override
	public void eliminar(String idmedico) throws Exception {
		// TODO Auto-generated method stub
		try {

			// System.out.println(sql);
			Connection con = Conexion.getConexion();
			String sql2 = "DELETE from medico WHERE id_medico=?";
			java.sql.PreparedStatement stm2 = con.prepareStatement(sql2);
			stm2.setString(1, idmedico);
			stm2.executeUpdate();

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			// Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE,
			// null, ex);
		} finally {
			JOptionPane.showMessageDialog(null, "Usuario eliminado", "Info", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	@Override
	public void actualizar(Medico medico) throws Exception {
		// TODO Auto-generated method stub

		try {
			String sql = "UPDATE medico SET id_medico=?,nombre_medico=?,apellido_medico=?,telefono_medico=?,direccion_medico=?,email_medico=?,telefono_emergencia_medico=?,fecha_nacimiento_medico=?,numero_documento_medico=?,id_tipo_documento=? where id_medico=?";
			// System.out.println(sql);

			Connection con = Conexion.getConexion();
			java.sql.PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, medico.getIdMedico());
			stm.setString(2, medico.getNombreMedico());
			stm.setString(3, medico.getApellidoMedico());
			stm.setObject(4, medico.getTelefonoMedico());
			stm.setString(5, medico.getDireccionMedico());
			stm.setString(6, medico.getEmailMedico());
			stm.setString(7, medico.getTelefonoEmergenciaMedico());
			stm.setObject(8, medico.getFechaNacimientoMedico());
			stm.setString(9, medico.getNumeroDocumentoMedico());
			stm.setObject(10, medico.getTipodocumento().getIdTipoDocumento());
			stm.setString(11, medico.getIdMedico());
			stm.executeUpdate();

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
	}

	

	public java.sql.ResultSet listarMedicoRS() {
		// TODO Auto-generated method stub
		java.sql.ResultSet rs = null;
		try {
			Connection con = Conexion.getConexion();
			java.sql.PreparedStatement stm;
			String sql = "SELECT  m.id_medico,m.nombre_medico,m.apellido_medico,m.telefono_medico,m.direccion_medico,m.email_medico,m.telefono_emergencia_medico,m.fecha_nacimiento_medico,m.numero_documento_medico,t.id_tipo_documento,t.tipo_documento from medico as m "
					+ "join tipodocumento as t on t.id_tipo_documento = m.id_tipo_documento";
			stm = con.prepareStatement(sql);
			rs = stm.executeQuery();

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return rs;
	}

	public ArrayList<Tipodocumento> listarDocumento() {
		Tipodocumento tipodocumento = null;
		ArrayList<Tipodocumento> listDoc = new ArrayList<>();
		// Tipodocumento tipDocumento;
		try {

			String sql = "SELECT * FROM tipodocumento ";
			Connection con = Conexion.getConexion();
			java.sql.PreparedStatement stm = con.prepareStatement(sql);
			java.sql.ResultSet rs = stm.executeQuery();
			/*
			 * if(rs != null){ tipodocumento=(Tipodocumento) rs; }
			 */
			while (rs.next()) {
				tipodocumento = new Tipodocumento(rs.getString("id_tipo_documento"), rs.getString("tipo_documento"));
				listDoc.add(tipodocumento);

			}

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return listDoc;

	}

	@Override
	public Vector<Medico> listarMedico() {
		Medico medico = null;
		Vector<Medico> listMedico = new Vector<>();
		// Tipodocumento tipDocumento;
		try {

			String sql = "SELECT  m.id_medico,m.nombre_medico,m.apellido_medico,m.telefono_medico,m.direccion_medico,m.email_medico,m.telefono_emergencia_medico,m.fecha_nacimiento_medico,m.numero_documento_medico,t.id_tipo_documento,t.tipo_documento from medico as m "
				+ "join tipodocumento as t on t.id_tipo_documento = m.id_tipo_documento";
			Connection con = Conexion.getConexion();
			java.sql.PreparedStatement stm = con.prepareStatement(sql);
			java.sql.ResultSet res = stm.executeQuery();
			
			while (res.next()) {
				String idmedico = res.getString(1);
				String nombreMedico = res.getString(2);
				String apellidoMedico = res.getString(3);
				String telefonoMedico = res.getString(4);
				String direccionMedico = res.getString(5);
				String emailMedico = res.getString(6);
				String telefonoEmergenciaMedico = res.getString(7);
				Date fechaNacimientoMedico = res.getDate(8);
				String numeroDocumentoMedico = res.getString(9);
				Tipodocumento tipodocumento = new Tipodocumento(res.getString(10), res.getString(11));
				medico = new Medico(idmedico, nombreMedico, apellidoMedico, telefonoMedico, direccionMedico, emailMedico,
						telefonoEmergenciaMedico, fechaNacimientoMedico, numeroDocumentoMedico, tipodocumento);
				listMedico.addElement(medico);
				System.out.println(medico.toString());
			}

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return listMedico;
	}

	
}
