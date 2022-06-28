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

		}else if(e.getSource() == vista.modificar){

		}else if(e.getSource() == vista.eliminar){

		}else if(e.getSource() == vista.cancelar){

		}else if(e.getSource() == vista.inactivar){

		}else if(e.getSource() == vista.reactivar){

		}else if(e.getSource() == vista.actualizar){

		}else if(e.getSource() == vista.salir){

		}
	}
}
