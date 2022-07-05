package src.modelo;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.*;
import java.util.*;

public class RolRegistroDAO {

	public Conexion con = new Conexion();
	public RolRegistro registro = new RolRegistro();
	private PreparedStatement ps; 
	private ResultSet rs;
	private Connection bd;  

	public ArrayList<RolRegistro> listar(){
		ArrayList<RolRegistro> listRegistro = new ArrayList<RolRegistro>();
		String sql = "SELECT * FROM `GZZ_ROL_REGISTRO`";

		try{
			con.conectar();
			bd = con.getConnection();
			ps = bd.prepareStatement(sql);
			rs = ps.executeQuery();
			// recibimos los resultados
			while(rs.next()){
				registro = new RolRegistro();
				registro.setIde(rs.getInt(1));
				registro.setDescripcionRol(rs.getString(2));
				registro.setEstadoRegistro(rs.getString(4).charAt(0));
				listRegistro.add(registro);
			}
			System.out.println("RolRegistroDAO Listar:CORRECTO");

		}catch(Exception e){
			System.out.println("RolRegistroDAO listar:ERROR");
			System.err.println(e);
		}finally{
			con.desconectar();
		}
		
		return listRegistro;
	}

	// agregar
	public int add(RolRegistro registro){
		int state = 0;
		String sql = "INSERT INTO `GZZ_ROL_REGISTRO` (`RolRegIde`, `RolRegDes`, `RolRegEstReg`) VALUES (?, ?, ?);";
		try{
			con.conectar();
			bd = con.getConnection();
			ps = bd.prepareStatement(sql);
			// llenamos los datos
			ps.setString(1,registro.getIde()+"");
			ps.setString(2,registro.getDescripcionRol()+"");
			ps.setString(3, "A");
			state = ps.executeUpdate();
			System.out.println("RolRegistroDAO Add: CORRECTO");

		}catch(SQLException e){
			System.out.println("RolRegistroDAO add: ERROR"); 
			System.out.println(e);
		}finally{
			con.desconectar();
		}
		return state;
	}

	public int modificar(RolRegistro registro){
		int state = 0;
		String sql = "UPDATE `GZZ_ROL_REGISTRO` SET `RolRegDes` = ?, `RolRegEstReg` = ? WHERE `GZZ_ROL_REGISTRO`.`RolRegIde` = ?;";
		try{
			con.conectar();
			bd = con.getConnection();
			ps = bd.prepareStatement(sql);
			// llenamos datos
			ps.setString(1,registro.getDescripcionRol()+"");
			ps.setString(2,registro.getEstadoRegistro()+"");
			ps.setString(3,registro.getIde()+"");
			state = ps.executeUpdate(); 
			System.out.println("RolRegistroDAO ModificarInter: CORRECTO");
		}catch (SQLException e){
			System.out.println("RolRegistroDAO ModificarInter: ERROR");
			System.out.println(e);
		}finally{
			con.desconectar();
		}

		return state;
	}

}


