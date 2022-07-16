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
		String sql = "INSERT INTO `V1M_REPRESENTANTE_VENTAS_DETALLE` (`RepVenDetIde`, `RepVenDetOfiIde`, `RepVenCabCarIde`, `RepVenDetRolRegIde`, `RepVenDetTipIde`, `RepVenDetUsuRegDetIde`, `RepVenDetNom`, `RepVenDetEdad`, `RepVenDetCon`, `RepVenDetDetObjRep`, `RepVenDetEstReg`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

		try {
			con.conectar();
			bd = con.getConnection();
			ps = bd.prepareStatement(sql);

			// llenamos los datos
			ps.setString(1, repVen.getIde() + "");
			ps.setString(2, repVen.getOficinaIde() + "");
			ps.setString(3, repVen.getCargoIde() + "");
			

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
