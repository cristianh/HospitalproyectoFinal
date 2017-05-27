package eam.desarrollo.hospital.DAO;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;

import eam.desarrollo.hospital.conexion.Conexion;
import eam.desarrollo.hospital.controladores.controladorConsultorio;
import eam.desarrollo.hospital.entidades.Cama;
import eam.desarrollo.hospital.entidades.Consultorio;
import eam.desarrollo.hospital.entidades.EstadoCama;
import eam.desarrollo.hospital.entidades.EstadoConsultorio;
import eam.desarrollo.hospital.entidades.Habitacion;
import eam.desarrollo.hospital.interfaces.IntHabitacion;

public class DAOHabitacion implements IntHabitacion {

public static void main(String[] args) {
	
	}

@Override
public void crear(Habitacion habitacion) throws Exception {
	// TODO Auto-generated method stub
	try {

		String sql = "INSERT INTO  habitacion (id_habitacion,descripcion_habitacion,id_consultorio) VALUES (?,?,?)";
		

		Connection con = Conexion.getConexion();
		PreparedStatement stm = con.prepareStatement(sql);
		stm.setString(1, habitacion.getIdHabitacion());
		stm.setString(2, habitacion.getDescripcionHabitacion());
		stm.setString(3, habitacion.getConsultorio().getIdConsultario());
		stm.executeUpdate();

		JOptionPane.showMessageDialog(null, "Habitacion registrada", "Info", JOptionPane.INFORMATION_MESSAGE);
	} catch (SQLException ex) {
		System.out.println(ex.getMessage());
		// Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE,
		// null, ex);
	}
	
}

@Override
public Habitacion buscar(String identificacion) throws Exception {
	Connection con = Conexion.getConexion();
	// String sql = "SELECT * from paciente WHERE
	// numero_documento_paciente=?";
	String sql = "SELECT  h.id_habitacion,h.descripcion_habitacion,h.id_consultorio,c.id_consultorio,c.descripcion_consultorio from habitacion   as h join consultorio as c on h.id_consultorio = c.id_consultorio where h.id_habitacion = ?";
	// String sql2 = "SELECT tipo_documento from tipodocumento WHERE
	// id_documento=?";
	java.sql.PreparedStatement pstmt = con.prepareStatement(sql);
	// java.sql.PreparedStatement pstmt2 = con.prepareStatement(sql2);
	pstmt.setString(1, identificacion);
	// ejecutar consulta
	java.sql.ResultSet res = pstmt.executeQuery();
	// java.sql.ResultSet res = pstmt.executeQuery();
	Habitacion habitacion = null;
	// hubo un registro....
	System.out.println(res);
	if (res.next()) {
		String idhabitacion = res.getString(1);
		String descripcion = res.getString(2);
		String idconsultorio = res.getString(3);
		String descripcionCon = res.getString(4);
		
		Consultorio consultorio = new Consultorio(idconsultorio,descripcionCon,null);
		//cama= new Cama(idcama,estado_cama);
		habitacion = new Habitacion(idhabitacion, descripcion, consultorio);

	}
	con.close();
	return habitacion;
}

@Override
public void eliminar(String id) throws Exception {
	// TODO Auto-generated method stub
	try {
		Connection con = Conexion.getConexion();
		String sql2 = "DELETE from habitacion WHERE id_habitacion=?";
		java.sql.PreparedStatement stm2 = con.prepareStatement(sql2);
		stm2.setString(1, id);
		stm2.executeUpdate();

	} catch (SQLException ex) {
		System.out.println(ex.getMessage());
	} finally {
		System.out.print("Habitacion eliminada");
	}
	
}

@Override
public void actualizar(Habitacion habitacion) throws Exception {

	try {

		String sql = "UPDATE habitacion SET descripcion_habitacion =?,id_consultorio=? where id_habitacion=?";
		// System.out.println(sql);

		Connection con = Conexion.getConexion();
		java.sql.PreparedStatement stm = con.prepareStatement(sql);
		
		stm.setString(1, habitacion.getDescripcionHabitacion());
		stm.setString(2, habitacion.getConsultorio().getIdConsultario());
		stm.setString(3, habitacion.getIdHabitacion());
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

public ArrayList<Consultorio> listarConsultorio() {
	Consultorio consultorio = null;
	EstadoConsultorio estado = null;
	ArrayList<Consultorio> listConsultorio = new ArrayList<>();
	// Tipodocumento tipDocumento;
	try {

		String sql = "SELECT * FROM consultorio ";
		System.out.println(sql);
		Connection con = Conexion.getConexion();
		java.sql.PreparedStatement stm = con.prepareStatement(sql);
		java.sql.ResultSet rs = stm.executeQuery();
		
		while (rs.next()) {
			consultorio= new Consultorio(rs.getString("id_consultorio"),
					rs.getString("descripcion_consultorio"),null);
			
			listConsultorio.add(consultorio);

		}

	} catch (SQLException ex) {
		System.out.println(ex.getMessage());
	}

	return listConsultorio;

}
}
