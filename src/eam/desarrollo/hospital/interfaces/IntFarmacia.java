package eam.desarrollo.hospital.interfaces;

import eam.desarrollo.hospital.entidades.Farmacia;

public interface IntFarmacia {
	public abstract void crear(Farmacia farmacia) throws Exception;
	public abstract Farmacia buscar(String id) throws Exception;
	public abstract void eliminar(String id) throws Exception;
	public abstract void actualizar(Farmacia farmacia) throws Exception;
	public abstract java.sql.ResultSet listarFarmacias() throws Exception;
}
