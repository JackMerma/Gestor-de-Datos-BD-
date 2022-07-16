package src.modelo.HistorialAplicativoDetalle;

public class HistorialAplicativoDetalle {
    public int ide;
	 public String hora;
	 public String descripcion;
    public String anio;
    public String mes;
    public String dia;
    public String estReg;

    public HistorialAplicativoDetalle(int ide, String hora, String descripcion, String anio, String mes, String dia, String estReg) {
        this.ide = ide;
		  this.hora = hora;
		  this.descripcion = descripcion;
        this.anio = anio;
        this.mes = mes;
        this.dia = dia;
        this.estReg = estReg;
    }

    // constructor con valores vacios
    public HistorialAplicativoDetalle() {
        this.ide = -1;
		  this.hora = "";
		  this.descripcion = "";
        this.anio = "";
        this.mes = "";
        this.dia = "";
        this.estReg = "";
    }

    // get and set
    public int getIde() {
        return ide;
    }

    public void setIde(int ide) {
        this.ide = ide;
    }

	 public String getHora(){
		 return this.hora;
	 }

	 public void setHora(String hora){
		 this.hora = hora;
	 }

	 public String getDescripcion(){
		 return this.descripcion;
	 }

	 public void setDescripcion(String descripcion){
		 this.descripcion = descripcion;
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

    public String getEstReg() {
        return estReg;
    }

    public void setEstReg(String estReg) {
        this.estReg = estReg;
    }

}
