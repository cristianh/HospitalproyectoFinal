package eam.desarrollo.hospital.DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;

import eam.desarrollo.hospital.conexion.Conexion;
import eam.desarrollo.hospital.entidades.Consultorio;
import eam.desarrollo.hospital.entidades.EstadoConsultorio;

import eam.desarrollo.hospital.interfaces.IntConsultorio;

public class DAOConsultorio implements IntConsultorio {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void crear(Consultorio consultorio) throws Exception {
		// TODO Auto-generated method stub
		try {

			String sql = "INSERT INTO  consultorio (id_consultorio,descripcion_consultorio,id_estado_consultorio) VALUES (?,?,?)";
			// System.out.println(sql);

			Connection con = Conexion.getConexion();
			PreparedStatement stm = con.prepareStatement(sql);

			/*
			 * Tipodocumento tipo_documento= paciente.getTipodocumento();
			 * Municipio municipio = paciente.getMunicipio(); Genero genero=
			 * paciente.getGenero();
			 */

			stm.setString(1, consultorio.getIdConsultario());
			stm.setString(2, consultorio.getDescripcionConsultorio());
			stm.setObject(3, consultorio.getEstadoConsultorio().getIdEstadoConsultorio());
			stm.executeUpdate();

			JOptionPane.showMessageDialog(null, "Consultorio registrado", "Info", JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			// Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE,
			// null, ex);
		}

	}

	@Override
	public Consultorio buscar(String idConsultorio) throws Exception {
		Connection con = Conexion.getConexion();
		// String sql = "SELECT * from paciente WHERE
		// numero_documento_paciente=?";
		String sql = "SELECT  c.id_consultorio,c.descripcion_consultorio,c.id_estado_consultorio,es.id_estado_consultorio,es.descripcion_estado_consultorio from consultorio as c join estado_consultorio as es on c.id_estado_consultorio = es.id_estado_consultorio where c.id_consultorio = ?";
		// String sql2 = "SELECT tipo_documento from tipodocumento WHERE
		// id_documento=?";
		java.sql.PreparedStatement pstmt = con.prepareStatement(sql);
		// java.sql.PreparedStatement pstmt2 = con.prepareStatement(sql2);
		pstmt.setString(1, idConsultorio);
		// ejecutar consulta
		java.sql.ResultSet res = pstmt.executeQuery();
		// java.sql.ResultSet res = pstmt.executeQuery();
		Consultorio consultorio = null;
		// hubo un registro....
		System.out.println(res);
		if (res.next()) {
			String idconsultorio = res.getString(1);
			String descripcionconsultorio = res.getString(2);
			String estadoconsultorio = res.getString(3);
			String idestadoconsultorio = res.getString(4);
			String descripcionestadoconsultorio = res.getString(5);
			EstadoConsultorio estado_consultorio = new EstadoConsultorio(idestadoconsultorio,
					descripcionestadoconsultorio);
			consultorio = new Consultorio(idconsultorio, descripcionconsultorio, estado_consultorio);

		}
		con.close();
		return consultorio;
	}

	@Override
	public void eliminar(String id) throws Exception {
		// TODO Auto-generated method stub
		try {

			// System.out.println(sql);
			Connection con = Conexion.getConexion();
			String sql2 = "DELETE from consultorio WHERE id_consultorio=?";
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
	public void actualizar(Consultorio consultorio) throws Exception {
		// TODO Auto-generated method stub

		try {

			String sql = "UPDATE consultorio SET descripcion_consultorio=?,id_estado_consultorio=? where id_consultorio=?";
			// System.out.println(sql);

			Connection con = Conexion.getConexion();
			java.sql.PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, consultorio.getDescripcionConsultorio());
			stm.setString(2, consultorio.getEstadoConsultorio().getIdEstadoConsultorio());
			stm.setString(3, consultorio.getIdConsultario());
			stm.executeUpdate();

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			// Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE,
			// null, ex);
		}

	}
	
	public ArrayList<Consultorio> listarConsultorioCita() {
		// TODO Auto-generated method stub
		Consultorio consultorio = null;
		ArrayList<Consultorio> listConsultorio = new ArrayList<>();
		// Tipodocumento tipDocumento;
		try {

			String sql = "SELECT  co.id_consultorio,co.descripcion_consultorio,co.id_estado_consultorio,es.descripcion_estado_consultorio from consultorio as co join estado_consultorio as es on co.id_estado_consultorio = es.id_estado_consultorio";
			Connection con = Conexion.getConexion();
			java.sql.PreparedStatement stm = con.prepareStatement(sql);
			java.sql.ResultSet rs = stm.executeQuery();
			
			while (rs.next()) {
				consultorio = new Consultorio(rs.getString("id_consultorio"),
						rs.getString("descripcion_consultorio"),new EstadoConsultorio(rs.getString("id_estado_consultorio"),rs.getString("descripcion_consultorio")));
				listConsultorio.add(consultorio);

			}

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return listConsultorio;
	}

	@Override
	public java.sql.ResultSet listarConsultorio() {
		// TODO Auto-generated method stub
		java.sql.ResultSet rs = null;
		try {
			Connection con = Conexion.getConexion();
			java.sql.PreparedStatement stm;
			String sql = "SELECT  c.id_consultorio,c.descripcion_consultorio,es.descripcion_estado_consultorio from consultorio as c join estado_consultorio as es on c.id_estado_consultorio = es.id_estado_consultorio";
			stm = con.prepareStatement(sql);
			rs = stm.executeQuery();

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return rs;
	}

	public ArrayList<EstadoConsultorio> listarEstadoConsul() {
		EstadoConsultorio estado = null;
		ArrayList<EstadoConsultorio> listEstado = new ArrayList<>();
		// Tipodocumento tipDocumento;
		try {

			String sql = "SELECT * FROM estado_consultorio ";
			Connection con = Conexion.getConexion();
			java.sql.PreparedStatement stm = con.prepareStatement(sql);
			java.sql.ResultSet rs = stm.executeQuery();
			
			while (rs.next()) {
				estado = new EstadoConsultorio(rs.getString("id_estado_consultorio"),
						rs.getString("descripcion_estado_consultorio"));
				listEstado.add(estado);

			}

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return listEstado;

	}

}
