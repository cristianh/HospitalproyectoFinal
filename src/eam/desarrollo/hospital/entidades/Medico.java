package eam.desarrollo.hospital.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Model class of medico.
 * 
 * @author generated by ERMaster
 * @version $Id$
 */
public class Medico implements Serializable {

	/** serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** id_medico. */
	private String idMedico;

	/** nombre_medico. */
	private String nombreMedico;

	/** apellido_medico. */
	private String apellidoMedico;

	/** telefono_medico. */
	private String telefonoMedico;

	/** direccion_medico. */
	private String direccionMedico;

	/** email_medico. */
	private String emailMedico;

	/** telefono_emergencia_medico. */
	private String telefonoEmergenciaMedico;

	/** fecha_nacimiento_medico. */
	private Date fechaNacimientoMedico;

	/** numero_documento_medico. */
	private String numeroDocumentoMedico;

	/** tipodocumento. */
	private Tipodocumento tipodocumento;

	/** The set of agendamedica. */
	//private Set<Agendamedica> agendamedicaSet;

	/** The set of cita. */
	private Set<Cita> citaSet;

	/** The set of control_hospitalizacion_medico. */
	//private Set<ControlHospitalizacionMedico> controlHospitalizacionMedicoSet;

	/** The set of diagnostico. */
	//private Set<Diagnostico> diagnosticoSet;

	/** The set of entrada_medico. */
	//private Set<EntradaMedico> entradaMedicoSet;

	/** The set of formula. */
	//private Set<Formula> formulaSet;

	/** The set of incapacidad. */
	//private Set<Incapacidad> incapacidadSet;

	/** The set of salida_medico. */
	//private Set<SalidaMedico> salidaMedicoSet;

	
	/**
	 * Constructor.
	 */
	public Medico() {
		//this.agendamedicaSet = new HashSet<Agendamedica>();
		this.citaSet = new HashSet<Cita>();
		//this.controlHospitalizacionMedicoSet = new HashSet<ControlHospitalizacionMedico>();
		//this.diagnosticoSet = new HashSet<Diagnostico>();
		//this.entradaMedicoSet = new HashSet<EntradaMedico>();
		//this.formulaSet = new HashSet<Formula>();
		//this.incapacidadSet = new HashSet<Incapacidad>();
		//this.salidaMedicoSet = new HashSet<SalidaMedico>();
	}
	
	
	/**
	 * 
	 * @param idMedico
	 * @param nombreMedico
	 * @param apellidoMedico
	 * @param telefonoMedico
	 * @param direccionMedico
	 * @param emailMedico
	 * @param telefonoEmergenciaMedico
	 * @param fechaNacimientoMedico
	 * @param numeroDocumentoMedico
	 * @param tipodocumento
	 */
	public Medico(String idMedico, String nombreMedico, String apellidoMedico, String telefonoMedico,
			String direccionMedico, String emailMedico, String telefonoEmergenciaMedico, Date fechaNacimientoMedico,
			String numeroDocumentoMedico, Tipodocumento tipodocumento) {
		super();
		this.idMedico = idMedico;
		this.nombreMedico = nombreMedico;
		this.apellidoMedico = apellidoMedico;
		this.telefonoMedico = telefonoMedico;
		this.direccionMedico = direccionMedico;
		this.emailMedico = emailMedico;
		this.telefonoEmergenciaMedico = telefonoEmergenciaMedico;
		this.fechaNacimientoMedico = fechaNacimientoMedico;
		this.numeroDocumentoMedico = numeroDocumentoMedico;
		this.tipodocumento = tipodocumento;
	}

	/**
	 * Set the id_medico.
	 * 
	 * @param idMedico
	 *            id_medico
	 */
	public void setIdMedico(String idMedico) {
		this.idMedico = idMedico;
	}

	/**
	 * Get the id_medico.
	 * 
	 * @return id_medico
	 */
	public String getIdMedico() {
		return this.idMedico;
	}

	/**
	 * Set the nombre_medico.
	 * 
	 * @param nombreMedico
	 *            nombre_medico
	 */
	public void setNombreMedico(String nombreMedico) {
		this.nombreMedico = nombreMedico;
	}

	/**
	 * Get the nombre_medico.
	 * 
	 * @return nombre_medico
	 */
	public String getNombreMedico() {
		return this.nombreMedico;
	}

	/**
	 * Set the apellido_medico.
	 * 
	 * @param apellidoMedico
	 *            apellido_medico
	 */
	public void setApellidoMedico(String apellidoMedico) {
		this.apellidoMedico = apellidoMedico;
	}

	/**
	 * Get the apellido_medico.
	 * 
	 * @return apellido_medico
	 */
	public String getApellidoMedico() {
		return this.apellidoMedico;
	}

	/**
	 * Set the telefono_medico.
	 * 
	 * @param telefonoMedico
	 *            telefono_medico
	 */
	public void setTelefonoMedico(String telefonoMedico) {
		this.telefonoMedico = telefonoMedico;
	}

