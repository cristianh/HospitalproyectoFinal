package eam.desarrollo.entidades;

import java.io.Serializable;
import java.sql.Blob;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Model class of hospitalizacion.
 * 
 * @author generated by ERMaster
 * @version $Id$
 */
public class Hospitalizacion implements Serializable {

	/** serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** id_hospitalizacion. */
	private Blob idHospitalizacion;

	/** fecha_entrada_hospitalizacion. */
	private Date fechaEntradaHospitalizacion;

	/** fecha_salida_hospitalizacion. */
	private Date fechaSalidaHospitalizacion;

	/** estado_hospitalizacion. */
	private EstadoHospitalizacion estadoHospitalizacion;

	/** The set of control_hospitalizacion. */
	private Set<ControlHospitalizacion> controlHospitalizacionSet;

	/** The set of control_hospitalizacion_medico. */
	private Set<ControlHospitalizacionMedico> controlHospitalizacionMedicoSet;

	/**
	 * Constructor.
	 */
	public Hospitalizacion() {
		this.controlHospitalizacionSet = new HashSet<ControlHospitalizacion>();
		this.controlHospitalizacionMedicoSet = new HashSet<ControlHospitalizacionMedico>();
	}

	/**
	 * Set the id_hospitalizacion.
	 * 
	 * @param idHospitalizacion
	 *            id_hospitalizacion
	 */
	public void setIdHospitalizacion(Blob idHospitalizacion) {
		this.idHospitalizacion = idHospitalizacion;
	}

	/**
	 * Get the id_hospitalizacion.
	 * 
	 * @return id_hospitalizacion
	 */
	public Blob getIdHospitalizacion() {
		return this.idHospitalizacion;
	}

	/**
	 * Set the fecha_entrada_hospitalizacion.
	 * 
	 * @param fechaEntradaHospitalizacion
	 *            fecha_entrada_hospitalizacion
	 */
	public void setFechaEntradaHospitalizacion(Date fechaEntradaHospitalizacion) {
		this.fechaEntradaHospitalizacion = fechaEntradaHospitalizacion;
	}

	/**
	 * Get the fecha_entrada_hospitalizacion.
	 * 
	 * @return fecha_entrada_hospitalizacion
	 */
	public Date getFechaEntradaHospitalizacion() {
		return this.fechaEntradaHospitalizacion;
	}

	/**
	 * Set the fecha_salida_hospitalizacion.
	 * 
	 * @param fechaSalidaHospitalizacion
	 *            fecha_salida_hospitalizacion
	 */
	public void setFechaSalidaHospitalizacion(Date fechaSalidaHospitalizacion) {
		this.fechaSalidaHospitalizacion = fechaSalidaHospitalizacion;
	}

	/**
	 * Get the fecha_salida_hospitalizacion.
	 * 
	 * @return fecha_salida_hospitalizacion
	 */
	public Date getFechaSalidaHospitalizacion() {
		return this.fechaSalidaHospitalizacion;
	}

	/**
	 * Set the estado_hospitalizacion.
	 * 
	 * @param estadoHospitalizacion
	 *            estado_hospitalizacion
	 */
	public void setEstadoHospitalizacion(EstadoHospitalizacion estadoHospitalizacion) {
		this.estadoHospitalizacion = estadoHospitalizacion;
	}

	/**
	 * Get the estado_hospitalizacion.
	 * 
	 * @return estado_hospitalizacion
	 */
	public EstadoHospitalizacion getEstadoHospitalizacion() {
		return this.estadoHospitalizacion;
	}

	/**
	 * Set the set of the control_hospitalizacion.
	 * 
	 * @param controlHospitalizacionSet
	 *            The set of control_hospitalizacion
	 */
	public void setControlHospitalizacionSet(Set<ControlHospitalizacion> controlHospitalizacionSet) {
		this.controlHospitalizacionSet = controlHospitalizacionSet;
	}

	/**
	 * Add the control_hospitalizacion.
	 * 
	 * @param controlHospitalizacion
	 *            control_hospitalizacion
	 */
	public void addControlHospitalizacion(ControlHospitalizacion controlHospitalizacion) {
		this.controlHospitalizacionSet.add(controlHospitalizacion);
	}

	/**
	 * Get the set of the control_hospitalizacion.
	 * 
	 * @return The set of control_hospitalizacion
	 */
	public Set<ControlHospitalizacion> getControlHospitalizacionSet() {
		return this.controlHospitalizacionSet;
	}

	/**
	 * Set the set of the control_hospitalizacion_medico.
	 * 
	 * @param controlHospitalizacionMedicoSet
	 *            The set of control_hospitalizacion_medico
	 */
	public void setControlHospitalizacionMedicoSet(Set<ControlHospitalizacionMedico> controlHospitalizacionMedicoSet) {
		this.controlHospitalizacionMedicoSet = controlHospitalizacionMedicoSet;
	}

	/**
	 * Add the control_hospitalizacion_medico.
	 * 
	 * @param controlHospitalizacionMedico
	 *            control_hospitalizacion_medico
	 */
	public void addControlHospitalizacionMedico(ControlHospitalizacionMedico controlHospitalizacionMedico) {
		this.controlHospitalizacionMedicoSet.add(controlHospitalizacionMedico);
	}

	/**
	 * Get the set of the control_hospitalizacion_medico.
	 * 
	 * @return The set of control_hospitalizacion_medico
	 */
	public Set<ControlHospitalizacionMedico> getControlHospitalizacionMedicoSet() {
		return this.controlHospitalizacionMedicoSet;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idHospitalizacion == null) ? 0 : idHospitalizacion.hashCode());
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
		Hospitalizacion other = (Hospitalizacion) obj;
		if (idHospitalizacion == null) {
			if (other.idHospitalizacion != null) {
				return false;
			}
		} else if (!idHospitalizacion.equals(other.idHospitalizacion)) {
			return false;
		}
		return true;
	}

}
