/**
 * 
 */
package eam.desarrollo.hospital.DAO;

import java.sql.SQLException;

import com.mysql.jdbc.Connection;

import eam.desarrollo.hospital.conexion.Conexion;
import eam.desarrollo.hospital.entidades.Login;
import eam.desarrollo.hospital.entidades.TipoUsuario;

/**
 * @author Casa1
 *
 */
public class DAOLogin {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
	public Login ingresarSistema(String user,String password){
		System.out.println(user);
		System.out.println(password);
		Login login= null;
		try {
			Connection con = Conexion.getConexion();
			java.sql.PreparedStatement stm;
			String sql = "SELECT l.id,l.user,l.password,l.estado,l.id_tipo_usuario,t.tipo_usuario FROM login as l join tipousuario as t on l.id_tipo_usuario= t.id_tipo_usuario where l.user=? and l.password=?";
			stm = con.prepareStatement(sql);
			stm.setString(1, user);
			stm.setString(2, password);
			java.sql.ResultSet rs = stm.executeQuery();
			System.out.println(rs.next());
			//int idLogin, String user, char password, Boolean estado, TipoUsuario idTipoUsuario
			TipoUsuario tipousuario = new TipoUsuario(rs.getInt("id_tipo_usuario"),rs.getString("tipo_usuario"));
			login  = new Login(rs.getInt("id"),rs.getString("user"),rs.getString("password"), rs.getBoolean("estado"), tipousuario);

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return login;
	}

}
