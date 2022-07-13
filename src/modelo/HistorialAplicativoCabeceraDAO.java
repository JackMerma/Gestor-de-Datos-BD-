package src.modelo;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.*;
import java.util.*;

public class HistorialAplicativoCabeceraDAO {

	public Conexion con = new Conexion();
	public HistorialAplicativoCabecera historialAplicativoCabecera = new HistorialAplicativoCabecera();
	private PreparedStatement ps; 
	private ResultSet rs;
	private Connection bd;  

	public ArrayList<HistorialAplicativoCabecera> listar(){
		ArrayList<HistorialAplicativoCabecera> listHistorialAplicativoCabecera = new ArrayList<HistorialAplicativoCabecera>();
		String sql = "SELECT * FROM `V3Z_HISTORIAL _APLICATIVO_CABECERA`";

		try{
			con.conectar();
			bd = con.getConnection();
			ps = bd.prepareStatement(sql);
			rs = ps.executeQuery();
			// recibimos los resultados
			while(rs.next()){
				historialAplicativoCabecera = new HistorialAplicativoCabecera();
				historialAplicativoCabecera.setIdeFactura(rs.getInt(1));
				historialAplicativoCabecera.setIdeHistoria(rs.getInt(2));
				historialAplicativoCabecera.setEstadoRegistro(rs.getString(3).charAt(0));
				listHistorialAplicativoCabecera.add(historialAplicativoCabecera);
			}
			System.out.println("HistorialAplicativoCabeceraDAO Listar:CORRECTO");

		}catch(Exception e){
			System.out.println("HistorialAplicativoCabeceraDAO listar:ERROR");
			System.err.println(e);
		}finally{
			con.desconectar();
		}
		
		return listHistorialAplicativoCabecera;
	}

	// agregar
	public int add(HistorialAplicativoCabecera historialAplicativoCabecera){
		int state = 0;
		String sql = "INSERT INTO `V3Z_HISTORIAL _APLICATIVO_CABECERA` (`HisApliCabFacIde`, `HisApliCabIde`, `HisApliCabEstReg`) VALUES (?, ?, ?);";
		try{
			con.conectar();
			bd = con.getConnection();
			ps = bd.prepareStatement(sql);
			// llenamos los datos
			ps.setString(1,historialAplicativoCabecera.getIdeFactura()+"");
			ps.setString(2,historialAplicativoCabecera.getIdeHistoria()+"");
			ps.setString(3, "A");
			state = ps.executeUpdate();
			System.out.println("HistorialAplicativoCabeceraDAO Add: CORRECTO");

		}catch(SQLException e){
			System.out.println("HistorialAplicativoCabeceraDAO add: ERROR"); 
			System.out.println(e);
		}finally{
			con.desconectar();
		}
		return state;
	}

	public int modificar(HistorialAplicativoCabecera historialAplicativoCabecera){
		int state = 0;
		String sql = "UPDATE `V3Z_HISTORIAL _APLICATIVO_CABECERA` SET `HisApliCabIde` = ?, `HisApliCabEstReg` = ? WHERE `V3Z_HISTORIAL _APLICATIVO_CABECERA`.`HisApliCabFacIde` = ?;";
		try{
			con.conectar();
			bd = con.getConnection();
			ps = bd.prepareStatement(sql);
			// llenamos datos
			ps.setString(1,historialAplicativoCabecera.getIdeHistoria()+"");
			ps.setString(2,historialAplicativoCabecera.getEstadoRegistro()+"");
			ps.setString(3,historialAplicativoCabecera.getIdeFactura()+"");
			state = ps.executeUpdate(); 
			System.out.println("HistorialAplicativoCabeceraDAO ModificarInter: CORRECTO");
		}catch (SQLException e){
			System.out.println("HistorialAplicativoCabeceraDAO ModificarInter: ERROR");
			System.out.println(e);
		}finally{
			con.desconectar();
		}

		return state;
	}

}
