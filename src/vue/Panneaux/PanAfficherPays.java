package vue.Panneaux;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class PanAfficherPays extends JPanel implements ActionListener {



    //private JLabel lblNom = new JLabel("Nom Pays :");


    //private JTextField txtCode = new JTextField();


    private JButton btnSupprimerPays = new JButton("Supprimer Pays");
    private JButton btnAjouterPays = new JButton("Ajouter Pays");

    private JButton btnAfficherMembres = new JButton("Afficher Membres");
    private JButton btnAfficherPays = new JButton("Afficher Pays");
    private JButton btnAfficherEquipes = new JButton("Afficher Equipes");



    public PanAfficherPays() {

        initPanel();
    }

    private void initPanel() {

        //    lblNom.setBounds(10, 40, 80, 20);
        //    this.add(lblNom);


        //    txtNom.setBounds(100, 40, 100, 20);
        //    txtNom.setEditable(false);
        //    this.add(txtNom);

//Boutons de gestion(GAUCHE)


        btnSupprimerPays.setBounds(20, 50, 150, 30);
        btnSupprimerPays.addActionListener(this);
        btnSupprimerPays.setActionCommand("SupprimerPays");
        this.add(btnSupprimerPays);

        btnAjouterPays.setBounds(20, 90, 150, 30);
        btnAjouterPays.addActionListener(this);
        btnAjouterPays.setActionCommand("AjouterPays");
        this.add(btnAjouterPays);

//Boutons d'affichages(DROITE)

        btnAfficherMembres.setBounds(710, 10, 150, 30);
        btnAfficherMembres.addActionListener(this);
        btnAfficherMembres.setActionCommand("AfficherMembres");
        this.add(btnAfficherMembres);

        btnAfficherPays.setBounds(710, 50, 150, 30);
        btnAfficherPays.addActionListener(this);
        btnAfficherPays.setActionCommand("AfficherPays");
        this.add(btnAfficherPays);

        btnAfficherEquipes.setBounds(710, 90, 150, 30);
        btnAfficherEquipes.addActionListener(this);
        btnAfficherEquipes.setActionCommand("AfficherEquipes");
        this.add(btnAfficherEquipes);



        this.setLayout(null);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
