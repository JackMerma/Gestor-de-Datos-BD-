package src.vista;

// GUI
import java.util.*;
import java.awt.*;
import javax.swing.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

//llamar al DAO

public class Vista {

	//clase DAO

	//botones, frames, etc...
	public JButton b = new JButton("presioname");

	public JPanel content;

	public JPanel getContent(){
		content = new JPanel(new BorderLayout());

		content.add(b);

		return content;
	}
}


