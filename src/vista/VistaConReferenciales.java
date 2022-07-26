package src.vista;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;

import java.sql.Connection;
import java.sql.*;
import src.modelo.Conexion;

public class VistaConReferenciales {
    public JPanel content;

    // paneles
    public JPanel tabla1Panel = new JPanel(new BorderLayout());
    public JPanel tabla2Panel = new JPanel(new BorderLayout());
    public JPanel tabla3Panel = new JPanel(new BorderLayout());

    // conexion
    private Conexion con = new Conexion();
    private PreparedStatement ps;
    private ResultSet rs;
    private Connection bd;

    public JPanel getContent() {
        content = new JPanel(new BorderLayout());

        JPanel panelContenido = createTabla1Panel();

        content.add(panelContenido, BorderLayout.CENTER);
        return content;
    }

    public JPanel createTabla1Panel() {
        // tabla

        int count = 8;
        String cols[] = { "Nombre", "Edad", "Cargo", "Sueldo", "Rol", "TipoRepresentante", "CiudadOficina",
                "ObjetivoOficina" };
        int colsType[] = { 0, 1, 0, 1, 0, 0, 0, 1 };
        String tableName = "RepreConReferenciales"; // nombre de la vista
        String name = "V1M_REPRESENTANTE_VENTAS_DETALLE_CON_REFERENCIALES"; // nombre de la tabla

        JPanel tablaPanelPanel = createTableContent(count, cols, colsType, tableName, name);
        return tablaPanelPanel;
    }

    public JPanel createTableContent(int colsCount, String cols[], int colsType[], String tableName, String name) {
        // colsType=(0:String, 1:Integer)

        JPanel tableContent = new JPanel(new BorderLayout());
        JLabel tableNameLabel = new JLabel(name);

        String sql = "SELECT * FROM `" + tableName + "`";

        try {
            con.conectar();
            bd = con.getConnection();
            ps = bd.prepareStatement(sql);
            rs = ps.executeQuery();

            Object[][] objetos = new Object[30][colsCount];

            // resultado
            int i = 0;
            while (rs.next()) {// para cada objeto
                for (int j = 0; j < colsCount; j++)// para cada columna
                    objetos[i][j] = (colsType[j] == 1) ? rs.getInt(j + 1) : rs.getString(j + 1);
                i++;
            }

            JTable tabla = new JTable(objetos, cols);
            JScrollPane barra = new JScrollPane(tabla);

            // agregando componentes
            tableContent.add(tableNameLabel, BorderLayout.NORTH);
            tableContent.add(barra);

            System.out.println("Mostrando 3 tablas :CORRECTO");
        } catch (Exception ex) {
            System.out.println("Mostrando 3 tablas :ERROR");
            System.err.println(ex);
        } finally {
            con.desconectar();
        }

        return tableContent;
    }

    // metodo auxiliar (ni entiendo para que sirve xd)
    public void createPanelWidth(JPanel panel, boolean n, boolean s, boolean e, boolean w) {
        if (n)
            panel.add(new JLabel("\n"), BorderLayout.NORTH);
        if (s)
            panel.add(new JLabel("\n"), BorderLayout.SOUTH);
        if (e)
            panel.add(new JLabel("   "), BorderLayout.EAST);
        if (w)
            panel.add(new JLabel("   "), BorderLayout.WEST);
    }

    public void centrarCeldas(JTable tabla) {
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < tabla.getColumnCount(); i++) {
            tabla.getColumnModel().getColumn(i).setCellRenderer(tcr);
        }
    }

    public void showNewFrame(JScrollPane scroll) {
        JFrame newFrame = new JFrame("3Tablas");
        newFrame.setLocationRelativeTo(null);
        newFrame.setLayout(new FlowLayout());
        newFrame.setVisible(true);
        newFrame.setSize(500, 400);

        newFrame.add(scroll);
    }
}
