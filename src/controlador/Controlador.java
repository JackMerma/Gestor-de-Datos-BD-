package src.controlador;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;

import src.modelo.DAO;
import src.modelo.OficinaDetalle.OficinaDetalle;
import src.vista.Vista;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;


public abstract class Controlador implements ActionListener {

    public String DEFAULT = "DEFAULT";
    public Vista vista;
    public DAO classDAO;
    public OficinaDetalle ofiDetalle = new OficinaDetalle();
    DefaultTableModel modelo = new DefaultTableModel();

    private int CarFlaAct = 0;
    private int action; // 1: agregar,

    // constructor
    public Controlador(Vista v) {
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

    // metodo auxiliar para obtener un objeto con los datos de la vista
    public abstract OficinaDetalle getClassNormaLSegunVista(); 
    // {
        // OficinaDetalle ofide = new OficinaDetalle();
        // String ide = vista.ide.getText();
        // String ciudad = vista.ciudad.getText();
        // String region = vista.region.getText();
        // String direccion = vista.direccion.getText();
        // String empleado = vista.empleado.getText();
        // String objetivo = vista.objetivo.getText();
        // String ventas = vista.ventas.getText();
        // String estaRegis = vista.estaRegis.getText();

        // // Creamos un objeto
        // ofide.setOfiIde(Integer.parseInt(ide));
        // ofide.setOfiCiu(ciudad);
        // ofide.setOfiReg(region);
        // ofide.setOfiDir(direccion);
        // ofide.setOfiEmp(empleado);
        // ofide.setOfiObj(Integer.parseInt(objetivo));
        // ofide.setOfiVen(ventas);
        // ofide.setOfiEstReg(estaRegis);

        // return ofide;
    // }

    // metodo que agrera a una nueva categoria
    private void agregar() {

        // Obtenemos datos

        ofiDetalle = getClassNormaLSegunVista();

        // limpiamos la tabla anterior
        limpiarTabla();

        // agregamos
        int n = classDAO.add(ofiDetalle);

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
    private void modificar() {

        // Obtenemos datos

        ofiDetalle = getClassNormaLSegunVista();

        // limpiamos la tabla anterior
        limpiarTabla();

        // Modificamos
        int n = classDAO.modificar(ofiDetalle);

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
    private void eliminar() {
        // Obtenemos datos

        ofiDetalle = getClassNormaLSegunVista();

        // limpiamos la tabla anterior
        limpiarTabla();

        // Modificamos
        int n = classDAO.modificar(ofiDetalle);

        // verificamor resultado
        if (n == 1) {
            JOptionPane.showMessageDialog(null, "Eliminado con Exito.");
        } else {
            JOptionPane.showMessageDialog(null, "Error");
        }

        // limpiamor entrada de texto
        limpiar();

        // listamor nueva tabla
        listar(vista.tabla);
    }

    // Para inavilitar una categoria
    private void inavilitar() {
        // Obtenemos datos

        ofiDetalle = getClassNormaLSegunVista();

        // limpiamos la tabla anterior
        limpiarTabla();

        // Modificamos
        int n = classDAO.modificar(ofiDetalle);

        // verificamor resultado
        if (n == 1) {
            JOptionPane.showMessageDialog(null, "Inavilitado con Exito.");
        } else {
            JOptionPane.showMessageDialog(null, "Error");
        }

        // limpiamor entrada de texto
        limpiar();

        // listamor nueva tabla
        listar(vista.tabla);
    }

    // Para reactivar una categoria
    private void reactivar() {
        // Obtenemos datos

        ofiDetalle = getClassNormaLSegunVista();

        // limpiamos la tabla anterior
        limpiarTabla();

        // Modificamos
        int n = classDAO.modificar(ofiDetalle);

        // verificamor resultado
        if (n == 1) {
            JOptionPane.showMessageDialog(null, "Reavilitado con Exito.");
        } else {
            JOptionPane.showMessageDialog(null, "Error");
        }

        // limpiamor entrada de texto
        limpiar();

        // listamor nueva tabla
        listar(vista.tabla);
    }

    // lista los nuevos datos
    public abstract void listar(JTable tabla); 
    // {
    //     centrarCeldas(tabla);
    //     modelo = (DefaultTableModel) tabla.getModel();
    //     tabla.setModel(modelo);

    //     ArrayList<OficinaDetalle> lista = oficinaDetalleDAO.listar();
    //     Object[] objeto = new Object[8];

    //     for (int i = 0; i < lista.size(); i++) {
    //         objeto[0] = lista.get(i).getOfiIde();
    //         objeto[1] = lista.get(i).getOfiCiu();
    //         objeto[2] = lista.get(i).getOfiReg();
    //         objeto[3] = lista.get(i).getOfiDir();
    //         objeto[4] = lista.get(i).getOfiEmp();
    //         objeto[5] = lista.get(i).getOfiObj();
    //         objeto[6] = lista.get(i).getOfiVen();
    //         objeto[7] = lista.get(i).getOfiEstReg();
    //         modelo.addRow(objeto);
    //     }
    // }

    // metodo para llenar en actionPerformed
    public abstract void llenarDatosDeTablaSelecionada(int fila, String estadoRegistro);
    // {

    //     String id = (String) vista.tabla.getValueAt(fila, 0).toString();
    //     String ciudad = (String) vista.tabla.getValueAt(fila, 1).toString();
    //     String region = (String) vista.tabla.getValueAt(fila, 2).toString();
    //     String direccion = (String) vista.tabla.getValueAt(fila, 3).toString();
    //     String empleado = (String) vista.tabla.getValueAt(fila, 4).toString();
    //     String objetivo = (String) vista.tabla.getValueAt(fila, 5).toString();
    //     String ventas = (String) vista.tabla.getValueAt(fila, 6).toString();
    //     String estareg = (String) vista.tabla.getValueAt(fila, 7).toString();

    //     vista.ide.setText(id);
    //     vista.ciudad.setText(ciudad);
    //     vista.region.setText(region);
    //     vista.direccion.setText(direccion);
    //     vista.empleado.setText(empleado);
    //     vista.objetivo.setText(objetivo);
    //     vista.ventas.setText(ventas);

    //     if (estadoRegistro.equals(DEFAULT)) {
    //         vista.estaRegis.setText(estareg);
    //     } else {
    //         vista.estaRegis.setText(estadoRegistro);
    //     }

    // }


    public abstract void actionPerformed(ActionEvent e);
    // {
    //     if (e.getSource() == vista.adicionar) {
    //         System.out.println("Apreto: adicionar");
    //         // limpiar();
    //         vista.estaRegis.setText("A");
    //         vista.estaRegis.setEditable(false);

    //         CarFlaAct = 1;
    //         action = 1;

    //     } else if (e.getSource() == vista.modificar) {
    //         System.out.println("Apreto: modificar");
    //         int fila = vista.tabla.getSelectedRow();

    //         if (fila == -1) {
    //             JOptionPane.showMessageDialog(null, "Debe Seleccionar Una fila..!!");
    //         } else {

    //             llenarDatosDeTablaSelecionada(fila, "DEFAULT");

    //             // String id = (String) vista.tabla.getValueAt(fila, 0).toString();
    //             // String descCarg = (String) vista.tabla.getValueAt(fila, 1).toString();
    //             // String sueldo = (String) vista.tabla.getValueAt(fila, 2).toString();
    //             // String estado = (String) vista.tabla.getValueAt(fila, 3).toString();

    //             // vista.ide.setText(id);
    //             // vista.descripcion.setText(descCarg);
    //             // vista.sueldo.setText(sueldo);
    //             // vista.estaRegis.setText(estado);

    //             vista.ide.setEditable(false);
    //             vista.estaRegis.setEditable(false);

    //             CarFlaAct = 1;
    //             action = 2;

    //         }

    //     } else if (e.getSource() == vista.eliminar) {
    //         System.out.println("Apreto: eliminar");

    //         int fila = vista.tabla.getSelectedRow();
    //         if (fila == -1) {
    //             JOptionPane.showMessageDialog(null, "Debe Seleccionar Una fila..!!");
    //         } else {

    //             llenarDatosDeTablaSelecionada(fila, "*");
    //             // String id = (String) vista.tabla.getValueAt(fila, 0).toString();
    //             // String descCarg = (String) vista.tabla.getValueAt(fila, 1).toString();
    //             // String sueldo = (String) vista.tabla.getValueAt(fila, 2).toString();
    //             // String estado = (String) vista.tabla.getValueAt(fila, 3).toString();

    //             // vista.ide.setText(id);
    //             // vista.descripcion.setText(descCarg);
    //             // vista.sueldo.setText(sueldo);
    //             // vista.estaRegis.setText("*");

    //             vista.ide.setEditable(false);
    //             vista.ciudad.setEditable(false);
    //             vista.region.setEditable(false);
    //             vista.direccion.setEditable(false);
    //             vista.empleado.setEditable(false);
    //             vista.objetivo.setEditable(false);
    //             vista.ventas.setEditable(false);
    //             vista.estaRegis.setEditable(false);

    //             CarFlaAct = 1;
    //             action = 3;

    //         }
    //     } else if (e.getSource() == vista.cancelar) {
    //         System.out.println("Apreto: cancelar");
    //         CarFlaAct = 0;
    //         limpiar();

    //     } else if (e.getSource() == vista.inactivar) {
    //         System.out.println("Apreto: inactivar");

    //         int fila = vista.tabla.getSelectedRow();
    //         if (fila == -1) {
    //             JOptionPane.showMessageDialog(null, "Debe Seleccionar Una fila..!!");
    //         } else {

    //             llenarDatosDeTablaSelecionada(fila, "I");

    //             // String id = (String) vista.tabla.getValueAt(fila, 0).toString();
    //             // String descCarg = (String) vista.tabla.getValueAt(fila, 1).toString();
    //             // String sueldo = (String) vista.tabla.getValueAt(fila, 2).toString();
    //             // String estado = (String) vista.tabla.getValueAt(fila, 3).toString();

    //             // vista.ide.setText(id);
    //             // vista.descripcion.setText(descCarg);
    //             // vista.sueldo.setText(sueldo);
    //             // vista.estaRegis.setText("I");

    //             vista.ide.setEditable(false);
    //             vista.ciudad.setEditable(false);
    //             vista.region.setEditable(false);
    //             vista.direccion.setEditable(false);
    //             vista.empleado.setEditable(false);
    //             vista.objetivo.setEditable(false);
    //             vista.ventas.setEditable(false);
    //             vista.estaRegis.setEditable(false);

    //             CarFlaAct = 1;
    //             action = 4;

    //         }
    //     } else if (e.getSource() == vista.reactivar) {
    //         System.out.println("Apreto: reactivar");

    //         int fila = vista.tabla.getSelectedRow();
    //         if (fila == -1) {
    //             JOptionPane.showMessageDialog(null, "Debe Seleccionar Una fila..!!");
    //         } else {

    //             llenarDatosDeTablaSelecionada(fila, "A");

    //             // String id = (String) vista.tabla.getValueAt(fila, 0).toString();
    //             // String descCarg = (String) vista.tabla.getValueAt(fila, 1).toString();
    //             // String sueldo = (String) vista.tabla.getValueAt(fila, 2).toString();
    //             // String estado = (String) vista.tabla.getValueAt(fila, 3).toString();

    //             // vista.ide.setText(id);
    //             // vista.descripcion.setText(descCarg);
    //             // vista.sueldo.setText(sueldo);
    //             // vista.estaRegis.setText("A");

    //             vista.ide.setEditable(false);
    //             vista.ciudad.setEditable(false);
    //             vista.region.setEditable(false);
    //             vista.direccion.setEditable(false);
    //             vista.empleado.setEditable(false);
    //             vista.objetivo.setEditable(false);
    //             vista.ventas.setEditable(false);
    //             vista.estaRegis.setEditable(false);

    //             CarFlaAct = 1;
    //             action = 5;

    //         }
    //     } else if (e.getSource() == vista.actualizar) {
    //         System.out.println("Apreto: actualizar");
    //         if (CarFlaAct == 1) {
    //             if (JOptionPane.showConfirmDialog(null, "Está seguro que desea realizar esta acción", "WARNING",
    //                     JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
    //                 System.out.println("Afecta a la bd");

    //                 if (action == 1) { // Agregar
    //                     agregar();
    //                 } else if (action == 2) { // Modificar
    //                     modificar();
    //                 } else if (action == 3) { // Eliminar
    //                     eliminar();
    //                 } else if (action == 4) { // Inavilitar
    //                     inavilitar();
    //                 } else if (action == 5) { // Reactivar
    //                     reactivar();
    //                 }

    //                 CarFlaAct = 0;
    //             }

    //         } else {
    //             JOptionPane.showMessageDialog(null, "Opción no es válida", "Alerta", JOptionPane.WARNING_MESSAGE);
    //         }
    //     } else if (e.getSource() == vista.salir) {
    //         System.out.println("Apreto: salir ");
    //         System.exit(0);

    //     }
    // }

    // limpia la entrada de texto
    public abstract void limpiar(); 
    // {
    //     vista.ide.setText("");
    //     vista.ciudad.setText("");
    //     vista.region.setText("");
    //     vista.direccion.setText("");
    //     vista.empleado.setText("");
    //     vista.objetivo.setText("");
    //     vista.ventas.setText("");
    //     vista.estaRegis.setText("");

    //     vista.ide.setEditable(true);
    //     vista.ciudad.setEditable(true);
    //     vista.region.setEditable(true);
    //     vista.direccion.setEditable(true);
    //     vista.empleado.setEditable(true);
    //     vista.objetivo.setEditable(true);
    //     vista.ventas.setEditable(true);
    //     vista.estaRegis.setEditable(true);
    // }

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