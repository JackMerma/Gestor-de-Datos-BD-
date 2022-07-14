package src.modelo.Cargo;

import java.sql.Connection;
import java.sql.*;
import java.util.*;

import src.modelo.Conexion;
import src.modelo.DAO;

public class CargoDAO extends DAO<Cargo> {

	private Conexion con = new Conexion();
	private PreparedStatement ps; 
	private ResultSet rs;
	private Connection bd;  

	// constructor
	public CargoDAO() {
		super();
	}

	// Listar
	public ArrayList<Cargo> listar(){
		ArrayList<Cargo> listCargo = new ArrayList<Cargo>();
		String sql = "SELECT * FROM `GZZ_CARGO`";

		try{
			con.conectar();
			bd = con.getConnection();
			ps = bd.prepareStatement(sql);
			rs = ps.executeQuery();
			// recibimos los resultados
			while(rs.next()){
				classNormal = new Cargo();
				classNormal.setIde(rs.getInt(1));
				classNormal.setDescripcionCargo(rs.getString(2));
				classNormal.setSueldo(rs.getInt(3));
				classNormal.setEstadoRegistro(rs.getString(4).charAt(0));
				listCargo.add(classNormal);
			}
			System.out.println("CargoDAO Listar:CORRECTO");

		}catch(Exception e){
			System.out.println("CargoDAO listar:ERROR");
			System.err.println(e);
		}finally{
			con.desconectar();
		}
		
		return listCargo;
	}

	// agregar
	public int add(Cargo cargo){
		int state = 0;
		String sql = "INSERT INTO `GZZ_CARGO` (`CarIde`, `CarDes`, `CarSue`, `CatEstReg`) VALUES (?, ?, ?, ?);";
		
		try{
			con.conectar();
			bd = con.getConnection();
			ps = bd.prepareStatement(sql);

			// llenamos los datos
			ps.setString(1,cargo.getIde()+"");
			ps.setString(2,cargo.getDescripcionCargo()+"");
			ps.setString(3,cargo.getSueldo()+"");
			ps.setString(4, "A");

			state = ps.executeUpdate();
			System.out.println("CargoDAO Add: CORRECTO");

		}catch(SQLException e){
			System.out.println("CargoDAO add: ERROR"); 
			System.out.println(e);
		}finally{
			con.desconectar();
		}
		return state;
	}

	// modificar
	public int modificar(Cargo cargo){
		int state = 0;
		String sql = "UPDATE `GZZ_CARGO` SET `CarDes` = ?, `CarSue` = ?, `CatEstReg` = ? WHERE `GZZ_CARGO`.`CarIde` = ?;";
		
		try{
			con.conectar();
			bd = con.getConnection();
			ps = bd.prepareStatement(sql);

			// llenamos datos
			ps.setString(1,cargo.getDescripcionCargo()+"");
			ps.setString(2,cargo.getSueldo()+"");
			ps.setString(3,cargo.getEstadoRegistro()+"");
			ps.setString(4,cargo.getIde()+"");

			state = ps.executeUpdate(); 
			System.out.println("CargoDAO ModificarInter: CORRECTO");
			
		}catch (SQLException e){
			System.out.println("CargoDAO ModificarInter: ERROR");
			System.out.println(e);
		}finally{
			con.desconectar();
		}

		return state;
	}

}


