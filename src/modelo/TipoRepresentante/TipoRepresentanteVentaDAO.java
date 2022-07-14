package src.modelo.TipoRepresentante;

import java.sql.Connection;
import java.sql.*;
import java.util.*;

import src.modelo.Conexion;
import src.modelo.DAO;

public class TipoRepresentanteVentaDAO extends DAO<TipoRepresentanteVenta> {

	public Conexion con = new Conexion();
	private PreparedStatement ps;
	private ResultSet rs;
	private Connection bd;

	// constructor
	public TipoRepresentanteVentaDAO() {
		super();
	}

	// listar
	public ArrayList<TipoRepresentanteVenta> listar() {
		ArrayList<TipoRepresentanteVenta> listTipRepVenta = new ArrayList<TipoRepresentanteVenta>();
		String sql = "SELECT * FROM `GZZ_TIPO_REPRESENTANTE_VENTAS`";

		try {
			con.conectar();
			bd = con.getConnection();
			ps = bd.prepareStatement(sql);
			rs = ps.executeQuery();

			// recibimos los resultados
			while (rs.next()) {
				classNormal = new TipoRepresentanteVenta();
				classNormal.setIde(rs.getInt(1));
				classNormal.setDescTipoRepVenta(rs.getString(2));
				classNormal.setEstadoRegistro(rs.getString(3).charAt(0));
				listTipRepVenta.add(classNormal);
			}
			System.out.println("TipoRepresentanteVentaDAO Listar:CORRECTO");

		} catch (Exception e) {
			System.out.println("TipoRepresentanteVentaDAO listar:ERROR");
			System.err.println(e);
		} finally {
			con.desconectar();
		}

		return listTipRepVenta;
	}

	// agregar
	public int add(TipoRepresentanteVenta tipRepVenta) {
		int state = 0;
		String sql = "INSERT INTO `GZZ_TIPO_REPRESENTANTE_VENTAS` (`TipRepVenIde`, `TipRepVenDes`, `TipRepVenEstReg`) VALUES (?, ?, ?);";
		try {
			con.conectar();
			bd = con.getConnection();
			ps = bd.prepareStatement(sql);
			
			// llenamos los datos
			ps.setString(1, tipRepVenta.getIde() + "");
			ps.setString(2, tipRepVenta.getDescTipoRepVenta() + "");
			ps.setString(3, "A");

			state = ps.executeUpdate();
			System.out.println("TipoRepresentanteVentaDAO Add: CORRECTO");

		} catch (SQLException e) {
			System.out.println("TipoRepresentanteVentaDAO add: ERROR");
			System.out.println(e);
		} finally {
			con.desconectar();
		}
		return state;
	}

	// modificar
	public int modificar(TipoRepresentanteVenta tipRepVenta) {
		int state = 0;
		String sql = "UPDATE `GZZ_TIPO_REPRESENTANTE_VENTAS` SET `TipRepVenDes` = ?, `TipRepVenEstReg` = ? WHERE `GZZ_TIPO_REPRESENTANTE_VENTAS`.`TipRepVenIde` = ?;";
		try {
			con.conectar();
			bd = con.getConnection();
			ps = bd.prepareStatement(sql);

			// llenamos datos
			ps.setString(1, tipRepVenta.getDescTipoRepVenta() + "");
			ps.setString(2, tipRepVenta.getEstadoRegistro() + "");
			ps.setString(3, tipRepVenta.getIde() + "");

			state = ps.executeUpdate();
			System.out.println("TipoRepresentanteVentaDAO ModificarInter: CORRECTO");
		} catch (SQLException e) {
			System.out.println("TipoRepresentanteVentaDAO ModificarInter: ERROR");
			System.out.println(e);
		} finally {
			con.desconectar();
		}

		return state;
	}

}
