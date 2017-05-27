package eam.desarrollo.hospital.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Model class of cita.
 * 
 * @author generated by ERMaster
 * @version $Id$
 */
public class Cita implements Serializable {

	/** serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** id_cita. */
	private String idCita;

	/** fecha_cita. */
	private Date fechaCita;
	
	/** Hora_cita. */
	private String HoraCita;

	/** paciente. */
	private Paciente paciente;

	/** tipo_cita. */
	private TipoCita tipoCita;

	/** estado_cita. */
	private EstadoCita estadoCita;

	/** consultorio. */
	private Consultorio consultorio;

	/** medico. */
	private Medico medico;

	/** The set of historia. */
	private Set<Historia> historiaSet;
	
	
	/**
	 * 
	 * @param idCita
	 * @param fechaCita
	 * @param horaCita
	 * @param paciente
	 * @param tipoCita
	 * @param estadoCita
	 * @param consultorio
	 * @param medico
	 */
	public Cita(String idCita, Date fechaCita, String horaCita, Paciente paciente, TipoCita tipoCita,
			EstadoCita estadoCita, Consultorio consultorio, Medico medico) {
		this.idCita = idCita;
		this.fechaCita = fechaCita;
		HoraCita = horaCita;
		this.paciente = paciente;
		this.tipoCita = tipoCita;
		this.estadoCita = estadoCita;
		this.consultorio = consultorio;
		this.medico = medico;
	}

	/**
	 * 
	 * @return
	 */
	public String getHoraCita() {
		return HoraCita;
	}

	/**
	 * 
	 * @param horaCita
	 */
	public void setHoraCita(String horaCita) {
		HoraCita = horaCita;
	}


	/**
	 * Set the id_cita.
	 * 
	 * @param idCita
	 *            id_cita
	 */
	public void setIdCita(String idCita) {
		this.idCita = idCita;
	}

	/**
	 * Get the id_cita.
	 * 
	 * @return id_cita
	 */
	public String getIdCita() {
		return this.idCita;
	}

	/**
	 * Set the fecha_cita.
	 * 
	 * @param fechaCita
	 *            fecha_cita
	 */
	public void setFechaCita(Date fechaCita) {
		this.fechaCita = fechaCita;
	}

	/**
	 * Get the fecha_cita.
	 * 
	 * @return fecha_cita
	 */
	public Date getFechaCita() {
		return this.fechaCita;
	}

	/**
	 * Set the paciente.
	 * 
	 * @param paciente
	 *            paciente
	 */
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	/**
	 * Get the paciente.
	 * 
	 * @return paciente
	 */
	public Paciente getPaciente() {
		return this.paciente;
	}

	/**
	 * Set the tipo_cita.
	 * 
	 * @param tipoCita
	 *            tipo_cita
	 */
	public void setTipoCita(TipoCita tipoCita) {
		this.tipoCita = tipoCita;
	}

	/**
	 * Get the tipo_cita.
	 * 
	 * @return tipo_cita
	 */
	public TipoCita getTipoCita() {
		return this.tipoCita;
	}

	/**
	 * Set the estado_cita.
	 * 
	 * @param estadoCita
	 *            estado_cita
	 */
	public void setEstadoCita(EstadoCita estadoCita) {
		this.estadoCita = estadoCita;
	}

	/**
	 * Get the estado_cita.
	 * 
	 * @return estado_cita
	 */
	public EstadoCita getEstadoCita() {
		return this.estadoCita;
	}

	/**
	 * Set the consultorio.
	 * 
	 * @param consultorio
	 *            consultorio
	 */
	public void setConsultorio(Consultorio consultorio) {
		this.consultorio = consultorio;
	}

	/**
	 * Get the consultorio.
	 * 
	 * @return consultorio
	 */
	public Consultorio getConsultorio() {
		return this.consultorio;
	}

	/**
	 * Set the medico.
	 * 
	 * @param medico
	 *            medico
	 */
	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	/**
	 * Get the medico.
	 * 
	 * @return medico
	 */
	public Medico getMedico() {
		return this.medico;
	}

	/**
	 * Set the set of the historia.
	 * 
	 * @param historiaSet
	 *            The set of historia
	 */
	public void setHistoriaSet(Set<Historia> historiaSet) {
		this.historiaSet = historiaSet;
	}

	/**
	 * Add the historia.
	 * 
	 * @param historia
	 *            historia
	 */
	public void addHistoria(Historia historia) {
		this.historiaSet.add(historia);
	}

	/**
	 * Get the set of the historia.
	 * 
	 * @return The set of historia
	 */
	public Set<Historia> getHistoriaSet() {
		return this.historiaSet;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idCita == null) ? 0 : idCita.hashCode());
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Cita other = (Cita) obj;
		if (idCita == null) {
			if (other.idCita != null) {
				return false;
			}
		} else if (!idCita.equals(other.idCita)) {
			return false;
		}
		return true;
	}


	
	

}
