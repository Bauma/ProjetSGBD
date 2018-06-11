package controller;

import modele.Membre;

import java.sql.SQLException;

public class MembreController {


    public MembreController(){}


    public boolean createMembre(String nom) {
        if (nom != null) {
            // plus de validation si besoin genre c'est pas des caractère bizare

            try {
                Membre.createNewMembre(nom);
                return true;
            } catch (SQLException e) {
                e.printStackTrace();

            }
        }
        return false;
    }

    public Object[][] afficherMembre(){
        try{
            Membre[] tabMembre = Membre.getAllMembre();
            Object[][] tableData = new Object[tabMembre.length][5];
            int index = 0;
            for(Membre membre : tabMembre) {
                System.out.println(membre);
                tableData[index][0] = membre.getId();
                tableData[index][1] = membre.getNomMembre();
                tableData[index][2] = membre.getPays();
                tableData[index][3] = membre.getEquipe();
                tableData[index][4] = membre.getRole();

                index++;

            }
            return tableData;

        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;

    }

}
