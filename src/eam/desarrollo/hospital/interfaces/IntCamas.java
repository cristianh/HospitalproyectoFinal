package eam.desarrollo.hospital.interfaces;

import eam.desarrollo.hospital.entidades.Cama;


public interface IntCamas {
	public abstract void crear(Cama cama) throws Exception;
	public abstract Cama buscar(String identificacion) throws Exception;
	public abstract void eliminar(String id) throws Exception;
	public abstract void actualizar(Cama cama) throws Exception;
	public abstract java.sql.ResultSet listarCama() throws Exception;
}
