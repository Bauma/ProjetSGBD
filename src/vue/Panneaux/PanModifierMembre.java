package vue.Panneaux;

import controller.MembreController;
import modele.ZModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class PanModifierMembre extends JPanel implements ActionListener {

    private MembreController ctrlMembre;

    private JLabel lblIdMembre = new JLabel("Id");
    private JLabel lblPseudo = new JLabel("Pseudo");
    private JLabel lblNationalite = new JLabel("Nationalité");

    private JTextField txtIdMembre = new JTextField();
    private JTextField txtPseudo = new JTextField();
    private JTextField txtNationalite = new JTextField();


    private JButton btnModifier = new JButton("Modifier");
    private JButton btnSupprimerEquipe = new JButton("X");
    private JButton btnSupprimerRole = new JButton("X");




    public PanModifierMembre(int membreId) {
        this.ctrlMembre = new MembreController();
        getForm(membreId);
        initPanel();
    }

    private void initPanel() {

        lblIdMembre.setBounds(20, 20, 100, 20);
        this.add(lblIdMembre);

        lblPseudo.setBounds(20, 50, 100, 20);
        this.add(lblPseudo);

        lblNationalite.setBounds(20, 80, 100, 20);
        this.add(lblNationalite);


        txtIdMembre.setBounds(150, 20, 150, 20);
        txtIdMembre.setEditable(false);
        this.add(txtIdMembre);

        txtPseudo.setBounds(150, 50, 150, 20);
        txtPseudo.setEditable(true);
        this.add(txtPseudo);

        txtNationalite.setBounds(150, 80, 150, 20);
        txtNationalite.setEditable(false);
        this.add(txtNationalite);

        btnModifier.setBounds(315, 45, 100, 30);
        btnModifier.addActionListener(this);
        btnModifier.setActionCommand("ModifierMembre");
        this.add(btnModifier);

        this.setLayout(null);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "ModifierMembre":
                ctrlMembre.updateMembre(txtPseudo.getText(),Integer.parseInt(txtIdMembre.getText()));
                Container topLevel = this.getTopLevelAncestor();
                JFrame maJFrame = (JFrame) topLevel;
                maJFrame.dispose();
                break;
        }
    }

    public void getForm(int teamId){

        Object[][] dataMembre = ctrlMembre.afficherMembre();
        String title[] = {"id", "Pseudo", "Nationnalité", "Equipe", "Role"};
        ZModel model = new ZModel(dataMembre, title);
        txtIdMembre.setText(model.getValueAt(teamId, 0).toString());
        txtPseudo.setText(model.getValueAt(teamId, 1).toString());
        txtNationalite.setText(model.getValueAt(teamId, 2).toString());

    }
}
