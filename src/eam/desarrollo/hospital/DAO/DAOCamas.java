package eam.desarrollo.hospital.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;

import eam.desarrollo.hospital.conexion.Conexion;
import eam.desarrollo.hospital.entidades.Cama;
import eam.desarrollo.hospital.entidades.Consultorio;
import eam.desarrollo.hospital.entidades.EstadoCama;
import eam.desarrollo.hospital.entidades.EstadoConsultorio;
import eam.desarrollo.hospital.entidades.Habitacion;
import eam.desarrollo.hospital.interfaces.IntCamas;

/**
 * 
 * @author Casa1
 *
 */
public class DAOCamas implements IntCamas {

	public static void main(String[] args) {
		
	}

	@Override
	public void crear(Cama cama) throws Exception {
		try {

			String sql = "INSERT INTO  cama (id_cama,id_estado_cama,id_habitacion) VALUES (?,?,?)";
			// System.out.println(sql);

			Connection con = Conexion.getConexion();
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, cama.getIdCama());
			stm.setString(2, cama.getEstadoCama().getIdEstadoCama());
			stm.setString(3, cama.getHabitacion().getIdHabitacion());
			stm.executeUpdate();

			JOptionPane.showMessageDialog(null, "Cama registrada", "Info", JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			// Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE,
			// null, ex);
		}

		
	}

	@Override
	public Cama buscar(String identificacion) throws Exception {
		Connection con = Conexion.getConexion();
		// String sql = "SELECT * from paciente WHERE
		// numero_documento_paciente=?";
		String sql = "SELECT  c.id_cama,c.id_estado_cama,c.id_habitacion,es.descripcion_estado_cama,h.descripcion_habitacion,h.id_habitacion,es.id_estado_cama from cama   as c join estado_cama as es on c.id_estado_cama = es.id_estado_cama join habitacion as h on c.id_habitacion = h.id_habitacion where c.id_cama = ?";
		// String sql2 = "SELECT tipo_documento from tipodocumento WHERE
		// id_documento=?";
		java.sql.PreparedStatement pstmt = con.prepareStatement(sql);
		// java.sql.PreparedStatement pstmt2 = con.prepareStatement(sql2);
		pstmt.setString(1, identificacion);
		// ejecutar consulta
		java.sql.ResultSet res = pstmt.executeQuery();
		// java.sql.ResultSet res = pstmt.executeQuery();
		Cama cama = null;
		// hubo un registro....
		System.out.println(res);
		if (res.next()) {
			String idcama = res.getString(1);
			String idestadocama = res.getString(2);
			String idHabitacion = res.getString(3);
			String descripcionestadocama = res.getString(4);
			String descripcionhabitacion = res.getString(5);
			
			EstadoCama estado_cama = new EstadoCama(idestadocama,descripcionestadocama);
			Habitacion habitacion = new Habitacion(idHabitacion, descripcionhabitacion, null);
			cama= new Cama(idcama,estado_cama,habitacion);

		}
		con.close();
		return cama;
	}

	@Override
	public void eliminar(String id) throws Exception {
		// TODO Auto-generated method stub
		
		try {
			Connection con = Conexion.getConexion();
			String sql2 = "DELETE from cama WHERE id_cama=?";
			java.sql.PreparedStatement stm2 = con.prepareStatement(sql2);
			stm2.setString(1, id);
			stm2.executeUpdate();

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			System.out.print("Cama eliminada");
		}
		
	}

	@Override
	public void actualizar(Cama cama) throws Exception {
		// TODO Auto-generated method stub
		
		try {

			String sql = "UPDATE cama SET id_estado_cama=? where id_cama=?";
			// System.out.println(sql);

			Connection con = Conexion.getConexion();
			java.sql.PreparedStatement stm = con.prepareStatement(sql);
			
			stm.setString(1, cama.getEstadoCama().getIdEstadoCama());
			stm.setString(2, cama.getIdCama());
			stm.executeUpdate();

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			
		}
		
	}

	@Override
	public ResultSet listarCama() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	public ArrayList<EstadoCama> listarEstadoCama() {
		EstadoCama estado = null;
		ArrayList<EstadoCama> listEstado = new ArrayList<>();
		// Tipodocumento tipDocumento;
		try {

			String sql = "SELECT * FROM estado_cama ";
			Connection con = Conexion.getConexion();
			java.sql.PreparedStatement stm = con.prepareStatement(sql);
			java.sql.ResultSet rs = stm.executeQuery();
			
			while (rs.next()) {
				estado= new EstadoCama(rs.getString("id_estado_cama"),
						rs.getString("descripcion_estado_cama"));
				
				listEstado.add(estado);

			}

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return listEstado;

	}
	
	public ArrayList<Habitacion> listarHabitacion() {
		Habitacion habitacion = null;
		ArrayList<Habitacion> listHabitacion = new ArrayList<>();
		// Tipodocumento tipDocumento;
		try {

			String sql = "SELECT * FROM habitacion ";
			Connection con = Conexion.getConexion();
			java.sql.PreparedStatement stm = con.prepareStatement(sql);
			java.sql.ResultSet rs = stm.executeQuery();
			
			while (rs.next()) {
				habitacion= new Habitacion(rs.getString("id_habitacion"),
						rs.getString("descripcion_habitacion"),null);
				
				listHabitacion.add(habitacion);

			}

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return listHabitacion;

	}
	
	
	
}
