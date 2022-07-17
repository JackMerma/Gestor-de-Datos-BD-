package src.vista;

import java.awt.*;
import javax.swing.*;

public class VistaUsuarioRegistradoDetalle extends Vista {
    // add Panel
    public JTextField ide;
    public JTextField usuario;
    public JTextField contrasenia; 
    public JTextField estaRegis;
 

    public VistaUsuarioRegistradoDetalle() {
        super("V4M_USUARIO_REGISTRADOS_DETALLE", new String[] { "Ide", "Usuario", "Contraseña", "EstadoRegistro" });
    }

    @Override
    public void createAddPanelContent() {
        
        JPanel addPanelContent = new JPanel(new BorderLayout());

        JPanel addPanelContentContent = new JPanel(new GridLayout(3, 1, 5, 10));

        // instaciomos Atributos
        ide = new JTextField(20);
        usuario = new JTextField(20);
        contrasenia = new JTextField(20);   
        estaRegis = new JTextField("", 20);
     

        // ide

        JPanel idePanel = addComponente(ide, "Ide:");

        // Usuario

        JPanel usuarioPanel = addComponente(usuario, "Usuario:");

        // contraseña

        JPanel contraseniaPanel = addComponente(contrasenia, "Contraseña:");

        // estaRegis field
        JPanel estaRegisPanel = addComponente(estaRegis, "Estado de registro:");


        // agregando paneles
        addPanelContentContent.add(idePanel);
        addPanelContentContent.add(usuarioPanel);
        addPanelContentContent.add(contraseniaPanel);
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
