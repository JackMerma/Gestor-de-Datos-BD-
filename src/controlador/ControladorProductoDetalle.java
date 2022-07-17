package src.controlador;

import java.awt.event.ActionEvent;
import javax.swing.*;

import src.modelo.ProductoDetalle.ProductoDetalle;
import src.modelo.ProductoDetalle.ProductoDetalleDAO;
import src.modelo.RepresentanteVentasCabecera.RepresentanteVentasCabeceraDAO;
import src.modelo.RepresentanteVentasDetalle.RepresentanteVentasDetalle;
import src.modelo.RepresentanteVentasDetalle.RepresentanteVentasDetalleDAO;
import src.modelo.UsuarioRegistrado.UsuarioRegistrado;
import src.modelo.UsuarioRegistrado.UsuarioRegistradoDAO;
import src.vista.VistaProductoDetalle;
import src.vista.VistaRepresentanteVentasDetalle;
import src.vista.VistaUsuarioRegistradoDetalle;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class ControladorProductoDetalle extends Controlador<ProductoDetalle> {

    public VistaProductoDetalle vista = (VistaProductoDetalle) vistaSuper;
    public static ProductoDetalleDAO classDAO = new ProductoDetalleDAO();
    public ProductoDetalle ofiDetalle = new ProductoDetalle();

    private int CarFlaAct = 0;
    private int action; // 1: agregar,

    // constructor de la clase, se pasan los parametros de la vistaEspecifica
    public ControladorProductoDetalle(VistaProductoDetalle v) {
        super(v, classDAO);
        this.vista = v;
        listar(vista.tabla);
    }

    // metodo auxiliar para obtener un objeto con los datos de la vista
    @Override
    public ProductoDetalle getOficinaDetalle() {
        ProductoDetalle classInterna = new ProductoDetalle();
        String ide = vista.ide.getText();
        String fab = vista.fab.getText();
        String des = vista.des.getText();
        String precio = vista.precio.getText();
        String exi = vista.exi.getText();
        String claseABC = vista.claseABC.getText();
        String unidad = vista.unidad.getText();
        String stockAct = vista.stockAct.getText();
        String stockMin = vista.stockMin.getText();
        String stockMax = vista.stockMax.getText();
        String estaRegis = vista.estaRegis.getText();

        // Creamos un objeto
        classInterna.setIde(Integer.parseInt(ide));
        classInterna.setFabricante(fab);
        classInterna.setDescripcion(des);
        classInterna.setPrecio(Double.parseDouble(precio));
        classInterna.setExistencia(Integer.parseInt(exi));
        classInterna.setClaseABC(claseABC);
        classInterna.setUnidadMedida(unidad);
        classInterna.setStockActual(Integer.parseInt(stockAct));
        classInterna.setStockMinimo(Integer.parseInt(stockMin));
        classInterna.setStockMaximo(Integer.parseInt(stockMax));
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
        ArrayList<ProductoDetalle> lista = classDAO.listar();
        Object[] objeto = new Object[11]; // cambiar segun el numero de atributos

        for (int i = 0; i < lista.size(); i++) {
            objeto[0] = lista.get(i).getIde();
            objeto[1] = lista.get(i).getFabricante();
            objeto[2] = lista.get(i).getDescripcion();
            objeto[3] = lista.get(i).getPrecio();
            objeto[4] = lista.get(i).getExistencia();
            objeto[5] = lista.get(i).getClaseABC();
            objeto[6] = lista.get(i).getUnidadMedida();
            objeto[7] = lista.get(i).getStockActual();
            objeto[8] = lista.get(i).getStockMinimo();
            objeto[9] = lista.get(i).getStockMaximo();
            objeto[10] = lista.get(i).getEstadoRegistro();

            modelo.addRow(objeto);
        }
    }

    // metodo para llenar los campos de la vista, trabaja con la fila 'fila', y el
    // estado de registro, si el estado de registro se quiere matener
    // se pasa 'DEFAULT'
    @Override
    public void llenarDatosDeTablaSelecionada(int fila, String estadoRegistro) {

        String id = (String) vista.tabla.getValueAt(fila, 0).toString();
        String fab = (String) vista.tabla.getValueAt(fila, 1).toString();
        String des = (String) vista.tabla.getValueAt(fila, 2).toString();
        String precio = (String) vista.tabla.getValueAt(fila, 3).toString();
        String exi = (String) vista.tabla.getValueAt(fila, 4).toString();
        String claseABC = (String) vista.tabla.getValueAt(fila, 5).toString();
        String unidad = (String) vista.tabla.getValueAt(fila, 6).toString();
        String stockAct = (String) vista.tabla.getValueAt(fila, 7).toString();
        String stockMin = (String) vista.tabla.getValueAt(fila, 8).toString();
        String stockMax = (String) vista.tabla.getValueAt(fila, 9).toString();
        String estaRegis = (String) vista.tabla.getValueAt(fila, 10).toString();

        vista.ide.setText(id);
        vista.fab.setText(fab);
        vista.des.setText(des);
        vista.precio.setText(precio);
        vista.exi.setText(exi);
        vista.claseABC.setText(claseABC);
        vista.unidad.setText(unidad);
        vista.stockAct.setText(stockAct);
        vista.stockMin.setText(stockMin);
        vista.stockMax.setText(stockMax);
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
        vista.fab.setText("");
        vista.des.setText("");
        vista.precio.setText("");
        vista.exi.setText("");
        vista.claseABC.setText("");
        vista.unidad.setText("");
        vista.stockAct.setText("");
        vista.stockMin.setText("");
        vista.stockMax.setText("");
        vista.estaRegis.setText("");

        vista.ide.setEditable(true);
        vista.fab.setEditable(true);
        vista.des.setEditable(true);
        vista.precio.setEditable(true);
        vista.exi.setEditable(true);
        vista.claseABC.setEditable(true);
        vista.unidad.setEditable(true);
        vista.stockAct.setEditable(true);
        vista.stockMin.setEditable(true);
        vista.stockMax.setEditable(true);
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
                vista.fab.setEditable(false);
                vista.des.setEditable(false);
                vista.precio.setEditable(false);
                vista.exi.setEditable(false);
                vista.claseABC.setEditable(false);
                vista.unidad.setEditable(false);
                vista.stockAct.setEditable(false);
                vista.stockMin.setEditable(false);
                vista.stockMax.setEditable(false);
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
                vista.fab.setEditable(false);
                vista.des.setEditable(false);
                vista.precio.setEditable(false);
                vista.exi.setEditable(false);
                vista.claseABC.setEditable(false);
                vista.unidad.setEditable(false);
                vista.stockAct.setEditable(false);
                vista.stockMin.setEditable(false);
                vista.stockMax.setEditable(false);
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
                vista.fab.setEditable(false);
                vista.des.setEditable(false);
                vista.precio.setEditable(false);
                vista.exi.setEditable(false);
                vista.claseABC.setEditable(false);
                vista.unidad.setEditable(false);
                vista.stockAct.setEditable(false);
                vista.stockMin.setEditable(false);
                vista.stockMax.setEditable(false);
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
