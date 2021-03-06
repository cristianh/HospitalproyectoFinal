package eam.desarrollo.entidades;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Model class of tipodocumento.
 * 
 * @author generated by ERMaster
 * @version $Id$
 */
public class Tipodocumento implements Serializable {

	/** serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** id_tipo_documento. */
	private String idTipoDocumento;

	/** tipo_documento. */
	private String tipoDocumento;

	/** The set of medico. */
	private Set<Medico> medicoSet;

	/** The set of paciente. */
	private Set<Paciente> pacienteSet;

	/**
	 * Constructor.
	 */
	public Tipodocumento() {
		this.medicoSet = new HashSet<Medico>();
		this.pacienteSet = new HashSet<Paciente>();
	}

	/**
	 * Set the id_tipo_documento.
	 * 
	 * @param idTipoDocumento
	 *            id_tipo_documento
	 */
	public void setIdTipoDocumento(String idTipoDocumento) {
		this.idTipoDocumento = idTipoDocumento;
	}

	/**
	 * Get the id_tipo_documento.
	 * 
	 * @return id_tipo_documento
	 */
	public String getIdTipoDocumento() {
		return this.idTipoDocumento;
	}

	/**
	 * Set the tipo_documento.
	 * 
	 * @param tipoDocumento
	 *            tipo_documento
	 */
	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	/**
	 * Get the tipo_documento.
	 * 
	 * @return tipo_documento
	 */
	public String getTipoDocumento() {
		return this.tipoDocumento;
	}

	/**
	 * Set the set of the medico.
	 * 
	 * @param medicoSet
	 *            The set of medico
	 */
	public void setMedicoSet(Set<Medico> medicoSet) {
		this.medicoSet = medicoSet;
	}

	/**
	 * Add the medico.
	 * 
	 * @param medico
	 *            medico
	 */
	public void addMedico(Medico medico) {
		this.medicoSet.add(medico);
	}

	/**
	 * Get the set of the medico.
	 * 
	 * @return The set of medico
	 */
	public Set<Medico> getMedicoSet() {
		return this.medicoSet;
	}

	/**
	 * Set the set of the paciente.
	 * 
	 * @param pacienteSet
	 *            The set of paciente
	 */
	public void setPacienteSet(Set<Paciente> pacienteSet) {
		this.pacienteSet = pacienteSet;
	}

	/**
	 * Add the paciente.
	 * 
	 * @param paciente
	 *            paciente
	 */
	public void addPaciente(Paciente paciente) {
		this.pacienteSet.add(paciente);
	}

	/**
	 * Get the set of the paciente.
	 * 
	 * @return The set of paciente
	 */
	public Set<Paciente> getPacienteSet() {
		return this.pacienteSet;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idTipoDocumento == null) ? 0 : idTipoDocumento.hashCode());
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
		Tipodocumento other = (Tipodocumento) obj;
		if (idTipoDocumento == null) {
			if (other.idTipoDocumento != null) {
				return false;
			}
		} else if (!idTipoDocumento.equals(other.idTipoDocumento)) {
			return false;
		}
		return true;
	}

}
