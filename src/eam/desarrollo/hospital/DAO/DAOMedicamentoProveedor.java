package eam.desarrollo.hospital.DAO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;

import eam.desarrollo.hospital.conexion.Conexion;
import eam.desarrollo.hospital.entidades.Genero;
import eam.desarrollo.hospital.entidades.Habitacion;
import eam.desarrollo.hospital.entidades.Medicamento;
import eam.desarrollo.hospital.entidades.MedicamentoProveedor;
import eam.desarrollo.hospital.entidades.Municipio;
import eam.desarrollo.hospital.entidades.Paciente;
import eam.desarrollo.hospital.entidades.Proveedor;
import eam.desarrollo.hospital.entidades.Tipodocumento;
import eam.desarrollo.hospital.interfaces.IntMedicamentoProveedor;

public class DAOMedicamentoProveedor implements IntMedicamentoProveedor {

	@Override
	public void crear(MedicamentoProveedor medicamento) throws Exception {
		// TODO Auto-generated method stub
		
		try {

			String sql = "INSERT INTO  medicamento_proveedor (id_medicamento_proveedor,cantidad_medicamento,lote_medicamento,fecha_vencimento,id_proveedor,id_medicamento) VALUES (?,?,?,?,?,?)";
			// System.out.println(sql);

			Connection con = Conexion.getConexion();
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, medicamento.getIdMedicamentoProveedor());
			stm.setInt(2, medicamento.getCantidadMedicamento());
			stm.setString(3, medicamento.getLoteMedicamento());
			stm.setObject(4, medicamento.getFechaVencimento());
			stm.setString(5, medicamento.getProveedor().getIdProveedor());
			stm.setString(6, medicamento.getMedicamento().getIdMedicamento());
			
			stm.executeUpdate();

			JOptionPane.showMessageDialog(null, "Medicamento registrado", "Info", JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			// Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE,
			// null, ex);
		}

		
		
	}

	@Override
	public MedicamentoProveedor buscar(String id) throws Exception {
		// TODO Auto-generated method stub
				Connection con = Conexion.getConexion();
				String sql="SELECT mp.id_medicamento_proveedor,mp.cantidad_medicamento,mp.lote_medicamento,mp.fecha_vencimento,mp.id_proveedor,mp.id_medicamento,p.id_proveedor,p.nombre_proveedor,m.id_medicamento,m.nombre_medicamento from medicamento_proveedor as mp join proveedor as p on mp.id_proveedor = p.id_proveedor join medicamento as m on mp.id_medicamento = m.id_medicamento where mp.id_medicamento_proveedor=?";
				java.sql.PreparedStatement pstmt = con.prepareStatement(sql);
				// java.sql.PreparedStatement pstmt2 = con.prepareStatement(sql2);
				pstmt.setString(1, id);
				// ejecutar consulta
				java.sql.ResultSet res = pstmt.executeQuery();
				// java.sql.ResultSet res = pstmt.executeQuery();
				MedicamentoProveedor medicamentoProveedor = null;
				// hubo un registro....
				
				if (res.next()) {
					String idMedicamentomp = res.getString(1);
					int cantidadMedicamento = res.getInt(2);
					String loteMedicamento = res.getString(3);
					Date fechaVencimiento = res.getDate(4);
					String idProveedormp = res.getString(5);
					String idMedicamentomP = res.getString(6);
					String idProveedorp = res.getString(7);
					String nombreProveedor = res.getString(8);
					String idMedicamentom = res.getString(9);
					String nombreMedicamento = res.getString(10);
					
					Medicamento medicamento= new Medicamento(res.getString(9),res.getString(10),null,null);
					Proveedor proveedor=new Proveedor(res.getString(7),res.getString(8),null,null,null,null);
					medicamentoProveedor=new MedicamentoProveedor(idMedicamentomp,cantidadMedicamento,loteMedicamento,fechaVencimiento,proveedor,medicamento);
					
				}
				con.close();
				return medicamentoProveedor;
	}

	@Override
	public void eliminar(String id) throws Exception {
		// TODO Auto-generated method stub
		
		try {	
			Connection con = Conexion.getConexion();
			String sql2 = "DELETE from medicamento_proveedor WHERE id_medicamento_proveedor=?";
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
	public void actualizar(MedicamentoProveedor medicamento) throws Exception {
		try {

			String sql = "UPDATE medicamento_proveedor SET cantidad_medicamento=?,lote_medicamento=?,fecha_vencimento=?,id_proveedor=?,id_medicamento=? where id_medicamento_proveedor=?";
			// System.out.println(sql);

			Connection con = Conexion.getConexion();
			java.sql.PreparedStatement stm = con.prepareStatement(sql);
			stm.setInt(1, medicamento.getCantidadMedicamento());
			stm.setString(2, medicamento.getLoteMedicamento());
			stm.setObject(3, medicamento.getFechaVencimento());
			stm.setString(4, medicamento.getProveedor().getIdProveedor());
			stm.setString(5, medicamento.getMedicamento().getIdMedicamento());
			stm.setString(6, medicamento.getIdMedicamentoProveedor());
			stm.executeUpdate();

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		
	}

	@Override
	public ResultSet listarMedicamentoProveedor() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	public ArrayList<Medicamento> listarMedicamento() {
		Medicamento medicamentos = null;
		ArrayList<Medicamento> listMedicamento = new ArrayList<>();
		
		try {

			String sql = "SELECT * FROM medicamento ";
			Connection con = Conexion.getConexion();
			java.sql.PreparedStatement stm = con.prepareStatement(sql);
			java.sql.ResultSet rs = stm.executeQuery();
			
			while (rs.next()) {
				medicamentos= new Medicamento(rs.getString("id_medicamento"),
						rs.getString("nombre_medicamento"),rs.getString("marca_medicamento"),null);
				
				listMedicamento.add(medicamentos);

			}

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return listMedicamento;

	}
	
	public ArrayList<Proveedor> listarProveedor() {
		Proveedor proveedores = null;
		ArrayList<Proveedor> listProveedor = new ArrayList<>();
		
		try {

			String sql = "SELECT * FROM proveedor ";
			Connection con = Conexion.getConexion();
			java.sql.PreparedStatement stm = con.prepareStatement(sql);
			java.sql.ResultSet rs = stm.executeQuery();
			
			while (rs.next()) {
				proveedores= new Proveedor(rs.getString("id_proveedor"),
						rs.getString("nombre_proveedor"),rs.getString("persona_contacto"),rs.getString("direccion_proveedor"),rs.getString("telefono_proveedor"),rs.getString("email_preveedor"));
				
				listProveedor.add(proveedores);

			}

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return listProveedor;

	}
	
	
	
	

}
