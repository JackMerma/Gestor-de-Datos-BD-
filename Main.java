import src.vista.*;
import src.modelo.*;
import src.controlador.*;

import java.util.*;
import java.awt.*;
import javax.swing.*;

import java.awt.event.*;
public class Main {
	
	public static final String PROJECTNAME = "EMPRESA DE DISTRIBUCION";
	public static JFrame frame;
	public static JFrame frameInitial;

	public static void main(String [] args){

		// creando una interface adicional para probar las demas
		frameInitial = new JFrame("INICIO TABLAS REFERENCIALES");
		frameInitial.setSize(700, 200);
		frameInitial.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameInitial.setLocationRelativeTo(null);

		frameInitial.setLayout(new BorderLayout()); 
		JLabel label = new JLabel("Tablas Referencioales", SwingConstants.CENTER);
		frameInitial.add(label, BorderLayout.NORTH);

		// agregando los otros paneles
		addButtonsTableReference();
		
		frameInitial.setVisible(true);
		
		/*
		frame = new JFrame(PROJECTNAME);
		frame.setSize(500, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);

		generateContent();
		frame.setVisible(true);
		*/
		//probando la coneccion
		// CategoriaClienteDAO test = new CategoriaClienteDAO();
		// CategoriaCliente catCli = new CategoriaCliente(2,2000);// mejorar esta parte, se duplica la clave
		// catCli.setLimCredito(100);
		// test.modificar(catCli);
		// //test.add(catCli);
		// test.listar();

	}

	public static void addButtonsTableReference(){
		JPanel panel = new JPanel();

		// creando el panel para los botones internos
		panel.setLayout(new GridLayout(2,2,5,10));	
		
		panel.add(addPanelButton("Cargo"));
		panel.add(addPanelButton("Categoria Cliente"));
		panel.add(addPanelButton("Rol Registro"));
		panel.add(addPanelButton("Tipo Representante Venta"));
		
		frameInitial.add(panel, BorderLayout.CENTER);
	}

	public static JPanel addPanelButton(String titleTableReference){
		JPanel panelInter = new JPanel();
		panelInter.add(new JLabel(titleTableReference));
		JButton button =new JButton(titleTableReference);
		ControladorMain contro = new ControladorMain();
		button.addActionListener(contro);
		panelInter.add(button);
		return panelInter;
	}

	public static void generateContent(){
		VistaCargo vi = new VistaCargo();
		
		frame.add(vi.getContent());
		ControladorCargo con = new ControladorCargo(vi); 
	
	}
}

class ControladorMain implements ActionListener{
	public void actionPerformed(ActionEvent e){
		if(e.getActionCommand().equals("Cargo")){
			System.out.println("Cargo");
		}else if((e.getActionCommand().equals("Categoria Cliente"))){
			System.out.println("Categoria Cliente");
		}else if((e.getActionCommand().equals("Rol Registro"))){
			System.out.println("Rol Registro");
		}else if((e.getActionCommand().equals("Tipo Representante Venta"))){
			System.out.println("Tipo Representante Venta");
		}
	}
}