	/**
	 * Get the telefono_medico.
	 * 
	 * @return telefono_medico
	 */
	public String getTelefonoMedico() {
		return this.telefonoMedico;
	}

	/**
	 * Set the direccion_medico.
	 * 
	 * @param direccionMedico
	 *            direccion_medico
	 */
	public void setDireccionMedico(String direccionMedico) {
		this.direccionMedico = direccionMedico;
	}

	/**
	 * Get the direccion_medico.
	 * 
	 * @return direccion_medico
	 */
	public String getDireccionMedico() {
		return this.direccionMedico;
	}

	/**
	 * Set the email_medico.
	 * 
	 * @param emailMedico
	 *            email_medico
	 */
	public void setEmailMedico(String emailMedico) {
		this.emailMedico = emailMedico;
	}

	/**
	 * Get the email_medico.
	 * 
	 * @return email_medico
	 */
	public String getEmailMedico() {
		return this.emailMedico;
	}

	/**
	 * Set the telefono_emergencia_medico.
	 * 
	 * @param telefonoEmergenciaMedico
	 *            telefono_emergencia_medico
	 */
	public void setTelefonoEmergenciaMedico(String telefonoEmergenciaMedico) {
		this.telefonoEmergenciaMedico = telefonoEmergenciaMedico;
	}

	/**
	 * Get the telefono_emergencia_medico.
	 * 
	 * @return telefono_emergencia_medico
	 */
	public String getTelefonoEmergenciaMedico() {
		return this.telefonoEmergenciaMedico;
	}

	/**
	 * Set the fecha_nacimiento_medico.
	 * 
	 * @param fechaNacimientoMedico
	 *            fecha_nacimiento_medico
	 */
	public void setFechaNacimientoMedico(Date fechaNacimientoMedico) {
		this.fechaNacimientoMedico = fechaNacimientoMedico;
	}

	/**
	 * Get the fecha_nacimiento_medico.
	 * 
	 * @return fecha_nacimiento_medico
	 */
	public Date getFechaNacimientoMedico() {
		return this.fechaNacimientoMedico;
	}

	/**
	 * Set the numero_documento_medico.
	 * 
	 * @param numeroDocumentoMedico
	 *            numero_documento_medico
	 */
	public void setNumeroDocumentoMedico(String numeroDocumentoMedico) {
		this.numeroDocumentoMedico = numeroDocumentoMedico;
	}

	/**
	 * Get the numero_documento_medico.
	 * 
	 * @return numero_documento_medico
	 */
	public String getNumeroDocumentoMedico() {
		return this.numeroDocumentoMedico;
	}

	/**
	 * Set the tipodocumento.
	 * 
	 * @param tipodocumento
	 *            tipodocumento
	 */
	public void setTipodocumento(Tipodocumento tipodocumento) {
		this.tipodocumento = tipodocumento;
	}

	/**
	 * Get the tipodocumento.
	 * 
	 * @return tipodocumento
	 */
	public Tipodocumento getTipodocumento() {
		return this.tipodocumento;
	}

	/**
	 * Set the set of the agendamedica.
	 * 
	 * @param agendamedicaSet
	 *            The set of agendamedica
	 */
	/**
	public void setAgendamedicaSet(Set<Agendamedica> agendamedicaSet) {
		this.agendamedicaSet = agendamedicaSet;
	}
	*/

	/**
	 * Add the agendamedica.
	 * 
	 * @param agendamedica
	 *            agendamedica
	 */
	/**
	public void addAgendamedica(Agendamedica agendamedica) {
		this.agendamedicaSet.add(agendamedica);
	}
	*/
	/**
	 * Get the set of the agendamedica.
	 * 
	 * @return The set of agendamedica
	 */
	/**
	public Set<Agendamedica> getAgendamedicaSet() {
		return this.agendamedicaSet;
	}
	*/

	/**
	 * Set the set of the cita.
	 * 
	 * @param citaSet
	 *            The set of cita
	 */
	public void setCitaSet(Set<Cita> citaSet) {
		this.citaSet = citaSet;
	}

	/**
	 * Add the cita.
	 * 
	 * @param cita
	 *            cita
	 */
	public void addCita(Cita cita) {
		this.citaSet.add(cita);
	}

	/**
	 * Get the set of the cita.
	 * 
	 * @return The set of cita
	 */
	public Set<Cita> getCitaSet() {
		return this.citaSet;
	}

	/**
	 * Set the set of the control_hospitalizacion_medico.
	 * 
	 * @param controlHospitalizacionMedicoSet
	 *            The set of control_hospitalizacion_medico
	 */
	/**
	public void setControlHospitalizacionMedicoSet(Set<ControlHospitalizacionMedico> controlHospitalizacionMedicoSet) {
		this.controlHospitalizacionMedicoSet = controlHospitalizacionMedicoSet;
	}
	*/

