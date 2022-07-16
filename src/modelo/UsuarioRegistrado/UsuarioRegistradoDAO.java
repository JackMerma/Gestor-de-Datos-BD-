package src.modelo.UsuarioRegistrado;

import java.sql.Connection;
import java.sql.*;
import java.util.*;

import src.modelo.Conexion;
import src.modelo.DAO;

public class UsuarioRegistradoDAO extends DAO<UsuarioRegistrado> {

	private Conexion con = new Conexion();
	private PreparedStatement ps; 
	private ResultSet rs;
	private Connection bd;  

	// constructor
	public UsuarioRegistradoDAO() {
		super();
	}

	// Listar
	public ArrayList<UsuarioRegistrado> listar(){
		ArrayList<UsuarioRegistrado> lista = new ArrayList<UsuarioRegistrado>();
		String sql = "SELECT * FROM `V4M_USUARIO_REGISTRADOS_DETALLE`";

		try{
			con.conectar();
			bd = con.getConnection();
			ps = bd.prepareStatement(sql);
			rs = ps.executeQuery();
			// recibimos los resultados
			while(rs.next()){
				classNormal = new UsuarioRegistrado();
				classNormal.setIde(rs.getInt(1));
				classNormal.setUserName(rs.getString(2));
				classNormal.setPassword(rs.getString(3));
				classNormal.setEstadoRegistro(rs.getString(4).charAt(0));
				lista.add(classNormal);
			}
			System.out.println("UsuarioRegistradoDAO Listar:CORRECTO");

		}catch(Exception e){
			System.out.println("UsuarioRegistradoDAO listar:ERROR");
			System.err.println(e);
		}finally{
			con.desconectar();
		}
		
		return lista;
	}

	// agregar
	public int add(UsuarioRegistrado usuRegis){
		int state = 0;
		String sql = "INSERT INTO `V4M_USUARIO_REGISTRADOS_DETALLE` (`UsuRegDetIde`, `UsuRegDetUsu`, `UsuRegDetPass`, `UsuRegEstReg`) VALUES (?, ?, ?, ?);";
		
		try{
			con.conectar();
			bd = con.getConnection();
			ps = bd.prepareStatement(sql);

			// llenamos los datos
			ps.setString(1,usuRegis.getIde()+"");
			ps.setString(2,usuRegis.getUserName()+"");
			ps.setString(3,usuRegis.getPassword()+"");
			ps.setString(4, "A");

			state = ps.executeUpdate();
			System.out.println("UsuarioRegistradoDAO Add: CORRECTO");

		}catch(SQLException e){
			System.out.println("UsuarioRegistradoDAO add: ERROR"); 
			System.out.println(e);
		}finally{
			con.desconectar();
		}
		return state;
	}

	// modificar
	public int modificar(UsuarioRegistrado usuRegis){
		int state = 0;
		String sql = "UPDATE `V4M_USUARIO_REGISTRADOS_DETALLE` SET `UsuRegDetUsu` = ?, `UsuRegDetPass` = ?, `UsuRegEstReg` = ? WHERE `V4M_USUARIO_REGISTRADOS_DETALLE`.`UsuRegDetIde` = ?;";
		
		try{
			con.conectar();
			bd = con.getConnection();
			ps = bd.prepareStatement(sql);

			// llenamos datos
			ps.setString(1,usuRegis.getUserName()+"");
			ps.setString(2,usuRegis.getPassword()+"");
			ps.setString(3,usuRegis.getEstadoRegistro()+"");
			ps.setString(4,usuRegis.getIde()+"");

			state = ps.executeUpdate(); 
			System.out.println("UsuarioRegistradoDAO ModificarInter: CORRECTO");
			
		}catch (SQLException e){
			System.out.println("UsuarioRegistradoDAO ModificarInter: ERROR");
			System.out.println(e);
		}finally{
			con.desconectar();
		}

		return state;
	}

}


