package eam.desarrollo.hospital.interfaces;

import java.util.ArrayList;

import eam.desarrollo.hospital.entidades.Cita;
import eam.desarrollo.hospital.entidades.TipoCita;

public interface IntTipoCita {
	public abstract void crear(TipoCita tipocita) throws Exception;
	public abstract TipoCita buscar(String numerocita) throws Exception;
	public abstract void eliminar(String idCita) throws Exception;
	public abstract void actualizar(TipoCita cita) throws Exception;
	public ArrayList<TipoCita> listarTipocita();
}
