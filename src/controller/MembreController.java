package controller;

import modele.Membre;
import modele.Pays;

import java.sql.SQLException;
import java.util.ArrayList;

public class MembreController {


    public MembreController(){}


    public boolean createMembre(String nom, int nationnalite) {
        if (nom != null) {
            // plus de validation si besoin genre c'est pas des caractère bizare

            try {
                Membre.createNewMembre(nom, nationnalite);
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public Pays[] getAllPays(){
        try {
            return Pays.getAllPays();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public int getIdPaysByName(String nom){

        try {
            return Pays.getidPaysByName(nom);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }


    public Object[][] afficherMembre(){
        try{
            Membre[] tabMembre = Membre.getAllMembre();
            Object[][] tableData = new Object[tabMembre.length][5];
            int index = 0;
            for(Membre membre : tabMembre) {
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
    public void updateMembre(String nom, int id){
        try {
            Membre.updateNomMembre(nom, id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
