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
		vista.b.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e){
		if(e.getSource() == vista.b){
			ArrayList<CategoriaCliente> dat = catclidao.listar();
			//no hace nada
		}
	}
}


