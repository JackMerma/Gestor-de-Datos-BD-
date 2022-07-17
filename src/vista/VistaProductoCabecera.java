package src.vista;

import java.awt.*;
import javax.swing.*;

public class VistaProductoCabecera extends Vista {
    // add Panel
    public JTextField facIde;
    public JTextField proIde;
    public JTextField detCan;
    public JTextField estaRegis;


    public VistaProductoCabecera() {
        super("V1Z_PRODUCTO_CABECERA", new String[] { "FacIde", "ProIde", "DetCan" , "EstaRegis" });
    }

    @Override
    public void createAddPanelContent() {

        JPanel addPanelContent = new JPanel(new BorderLayout());

        JPanel addPanelContentContent = new JPanel(new GridLayout(3, 1, 5, 10));

        // instaciomos Atributos
        facIde = new JTextField(20);
        proIde = new JTextField(20);
        detCan = new JTextField(20);
        estaRegis = new JTextField("", 5);

        
        // factIde

        JPanel facIdePanel = addComponente(facIde, "Factura Ide:");

        // proIde

        JPanel proIdePanel = addComponente(proIde, "Producto Ide:");

        // detCan

        JPanel detCanPanel = addComponente(detCan, "Detalle Cantidad:");

        // estaRegis field
        JPanel estaRegisPanel = addComponente(estaRegis, "Estado de registro:");

        
        // agregando paneles
        addPanelContentContent.add(facIdePanel);
        addPanelContentContent.add(proIdePanel);
        addPanelContentContent.add(detCanPanel);
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
