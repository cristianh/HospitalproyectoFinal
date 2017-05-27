package eam.desarrollo.hospital.interfaces;

import java.util.ArrayList;

import eam.desarrollo.hospital.entidades.EstadoCita;


public interface IntEstadoCita {
	public abstract void crear(EstadoCita estadocita) throws Exception;
	public abstract EstadoCita buscar(String numerocita) throws Exception;
	public abstract void eliminar(String idEstadiCita) throws Exception;
	public abstract void actualizar(EstadoCita cita) throws Exception;
	public ArrayList<EstadoCita> listarEstadoCita();
}
