package src.modelo.ProductoDetalle;

import java.sql.Connection;
import java.sql.*;
import java.util.*;
import src.modelo.Conexion;
import src.modelo.DAO;

public class ProductoDetalleDAO extends DAO<ProductoDetalle> {

    private Conexion con = new Conexion();
    private PreparedStatement ps;
    private ResultSet rs;
    private Connection bd;

    // constructor
    public ProductoDetalleDAO() {
        super();
    }

    // listar
    public ArrayList<ProductoDetalle> listar() {
        ArrayList<ProductoDetalle> listCatCli = new ArrayList<ProductoDetalle>();
        String sql = "SELECT * FROM `V1T_PRODUCTO_DETALLE`";

        try {
            con.conectar();
            bd = con.getConnection();
            ps = bd.prepareStatement(sql);
            rs = ps.executeQuery();

            // recibimos los resultados
            while (rs.next()) {
                classNormal = new ProductoDetalle();

                classNormal.setIde(rs.getInt(1));
                classNormal.setFabricante(rs.getString(2));
                classNormal.setDescripcion(rs.getString(3));
                classNormal.setPrecio(rs.getDouble(4));
                classNormal.setExistencia(rs.getInt(5));
                classNormal.setClaseABC(rs.getString(6));
                classNormal.setUnidadMedida(rs.getString(7));
                classNormal.setStockActual(rs.getInt(8));
                classNormal.setStockMinimo(rs.getInt(9));
                classNormal.setStockMaximo(rs.getInt(10));

                classNormal.setEstadoRegistro(rs.getString(11).charAt(0));

                listCatCli.add(classNormal);
            }
            System.out.println("ProductoDetalleDAO Listar:CORRECTO");

        } catch (Exception e) {
            System.out.println("ProductoDetalleDAO listar:ERROR");
            System.err.println(e);
        } finally {
            con.desconectar();
        }

        return listCatCli;
    }

    // agregar
    public int add(ProductoDetalle ofiDet) {
        int state = 0;
        String sql = "INSERT INTO `V1T_PRODUCTO_DETALLE` (`ProDetIde`, `ProDetFab`, `ProDetDes`, `ProDetPre`, `ProDetExi`, `ProDetClaABC`, `ProDetUni`, `ProDetStoAct`, `ProDetStoMin`, `ProDetStoMax`, `ProDetEstReg`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        try {
            con.conectar();
            bd = con.getConnection();
            ps = bd.prepareStatement(sql);

            // llenamos los datos

            ps.setString(1, ofiDet.getIde() + "");
            ps.setString(2, ofiDet.getFabricante());
            ps.setString(3, ofiDet.getDescripcion());
            ps.setString(4, ofiDet.getPrecio() + "");
            ps.setString(5, ofiDet.getExistencia() + "");
            ps.setString(6, ofiDet.getClaseABC() + "");
            ps.setString(7, ofiDet.getUnidadMedida() + "");
            ps.setString(8, ofiDet.getStockActual() + "");
            ps.setString(9, ofiDet.getStockMinimo() + "");
            ps.setString(10, ofiDet.getStockMaximo() + "");

            ps.setString(11, ofiDet.getEstadoRegistro() + "");

            state = ps.executeUpdate();
            System.out.println("ProductoDetalleDao Add: CORRECTO");

        } catch (SQLException e) {
            System.out.println("ProductoDetalleDao add: ERROR");
            System.out.println(e);
        } finally {
            con.desconectar();
        }
        return state;
    }

    // modificar
    public int modificar(ProductoDetalle ofiDet) {
        int state = 0;
        String sql = "UPDATE `V1T_PRODUCTO_DETALLE` SET `ProDetFab` = ?, `ProDetDes` = ?, `ProDetPre` = ?, `ProDetExi` = ?, `ProDetClaABC` = ?, `ProDetUni` = ?, `ProDetStoAct` = ?, `ProDetStoMin` = ?, `ProDetStoMax` = ?, `ProDetEstReg` = ? WHERE `V1T_PRODUCTO_DETALLE`.`ProDetIde` = ?;";
        try {
            con.conectar();
            bd = con.getConnection();
            ps = bd.prepareStatement(sql);

            // llenamos datos
            ps.setString(1, ofiDet.getFabricante());
            ps.setString(2, ofiDet.getDescripcion());
            ps.setString(3, ofiDet.getPrecio() + "");
            ps.setString(4, ofiDet.getExistencia() + "");
            ps.setString(5, ofiDet.getClaseABC() + "");
            ps.setString(6, ofiDet.getUnidadMedida() + "");
            ps.setString(7, ofiDet.getStockActual() + "");
            ps.setString(8, ofiDet.getStockMinimo() + "");
            ps.setString(9, ofiDet.getStockMaximo() + "");
            ps.setString(10, ofiDet.getEstadoRegistro() + "");

            ps.setString(11, ofiDet.getIde() + "");

            state = ps.executeUpdate();
            System.out.println("ProductoDetalleDao ModificarInter: CORRECTO");
        } catch (SQLException e) {
            System.out.println("ProductoDetalleDao ModificarInter: ERROR");
            System.out.println(e);
        } finally {
            con.desconectar();
        }

        return state;
    }

}
