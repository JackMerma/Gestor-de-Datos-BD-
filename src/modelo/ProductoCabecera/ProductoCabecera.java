package src.modelo.ProductoCabecera;

public class ProductoCabecera {
	public int facturaIde;
	public int productoIde;
	public int cantidad;
	public char estadoRegistro;

	// constructor all args
	public ProductoCabecera(int facturaIde, int productoIde, int cantidad, char estadoRegistro) {
		this.facturaIde = facturaIde;
		this.productoIde = productoIde;
		this.cantidad = cantidad;
		this.estadoRegistro = estadoRegistro;
	}

	// constructor no args
	public ProductoCabecera() {
		this(-1, -1, -1, 'A');
	}

	// setters and getters
	public void setFacturaIde(int facturaIde) {
		this.facturaIde = facturaIde;
	}

	public void setProductoIde(int productoIde) {
		this.productoIde = productoIde;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public void setEstadoRegistro(char estadoRegistro) {
		this.estadoRegistro = estadoRegistro;
	}

	public int getFacturaIde() {
		return facturaIde;
	}

	public int getProductoIde() {
		return productoIde;
	}

	public int getCantidad() {
		return cantidad;
	}

	public char getEstadoRegistro() {
		return estadoRegistro;
	}

}
