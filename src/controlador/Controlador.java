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
