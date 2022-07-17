package src.controlador;

import java.awt.event.ActionEvent;
import javax.swing.*;

import src.modelo.RepresentanteVentasCabecera.RepresentanteVentasCabeceraDAO;
import src.modelo.RepresentanteVentasDetalle.RepresentanteVentasDetalle;
import src.modelo.RepresentanteVentasDetalle.RepresentanteVentasDetalleDAO;
import src.modelo.UsuarioRegistrado.UsuarioRegistrado;
import src.modelo.UsuarioRegistrado.UsuarioRegistradoDAO;
import src.vista.VistaRepresentanteVentasDetalle;
import src.vista.VistaUsuarioRegistradoDetalle;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class ControladorRepresentanteVentasDetalle extends Controlador<RepresentanteVentasDetalle> {

	public VistaRepresentanteVentasDetalle vista = (VistaRepresentanteVentasDetalle) vistaSuper;
	public static RepresentanteVentasDetalleDAO classDAO = new RepresentanteVentasDetalleDAO();
	public RepresentanteVentasDetalle ofiDetalle = new RepresentanteVentasDetalle();

	private int CarFlaAct = 0;
	private int action; // 1: agregar,

	// constructor de la clase, se pasan los parametros de la vistaEspecifica
	public ControladorRepresentanteVentasDetalle(VistaRepresentanteVentasDetalle v) {
		super(v, classDAO);
		this.vista = v;
		listar(vista.tabla);
	}

	// metodo auxiliar para obtener un objeto con los datos de la vista
	@Override
	public RepresentanteVentasDetalle getOficinaDetalle() {
		RepresentanteVentasDetalle classInterna = new RepresentanteVentasDetalle();
		String ide = vista.ide.getText();
		String ofiIde = vista.ofiIde.getText();
		String cargIde = vista.cargIde.getText();
		String RolRegIde = vista.RolRegIde.getText();
		String tipIde = vista.tipIde.getText();
		String usuRegIde = vista.usuRegIde.getText();
		String nombre = vista.nombre.getText();
		String edad = vista.edad.getText();
		String con = vista.con.getText();
		String objRep = vista.objRep.getText();
		String estaRegis = vista.estaRegis.getText();
		

		
		// Creamos un objeto
		classInterna.setIde(Integer.parseInt(ide));
		classInterna.setOficinaIde(Integer.parseInt(ofiIde));
		classInterna.setCargoIde(Integer.parseInt(cargIde));
		classInterna.setRolRegistroIde(Integer.parseInt(RolRegIde));
		classInterna.setTipoRepresentanteIde(Integer.parseInt(tipIde));
		classInterna.setUsuarioRegistradoIde(Integer.parseInt(usuRegIde));
		classInterna.setNombre(nombre);
		classInterna.setEdad(Integer.parseInt(edad));
		classInterna.setContrato(con);
		classInterna.setObjetivoRepresentante(objRep);
		classInterna.setEstadoRegistro(estaRegis.charAt(0));

		return classInterna;
	}

	// lista los nuevos datos
	@Override
	public void listar(JTable tabla) {
		centrarCeldas(tabla);
		modelo = (DefaultTableModel) tabla.getModel();
		tabla.setModel(modelo);

		// Tenemos que cambiar esta parte
		ArrayList<RepresentanteVentasDetalle> lista = classDAO.listar();
		Object[] objeto = new Object[11]; // cambiar segun el numero de atributos


		for (int i = 0; i < lista.size(); i++) {
			objeto[0] = lista.get(i).getIde();
			objeto[1] = lista.get(i).getOficinaIde();
			objeto[2] = lista.get(i).getCargoIde();
			objeto[3] = lista.get(i).getRolRegistroIde();
			objeto[4] = lista.get(i).getTipoRepresentanteIde();
			objeto[5] = lista.get(i).getUsuarioRegistradoIde();
			objeto[6] = lista.get(i).getNombre();
			objeto[7] = lista.get(i).getEdad();
			objeto[8] = lista.get(i).getContrato();
			objeto[9] = lista.get(i).getObjetivoRepresentante();
			objeto[10] = lista.get(i).getEstadoRegistro();

			modelo.addRow(objeto);
		}
	}

	// metodo para llenar los campos de la vista, trabaja con la fila 'fila', y el estado de registro, si el estado de registro se quiere matener
	// se pasa 'DEFAULT'
	@Override
	public void llenarDatosDeTablaSelecionada(int fila, String estadoRegistro) {

		String id = (String) vista.tabla.getValueAt(fila, 0).toString();
		String ofiId = (String) vista.tabla.getValueAt(fila, 1).toString();
		String cargId = (String) vista.tabla.getValueAt(fila, 2).toString();
		String RolRegId = (String) vista.tabla.getValueAt(fila, 3).toString();
		String tipId = (String) vista.tabla.getValueAt(fila, 4).toString();
		String usuRegId = (String) vista.tabla.getValueAt(fila, 5).toString();
		String nombre = (String) vista.tabla.getValueAt(fila, 6).toString();
		String edad = (String) vista.tabla.getValueAt(fila, 7).toString();
		String con = (String) vista.tabla.getValueAt(fila, 8).toString();
		String objRep = (String) vista.tabla.getValueAt(fila, 9).toString();
		String estaRegis = (String) vista.tabla.getValueAt(fila, 10).toString();

		vista.ide.setText(id);
		vista.ofiIde.setText(ofiId);
		vista.cargIde.setText(cargId);
		vista.RolRegIde.setText(RolRegId);
		vista.tipIde.setText(tipId);
		vista.usuRegIde.setText(usuRegId);
		vista.nombre.setText(nombre);
		vista.edad.setText(edad);
		vista.con.setText(con);
		vista.objRep.setText(objRep);
		vista.estaRegis.setText(estaRegis);

		if (estadoRegistro.equals("DEFAULT")) {
			vista.estaRegis.setText(estaRegis);
		} else {
			vista.estaRegis.setText(estadoRegistro);
		}

	}

	// limpia la entrada de texto de la vista
	@Override
	public void limpiar() {
		vista.ide.setText("");
		vista.ofiIde.setText("");
		vista.cargIde.setText("");
		vista.RolRegIde.setText("");
		vista.tipIde.setText("");
		vista.usuRegIde.setText("");
		vista.nombre.setText("");
		vista.edad.setText("");
		vista.con.setText("");
		vista.objRep.setText("");
		vista.estaRegis.setText("");

		vista.ide.setEditable(true);
		vista.ofiIde.setEditable(true);
		vista.cargIde.setEditable(true);
		vista.RolRegIde.setEditable(true);
		vista.tipIde.setEditable(true);
		vista.usuRegIde.setEditable(true);
		vista.nombre.setEditable(true);
		vista.edad.setEditable(true);
		vista.con.setEditable(true);
		vista.objRep.setEditable(true);
		vista.estaRegis.setEditable(true);
	}

	// Metodo para las acciones
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

				// se tiene que cambiar estas partes (casi en todas es igual xd)
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
				vista.ofiIde.setEditable(false);
				vista.cargIde.setEditable(false);
				vista.RolRegIde.setEditable(false);
				vista.tipIde.setEditable(false);
				vista.usuRegIde.setEditable(false);
				vista.nombre.setEditable(false);
				vista.edad.setEditable(false);
				vista.con.setEditable(false);
				vista.objRep.setEditable(false);
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
				vista.ofiIde.setEditable(false);
				vista.cargIde.setEditable(false);
				vista.RolRegIde.setEditable(false);
				vista.tipIde.setEditable(false);
				vista.usuRegIde.setEditable(false);
				vista.nombre.setEditable(false);
				vista.edad.setEditable(false);
				vista.con.setEditable(false);
				vista.objRep.setEditable(false);
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
				vista.ofiIde.setEditable(false);
				vista.cargIde.setEditable(false);
				vista.RolRegIde.setEditable(false);
				vista.tipIde.setEditable(false);
				vista.usuRegIde.setEditable(false);
				vista.nombre.setEditable(false);
				vista.edad.setEditable(false);
				vista.con.setEditable(false);
				vista.objRep.setEditable(false);
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

}
