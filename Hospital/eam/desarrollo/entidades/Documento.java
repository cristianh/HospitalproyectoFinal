package eam.desarrollo.entidades;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Model class of documento.
 * 
 * @author generated by ERMaster
 * @version $Id$
 */
public class Documento implements Serializable {

	/** serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** numero_documento. */
	private String numeroDocumento;

	/** id_documento. */
	private String idDocumento;

	/** tip_documento. */
	private String tipDocumento;

	/** The set of paciente. */
	private Set<Paciente> pacienteSet;

	/**
	 * Constructor.
	 */
	public Documento() {
		this.pacienteSet = new HashSet<Paciente>();
	}

	/**
	 * Set the numero_documento.
	 * 
	 * @param numeroDocumento
	 *            numero_documento
	 */
	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	/**
	 * Get the numero_documento.
	 * 
	 * @return numero_documento
	 */
	public String getNumeroDocumento() {
		return this.numeroDocumento;
	}

	/**
	 * Set the id_documento.
	 * 
	 * @param idDocumento
	 *            id_documento
	 */
	public void setIdDocumento(String idDocumento) {
		this.idDocumento = idDocumento;
	}

	/**
	 * Get the id_documento.
	 * 
	 * @return id_documento
	 */
	public String getIdDocumento() {
		return this.idDocumento;
	}

	/**
	 * Set the tip_documento.
	 * 
	 * @param tipDocumento
	 *            tip_documento
	 */
	public void setTipDocumento(String tipDocumento) {
		this.tipDocumento = tipDocumento;
	}

	/**
	 * Get the tip_documento.
	 * 
	 * @return tip_documento
	 */
	public String getTipDocumento() {
		return this.tipDocumento;
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
		result = prime * result + ((idDocumento == null) ? 0 : idDocumento.hashCode());
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
		Documento other = (Documento) obj;
		if (idDocumento == null) {
			if (other.idDocumento != null) {
				return false;
			}
		} else if (!idDocumento.equals(other.idDocumento)) {
			return false;
		}
		return true;
	}

}
