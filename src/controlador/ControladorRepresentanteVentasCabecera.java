package src.controlador;

import java.awt.event.ActionEvent;
import javax.swing.*;

import src.modelo.RepresentanteVentasCabecera.RepresentanteVentasCabecera;
import src.modelo.RepresentanteVentasCabecera.RepresentanteVentasCabeceraDAO;
import src.vista.VistaRepresentanteVentasCabecera;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class ControladorRepresentanteVentasCabecera extends Controlador<RepresentanteVentasCabecera> {

    public VistaRepresentanteVentasCabecera vista = (VistaRepresentanteVentasCabecera) vistaSuper;
    public static RepresentanteVentasCabeceraDAO classDAO = new RepresentanteVentasCabeceraDAO();
    public RepresentanteVentasCabecera ofiDetalle = new RepresentanteVentasCabecera();

    private int CarFlaAct = 0;
    private int action; // 1: agregar,

    // constructor de la clase, se pasan los parametros de la vistaEspecifica
    public ControladorRepresentanteVentasCabecera(VistaRepresentanteVentasCabecera v) {
        super(v, classDAO);
        this.vista = v;
        listar(vista.tabla);
    }

    // metodo auxiliar para obtener un objeto con los datos de la vista
    @Override
    public RepresentanteVentasCabecera getOficinaDetalle() {
        RepresentanteVentasCabecera classInterna = new RepresentanteVentasCabecera();

        String factIde = vista.factIde.getText();
        String repIde = vista.repIde.getText();
        String estaRegis = vista.estaRegis.getText();

        // Creamos un objeto

        classInterna.setIde(Integer.parseInt(factIde));
        classInterna.setRepIde(Integer.parseInt(repIde));
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
        ArrayList<RepresentanteVentasCabecera> lista = classDAO.listar();
        Object[] objeto = new Object[3]; // cambiar segun el numero de atributos

        for (int i = 0; i < lista.size(); i++) {

            objeto[0] = lista.get(i).getIde();
            objeto[1] = lista.get(i).getRepIde();
            objeto[2] = lista.get(i).getEstadoRegistro();

            modelo.addRow(objeto);
        }
    }

    // metodo para llenar los campos de la vista, trabaja con la fila 'fila', y el
    // estado de registro, si el estado de registro se quiere matener
    // se pasa 'DEFAULT'
    @Override
    public void llenarDatosDeTablaSelecionada(int fila, String estadoRegistro) {

        String id = (String) vista.tabla.getValueAt(fila, 0).toString();
        String repIde = (String) vista.tabla.getValueAt(fila, 1).toString();
        String estaRegis = (String) vista.tabla.getValueAt(fila, 2).toString();


        vista.factIde.setText(id);
        vista.repIde.setText(repIde);
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

        vista.factIde.setText("");
        vista.repIde.setText("");
        vista.estaRegis.setText("");

        vista.factIde.setEditable(true);
        vista.repIde.setEditable(true);
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
                vista.factIde.setEditable(false);
                vista.repIde.setEditable(false);
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

                vista.factIde.setEditable(false);
                vista.repIde.setEditable(false);
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

                vista.factIde.setEditable(false);
                vista.repIde.setEditable(false);
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

                vista.factIde.setEditable(false);
                vista.repIde.setEditable(false);
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
