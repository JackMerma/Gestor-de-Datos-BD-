package src.controlador;

import java.awt.event.ActionEvent;
import javax.swing.*;
import src.modelo.Acciones.Acciones;
import src.modelo.Acciones.AccionesDAO;
import src.vista.VistaAcciones;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class ControladorAcciones extends Controlador<Acciones> {

    public VistaAcciones vista = (VistaAcciones) vistaSuper;
    public static AccionesDAO classDAO = new AccionesDAO();
    public Acciones ofiDetalle = new Acciones();

    private int CarFlaAct = 0;
    private int action; // 1: agregar,

    // constructor de la clase, se pasan los parametros de la vistaEspecifica
    public ControladorAcciones(VistaAcciones v) {
        super(v, classDAO);
        this.vista = v;
        listar(vista.tabla);
    }

    // metodo auxiliar para obtener un objeto con los datos de la vista
    @Override
    public Acciones getOficinaDetalle() {
        Acciones classInterna = new Acciones();

        String factIde = vista.ide.getText();
        String ideHistoria = vista.ideHistoria.getText();
        String estaRegis = vista.estaRegis.getText();

        // Creamos un objeto

        classInterna.setIde(Integer.parseInt(factIde));
        classInterna.setIdeHistoria(Integer.parseInt(ideHistoria));
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
        ArrayList<Acciones> lista = classDAO.listar();
        Object[] objeto = new Object[3]; // cambiar segun el numero de atributos

        for (int i = 0; i < lista.size(); i++) {

            objeto[0] = lista.get(i).getIde();
            objeto[1] = lista.get(i).getIdeHistoria();
            objeto[2] = lista.get(i).getEstadoRegistro();

            modelo.addRow(objeto);
        }
    }

    // metodo para llenar los campos de la vista, trabaja con la fila 'fila', y el
    // estado de registro, si el estado de registro se quiere matener
    // se pasa 'DEFAULT'
    @Override
    public void llenarDatosDeTablaSelecionada(int fila, String estadoRegistro) {

		String ide = (String) vista.tabla.getValueAt(fila, 0).toString();
        String ideHistoria = (String) vista.tabla.getValueAt(fila, 1).toString();
        String estaRegis = (String) vista.tabla.getValueAt(fila, 2).toString();

        vista.ide.setText(ide);
        vista.ideHistoria.setText(ideHistoria);
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
        vista.ideHistoria.setText("");
        vista.estaRegis.setText("");

        vista.ide.setEditable(true);
        vista.ideHistoria.setEditable(true);
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
                vista.ideHistoria.setEditable(false);
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
                vista.ideHistoria.setEditable(false);
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
                vista.ideHistoria.setEditable(false);
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
                vista.ideHistoria.setEditable(false);
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
