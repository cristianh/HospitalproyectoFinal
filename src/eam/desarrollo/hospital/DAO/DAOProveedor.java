package eam.desarrollo.hospital.DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;

import eam.desarrollo.hospital.conexion.Conexion;
import eam.desarrollo.hospital.entidades.Proveedor;
import eam.desarrollo.hospital.interfaces.IntProveedor;

public class DAOProveedor implements IntProveedor {

	@Override
	public void crear(Proveedor proveedor) throws Exception {
		try {
			System.out.println("Entra");
			String sql = "INSERT INTO  proveedor (id_proveedor,nombre_proveedor,persona_contacto,direccion_proveedor,telefono_proveedor,email_preveedor) VALUES (?,?,?,?,?,?)";
			// System.out.println(sql);

			Connection con = Conexion.getConexion();
			PreparedStatement stm = con.prepareStatement(sql);

			stm.setString(1, proveedor.getIdProveedor());
			stm.setObject(2, proveedor.getEmpresa());
			stm.setObject(3, proveedor.getNombre());
			stm.setObject(4, proveedor.getDireccion());
			stm.setObject(5, proveedor.getTelefono());
			stm.setObject(6, proveedor.getEmail());
			stm.executeUpdate();

			JOptionPane.showMessageDialog(null, "Proveedor registrado", "Info", JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException ex) {
			// System.out.println(ex.getMessage());

		}
		
		
	}

	@Override
	public Proveedor buscar(String nombre) throws Exception {
		Connection con = Conexion.getConexion();

		String sql = "SELECT id_proveedor,nombre_proveedor,persona_contacto,direccion_proveedor,telefono_proveedor,email_preveedor from proveedor where id_proveedor=?";
		
		java.sql.PreparedStatement pstmt = con.prepareStatement(sql);
		
		pstmt.setString(1, nombre);

		// ejecutar consulta
		java.sql.ResultSet res = pstmt.executeQuery();
		
		Proveedor pro = null;
		if(res.next()){
			String idproveedor = res.getString(1);
			String nombreproveedor = res.getString(2);
			String personacontacto = res.getString(3);
			String direccionproveedor = res.getString(4);
			String telefonoproveedor = res.getString(5);
			String emailproveedor = res.getString(6);
			
			 pro = new Proveedor(idproveedor,nombreproveedor,personacontacto,direccionproveedor,telefonoproveedor,emailproveedor);
		}


		con.close();
		return pro;

	}

	@Override
	public void eliminar(String nombre) throws Exception {
		try {

			// System.out.println(sql);
			Connection con = Conexion.getConexion();
			String sql2 = "DELETE from proveedor WHERE id_proveedor=?";
			java.sql.PreparedStatement stm2 = con.prepareStatement(sql2);
			stm2.setString(1, nombre);
			stm2.executeUpdate();

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			// Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE,
			// null, ex);
		} finally {
			System.out.print("Proveedor eliminado");
		}
		
	}

	@Override
	public void actualizar(Proveedor nombre) throws Exception {
		try {

			String sql = "UPDATE proveedor SET nombre_proveedor=?,persona_contacto=?,direccion_proveedor=?,telefono_proveedor=?,email_preveedor=? where id_proveedor=?";
			// System.out.println(sql);

			Connection con = Conexion.getConexion();
			java.sql.PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, nombre.getEmpresa());
			stm.setString(2, nombre.getNombre());
			stm.setString(3, nombre.getDireccion());
			stm.setString(4, nombre.getTelefono());
			stm.setString(5, nombre.getEmail());
			stm.setString(6, nombre.getIdProveedor());
			
			
			
			
			stm.executeUpdate();

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			// Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE,
			// null, ex);
		}
		
	}

	@Override
	public void listarProveedor(Proveedor proveedores) {
		// TODO Auto-generated method stub
		
	}

}
