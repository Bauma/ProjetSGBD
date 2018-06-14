package controller;


import modele.Equipe;
import modele.Pays;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class PaysController {

public PaysController(){}


    public boolean createPays(String nom) {
        if (nom != null) {
            // plus de validation si besoin genre c'est pas des caractère bizare

            try {
                Pays.createNewPays(nom);
                return true;
            } catch (SQLException e) {
                e.printStackTrace();

            }
        }
        return false;
    }

    public Object[][] afficherPays(){
        try{
            Pays[] tabPays = Pays.getAllPays();
            Object[][] tableData = new Object[tabPays.length][4];
            int index = 0;
            for(Pays pays : tabPays){

                tableData[index][0] = pays.getId();
                tableData[index][1] = pays.getNomPays();
                Equipe[] tabEquipe = Equipe.getEquipesForPays(pays.getId());
                for(Equipe equipe : tabEquipe){

                    if (tableData[index][2] == null) {
                        tableData[index][2] = equipe.getNomEquipe();
                    } else{
                        tableData[index][3] = equipe.getNomEquipe();
                    }
                }
                index++;
            }

            return tableData;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;



    }

}
