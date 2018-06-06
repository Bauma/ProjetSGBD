package vue.Panneaux;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class PanAjouterPays extends JPanel implements ActionListener {


    private JLabel lblNomPays = new JLabel("nom du Pays");



    private JTextField txtNomPays = new JTextField();




    private JButton btnAjouter = new JButton("Ajouter");




    public PanAjouterPays() {

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
        btnAjouter.setActionCommand("AjouterEquipe");
        this.add(btnAjouter);

        this.setLayout(null);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
