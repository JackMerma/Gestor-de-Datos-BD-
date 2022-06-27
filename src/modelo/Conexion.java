package src.modelo;

import java.sql.DriverManager;
import java.sql.Connection;

public class Conexion {
	private String password;
	private String dataBaseName;
	private String userName;
	private Connection con;

	public Conexion(String p, String dbn, String un){
		this.password = p;
		this.dataBaseName = dbn;
		this.userName = un;
	}

	public void conectar(){
		System.out.println("Conectando a " + dataBaseName + " ...");

		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + dataBaseName, userName, password);
			System.out.println("Base de datos conectada");
		}catch(Exception e){
			System.out.println("No se pudo conectar a la base de datos");
		}
	}
}
