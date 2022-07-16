package src.modelo.RepresentanteVentasCabecera;

public class RepresentanteVentasCabecera {
    // identificador
    public int facIde;

    // llaves foraneas
    public int repIde;

    // Atributos
    public char estadoRegistro;

    // Constructor
    public RepresentanteVentasCabecera(int facIde, int repIde, char estadoRegistro) {
        this.facIde = facIde;
        this.repIde = repIde;
        this.estadoRegistro = estadoRegistro;
    }

    // set and geters
    public RepresentanteVentasCabecera() {
        this(-1, -1, 'A');
    }

    public int getFacIde() {
        return facIde;
    }

    public void setFacIde(int facIde) {
        this.facIde = facIde;
    }

    public int getRepIde() {
        return repIde;
    }

    public void setRepIde(int repIde) {
        this.repIde = repIde;
    }

    public char getEstadoRegistro() {
        return estadoRegistro;
    }

    public void setEstadoRegistro(char estadoRegistro) {
        this.estadoRegistro = estadoRegistro;
    }

}