	/**
	 * Add the control_hospitalizacion_medico.
	 * 
	 * @param controlHospitalizacionMedico
	 *            control_hospitalizacion_medico
	 */
	/**
	public void addControlHospitalizacionMedico(ControlHospitalizacionMedico controlHospitalizacionMedico) {
		this.controlHospitalizacionMedicoSet.add(controlHospitalizacionMedico);
	}
*/
	/**
	 * Get the set of the control_hospitalizacion_medico.
	 * 
	 * @return The set of control_hospitalizacion_medico
	 */
	/**
	public Set<ControlHospitalizacionMedico> getControlHospitalizacionMedicoSet() {
		return this.controlHospitalizacionMedicoSet;
	}
	*/
	/**
	 * Set the set of the diagnostico.
	 * 
	 * @param diagnosticoSet
	 *            The set of diagnostico
	 */
	
	/**
	public void setDiagnosticoSet(Set<Diagnostico> diagnosticoSet) {
		this.diagnosticoSet = diagnosticoSet;
	}
	*/
	/**
	 * Add the diagnostico.
	 * 
	 * @param diagnostico
	 *            diagnostico
	 */
	/**
	public void addDiagnostico(Diagnostico diagnostico) {
		this.diagnosticoSet.add(diagnostico);
	}
	*/
	/**
	 * Get the set of the diagnostico.
	 * 
	 * @return The set of diagnostico
	 */
	/**
	public Set<Diagnostico> getDiagnosticoSet() {
		return this.diagnosticoSet;
	}
	*/
	/**
	 * Set the set of the entrada_medico.
	 * 
	 * @param entradaMedicoSet
	 *            The set of entrada_medico
	 */
	/**
	public void setEntradaMedicoSet(Set<EntradaMedico> entradaMedicoSet) {
		this.entradaMedicoSet = entradaMedicoSet;
	}
	*/
	/**
	 * Add the entrada_medico.
	 * 
	 * @param entradaMedico
	 *            entrada_medico
	 */
	/**
	public void addEntradaMedico(EntradaMedico entradaMedico) {
		this.entradaMedicoSet.add(entradaMedico);
	}
	*/

	/**
	 * Get the set of the entrada_medico.
	 * 
	 * @return The set of entrada_medico
	 */
	/**
	public Set<EntradaMedico> getEntradaMedicoSet() {
		return this.entradaMedicoSet;
	}
	*/

	/**
	 * Set the set of the formula.
	 * 
	 * @param formulaSet
	 *            The set of formula
	 */
	/**
	public void setFormulaSet(Set<Formula> formulaSet) {
		this.formulaSet = formulaSet;
	}
	*/
	/**
	 * Add the formula.
	 * 
	 * @param formula
	 *            formula
	 */
	/**
	public void addFormula(Formula formula) {
		this.formulaSet.add(formula);
	}
	*/

	/**
	 * Get the set of the formula.
	 * 
	 * @return The set of formula
	 */
	/**
	public Set<Formula> getFormulaSet() {
		return this.formulaSet;
	}
*/
	/**
	 * Set the set of the incapacidad.
	 * 
	 * @param incapacidadSet
	 *            The set of incapacidad
	 */
	/**
	public void setIncapacidadSet(Set<Incapacidad> incapacidadSet) {
		this.incapacidadSet = incapacidadSet;
	}
*/
	/**
	 * Add the incapacidad.
	 * 
	 * @param incapacidad
	 *            incapacidad
	 */
	/**
	public void addIncapacidad(Incapacidad incapacidad) {
		this.incapacidadSet.add(incapacidad);
	}
*/
	/**
	 * Get the set of the incapacidad.
	 * 
	 * @return The set of incapacidad
	 */
	/**
	public Set<Incapacidad> getIncapacidadSet() {
		return this.incapacidadSet;
	}
*/
	/**
	 * Set the set of the salida_medico.
	 * 
	 * @param salidaMedicoSet
	 *            The set of salida_medico
	 */
	/**
	public void setSalidaMedicoSet(Set<SalidaMedico> salidaMedicoSet) {
		this.salidaMedicoSet = salidaMedicoSet;
	}
*/
	/**
	 * Add the salida_medico.
	 * 
	 * @param salidaMedico
	 *            salida_medico
	 */
	/**
	public void addSalidaMedico(SalidaMedico salidaMedico) {
		this.salidaMedicoSet.add(salidaMedico);
	}
*/
	/**
	 * Get the set of the salida_medico.
	 * 
	 * @return The set of salida_medico
	 */
	/**
	public Set<SalidaMedico> getSalidaMedicoSet() {
		return this.salidaMedicoSet;
	}
*/
	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idMedico == null) ? 0 : idMedico.hashCode());
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
		Medico other = (Medico) obj;
		if (idMedico == null) {
			if (other.idMedico != null) {
				return false;
			}
		} else if (!idMedico.equals(other.idMedico)) {
			return false;
		}
		return true;
	}


	@Override
	public String toString() {
		return nombreMedico + " " +apellidoMedico;
	}

	
}
