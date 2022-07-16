package src.controlador;

import java.awt.event.ActionListener;
import javax.swing.*;
import src.vista.Vista;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public abstract class Controlador implements ActionListener {

    public Vista vistaSuper;
    // public OficinaDetalleDAO oficinaDetalleDAO = new OficinaDetalleDAO();
    // public OficinaDetalle ofiDetalle = new OficinaDetalle();
    DefaultTableModel modelo = new DefaultTableModel();

    // Contructor
    public Controlador(Vista v) {
        vistaSuper = v;
        vistaSuper.adicionar.addActionListener(this);
        vistaSuper.modificar.addActionListener(this);
        vistaSuper.eliminar.addActionListener(this);
        vistaSuper.cancelar.addActionListener(this);
        vistaSuper.inactivar.addActionListener(this);
        vistaSuper.reactivar.addActionListener(this);
        vistaSuper.actualizar.addActionListener(this);
        vistaSuper.salir.addActionListener(this);
    }

    // limpia la tabla
    public void limpiarTabla() {
        for (int i = 0; i < vistaSuper.tabla.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i - 1;
        }
    }

    // centra los numeros
    public void centrarCeldas(JTable tabla) {
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < vistaSuper.tabla.getColumnCount(); i++) {
            tabla.getColumnModel().getColumn(i).setCellRenderer(tcr);
        }
    }
}
