import src.vista.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import src.modelo.*;
import src.controlador.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;

public class Main implements ActionListener {

	public static final String PROJECTNAME = "EMPRESA DE DISTRIBUCION";
	public static JFrame frame;
	public JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15, b16;

	public Main() {
		frame = new JFrame(PROJECTNAME);
		frame.setSize(500, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);		
		frame.setLayout(new BorderLayout());
		frame.setVisible(true);

		b1 = new JButton("Cargo");
		b2 = new JButton("Acciones");
		b3 = new JButton("Categoria Clientes");
		b4 = new JButton("Cliente Cabecera");
		b5 = new JButton("Cliente Detalle");
		b6 = new JButton("Historial Apl. Cab");
		b7 = new JButton("Historial Apl. Det");
		b8 = new JButton("Rol Registro");
		b9 = new JButton("Tipo Rep Venta");
		b10 = new JButton("Rep Venta Cabecera");
		b11 = new JButton("Rep Venta Detalle");
		b12 = new JButton("Usuariob Reg Detalle");
		b13 = new JButton("Oficina Detalle");
		b14 = new JButton("Oficina Factura");
		b15 = new JButton("Producto Cabecera");
		b16 = new JButton("Producto Detalle");

		b1.addActionListener((java.awt.event.ActionListener) this);
		b2.addActionListener((java.awt.event.ActionListener) this);
		b3.addActionListener((java.awt.event.ActionListener) this);
		b4.addActionListener((java.awt.event.ActionListener) this);
		b5.addActionListener((java.awt.event.ActionListener) this);
		b6.addActionListener((java.awt.event.ActionListener) this);
		b7.addActionListener((java.awt.event.ActionListener) this);
		b8.addActionListener((java.awt.event.ActionListener) this);
		b9.addActionListener((java.awt.event.ActionListener) this);
		b10.addActionListener((java.awt.event.ActionListener) this);
		b11.addActionListener((java.awt.event.ActionListener) this);
		b12.addActionListener((java.awt.event.ActionListener) this);
		b13.addActionListener((java.awt.event.ActionListener) this);
		b14.addActionListener((java.awt.event.ActionListener) this);
		b15.addActionListener((java.awt.event.ActionListener) this);
		b16.addActionListener((java.awt.event.ActionListener) this);

		JPanel panel = new JPanel();

		// creando el panel para los botones internos
		panel.setLayout(new GridLayout(8,2,5,10));	
		
		panel.add(b1);
		panel.add(b2);
		panel.add(b3);
		panel.add(b4);
		panel.add(b5);
		panel.add(b6);
		panel.add(b7);
		panel.add(b8);
		panel.add(b9);
		panel.add(b10);
		panel.add(b11);
		panel.add(b12);
		panel.add(b13);
		panel.add(b14);
		panel.add(b15);
		panel.add(b16);

		
		frame.add(panel, BorderLayout.CENTER);
		frame.pack();
		

	}

