package eam.desarrollo.hospital.DAO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;

import eam.desarrollo.hospital.conexion.Conexion;
import eam.desarrollo.hospital.entidades.EstadoCita;
import eam.desarrollo.hospital.entidades.EstadoConsultorio;
import eam.desarrollo.hospital.entidades.Genero;
import eam.desarrollo.hospital.entidades.Municipio;
import eam.desarrollo.hospital.entidades.Paciente;
import eam.desarrollo.hospital.entidades.Tipodocumento;
import eam.desarrollo.hospital.interfaces.IntEstadoCita;

public class DAOEstadoCita implements IntEstadoCita {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
	}

	@Override
	public void crear(EstadoCita estadocita) throws Exception {
		// TODO Auto-generated method stub
		try {

			String sql = "INSERT INTO  estado_cita(id_estado_cita,descripcion_estado_cita) VALUES(?,?)";
			// System.out.println(sql);

			Connection con = Conexion.getConexion();
			PreparedStatement stm = con.prepareStatement(sql);

			/*
			 * Tipodocumento tipo_documento= paciente.getTipodocumento();
			 * Municipio municipio = paciente.getMunicipio(); Genero genero=
			 * paciente.getGenero();
			 */

			stm.setString(1, estadocita.getIdEstadoCita());
			stm.setString(2, estadocita.getDescripcionEstadoCita());
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
	public EstadoCita buscar(String numerocita) throws Exception {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				Connection con = Conexion.getConexion();
				// String sql = "SELECT * from paciente WHERE
				// numero_documento_paciente=?";
				String sql = "SELECT  * from estado_cita where id_estado_cita = ?";

				// String sql2 = "SELECT tipo_documento from tipodocumento WHERE
				// id_documento=?";
				java.sql.PreparedStatement pstmt = con.prepareStatement(sql);
				// java.sql.PreparedStatement pstmt2 = con.prepareStatement(sql2);
				pstmt.setString(1, numerocita);
				// ejecutar consulta
				java.sql.ResultSet res = pstmt.executeQuery();
				// java.sql.ResultSet res = pstmt.executeQuery();
				EstadoCita estadocita = null;
				// hubo un registro....
				System.out.println(res);
				if (res.next()) {
					String idestadocita = res.getString(1);
					String descripcionestadocita = res.getString(2);
					estadocita = new EstadoCita(idestadocita,descripcionestadocita);
				}
				con.close();
				return estadocita;
	}

	@Override
	public void eliminar(String idEstadiCita) throws Exception {
		// TODO Auto-generated method stub
		try {
			// System.out.println(sql);
			Connection con = Conexion.getConexion();
			String sql2 = "DELETE from estado_cita WHERE id_estado_cita=?";
			java.sql.PreparedStatement stm2 = con.prepareStatement(sql2);
			stm2.setString(1, idEstadiCita);
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
	public void actualizar(EstadoCita cita) throws Exception {
		// TODO Auto-generated method stub
		try {

			String sql = "UPDATE estado_cita SET id_estado_cita=?,descripcion_estado_cita=? where id_estado_cita=?";
			// System.out.println(sql);
			Connection con = Conexion.getConexion();
			java.sql.PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, cita.getIdEstadoCita());
			stm.setString(2, cita.getDescripcionEstadoCita());
			stm.executeUpdate();

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			// Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE,
			// null, ex);
		}
	}

	@Override
	public ArrayList<EstadoCita> listarEstadoCita() {
		// TODO Auto-generated method stub
		EstadoCita estadocitaob = null;
		ArrayList<EstadoCita> listEstadocita = new ArrayList<>();
		// Tipodocumento tipDocumento;
		try {

			String sql = "SELECT * FROM estado_cita ";
			Connection con = Conexion.getConexion();
			java.sql.PreparedStatement stm = con.prepareStatement(sql);
			java.sql.ResultSet rs = stm.executeQuery();
			
			while (rs.next()) {
				estadocitaob = new EstadoCita(rs.getString("id_estado_cita"),
						rs.getString("descripcion_estado_cita"));
				listEstadocita.add(estadocitaob);

			}

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return listEstadocita;
	}

}
