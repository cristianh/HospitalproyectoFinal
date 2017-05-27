package eam.desarrollo.hospital.testUnit;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import eam.desarrollo.hospital.DAO.DAOPaciente;
import eam.desarrollo.hospital.entidades.Departamento;
import eam.desarrollo.hospital.entidades.Genero;
import eam.desarrollo.hospital.entidades.Municipio;
import eam.desarrollo.hospital.entidades.Paciente;
import eam.desarrollo.hospital.entidades.Tipodocumento;

public class TestUnitCrudPaciente {
	public DAOPaciente daoP= new DAOPaciente();
	public Paciente nuevo_paciente;
	public Paciente nuevo_pacienteTest;
	public Paciente nuevo_paciente2;
	public Paciente nuevo_paciente3;
	public Tipodocumento nuevo_tipo_documento;
	public Paciente paciente;
	public DAOPaciente daopacienteTest;
	

	@Test
	public void test() {

		// Tipo Documento
		String tipo_documento="Cedula";
		String id_documento="1";
		
		//Municipio variables
		String idMunicipio="1";
		String nombreMunicipio="Armenia";
		
		//Departamento variables
		String idDepartamento="2";
		String nombreDepartamento="Quindio";
		
		//Genero Variables
		String idGenero= "1";
		String tipo="Masculiono";
		
	
		Departamento departamento =  new Departamento(idDepartamento,nombreDepartamento);
		
		String idPaciente="001";
		String nombrePaciente="Juan";
		String apellidoPaciente="Sanchez";
		String direccionPaciente="B los olivos 13 # 12";
		Date fechaNacimientoPaciente=new Date(1989, 01, 23);
		String telefonoPaciente="312222332";
		Float pesoPaciente=(float) 34;
		String numeroDocumentoPaciente="122232322";
		Tipodocumento tipodocumento= new Tipodocumento(id_documento,tipo_documento);
		Municipio municipio= new Municipio(idMunicipio, nombreMunicipio);
		Genero genero = new Genero(idGenero, tipo);
		nuevo_paciente = new Paciente(idPaciente, nombrePaciente, apellidoPaciente, direccionPaciente, fechaNacimientoPaciente, telefonoPaciente, pesoPaciente, numeroDocumentoPaciente, tipodocumento, municipio, genero);
		
		try {
			daoP.crear(nuevo_paciente);
			} catch (Exception e){
				
			}
			finally{
				System.out.println(nuevo_paciente.toString());
			}
		
		// Tipo Documento
				String tipo_documento2="Pasaporte";
				String id_documento2="2";
				
				//Municipio variables
				String idMunicipio2="2";
				String nombreMunicipio2="Armenia";
				
				//Departamento variables
				String idDepartamento2="3";
				String nombreDepartamento2="Risaralda";
				
				//Genero Variables
				String idGenero2= "2";
				String tipo2="Femenino";
				
			
				Departamento departamento2 =  new Departamento(idDepartamento,nombreDepartamento);
				
				String idPaciente2="002";
				String nombrePaciente2="Manuela";
				String apellidoPaciente2="Molina";
				String direccionPaciente2="B los olivos 45 # 12";
				Date fechaNacimientoPaciente2=new Date(2009, 01, 23);
				String telefonoPaciente2="3129999032";
				Float pesoPaciente2=(float) 56;
				String numeroDocumentoPaciente2="0002232322";
				Tipodocumento tipodocumento2= new Tipodocumento(id_documento2,tipo_documento2);
				Municipio municipio2= new Municipio(idMunicipio2, nombreMunicipio2);
				Genero genero2 = new Genero(idGenero2, tipo2);
				nuevo_paciente2 = new Paciente(idPaciente2, nombrePaciente2, apellidoPaciente2, direccionPaciente2, fechaNacimientoPaciente2, telefonoPaciente2, pesoPaciente2, numeroDocumentoPaciente2, tipodocumento2, municipio2, genero2);
				
		
		
		
		try {
		daoP.crear(nuevo_paciente2);
		} catch (Exception e){
			
		}
		finally{
			System.out.println(nuevo_paciente2.toString());
		}
		
		
		/*try {
		paciente= daoP.buscar(002);
		} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
		finally{
		System.out.println("Usuario encontrado");
		}
		
		// Tipo Documento
				String tipo_documento3="Cedula";
				String id_documento3="1";
				
				//Municipio variables
				String idMunicipio3="1";
				String nombreMunicipio3="Armenia";
				
				//Departamento variables
				String idDepartamento3="2";
				String nombreDepartamento3="Quindio";
				
				//Genero Variables
				String idGenero3= "1";
				String tipo3="Masculiono";
				
			
				Departamento departamento3 =  new Departamento(idDepartamento,nombreDepartamento);
				
				String idPaciente3="001";
				String nombrePaciente3="JuanR";
				String apellidoPaciente3="Sanchez";
				String direccionPaciente3="B los olivos 13 # 12";
				Date fechaNacimientoPaciente3=new Date(1989, 01, 23);
				String telefonoPaciente3="312222332";
				Float pesoPaciente3=(float) 34;
				String numeroDocumentoPaciente3="122232322";
				Tipodocumento tipodocumento3= new Tipodocumento(id_documento3,tipo_documento3);
				Municipio municipio3= new Municipio(idMunicipio3, nombreMunicipio3);
				Genero genero3 = new Genero(idGenero3, tipo3);
				nuevo_paciente3 = new Paciente(idPaciente3, nombrePaciente3, apellidoPaciente3, direccionPaciente3, fechaNacimientoPaciente3, telefonoPaciente3, pesoPaciente3, numeroDocumentoPaciente3, tipodocumento3, municipio3, genero3);
				
				try {
					daoP.actualizar(nuevo_paciente3);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}		
		
				
		/*try {
			daoP.eliminar("001");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			System.out.println("Usuario Eliminado");
		}*/
				/*JOptionPane.showMessageDialog(this, "Paciente registrado", "El paciente a sido registrado",
						JOptionPane.ERROR_MESSAGE);*/
			
		
		fail("Not yet implemented");
	}
	
	@Test
	public void crearPaciente(){
		daopacienteTest.crear(nuevo_paciente);
	}

}