	public void actionPerformed(ActionEvent e) {
		Object E = e.getActionCommand();

		if (E.equals("Cargo")) {
			System.out.println("Cargo");
			//Main.mainInitial("Cargo");

		} else if (E.equals("Acciones")) {
			System.out.println("Categoria Cliente");
			//Main.mainInitial("Categoria Cliente");

		} else if (E.equals("Categoria Clientes")) {
			System.out.println("Rol Registro");
			//Main.mainInitial("Rol Registro");

		} else if (E.equals("Cliente Cabecera")) {
			System.out.println("Tipo Representante Venta");
			//Main.mainInitial("Tipo Representante Venta");

		}else if (E.equals("Cliente Detalle")) {
			System.out.println("Categoria Cliente");
			//Main.mainInitial("Categoria Cliente");

		} else if (E.equals("Historial Apl. Cab")) {
			System.out.println("Rol Registro");
			//Main.mainInitial("Rol Registro");

		} else if (E.equals("Historial Apl. Det")) {
			System.out.println("Tipo Representante Venta");
			//Main.mainInitial("Tipo Representante Venta");

		}else if (E.equals("Rol Registro")) {
			System.out.println("Categoria Cliente");
			//Main.mainInitial("Categoria Cliente");

		} else if (E.equals("Tipo Rep Venta")) {
			System.out.println("Rol Registro");
			//Main.mainInitial("Rol Registro");

		} else if (E.equals("Rep Venta Cabecera")) { //------------
			System.out.println("Tipo Representante Venta");
			//Main.mainInitial("Tipo Representante Venta");

		}else if (E.equals("Rep Venta Detalle")) {
			System.out.println("Categoria Cliente");
			//Main.mainInitial("Categoria Cliente");

		} else if (E.equals("Usuariob Reg Detalle")) {
			System.out.println("Rol Registro");
			//Main.mainInitial("Rol Registro");

		} else if (E.equals("Oficina Detalle")) {
			System.out.println("Tipo Representante Venta");
			//Main.mainInitial("Tipo Representante Venta");

		}else if (E.equals("Oficina Factura")) {
			System.out.println("Categoria Cliente");
			//Main.mainInitial("Categoria Cliente");

		} else if (E.equals("Producto Cabecera")) {
			System.out.println("Rol Registro");
			//Main.mainInitial("Rol Registro");

		} else if (E.equals("Producto Detalle")) {
			System.out.println("Tipo Representante Venta");
			//Main.mainInitial("Tipo Representante Venta");
		}
	}

	// CARGO -------------------------------------
	public static void generateContent_Cargo() {
		VistaCargo vi = new VistaCargo();
		frame.add(vi.getContent());
		ControladorCargo con = new ControladorCargo(vi);

	}

	// ACCIONES -------------------------------------
	public static void generateContent_Acciones() {

	}

	// CATEGORIA CLIENTES -------------------------------------
	public static void generateContent_CatCli() {
		VistaCategoriaCliente vi = new VistaCategoriaCliente();
		frame.add(vi.getContent());
		ControladorCategoriaCliente con = new ControladorCategoriaCliente(vi);
	}

	// CLIENTE CABECERA -------------------------------------
	public static void generateContent_CliCab() {

	}

	// CLIENTE DETALLE -------------------------------------
	public static void generateContent_CliDet() {

	}

	// HISTORIAL APLICATIVO CABECERA -------------------------------------
	public static void generateContent_HisApliCab() {

	}

	// HISTORIAL APLICATIVO DETALLE -------------------------------------
	public static void generateContent_HisApliDet() {

	}

	// ROL REGISTRO -------------------------------------
	public static void generateContent_RolReg() {
		VistaRolRegistro vi = new VistaRolRegistro();
		frame.add(vi.getContent());
		ControladorRolRegistro con = new ControladorRolRegistro(vi);
	}

	// TIPO REPRESENTANTE VENTA -------------------------------------
	public static void generateContent_TipRepVen() {
		VistaTipoRepresentanteVenta vi = new VistaTipoRepresentanteVenta();
		frame.add(vi.getContent());
		ControladorTipoRepresentanteVenta con = new ControladorTipoRepresentanteVenta(vi);

	}

	// REPRESENTANTE VENTAS CABECERA -------------------------------------
	public static void generateContent_RepVenCab() {

	}

	// REPRESENTANTE VENTA DETALLE --------------------------------------
	public static void generateContent_RepVenDet() {

	}

	// USUARIO REGISTRADO DETALLE -------------------------------------
	public static void generateContent_UsuRegDet() {

	}

	// OFICINA DETALLE -------------------------------------
	public static void generateContent_OfiDet() {

	}

	// OFICINA FACTURA -------------------------------------
	public static void generateContent_OfiFac() {

	}

	// PRODUCTO CABECERA -------------------------------------
	public static void generateContent_ProCab() {

	}

	// PRODUCTO DETALLE -------------------------------------
	public static void generateContent_CliCabecera() {

	}

	public static void main(String[] args) {
	Main j = new Main();		

	}
}
