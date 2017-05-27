package eam.desarrollo.hospital.interfaces;

import java.sql.ResultSet;

import eam.desarrollo.hospital.entidades.Agenda;


public interface IntAgenda {
	public abstract void crear(Agenda agenda) throws Exception;
	public abstract void buscar(String idagenda) throws Exception;
	public abstract void eliminar(String numerocita) throws Exception;
	public abstract void actualizar(Agenda agenda) throws Exception;
	public void listarAgenda(Agenda agenda);
	public ResultSet listarAgenda() throws Exception;
}
