package eam.desarrollo.hospital.interfaces;


import eam.desarrollo.hospital.entidades.Habitacion;

public interface IntHabitacion {
	public abstract void crear(Habitacion habitacion) throws Exception;
	public abstract Habitacion buscar(String identificacion) throws Exception;
	public abstract void eliminar(String id) throws Exception;
	public abstract void actualizar(Habitacion cama) throws Exception;
	public abstract java.sql.ResultSet listarCama() throws Exception;
}
