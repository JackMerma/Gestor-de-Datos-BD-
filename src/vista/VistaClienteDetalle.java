package src.vista;

import java.util.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;

import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;

public class VistaClienteDetalle {
	public JPanel content;
	private String nombreTabla = "CLIENTE DETALLE";

	// 3 paneles principales
	public JPanel addPanel = new JPanel(new BorderLayout());
	public JPanel viewPanel = new JPanel(new BorderLayout());
	public JPanel optionPanel = new JPanel(new BorderLayout());

	// add Panel
	public JTextField ide = new JTextField(10);
	public JTextField ideCategoria = new JTextField(10);
	public JTextField empDesc = new JTextField(10);
	public JTextField numEmple = new JTextField(10);
	public JTextField pagoCuo = new JTextField(10);
	public JTextField credito = new JTextField(10);
	public JTextField departamento = new JTextField(10);
	public JTextField nombre = new JTextField(10);
	public JTextField comportamiento = new JTextField(10);
	public JTextField apellPaterno = new JTextField(10);
	public JTextField apellMaterno = new JTextField(10);
	public JTextField direccion = new JTextField(10);
	public JTextField telefono = new JTextField(10);
	public JTextField correo = new JTextField(10);
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

		JPanel addPanelContentContent = new JPanel(new GridLayout(15,1,5,0));

		JPanel idePanel;
		JPanel ideCategoriaPanel;
		JPanel empDescPanel;
		JPanel numEmplePanel;
		JPanel pagoCuoPanel;
		JPanel creditoPanel;
		JPanel departamentoPanel;
		JPanel nombrePanel;
		JPanel comportamientoPanel;
		JPanel apellPaternoPanel;
		JPanel apellMaternoPanel;
		JPanel direccionPanel;
		JPanel telefonoPanel;
		JPanel correoPanel;
		JPanel estaRegisPanel;

		// ide field

		idePanel = new JPanel(new GridLayout(1,2));
		JLabel ideLabel = new JLabel("Ide:");
		ideLabel.setHorizontalAlignment(JLabel.CENTER);

		idePanel.add(ideLabel);

		JPanel ideButtonPanel= new JPanel(new FlowLayout());

		ideButtonPanel.add(ide);
		idePanel.add(ideButtonPanel);

		// ideCategoria

		ideCategoriaPanel = new JPanel(new GridLayout(1,2));
		JLabel ideCategoriaLabel = new JLabel("Ide Categoria:");
		ideCategoriaLabel.setHorizontalAlignment(JLabel.CENTER);

		ideCategoriaPanel.add(ideCategoriaLabel);

		JPanel ideCategoriaButtonPanel = new JPanel(new FlowLayout());

		ideCategoriaButtonPanel.add(ideCategoria);
		ideCategoriaPanel.add(ideCategoriaButtonPanel);

		// empDesc

		empDescPanel = new JPanel(new GridLayout(1,2));
		JLabel empDescLabel = new JLabel("Descripcion empresa:");
		empDescLabel.setHorizontalAlignment(JLabel.CENTER);

		empDescPanel.add(empDescLabel);

		JPanel empDescButtonPanel = new JPanel(new FlowLayout());

		empDescButtonPanel.add(empDesc);
		empDescPanel.add(empDescButtonPanel);

		// numEmple

		numEmplePanel = new JPanel(new GridLayout(1,2));
		JLabel numEmpleLabel = new JLabel("Representante cliente:");
		numEmpleLabel.setHorizontalAlignment(JLabel.CENTER);

		numEmplePanel.add(numEmpleLabel);

		JPanel numEmpleButtonPanel = new JPanel(new FlowLayout());

		numEmpleButtonPanel.add(numEmple);
		numEmplePanel.add(numEmpleButtonPanel);

		// pagoCuo

		pagoCuoPanel = new JPanel(new GridLayout(1,2));
		JLabel pagoCuoLabel = new JLabel("Pago cuota:");
		pagoCuoLabel.setHorizontalAlignment(JLabel.CENTER);

		pagoCuoPanel.add(pagoCuoLabel);

		JPanel pagoCuoButtonPanel = new JPanel(new FlowLayout());

		pagoCuoButtonPanel.add(pagoCuo);
		pagoCuoPanel.add(pagoCuoButtonPanel);

		// credito

		creditoPanel = new JPanel(new GridLayout(1,2));
		JLabel creditoLabel = new JLabel("Credito:");
		creditoLabel.setHorizontalAlignment(JLabel.CENTER);

		creditoPanel.add(creditoLabel);

		JPanel creditoButtonPanel = new JPanel(new FlowLayout());

		creditoButtonPanel.add(credito);
		creditoPanel.add(creditoButtonPanel);

		// departamento

		departamentoPanel = new JPanel(new GridLayout(1,2));
		JLabel departamentoLabel = new JLabel("Departamento:");
		departamentoLabel.setHorizontalAlignment(JLabel.CENTER);

		departamentoPanel.add(departamentoLabel);

