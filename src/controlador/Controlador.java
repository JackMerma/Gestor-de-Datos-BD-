package src.controlador;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import src.vista.Vista;

public class Controlador implements ActionListener{

	Vista vista = new Vista();

	public Controlador(Vista v){
		this.vista = v;
	}

	public void actionPerformed(ActionEvent e){

	}
}


