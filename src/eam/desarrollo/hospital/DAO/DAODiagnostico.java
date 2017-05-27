package eam.desarrollo.hospital.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;

import eam.desarrollo.hospital.conexion.Conexion;
import eam.desarrollo.hospital.entidades.Cama;
import eam.desarrollo.hospital.entidades.Diagnostico;
import eam.desarrollo.hospital.entidades.EstadoCama;
import eam.desarrollo.hospital.entidades.Habitacion;
import eam.desarrollo.hospital.entidades.Medico;
import eam.desarrollo.hospital.entidades.Paciente;
import eam.desarrollo.hospital.interfaces.IntDiagnostico;

public class DAODiagnostico implements IntDiagnostico {

	@Override
	public void crear(Diagnostico diagnostico) throws Exception {
		// TODO Auto-generated method stub
		try {

			String sql = "INSERT INTO  diagnostico (id_diagnostico,nombre_diagnostico,descripcion_diagnostico,id_medico,id_paciente) VALUES (?,?,?,?,?)";
			// System.out.println(sql);

			Connection con = Conexion.getConexion();
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, diagnostico.getIdDiagnostico());
			stm.setString(2, diagnostico.getNombreDiagnostico());
			stm.setString(3,diagnostico.getDescripcionDiagnostico() );
			stm.setString(4,diagnostico.getMedico().getIdMedico());
			stm.setString(5,diagnostico.getPaciente().getIdPaciente());
			stm.executeUpdate();

			JOptionPane.showMessageDialog(null, "Diagnostico registrado", "Info", JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			// Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE,
			// null, ex);
		}
	}

	@Override
	public Diagnostico buscar(String id) throws Exception {
		Connection con = Conexion.getConexion();
		String sql="SELECT d.id_diagnostico,d.nombre_diagnostico,d.descripcion_diagnostico,d.id_medico,d.id_paciente,m.id_medico,m.nombre_medico,p.id_paciente,p.nombre_paciente from diagnostico as d join medico as m on d.id_medico = m.id_medico join paciente as p on p.id_paciente=d.id_paciente where d.id_diagnostico=?";
	
		java.sql.PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, id);
		// ejecutar consulta
		java.sql.ResultSet res = pstmt.executeQuery();
		Diagnostico diagnostico = null;
		// hubo un registro....
		System.out.println(res);
		if (res.next()) {
			
			String iddiagnosticod = res.getString(1);
			String nombrediagnostico = res.getString(2);
			String descripciondiagnostico = res.getString(3);
			String medicodiagnostico = res.getString(4);
			String pacientediagnostico = res.getString(5);
			String medico = res.getString(6);
			String nombreMedico = res.getString(7);
			String paciente = res.getString(8);
			String nombrepaciente = res.getString(9);
			
			Paciente pacientes = new Paciente(paciente,nombrepaciente,null,null,null,null,null,null,null,null,null);
			Medico medicos = new Medico(medico,nombreMedico,null,null,null,null,null,null,null,null);
			diagnostico= new Diagnostico(iddiagnosticod,nombrediagnostico,descripciondiagnostico,medicos,pacientes);

		}
		con.close();
		return diagnostico;
	}

	@Override
	public void eliminar(String id) throws Exception {
		// TODO Auto-generated method stub
		try {
			Connection con = Conexion.getConexion();
			String sql2 = "DELETE from diagnostico WHERE id_diagnostico=?";
			java.sql.PreparedStatement stm2 = con.prepareStatement(sql2);
			stm2.setString(1, id);
			stm2.executeUpdate();

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			System.out.print("Diagnostico eliminado");
		}
		
	}

	@Override
	public void actualizar(Diagnostico diagnostico) throws Exception {
		// TODO Auto-generated method stub
		
		try {

			String sql = "UPDATE diagnostico SET nombre_diagnostico=?,descripcion_diagnostico=?,id_medico=?,id_paciente=? where id_diagnostico=?";
			// System.out.println(sql);

			Connection con = Conexion.getConexion();
			java.sql.PreparedStatement stm = con.prepareStatement(sql);
			
			stm.setString(1, diagnostico.getNombreDiagnostico());
			stm.setString(2, diagnostico.getDescripcionDiagnostico());
			stm.setString(3,diagnostico.getMedico().getIdMedico());
			stm.setString(4, diagnostico.getPaciente().getIdPaciente());
			stm.setString(5, diagnostico.getIdDiagnostico());
			stm.executeUpdate();

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			
		}
		
	}

	@Override
	public ResultSet listarDiagnostico() throws Exception {
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
