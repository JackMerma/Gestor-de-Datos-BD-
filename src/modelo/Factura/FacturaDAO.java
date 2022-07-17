package src.modelo.Factura;

import java.sql.Connection;
import java.sql.*;
import java.util.*;

import src.modelo.Conexion;
import src.modelo.DAO;

public class FacturaDAO extends DAO<Factura> {

	private Conexion con = new Conexion();
	private PreparedStatement ps;
	private ResultSet rs;
	private Connection bd;

	// constructor
	public FacturaDAO() {
		super();
	}

	// listar
	public ArrayList<Factura> listar() {
		ArrayList<Factura> lista = new ArrayList<Factura>();
		String sql = "SELECT * FROM `V2T_FACTURA`";

		try {
			con.conectar();
			bd = con.getConnection();
			ps = bd.prepareStatement(sql);
			rs = ps.executeQuery();

			// recibimos los resultados
			while (rs.next()) {
				classNormal = new Factura();
				classNormal.setIde(rs.getInt(1));
				classNormal.setImporte(rs.getInt(2));
				classNormal.setAnio(rs.getString(3));
				classNormal.setMes(rs.getString(4));
				classNormal.setDia(rs.getString(5));
				classNormal.setEstReg(rs.getString(6).charAt(0));

				lista.add(classNormal);
			}
			System.out.println("FacturaDAO Listar:CORRECTO");

		} catch (Exception e) {
			System.out.println("FacturaDAO listar:ERROR");
			System.err.println(e);
		} finally {
			con.desconectar();
		}

		return lista;
	}

	// agregar
	public int add(Factura factura) {
		int state = 0;
		String sql = "INSERT INTO `V2T_FACTURA` (`FacIde`, `FacImp`, `FacAño`, `FacMes`, `FacDia`, `FacEstReg`) VALUES (?, ?, ?, ?, ?, ?);";
		try {
			con.conectar();
			bd = con.getConnection();
			ps = bd.prepareStatement(sql);

			// llenamos los datos

			ps.setString(1, factura.getIde() + "");
			ps.setString(2, factura.getImporte() + "");
			ps.setString(3, factura.getAnio() + "");
			ps.setString(4, factura.getMes() + "");
			ps.setString(5, factura.getDia() + "");
			ps.setString(6, "A");

			state = ps.executeUpdate();
			System.out.println("FacturaDao Add: CORRECTO");

		} catch (SQLException e) {
			System.out.println("FacturaDao add: ERROR");
			System.out.println(e);
		} finally {
			con.desconectar();
		}
		return state;
	}

	// modificar
	public int modificar(Factura ofiDet) {
		int state = 0;
		String sql = "UPDATE `V2T_FACTURA` SET `FacImp` = ?, `FacAño` = ?, `FacMes` = ?, `FacDia` = ?, `FacEstReg` = ? WHERE `V2T_FACTURA`.`FacIde` = ?;";
		try {
			con.conectar();
			bd = con.getConnection();
			ps = bd.prepareStatement(sql);

			// llenamos datos
			ps.setString(1, ofiDet.getImporte() + "");
			ps.setString(2, ofiDet.getAnio() + "");
			ps.setString(3, ofiDet.getMes() + "");
			ps.setString(4, ofiDet.getDia() + "");
			ps.setString(5, ofiDet.getEstReg() + "");
			ps.setString(6, ofiDet.getIde() + "");

			state = ps.executeUpdate();
			System.out.println("FacturaDao ModificarInter: CORRECTO");
		} catch (SQLException e) {
			System.out.println("FacturaDao ModificarInter: ERROR");
			System.out.println(e);
		} finally {
			con.desconectar();
		}

		return state;
	}

}
