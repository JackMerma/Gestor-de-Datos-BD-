package src.modelo.RepresentanteVentasCabecera;

import java.sql.Connection;
import java.sql.*;
import java.util.*;

import src.modelo.Conexion;
import src.modelo.DAO;

public class RepresentanteVentasCabeceraDAO extends DAO<RepresentanteVentasCabecera> {

	private Conexion con = new Conexion();
	private PreparedStatement ps;
	private ResultSet rs;
	private Connection bd;

	// constructor
	public RepresentanteVentasCabeceraDAO() {
		super();
	}

	// Listar
	public ArrayList<RepresentanteVentasCabecera> listar() {
		ArrayList<RepresentanteVentasCabecera> lista = new ArrayList<RepresentanteVentasCabecera>();
		String sql = "SELECT * FROM `V1M_REPRESENTANTE_VENTAS_CABECERA`";

		try {
			con.conectar();
			bd = con.getConnection();
			ps = bd.prepareStatement(sql);
			rs = ps.executeQuery();
			// recibimos los resultados
			while (rs.next()) {
				classNormal = new RepresentanteVentasCabecera();

				classNormal.setFacIde(rs.getInt(1));
				classNormal.setRepIde(rs.getInt(2));
				classNormal.setEstadoRegistro(rs.getString(3).charAt(0));

				lista.add(classNormal);
			}
			System.out.println("RepresentanteCabeceraDAO Listar:CORRECTO");

		} catch (Exception e) {
			System.out.println("RepresentanteCabeceraDAO listar:ERROR");
			System.err.println(e);
		} finally {
			con.desconectar();
		}

		return lista;
	}

	// agregar
	public int add(RepresentanteVentasCabecera repVen) {
		int state = 0;
		String sql = "INSERT INTO `V1M_REPRESENTANTE_VENTAS_CABECERA` (`RepVenCabFacIde`, `RepVenCabRepIde`, `RepVenCabEstReg`) VALUES (?, ?, ?);";

		try {
			con.conectar();
			bd = con.getConnection();
			ps = bd.prepareStatement(sql);

			// llenamos los datos
			ps.setString(1, repVen.getFacIde() + "");
			ps.setString(2, repVen.getRepIde() + "");
			ps.setString(3, "A");

			state = ps.executeUpdate();
			System.out.println("RepresentanteCabeceraDAO Add: CORRECTO");

		} catch (SQLException e) {
			System.out.println("RepresentanteCabeceraDAO add: ERROR");
			System.out.println(e);
		} finally {
			con.desconectar();
		}
		return state;
	}

	// modificar
	public int modificar(RepresentanteVentasCabecera repVenta) {
		int state = 0;

		// create the sentence for update every values with WHERE is the id
		String sql = "UPDATE `V1M_REPRESENTANTE_VENTAS_CABECERA` SET `RepVenCabEstReg` = ? WHERE `V1M_REPRESENTANTE_VENTAS_CABECERA`.`RepVenCabFacIde` = ? AND `V1M_REPRESENTANTE_VENTAS_CABECERA`.`RepVenCabRepIde` = ?;";

		try {
			con.conectar();
			bd = con.getConnection();
			ps = bd.prepareStatement(sql);

			// llenamos datos
			ps.setString(1, repVenta.getEstadoRegistro() + "");
			ps.setString(2, repVenta.getFacIde() + "");
			ps.setString(3, repVenta.getRepIde() + "");

			state = ps.executeUpdate();
			System.out.println("RepresentanteCabeceraDAO ModificarInter: CORRECTO");

		} catch (SQLException e) {
			System.out.println("RepresentanteCabeceraDAO ModificarInter: ERROR");
			System.out.println(e);
		} finally {
			con.desconectar();
		}

		return state;
	}

}
