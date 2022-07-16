package src.vista;

import java.awt.*;
import javax.swing.*;

public class VistaOficinaDetalle extends Vista {

	// add Panel
	public JTextField ide;
	public JTextField ciudad;
	public JTextField region;
	public JTextField direccion;
	public JTextField empleado;
	public JTextField objetivo;
	public JTextField ventas;
	public JTextField estaRegis;

	public VistaOficinaDetalle() {
		super("Oficina Detalle", new String[] { "Ide", "Ciudad", "Region", "Direccion", "Empleado", "Obejtico",
				"Ventas", "EstadoRegistro" });
	}

	/*
	 * Metodos a implementar
	 */

	@Override
	public void createAddPanelContent() {
		
		JPanel addPanelContent = new JPanel(new BorderLayout());

		JPanel addPanelContentContent = new JPanel(new GridLayout(8, 1, 5, 10));

		// instaciomos Atributos
		ide = new JTextField(10);
		ciudad = new JTextField(10);
		region = new JTextField(10);
		direccion = new JTextField(10);
		empleado = new JTextField(10);
		objetivo = new JTextField(10);
		ventas = new JTextField(10);
		estaRegis = new JTextField("", 1);

		// ide field

		JPanel idePanel = addComponente(ide, "Ide: ");
		
		// Ciudad

		JPanel ciudadPanel = addComponente(ciudad, "Ciudad de la oficina:");

		// Region-----------------------------

		JPanel regionPanel = addComponente(region, "Region: ");
		
		// Direccion
		
		JPanel direccionPanel = addComponente(direccion, "Direccion: ");
		
		// Empleado
		
		JPanel empleadoPanel = addComponente(empleado, "Empleado: ");
		
		// Objetivo
		
		JPanel objetivoPanel = addComponente(objetivo, "Objetivo: ");
		
		// Venta
		
		JPanel ventaPanel = addComponente(ventas, "Venta: ");
		
		
		// estado registro
		JPanel estaRegisPanel = addComponente(estaRegis, "Estado de registro: ");

		// agregando paneles
		addPanelContentContent.add(idePanel);
		addPanelContentContent.add(ciudadPanel);
		addPanelContentContent.add(regionPanel);
		addPanelContentContent.add(direccionPanel);
		addPanelContentContent.add(empleadoPanel);
		addPanelContentContent.add(objetivoPanel);
		addPanelContentContent.add(ventaPanel);
		addPanelContentContent.add(estaRegisPanel);

		createPanelWidth(addPanelContent, true, true, true, true);
		addPanelContent.add(addPanelContentContent);
		addPanel.add(addPanelContent);
	}

	private JPanel addComponente(JTextField txtField, String name) {
		JPanel panel = new JPanel(new GridLayout(1, 2));
		JLabel label = new JLabel(name);
		label.setHorizontalAlignment(JLabel.CENTER);

		panel.add(label);

		JPanel buttonPanel = new JPanel(new FlowLayout());

		buttonPanel.add(txtField);
		panel.add(buttonPanel);
		return panel;
	}

}
