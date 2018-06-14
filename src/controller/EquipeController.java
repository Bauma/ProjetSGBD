package controller;

import modele.Equipe;
import modele.Membre;


import java.sql.SQLException;
import java.util.ArrayList;

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

    public boolean createEquipe(String nom, int nationnalite) {

            if (nom != null) {
                // plus de validation si besoin genre c'est pas des caractères bizare

                try {
                    Equipe.createNewEquipe(nom,nationnalite);
                    return true;
                } catch (SQLException e) {
                    e.printStackTrace();

                }
            }
            return false;
        }


        public ArrayList<String> getFreePlayer(String nomMembre, String pays, String equipe){
            ArrayList<String> freePlayers = new ArrayList();
            freePlayers.add(nomMembre);
            try {
                Membre[] tabMembre = Membre.getAllMembre();
                for(Membre membre : tabMembre) {
                    if (membre.getPays().equals(pays) && ((membre.getEquipe()== null)|| membre.getEquipe().equals(equipe)) ) {
                        freePlayers.add(membre.getNomMembre());
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return freePlayers;
        }
        public ArrayList<String> getFreeTrainer(String nomMembre, String equipe){
        ArrayList<String> freeTrainer = new ArrayList<>();
        freeTrainer.add(nomMembre);
            try {
                Membre[] tabMembre = Membre.getAllMembre();
                for (Membre membre : tabMembre){
                    if (membre.getEquipe()== null || membre.getEquipe().equals(equipe)){
                        freeTrainer.add(membre.getNomMembre());
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        return freeTrainer;
        }

        public void leaveEquipe(String joueur){
            if (!joueur.isEmpty()){
                try {
                    Membre membre = Membre.findByName(joueur);
                    membre.leaveEquipe(membre.getId());
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
        }

        public void updateEquipe(ArrayList newEntry){
            try {
                Equipe.updateEquipe(newEntry.get(1).toString(),Integer.parseInt(newEntry.get(0).toString()));

//Entraineur
                if (!newEntry.get(3).toString().equals("")) {
                    Membre membre = Membre.findByName(newEntry.get(3).toString());
                    if (membre.getEquipe()== null) membre.setEquipe("");
                    int isJoueur;
                    if (!newEntry.get(7).toString().equals("")){

                        System.out.print("update");
                        if (newEntry.get(4).toString().equals(newEntry.get(3).toString())
                            || newEntry.get(5).toString().equals(newEntry.get(3).toString())
                            || newEntry.get(6).toString().equals(newEntry.get(3).toString())
                            ) {

                            isJoueur = 1;
                        } else {
                            isJoueur = 0;
                        }
                    Membre.updateMembreEquipe(
                            membre.getId(),
                            Integer.parseInt(newEntry.get(0).toString()),
                            isJoueur,
                            1,
                            newEntry.get(7).toString());
                    }else{
                        System.out.print("insert");
                        if (newEntry.get(4).toString().equals(newEntry.get(3).toString())
                                || newEntry.get(5).toString().equals(newEntry.get(3).toString())
                                || newEntry.get(6).toString().equals(newEntry.get(3).toString())
                                ) {

                            isJoueur = 1;
                        } else {
                            isJoueur = 0;
                        }
                    Membre.createMembreEquipe(membre.getId(),Integer.parseInt(newEntry.get(0).toString()),isJoueur,1);
                    }
                }
//Joueur 1
                if (!newEntry.get(4).toString().equals("")) {
                    Membre membre = Membre.findByName(newEntry.get(4).toString());
                    if (membre.getEquipe()== null) membre.setEquipe("");
                    int isEntraineur;
                    if (!newEntry.get(8).toString().equals("")){
                        if (newEntry.get(4).toString().equals(newEntry.get(3).toString())){
                            isEntraineur = 1;
                        }else {
                            isEntraineur = 0;
                        }
                        Membre.updateMembreEquipe(
                            membre.getId(),
                            Integer.parseInt(newEntry.get(0).toString()),
                            1,
                                isEntraineur,
                            newEntry.get(8).toString());
                    }else{
                        if (newEntry.get(4).toString().equals(newEntry.get(3).toString())){
                            isEntraineur = 1;
                        } else {
                            isEntraineur = 0;
                        }
                        Membre.createMembreEquipe(membre.getId(),Integer.parseInt(newEntry.get(0).toString()),1,isEntraineur);
                    }


                }
//Joueur 2
                if (!newEntry.get(5).toString().equals("")) {
                    Membre membre = Membre.findByName(newEntry.get(5).toString());
                    if (membre.getEquipe()== null) membre.setEquipe("");
                    int isEntraineur;
                    if (!newEntry.get(9).toString().equals("")){
                        if (newEntry.get(5).toString().equals(newEntry.get(3).toString())){
                            isEntraineur = 1;
                        } else {
                            isEntraineur = 0;
                        }
                        Membre.updateMembreEquipe(
                            membre.getId(),
                            Integer.parseInt(newEntry.get(0).toString()),
                                1,
                                isEntraineur,
                            newEntry.get(9).toString());
                    }else{
                        if (newEntry.get(5).toString().equals(newEntry.get(3).toString())){
                            isEntraineur = 1;
                        } else {
                            isEntraineur = 0;
                        }
                        Membre.createMembreEquipe(membre.getId(),Integer.parseInt(newEntry.get(0).toString()),1,isEntraineur);
                    }
                }
//Joueur 3
                if (!newEntry.get(6).toString().equals("")) {
                    Membre membre = Membre.findByName(newEntry.get(6).toString());
                    if (membre.getEquipe()== null) membre.setEquipe("");
                    int isEntraineur;
                    if (!newEntry.get(10).toString().equals("")){
                        if (newEntry.get(6).toString().equals(newEntry.get(3).toString())){
                            isEntraineur = 1;
                        } else {
                            isEntraineur = 0;
                        }
                        Membre.updateMembreEquipe(
                            membre.getId(),
                            Integer.parseInt(newEntry.get(0).toString()),
                                1,
                                isEntraineur,
                            newEntry.get(10).toString());
                    }else{
                        if (newEntry.get(6).toString().equals(newEntry.get(3).toString())){
                            isEntraineur = 1;
                        } else {
                            isEntraineur = 0;
                        }
                        Membre.createMembreEquipe(membre.getId(),Integer.parseInt(newEntry.get(0).toString()),1, isEntraineur);
                    }
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }


        }

}