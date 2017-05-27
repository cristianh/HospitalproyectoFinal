/**
 * 
 */
package eam.desarrollo.hospital.entidades;

/**
 * @author Casa1
 *
 */
public class Login {

	/** serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	private int idLogin;
	
	private String user;
	
	private char password;
	
	private Boolean estado;
	
	private TipoUsuario idTipoUsuario;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * 
	 * @param idLogin
	 * @param user
	 * @param password
	 * @param estado
	 * @param idTipoUsuario
	 */
	public Login(int idLogin, String user, char password, Boolean estado, TipoUsuario idTipoUsuario) {
		super();
		this.idLogin = idLogin;
		this.user = user;
		this.password = password;
		this.estado = estado;
		this.idTipoUsuario = idTipoUsuario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
		result = prime * result + idLogin;
		result = prime * result + ((idTipoUsuario == null) ? 0 : idTipoUsuario.hashCode());
		result = prime * result + password;
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}
	
	

	public int getIdLogin() {
		return idLogin;
	}

	public void setIdLogin(int idLogin) {
		this.idLogin = idLogin;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public char getPassword() {
		return password;
	}

	public void setPassword(char password) {
		this.password = password;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public TipoUsuario getIdTipoUsuario() {
		return idTipoUsuario;
	}

	public void setIdTipoUsuario(TipoUsuario idTipoUsuario) {
		this.idTipoUsuario = idTipoUsuario;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Login other = (Login) obj;
		if (estado == null) {
			if (other.estado != null)
				return false;
		} else if (!estado.equals(other.estado))
			return false;
		if (idLogin != other.idLogin)
			return false;
		if (idTipoUsuario == null) {
			if (other.idTipoUsuario != null)
				return false;
		} else if (!idTipoUsuario.equals(other.idTipoUsuario))
			return false;
		if (password != other.password)
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}
	
	
	
	

}
