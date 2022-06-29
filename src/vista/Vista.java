package src.vista;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Color;

import java.awt.Dimension;
import java.awt.Font;
import java.io.PrintWriter;
import java.awt.*;

public class Vista extends JFrame implements ActionListener {
	JLabel labelCod, labelDes, labelEst;
	JTextField txtCod, txtDes, txtEst;
	JButton adicionar, modificar, eliminar, cancelar, inactivar, reactivar, actualizar, salir;
	JPanel panelReg, panelTab, panelBot;

	public Vista() {
		setTitle("GZZ ESTADO REGISTRO");
		setLayout(new FlowLayout());
		setVisible(true);
		setSize(540, 630);
		createContens();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public void createContens() {

		// PANEL 1
		panelReg = new JPanel();
		panelReg.setPreferredSize(new Dimension(500, 200));
		panelReg.setBackground(Color.RED);

		labelCod = new JLabel("Codigo");
		labelCod.setForeground(Color.WHITE);
		labelCod.setPreferredSize(new Dimension(500, 35));
		labelCod.setFont(new Font("Jokerman", 0, 19));
		panelReg.add(labelCod);
		add(panelReg);

		// PANEL 2
		panelTab = new JPanel();
		panelTab.setPreferredSize(new Dimension(500, 250));
		panelTab.setBackground(Color.BLUE);
		add(panelTab);

		// PANEL 3
		panelBot = new JPanel(new GridLayout(2, 4));
		panelBot.setPreferredSize(new Dimension(500, 100));

		panelBot.setBackground(Color.DARK_GRAY);
		adicionar = new JButton("Adicionar");
		modificar = new JButton("Modificar");
		eliminar = new JButton("Eliminar");
		cancelar = new JButton("Cancelar");
		inactivar = new JButton("Inactivar");
		reactivar = new JButton("Reactivar");
		actualizar = new JButton("Actualizar");
		salir = new JButton("Salir");
		panelBot.add(adicionar);
		panelBot.add(modificar);
		panelBot.add(eliminar);
		panelBot.add(cancelar);
		panelBot.add(inactivar);
		panelBot.add(reactivar);
		panelBot.add(actualizar);
		panelBot.add(salir);

		add(panelBot);

	}

	public static void main(String[] args) {
		Vista newVista = new Vista();
	}
}
