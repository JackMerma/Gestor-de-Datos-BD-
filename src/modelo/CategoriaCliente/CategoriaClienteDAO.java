package src.modelo.CategoriaCliente;

import java.sql.Connection;
import java.sql.*;
import java.util.*;

import src.modelo.Conexion;
import src.modelo.DAO;

public class CategoriaClienteDAO extends DAO<CategoriaCliente> {

	private Conexion con = new Conexion();
	private PreparedStatement ps; 
	private ResultSet rs;
	private Connection bd;  

	// constructor
	public CategoriaClienteDAO() {
		super();
	}

	// listar
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
				classNormal = new CategoriaCliente();
				classNormal.setIde(rs.getInt(1));
				classNormal.setLimCredito(rs.getInt(2));
				classNormal.setEstadoRegistro(rs.getString(3).charAt(0));
				listCatCli.add(classNormal);
			}
			System.out.println("CategoriaClienteDAO Listar:CORRECTO");

		}catch(Exception e){
			System.out.println("CategoriaClienteDAO listar:ERROR");
			System.err.println(e);
		}finally{
			con.desconectar();
		}
		
		return listCatCli;
	}

	// agregar
	public int add(CategoriaCliente catCli){
		int state = 0;
		String sql = "INSERT INTO `GZZ_CATEGORIA_CLIENTE` (`CatCliIde`, `CatCliLimCre`, `CatCliEstReg`) VALUES (?, ?, ?);";
		try{
			con.conectar();
			bd = con.getConnection();
			ps = bd.prepareStatement(sql);

			// llenamos los datos
			ps.setString(1,catCli.getIde()+"");
			ps.setString(2,catCli.getLimCredito()+"");
			ps.setString(3, "A");

			state = ps.executeUpdate();
			System.out.println("categoriaClienteDao Add: CORRECTO");

		}catch(SQLException e){
			System.out.println("categoriaClienteDao add: ERROR"); 
			System.out.println(e);
		}finally{
			con.desconectar();
		}
		return state;
	}

	// modificar
	public int modificar(CategoriaCliente catCli){
		int state = 0;
		String sql = "UPDATE `GZZ_CATEGORIA_CLIENTE` SET `CatCliLimCre` = ?, `CatCliEstReg` = ? WHERE `GZZ_CATEGORIA_CLIENTE`.`CatCliIde` = ?;";
		try{
			con.conectar();
			bd = con.getConnection();
			ps = bd.prepareStatement(sql);

			// llenamos datos
			ps.setString(1,catCli.getLimCredito()+"");
			ps.setString(2,catCli.getEstadoRegistro()+"");
			ps.setString(3,catCli.getIde()+"");
			state = ps.executeUpdate(); 
			System.out.println("categoriaClienteDao ModificarInter: CORRECTO");
		}catch (SQLException e){
			System.out.println("categoriaClienteDao ModificarInter: ERROR");
			System.out.println(e);
		}finally{
			con.desconectar();
		}

		return state;
	}

}


