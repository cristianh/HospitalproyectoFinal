package eam.desarrollo.hospital.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;

import eam.desarrollo.hospital.conexion.Conexion;
import eam.desarrollo.hospital.entidades.Cama;
import eam.desarrollo.hospital.entidades.EstadoCama;
import eam.desarrollo.hospital.entidades.Farmacia;
import eam.desarrollo.hospital.entidades.Habitacion;
import eam.desarrollo.hospital.interfaces.IntFarmacia;

public class DAOFarmacia implements IntFarmacia{

	@Override
	public void crear(Farmacia farmacia) throws Exception {
		// TODO Auto-generated method stub
		try {

			String sql = "INSERT INTO  farmacia (id_farmacia,nombre_farmacia,persona_a_cargo,telefono_farmacia) VALUES (?,?,?,?)";
			Connection con = Conexion.getConexion();
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, farmacia.getIdFarmacia());
			stm.setString(2, farmacia.getNombreFarmacia());
			stm.setString(3, farmacia.getPersonaACargo());
			stm.setString(4, farmacia.getTelefonoFarmacia());
			stm.executeUpdate();
			JOptionPane.showMessageDialog(null, "Farmacia registrada", "Info", JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			
		}

		
	}

	@Override
	public Farmacia buscar(String id) throws Exception {
		Connection con = Conexion.getConexion();
		String sql = "SELECT  id_farmacia,nombre_farmacia,persona_a_cargo,telefono_farmacia from farmacia where id_farmacia = ?";
		java.sql.PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, id);
		// ejecutar consulta
		java.sql.ResultSet res = pstmt.executeQuery();
		
		Farmacia farmacia = null;
		// hubo un registro....
		System.out.println(res);
		if (res.next()) {
			String idFarmacia = res.getString(1);
			String nombreFarmacia = res.getString(2);
			String personaACargo = res.getString(3);
			String telefonoFarmacia = res.getString(4);
			
			farmacia = new Farmacia(idFarmacia, nombreFarmacia, personaACargo, telefonoFarmacia);
			

		}
		con.close();
		return farmacia;
	}

	@Override
	public void eliminar(String id) throws Exception {
		// TODO Auto-generated method stub

		try {
			Connection con = Conexion.getConexion();
			String sql2 = "DELETE from farmacia WHERE id_farmacia=?";
			java.sql.PreparedStatement stm2 = con.prepareStatement(sql2);
			stm2.setString(1, id);
			stm2.executeUpdate();

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			System.out.print("Farmacia eliminada");
		}
		
	}

	@Override
	public void actualizar(Farmacia farmacia) throws Exception {
		try {

			String sql = "UPDATE farmacia SET nombre_farmacia=?,persona_a_cargo=?,telefono_farmacia=? where id_farmacia=?";
			// System.out.println(sql);

			Connection con = Conexion.getConexion();
			java.sql.PreparedStatement stm = con.prepareStatement(sql);
			
			stm.setString(1, farmacia.getNombreFarmacia());
			stm.setString(2, farmacia.getPersonaACargo());
			stm.setString(3, farmacia.getTelefonoFarmacia());
			stm.setString(4, farmacia.getIdFarmacia());
			stm.executeUpdate();

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			
		}
		
	}

	@Override
	public ResultSet listarFarmacias() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
