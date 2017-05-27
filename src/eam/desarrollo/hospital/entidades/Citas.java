package eam.desarrollo.hospital.entidades;
import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

/**
 * Model class of Citas.
 * 
 * @author generated by ERMaster
 * @version $Id$
 */
public class Citas implements Serializable {

	/** serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** IdCita. */
	private Integer Idcita;
	
	/** Fecha_cita. */
	private Date fechaCita;
	
	

	/** idProfesional. */
	private Integer idprofesional;

	/** Id_cliente. */
	private Integer idCliente;
	
	/** Hora_cita. */
	private String hora_cita;

	/**
	 * 
	 * @param idcita
	 * @param fechaCita
	 * @param idprofesional
	 * @param idCliente
	 * @param hora_cita
	 */
	public Citas(Integer idcita, Date fechaCita, Integer idprofesional, Integer idCliente, String hora_cita) {
		super();
		Idcita = idcita;
		this.fechaCita = fechaCita;
		this.idprofesional = idprofesional;
		this.idCliente = idCliente;
		this.hora_cita = hora_cita;
	}



	public Integer getIdcita() {
		return Idcita;
	}



	public void setIdcita(Integer idcita) {
		Idcita = idcita;
	}



	public String getHora_cita() {
		return hora_cita;
	}



	public void setHora_cita(String hora_cita) {
		this.hora_cita = hora_cita;
	}



	public Date getFechaCita() {
		return fechaCita;
	}

	public void setFechaCita(Date fechaCita) {
		this.fechaCita = fechaCita;
	}

	public Integer getIdprofesional() {
		return idprofesional;
	}

	public void setIdprofesional(Integer idprofesional) {
		this.idprofesional = idprofesional;
	}

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}
	
	

}
