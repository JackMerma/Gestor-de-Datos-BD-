package src.modelo;

public class Registro {
	public int ide;
	public String descripcionRol;
	public char estadoRegistro;

	public Registro(int ide, String descripcionRol){
		this.ide = ide;
		this.descripcionRol = descripcionRol;
		this.estadoRegistro = 'A';
		
	}

	public Registro(){
		this(-1, "");
	}

	public void setIde(int ide){
		this.ide = ide;
	}

	public void setDescripcionRol(String descripcionRol){
		this.descripcionRol = descripcionRol;
	}

	public void setEstadoRegistro(char s){
		this.estadoRegistro = s;
	}

	public int getIde(){
		return this.ide;
	}

	public String getDescripcionRol(){
		return this.descripcionRol;
	}

	public char getEstadoRegistro(){
		return this.estadoRegistro;
	}
}
