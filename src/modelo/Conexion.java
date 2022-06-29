package src.modelo;

import java.sql.DriverManager;
import java.sql.*;

public class Conexion {
	private String url = "jdbc:mysql://0.tcp.sa.ngrok.io:17320/";
	private String password = "mypassword";
	private String dataBaseName = "BD_EMPRESA_DISTRIBUCION";
	private String userName = "root";
	private Connection con;

	public void conectar(){
		System.out.println("Conectando a " + dataBaseName + " ...");

		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url + dataBaseName, userName, password);
			System.out.println("Base de datos conectada");
		}catch(Exception e){
			System.out.println("No se pudo conectar a la base de datos");
		}
	}


	public void desconectar(){
		try{
			con.close();
			System.out.println("Conexion cerrada");

		}catch(SQLException e){
			System.out.println("No se pudo desconectar");
			e.printStackTrace();
		}
	}

	public Connection getConnection(){
		return con;
	}
}
