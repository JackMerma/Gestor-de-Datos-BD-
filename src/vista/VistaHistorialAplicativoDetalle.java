package src.vista;

import java.awt.*;
import javax.swing.*;

public class VistaHistorialAplicativoDetalle extends Vista {

	// add Panel
	public JTextField ide;
	public JTextField hora;
	public JTextField descripcion;
	public JTextField anio;
	public JTextField mes;
	public JTextField dia;
	public JTextField estaRegis;

	public VistaHistorialAplicativoDetalle() {
		super("V3H_HISTORIAL _APLICATIVO_DETALLE", new String[] { "Ide", "Hora", "Descripcion", "Año", "Mes", "Dia", "EstadoRegistro" });
	}

	/*
	 * Metodos a implementar
	 */

	@Override
	public void createAddPanelContent() {
		
		JPanel addPanelContent = new JPanel(new BorderLayout());

		JPanel addPanelContentContent = new JPanel(new GridLayout(4, 1, 5, 10));

		// instaciomos Atributos
		ide = new JTextField(20);
		hora = new JTextField(20);
		descripcion = new JTextField(20);
		anio = new JTextField(20);
		mes = new JTextField(20);
		dia = new JTextField(20);
		estaRegis = new JTextField("", 20);

		// ide field
		JPanel idePanel = addComponente(ide, "Ide:");

		// hora
		JPanel horaPanel = addComponente(hora, "Hora:");

		// descripcion
		JPanel descripcionPanel = addComponente(descripcion, "Descripcion:");

		// año
		JPanel anioPanel = addComponente(anio, "Año:");

		// mes
		JPanel mesPanel = addComponente(mes, "Mes:");

		// dia
		JPanel diaPanel = addComponente(dia, "Dia:");

		// estaRegis field
		JPanel estaRegisPanel = addComponente(estaRegis, "Estado de registro:");


		// agregando paneles
		addPanelContentContent.add(idePanel);
		addPanelContentContent.add(horaPanel);
		addPanelContentContent.add(descripcionPanel);
		addPanelContentContent.add(anioPanel);
		addPanelContentContent.add(mesPanel);
		addPanelContentContent.add(diaPanel);
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
