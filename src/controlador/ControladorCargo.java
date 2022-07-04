package src.controlador;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.util.*;
import java.awt.*;
import javax.swing.*;

import src.modelo.Cargo;
import src.modelo.CargoDAO;
import src.vista.VistaCargo;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import java.util.ArrayList;

public class ControladorCargo implements ActionListener{

	public VistaCargo vista = new VistaCargo();
	public CargoDAO catclidao = new CargoDAO();
	public Cargo catcli = new Cargo();
	DefaultTableModel modelo = new DefaultTableModel();

	private int CarFlaAct = 0;
	private int action; // 1: agregar, 

	// constructor
	public ControladorCargo(VistaCargo v){
		this.vista = v;
		vista.adicionar.addActionListener(this);
		vista.modificar.addActionListener(this);
		vista.eliminar.addActionListener(this);
		vista.cancelar.addActionListener(this);
		vista.inactivar.addActionListener(this);
		vista.reactivar.addActionListener(this);
		vista.actualizar.addActionListener(this);
		vista.salir.addActionListener(this);
		listar(vista.tabla);
	}

	// metodo que agrera a una nueva categoria
	private void agregar(){
		
		// Obtenemos datos
		String ide = vista.ide.getText();
		String desc = vista.descripcion.getText();
		String sueldo = vista.sueldo.getText();
		String esta = vista.estaRegis.getText();

		// Creamos un objeto
		catcli.setIde(Integer.parseInt(ide));
		catcli.setDescripcionCargo(desc);
		catcli.setSueldo(Integer.parseInt(sueldo));
		catcli.setEstadoRegistro(esta.charAt(0));
		
		// limpiamos la tabla anterior
		limpiarTabla();
		
		// agregamos 
		int n = catclidao.add(catcli);

		// verificamor resultado
		if (n == 1) {
			JOptionPane.showMessageDialog(null, "Agregado con Exito.");
		} else {
			JOptionPane.showMessageDialog(null, "Error");
		}
		
		// limpiamor entrada de texto
		limpiar();

		// listamor nueva tabla
		listar(vista.tabla);
	}

	// Para modificar una categoria
	private void modificar(){
		// Obtenemos datos
		String ide = vista.ide.getText();
		String desc = vista.descripcion.getText();
		String sueldo = vista.sueldo.getText();
		String esta = vista.estaRegis.getText();

		// Creamos un objeto
		catcli.setIde(Integer.parseInt(ide));
		catcli.setDescripcionCargo(desc);
		catcli.setSueldo(Integer.parseInt(sueldo));
		catcli.setEstadoRegistro(esta.charAt(0));

		// limpiamos la tabla anterior
		limpiarTabla();
		
		// agregamos 
		int n = catclidao.modificar(catcli);

		// verificamor resultado
		if (n == 1) {
			JOptionPane.showMessageDialog(null, "Modificado con Exito.");
		} else {
			JOptionPane.showMessageDialog(null, "Error");
		}
		
		// limpiamor entrada de texto
		limpiar();

		// listamor nueva tabla
		listar(vista.tabla);
	}

	// Para eliminar una categoria
	private void eliminar(){
		// Obtenemos datos
		String ide = vista.ide.getText();
		String limi = vista.limCredito.getText();
		String esta = vista.estaRegis.getText();

		// Creamos un objeto
		catcli.setIde(Integer.parseInt(ide));
		catcli.setLimCredito(Integer.parseInt(limi));
		catcli.setEstadoRegistro(esta.charAt(0));

		// limpiamos la tabla anterior
		limpiarTabla();
		
		// agregamos 
		int n = catclidao.modificar(catcli);

		// verificamor resultado
		if (n == 1) {
			JOptionPane.showMessageDialog(null, "Usuario Eliminado con Exito.");
		} else {
			JOptionPane.showMessageDialog(null, "Error");
		}
		
		// limpiamor entrada de texto
		limpiar();

		// listamor nueva tabla
		listar(vista.tabla);
	}

