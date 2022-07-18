package src.modelo.HistorialAplicativoDetalle;

import java.sql.Connection;
import java.sql.*;
import java.util.*;

import src.modelo.Conexion;
import src.modelo.DAO;


public class HistorialAplicativoDetalleDAO extends DAO<HistorialAplicativoDetalle> {

	private Conexion con = new Conexion();
	private PreparedStatement ps; 
	private ResultSet rs;
	private Connection bd;  

	// constructor
	public HistorialAplicativoDetalleDAO() {
		super();
	}

	// Listar
	public ArrayList<HistorialAplicativoDetalle> listar(){
		ArrayList<HistorialAplicativoDetalle> listHistorialAplicativoDetalle = new ArrayList<HistorialAplicativoDetalle>();
		String sql = "SELECT * FROM `V3H_HISTORIAL _APLICATIVO_DETALLE`";

		try{
			con.conectar();
			bd = con.getConnection();
			ps = bd.prepareStatement(sql);
			rs = ps.executeQuery();
			// recibimos los resultados
			while(rs.next()){
				classNormal = new HistorialAplicativoDetalle();
				classNormal.setIde(rs.getInt(1));
				classNormal.setHora(rs.getString(2));
				classNormal.setDescripcion(rs.getString(3));
				classNormal.setAnio(rs.getString(4));
				classNormal.setMes(rs.getString(5));
				classNormal.setDia(rs.getString(6));
				classNormal.setEstReg(rs.getString(7).charAt(0));
				listHistorialAplicativoDetalle.add(classNormal);
			}
			System.out.println("HistorialAplicativoDetalleDAO Listar:CORRECTO");

		}catch(Exception e){
			System.out.println("HistorialAplicativoDetalleDAO listar:ERROR");
			System.err.println(e);
		}finally{
			con.desconectar();
		}
		
		return listHistorialAplicativoDetalle;
	}

	// agregar
	public int add(HistorialAplicativoDetalle historialAplicativoDetalle){
		int state = 0;
		String sql = "INSERT INTO `V3H_HISTORIAL _APLICATIVO_DETALLE` (`HisApliDetIde`, `HisApliDetHor`, `HisApliDetDes`, `HisApliDetAni`, `HisApliDetMes`, `HisApliDetDia`, `HisAplEstReg`) VALUES (?, ?, ?, ?, ?, ?, ?);";
		
		try{
			con.conectar();
			bd = con.getConnection();
			ps = bd.prepareStatement(sql);

			// llenamos los datos
			ps.setString(1,historialAplicativoDetalle.getIde()+"");
			ps.setString(2,historialAplicativoDetalle.getHora()+"");
			ps.setString(3,historialAplicativoDetalle.getDescripcion()+"");
			ps.setString(4,historialAplicativoDetalle.getAnio()+"");
			ps.setString(5,historialAplicativoDetalle.getMes()+"");
			ps.setString(6,historialAplicativoDetalle.getDia()+"");
			ps.setString(7, "A");

			state = ps.executeUpdate();
			System.out.println("HistorialAplicativoDetalleDAO Add: CORRECTO");

		}catch(SQLException e){
			System.out.println("HistorialAplicativoDetalleDAO add: ERROR"); 
			System.out.println(e);
		}finally{
			con.desconectar();
		}
		return state;
	}

	// modificar
	public int modificar(HistorialAplicativoDetalle historialAplicativoDetalle){
		int state = 0;
		String sql = "UPDATE `V3H_HISTORIAL _APLICATIVO_DETALLE` SET `HisApliDetHor` = ?, `HisApliDetDes` = ?, `HisApliDetAni` = ?, `HisApliDetMes` = ?, `HisApliDetDia` = ?, `HisAplEstReg` = ? WHERE `V3H_HISTORIAL _APLICATIVO_DETALLE`.`HisApliDetIde` = ?;";
		
		try{
			con.conectar();
			bd = con.getConnection();
			ps = bd.prepareStatement(sql);

			// llenamos datos
			ps.setString(1,historialAplicativoDetalle.getHora()+"");
			ps.setString(2,historialAplicativoDetalle.getDescripcion()+"");
			ps.setString(3,historialAplicativoDetalle.getAnio()+"");
			ps.setString(4,historialAplicativoDetalle.getMes()+"");
			ps.setString(5,historialAplicativoDetalle.getDia()+"");
			ps.setString(6, historialAplicativoDetalle.getEstReg()+"");
			ps.setString(7,historialAplicativoDetalle.getIde()+"");

			state = ps.executeUpdate(); 
			System.out.println("HistorialAplicativoDetalleDAO ModificarInter: CORRECTO");
			
		}catch (SQLException e){
			System.out.println("HistorialAplicativoDetalleDAO ModificarInter: ERROR");
			System.out.println(e);
		}finally{
			con.desconectar();
		}

		return state;
	}

}
