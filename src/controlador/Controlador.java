package src.controlador;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.util.*;
import java.awt.*;
import javax.swing.*;

import src.modelo.CategoriaCliente;
import src.modelo.CategoriaClienteDAO;
import src.vista.Vista;

import java.util.ArrayList;

public class Controlador implements ActionListener{

	public Vista vista = new Vista();
	public CategoriaClienteDAO catclidao = new CategoriaClienteDAO();
	public CategoriaCliente catcli = new CategoriaCliente();

	private int CarFlaAct = 0;
	public Controlador(Vista v){
		this.vista = v;
		vista.adicionar.addActionListener(this);
		vista.modificar.addActionListener(this);
		vista.eliminar.addActionListener(this);
		vista.cancelar.addActionListener(this);
		vista.inactivar.addActionListener(this);
		vista.reactivar.addActionListener(this);
		vista.actualizar.addActionListener(this);
		vista.salir.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e){
		if(e.getSource() == vista.adicionar){
			System.out.println("Apreto: adicionar");
			limpiar();
			vista.estaRegis.setText("A");
			vista.estaRegis.setEditable(false);

			CarFlaAct = 1;


		}else if(e.getSource() == vista.modificar){
			System.out.println("Apreto: modificar");

		}else if(e.getSource() == vista.eliminar){
			System.out.println("Apreto: eliminar");

		}else if(e.getSource() == vista.cancelar){
			System.out.println("Apreto: cancelar");
			CarFlaAct=0;
			limpiar();

		}else if(e.getSource() == vista.inactivar){
			System.out.println("Apreto: inactivar");

		}else if(e.getSource() == vista.reactivar){
			System.out.println("Apreto: reactivar");

		}else if(e.getSource() == vista.actualizar){
			System.out.println("Apreto: actualizar");
			if(CarFlaAct==1){
				if (JOptionPane.showConfirmDialog(null, "Está seguro que desea realizar esta acción", "WARNING",
				JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					System.out.println("Afecta a la bd");
					CarFlaAct=0;	
				}				
		
			}else{
				JOptionPane.showMessageDialog(null, "Opción no es válida","Alerta",JOptionPane.WARNING_MESSAGE);
			}
		}else if(e.getSource() == vista.salir){
			System.out.println("Apreto: salir ");

 
		}
	}

	private void limpiar(){
		vista.ide.setText("");
		vista.limCredito.setText("");
		vista.estaRegis.setText("");
		vista.ide.setEditable(true);
		vista.limCredito.setEditable(true);
		vista.estaRegis.setEditable(true);
		
	}
}
