package eam.desarrollo.hospital.interfaces;

import java.sql.ResultSet;


import eam.desarrollo.hospital.entidades.Proveedor;

public interface IntProveedor {
	public abstract void crear(Proveedor proveedor) throws Exception;
	public abstract Proveedor buscar(String nombre) throws Exception;
	public abstract void eliminar(String nombre) throws Exception;
	public abstract void actualizar(Proveedor nombre) throws Exception;
	public void listarProveedor(Proveedor proveedores);

}
