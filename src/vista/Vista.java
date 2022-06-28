package src.vista;

// GUI
import java.util.*;
import java.awt.*;
import javax.swing.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Vista {
	public JPanel content;
	private String nombreTabla = "CATEGORÍA CLIENTE";

	// 3 paneles principales
	public JPanel addPanel = new JPanel(new BorderLayout());
	public JPanel viewPanel = new JPanel(new BorderLayout());
	public JPanel optionPanel = new JPanel(new BorderLayout());

	// add Panel
	public JLabel ide = new JLabel();
	public JLabel limCredito = new JLabel();
	public JLabel estaRegis = new JLabel();

	// view Panel
	//decidir recurso a usar...

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

		createPanelWidth(content);

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
		//modifica addPanel
	}

	public void createViewPanelContent(){
		//modifica viewPanel
	}

	public void createOptionPanelContent(){
		//modifica optionPanel
	}


	public void createPanelWidth(JPanel panel){
		panel.add(new JLabel("\n"), BorderLayout.NORTH);
		panel.add(new JLabel("\n"), BorderLayout.SOUTH);
		panel.add(new JLabel("   "), BorderLayout.EAST);
		panel.add(new JLabel("   "), BorderLayout.WEST);
	}
}


