package src.modelo;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.*;
import java.util.*;

public class TipoRepresentanteVentaDAO {

	public Conexion con = new Conexion();
	public TipoRepresentanteVenta tipRepVenta = new TipoRepresentanteVenta();
	private PreparedStatement ps; 
	private ResultSet rs;
	private Connection bd;  

	public ArrayList<TipoRepresentanteVenta> listar(){
		ArrayList<TipoRepresentanteVenta> listTipRepVenta = new ArrayList<TipoRepresentanteVenta>();
		String sql = "SELECT * FROM `GZZ_ROL_REGISTRO`";

		try{
			con.conectar();
			bd = con.getConnection();
			ps = bd.prepareStatement(sql);
			rs = ps.executeQuery();
			// recibimos los resultados
			while(rs.next()){
				tipRepVenta = new TipoRepresentanteVenta();
				tipRepVenta.setIde(rs.getInt(1));
				tipRepVenta.setDescTipoRepVenta(rs.getString(2));
				tipRepVenta.setEstadoRegistro(rs.getString(3).charAt(0));
				listTipRepVenta.add(tipRepVenta);
			}
			System.out.println("TipoRepresentanteVentaDAO Listar:CORRECTO");

		}catch(Exception e){
			System.out.println("TipoRepresentanteVentaDAO listar:ERROR");
			System.err.println(e);
		}finally{
			con.desconectar();
		}
		
		return listTipRepVenta;
	}

	// agregar
	public int add(TipoRepresentanteVenta tipRepVenta){
		int state = 0;
		String sql = "INSERT INTO `GZZ_TIPO_REPRESENTANTE_VENTAS` (`TipRepVenIde`, `TipRepVenDes`, `TipRepVenEstReg`) VALUES (?, ?, ?);";
		try{
			con.conectar();
			bd = con.getConnection();
			ps = bd.prepareStatement(sql);
			// llenamos los datos
			ps.setString(1,tipRepVenta.getIde()+"");
			ps.setString(2,tipRepVenta.getDescTipoRepVenta()+"");
			ps.setString(3, "A");
			state = ps.executeUpdate();
			System.out.println("TipoRepresentanteVentaDAO Add: CORRECTO");

		}catch(SQLException e){
			System.out.println("TipoRepresentanteVentaDAO add: ERROR"); 
			System.out.println(e);
		}finally{
			con.desconectar();
		}
		return state;
	}

	public int modificar(Registro registro){
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
			System.out.println("RegistroDAO ModificarInter: CORRECTO");
		}catch (SQLException e){
			System.out.println("RegistroDAO ModificarInter: ERROR");
			System.out.println(e);
		}finally{
			con.desconectar();
		}

		return state;
	}

}


