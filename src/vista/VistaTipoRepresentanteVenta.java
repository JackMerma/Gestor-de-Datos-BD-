package src.vista;

import java.awt.*;
import javax.swing.*;

public class VistaTipoRepresentanteVenta extends Vista {
	// add Panel
	public JTextField ide;
	public JTextField descTipRepVen;
	public JTextField estaRegis;

	public VistaTipoRepresentanteVenta() {
		super("Tipo Representante Venta", new String[] { "Ide", "TipoRepresentante", "EstadoRegistro" });
	}

	/*
	 * Metodos a implementar
	 */

	public void createAddPanelContent() {
		addPanel.add(new JLabel("Registro de Tipo Representante Venta"), BorderLayout.NORTH);

		JPanel addPanelContent = new JPanel(new BorderLayout());

		JPanel addPanelContentContent = new JPanel(new GridLayout(3, 1, 5, 25));

		// ide field

		JPanel idePanel = new JPanel(new GridLayout(1, 2));
		JLabel ideLabel = new JLabel("Ide:");
		ideLabel.setHorizontalAlignment(JLabel.CENTER);

		idePanel.add(ideLabel);

		JPanel ideButtonPanel = new JPanel(new FlowLayout());
		// createPanelWidth(ideButtonPanel, true, true, false, false);

		// INstanciamos los atributos
		ide = new JTextField(10);
		descTipRepVen = new JTextField(10);
		estaRegis = new JTextField("", 1);

		ideButtonPanel.add(ide);
		idePanel.add(ideButtonPanel);

		// descTipRepVen field

		JPanel descTipRepVenPanel = new JPanel(new GridLayout(1, 2));
		JLabel descTipRepVenLabel = new JLabel("Tipo de representante:");
		descTipRepVenLabel.setHorizontalAlignment(JLabel.CENTER);

		descTipRepVenPanel.add(descTipRepVenLabel);

		JPanel descTipRepVenButtonPanel = new JPanel(new FlowLayout());
		// createPanelWidth(descTipRepVenButtonPanel, true, true, false, false);

		descTipRepVenButtonPanel.add(descTipRepVen);
		descTipRepVenPanel.add(descTipRepVenButtonPanel);

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
		addPanelContentContent.add(descTipRepVenPanel);
		addPanelContentContent.add(estaRegisPanel);

		createPanelWidth(addPanelContent, true, true, true, true);
		addPanelContent.add(addPanelContentContent);
		addPanel.add(addPanelContent);
	}
}
