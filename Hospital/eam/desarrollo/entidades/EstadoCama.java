package eam.desarrollo.entidades;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Model class of estado_cama.
 * 
 * @author generated by ERMaster
 * @version $Id$
 */
public class EstadoCama implements Serializable {

	/** serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** id_estado_cama. */
	private String idEstadoCama;

	/** descripcion_estado_cama. */
	private String descripcionEstadoCama;

	/** The set of cama. */
	private Set<Cama> camaSet;

	/**
	 * Constructor.
	 */
	public EstadoCama() {
		this.camaSet = new HashSet<Cama>();
	}

	/**
	 * Set the id_estado_cama.
	 * 
	 * @param idEstadoCama
	 *            id_estado_cama
	 */
	public void setIdEstadoCama(String idEstadoCama) {
		this.idEstadoCama = idEstadoCama;
	}

	/**
	 * Get the id_estado_cama.
	 * 
	 * @return id_estado_cama
	 */
	public String getIdEstadoCama() {
		return this.idEstadoCama;
	}

	/**
	 * Set the descripcion_estado_cama.
	 * 
	 * @param descripcionEstadoCama
	 *            descripcion_estado_cama
	 */
	public void setDescripcionEstadoCama(String descripcionEstadoCama) {
		this.descripcionEstadoCama = descripcionEstadoCama;
	}

	/**
	 * Get the descripcion_estado_cama.
	 * 
	 * @return descripcion_estado_cama
	 */
	public String getDescripcionEstadoCama() {
		return this.descripcionEstadoCama;
	}

	/**
	 * Set the set of the cama.
	 * 
	 * @param camaSet
	 *            The set of cama
	 */
	public void setCamaSet(Set<Cama> camaSet) {
		this.camaSet = camaSet;
	}

	/**
	 * Add the cama.
	 * 
	 * @param cama
	 *            cama
	 */
	public void addCama(Cama cama) {
		this.camaSet.add(cama);
	}

	/**
	 * Get the set of the cama.
	 * 
	 * @return The set of cama
	 */
	public Set<Cama> getCamaSet() {
		return this.camaSet;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idEstadoCama == null) ? 0 : idEstadoCama.hashCode());
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
		EstadoCama other = (EstadoCama) obj;
		if (idEstadoCama == null) {
			if (other.idEstadoCama != null) {
				return false;
			}
		} else if (!idEstadoCama.equals(other.idEstadoCama)) {
			return false;
		}
		return true;
	}

}
