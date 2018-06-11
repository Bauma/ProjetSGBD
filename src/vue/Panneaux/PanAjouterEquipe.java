package vue.Panneaux;

import controller.EquipeController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class PanAjouterEquipe extends JPanel implements ActionListener {

    private EquipeController ctrlEquipe;

    private JLabel lblNomEquipe = new JLabel("Nom de l'équipe");
    private JLabel lblPaysEquipe = new JLabel("Pays de l'équipe");


    private JTextField txtNomEquipe = new JTextField();
    private JTextField txtPaysEquipe = new JTextField();


    private JButton btnAjouter = new JButton("Ajouter");



    public PanAjouterEquipe() {
        this.ctrlEquipe = new EquipeController();
        initPanel();
    }

    private void initPanel() {

        lblNomEquipe.setBounds(20, 20, 100, 20);
        this.add(lblNomEquipe);

        lblPaysEquipe.setBounds(20, 50, 100, 20);
        this.add(lblPaysEquipe);



        txtNomEquipe.setBounds(150, 20, 150, 20);
        txtNomEquipe.setEditable(true);
        this.add(txtNomEquipe);

        txtPaysEquipe.setBounds(150, 50, 150, 20);
        txtPaysEquipe.setEditable(true);
        this.add(txtPaysEquipe);


        btnAjouter.setBounds(315, 30, 100, 30);
        btnAjouter.addActionListener(this);
        btnAjouter.setActionCommand("AjouterEquipe");
        this.add(btnAjouter);


        this.setLayout(null);

    }




    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case "AjouterEquipe" :
                ctrlEquipe.createEquipe(txtNomEquipe.getText());

                break;


        }
    }
}
