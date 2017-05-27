package eam.desarrollo.hospital.DAO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;

import eam.desarrollo.hospital.conexion.Conexion;
import eam.desarrollo.hospital.entidades.Cita;
import eam.desarrollo.hospital.entidades.EstadoConsultorio;
import eam.desarrollo.hospital.entidades.Genero;
import eam.desarrollo.hospital.entidades.Municipio;
import eam.desarrollo.hospital.entidades.Paciente;
import eam.desarrollo.hospital.entidades.TipoCita;
import eam.desarrollo.hospital.entidades.Tipodocumento;
import eam.desarrollo.hospital.interfaces.IntTipoCita;

public class DAOTipoCita implements IntTipoCita{

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void crear(TipoCita tipocita) throws Exception {
		
		// TODO Auto-generated method stub
				try {

					String sql = "INSERT INTO  paciente(id_tipo_cita,descripcion_tipo_cita) VALUES(?,?)";
					// System.out.println(sql);

					Connection con = Conexion.getConexion();
					PreparedStatement stm = con.prepareStatement(sql);

					/*
					 * Tipodocumento tipo_documento= paciente.getTipodocumento();
					 * Municipio municipio = paciente.getMunicipio(); Genero genero=
					 * paciente.getGenero();
					 */

					stm.setString(1, tipocita.getIdTipoCita());
					stm.setString(2, tipocita.getDescripcionTipoCita());
					stm.executeUpdate();
				} catch (SQLException ex) {
					System.out.println(ex.getMessage());
					// Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE,
					// null, ex);
				} finally {
					JOptionPane.showMessageDialog(null, "Registro exitoso", "Info", JOptionPane.INFORMATION_MESSAGE);
				}
	}

	@Override
	public TipoCita buscar(String numerocita) throws Exception {
		// TODO Auto-generated method stub
		Connection con = Conexion.getConexion();
		// String sql = "SELECT * from paciente WHERE
		// numero_documento_paciente=?";
		String sql = "SELECT  * where id_tipo_cita = ?";

		// String sql2 = "SELECT tipo_documento from tipodocumento WHERE
		// id_documento=?";
		java.sql.PreparedStatement pstmt = con.prepareStatement(sql);
		// java.sql.PreparedStatement pstmt2 = con.prepareStatement(sql2);
		pstmt.setString(1, numerocita);
		// ejecutar consulta
		java.sql.ResultSet res = pstmt.executeQuery();
		// java.sql.ResultSet res = pstmt.executeQuery();
		TipoCita tipocita = null;
		// hubo un registro....
		System.out.println(res);
		if (res.next()) {
			String idTipoCita = res.getString(1);
			String descripcionTipoCita = res.getString(2);
			tipocita = new TipoCita(idTipoCita,descripcionTipoCita);
		}
		con.close();
		return tipocita;
	}

	@Override
	public void eliminar(String idCita) throws Exception {
		// TODO Auto-generated method stub
		try {

			// System.out.println(sql);
			Connection con = Conexion.getConexion();
			String sql2 = "DELETE from tipo_cita WHERE id_tipo_cita=?";
			java.sql.PreparedStatement stm2 = con.prepareStatement(sql2);
			stm2.setString(1, idCita);
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
	public void actualizar(TipoCita cita) throws Exception {
		// TODO Auto-generated method stub
		try {

			String sql = "UPDATE tipo_cita SET (id_tipo_cita,descripcion_tipo_cita) where id_tipo_cita=?";
			// System.out.println(sql);

			Connection con = Conexion.getConexion();
			java.sql.PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, cita.getIdTipoCita());
			stm.setString(2, cita.getDescripcionTipoCita());
			stm.executeUpdate();

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
	}

	@Override
	public ArrayList<TipoCita> listarTipocita() {
		// TODO Auto-generated method stub
		TipoCita estado = null;
		ArrayList<TipoCita> listTipoCita = new ArrayList<>();
		// Tipodocumento tipDocumento;
		try {

			String sql = "SELECT * FROM tipo_cita ";
			Connection con = Conexion.getConexion();
			java.sql.PreparedStatement stm = con.prepareStatement(sql);
			java.sql.ResultSet rs = stm.executeQuery();
			
			while (rs.next()) {
				estado = new TipoCita(rs.getString("id_tipo_cita"),
						rs.getString("descripcion_tipo_cita"));
				listTipoCita.add(estado);

			}

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return listTipoCita;
		
	}

}
