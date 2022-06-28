package src.modelo;

import java.sql.DriverManager;
import java.sql.Connection;

import java.util.*;

public class CategoriaClienteDAO {

	public Conexion con = new Conexion();
	public CategoriaCliente cc = new CategoriaCliente();

	public ArrayList<CategoriaCliente> listar(){
		ArrayList<CategoriaCliente> dat = new ArrayList<CategoriaCliente>();

		try{
			con.conectar();
		}catch(Exception e){
			System.err.println(e);
		}
		
		return dat;
	}
}


