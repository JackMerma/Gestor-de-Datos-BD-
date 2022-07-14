package src.vista;

import java.util.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;

import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;

public class VistaCargoBack {
	public JPanel content;
	private String nombreTabla = "CARGO";

	// 3 paneles principales
	public JPanel addPanel = new JPanel(new BorderLayout());
	public JPanel viewPanel = new JPanel(new BorderLayout());
	public JPanel optionPanel = new JPanel(new BorderLayout());

	// add Panel
	public JTextField ide = new JTextField(10);
	public JTextField descripcion = new JTextField(10);
	public JTextField sueldo = new JTextField(10);
	public JTextField estaRegis = new JTextField("", 1);

	// view Panel
	public JTable tabla;
	public JScrollPane miBarra;
	public DefaultTableModel modelo;

	// option Panel
	public JButton adicionar = new JButton("Adicionar");
	public JButton modificar = new JButton("Modificar");
	public JButton eliminar = new JButton("Eliminar");
	public JButton cancelar = new JButton("Cancelar");
	public JButton inactivar = new JButton("Inactivar");
	public JButton reactivar = new JButton("Reactivar");
	public JButton actualizar = new JButton("Actualizar");
	public JButton salir = new JButton("Salir");


	public JPanel getContent(){
		content = new JPanel(new BorderLayout());
		JPanel centerContent = new JPanel(new GridLayout(3,1,5,5));

		// relleno (bordes) en panel

		createPanelWidth(content, true, true, true, true);

		// creación de contenido en cada panel

		createAddPanelContent();
		createViewPanelContent();
		createOptionPanelContent();

		// agregación de los paneles 

		centerContent.add(addPanel);
		centerContent.add(viewPanel);
		centerContent.add(optionPanel);

		content.add(centerContent);
		content.add(new JLabel(this.nombreTabla), BorderLayout.NORTH);//nombre de tabla
		return content;
	}

	/*
	 * Metodos a implementar
	 */

	public void createAddPanelContent(){
		addPanel.add(new JLabel("Registro de Cargo"), BorderLayout.NORTH);

		JPanel addPanelContent = new JPanel(new BorderLayout());

		JPanel addPanelContentContent = new JPanel(new GridLayout(4,1,5,10));

		// ide field

		JPanel idePanel = new JPanel(new GridLayout(1,2));
		JLabel ideLabel = new JLabel("Ide:");
		ideLabel.setHorizontalAlignment(JLabel.CENTER);

		idePanel.add(ideLabel);

		JPanel ideButtonPanel= new JPanel(new FlowLayout());

		ideButtonPanel.add(ide);
		idePanel.add(ideButtonPanel);

		// descripcion
		
		JPanel descripcionPanel = new JPanel(new GridLayout(1,2));
		JLabel descripcionLabel = new JLabel("Descripción del cargo:");
		descripcionLabel.setHorizontalAlignment(JLabel.CENTER);

		descripcionPanel.add(descripcionLabel);

		JPanel descripcionButtonPanel = new JPanel(new FlowLayout());
		//createPanelWidth(descripcionButtonPanel, true, true, false, false);

		descripcionButtonPanel.add(descripcion);
		descripcionPanel.add(descripcionButtonPanel);

		// sueldo

		JPanel sueldoPanel = new JPanel(new GridLayout(1,2));
		JLabel sueldoLabel = new JLabel("Sueldo:");
		sueldoLabel.setHorizontalAlignment(JLabel.CENTER);

		sueldoPanel.add(sueldoLabel);

		JPanel sueldoButtonPanel = new JPanel(new FlowLayout());

		sueldoButtonPanel.add(sueldo);
		sueldoPanel.add(sueldoButtonPanel);

		// estaRegis field

		JPanel estaRegisPanel = new JPanel(new GridLayout(1,2));
		JLabel estaRegisLabel = new JLabel("Estado de registro:");
		estaRegisLabel.setHorizontalAlignment(JLabel.CENTER);

		estaRegisPanel.add(estaRegisLabel);

		JPanel estaRegisButtonPanel = new JPanel(new FlowLayout());
		//createPanelWidth(estaRegisButtonPanel, true, true, false, false);

		//estaRegis.setEditable(false);
		estaRegisButtonPanel.add(estaRegis);
		estaRegisPanel.add(estaRegisButtonPanel);
		

		//agregando paneles
		addPanelContentContent.add(idePanel);
		addPanelContentContent.add(sueldoPanel);
		addPanelContentContent.add(descripcionPanel);
		addPanelContentContent.add(estaRegisPanel);

		createPanelWidth(addPanelContent, true, true, true, true);
		addPanelContent.add(addPanelContentContent);
		addPanel.add(addPanelContent);
	}

	public void createViewPanelContent(){
		//modifica viewPanel
		
		//DefaultTableModel model = new DefaultTableModel(new String[] {"Columna 1", "Columna 2"}, 0);        
		tabla = new JTable(){
			// para evitar que sea editabue
			public boolean isCellEditable(int fila,int col){
				return false;
			}};
		modelo = (DefaultTableModel)tabla.getModel();

		miBarra = new JScrollPane(tabla);
		
		
		//tabla.setModel(new DefaultTableModel(
			//		null,
				//	title
		//));
		tabla.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
		tabla.setModel(new javax.swing.table.DefaultTableModel(
					null,
					new String [] {
						"Ide", "DescripcionCargo", "Sueldo", "EstadoRegistro"
					}
					));
		tabla.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
		tabla.setFocusable(false);
		tabla.getTableHeader().setReorderingAllowed(false);
		
		tabla.setRowMargin(4);

		tabla.addMouseListener( new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e){
				int fila = tabla.rowAtPoint(e.getPoint());
				int columna = tabla.columnAtPoint(e.getPoint());
				System.out.println("fila:"+fila+", Col:"+columna);
			}
      		


			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
   		});
		viewPanel.add(miBarra, BorderLayout.CENTER);
	}

	public void createOptionPanelContent(){
		JPanel optionPanelContent = new JPanel(new BorderLayout());

		JPanel optionPanelContentContent = new JPanel(new GridLayout(2,4,5,45));

		optionPanelContentContent.add(adicionar);
		optionPanelContentContent.add(modificar);
		optionPanelContentContent.add(eliminar);
		optionPanelContentContent.add(cancelar);
		optionPanelContentContent.add(inactivar);
		optionPanelContentContent.add(reactivar);
		optionPanelContentContent.add(actualizar);
		optionPanelContentContent.add(salir);

		optionPanelContent.add(optionPanelContentContent);
		createPanelWidth(optionPanelContent, true, true, true, true);
		createPanelWidth(optionPanel, true, true, true, true);
		optionPanel.add(optionPanelContent);
	}


	public void createPanelWidth(JPanel panel, boolean n, boolean s, boolean e, boolean w){
		if(n) panel.add(new JLabel("\n"), BorderLayout.NORTH);
		if(s) panel.add(new JLabel("\n"), BorderLayout.SOUTH);
		if(e) panel.add(new JLabel("   "), BorderLayout.EAST);
		if(w) panel.add(new JLabel("   "), BorderLayout.WEST);
	}
}


