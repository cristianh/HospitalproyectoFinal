/**
 * 
 */
package eam.desarrollo.hospital.logica;

import eam.desarrollo.hospital.DAO.DAOCita;
import eam.desarrollo.hospital.DAO.DAOConsultorio;
import eam.desarrollo.hospital.DAO.DAOEstadoCita;
import eam.desarrollo.hospital.DAO.DAOMedico;
import eam.desarrollo.hospital.DAO.DAOPaciente;
import eam.desarrollo.hospital.DAO.DAOTipoCita;

/**
 * @author Casa1
 *
 */
public class BOCita {

	/**
	 * @param args
	 */
	private DAOCita Midao = new DAOCita();
	private DAOPaciente MidaoPaciente = new DAOPaciente();
	private DAOMedico MidaoMedico = new DAOMedico();
	private DAOTipoCita MidaoTipoCita = new DAOTipoCita();
	private DAOEstadoCita MidaoEstadoCita = new DAOEstadoCita();
	private DAOConsultorio MidaoConsultorio = new DAOConsultorio();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
