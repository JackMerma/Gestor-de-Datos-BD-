package src.vista;

import java.awt.*;
import javax.swing.*;

public class VistaClienteDetalle extends Vista {

	// add Panel
	public JTextField ide;
	public JTextField ideCategoria;
	public JTextField empDesc;
	public JTextField numEmple;
	public JTextField pagoCuo;
	public JTextField credito;
	public JTextField departamento;
	public JTextField nombre;
	public JTextField comportamiento;
	public JTextField apellPaterno;
	public JTextField apellMaterno;
	public JTextField direccion;
	public JTextField telefono;
	public JTextField correo;
	public JTextField estaRegis;

	public VistaClienteDetalle() {
		super("V1M_CLIENTE_DETALLE", new String[] { "Ide", "IdeCategoria", "EmpresaDesc", "Representante", "PagoCuota", "Credito", "Departamento", "Nombre", "Comportamiento", "ApellPaterno", "ApellMaterno", "Direccion", "Telefono", "Correo", "EstadoRegistro" });
	}

	/*
	 * Metodos a implementar
	 */

	@Override
	public void createAddPanelContent() {
		
		JPanel addPanelContent = new JPanel(new BorderLayout());

		JPanel addPanelContentContent = new JPanel(new GridLayout(15, 1, 5, 0));

		// instaciomos Atributos
		ide = new JTextField(20);
		ideCategoria = new JTextField(20);
		empDesc = new JTextField(20);
		numEmple = new JTextField(20);
		pagoCuo = new JTextField(20);
		credito = new JTextField(20);
		departamento = new JTextField(20);
		nombre = new JTextField(20);
		comportamiento = new JTextField(20);
		apellPaterno = new JTextField(20);
		apellMaterno = new JTextField(20);
		direccion = new JTextField(20);
		telefono = new JTextField(20);
		correo = new JTextField(20);
		estaRegis = new JTextField("", 20);

		// ide field
		JPanel idePanel = addComponente(ide, "Ide:");

		// ideCategoria
		JPanel ideCategoriaPanel = addComponente(ideCategoria, "Ide Categoria:");

		// descripcion empresa
		JPanel empDescPanel = addComponente(empDesc, "Descripcion Empresa:");

		// representante cliente
		JPanel numEmplePanel = addComponente(numEmple, "Representante Cliente:");

		// Pago Cuota
		JPanel pagoCuoPanel = addComponente(pagoCuo, "Pago Cuota:");

		// credito
		JPanel creditoPanel = addComponente(credito, "Credito:");

		// departamento
		JPanel departamentoPanel = addComponente(departamento, "Departamento:");

		// nombre
		JPanel nombrePanel = addComponente(nombre, "Nombre:");

		// comportamiento
		JPanel comportamientoPanel = addComponente(comportamiento, "Comportamiento:");

		// apellido Paterno
		JPanel apellPaternoPanel = addComponente(apellPaterno, "Apellido Paterno:");

		// apellido Materno
		JPanel apellMaternoPanel = addComponente(apellMaterno, "Apellido Materno:");

		// direccion
		JPanel direccionPanel = addComponente(direccion, "Direccion:");

		// telefono
		JPanel telefonoPanel = addComponente(telefono, "Telefono:");

		// Correo
		JPanel correoPanel = addComponente(correo, "Correo:");

		// estaRegis field
		JPanel estaRegisPanel = addComponente(estaRegis, "Estado de registro:");


		// agregando paneles
		addPanelContentContent.add(idePanel);
		addPanelContentContent.add(ideCategoriaPanel);
		addPanelContentContent.add(empDescPanel);
		addPanelContentContent.add(numEmplePanel);
		addPanelContentContent.add(pagoCuoPanel);
		addPanelContentContent.add(creditoPanel);
		addPanelContentContent.add(departamentoPanel);
		addPanelContentContent.add(nombrePanel);
		addPanelContentContent.add(comportamientoPanel);
		addPanelContentContent.add(apellPaternoPanel);
		addPanelContentContent.add(apellMaternoPanel);
		addPanelContentContent.add(direccionPanel);
		addPanelContentContent.add(telefonoPanel);
		addPanelContentContent.add(correoPanel);
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
