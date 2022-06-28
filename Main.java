import src.vista.*;
import src.modelo.*;
import src.controlador.*;

import java.util.*;
import java.awt.*;
import javax.swing.*;

public class Main {
	
	public static final String PROJECTNAME = "ZZZZZ";
	public static JFrame frame;

	public static void main(String [] args){
		frame = new JFrame(PROJECTNAME);
		frame.setSize(500, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);

		generateContent();

		frame.setVisible(true);
		//probando la coneccion
		CategoriaClienteDAO test = new CategoriaClienteDAO();
		
		test.listar();

	}

	public static void generateContent(){
		Vista vi = new Vista();
		Controlador con = new Controlador(vi); 
		
		frame.add(vi.getContent());
	}
}
