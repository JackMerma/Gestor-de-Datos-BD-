package src.modelo.ProductoCabecera;

import java.sql.Connection;
import java.sql.*;
import java.util.*;
import src.modelo.Conexion;
import src.modelo.DAO;

public class ProductoCabeceraDAO extends DAO<ProductoCabecera> {

    private Conexion con = new Conexion();
    private PreparedStatement ps;
    private ResultSet rs;
    private Connection bd;

    // constructor
    public ProductoCabeceraDAO() {
        super();
    }

    // Listar
    public ArrayList<ProductoCabecera> listar() {
        ArrayList<ProductoCabecera> lista = new ArrayList<ProductoCabecera>();
        String sql = "SELECT * FROM `V1Z_PRODUCTO_CABECERA`";

        try {
            con.conectar();
            bd = con.getConnection();
            ps = bd.prepareStatement(sql);
            rs = ps.executeQuery();
            // recibimos los resultados
            while (rs.next()) {
                classNormal = new ProductoCabecera();

                classNormal.setFacturaIde(rs.getInt(1));
                classNormal.setProductoIde(rs.getInt(2));
                classNormal.setCantidad(rs.getInt(3));
                classNormal.setEstadoRegistro(rs.getString(4).charAt(0));

                lista.add(classNormal);
            }
            System.out.println("ProductoCabeceraDAO Listar:CORRECTO");

        } catch (Exception e) {
            System.out.println("ProductoCabeceraDAO listar:ERROR");
            System.err.println(e);
        } finally {
            con.desconectar();
        }

        return lista;
    }

    // agregar
    public int add(ProductoCabecera proCabe) {
        int state = 0;
        String sql = "INSERT INTO `V1Z_PRODUCTO_CABECERA` (`ProCabFacIde`, `ProCabProIde`, `ProCabDetCan`, `ProCabEstReg`) VALUES (?, ?, ?, ?);";

        try {
            con.conectar();
            bd = con.getConnection();
            ps = bd.prepareStatement(sql);

            // llenamos los datos

            ps.setString(1, proCabe.getFacturaIde() + "");
            ps.setString(2, proCabe.getProductoIde() + "");
            ps.setString(3, proCabe.getCantidad() + "");
            ps.setString(4, "A");

            state = ps.executeUpdate();
            System.out.println("ProductoCabeceraDAO Add: CORRECTO");

        } catch (SQLException e) {
            System.out.println("ProductoCabeceraDAO add: ERROR");
            System.out.println(e);
        } finally {
            con.desconectar();
        }
        return state;
    }

    // modificar
    public int modificar(ProductoCabecera proCab) {
        int state = 0;
        String sql = "UPDATE `V1Z_PRODUCTO_CABECERA` SET `ProCabDetCan` = ?, `ProCabEstReg` = ? WHERE `V1Z_PRODUCTO_CABECERA`.`ProCabFacIde` = ? AND `V1Z_PRODUCTO_CABECERA`.`ProCabProIde` = ?;";

        try {
            con.conectar();
            bd = con.getConnection();
            ps = bd.prepareStatement(sql);

            // llenamos datos
            ps.setString(1, proCab.getCantidad() + "");
            ps.setString(2, proCab.getEstadoRegistro() + "");
            ps.setString(3, proCab.getFacturaIde() + "");
            ps.setString(4, proCab.getProductoIde() + "");

            state = ps.executeUpdate();
            System.out.println("ProductoCabeceraDAO ModificarInter: CORRECTO");

        } catch (SQLException e) {
            System.out.println("ProductoCabeceraDAO ModificarInter: ERROR");
            System.out.println(e);
        } finally {
            con.desconectar();
        }

        return state;
    }

}
