package eam.desarrollo.hospital.interfaces;

import java.util.ArrayList;
import java.util.Vector;

import eam.desarrollo.hospital.entidades.Medico;
import eam.desarrollo.hospital.entidades.Paciente;

public interface IntMedico {
	public abstract void crear(Medico medico) throws Exception;
	public abstract Medico buscar(String documentomedico) throws Exception;
	public abstract void eliminar(String documentomedico) throws Exception;
	public abstract void actualizar(Medico medico) throws Exception;
	public Vector<Medico> listarMedico();
	public java.sql.ResultSet listarMedicoRS();
}