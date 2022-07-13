package src.modelo;

public class ClienteDetalle {
	public int ide;
	public int ideCategoria;
	public String empDesc;
	public int numEmple;
	public String pagoCuo;
	public int credito;
	public String departamento;
	public String nombre;
	public String comportamiento;
	public String apellPaterno;
	public String apellMaterno;
	public String direccion;
	public int telefono;
	public String correo;
	public char estadoRegistro;

	public ClienteDetalle(int ide, int ideCategoria, String empDesc, int numEmple, String pagoCuo, int credito, String departamento, String nombre, String comportamiento, String apellPaterno, String apellMaterno, String direccion, int telefono, String correo){
		this.ide = ide;
		this.ideCategoria = ideCategoria;
		this.empDesc = empDesc;
		this.numEmple = numEmple;
		this.pagoCuo = pagoCuo;
		this.credito = credito;
		this.departamento = departamento;
		this.nombre = nombre;
		this.comportamiento = comportamiento;
		this.apellPaterno = apellPaterno;
		this.apellMaterno = apellMaterno;
		this.direccion = direccion;
		this.telefono = telefono;
		this.correo = correo;
		this.estadoRegistro = 'A';
		
	}

	public ClienteDetalle(){
		this(-1, -1, "", -1, "", -1, "", "", "", "", "", "", -1, "");
	}

	public void setIde(int ide){
		this.ide = ide;
	}

	public void setIdeCategoria(int ideCategoria){
		this.ideCategoria = ideCategoria;
	}

	public void setEmpDescripcion(String empDesc){
		this.empDesc = empDesc;
	}

	public void setNumEmpleado(int numEmple){
		this.numEmple = numEmple;
	}

	public void setPagoCuota(String pagoCuo){
		this.pagoCuo = pagoCuo;
	}

	public void setCredito(int credito){
		this.credito = credito;
	}

	public void setDepartamento(String departamento){
		this.departamento = departamento;
	}

	public void setNombre(String nombre){
		this.nombre = nombre;
	}

	public void setComportamiento(String comportamiento){
		this.comportamiento = comportamiento;
	}

	public void setApellidoPaterno(String apellPaterno){
		this.apellPaterno = apellPaterno;
	}

	public void setApellidoMaterno(String apellMaterno){
		this.apellMaterno = apellMaterno;
	}

	public void setDireccion(String direccion){
		this.direccion = direccion;
	}

	public void setTelefono(int telefono){
		this.telefono = telefono;
	}

	public void setCorreo(String correo){
		this.correo = correo;
	}

	public void setEstadoRegistro(char s){
		this.estadoRegistro = s;
	}

	public int getIde(){
		return this.ide;
	}

	public int getIdeCategoria(){
		return this.ideCategoria;
	}

	public String getEmpDescripcion(){
		return this.empDesc;
	}

	public int getNumEmpleado(){
		return this.numEmple;
	}

	public String getPagoCuota(){
		return this.pagoCuo;
	}

	public int getCredito(){
		return this.credito;
	}

	public String getDepartamento(){
		return this.departamento;
	}

	public String getNombre(){
		return this.nombre;
	}

	public String getComportamiento(){
		return this.comportamiento;
	}

	public String getApellidoPaterno(){
		return this.apellPaterno;
	}

	public String getApellidoMaterno(){
		return this.apellMaterno;
	}

	public String getDireccion(){
		return this.direccion;
	}

	public int getTelefono(){
		return this.telefono;
	}

	public String getCorreo(){
		return this.correo;
	}

	public char getEstadoRegistro(){
		return this.estadoRegistro;
	}
}
