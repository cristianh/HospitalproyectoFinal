package eam.desarrollo.hospital.interfaces;

import java.util.ArrayList;

import eam.desarrollo.hospital.entidades.Paciente;


public interface IntPaciente {

	public abstract void crear(Paciente paciente) throws Exception;
	public abstract Paciente buscar(String identificacion) throws Exception;
	public abstract void eliminar(String id) throws Exception;
	public abstract void actualizar(Paciente paciente) throws Exception;
	public ArrayList<Paciente> listarPaciente();
}
