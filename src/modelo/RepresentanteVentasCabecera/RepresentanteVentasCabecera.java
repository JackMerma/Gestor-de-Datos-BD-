package src.modelo.RepresentanteVentasCabecera;

public class RepresentanteVentasCabecera {
    // identificador
    public int ide;

    // llaves foraneas
    public int repIde;

    // Atributos
    public char estadoRegistro;

    // Constructor
    public RepresentanteVentasCabecera(int ide, int repIde, char estadoRegistro) {
        this.ide = ide;
        this.repIde = repIde;
        this.estadoRegistro = estadoRegistro;
    }

    // set and geters
    public RepresentanteVentasCabecera() {
        this(-1, -1, 'A');
    }

    public int getIde() {
        return ide;
    }

    public void setIde(int ide) {
        this.ide = ide;
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
