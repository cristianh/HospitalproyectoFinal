/**
 * 
 */
package eam.desarrollo.hospital.DAO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;

import eam.desarrollo.hospital.conexion.Conexion;
import eam.desarrollo.hospital.entidades.Agenda;
import eam.desarrollo.hospital.entidades.Consultorio;
import eam.desarrollo.hospital.entidades.EstadoConsultorio;
import eam.desarrollo.hospital.interfaces.IntAgenda;

/**
 * @author Casa1
 *
 */
public class DAOAgenda implements IntAgenda{


	@Override
	public void crear(Agenda agenda) throws Exception {
		// TODO Auto-generated method stub
		try {
			System.out.println("Entra");
			String sql = "INSERT INTO  agendamedica (id_agenda_medico,fecha_agenda,hora_agenda,id_medico) VALUES (?,?,?,?)";
			// System.out.println(sql);

			Connection con = Conexion.getConexion();
			PreparedStatement stm = con.prepareStatement(sql);

			stm.setString(1, agenda.getId_agenda());
			stm.setObject(2, agenda.getFecha_agenda());
			stm.setObject(3, agenda.getHora_agenda());
			stm.setObject(4, agenda.getMedico().getIdMedico());
			stm.executeUpdate();

			JOptionPane.showMessageDialog(null, "Agenda Guardada", "Info", JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException ex) {
			// System.out.println(ex.getMessage());

		}
	}

	@Override
	public void buscar(String idagenda) throws Exception {
		// TODO Auto-generated method stub
		Agenda agenda = null;
		/*Connection con = Conexion.getConexion();
		String sql = "SELECT * from agendamedica WHERE id_agenda_medico=?";
		java.sql.PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, idagenda);
		// ejecutar consulta
		java.sql.ResultSet res = pstmt.executeQuery();
		
		// hubo un registro....
		System.out.println(res);
		if (res.next()) {
			String idagendaMe = res.getString(1);
			String fechaagenda = res.getString(2);
			String horaagenda = res.getString(3);
			String idmedico = res.getObject(4);
			agenda = new Agenda(idagendaMe, fechaagenda, horaagenda,idmedico);

		}
		con.close();*/
	}

	@Override
	public void eliminar(String idAgenda) throws Exception {
		// TODO Auto-generated method stub
		try {

			// System.out.println(sql);
			Connection con = Conexion.getConexion();
			String sql2 = "DELETE from agendamedica WHERE id_agenda_medico=?";
			java.sql.PreparedStatement stm2 = con.prepareStatement(sql2);
			stm2.setString(1, idAgenda);
			stm2.executeUpdate();
			JOptionPane.showMessageDialog(null, "Registro en la agenda eliminado", "Info",
					JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			// Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE,
			// null, ex);
		} finally {
			System.out.print("Registro en la agenda eliminado");
		}
	}

	@Override
	public void actualizar(Agenda agenda) throws Exception {
		// TODO Auto-generated method stub
		try {

			String sql = "UPDATE agendamedica SET fecha_agenda=?,hora_agenda=?,id_medico=? where id_agenda_medico=?";
			// System.out.println(sql);

			Connection con = Conexion.getConexion();
			java.sql.PreparedStatement stm = con.prepareStatement(sql);
			stm.setObject(1, agenda.getFecha_agenda());
			stm.setString(2, agenda.getHora_agenda());
			stm.setString(3, agenda.getMedico().getIdMedico());
			stm.setObject(4, agenda.getId_agenda());
			stm.executeUpdate();

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			// Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE,
			// null, ex);
		}
		
	}

	@Override
	public void listarAgenda(Agenda agenda) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ResultSet listarAgenda() throws Exception {
		// TODO Auto-generated method stub
		java.sql.ResultSet rs = null;
		try {
			Connection con = Conexion.getConexion();
			java.sql.PreparedStatement stm;
			String sql = "SELECT  ag.id_agenda_medico,ag.fecha_agenda,ag.hora_agenda,m.nombre_medico,m.apellido_medico from agendamedica as ag join medico as m on m.id_medico = ag.id_medico";
			stm = con.prepareStatement(sql);
			rs = stm.executeQuery();

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return rs;
	}

	

}
