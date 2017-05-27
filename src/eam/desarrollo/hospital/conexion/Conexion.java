package eam.desarrollo.hospital.conexion;


import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

public class Conexion {
    private static java.sql.Connection con;
    private Statement stm;
    private ResultSet rs;
    public static boolean estadoconexion = false;

    

    public static Connection getConexion() throws SQLException {
        try {
            
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            String database = "hospital";
            String usuario  = "root";
            //Comentario para sbaer de git.
            String clave    = "1234";
            con =  DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/"+database+"?"
            + "user="+usuario+"&password="+clave);
            estadoconexion = true;
            
        } catch (Exception e) {
        	JOptionPane.showMessageDialog(null, e.getMessage().toString(), "Error",
					JOptionPane.INFORMATION_MESSAGE);
        	
        }
        finally {
        	  if (estadoconexion) System.out.println("success");
        	}
       
        return (Connection) con;
    }

}
