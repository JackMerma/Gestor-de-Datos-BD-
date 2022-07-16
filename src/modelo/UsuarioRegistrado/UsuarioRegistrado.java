package src.modelo.UsuarioRegistrado;

public class UsuarioRegistrado {
	public int ide;
	public String userName;
	public String password;

	public UsuarioRegistrado(int ide, String userName, String password) {
		this.ide = ide;
		this.userName = userName;
		this.password = password;
	}

	public UsuarioRegistrado() {
		this(-1, "", "password");
	}

	// set and geters
	public int getIde() {
		return ide;
	}

	public void setIde(int ide) {
		this.ide = ide;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
