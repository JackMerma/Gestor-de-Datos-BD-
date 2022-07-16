package src.vista;

import java.awt.*;
import javax.swing.*;

public class VistaRepresentanteVentasDetalle extends Vista {
    // add Panel
    public JTextField ide;
    public JTextField ofiIde;
    public JTextField cargIde;
    public JTextField RolRegIde;
    public JTextField tipIde;
    public JTextField usuRegIde;
    public JTextField nombre;
    public JTextField edad;
    public JTextField con;
    public JTextField objRep;

    public VistaRepresentanteVentasDetalle() {
        super("REPRESENTANTE VENTAS DETALLE", new String[] { "Ide", "OfiIde", "CargIde", "RolRegIde", "TipIde",
                "UsuRegIde", "Nombre", "Edad", "Con", "ObjRep" });
    }

    @Override
    public void createAddPanelContent() {
       
        JPanel addPanelContent = new JPanel(new BorderLayout());

        JPanel addPanelContentContent = new JPanel(new GridLayout(10, 1, 0, 0));

        // instaciomos Atributos
        ide = new JTextField(20);
        ofiIde = new JTextField(20);
        cargIde = new JTextField(20);
        RolRegIde = new JTextField(20);
        tipIde = new JTextField(20);
        usuRegIde = new JTextField(20);
        nombre = new JTextField(20);
        edad = new JTextField(20);
        con = new JTextField(20);
        objRep = new JTextField(20);

        // ide

        JPanel idePanel = addComponente(ide, "Ide:");

         // ofiIde

         JPanel ofiIdePanel = addComponente(ofiIde, "OfiIde:");

        // carIde

        JPanel carIdePanel = addComponente(cargIde, "CargIde:");

        // rolRegIde

        JPanel rolRegIdePanel = addComponente(RolRegIde, "RolRegIde:");

        // tipIde

        JPanel tipIdePanel = addComponente(tipIde, "TipIde:");

        // usuRegIde

        JPanel usuRegIdePanel = addComponente(usuRegIde, "UsuRegIde:");

        // nombre

        JPanel nombrePanel = addComponente(nombre, "Nombre:");

        // edad

        JPanel edadPanel = addComponente(edad, "Edad:");

        // con

        JPanel conPanel = addComponente(con, "Contraseña:");
        
        // objRep

        JPanel objRepPanel = addComponente(objRep, "ObjRep:");

        // agregando paneles
        addPanelContentContent.add(idePanel);
        addPanelContentContent.add(ofiIdePanel);
        addPanelContentContent.add(carIdePanel);
        addPanelContentContent.add(rolRegIdePanel);
        addPanelContentContent.add(tipIdePanel);
        addPanelContentContent.add(usuRegIdePanel);
        addPanelContentContent.add(nombrePanel);
        addPanelContentContent.add(rolRegIdePanel);
        addPanelContentContent.add(edadPanel);
        addPanelContentContent.add(conPanel);
        addPanelContentContent.add(objRepPanel);

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