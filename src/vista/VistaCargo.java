package src.vista;

import java.awt.*;
import javax.swing.*;

public class VistaCargo extends Vista {

	// add Panel
	public JTextField ide = new JTextField(10);
	public JTextField descripcion = new JTextField(10);
	public JTextField sueldo = new JTextField(10);
	public JTextField estaRegis = new JTextField("", 1);

	public VistaCargo(String nombreTabla) {
		super(nombreTabla, new String[] { "Ide", "DescripcionCargo", "Sueldo", "EstadoRegistro"});
	}

	/*
	 * Metodos a implementar
	 */

	@Override
	public void createAddPanelContent() {
		addPanel.add(new JLabel("Registro de Cargo"), BorderLayout.NORTH);

		JPanel addPanelContent = new JPanel(new BorderLayout());

		JPanel addPanelContentContent = new JPanel(new GridLayout(4, 1, 5, 10));

		// ide field

		JPanel idePanel = new JPanel(new GridLayout(1, 2));
		JLabel ideLabel = new JLabel("Ide:");
		ideLabel.setHorizontalAlignment(JLabel.CENTER);

		idePanel.add(ideLabel);

		JPanel ideButtonPanel = new JPanel(new FlowLayout());

		ideButtonPanel.add(ide);
		idePanel.add(ideButtonPanel);

		// descripcion

		JPanel descripcionPanel = new JPanel(new GridLayout(1, 2));
		JLabel descripcionLabel = new JLabel("Descripción del cargo:");
		descripcionLabel.setHorizontalAlignment(JLabel.CENTER);

		descripcionPanel.add(descripcionLabel);

		JPanel descripcionButtonPanel = new JPanel(new FlowLayout());
		// createPanelWidth(descripcionButtonPanel, true, true, false, false);

		descripcionButtonPanel.add(descripcion);
		descripcionPanel.add(descripcionButtonPanel);

		// sueldo

		JPanel sueldoPanel = new JPanel(new GridLayout(1, 2));
		JLabel sueldoLabel = new JLabel("Sueldo:");
		sueldoLabel.setHorizontalAlignment(JLabel.CENTER);

		sueldoPanel.add(sueldoLabel);

		JPanel sueldoButtonPanel = new JPanel(new FlowLayout());

		sueldoButtonPanel.add(sueldo);
		sueldoPanel.add(sueldoButtonPanel);

		// estaRegis field

		JPanel estaRegisPanel = new JPanel(new GridLayout(1, 2));
		JLabel estaRegisLabel = new JLabel("Estado de registro:");
		estaRegisLabel.setHorizontalAlignment(JLabel.CENTER);

		estaRegisPanel.add(estaRegisLabel);

		JPanel estaRegisButtonPanel = new JPanel(new FlowLayout());
		// createPanelWidth(estaRegisButtonPanel, true, true, false, false);

		// estaRegis.setEditable(false);
		estaRegisButtonPanel.add(estaRegis);
		estaRegisPanel.add(estaRegisButtonPanel);

		// agregando paneles
		addPanelContentContent.add(idePanel);
		addPanelContentContent.add(sueldoPanel);
		addPanelContentContent.add(descripcionPanel);
		addPanelContentContent.add(estaRegisPanel);

		createPanelWidth(addPanelContent, true, true, true, true);
		addPanelContent.add(addPanelContentContent);
		addPanel.add(addPanelContent);
	}

}
