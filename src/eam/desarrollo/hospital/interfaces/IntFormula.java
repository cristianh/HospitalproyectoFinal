package eam.desarrollo.hospital.interfaces;

import eam.desarrollo.hospital.entidades.Formula;

public interface IntFormula {
	public abstract void crear(Formula farmacia) throws Exception;
	public abstract Formula buscar(String id) throws Exception;
	public abstract void eliminar(String id) throws Exception;
	public abstract void actualizar(Formula farmacia) throws Exception;
	public abstract java.sql.ResultSet listarFormula() throws Exception;
}
