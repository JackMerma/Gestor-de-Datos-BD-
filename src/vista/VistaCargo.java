package src.vista;

import java.awt.*;
import javax.swing.*;

public class VistaCargo extends Vista {

	// add Panel
	public JTextField ide;
	public JTextField descripcion;
	public JTextField sueldo;
	public JTextField estaRegis;

	public VistaCargo() {
		super("TABLA CARGO", new String[] { "Ide", "DescripcionCargo", "Sueldo", "EstadoRegistro" });
	}

	/*
	 * Metodos a implementar
	 */

	@Override
	public void createAddPanelContent() {
		addPanel.add(new JLabel("Registro de Cargo"), BorderLayout.NORTH);

		JPanel addPanelContent = new JPanel(new BorderLayout());

		JPanel addPanelContentContent = new JPanel(new GridLayout(4, 1, 5, 10));

		// instaciomos Atributos
		ide = new JTextField(10);
		descripcion = new JTextField(10);
		sueldo = new JTextField(10);
		estaRegis = new JTextField("", 1);

		// ide field

		JPanel idePanel = addComponente(ide, "Ide:");

		// descripcion

		JPanel descripcionPanel = addComponente(descripcion, "Descripcion del Cargo:");

		// sueldo

		JPanel sueldoPanel = addComponente(sueldo, "Sueldo:");
	

		// estaRegis field

		JPanel estaRegisPanel = addComponente(estaRegis, "Estado de registro:");
	

		// agregando paneles
		addPanelContentContent.add(idePanel);
		addPanelContentContent.add(sueldoPanel);
		addPanelContentContent.add(descripcionPanel);
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
