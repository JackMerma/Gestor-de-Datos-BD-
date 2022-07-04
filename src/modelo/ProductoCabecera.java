package src.modelo;

public class ProductoCabecera {
	public int ide;
	public int ideProducto;
	public int cantidad;
	public char estadoRegistro;

	public ProductoCabecera(int ide, int idProducto, int cantidad){
		this.ide = ide;
		this.ideProducto = ideProducto;
		this.cantidad = cantidad;
		this.estadoRegistro = 'A';
	}

	public ProductoCabecera(){
		this(-1, -1, -1);
	}

	public void setIde(int ide){
		this.ide = ide;
	}

	public void setIdeProducto(int ideProducto){
		this.ideProducto = ideProducto;
	}

	public void setCantidad(int cantidad){
		this.cantidad = cantidad;
	}

	public void setEstadoRegistro(char s){
		this.estadoRegistro = s;
	}

	public int getIde(){
		return this.ide;
	}

	public int getIdeProducto(){
		return this.ideProducto;
	}

	public int getCantidad(){
		return this.cantidad;
	}

	public char getEstadoRegistro(){
		return this.estadoRegistro;
	}
}

