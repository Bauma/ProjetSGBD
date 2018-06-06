package vue.Panneaux;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class PanAjouterMembre extends JPanel implements ActionListener {


    private JLabel lblPseudo = new JLabel("Pseudo");
    private JLabel lblNationalite = new JLabel("Nationalité");

    private JTextField txtPseudo = new JTextField();
    private JTextField txtNationalite = new JTextField();

    private JButton btnAjouter = new JButton("Ajouter");


    public PanAjouterMembre() {

        initPanel();
    }

    private void initPanel() {

        lblPseudo.setBounds(20, 20, 100, 20);
        this.add(lblPseudo);
        lblNationalite.setBounds(20, 50, 100, 20);
        this.add(lblNationalite);


        txtPseudo.setBounds(150, 20, 150, 20);
        txtPseudo.setEditable(true);
        this.add(txtPseudo);

        txtNationalite.setBounds(150, 50, 150, 20);
        txtNationalite.setEditable(true);
        this.add(txtNationalite);


        btnAjouter.setBounds(315, 30, 100, 30);
        btnAjouter.addActionListener(this);
        btnAjouter.setActionCommand("AjouterMembre");
        this.add(btnAjouter);

        this.setLayout(null);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
