package eam.desarrollo.entidades;

import java.io.Serializable;
import java.sql.Blob;
import java.util.HashSet;
import java.util.Set;

/**
 * Model class of procedimiento.
 * 
 * @author generated by ERMaster
 * @version $Id$
 */
public class Procedimiento implements Serializable {

	/** serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** id_procedimiento. */
	private Blob idProcedimiento;

	/** nombre_procedimiento. */
	private String nombreProcedimiento;

	/** procedimiento. */
	private String procedimiento;

	/** The set of control_hospitalizacion. */
	private Set<ControlHospitalizacion> controlHospitalizacionSet;

	/** The set of urgencia_procedimiento. */
	private Set<UrgenciaProcedimiento> urgenciaProcedimientoSet;

	/**
	 * Constructor.
	 */
	public Procedimiento() {
		this.controlHospitalizacionSet = new HashSet<ControlHospitalizacion>();
		this.urgenciaProcedimientoSet = new HashSet<UrgenciaProcedimiento>();
	}

	/**
	 * Set the id_procedimiento.
	 * 
	 * @param idProcedimiento
	 *            id_procedimiento
	 */
	public void setIdProcedimiento(Blob idProcedimiento) {
		this.idProcedimiento = idProcedimiento;
	}

	/**
	 * Get the id_procedimiento.
	 * 
	 * @return id_procedimiento
	 */
	public Blob getIdProcedimiento() {
		return this.idProcedimiento;
	}

	/**
	 * Set the nombre_procedimiento.
	 * 
	 * @param nombreProcedimiento
	 *            nombre_procedimiento
	 */
	public void setNombreProcedimiento(String nombreProcedimiento) {
		this.nombreProcedimiento = nombreProcedimiento;
	}

	/**
	 * Get the nombre_procedimiento.
	 * 
	 * @return nombre_procedimiento
	 */
	public String getNombreProcedimiento() {
		return this.nombreProcedimiento;
	}

	/**
	 * Set the procedimiento.
	 * 
	 * @param procedimiento
	 *            procedimiento
	 */
	public void setProcedimiento(String procedimiento) {
		this.procedimiento = procedimiento;
	}

	/**
	 * Get the procedimiento.
	 * 
	 * @return procedimiento
	 */
	public String getProcedimiento() {
		return this.procedimiento;
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
	 * Set the set of the urgencia_procedimiento.
	 * 
	 * @param urgenciaProcedimientoSet
	 *            The set of urgencia_procedimiento
	 */
	public void setUrgenciaProcedimientoSet(Set<UrgenciaProcedimiento> urgenciaProcedimientoSet) {
		this.urgenciaProcedimientoSet = urgenciaProcedimientoSet;
	}

	/**
	 * Add the urgencia_procedimiento.
	 * 
	 * @param urgenciaProcedimiento
	 *            urgencia_procedimiento
	 */
	public void addUrgenciaProcedimiento(UrgenciaProcedimiento urgenciaProcedimiento) {
		this.urgenciaProcedimientoSet.add(urgenciaProcedimiento);
	}

	/**
	 * Get the set of the urgencia_procedimiento.
	 * 
	 * @return The set of urgencia_procedimiento
	 */
	public Set<UrgenciaProcedimiento> getUrgenciaProcedimientoSet() {
		return this.urgenciaProcedimientoSet;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idProcedimiento == null) ? 0 : idProcedimiento.hashCode());
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
		Procedimiento other = (Procedimiento) obj;
		if (idProcedimiento == null) {
			if (other.idProcedimiento != null) {
				return false;
			}
		} else if (!idProcedimiento.equals(other.idProcedimiento)) {
			return false;
		}
		return true;
	}

}
