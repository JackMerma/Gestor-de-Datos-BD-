package src.modelo.OficinaDetalle;
import java.sql.Connection;
import java.sql.*;
import java.util.*;

import src.modelo.Conexion;
import src.modelo.DAO;

public class OficinaDetalleDAO extends DAO<OficinaDetalle> {

	private Conexion con = new Conexion();
	private PreparedStatement ps; 
	private ResultSet rs;
	private Connection bd;  

	// constructor
	public OficinaDetalleDAO() {
		super();
	}

	// listar
	public ArrayList<OficinaDetalle> listar(){
		ArrayList<OficinaDetalle> listCatCli = new ArrayList<OficinaDetalle>();
		String sql = "SELECT * FROM `V1M_OFICINA_DETALLE`";

		try{
			con.conectar();
			bd = con.getConnection();
			ps = bd.prepareStatement(sql);
			rs = ps.executeQuery();

			// recibimos los resultados
			while(rs.next()){
				classNormal = new OficinaDetalle();
				classNormal.setOfiIde(rs.getInt(1));
				classNormal.setOfiCiu(rs.getString(2));
				classNormal.setOfiReg(rs.getString(3));
                classNormal.setOfiDir(rs.getString(4));
				classNormal.setOfiEmp(rs.getString(5));
				classNormal.setOfiObj(rs.getInt(6));
                classNormal.setOfiVen(rs.getString(7));
				classNormal.setOfiEstReg(rs.getString(8));
				
				listCatCli.add(classNormal);
			}
			System.out.println("OficinaDetalleDAO Listar:CORRECTO");

		}catch(Exception e){
			System.out.println("OficinaDetalleDAO listar:ERROR");
			System.err.println(e);
		}finally{
			con.desconectar();
		}
		
		return listCatCli;
	}

	// agregar
	public int add(OficinaDetalle ofiDet){
		int state = 0;
		String sql = "INSERT INTO `V1M_OFICINA_DETALLE` (`OfiIde`, `OfiCiu`, `OfiReg`, `OfiDir`, `OfiEmp`, `OfiObj`, `OfiVen`, `OfiEstReg`) VALUES VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
		try{
			con.conectar();
			bd = con.getConnection();
			ps = bd.prepareStatement(sql);

			// llenamos los datos
			ps.setString(1,ofiDet.getOfiIde()+"");
			ps.setString(2,ofiDet.getOfiCiu()+"");
			ps.setString(3,ofiDet.getOfiReg()+"");
			ps.setString(4,ofiDet.getOfiDir()+"");
			ps.setString(5,ofiDet.getOfiEmp()+"");
			ps.setString(6,ofiDet.getOfiObj()+"");
			ps.setString(7,ofiDet.getOfiVen()+"");
			ps.setString(8,ofiDet.getOfiEstReg()+"");

			state = ps.executeUpdate();
			System.out.println("oficinaDetalleDao Add: CORRECTO");

		}catch(SQLException e){
			System.out.println("oficinaDetalleDao add: ERROR"); 
			System.out.println(e);
		}finally{
			con.desconectar();
		}
		return state;
	}

	// modificar
	public int modificar(OficinaDetalle ofiDet){
		int state = 0;
		String sql = "UPDATE `V1M_OFICINA_DETALLE` SET `OfiCiu` = ?, `OfiReg` = ?, `OfiDir` = ?, `OfiEmp` = ?, `OfiObj` = ?, `OfiVen` = ?, `OfiEstReg` = ? WHERE `V1M_OFICINA_DETALLE`.`OfiIde` = ?";
		try{
			con.conectar();
			bd = con.getConnection();
			ps = bd.prepareStatement(sql);

			// llenamos datos
			ps.setString(1,ofiDet.getOfiCiu()+"");
			ps.setString(2,ofiDet.getOfiReg()+"");
			ps.setString(3,ofiDet.getOfiDir()+"");
			ps.setString(4,ofiDet.getOfiEmp()+"");
			ps.setString(5,ofiDet.getOfiObj()+"");
			ps.setString(6,ofiDet.getOfiVen()+"");
			ps.setString(7,ofiDet.getOfiEstReg()+"");
			ps.setString(8,ofiDet.getOfiIde()+"");

			state = ps.executeUpdate(); 
			System.out.println("oficinaDetalleDao ModificarInter: CORRECTO");
		}catch (SQLException e){
			System.out.println("oficinaDetalleDao ModificarInter: ERROR");
			System.out.println(e);
		}finally{
			con.desconectar();
		}

		return state;
	}
   

}


