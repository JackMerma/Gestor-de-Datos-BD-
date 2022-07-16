package src.modelo.ClienteCabecera;

public class ClienteCabecera{
	public int ideFactCli;
	public int ideCli;
	public char estadoRegistro;

	public ClienteCabecera(int ideFactCli, int ideCli){
		this.ideFactCli = ideFactCli;
		this.ideCli = ideCli;
		this.estadoRegistro = 'A';
	}

	public ClienteCabecera(){
		this(-1, -1);
	}

	public void setIdeFacturaCliente(int ideFactCli){
		this.ideFactCli = ideFactCli;
	}

	public void setIdeCliente(int ideCli){
		this.ideCli = ideCli;
	}

	public void setEstadoRegistro(char s){
		this.estadoRegistro = s;
	}

	public int getIdeFacturaCliente(){
		return this.ideFactCli;
	}

	public int getIdeCliente(){
		return this.ideCli;
	}

	public char getEstadoRegistro(){
		return this.estadoRegistro;
	}
}
