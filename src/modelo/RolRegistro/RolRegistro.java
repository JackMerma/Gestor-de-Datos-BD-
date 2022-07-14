package src.modelo.RolRegistro;

public class RolRegistro {
	public int ide;
	public String descripcionRol;
	public char estadoRegistro;

	public RolRegistro(int ide, String descripcionRol){
		this.ide = ide;
		this.descripcionRol = descripcionRol;
		this.estadoRegistro = 'A';
		
	}

	public RolRegistro(){
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