		JPanel departamentoButtonPanel = new JPanel(new FlowLayout());

		departamentoButtonPanel.add(departamento);
		departamentoPanel.add(departamentoButtonPanel);

		// nombre

		nombrePanel = new JPanel(new GridLayout(1,2));
		JLabel nombreLabel = new JLabel("Nombre:");
		nombreLabel.setHorizontalAlignment(JLabel.CENTER);

		nombrePanel.add(nombreLabel);

		JPanel nombreButtonPanel = new JPanel(new FlowLayout());

		nombreButtonPanel.add(nombre);
		nombrePanel.add(nombreButtonPanel);

		// comportamiento

		comportamientoPanel = new JPanel(new GridLayout(1,2));
		JLabel comportamientoLabel = new JLabel("Comportamiento:");
		comportamientoLabel.setHorizontalAlignment(JLabel.CENTER);

		comportamientoPanel.add(comportamientoLabel);

		JPanel comportamientoButtonPanel = new JPanel(new FlowLayout());

		comportamientoButtonPanel.add(comportamiento);
		comportamientoPanel.add(comportamientoButtonPanel);

		// apellPaterno

		apellPaternoPanel = new JPanel(new GridLayout(1,2));
		JLabel apellPaternoLabel = new JLabel("Apellido Paterno:");
		apellPaternoLabel.setHorizontalAlignment(JLabel.CENTER);

		apellPaternoPanel.add(apellPaternoLabel);

		JPanel apellPaternoButtonPanel = new JPanel(new FlowLayout());

		apellPaternoButtonPanel.add(apellPaterno);
		apellPaternoPanel.add(apellPaternoButtonPanel);

		// apellMaterno

		apellMaternoPanel = new JPanel(new GridLayout(1,2));
		JLabel apellMaternoLabel = new JLabel("Apellido Materno:");
		apellMaternoLabel.setHorizontalAlignment(JLabel.CENTER);

		apellMaternoPanel.add(apellMaternoLabel);

		JPanel apellMaternoButtonPanel = new JPanel(new FlowLayout());

		apellMaternoButtonPanel.add(apellMaterno);
		apellMaternoPanel.add(apellMaternoButtonPanel);

		// direccion

		direccionPanel = new JPanel(new GridLayout(1,2));
		JLabel direccionLabel = new JLabel("Direccion:");
		direccionLabel.setHorizontalAlignment(JLabel.CENTER);

		direccionPanel.add(direccionLabel);

		JPanel direccionButtonPanel = new JPanel(new FlowLayout());

		direccionButtonPanel.add(direccion);
		direccionPanel.add(direccionButtonPanel);

		// telefono

		telefonoPanel = new JPanel(new GridLayout(1,2));
		JLabel telefonoLabel = new JLabel("Telefono:");
		telefonoLabel.setHorizontalAlignment(JLabel.CENTER);

		telefonoPanel.add(telefonoLabel);

		JPanel telefonoButtonPanel = new JPanel(new FlowLayout());

		telefonoButtonPanel.add(telefono);
		telefonoPanel.add(telefonoButtonPanel);

		// correo

		correoPanel = new JPanel(new GridLayout(1,2));
		JLabel correoLabel = new JLabel("Correo:");
		correoLabel.setHorizontalAlignment(JLabel.CENTER);

		correoPanel.add(correoLabel);

		JPanel correoButtonPanel = new JPanel(new FlowLayout());

		correoButtonPanel.add(correo);
		correoPanel.add(correoButtonPanel);

		// estaRegis field

		estaRegisPanel = new JPanel(new GridLayout(1,2));
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
		addPanelContentContent.add(ideCategoriaPanel);
		addPanelContentContent.add(empDescPanel);
		addPanelContentContent.add(numEmplePanel);
		addPanelContentContent.add(pagoCuoPanel);
		addPanelContentContent.add(creditoPanel);
		addPanelContentContent.add(departamentoPanel);
		addPanelContentContent.add(nombrePanel);
		addPanelContentContent.add(apellPaternoPanel);
		addPanelContentContent.add(apellMaternoPanel);
		addPanelContentContent.add(comportamientoPanel);
		addPanelContentContent.add(direccionPanel);
		addPanelContentContent.add(telefonoPanel);
		addPanelContentContent.add(correoPanel);
		addPanelContentContent.add(estaRegisPanel);

		createPanelWidth(addPanelContent, true, true, true, true);

		JScrollPane scroll = new JScrollPane(addPanelContentContent);

		addPanelContent.add(scroll);
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
						"Ide", "IdeCategoria", "DescripcionEmpresa", "Representante Cliente",
						"PagoCuota", "Credito", "Departamento", "Nombre", "ApellidoPaterno",
						"ApellidoMaterno", "Comportamiento", "Direccion", "Telefono", "Correo", "EstaRegistro"
					}
					));
		tabla.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
		tabla.setFocusable(false);
		tabla.getTableHeader().setReorderingAllowed(false);
		
		tabla.setRowMargin(4);
		tabla.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

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
