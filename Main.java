import src.CargaDatos;
import src.Conexion;

import java.util.*;
import java.awt.*;
import javax.swing.*;

public class Main {
	
	public static final String PROJECTNAME = "ZZZZZ";
	public static JFrame frame;

	public static void main(String [] args){
		frame = new JFrame(PROJECTNAME);
		frame.setSize(200, 300);
		frame.setLocationRelativeTo(null);

		generateContent();

		frame.setVisible(true);
	}

	public static void generateContent(){

	}
}
