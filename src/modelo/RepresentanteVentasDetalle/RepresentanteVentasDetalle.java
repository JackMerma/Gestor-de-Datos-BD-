package src.modelo.RepresentanteVentasDetalle;

public class RepresentanteVentasDetalle {
    // identificador
    public int ide;

    // llaves foraneas
    public int oficinaIde;
    public int cargoIde;
    public int rolRegistroIde;
    public int tipoRepresentanteIde;
    public int UsuarioRegistradoIde;

    // Atributos
    public String nombre;
    public int edad;
    public String contrato;
    public String ObjeticoRepresentante;
    public String estadoRegistro;

    // Constructor
    public RepresentanteVentasDetalle(int ide, int oficinaIde, int cargoIde, int rolRegistroIde,
            int tipoRepresentanteIde, int UsuarioRegistradoIde, String nombre, int edad, String contrato,
            String ObjeticoRepresentante) {
        this.ide = ide;
        this.oficinaIde = oficinaIde;
        this.cargoIde = cargoIde;
        this.rolRegistroIde = rolRegistroIde;
        this.tipoRepresentanteIde = tipoRepresentanteIde;
        this.UsuarioRegistradoIde = UsuarioRegistradoIde;
        this.nombre = nombre;
        this.edad = edad;
        this.contrato = contrato;
        this.ObjeticoRepresentante = ObjeticoRepresentante;
        this.estadoRegistro = "A";
    }

    public RepresentanteVentasDetalle() {
        this(-1, -1, -1, -1, -1, -1, "", -1, "", "");
    }

    // set and geters
    public int getIde() {
        return ide;
    }

    public void setIde(int ide) {
        this.ide = ide;
    }

    public int getOficinaIde() {
        return oficinaIde;
    }

    public void setOficinaIde(int oficinaIde) {
        this.oficinaIde = oficinaIde;
    }

    public int getCargoIde() {
        return cargoIde;
    }

    public void setCargoIde(int cargoIde) {
        this.cargoIde = cargoIde;
    }

    public int getRolRegistroIde() {
        return rolRegistroIde;
    }

    public void setRolRegistroIde(int rolRegistroIde) {
        this.rolRegistroIde = rolRegistroIde;
    }

    public int getTipoRepresentanteIde() {
        return tipoRepresentanteIde;
    }

    public void setTipoRepresentanteIde(int tipoRepresentanteIde) {
        this.tipoRepresentanteIde = tipoRepresentanteIde;
    }

    public int getUsuarioRegistradoIde() {
        return UsuarioRegistradoIde;
    }

    public void setUsuarioRegistradoIde(int UsuarioRegistradoIde) {
        this.UsuarioRegistradoIde = UsuarioRegistradoIde;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getContrato() {
        return contrato;
    }

    public void setContrato(String contrato) {
        this.contrato = contrato;
    }

    public String getObjeticoRepresentante() {
        return ObjeticoRepresentante;
    }

    public void setObjeticoRepresentante(String ObjeticoRepresentante) {
        this.ObjeticoRepresentante = ObjeticoRepresentante;
    }

    public String getEstadoRegistro() {
        return estadoRegistro;
    }

    public void setEstadoRegistro(String estadoRegistro) {
        this.estadoRegistro = estadoRegistro;
    }

}
