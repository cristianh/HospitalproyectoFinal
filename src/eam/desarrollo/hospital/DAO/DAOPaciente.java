package eam.desarrollo.hospital.DAO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;

import javax.swing.JOptionPane;

import java.util.*;

import com.mysql.jdbc.Connection;

import com.mysql.jdbc.ResultSet;

import eam.desarrollo.hospital.conexion.Conexion;
import eam.desarrollo.hospital.entidades.Genero;
import eam.desarrollo.hospital.entidades.Municipio;
import eam.desarrollo.hospital.entidades.Paciente;
import eam.desarrollo.hospital.entidades.Tipodocumento;
import eam.desarrollo.hospital.interfaces.IntPaciente;

/**
 * 
 * @author CRIS77IAN
 *
 */
public class DAOPaciente implements IntPaciente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void crear(Paciente paciente) {
		// TODO Auto-generated method stub
		try {

			String sql = "INSERT INTO  paciente(id_paciente,nombre_paciente,apellido_paciente,direccion_paciente,fecha_nacimiento_paciente,telefono_paciente,peso_paciente,numero_documento_paciente,id_tipo_documento,id_municipio,id_genero) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
			// System.out.println(sql);

			Connection con = Conexion.getConexion();
			PreparedStatement stm = con.prepareStatement(sql);

			/*
			 * Tipodocumento tipo_documento= paciente.getTipodocumento();
			 * Municipio municipio = paciente.getMunicipio(); Genero genero=
			 * paciente.getGenero();
			 */

			stm.setString(1, paciente.getIdPaciente());
			stm.setString(2, paciente.getNombrePaciente());
			stm.setString(3, paciente.getApellidoPaciente());
			stm.setString(4, paciente.getDireccionPaciente());
			stm.setObject(5, paciente.getFechaNacimientoPaciente());
			stm.setString(6, paciente.getTelefonoPaciente());
			stm.setFloat(7, paciente.getPesoPaciente());
			stm.setString(8, paciente.getNumeroDocumentoPaciente());
			stm.setObject(9, paciente.getTipodocumento().getIdTipoDocumento());
			stm.setObject(10, paciente.getMunicipio().getIdMunicipio());
			stm.setObject(11, paciente.getGenero().getIdGenero());
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
	public Paciente buscar(String identificacion) throws Exception {
		// TODO Auto-generated method stub
		Connection con = Conexion.getConexion();
		// String sql = "SELECT * from paciente WHERE
		// numero_documento_paciente=?";
		String sql = "SELECT  p.id_paciente,p.nombre_paciente,p.apellido_paciente,p.direccion_paciente,p.fecha_nacimiento_paciente,p.telefono_paciente,p.peso_paciente,p.numero_documento_paciente,t.id_tipo_documento,t.tipo_documento,m.id_municipio,m.nombre_municipio,g.id_genero,g.tipo from paciente as p join tipodocumento as t on p.id_tipo_documento = t.id_tipo_documento join municipio as m on p.id_municipio = m.id_municipio join genero as g on p.id_genero = g.id_genero where p.numero_documento_paciente = ?";

		// String sql2 = "SELECT tipo_documento from tipodocumento WHERE
		// id_documento=?";
		java.sql.PreparedStatement pstmt = con.prepareStatement(sql);
		// java.sql.PreparedStatement pstmt2 = con.prepareStatement(sql2);
		pstmt.setString(1, identificacion);
		// ejecutar consulta
		java.sql.ResultSet res = pstmt.executeQuery();
		// java.sql.ResultSet res = pstmt.executeQuery();
		Paciente paciente = null;
		// hubo un registro....
		
		if (res.next()) {
			String idPaciente = res.getString(1);
			String nombrePaciente = res.getString(2);
			String apellidoPaciente = res.getString(3);
			String direccionPaciente = res.getString(4);
			Date fechaNacimientoPaciente = res.getDate(5);
			String telefonoPaciente = res.getString(6);
			Float pesoPaciente = res.getFloat(7);
			String numeroDocumentoPaciente = res.getString(8);
			String idtipodocumento = res.getString(9);
			String tipodocumento = res.getString(10);
			String idmunicipio = res.getString(11);
			String nombremunicipio = res.getString(12);
			String id_genero = res.getString(13);
			String tipogenero = res.getString(14);
			
			/*
			 * Tipodocumento tipodocumento= new
			 * Tipodocumento(res.getObject(9).toString(), ); Municipio
			 * municipio= new
			 * Municipio(Integer.toString(JCBMunicipioPaciente.getSelectedIndex(
			 * )), JCBMunicipioPaciente.getSelectedItem().toString());
			 */
			// Genero genero = new
			// Genero(Integer.toString(JCBGeneroPaciente.getSelectedIndex()),
			// JCBGeneroPaciente.getSelectedItem().toString());
			Tipodocumento documento = new Tipodocumento(res.getString(9), res.getString(10));
			Municipio municipio = new Municipio(res.getString(11), res.getString(12));
			Genero genero = new Genero(res.getString(13), res.getString(14));
			paciente = new Paciente(idPaciente, nombrePaciente, apellidoPaciente, direccionPaciente,
					fechaNacimientoPaciente, telefonoPaciente, pesoPaciente, numeroDocumentoPaciente, documento,
					municipio, genero);
		}
		con.close();
		return paciente;
	}

	@Override
	public void eliminar(String id) throws Exception {
		// TODO Auto-generated method stub
		try {

			
			Connection con = Conexion.getConexion();
			String sql2 = "DELETE from paciente WHERE numero_documento_paciente=?";
			java.sql.PreparedStatement stm2 = con.prepareStatement(sql2);
			stm2.setString(1, id);
			stm2.executeUpdate();

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			// Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE,
			// null, ex);
		} finally {
			System.out.print("Usuario eliminado");
		}

	}

	@Override
	public void actualizar(Paciente paciente) throws Exception {
		// TODO Auto-generated method stub
		try {

			String sql = "UPDATE paciente SET nombre_paciente=?,apellido_paciente=?,direccion_paciente=?,fecha_nacimiento_paciente=?,telefono_paciente=?,peso_paciente=?,numero_documento_paciente=?,id_tipo_documento=?,id_municipio=?,id_genero=? where id_paciente=?";
			// System.out.println(sql);

			Connection con = Conexion.getConexion();
			java.sql.PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, paciente.getNombrePaciente());
			stm.setString(2, paciente.getApellidoPaciente());
			stm.setString(3, paciente.getDireccionPaciente());
			stm.setObject(4, paciente.getFechaNacimientoPaciente());
			stm.setString(5, paciente.getTelefonoPaciente());
			stm.setFloat(6, paciente.getPesoPaciente());
			stm.setString(7, paciente.getNumeroDocumentoPaciente());
			stm.setObject(8, paciente.getTipodocumento().getIdTipoDocumento());
			stm.setObject(9, paciente.getMunicipio().getIdMunicipio());
			stm.setObject(10, paciente.getGenero().getIdGenero());
			stm.setString(11, paciente.getIdPaciente());
			stm.executeUpdate();

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

	}

	@Override
	public ArrayList<Paciente> listarPaciente() {
		// TODO Auto-generated method stub
		return null;

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

	public ArrayList<Genero> listarGenero() {
		Genero tipogenero = null;
		ArrayList<Genero> listGene = new ArrayList<>();
		// Tipodocumento tipDocumento;
		try {

			String sql = "SELECT * FROM genero ";
			Connection con = Conexion.getConexion();
			java.sql.PreparedStatement stm = con.prepareStatement(sql);
			java.sql.ResultSet rs = stm.executeQuery();
			/*
			 * if(rs != null){ tipodocumento=(Tipodocumento) rs; }
			 */
			while (rs.next()) {
				tipogenero = new Genero(rs.getString("id_genero"), rs.getString("tipo"));
				listGene.add(tipogenero);

			}

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return listGene;

	}

	public ArrayList<Municipio> listarMunicipio() {
		Municipio municipio = null;
		ArrayList<Municipio> listMuni = new ArrayList<>();
		// Tipodocumento tipDocumento;
		try {

			String sql = "SELECT * FROM municipio where id_departamento=1";
			Connection con = Conexion.getConexion();
			java.sql.PreparedStatement stm = con.prepareStatement(sql);
			java.sql.ResultSet rs = stm.executeQuery();
			/*
			 * if(rs != null){ tipodocumento=(Tipodocumento) rs; }
			 */
			while (rs.next()) {
				municipio = new Municipio(rs.getString("id_municipio"), rs.getString("nombre_municipio"));
				listMuni.add(municipio);

			}

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return listMuni;

	}

}