	// Para inavilitar una categoria
	private void inavilitar(){
		// Obtenemos datos
		String ide = vista.ide.getText();
		String limi = vista.limCredito.getText();
		String esta = vista.estaRegis.getText();

		// Creamos un objeto
		catcli.setIde(Integer.parseInt(ide));
		catcli.setLimCredito(Integer.parseInt(limi));
		catcli.setEstadoRegistro(esta.charAt(0));

		// limpiamos la tabla anterior
		limpiarTabla();
		
		// agregamos 
		int n = catclidao.modificar(catcli);

		// verificamor resultado
		if (n == 1) {
			JOptionPane.showMessageDialog(null, "Usuario Inavilitado con Exito.");
		} else {
			JOptionPane.showMessageDialog(null, "Error");
		}
		
		// limpiamor entrada de texto
		limpiar();

		// listamor nueva tabla
		listar(vista.tabla);
	}

	
	// Para reactivar una categoria
	private void reactivar(){
		// Obtenemos datos
		String ide = vista.ide.getText();
		String limi = vista.limCredito.getText();
		String esta = vista.estaRegis.getText();

		// Creamos un objeto
		catcli.setIde(Integer.parseInt(ide));
		catcli.setLimCredito(Integer.parseInt(limi));
		catcli.setEstadoRegistro(esta.charAt(0));

		// limpiamos la tabla anterior
		limpiarTabla();
		
		// agregamos 
		int n = catclidao.modificar(catcli);

		// verificamor resultado
		if (n == 1) {
			JOptionPane.showMessageDialog(null, "Usuario Reavilitado con Exito.");
		} else {
			JOptionPane.showMessageDialog(null, "Error");
		}
		
		// limpiamor entrada de texto
		limpiar();

		// listamor nueva tabla
		listar(vista.tabla);
	}	

	// lista los nuevos datos
	public void listar(JTable tabla) {
        centrarCeldas(tabla);
        modelo = (DefaultTableModel) tabla.getModel();
        tabla.setModel(modelo);
		ArrayList<CategoriaCliente> lista = catclidao.listar();
        Object[] objeto = new Object[3];
        for (int i = 0; i < lista.size(); i++) {
            objeto[0] = lista.get(i).getIde();
            objeto[1] = lista.get(i).getLimCredito();
            objeto[2] = lista.get(i).getEstadoRegistro();
            modelo.addRow(objeto);
        }

    }




