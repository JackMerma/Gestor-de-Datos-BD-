import src.vista.*;
import src.modelo.*;
import src.controlador.*;

import java.util.*;
import java.awt.*;
import javax.swing.*;

public class Main {
	
	public static final String PROJECTNAME = "EMPRESA DE DISTRIBUCION";
	public static JFrame frame;

	public static void main(String [] args){
		frame = new JFrame(PROJECTNAME);
		frame.setSize(500, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);

		generateContent();

		frame.setVisible(true);
	
	}

	public static void generateContent(){
		VistaCargo vi = new VistaCargo();
		
		frame.add(vi.getContent());
		ControladorCargo con = new ControladorCargo(vi); 
	
	}
}
