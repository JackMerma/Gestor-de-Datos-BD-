package src.vista;

import java.awt.*;
import javax.swing.*;

public class VistaProductoDetalle extends Vista {
    // add Panel
    public JTextField ide;
    public JTextField fab;
    public JTextField des;
    public JTextField precio;
    public JTextField exi;
    public JTextField claseABC;
    public JTextField unidad;
    public JTextField stockAct;
    public JTextField stockMin;
    public JTextField stockMax;
    public JTextField estaRegis;


    public VistaProductoDetalle() {
        super("PRODUCTO DETALLE", new String[] { "Ide", "Fabricacion", "Descripcion", "Precio", "Exi", "ClaseABC",
                "Unidad", "StockAct", "StockMin", "StockMax", "EstadoRegistro" });
    }

    @Override
    public void createAddPanelContent() {

        JPanel addPanelContent = new JPanel(new BorderLayout());

        JPanel addPanelContentContent = new JPanel(new GridLayout(5, 1, 0, 0));

        // instaciomos Atributos
        ide = new JTextField(10);
        fab = new JTextField(10);
        des = new JTextField(10);
        precio = new JTextField(10);
        exi = new JTextField(10);
        claseABC = new JTextField(10);
        unidad = new JTextField(10);
        stockAct = new JTextField(10);
        stockMin = new JTextField(10);
        stockMax = new JTextField(10);
        estaRegis = new JTextField("", 5);


        // ide

        JPanel idePanel = addComponente(ide, "Ide:");

        // fabricacion

        JPanel fabPanel = addComponente(fab, "Fabricacion:");

        // descripcion

        JPanel desPanel = addComponente(des, "Descripcion:");

        // precio

        JPanel precioPanel = addComponente(precio, "Precio:");

        // exi

        JPanel exiPanel = addComponente(exi, "Exi:");

        // claseABC

        JPanel claseABCPanel = addComponente(claseABC, "ClaseABC:");

        // unidad

        JPanel unidadPanel = addComponente(unidad, "Unidad:");

        // stockAct

        JPanel stockActPanel = addComponente(stockAct, "Stock Act.:");

        // stockMin

        JPanel stockMinPanel = addComponente(stockMin, "Stock Min:");

        // stockMax

        JPanel stockMaxPanel = addComponente(stockMax, "Stock Max:");

        // estaRegis field
        JPanel estaRegisPanel = addComponente(estaRegis, "Estado Registro:");

        // agregando paneles
        addPanelContentContent.add(idePanel);
        addPanelContentContent.add(fabPanel);
        addPanelContentContent.add(desPanel);
        addPanelContentContent.add(precioPanel);
        addPanelContentContent.add(exiPanel);
        addPanelContentContent.add(claseABCPanel);
        addPanelContentContent.add(unidadPanel);
        addPanelContentContent.add(stockActPanel);
        addPanelContentContent.add(stockMinPanel);
        addPanelContentContent.add(stockMaxPanel);
        addPanelContentContent.add(estaRegisPanel);
        

        createPanelWidth(addPanelContent, true, true, true, true);
        addPanelContent.add(addPanelContentContent);
        addPanel.add(addPanelContent);
    }

    private JPanel addComponente(JTextField txtField, String name) {
        JPanel panel = new JPanel(new GridLayout(1, 2));
        JLabel label = new JLabel(name);
        label.setHorizontalAlignment(JLabel.CENTER);

        panel.add(label);

        JPanel buttonPanel = new JPanel(new FlowLayout());

        buttonPanel.add(txtField);
        panel.add(buttonPanel);
        return panel;
    }

}