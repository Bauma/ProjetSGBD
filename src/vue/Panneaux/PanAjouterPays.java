package vue.Panneaux;

import controller.PaysController;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class PanAjouterPays extends JPanel implements ActionListener {

    private PaysController ctrl;

    private JLabel lblNomPays = new JLabel("nom du Pays");

    private JTextField txtNomPays = new JTextField();

    private JButton btnAjouter = new JButton("Ajouter");




    public PanAjouterPays() {
        this.ctrl = new PaysController();
        initPanel();
    }

    private void initPanel() {

        lblNomPays.setBounds(20, 20, 100, 20);
        this.add(lblNomPays);


        txtNomPays.setBounds(150, 20, 150, 20);
        txtNomPays.setEditable(true);
        this.add(txtNomPays);


        btnAjouter.setBounds(315, 15, 100, 30);
        btnAjouter.addActionListener(this);
        btnAjouter.setActionCommand("AjouterPays");
        this.add(btnAjouter);

        this.setLayout(null);
    }


    @Override
    public void actionPerformed(ActionEvent e){
        switch (e.getActionCommand()){
            case "AjouterPays" :
                ctrl.createPays(txtNomPays.getText());
                Container topLevel = this.getTopLevelAncestor();
                JFrame maJFrame = (JFrame) topLevel;
                maJFrame.dispose();
                break;


        }


    }
}
