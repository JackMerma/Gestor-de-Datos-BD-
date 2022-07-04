package src.modelo;

public class Cargo {
	public int ide;
	public String descripcionCargo;
	public int sueldo;
	public char estadoRegistro;

	public Cargo(int ide, String descripcionCargo, int sueldo){
		this.ide = ide;
		this.descripcionCargo = descripcionCargo;
		this.sueldo = sueldo;
		this.estadoRegistro = 'A';
		
	}

	public Cargo(){
		this(-1, "", -1);
	}

	public void setIde(int ide){
		this.ide = ide;
	}

	public void setDescripcionCargo(String descripcionCargo){
		this.descripcionCargo = descripcionCargo;
	}

	public void setSueldo(int sueldo){
		this.sueldo = sueldo;
	}

	public void setEstadoRegistro(char s){
		this.estadoRegistro = s;
	}

	public int getIde(){
		return this.ide;
	}

	public String getDescripcionCargo(){
		return this.descripcionCargo;
	}

	public int getSueldo(){
		return this.sueldo;
	}

	public char getEstadoRegistro(){
		return this.estadoRegistro;
	}
}
