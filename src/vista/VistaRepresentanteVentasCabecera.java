package src.vista;

import java.awt.*;
import javax.swing.*;

public class VistaRepresentanteVentasCabecera extends Vista {

	// add Panel
	public JTextField factIde;
	public JTextField repIde;
	
	public VistaRepresentanteVentasCabecera() {
		super("REPRESENTANTE VENTAS DETALLE", new String[] { "FactIde", "RepIde"});
	}

	/*
	 * Metodos a implementar
	 */

	@Override
	public void createAddPanelContent() {
		
		JPanel addPanelContent = new JPanel(new BorderLayout());

		JPanel addPanelContentContent = new JPanel(new GridLayout(2, 1, 5, 10));

		// instaciomos Atributos
		factIde = new JTextField(20);
		repIde = new JTextField(20);
		
		// ide field

		JPanel factIdePanel = addComponente(factIde, "Factura Ide:");

		// descripcion

        JPanel repIdePanel = addComponente(repIde, "Representante Ide:");

		// agregando paneles
		addPanelContentContent.add(factIdePanel);
		addPanelContentContent.add(repIdePanel);
		
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
