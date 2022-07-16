package src.modelo.HistorialAplicativoCabecera;

public class HistorialAplicativoCabecera {
	public int ideFact;
	public int ideHist;
	public char estadoRegistro;

	public HistorialAplicativoCabecera(int ideFact, int ideHist){
		this.ideFact = ideFact;
		this.ideHist = ideHist;
		this.estadoRegistro = 'A';
	}

	public HistorialAplicativoCabecera(){
		this(-1, -1);
	}

	public void setIdeFactura(int ideFact){
		this.ideFact = ideFact;
	}

	public void setIdeHistoria(int ideHist){
		this.ideHist = ideHist;
	}

	public void setEstadoRegistro(char s){
		this.estadoRegistro = s;
	}

	public int getIdeFactura(){
		return this.ideFact;
	}

	public int getIdeHistoria(){
		return this.ideHist;
	}

	public char getEstadoRegistro(){
		return this.estadoRegistro;
	}
}

