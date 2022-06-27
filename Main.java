import java.sql.DriverManager;
import java.sql.Connection;
import src.*;

public class Main {
	public static void main(String [] args){
		Conexion con = new Conexion ("73123732", "Datos_Personales", "root");
		con.conectar();
	}
}
