package vue.Panneaux;



import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class PanAfficherEquipe extends JPanel implements ActionListener {

    private JButton btnModifierEquipe = new JButton("Modifier Equipe");
    private JButton btnSupprimerEquipe = new JButton("Supprimer Equipe");
    private JButton btnAjouterEquipe = new JButton("Ajouter Equipe");

    private JButton btnAfficherMembres = new JButton("Afficher Membres");
    private JButton btnAfficherPays = new JButton("Afficher Pays");
    private JButton btnAfficherEquipes = new JButton("Afficher Equipes");

    Object[][] data = {
            {1,"Dark", "Belgique", "Cinetik", "Boma", "Ryoh", "Bach"},
            {2,"Light", "France", "Cinetik", "Boma", "Ryoh", "Bach"},
            {3,"Green", "Allemagne", "Cinetik", "Boma", "Ryoh", "Bach"},
            {4,"Blue", "Espgne", "Cinetik", "Boma", "Ryoh", "Bach"}
    };

    String title[] = {"id", "Nom de l'équipe", "Pays", "Entraineur", "Joueur 1", "Joueur 2", "Joueur 3"};

    private JTable tableAfficherResult = new JTable(data, title);
    private JScrollPane js = new JScrollPane(tableAfficherResult);


    public PanAfficherEquipe() {

        initPanel();
    }

    private void initPanel() {


//Boutons de gestion(GAUCHE)

        btnModifierEquipe.setBounds(20, 10, 150, 30);
        btnModifierEquipe.addActionListener(this);
        btnModifierEquipe.setActionCommand("ModifierEquipe");
        this.add(btnModifierEquipe);

        btnSupprimerEquipe.setBounds(20, 50, 150, 30);
        btnSupprimerEquipe.addActionListener(this);
        btnSupprimerEquipe.setActionCommand("SupprimerEquipe");
        this.add(btnSupprimerEquipe);

        btnAjouterEquipe.setBounds(20, 90, 150, 30);
        btnAjouterEquipe.addActionListener(this);
        btnAjouterEquipe.setActionCommand("AjouterEquipe");
        this.add(btnAjouterEquipe);



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


        js.setBounds(20,140,840,440);
        js.setVisible(true);
        this.add(js);

        this.setLayout(null);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
