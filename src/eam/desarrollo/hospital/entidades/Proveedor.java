package eam.desarrollo.hospital.entidades;

public class Proveedor {
private String idProveedor;
private String empresa;
private String nombre;
private String direccion;
private String telefono;
private String email;
public Proveedor(String idProveedor, String empresa, String nombre, String direccion, String telefono, String email) {
	super();
	this.idProveedor = idProveedor;
	this.empresa = empresa;
	this.nombre = nombre;
	this.direccion = direccion;
	this.telefono = telefono;
	this.email = email;
}
public String getIdProveedor() {
	return idProveedor;
}
public void setIdProveedor(String idProveedor) {
	this.idProveedor = idProveedor;
}
public String getEmpresa() {
	return empresa;
}
public void setEmpresa(String empresa) {
	this.empresa = empresa;
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public String getDireccion() {
	return direccion;
}
public void setDireccion(String direccion) {
	this.direccion = direccion;
}
public String getTelefono() {
	return telefono;
}
public void setTelefono(String telefono) {
	this.telefono = telefono;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}


}
