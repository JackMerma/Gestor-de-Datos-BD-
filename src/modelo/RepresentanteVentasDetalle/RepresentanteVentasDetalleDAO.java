package src.modelo.RepresentanteVentasDetalle;

import java.sql.Connection;
import java.sql.*;
import java.util.*;

import src.modelo.Conexion;
import src.modelo.DAO;

public class RepresentanteVentasDetalleDAO extends DAO<RepresentanteVentasDetalle> {

	private Conexion con = new Conexion();
	private PreparedStatement ps;
	private ResultSet rs;
	private Connection bd;

	// constructor
	public RepresentanteVentasDetalleDAO() {
		super();
	}

	// Listar
	public ArrayList<RepresentanteVentasDetalle> listar() {
		ArrayList<RepresentanteVentasDetalle> lista = new ArrayList<RepresentanteVentasDetalle>();
		String sql = "SELECT * FROM `V1M_REPRESENTANTE_VENTAS_DETALLE`";

		try {
			con.conectar();
			bd = con.getConnection();
			ps = bd.prepareStatement(sql);
			rs = ps.executeQuery();
			// recibimos los resultados
			while (rs.next()) {
				classNormal = new RepresentanteVentasDetalle();

				classNormal.setIde(rs.getInt(1));

				classNormal.setOficinaIde(rs.getInt(2));
				classNormal.setCargoIde(rs.getInt(3));
				classNormal.setRolRegistroIde(rs.getInt(4));
				classNormal.setTipoRepresentanteIde(rs.getInt(5));
				classNormal.setUsuarioRegistradoIde(rs.getInt(6));

				classNormal.setNombre(rs.getString(7));
				classNormal.setEdad(rs.getInt(8));
				classNormal.setContrato(rs.getString(9));
				classNormal.setObjetivoRepresentante(rs.getString(10));

				classNormal.setEstadoRegistro(rs.getString(11).charAt(0));

				lista.add(classNormal);
			}
			System.out.println("RepresentanteDetalleDAO Listar:CORRECTO");

		} catch (Exception e) {
			System.out.println("RepresentanteDetalleDAO listar:ERROR");
			System.err.println(e);
		} finally {
			con.desconectar();
		}

		return lista;
	}

	// agregar
	public int add(RepresentanteVentasDetalle repVen) {
		int state = 0;
		String sql = "INSERT INTO `V1M_REPRESENTANTE_VENTAS_DETALLE` (`RepVenDetIde`, `RepVenDetOfiIde`, `RepVenCabCarIde`, `RepVenDetRolRegIde`, `RepVenDetTipIde`, `RepVenDetUsuRegDetIde`, `RepVenDetNom`, `RepVenDetEdad`, `RepVenDetCon`, `RepVenDetDetObjRep`, `RepVenDetEstReg`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

		try {
			con.conectar();
			bd = con.getConnection();
			ps = bd.prepareStatement(sql);

			// llenamos los datos
			ps.setString(1, repVen.getIde() + "");
			ps.setString(2, repVen.getOficinaIde() + "");
			ps.setString(3, repVen.getCargoIde() + "");
			ps.setString(4, repVen.getRolRegistroIde() + "");
			ps.setString(5, repVen.getTipoRepresentanteIde() + "");
			ps.setString(6, repVen.getUsuarioRegistradoIde() + "");
			ps.setString(7, repVen.getNombre());
			ps.setString(8, repVen.getEdad() + "");
			ps.setString(9, repVen.getContrato());
			ps.setString(10, repVen.getObjetivoRepresentante());
			ps.setString(11, "A");

			state = ps.executeUpdate();
			System.out.println("RepresentanteDetalleDAO Add: CORRECTO");

		} catch (SQLException e) {
			System.out.println("RepresentanteDetalleDAO add: ERROR");
			System.out.println(e);
		} finally {
			con.desconectar();
		}
		return state;
	}

	// modificar
	public int modificar(RepresentanteVentasDetalle cargo) {
		int state = 0;

		// create the sentence for update every values with WHERE is the id
		String sql = "UPDATE `V1M_REPRESENTANTE_VENTAS_DETALLE` SET `RepVenDetOfiIde` = ?, `RepVenCabCarIde` = ?, `RepVenDetRolRegIde` = ?, `RepVenDetTipIde` = ?, `RepVenDetUsuRegDetIde` = ?, `RepVenDetNom` = ?, `RepVenDetEdad` = ?, `RepVenDetCon` = ?, `RepVenDetDetObjRep` = ?, `RepVenDetEstReg` = ? WHERE `RepVenDetIde` = ?";

		// String sql = "UPDATE `GZZ_CARGO` SET `CarDes` = ?, `CarSue` = ?, `CatEstReg`
		// = ? WHERE `GZZ_CARGO`.`CarIde` = ?;";

		try {
			con.conectar();
			bd = con.getConnection();
			ps = bd.prepareStatement(sql);

			// llenamos datos
			ps.setString(1, cargo.getOficinaIde() + "");
			ps.setString(2, cargo.getCargoIde() + "");
			ps.setString(3, cargo.getRolRegistroIde() + "");
			ps.setString(4, cargo.getTipoRepresentanteIde() + "");
			ps.setString(5, cargo.getUsuarioRegistradoIde() + "");
			ps.setString(6, cargo.getNombre());
			ps.setString(7, cargo.getEdad() + "");
			ps.setString(8, cargo.getContrato());
			ps.setString(9, cargo.getObjetivoRepresentante());
			ps.setString(10, cargo.getEstadoRegistro() + "");
			ps.setString(11, cargo.getIde() + "");

			state = ps.executeUpdate();
			System.out.println("RepresentanteDetalleDAO ModificarInter: CORRECTO");

		} catch (SQLException e) {
			System.out.println("RepresentanteDetalleDAO ModificarInter: ERROR");
			System.out.println(e);
		} finally {
			con.desconectar();
		}

		return state;
	}

}
