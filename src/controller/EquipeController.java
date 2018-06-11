package controller;

import modele.Equipe;
import modele.Membre;


import java.sql.SQLException;

public class EquipeController {


    public EquipeController(){}


    public boolean deleteEquipe(int id){
        try {
            Equipe.deleteEquipe(id);
            return true;
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Object[][] afficherEquipe(){
        try{
            Equipe[] tabEquipe = Equipe.getAllEquipe();
            Object[][] tableData = new Object[tabEquipe.length][7];
            int index = 0;
            for(Equipe equipe : tabEquipe) {
                System.out.println(equipe);
                tableData[index][0] = equipe.getId();
                tableData[index][1] = equipe.getNomEquipe();
                tableData[index][2] = equipe.getPays();

                Membre[] tabTrainer = Membre.findTrainerByTeamId(equipe.getId());
                for(Membre trainer : tabTrainer){
                            tableData[index][3] = trainer.getNomMembre();
                        }
                Membre[] tabPlayer = Membre.findAllPlayerByTeamId(equipe.getId());
                for(Membre player : tabPlayer){
                    if (tableData[index][4] == null) {
                        tableData[index][4] = player.getNomMembre();
                    } else if(tableData[index][5] == null){
                        tableData[index][5] = player.getNomMembre();
                    }else{
                        tableData[index][6] = player.getNomMembre();
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

    public boolean createEquipe(String nom) {

            if (nom != null) {
                // plus de validation si besoin genre c'est pas des caractères bizare

                try {
                    Equipe.createNewEquipe(nom);
                    return true;
                } catch (SQLException e) {
                    e.printStackTrace();

                }
            }
            return false;
        }



}