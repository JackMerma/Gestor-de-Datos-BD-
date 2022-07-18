package src.modelo.Acciones;

import java.sql.Connection;
import java.sql.*;
import java.util.*;

import src.modelo.Conexion;
import src.modelo.DAO;

//import src.modelo.DAO;

public class AccionesDAO extends DAO<Acciones>{

	public Conexion con = new Conexion();
	public Acciones acciones = new Acciones();
	private PreparedStatement ps; 
	private ResultSet rs;
	private Connection bd;  

	// constructor
	public AccionesDAO() {
		super();
	}

	public ArrayList<Acciones> listar(){
		ArrayList<Acciones> listAcciones = new ArrayList<Acciones>();
		String sql = "SELECT * FROM `V3H_ACCIONES`";

		try{
			con.conectar();
			bd = con.getConnection();
			ps = bd.prepareStatement(sql);
			rs = ps.executeQuery();
			// recibimos los resultados
			while(rs.next()){
				acciones = new Acciones();
				acciones.setIde(rs.getInt(1));
				acciones.setIdeHistoria(rs.getInt(2));
				acciones.setEstadoRegistro(rs.getString(3).charAt(0));
				listAcciones.add(acciones);
			}
			System.out.println("AccionesDAO Listar:CORRECTO");

		}catch(Exception e){
			System.out.println("AccionesDAO listar:ERROR");
			System.err.println(e);
		}finally{
			con.desconectar();
		}
		
		return listAcciones;
	}

	// agregar
	public int add(Acciones acciones){
		int state = 0;
		String sql = "INSERT INTO `V3H_ACCIONES` (`AccUsuRegDetIde`, `AccHisApliDetIde`, `AccEstReg`) VALUES (?, ?, ?);";
		try{
			con.conectar();
			bd = con.getConnection();
			ps = bd.prepareStatement(sql);
			// llenamos los datos
			ps.setString(1,acciones.getIde()+"");
			ps.setString(2,acciones.getIdeHistoria()+"");
			ps.setString(3, "A");
			state = ps.executeUpdate();
			System.out.println("AccionesDAO Add: CORRECTO");

		}catch(SQLException e){
			System.out.println("AccionesDAO add: ERROR"); 
			System.out.println(e);
		}finally{
			con.desconectar();
		}
		return state;
	}

	public int modificar(Acciones acciones){
		int state = 0;
		String sql = "UPDATE `V3H_ACCIONES` SET `AccHisApliDetIde` = ?, `AccEstReg` = ? WHERE `V3H_ACCIONES`.`AccUsuRegDetIde` = ?;";
		try{
			con.conectar();
			bd = con.getConnection();
			ps = bd.prepareStatement(sql);
			// llenamos datos
			ps.setString(1,acciones.getIdeHistoria()+"");
			ps.setString(2,acciones.getEstadoRegistro()+"");
			ps.setString(3,acciones.getIde()+"");
			state = ps.executeUpdate(); 
			System.out.println("AccionesDAO ModificarInter: CORRECTO");
		}catch (SQLException e){
			System.out.println("AccionesDAO ModificarInter: ERROR");
			System.out.println(e);
		}finally{
			con.desconectar();
		}

		return state;
	}

}
