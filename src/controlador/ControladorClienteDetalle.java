package src.controlador;

import java.awt.event.ActionEvent;
import javax.swing.*;
import src.modelo.ClienteDetalle.ClienteDetalle;
import src.modelo.ClienteDetalle.ClienteDetalleDAO;
import src.vista.VistaClienteDetalle;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class ControladorClienteDetalle extends Controlador<ClienteDetalle> {

	public VistaClienteDetalle vista = (VistaClienteDetalle) vistaSuper;
	public static ClienteDetalleDAO clienteDetalleDAO = new ClienteDetalleDAO();

	private int CarFlaAct = 0;
	private int action; // 1: agregar,

	// constructor de la clase, se pasan los parametros de la vistaEspecifica
	public ControladorClienteDetalle(VistaClienteDetalle v) {
		super(v, clienteDetalleDAO);
		this.vista = v;
		listar(vista.tabla);
	}

	// metodo auxiliar para obtener un objeto con los datos de la vista
	@Override
	public ClienteDetalle getOficinaDetalle() {
		ClienteDetalle classInterna = new ClienteDetalle();
		String ide = vista.ide.getText();
		String ideCategoria = vista.ideCategoria.getText();
		String empDesc = vista.empDesc.getText();
		String numEmple = vista.numEmple.getText();
		String pagoCuo = vista.pagoCuo.getText();
		String credito = vista.credito.getText();
		String departamento = vista.departamento.getText();
		String nombre = vista.nombre.getText();
		String comportamiento = vista.comportamiento.getText();
		String apellPaterno = vista.apellPaterno.getText();
		String apellMaterno = vista.apellMaterno.getText();
		String direccion = vista.direccion.getText();
		String telefono = vista.telefono.getText();
		String correo = vista.correo.getText();
		String estaRegis = vista.estaRegis.getText();

		// Creamos un objeto
		classInterna.setIde(Integer.parseInt(ide));
		classInterna.setIdeCategoria(Integer.parseInt(ideCategoria));
		classInterna.setEmpDescripcion(empDesc);
		classInterna.setNumEmpleado(Integer.parseInt(numEmple));
		classInterna.setPagoCuota(pagoCuo);
		classInterna.setCredito(Integer.parseInt(credito));
		classInterna.setDepartamento(departamento);
		classInterna.setNombre(nombre);
		classInterna.setComportamiento(comportamiento);
		classInterna.setApellidoPaterno(apellPaterno);
		classInterna.setApellidoMaterno(apellMaterno);
		classInterna.setDireccion(direccion);
		classInterna.setTelefono(Integer.parseInt(telefono));
		classInterna.setCorreo(correo);
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
		ArrayList<ClienteDetalle> lista = clienteDetalleDAO.listar();
		Object[] objeto = new Object[15]; // cambiar segun el numero de atributos


		for (int i = 0; i < lista.size(); i++) {
			objeto[0] = lista.get(i).getIde();
			objeto[1] = lista.get(i).getIdeCategoria();
			objeto[2] = lista.get(i).getEmpDescripcion();
			objeto[3] = lista.get(i).getNumEmpleado();
			objeto[4] = lista.get(i).getPagoCuota();
			objeto[5] = lista.get(i).getCredito();
			objeto[6] = lista.get(i).getDepartamento();
			objeto[7] = lista.get(i).getNombre();
			objeto[8] = lista.get(i).getComportamiento();
			objeto[9] = lista.get(i).getApellidoPaterno();
			objeto[10] = lista.get(i).getApellidoMaterno();
			objeto[11] = lista.get(i).getDireccion();
			objeto[12] = lista.get(i).getTelefono();
			objeto[13] = lista.get(i).getCorreo();
			objeto[14] = lista.get(i).getEstadoRegistro();
			modelo.addRow(objeto);
		}
	}

	// metodo para llenar los campos de la vista, trabaja con la fila 'fila', y el estado de registro, si el estado de registro se quiere matener
	// se pasa 'DEFAULT'
	@Override
	public void llenarDatosDeTablaSelecionada(int fila, String estadoRegistro) {

		String ide = (String) vista.tabla.getValueAt(fila, 0).toString();
		String ideCategoria = (String) vista.tabla.getValueAt(fila, 1).toString();
		String empDesc = (String) vista.tabla.getValueAt(fila, 2).toString();
		String numEmple = (String) vista.tabla.getValueAt(fila, 3).toString();
		String pagoCuo = (String) vista.tabla.getValueAt(fila, 4).toString();
		String credito = (String) vista.tabla.getValueAt(fila, 5).toString();
		String departamento = (String) vista.tabla.getValueAt(fila, 6).toString();
		String nombre = (String) vista.tabla.getValueAt(fila, 7).toString();
		String comportamiento = (String) vista.tabla.getValueAt(fila, 8).toString();
		String apellPaterno = (String) vista.tabla.getValueAt(fila, 9).toString();
		String apellMaterno = (String) vista.tabla.getValueAt(fila, 10).toString();
		String direccion = (String) vista.tabla.getValueAt(fila, 11).toString();
		String telefono = (String) vista.tabla.getValueAt(fila, 12).toString();
		String correo = (String) vista.tabla.getValueAt(fila, 13).toString();
		String estareg = (String) vista.tabla.getValueAt(fila, 14).toString();

		vista.ide.setText(ide);
		vista.ideCategoria.setText(ideCategoria);
		vista.empDesc.setText(empDesc);
		vista.numEmple.setText(numEmple);
		vista.pagoCuo.setText(pagoCuo);
		vista.credito.setText(credito);
		vista.departamento.setText(departamento);
		vista.nombre.setText(nombre);
		vista.comportamiento.setText(comportamiento);
		vista.apellPaterno.setText(apellPaterno);
		vista.apellMaterno.setText(apellMaterno);
		vista.direccion.setText(direccion);
		vista.telefono.setText(telefono);
		vista.correo.setText(telefono);
		vista.estaRegis.setText(estareg);

		if (estadoRegistro.equals("DEFAULT")) {
			vista.estaRegis.setText(estareg);
		} else {
			vista.estaRegis.setText(estadoRegistro);
		}
	}

	// limpia la entrada de texto de la vista
	@Override
	public void limpiar() {
		vista.ide.setText("");
		vista.ideCategoria.setText("");
		vista.empDesc.setText("");
		vista.numEmple.setText("");
		vista.pagoCuo.setText("");
		vista.credito.setText("");
		vista.departamento.setText("");
		vista.nombre.setText("");
		vista.comportamiento.setText("");
		vista.apellPaterno.setText("");
		vista.apellMaterno.setText("");
		vista.direccion.setText("");
		vista.telefono.setText("");
		vista.correo.setText("");
		vista.estaRegis.setText("");

		vista.ide.setEditable(true);
		vista.ideCategoria.setEditable(true);
		vista.empDesc.setEditable(true);
		vista.numEmple.setEditable(true);
		vista.pagoCuo.setEditable(true);
		vista.credito.setEditable(true);
		vista.departamento.setEditable(true);
		vista.nombre.setEditable(true);
		vista.comportamiento.setEditable(true);
		vista.apellPaterno.setEditable(true);
		vista.apellMaterno.setEditable(true);
		vista.direccion.setEditable(true);
		vista.telefono.setEditable(true);
		vista.correo.setEditable(true);
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
				vista.ideCategoria.setEditable(false);
				vista.empDesc.setEditable(false);
				vista.numEmple.setEditable(false);
				vista.pagoCuo.setEditable(false);
				vista.credito.setEditable(false);
				vista.departamento.setEditable(false);
				vista.nombre.setEditable(false);
				vista.comportamiento.setEditable(false);
				vista.apellPaterno.setEditable(false);
				vista.apellMaterno.setEditable(false);
				vista.direccion.setEditable(false);
				vista.telefono.setEditable(false);
				vista.correo.setEditable(false);
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
				vista.ideCategoria.setEditable(false);
				vista.empDesc.setEditable(false);
				vista.numEmple.setEditable(false);
				vista.pagoCuo.setEditable(false);
				vista.credito.setEditable(false);
				vista.departamento.setEditable(false);
				vista.nombre.setEditable(false);
				vista.comportamiento.setEditable(false);
				vista.apellPaterno.setEditable(false);
				vista.apellMaterno.setEditable(false);
				vista.direccion.setEditable(false);
				vista.telefono.setEditable(false);
				vista.correo.setEditable(false);
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
				vista.ideCategoria.setEditable(false);
				vista.empDesc.setEditable(false);
				vista.numEmple.setEditable(false);
				vista.pagoCuo.setEditable(false);
				vista.credito.setEditable(false);
				vista.departamento.setEditable(false);
				vista.nombre.setEditable(false);
				vista.comportamiento.setEditable(false);
				vista.apellPaterno.setEditable(false);
				vista.apellMaterno.setEditable(false);
				vista.direccion.setEditable(false);
				vista.telefono.setEditable(false);
				vista.correo.setEditable(false);
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

