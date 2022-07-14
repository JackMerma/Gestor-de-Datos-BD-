package src.modelo.TipoRepresentante;

public class TipoRepresentanteVenta {
	public int ide;
	public String descTipoRepVenta;
	public char estadoRegistro;

	public TipoRepresentanteVenta(int ide, String descTipoRepVenta){
		this.ide = ide;
		this.descTipoRepVenta = descTipoRepVenta;
		this.estadoRegistro = 'A';
	}

	public TipoRepresentanteVenta(){
		this(-1, "");
	}

	public void setIde(int ide){
		this.ide = ide;
	}

	public void setDescTipoRepVenta(String descTipoRepVenta){
		this.descTipoRepVenta = descTipoRepVenta;
	}

	public void setEstadoRegistro(char s){
		this.estadoRegistro = s;
	}

	public int getIde(){
		return this.ide;
	}

	public String getDescTipoRepVenta(){
		return this.descTipoRepVenta;
	}

	public char getEstadoRegistro(){
		return this.estadoRegistro;
	}
}
