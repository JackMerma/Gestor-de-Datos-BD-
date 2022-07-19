package src.controlador;

import java.awt.event.ActionEvent;

import javax.swing.*;

import src.modelo.RolRegistro.RolRegistro;
import src.modelo.RolRegistro.RolRegistroDAO;
import src.vista.VistaRolRegistro;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import java.util.ArrayList;

public class ControladorRolRegistro extends Controlador<RolRegistro> {

	public VistaRolRegistro vista = (VistaRolRegistro) vistaSuper;
	public static RolRegistroDAO oficinaDetalleDAO = new RolRegistroDAO();
	public RolRegistro ofiDetalle = new RolRegistro();

	private int CarFlaAct = 0;
	private int action; // 1: agregar,

	// constructor
	public ControladorRolRegistro(VistaRolRegistro v) {
		super(v, oficinaDetalleDAO);
		this.vista = v;
		listar(vista.tabla);
	}

	// metodo auxiliar para obtener un objeto con los datos de la vista
	@Override
	public RolRegistro getOficinaDetalle() {
		RolRegistro car = new RolRegistro();
		String ide = vista.ide.getText();
		String rolDesc = vista.rolDesc.getText();
		String estaRegis = vista.estaRegis.getText();

		// Creamos un objeto
		car.setIde(Integer.parseInt(ide));
		car.setDescripcionRol(rolDesc);
		car.setEstadoRegistro(estaRegis.charAt(0));

		return car;
	}

	// lista los nuevos datos
	@Override
	public void listar(JTable tabla) {
		centrarCeldas(tabla);
		modelo = (DefaultTableModel) tabla.getModel();
		tabla.setModel(modelo);

		ArrayList<RolRegistro> lista = oficinaDetalleDAO.listar();
		Object[] objeto = new Object[3];

		for (int i = 0; i < lista.size(); i++) {
			objeto[0] = lista.get(i).getIde();
			objeto[1] = lista.get(i).getDescripcionRol();
			objeto[2] = lista.get(i).getEstadoRegistro();

			modelo.addRow(objeto);
		}
	}

	// metodo para llenar en actionPerformed
	@Override
	public void llenarDatosDeTablaSelecionada(int fila, String estadoRegistro) {

		String id = (String) vista.tabla.getValueAt(fila, 0).toString();
		String rolDesc = (String) vista.tabla.getValueAt(fila, 1).toString();
		String estaRegis = (String) vista.tabla.getValueAt(fila, 2).toString();


		vista.ide.setText(id);
		vista.rolDesc.setText(rolDesc);
		vista.estaRegis.setText(estaRegis);


		if (estadoRegistro.equals("DEFAULT")) {
			vista.estaRegis.setText(estaRegis);
		} else {
			vista.estaRegis.setText(estadoRegistro);
		}

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == vista.adicionar) {
			System.out.println("Apreto: adicionar");
			// limpiar();
			vista.estaRegis.setText("A");
			vista.estaRegis.setEditable(false);

			CarFlaAct = 1;
			action = 1;

		} else if (e.getSource() == vista.modificar) {
			System.out.println("Apreto: modificar");
			int fila = vista.tabla.getSelectedRow();

			if (fila == -1) {
				JOptionPane.showMessageDialog(null, "Debe Seleccionar Una fila..!!");
			} else {

				llenarDatosDeTablaSelecionada(fila, "DEFAULT");

				vista.ide.setEditable(false);
				vista.estaRegis.setEditable(false);

				CarFlaAct = 1;
				action = 2;

			}

		} else if (e.getSource() == vista.eliminar) {
			System.out.println("Apreto: eliminar");

			int fila = vista.tabla.getSelectedRow();
			if (fila == -1) {
				JOptionPane.showMessageDialog(null, "Debe Seleccionar Una fila..!!");
			} else {

				llenarDatosDeTablaSelecionada(fila, "*");

				vista.ide.setEditable(false);
				vista.rolDesc.setEditable(false);
				vista.estaRegis.setEditable(false);

				CarFlaAct = 1;
				action = 3;

			}
		} else if (e.getSource() == vista.cancelar) {
			System.out.println("Apreto: cancelar");
			CarFlaAct = 0;
			limpiar();

		} else if (e.getSource() == vista.inactivar) {
			System.out.println("Apreto: inactivar");

			int fila = vista.tabla.getSelectedRow();
			if (fila == -1) {
				JOptionPane.showMessageDialog(null, "Debe Seleccionar Una fila..!!");
			} else {

				llenarDatosDeTablaSelecionada(fila, "I");

				vista.ide.setEditable(false);
				vista.rolDesc.setEditable(false);
				vista.estaRegis.setEditable(false);

				CarFlaAct = 1;
				action = 4;

			}
		} else if (e.getSource() == vista.reactivar) {
			System.out.println("Apreto: reactivar");

			int fila = vista.tabla.getSelectedRow();
			if (fila == -1) {
				JOptionPane.showMessageDialog(null, "Debe Seleccionar Una fila..!!");
			} else {

				llenarDatosDeTablaSelecionada(fila, "A");

				vista.ide.setEditable(false);
				vista.rolDesc.setEditable(false);
				vista.estaRegis.setEditable(false);

				CarFlaAct = 1;
				action = 5;

			}
		} else if (e.getSource() == vista.actualizar) {
			System.out.println("Apreto: actualizar");
			if (CarFlaAct == 1) {
				if (JOptionPane.showConfirmDialog(null, "Está seguro que desea realizar esta acción", "WARNING",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					System.out.println("Afecta a la bd");

					if (action == 1) { // Agregar
						agregar();
					} else if (action == 2) { // Modificar
						modificar();
					} else if (action == 3) { // Eliminar
						eliminar();
					} else if (action == 4) { // Inavilitar
						inavilitar();
					} else if (action == 5) { // Reactivar
						reactivar();
					}

					CarFlaAct = 0;
				}

			} else {
				JOptionPane.showMessageDialog(null, "Opción no es válida", "Alerta", JOptionPane.WARNING_MESSAGE);
			}
		} else if (e.getSource() == vista.salir) {
			System.out.println("Apreto: salir ");
			System.exit(0);

		}
	}

	// limpia la entrada de texto
	@Override
	public void limpiar() {
		vista.ide.setText("");
		vista.rolDesc.setText("");
		vista.estaRegis.setText("");

		vista.ide.setEditable(true);
		vista.rolDesc.setEditable(true);
		vista.estaRegis.setEditable(true);

	}

}
