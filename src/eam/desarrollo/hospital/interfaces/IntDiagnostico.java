package eam.desarrollo.hospital.interfaces;


import eam.desarrollo.hospital.entidades.Diagnostico;

public interface IntDiagnostico {
	public abstract void crear(Diagnostico diagnostico) throws Exception;
	public abstract Diagnostico buscar(String id) throws Exception;
	public abstract void eliminar(String id) throws Exception;
	public abstract void actualizar(Diagnostico diagnostico) throws Exception;
	public abstract java.sql.ResultSet listarDiagnostico() throws Exception;
}