	public void actionPerformed(ActionEvent e){
		if(e.getSource() == vista.adicionar){
			System.out.println("Apreto: adicionar");
			//limpiar();
			vista.estaRegis.setText("A");
			vista.estaRegis.setEditable(false);

			CarFlaAct = 1;
			action=1;
			


		}else if(e.getSource() == vista.modificar){
			System.out.println("Apreto: modificar");
			int fila = vista.tabla.getSelectedRow();
            if (fila == -1) {
                JOptionPane.showMessageDialog(null, "Debe Seleccionar Una fila..!!");
            } else {
                String id = (String) vista.tabla.getValueAt(fila, 0).toString();
                String limete = (String) vista.tabla.getValueAt(fila, 1).toString();
                String estado = (String) vista.tabla.getValueAt(fila, 2).toString();

				vista.ide.setText(id);
                vista.limCredito.setText(limete);
                vista.estaRegis.setText(estado);

				vista.ide.setEditable(false);
				vista.estaRegis.setEditable(false);

				CarFlaAct = 1;
				action = 2;
				
            }

		}else if(e.getSource() == vista.eliminar){
			System.out.println("Apreto: eliminar");

			int fila = vista.tabla.getSelectedRow();
            if (fila == -1) {
                JOptionPane.showMessageDialog(null, "Debe Seleccionar Una fila..!!");
            } else {
                String id = (String) vista.tabla.getValueAt(fila, 0).toString();
                String limete = (String) vista.tabla.getValueAt(fila, 1).toString();
                String estado = (String) vista.tabla.getValueAt(fila, 2).toString();

				vista.ide.setText(id);
                vista.limCredito.setText(limete);
                vista.estaRegis.setText("*");

				vista.ide.setEditable(false);
				vista.limCredito.setEditable(false);
				vista.estaRegis.setEditable(false);

				CarFlaAct = 1;
				action = 3;
				
            }
		}else if(e.getSource() == vista.cancelar){
			System.out.println("Apreto: cancelar");
			CarFlaAct=0;
			limpiar();

		}else if(e.getSource() == vista.inactivar){
			System.out.println("Apreto: inactivar");

			int fila = vista.tabla.getSelectedRow();
            if (fila == -1) {
                JOptionPane.showMessageDialog(null, "Debe Seleccionar Una fila..!!");
            } else {
                String id = (String) vista.tabla.getValueAt(fila, 0).toString();
                String limete = (String) vista.tabla.getValueAt(fila, 1).toString();
                String estado = (String) vista.tabla.getValueAt(fila, 2).toString();

				vista.ide.setText(id);
                vista.limCredito.setText(limete);
                vista.estaRegis.setText("I");

				vista.ide.setEditable(false);
				vista.limCredito.setEditable(false);
				vista.estaRegis.setEditable(false);

				CarFlaAct = 1;
				action = 4;
				
            }
		}else if(e.getSource() == vista.reactivar){
			System.out.println("Apreto: reactivar");

			int fila = vista.tabla.getSelectedRow();
            if (fila == -1) {
                JOptionPane.showMessageDialog(null, "Debe Seleccionar Una fila..!!");
            } else {
                String id = (String) vista.tabla.getValueAt(fila, 0).toString();
                String limete = (String) vista.tabla.getValueAt(fila, 1).toString();
                String estado = (String) vista.tabla.getValueAt(fila, 2).toString();

				vista.ide.setText(id);
                vista.limCredito.setText(limete);
                vista.estaRegis.setText("A");

				vista.ide.setEditable(false);
				vista.limCredito.setEditable(false);
				vista.estaRegis.setEditable(false);

				CarFlaAct = 1;
				action = 5;
				
            }
		}else if(e.getSource() == vista.actualizar){
			System.out.println("Apreto: actualizar");
			if(CarFlaAct==1){
				if (JOptionPane.showConfirmDialog(null, "Está seguro que desea realizar esta acción", "WARNING",
				JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					System.out.println("Afecta a la bd");

					if(action==1){ //Agregar
						agregar();
					}else if(action == 2){ //Modificar
						modificar();
					}else if(action == 3){ //Eliminar
						eliminar();
					}else if(action == 4){ //Inavilitar
						inavilitar();
					}else if(action == 5){ //Reactivar
						reactivar();
					}

					CarFlaAct=0;	
				}				
		
			}else{
				JOptionPane.showMessageDialog(null, "Opción no es válida","Alerta",JOptionPane.WARNING_MESSAGE);
			}
		}else if(e.getSource() == vista.salir){
			System.out.println("Apreto: salir ");
			System.exit(0);
 
		}
	}
	// limpia la entrada de texto
	private void limpiar(){
		vista.ide.setText("");
		vista.limCredito.setText("");
		vista.estaRegis.setText("");
		vista.ide.setEditable(true);
		vista.limCredito.setEditable(true);
		vista.estaRegis.setEditable(true);
		
	}

	// limpia la tabla
	void limpiarTabla() {
		for (int i = 0; i < vista.tabla.getRowCount(); i++) {
			modelo.removeRow(i);
			i = i - 1;
		}
	}

	// centra los numeros
	void centrarCeldas(JTable tabla) {
		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
		tcr.setHorizontalAlignment(SwingConstants.CENTER);
		for (int i = 0; i < vista.tabla.getColumnCount(); i++) {
			tabla.getColumnModel().getColumn(i).setCellRenderer(tcr);
		}
	}
}
