package eam.desarrollo.hospital.DAO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;

import eam.desarrollo.hospital.conexion.Conexion;
import eam.desarrollo.hospital.entidades.Diagnostico;
import eam.desarrollo.hospital.entidades.Formula;
import eam.desarrollo.hospital.entidades.Medico;
import eam.desarrollo.hospital.entidades.Paciente;
import eam.desarrollo.hospital.interfaces.IntFormula;

public class DAOFormula implements IntFormula {

	@Override
	public void crear(Formula formula) throws Exception {
		// TODO Auto-generated method stub
		try {

			String sql = "INSERT INTO  formula (id_formula,fecha,id_medico,id_paciente) VALUES (?,?,?,?)";
			Connection con = Conexion.getConexion();
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, formula.getIdFormula());
			stm.setObject(2, formula.getFechaFormula());
			stm.setString(3,formula.getMedico().getIdMedico());
			stm.setString(4,formula.getPaciente().getIdPaciente());
			stm.executeUpdate();

			JOptionPane.showMessageDialog(null, "Formula registrada", "Info", JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			
		}
		
	}

	@Override
	public Formula buscar(String id) throws Exception {
		Connection con = Conexion.getConexion();
		String sql="SELECT f.id_formula,f.fecha,f.id_medico,f.id_paciente,m.id_medico,m.nombre_medico,p.id_paciente,p.nombre_paciente from formula as f join medico as m on f.id_medico=m.id_medico join paciente as p on p.id_paciente=f.id_paciente where f.id_formula=?";
		java.sql.PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, id);
		// ejecutar consulta
		java.sql.ResultSet res = pstmt.executeQuery();
		Formula formula = null;
		// hubo un registro....
		System.out.println(res);
		if (res.next()) {
			
			String idformulaf = res.getString(1);
			Date fecha = res.getDate(2);
			String medicoformula = res.getString(3);
			String pacienteformula = res.getString(4);
			String medico = res.getString(5);
			String nombreMedico = res.getString(6);
			String paciente = res.getString(7);
			String nombrepaciente = res.getString(8);
			
			Paciente pacientes = new Paciente(paciente,nombrepaciente,null,null,null,null,null,null,null,null,null);
			Medico medicos = new Medico(medico,nombreMedico,null,null,null,null,null,null,null,null);
			
			formula=new Formula(idformulaf, fecha, medicos, pacientes);
		}
		con.close();
		return formula;
	}

	@Override
	public void eliminar(String id) throws Exception {
		// TODO Auto-generated method stub
		try {
			Connection con = Conexion.getConexion();
			String sql2 = "DELETE from formula WHERE id_formula=?";
			java.sql.PreparedStatement stm2 = con.prepareStatement(sql2);
			stm2.setString(1, id);
			stm2.executeUpdate();

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			System.out.print("Formula eliminada");
		}
		
	}

	@Override
	public void actualizar(Formula formula) throws Exception {
		// TODO Auto-generated method stub

		try {

			String sql = "UPDATE formula SET fecha=?,id_medico=?,id_paciente=? where id_formula=?";
			Connection con = Conexion.getConexion();
			java.sql.PreparedStatement stm = con.prepareStatement(sql);
			stm.setObject(1, formula.getFechaFormula());
			stm.setString(2,formula.getMedico().getIdMedico());
			stm.setString(3, formula.getPaciente().getIdPaciente());
			stm.setString(4, formula.getIdFormula());
			stm.executeUpdate();

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			
		}
		
	}

	@Override
	public ResultSet listarFormula() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	public ArrayList<Medico> listarMedico() {
		Medico medico = null;
		ArrayList<Medico> listMedico = new ArrayList<>();
		
		try {

			String sql = "SELECT * FROM medico ";
			Connection con = Conexion.getConexion();
			java.sql.PreparedStatement stm = con.prepareStatement(sql);
			java.sql.ResultSet rs = stm.executeQuery();
			
			while (rs.next()) {
				medico= new Medico(rs.getString("id_medico"),
						rs.getString("nombre_medico"),rs.getString("apellido_medico"),rs.getString("telefono_medico"),rs.getString("direccion_medico"),rs.getString("email_medico"),rs.getString("telefono_emergencia_medico"),rs.getDate("fecha_nacimiento_medico"),rs.getString("numero_documento_medico"),null);
				
				listMedico.add(medico);

			}

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return listMedico;

	}
	
	public ArrayList<Paciente> listarPaciente() {
		Paciente paciente = null;
		ArrayList<Paciente> listPaciente = new ArrayList<>();
		
		try {

			String sql = "SELECT * FROM paciente ";
			Connection con = Conexion.getConexion();
			java.sql.PreparedStatement stm = con.prepareStatement(sql);
			java.sql.ResultSet rs = stm.executeQuery();
			
			while (rs.next()) {
				paciente= new Paciente(rs.getString("id_paciente"),
						rs.getString("nombre_paciente"),rs.getString("apellido_paciente"),rs.getString("direccion_paciente"),rs.getDate("fecha_nacimiento_paciente"),rs.getString("telefono_paciente"),rs.getFloat("peso_paciente"),rs.getString("numero_documento_paciente"),null,null,null);
				
				listPaciente.add(paciente);

			}

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return listPaciente;

	}

}
