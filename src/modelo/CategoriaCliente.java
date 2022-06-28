package src.modelo;

public class CategoriaCliente {
	public int ide;
	public int limCredito;

	public CategoriaCliente(int ide, int limCredito){
		this.ide = ide;
		this.limCredito = limCredito;
	}

	public CategoriaCliente(){
		this(-1, -1);
	}

	public void setIde(int ide){
		this.ide = ide;
	}

	public void setLimCredito(int limCredito){
		this.limCredito = limCredito;
	}

	public int getIde(){
		return this.ide;
	}

	public int getLimCredito(){
		return this.limCredito;
	}
}
