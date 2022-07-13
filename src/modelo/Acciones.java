package src.modelo;

public class Acciones {
	public int ide;
	public int ideHist;
	public char estadoRegistro;

	public Acciones(int ide, int ideHist){
		this.ide = ide;
		this.ideHist = ideHist;
		this.estadoRegistro = 'A';
		
	}

	public Acciones(){
		this(-1, -1);
	}

	public void setIde(int ide){
		this.ide = ide;
	}

	public void setIdeHistoria(int ideHist){
		this.ideHist = ideHist;
	}

	public void setEstadoRegistro(char s){
		this.estadoRegistro = s;
	}

	public int getIde(){
		return this.ide;
	}

	public int getIdeHistoria(){
		return this.ideHist;
	}

	public char getEstadoRegistro(){
		return this.estadoRegistro;
	}
}

