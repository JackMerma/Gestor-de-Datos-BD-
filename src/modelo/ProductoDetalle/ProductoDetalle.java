package src.modelo.ProductoDetalle;

public class ProductoDetalle {
    public int ide;
    public String fabricante;
    public String descripcion;
    public float precio;
    public int existencia;
    public String claseABC;
    public float unidadMedida;
    public int stockActual;
    public int stockMinimo;
    public int stockMaximo;
    public char estadoRegistro;

    // constructor all args
    public ProductoDetalle(int ide, String fabricante, String descripcion, float precio, int existencia,
            String claseABC, float unidadMedida, int stockActual, int stockMinimo, int stockMaximo,
            char estadoRegistro) {
        this.ide = ide;
        this.fabricante = fabricante;
        this.descripcion = descripcion;
        this.precio = precio;
        this.existencia = existencia;
        this.claseABC = claseABC;
        this.unidadMedida = unidadMedida;
        this.stockActual = stockActual;
        this.stockMinimo = stockMinimo;
        this.stockMaximo = stockMaximo;
        this.estadoRegistro = estadoRegistro;
    }

    // constructor no args
    public ProductoDetalle() {
        this(-1, "", "", 0, 0, "", 0, 0, 0, 0, 'A');
    }

    // setters and getters
    public void setIde(int ide) {
        this.ide = ide;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public void setExistencia(int existencia) {
        this.existencia = existencia;
    }

    public void setClaseABC(String claseABC) {
        this.claseABC = claseABC;
    }

    public void setUnidadMedida(float unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public void setStockActual(int stockActual) {
        this.stockActual = stockActual;
    }

    public void setStockMinimo(int stockMinimo) {
        this.stockMinimo = stockMinimo;
    }

    public void setStockMaximo(int stockMaximo) {
        this.stockMaximo = stockMaximo;
    }

    public void setEstadoRegistro(char estadoRegistro) {
        this.estadoRegistro = estadoRegistro;
    }

    public int getIde() {
        return ide;
    }

    public String getFabricante() {
        return fabricante;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public float getPrecio() {
        return precio;
    }

    public int getExistencia() {
        return existencia;
    }

    public String getClaseABC() {
        return claseABC;
    }

    public float getUnidadMedida() {
        return unidadMedida;
    }

    public int getStockActual() {
        return stockActual;
    }

    public int getStockMinimo() {
        return stockMinimo;
    }

    public int getStockMaximo() {
        return stockMaximo;
    }

    public char getEstadoRegistro() {
        return estadoRegistro;
    }

}
