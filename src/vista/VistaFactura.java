package src.vista;

import java.awt.*;
import javax.swing.*;

public class VistaFactura extends Vista {
    // add Panel
    public JTextField ide;
    public JTextField imp;
    public JTextField anio;
    public JTextField mes;
    public JTextField dia;

    public VistaFactura() {
        super("FACTURA", new String[] { "Ide", "Imp", "Anio", "Mes", "Dia" });
    }

    @Override
    public void createAddPanelContent() {

        JPanel addPanelContent = new JPanel(new BorderLayout());

        JPanel addPanelContentContent = new JPanel(new GridLayout(5, 1, 5, 10));

        // instaciomos Atributos
        ide = new JTextField(20);
        imp = new JTextField(20);
        anio = new JTextField(20);
        mes = new JTextField(20);
        dia = new JTextField(20);

        // ide field

        JPanel idePanel = addComponente(ide, "Ide:");

        // imp

        JPanel impPanel = addComponente(imp, "Imp:");

        // anio

        JPanel anioPanel = addComponente(anio, "Año:");

        // mes

        JPanel mesPanel = addComponente(mes, "Mes:");
        
        // dia

        JPanel diaPanel = addComponente(dia, "Dia:");

        // agregando paneles
        addPanelContentContent.add(idePanel);
        addPanelContentContent.add(impPanel);
        addPanelContentContent.add(anioPanel);
        addPanelContentContent.add(mesPanel);
        addPanelContentContent.add(diaPanel);

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
