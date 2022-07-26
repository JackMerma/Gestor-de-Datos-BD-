package src.vista;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import java.sql.Connection;
import java.sql.*;
import src.modelo.Conexion;

public class Vista3Tablas {
	public JPanel content;

	//paneles
	public JPanel tabla1Panel = new JPanel(new BorderLayout());
	public JPanel tabla2Panel = new JPanel(new BorderLayout());
	public JPanel tabla3Panel = new JPanel(new BorderLayout());

	//conexion
	private Conexion con = new Conexion();
	private PreparedStatement ps; 
	private ResultSet rs;
	private Connection bd;  

	public JPanel getContent() {
		content = new JPanel(new GridLayout(3,1,5,5));

		createTabla1Panel();
		createTabla2Panel();
		createTabla3Panel();

		content.add(tabla1Panel);
		content.add(tabla2Panel);
		content.add(tabla3Panel);
		return content;
	}

	public void createTabla1Panel(){
		// tabla de CARGO
		int count = 4;
		String cols[] = {"Ide", "Descripcion", "Sueldo", "Estado Registro"};
		int colsType[] = {1, 0, 1, 0};
		String tableName = "GZZ_CARGO";
		String name = "CARGO";

		JPanel tablaPanelPanel = createTableContent(count, cols, colsType, tableName, name);
		tabla1Panel.add(tablaPanelPanel);
	}

	public void createTabla2Panel(){
		// tabla de TIPO REPRESENTANTE VENTAS
		int count = 3;
		String cols[] = {"IdeRepresentante", "Descripcion", "Estado Registro"};
		int colsType[] = {1, 0, 0};
		String tableName = "GZZ_TIPO_REPRESENTANTE_VENTAS";
		String name = "TIPO REPRESENTANTE VENTAS";

		JPanel tablaPanelPanel = createTableContent(count, cols, colsType, tableName, name);
		tabla2Panel.add(tablaPanelPanel);
	}

	public void createTabla3Panel(){
		// tabla de CATEGORIA CLIENTE
		int count = 3;
		String cols[] = {"Ide", "Limite Credito", "Estado Registro"};
		int colsType[] = {1, 1, 0};
		String tableName = "GZZ_CATEGORIA_CLIENTE";
		String name = "CATEGORIA CLIENTE";

		JPanel tablaPanelPanel = createTableContent(count, cols, colsType, tableName, name);
		tabla3Panel.add(tablaPanelPanel);
	}

	public JPanel createTableContent(int colsCount, String cols[], int colsType[], String tableName, String name){
				//colsType=(0:String, 1:Integer)

				JPanel tableContent = new JPanel(new BorderLayout());
				JLabel tableNameLabel = new JLabel(name);

				String sql = "SELECT * FROM `" + tableName +"`";

				try{
					con.conectar();
					bd = con.getConnection();
					ps = bd.prepareStatement(sql);
					rs = ps.executeQuery();

					Object[][] objetos = new Object[10][colsCount];

					//resultado
					int i = 0;
					while(rs.next()){//para cada objeto
						for(int j = 0; j < colsCount; j++)//para cada columna
							objetos[i][j] = (colsType[j]==1)? rs.getInt(j+1): rs.getString(j+1);
						i++;
					}

					JTable tabla = new JTable(objetos, cols);
					JScrollPane barra = new JScrollPane(tabla);

					//agregando componentes
					tableContent.add(tableNameLabel, BorderLayout.NORTH);
					tableContent.add(barra);

					System.out.println("Mostrando 3 tablas :CORRECTO");
				}catch(Exception ex){
					System.out.println("Mostrando 3 tablas :ERROR");
					System.err.println(ex);
				}finally{
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

	public void showNewFrame(JScrollPane scroll){
		JFrame newFrame = new JFrame("3Tablas");
		newFrame.setLocationRelativeTo(null);
		newFrame.setLayout(new FlowLayout());
		newFrame.setVisible(true);
		newFrame.setSize(500,400);

		newFrame.add(scroll);
	}
}
