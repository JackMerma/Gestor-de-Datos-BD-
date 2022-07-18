package src.modelo.ClienteCabecera;

import java.sql.Connection;
import java.sql.*;
import java.util.*;

import src.modelo.*;

public class ClienteCabeceraDAO extends DAO<ClienteCabecera> {

	public Conexion con = new Conexion();
	public ClienteCabecera clienteCabecera = new ClienteCabecera();
	private PreparedStatement ps; 
	private ResultSet rs;
	private Connection bd;  

	// constructor
	public ClienteCabeceraDAO() {
		super();
	}

	public ArrayList<ClienteCabecera> listar(){
		ArrayList<ClienteCabecera> listClienteCabecera = new ArrayList<ClienteCabecera>();
		String sql = "SELECT * FROM `V1M_CLIENTE_CABECERA`";

		try{
			con.conectar();
			bd = con.getConnection();
			ps = bd.prepareStatement(sql);
			rs = ps.executeQuery();
			// recibimos los resultados
			while(rs.next()){
				clienteCabecera = new ClienteCabecera();
				clienteCabecera.setIdeFacturaCliente(rs.getInt(1));
				clienteCabecera.setIdeCliente(rs.getInt(2));
				clienteCabecera.setEstadoRegistro(rs.getString(3).charAt(0));
				listClienteCabecera.add(clienteCabecera);
			}
			System.out.println("ClienteCabeceraDAO Listar:CORRECTO");

		}catch(Exception e){
			System.out.println("ClienteCabeceraDAO listar:ERROR");
			System.err.println(e);
		}finally{
			con.desconectar();
		}
		
		return listClienteCabecera;
	}

	// agregar
	public int add(ClienteCabecera clienteCabecera){
		int state = 0;
		String sql = "INSERT INTO `V1M_CLIENTE_CABECERA` (`CliCabFacIde`, `CliCabCliIde`, `CliCabEstReg`) VALUES (?, ?, ?);";
		try{
			con.conectar();
			bd = con.getConnection();
			ps = bd.prepareStatement(sql);
			// llenamos los datos
			ps.setString(1,clienteCabecera.getIdeFacturaCliente()+"");
			ps.setString(2,clienteCabecera.getIdeCliente()+"");
			ps.setString(3, "A");
			state = ps.executeUpdate();
			System.out.println("ClienteCabeceraDAO Add: CORRECTO");

		}catch(SQLException e){
			System.out.println("ClienteCabeceraDAO add: ERROR"); 
			System.out.println(e);
		}finally{
			con.desconectar();
		}
		return state;
	}

	public int modificar(ClienteCabecera clienteCabecera){
		int state = 0;
		String sql = "UPDATE `V1M_CLIENTE_CABECERA` SET `CliCabCliIde` = ?, `CliCabEstReg` = ? WHERE `V1M_CLIENTE_CABECERA`.`CliCabFacIde` = ?;";
		try{
			con.conectar();
			bd = con.getConnection();
			ps = bd.prepareStatement(sql);
			// llenamos datos
			ps.setString(1,clienteCabecera.getIdeCliente()+"");
			ps.setString(2,clienteCabecera.getEstadoRegistro()+"");
			ps.setString(3,clienteCabecera.getIdeFacturaCliente()+"");
			state = ps.executeUpdate(); 
			System.out.println("ClienteCabeceraDAO ModificarInter: CORRECTO");
		}catch (SQLException e){
			System.out.println("ClienteCabeceraDAO ModificarInter: ERROR");
			System.out.println(e);
		}finally{
			con.desconectar();
		}

		return state;
	}

}
