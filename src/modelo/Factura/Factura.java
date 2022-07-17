package src.modelo.Factura;

public class Factura {
    public int ide;
    public int importe;
    public String anio;
    public String mes;
    public String dia;
    public char estReg;

    public Factura(int ide, int importe, String anio, String mes, String dia, char estReg) {
        this.ide = ide;
        this.importe = importe;
        this.anio = anio;
        this.mes = mes;
        this.dia = dia;
        this.estReg = estReg;
    }

    // constructor con valores vacios
    public Factura() {
        this.ide = -1;
        this.importe = -1;
        this.anio = "";
        this.mes = "";
        this.dia = "";
        this.estReg = 'A';
    }

    // get and set
    public int getIde() {
        return ide;
    }

    public void setIde(int ide) {
        this.ide = ide;
    }

    public int getImporte() {
        return importe;
    }

    public void setImporte(int importe) {
        this.importe = importe;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public char getEstReg() {
        return estReg;
    }

    public void setEstReg(char c) {
        this.estReg = c;
    }

}
