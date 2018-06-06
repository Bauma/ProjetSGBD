package vue.Panneaux;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class PanModifierEquipe extends JPanel implements ActionListener {


    private JLabel lblIdEquipe = new JLabel("Id de l'équipe");
    private JLabel lblNomEquipe = new JLabel("Nom de l'équipe");
    private JLabel lblPaysEquipe = new JLabel("Pays de l'équipe");
    private JLabel lblEntraineur = new JLabel("Entraineur");
    private JLabel lblJoueur1 = new JLabel("Joueur 1");
    private JLabel lblJoueur2 = new JLabel("Joueur 2");
    private JLabel lblJoueur3 = new JLabel("Joueur 3");


    private JTextField txtIdEquipe = new JTextField();
    private JTextField txtNomEquipe = new JTextField();
    private JTextField txtPaysEquipe = new JTextField();


    private JComboBox cbEntraineur = new JComboBox();
    private JComboBox cbJoueur1 = new JComboBox();
    private JComboBox cbJoueur2 = new JComboBox();
    private JComboBox cbJoueur3 = new JComboBox();

    private JButton btnModifier = new JButton("Modifier");
    private JButton btnSupprimerEntraineur = new JButton("X");
    private JButton btnSupprimerJoueur1 = new JButton("X");
    private JButton btnSupprimerJoueur2 = new JButton("X");
    private JButton btnSupprimerJoueur3 = new JButton("X");



    public PanModifierEquipe() {

        initPanel();
    }

    private void initPanel() {

        lblIdEquipe.setBounds(20, 20, 100, 20);
        this.add(lblIdEquipe);

        lblNomEquipe.setBounds(20, 50, 100, 20);
        this.add(lblNomEquipe);

        lblPaysEquipe.setBounds(20, 80, 100, 20);
        this.add(lblPaysEquipe);


        lblEntraineur.setBounds(20, 120, 100, 20);
        this.add(lblEntraineur);

        lblJoueur1.setBounds(20, 150, 100, 20);
        this.add(lblJoueur1);

        lblJoueur2.setBounds(20, 180, 100, 20);
        this.add(lblJoueur2);

        lblJoueur3.setBounds(20, 210, 100, 20);
        this.add(lblJoueur3);


        txtIdEquipe.setBounds(150, 20, 150, 20);
        txtIdEquipe.setEditable(false);
        this.add(txtIdEquipe);

        txtNomEquipe.setBounds(150, 50, 150, 20);
        txtNomEquipe.setEditable(true);
        this.add(txtNomEquipe);

        txtPaysEquipe.setBounds(150, 80, 150, 20);
        txtPaysEquipe.setEditable(false);
        this.add(txtPaysEquipe);


        cbEntraineur.setBounds(150, 120, 150, 20);
        this.add(cbEntraineur);

        cbJoueur1.setBounds(150, 150, 150, 20);
        this.add(cbJoueur1);

        cbJoueur2.setBounds(150, 180, 150, 20);
        this.add(cbJoueur2);

        cbJoueur3.setBounds(150, 210, 150, 20);
        this.add(cbJoueur3);


        btnModifier.setBounds(315, 45, 100, 30);
        btnModifier.addActionListener(this);
        btnModifier.setActionCommand("ModifierEquipe");
        this.add(btnModifier);

        btnSupprimerEntraineur.setBounds(305, 120, 20, 20);
        btnSupprimerEntraineur.addActionListener(this);
        btnSupprimerEntraineur.setActionCommand("SupprimerEntraineur");
        this.add(btnSupprimerEntraineur);

        btnSupprimerJoueur1.setBounds(305, 150, 20, 20);
        btnSupprimerJoueur1.addActionListener(this);
        btnSupprimerJoueur1.setActionCommand("SupprimerJoueur1");
        this.add(btnSupprimerJoueur1);

        btnSupprimerJoueur2.setBounds(305, 180, 20, 20);
        btnSupprimerJoueur2.addActionListener(this);
        btnSupprimerJoueur2.setActionCommand("SupprimerJoueur2");
        this.add(btnSupprimerJoueur2);

        btnSupprimerJoueur3.setBounds(305, 210, 20, 20);
        btnSupprimerJoueur3.addActionListener(this);
        btnSupprimerJoueur3.setActionCommand("SupprimerJoueur3");
        this.add(btnSupprimerJoueur3);

        this.setLayout(null);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
