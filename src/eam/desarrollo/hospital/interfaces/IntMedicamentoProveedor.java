package eam.desarrollo.hospital.interfaces;


import eam.desarrollo.hospital.entidades.MedicamentoProveedor;

public interface IntMedicamentoProveedor {
	public abstract void crear(MedicamentoProveedor medicamento) throws Exception;
	public abstract MedicamentoProveedor buscar(String id) throws Exception;
	public abstract void eliminar(String id) throws Exception;
	public abstract void actualizar(MedicamentoProveedor medicamento) throws Exception;
	public abstract java.sql.ResultSet listarMedicamentoProveedor() throws Exception;
}
