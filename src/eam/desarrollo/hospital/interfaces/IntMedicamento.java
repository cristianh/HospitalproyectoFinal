package eam.desarrollo.hospital.interfaces;


import eam.desarrollo.hospital.entidades.Medicamento;

public interface IntMedicamento {
	public abstract void crear(Medicamento medicamento) throws Exception;
	public abstract Medicamento buscar(String identificacion) throws Exception;
	public abstract void eliminar(String id) throws Exception;
	public abstract void actualizar(Medicamento cama) throws Exception;
	public abstract java.sql.ResultSet listarMedicamento() throws Exception;
}
