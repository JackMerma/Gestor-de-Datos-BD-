package src.vista;

// GUI
import java.awt.*;
import javax.swing.*;

public class VistaRolRegistro extends Vista {

	// add Panel
	public JTextField ide;
	public JTextField rolDesc;
	public JTextField estaRegis;

	public VistaRolRegistro() {
		super("Rol Registro", new String[] { "Ide", "DescripcionRol", "EstadoRegistro" });
		// TODO Auto-generated constructor stub
	}

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
		rolDesc = new JTextField(10);
		estaRegis = new JTextField("", 1);

		ideButtonPanel.add(ide);
		idePanel.add(ideButtonPanel);

		// rolDesc field

		JPanel rolDescPanel = new JPanel(new GridLayout(1, 2));
		JLabel rolDescLabel = new JLabel("Descripcion del rol:");
		rolDescLabel.setHorizontalAlignment(JLabel.CENTER);

		rolDescPanel.add(rolDescLabel);

		JPanel rolDescButtonPanel = new JPanel(new FlowLayout());
		// createPanelWidth(rolDescButtonPanel, true, true, false, false);

		rolDescButtonPanel.add(rolDesc);
		rolDescPanel.add(rolDescButtonPanel);

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
		addPanelContentContent.add(rolDescPanel);
		addPanelContentContent.add(estaRegisPanel);

		createPanelWidth(addPanelContent, true, true, true, true);
		addPanelContent.add(addPanelContentContent);
		addPanel.add(addPanelContent);
	}

}
