package eam.desarrollo.hospital.entidades;
import java.util.ArrayList;

/**
 * 
 */

/**
 * @author Cristianh
 * @param <E>
 *
 */
public class datosAgenda{

	private static ArrayList<Cliente> cliente_arrayList = new ArrayList<Cliente>();
	private static ArrayList<Profesional> profesional_arrayList = new ArrayList<Profesional>();
	private static ArrayList<Citas> citas_arrayList = new ArrayList<Citas>();
	private static ArrayList<Agenda> agenda_arrayList = new ArrayList<Agenda>();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public datosAgenda() {
		// TODO Auto-generated constructor stub
	}
	public static ArrayList<Agenda> getAgenda_arrayList() {
		return agenda_arrayList;
	}
	public static void setAgenda_arrayList(ArrayList<Agenda> agenda_arrayList) {
		datosAgenda.agenda_arrayList = agenda_arrayList;
	}
	public static ArrayList<Citas> getCitas_arrayList() {
		return citas_arrayList;
	}
	public static void setCitas_arrayList(ArrayList<Citas> citas_arrayList) {
		datosAgenda.citas_arrayList = citas_arrayList;
	}
	public static ArrayList<Profesional> getProfesional_arrayList() {
		return profesional_arrayList;
	}
	public static void setProfesional_arrayList(ArrayList<Profesional> profesional_arrayList) {
		datosAgenda.profesional_arrayList = profesional_arrayList;
	}
	public static ArrayList<Cliente> getCliente_arrayList() {
		return cliente_arrayList;
	}
	public static void setCliente_arrayList(ArrayList<Cliente> cliente_arrayList) {
		datosAgenda.cliente_arrayList = cliente_arrayList;
	}
	
	
	

}
