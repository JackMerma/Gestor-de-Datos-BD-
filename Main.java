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
		//probando la coneccion
		// CategoriaClienteDAO test = new CategoriaClienteDAO();
		// CategoriaCliente catCli = new CategoriaCliente(2,2000);// mejorar esta parte, se duplica la clave
		// catCli.setLimCredito(100);
		// test.modificar(catCli);
		// //test.add(catCli);
		// test.listar();

	}

	public static void generateContent(){
		Vista vi = new Vista();
		
		frame.add(vi.getContent());
		Controlador con = new Controlador(vi); 
	
	}
}
