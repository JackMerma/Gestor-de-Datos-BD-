package src.vista;

// GUI
import java.awt.*;
import javax.swing.*;

public class VistaCategoriaCliente extends Vista {
	public VistaCategoriaCliente() {
		super("Categoria Clientes", new String[] { "Ide", "LimiteCredito", "EstadoRegistro" });
	}

	// add Panel
	public JTextField ide;
	public JTextField limCredito;
	public JTextField estaRegis;

	/*
	 * Metodos a implementar
	 */
	@Override
	public void createAddPanelContent() {
		
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
		limCredito = new JTextField(10);
		estaRegis = new JTextField("", 1);
	


		ideButtonPanel.add(ide);
		idePanel.add(ideButtonPanel);

		// limCredito field

		JPanel limCreditoPanel = new JPanel(new GridLayout(1, 2));
		JLabel limCreditoLabel = new JLabel("Limite de credito:");
		limCreditoLabel.setHorizontalAlignment(JLabel.CENTER);

		limCreditoPanel.add(limCreditoLabel);

		JPanel limCreditoButtonPanel = new JPanel(new FlowLayout());
		// createPanelWidth(limCreditoButtonPanel, true, true, false, false);

		limCreditoButtonPanel.add(limCredito);
		limCreditoPanel.add(limCreditoButtonPanel);

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
		addPanelContentContent.add(limCreditoPanel);
		addPanelContentContent.add(estaRegisPanel);

		createPanelWidth(addPanelContent, true, true, true, true);
		addPanelContent.add(addPanelContentContent);
		addPanel.add(addPanelContent);
	}

}
