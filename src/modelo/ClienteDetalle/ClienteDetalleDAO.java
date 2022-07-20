package src.modelo.ClienteDetalle;

import java.sql.Connection;
import java.sql.*;
import java.util.*;

import src.modelo.*;

public class ClienteDetalleDAO extends DAO<ClienteDetalle> {

	public Conexion con = new Conexion();
	public ClienteDetalle clienteDetalle = new ClienteDetalle();
	private PreparedStatement ps; 
	private ResultSet rs;
	private Connection bd;  

	// constructor
	public ClienteDetalleDAO() {
		super();
	}

	public ArrayList<ClienteDetalle> listar(){
		ArrayList<ClienteDetalle> listClienteDetalle = new ArrayList<ClienteDetalle>();
		String sql = "SELECT * FROM `V1M_CLIENTE_DETALLE`";

		try{
			con.conectar();
			bd = con.getConnection();
			ps = bd.prepareStatement(sql);
			rs = ps.executeQuery();
			// recibimos los resultados
			while(rs.next()){
				clienteDetalle = new ClienteDetalle();

				clienteDetalle.setIde(rs.getInt(1));
				clienteDetalle.setIdeCategoria(rs.getInt(2));
				clienteDetalle.setEmpDescripcion(rs.getString(3));
				clienteDetalle.setNumEmpleado(rs.getString(4));
				clienteDetalle.setCredito((rs.getInt(5)));
				clienteDetalle.setDepartamento(rs.getString(6));
				clienteDetalle.setNombre(rs.getString(7));
				clienteDetalle.setApellidoPaterno(rs.getString(8));
				clienteDetalle.setApellidoMaterno(rs.getString(9));
				clienteDetalle.setDireccion(rs.getString(10));
				clienteDetalle.setTelefono(rs.getInt(11));
				clienteDetalle.setCorreo(rs.getString(12));
				clienteDetalle.setComportamiento(rs.getString(13));
				clienteDetalle.setPagoCuota(rs.getString(14));
				clienteDetalle.setEstadoRegistro(rs.getString(15).charAt(0));

				listClienteDetalle.add(clienteDetalle);
			}
			System.out.println("ClienteDetalleDAO Listar:CORRECTO");

		}catch(Exception e){
			System.out.println("ClienteDetalleDAO listar:ERROR");
			System.err.println(e);
		}finally{
			con.desconectar();
		}
		
		return listClienteDetalle;
	}

	// agregar
	public int add(ClienteDetalle clienteDetalle){
		int state = 0;
		String sql = "INSERT INTO `V1M_CLIENTE_DETALLE` (`CliDetIde`, `CliDetCatCliIde`, `CliDetEmp`, `CliDetRep`, `CliDetPagCuo`, `CliDetCre`, `CliDetDep`, `CliDetNom`, `CliDetCliCom`, `CliDetApePat`, `CliDetApeMat`, `CliDetDir`, `CliDetTel`, `CliDetCor`, `CliCatEstReg`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
		try{
			con.conectar();
			bd = con.getConnection();
			ps = bd.prepareStatement(sql);
			// llenamos los datos
			ps.setString(1,clienteDetalle.getIde()+"");
			ps.setString(2,clienteDetalle.getIdeCategoria()+"");
			ps.setString(3,clienteDetalle.getEmpDescripcion()+"");
			ps.setString(4,clienteDetalle.getNumEmpleado()+"");
			ps.setString(5,clienteDetalle.getPagoCuota()+"");
			ps.setString(6,clienteDetalle.getCredito()+"");
			ps.setString(7,clienteDetalle.getDepartamento()+"");
			ps.setString(8,clienteDetalle.getNombre()+"");
			ps.setString(9,clienteDetalle.getComportamiento()+"");
			ps.setString(10,clienteDetalle.getApellidoPaterno()+"");
			ps.setString(11,clienteDetalle.getApellidoMaterno()+"");
			ps.setString(12,clienteDetalle.getDireccion()+"");
			ps.setString(13,clienteDetalle.getTelefono()+"");
			ps.setString(14,clienteDetalle.getCorreo()+"");
			ps.setString(15, "A");
			state = ps.executeUpdate();
			System.out.println("ClienteDetalleDAO Add: CORRECTO");

		}catch(SQLException e){
			System.out.println("ClienteDetalleDAO add: ERROR"); 
			System.out.println(e);
		}finally{
			con.desconectar();
		}
		return state;
	}

	public int modificar(ClienteDetalle clienteDetalle){
		int state = 0;
		String sql = "UPDATE `V1M_CLIENTE_DETALLE` SET `CliDetCatCliIde` = ?, `CliDetEmp` = ?, `CliDetRep` = ?, `CliDetPagCuo` = ?, `CliDetCre` = ?, `CliDetDep` = ?, `CliDetNom` = ?, `CliDetCliCom` = ?, `CliDetApePat` = ?, `CliDetApeMat` = ?, `CliDetDir` = ?, `CliDetTel` = ?, `CliDetCor` = ?, `CliCatEstReg` = ? WHERE `V1M_CLIENTE_DETALLE`.`CliDetIde` = ?;";
		try{
			con.conectar();
			bd = con.getConnection();
			ps = bd.prepareStatement(sql);
			// llenamos datos
			ps.setString(1,clienteDetalle.getIdeCategoria()+"");
			ps.setString(2,clienteDetalle.getEmpDescripcion()+"");
			ps.setString(3,clienteDetalle.getNumEmpleado()+"");
			ps.setString(4,clienteDetalle.getPagoCuota()+"");
			ps.setString(5,clienteDetalle.getCredito()+"");
			ps.setString(6,clienteDetalle.getDepartamento()+"");
			ps.setString(7,clienteDetalle.getNombre()+"");
			ps.setString(8,clienteDetalle.getComportamiento()+"");
			ps.setString(9,clienteDetalle.getApellidoPaterno()+"");
			ps.setString(10,clienteDetalle.getApellidoMaterno()+"");
			ps.setString(11,clienteDetalle.getDireccion()+"");
			ps.setString(12,clienteDetalle.getTelefono()+"");
			ps.setString(13,clienteDetalle.getCorreo()+"");
			ps.setString(14,clienteDetalle.getEstadoRegistro()+"");
			ps.setString(15,clienteDetalle.getIde()+"");
			state = ps.executeUpdate(); 
			System.out.println("ClienteDetalleDAO ModificarInter: CORRECTO");
		}catch (SQLException e){
			System.out.println("ClienteDetalleDAO ModificarInter: ERROR");
			System.out.println(e);
		}finally{
			con.desconectar();
		}

		return state;
	}

}
