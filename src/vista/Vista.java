package src.vista;

// GUI
import java.util.*;
import java.awt.*;
import javax.swing.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Vista {
	public JButton b = new JButton("presioname");

	public JPanel content;

	// 3 paneles principales
	public JPanel addPanel;
	public JPanel viewPanel;
	public JPanel optionPanel;

	// add Panel
	public JLabel ide = new JLabel();
	public JLabel limCredito = new JLabel();
	public JLabel estaRegis = new JLabel();

	// view Panel
	

	// option Panel


	public JPanel getContent(){
		content = new JPanel(new BorderLayout());

		content.add(b);

		return content;
	}
}


