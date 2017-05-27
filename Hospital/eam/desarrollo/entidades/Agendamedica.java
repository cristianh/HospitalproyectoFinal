package eam.desarrollo.entidades;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

/**
 * Model class of agendamedica.
 * 
 * @author generated by ERMaster
 * @version $Id$
 */
public class Agendamedica implements Serializable {

	/** serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** id_agenda_medico. */
	private String idAgendaMedico;

	/** fecha_agenda. */
	private Date fechaAgenda;

	/** hora_agenda. */
	private Time horaAgenda;

	/** medico. */
	private Medico medico;

	/**
	 * Constructor.
	 */
	public Agendamedica() {
	}

	/**
	 * Set the id_agenda_medico.
	 * 
	 * @param idAgendaMedico
	 *            id_agenda_medico
	 */
	public void setIdAgendaMedico(String idAgendaMedico) {
		this.idAgendaMedico = idAgendaMedico;
	}

	/**
	 * Get the id_agenda_medico.
	 * 
	 * @return id_agenda_medico
	 */
	public String getIdAgendaMedico() {
		return this.idAgendaMedico;
	}

	/**
	 * Set the fecha_agenda.
	 * 
	 * @param fechaAgenda
	 *            fecha_agenda
	 */
	public void setFechaAgenda(Date fechaAgenda) {
		this.fechaAgenda = fechaAgenda;
	}

	/**
	 * Get the fecha_agenda.
	 * 
	 * @return fecha_agenda
	 */
	public Date getFechaAgenda() {
		return this.fechaAgenda;
	}

	/**
	 * Set the hora_agenda.
	 * 
	 * @param horaAgenda
	 *            hora_agenda
	 */
	public void setHoraAgenda(Time horaAgenda) {
		this.horaAgenda = horaAgenda;
	}

	/**
	 * Get the hora_agenda.
	 * 
	 * @return hora_agenda
	 */
	public Time getHoraAgenda() {
		return this.horaAgenda;
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
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idAgendaMedico == null) ? 0 : idAgendaMedico.hashCode());
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
		Agendamedica other = (Agendamedica) obj;
		if (idAgendaMedico == null) {
			if (other.idAgendaMedico != null) {
				return false;
			}
		} else if (!idAgendaMedico.equals(other.idAgendaMedico)) {
			return false;
		}
		return true;
	}

}