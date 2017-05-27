package eam.desarrollo.hospital.interfaces;

import java.sql.ResultSet;

import eam.desarrollo.hospital.entidades.Cita;


public interface IntCita {
	public abstract void crear(Cita cita) throws Exception;
	public abstract ResultSet buscar(String numerocita) throws Exception;
	public abstract void eliminar(String numerocita) throws Exception;
	public abstract void actualizar(Cita cita) throws Exception;
	public void listarPaciente(Cita paciente);
	public ResultSet listarMedicos() throws Exception;
}
