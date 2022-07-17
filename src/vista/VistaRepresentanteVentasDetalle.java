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
    public JTextField estaRegis;


    public VistaRepresentanteVentasDetalle() {
        super("V1M_REPRESENTANTE_VENTAS_DETALLE", new String[] { "Ide", "OfiIde", "CargIde", "RolRegIde", "TipIde",
                "UsuRegIde", "Nombre", "Edad", "Con", "ObjRep", "EstadoRegistro" });
    }

    @Override
    public void createAddPanelContent() {

        JPanel addPanelContent = new JPanel(new BorderLayout());

        JPanel addPanelContentContent = new JPanel(new GridLayout(5, 1, 0, 0));

        // instaciomos Atributos
        ide = new JTextField(10);
        ofiIde = new JTextField(10);
        cargIde = new JTextField(10);
        RolRegIde = new JTextField(10);
        tipIde = new JTextField(10);
        usuRegIde = new JTextField(10);
        nombre = new JTextField(10);
        edad = new JTextField(10);
        con = new JTextField(10);
        objRep = new JTextField(10);
        estaRegis = new JTextField("", 5);


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

        // estaRegis field
        JPanel estaRegisPanel = addComponente(estaRegis, "Estado de registro:");

        // agregando paneles
        addPanelContentContent.add(idePanel);
        addPanelContentContent.add(ofiIdePanel);
        addPanelContentContent.add(carIdePanel);
        addPanelContentContent.add(rolRegIdePanel);
        addPanelContentContent.add(tipIdePanel);
        addPanelContentContent.add(usuRegIdePanel);
        addPanelContentContent.add(nombrePanel);        
        addPanelContentContent.add(edadPanel);
        addPanelContentContent.add(conPanel);
        addPanelContentContent.add(objRepPanel);
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