package vue.Panneaux;

import controller.EquipeController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class PanModifierMembre extends JPanel implements ActionListener {

    private EquipeController ctrlEquipe;

    private JLabel lblIdMembre = new JLabel("Id");
    private JLabel lblPseudo = new JLabel("Pseudo");
    private JLabel lblNationalite = new JLabel("Nationalité");
    private JLabel lblEquipe = new JLabel("Equipe");
    private JLabel lblRole = new JLabel("Rôle");


    private JTextField txtIdMembre = new JTextField();
    private JTextField txtPseudo = new JTextField();
    private JTextField txtNationalite = new JTextField();

    private JComboBox cbEquipe = new JComboBox();
    private JComboBox cbRole = new JComboBox();

    private JButton btnModifier = new JButton("Modifier");
    private JButton btnSupprimerEquipe = new JButton("X");
    private JButton btnSupprimerRole = new JButton("X");




    public PanModifierMembre() {
        this.ctrlEquipe = new EquipeController();
        initPanel();
    }

    private void initPanel() {

        lblIdMembre.setBounds(20, 20, 100, 20);
        this.add(lblIdMembre);

        lblPseudo.setBounds(20, 50, 100, 20);
        this.add(lblPseudo);

        lblNationalite.setBounds(20, 80, 100, 20);
        this.add(lblNationalite);

        lblEquipe.setBounds(20, 110, 100, 20);
        this.add(lblEquipe);

        lblRole.setBounds(20, 140, 100, 20);
        this.add(lblRole);




        txtIdMembre.setBounds(150, 20, 150, 20);
        txtIdMembre.setEditable(false);
        this.add(txtIdMembre);

        txtPseudo.setBounds(150, 50, 150, 20);
        txtPseudo.setEditable(true);
        this.add(txtPseudo);

        txtNationalite.setBounds(150, 80, 150, 20);
        txtNationalite.setEditable(false);
        this.add(txtNationalite);

        cbEquipe.setBounds(150, 110, 150, 20);
        this.add(cbEquipe);

        cbRole.setBounds(150, 140, 150, 20);
        this.add(cbRole);


        btnModifier.setBounds(315, 45, 100, 30);
        btnModifier.addActionListener(this);
        btnModifier.setActionCommand("ModifierEquipe");
        this.add(btnModifier);

        btnSupprimerEquipe.setBounds(305, 110, 20, 20);
        btnSupprimerEquipe.addActionListener(this);
        btnSupprimerEquipe.setActionCommand("SupprimerEntraineur");
        this.add(btnSupprimerEquipe);

        btnSupprimerRole.setBounds(305, 140, 20, 20);
        btnSupprimerRole.addActionListener(this);
        btnSupprimerRole.setActionCommand("SupprimerJoueur1");
        this.add(btnSupprimerRole);

        this.setLayout(null);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
