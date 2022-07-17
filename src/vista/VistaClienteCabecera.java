package src.vista;

import java.awt.*;
import javax.swing.*;

public class VistaClienteCabecera extends Vista {

	// add Panel
	public JTextField ide;
	public JTextField ideCliente;
	public JTextField estaRegis;

	public VistaClienteCabecera() {
		super("V1M_CLIENTE_CABECERA", new String[] { "Ide", "DescripcionCargo", "ideCliente", "EstadoRegistro" });
	}

	/*
	 * Metodos a implementar
	 */

	@Override
	public void createAddPanelContent() {
		
		JPanel addPanelContent = new JPanel(new BorderLayout());

		JPanel addPanelContentContent = new JPanel(new GridLayout(3, 1, 5, 45));

		// instaciomos Atributos
		ide = new JTextField(20);
		ideCliente = new JTextField(20);
		estaRegis = new JTextField("", 20);

		// ide field
		JPanel idePanel = addComponente(ide, "Ide:");

		// ideCliente
		JPanel ideClientePanel = addComponente(ideCliente, "ideCliente:");
	
		// estaRegis field
		JPanel estaRegisPanel = addComponente(estaRegis, "Estado de registro:");
	

		// agregando paneles
		addPanelContentContent.add(idePanel);
		addPanelContentContent.add(ideClientePanel);
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
