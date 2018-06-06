package vue.Panneaux;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class PanAfficherMembre extends JPanel implements ActionListener {



    //private JLabel lblNom = new JLabel("Nom Pays :");


    //private JTextField txtCode = new JTextField();

    private JButton btnModifierMembre = new JButton("Modifier Membre");
    private JButton btnSupprimerMembre = new JButton("Supprimer Membre");
    private JButton btnAjouterMembre = new JButton("Ajouter Membre");

    private JButton btnAfficherMembres = new JButton("Afficher Membres");
    private JButton btnAfficherPays = new JButton("Afficher Pays");
    private JButton btnAfficherEquipes = new JButton("Afficher Equipes");

    Object[][] data = {
            {1,"Cinetik", "France", "SardocheTeam", "Entraineur"},
            {2,"Boma", "Allemagne", "Red", "Joueur"},
            {3,"Ryoh", "Pologne", "Blue", "Entraineur/Joueur"},
            {4,"Bach", "Belgique", "Green", "Joueur"}
    };

    String title[] = {"id", "Pseudo", "Nationalité", "Equipe", "Role"};

    private JTable tableAfficherResult = new JTable(data, title);
    private JScrollPane js = new JScrollPane(tableAfficherResult);



    public PanAfficherMembre() {

        initPanel();
    }

    private void initPanel() {

    //    lblNom.setBounds(10, 40, 80, 20);
    //    this.add(lblNom);


    //    txtNom.setBounds(100, 40, 100, 20);
    //    txtNom.setEditable(false);
    //    this.add(txtNom);

//Boutons de gestion(GAUCHE)

        btnModifierMembre.setBounds(20, 10, 150, 30);
        btnModifierMembre.addActionListener(this);
        btnModifierMembre.setActionCommand("ModifierMembre");
        this.add(btnModifierMembre);

        btnSupprimerMembre.setBounds(20, 50, 150, 30);
        btnSupprimerMembre.addActionListener(this);
        btnSupprimerMembre.setActionCommand("SupprimerMembre");
        this.add(btnSupprimerMembre);

        btnAjouterMembre.setBounds(20, 90, 150, 30);
        btnAjouterMembre.addActionListener(this);
        btnAjouterMembre.setActionCommand("AjouterMembre");
        this.add(btnAjouterMembre);

//Boutons d'affichages(DROITE)

        btnAfficherMembres.setBounds(710, 10, 150, 30);
        btnAfficherMembres.addActionListener(this);
        btnAfficherMembres.setActionCommand("AjouterMembre");
        this.add(btnAfficherMembres);

        btnAfficherPays.setBounds(710, 50, 150, 30);
        btnAfficherPays.addActionListener(this);
        btnAfficherPays.setActionCommand("AjouterMembre");
        this.add(btnAfficherPays);

        btnAfficherEquipes.setBounds(710, 90, 150, 30);
        btnAfficherEquipes.addActionListener(this);
        btnAfficherEquipes.setActionCommand("AjouterMembre");
        this.add(btnAfficherEquipes);

        js.setBounds(20,140,840,440);
        js.setVisible(true);
        this.add(js);


        this.setLayout(null);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
