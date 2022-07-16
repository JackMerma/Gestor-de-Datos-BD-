package src.vista;

import java.awt.*;
import javax.swing.*;

public class VistaProductoCabecera extends Vista {
    // add Panel
    public JTextField facIde;
    public JTextField proIde;
    public JTextField detCan;

    public VistaProductoCabecera() {
        super("PRODUCTO CABECERA", new String[] { "FacIde", "ProIde", "DetCan" });
    }

    @Override
    public void createAddPanelContent() {

        JPanel addPanelContent = new JPanel(new BorderLayout());

        JPanel addPanelContentContent = new JPanel(new GridLayout(3, 1, 5, 10));

        // instaciomos Atributos
        facIde = new JTextField(20);
        proIde = new JTextField(20);
        detCan = new JTextField(20);
        
        // factIde

        JPanel facIdePanel = addComponente(facIde, "Factura Ide:");

        // proIde

        JPanel proIdePanel = addComponente(proIde, "Producto Ide:");

        // detCan

        JPanel detCanPanel = addComponente(detCan, "Detalle Cantidad:");

        
        // agregando paneles
        addPanelContentContent.add(facIdePanel);
        addPanelContentContent.add(proIdePanel);
        addPanelContentContent.add(detCanPanel);
        
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
