package src.modelo;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.*;
import java.util.*;

public class CategoriaClienteDAO {

	public Conexion con = new Conexion();
	public CategoriaCliente catCli = new CategoriaCliente();
	private PreparedStatement ps; 
	private ResultSet rs;
	private Connection bd;  

	public ArrayList<CategoriaCliente> listar(){
		ArrayList<CategoriaCliente> listCatCli = new ArrayList<CategoriaCliente>();
		String sql = "SELECT * FROM `GZZ_CATEGORIA_CLIENTE`";

		try{
			con.conectar();
			bd = con.getConnection();
			ps = bd.prepareStatement(sql);
			rs = ps.executeQuery();
			// recibimos los resultados
			while(rs.next()){
				catCli.setIde(rs.getInt(1));
				catCli.setLimCredito(rs.getInt(2));
				listCatCli.add(catCli);
			}
			System.out.println("CategoriaClienteDAO Listar:Correcto");

			con.desconectar();
		}catch(Exception e){
			System.err.println(e);
		}
		
		return listCatCli;
	}
}


