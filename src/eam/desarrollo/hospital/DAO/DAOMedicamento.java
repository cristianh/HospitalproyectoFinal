package eam.desarrollo.hospital.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;

import eam.desarrollo.hospital.conexion.Conexion;
import eam.desarrollo.hospital.entidades.Cama;
import eam.desarrollo.hospital.entidades.EstadoCama;
import eam.desarrollo.hospital.entidades.Farmacia;
import eam.desarrollo.hospital.entidades.Habitacion;
import eam.desarrollo.hospital.entidades.Medicamento;
import eam.desarrollo.hospital.interfaces.IntMedicamento;

public class DAOMedicamento implements IntMedicamento {

	@Override
	public void crear(Medicamento medicamento) throws Exception {
		// TODO Auto-generated method stub
		try {

			String sql = "INSERT INTO  medicamento (id_medicamento,nombre_medicamento,marca_medicamento,id_farmacia) VALUES (?,?,?,?)";
			// System.out.println(sql);

			Connection con = Conexion.getConexion();
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, medicamento.getIdMedicamento());
			stm.setString(2, medicamento.getNombreMedicamento());
			stm.setString(3, medicamento.getMarcaMedicamento());
			stm.setString(4, medicamento.getFarmacia().getIdFarmacia());
			stm.executeUpdate();

			JOptionPane.showMessageDialog(null, "Medicamento registrado", "Info", JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			// Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE,
			// null, ex);
		}
		
	}

	@Override
	public Medicamento buscar(String identificacion) throws Exception {
		Connection con = Conexion.getConexion();
		String sql="SELECT m.id_medicamento,m.nombre_medicamento,m.marca_medicamento,m.id_farmacia,f.id_farmacia,f.nombre_farmacia,f.persona_a_cargo,f.telefono_farmacia from medicamento as m join farmacia as f on m.id_farmacia=f.id_farmacia where id_medicamento=?";
	
		
		java.sql.PreparedStatement pstmt = con.prepareStatement(sql);
		
		pstmt.setString(1, identificacion);
		// ejecutar consulta
		java.sql.ResultSet res = pstmt.executeQuery();
		
		Medicamento medicamento = null;
		// hubo un registro....
		System.out.println(res);
		if (res.next()) {
			String idmedicamento = res.getString(1);
			String nombremedicamento = res.getString(2);
			String marcamedicamento = res.getString(3);
			String idfarmaciaM = res.getString(4);
			String idfarmaciaF= res.getString(5);
			String nombrefarmacia=res.getString(6);
			String personacargo=res.getString(7);
			String telefonofarmacia=res.getString(8);
			
			
			Farmacia farmacia = new Farmacia(idfarmaciaF, nombrefarmacia, personacargo, telefonofarmacia);
			medicamento = new Medicamento(idmedicamento, nombremedicamento, marcamedicamento, farmacia);
			

		}
		con.close();
		return medicamento;
	}

	@Override
	public void eliminar(String id) throws Exception {
		try {
			Connection con = Conexion.getConexion();
			String sql2 = "DELETE from medicamento WHERE id_medicamento=?";
			java.sql.PreparedStatement stm2 = con.prepareStatement(sql2);
			stm2.setString(1, id);
			stm2.executeUpdate();

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			System.out.print("Medicamento eliminado");
		}
		
	}

	@Override
	public void actualizar(Medicamento medicamento) throws Exception {
		// TODO Auto-generated method stub
		
		try {

			String sql = "UPDATE medicamento SET nombre_medicamento=?,marca_medicamento=?,id_farmacia=? where id_medicamento=?";
			// System.out.println(sql);

			Connection con = Conexion.getConexion();
			java.sql.PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, medicamento.getNombreMedicamento());
			stm.setString(2, medicamento.getMarcaMedicamento());
			stm.setString(3, medicamento.getFarmacia().getIdFarmacia());
			stm.setString(4, medicamento.getIdMedicamento());
			stm.executeUpdate();

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			
		}
		
	}
	
	public ArrayList<Farmacia> listarFarmacias() {
		Farmacia farmacia = null;
		ArrayList<Farmacia> listFarmacia = new ArrayList<>();
		// Tipodocumento tipDocumento;
		try {

			String sql = "SELECT * FROM farmacia ";
			Connection con = Conexion.getConexion();
			java.sql.PreparedStatement stm = con.prepareStatement(sql);
			java.sql.ResultSet rs = stm.executeQuery();
			
			while (rs.next()) {
				farmacia= new Farmacia(rs.getString("id_farmacia"),
						rs.getString("nombre_farmacia"),rs.getString("persona_a_cargo"),rs.getString("telefono_farmacia"));
				
				listFarmacia.add(farmacia);

			}

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return listFarmacia;

	}

	@Override
	public ResultSet listarMedicamento() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
