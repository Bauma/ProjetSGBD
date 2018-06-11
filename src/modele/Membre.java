package modele;


import com.sun.org.apache.xpath.internal.operations.Bool;
import database.mysql.MysqlClient;
import domaine.mysql.MysqlMembreDomain;

import java.sql.Connection;
import java.sql.SQLException;

public class Membre {
    private int id;
    private String nomMembre;
    private String pays;
    private String equipe;
    private Boolean isJoueur;
    private Boolean isEntraineur;
    private String role;



    // CONSTRUCTEUR
    public Membre(int id, String nomMembre, String pays, String equipe, boolean isJoueur, boolean isEntraineur) {
        this.nomMembre = nomMembre;
        this.id = id;
        this.pays = pays;
        this.equipe = equipe;
        this.isJoueur = isJoueur;
        this.isEntraineur =  isEntraineur;
        this.role = setRole(isJoueur, isEntraineur);
    }

    //ACCESSEURS

    public int getId(){
        return id;
    }
    public String getNomMembre() {
        return nomMembre;
    }
    public String getPays(){
        return pays;
    }
    public String getEquipe(){
        return equipe;
    }
    public Boolean getIsJoueur(){
        return isJoueur;
    }

    public Boolean getIsEntraineur(){
        return isEntraineur;
    }

    public String getRole(){
        return role;
    }

    //SETTERS
    public void setNomMembre(String nomMembre) {
        this.nomMembre = nomMembre;
    }

    public String setRole(boolean isJoueur, boolean isEntraineur){

        if (isJoueur == false){
            if (isEntraineur == false){
                return role = null;
            }else{
                return role = "Entraineur";
            }
        }else{
            if (isEntraineur == true){
                return role = "Entraineur & Joueur";
            }else{
                return role = "Joueur";
            }
        }
    }


    public static Membre[] getAllMembre() throws SQLException {
        return membreDomaine().getAll();
    }

    public static Membre[] findTrainerByTeamId(int id) throws SQLException{
        return membreDomaine().findTrainerByTeamId(id);
    }
    public static Membre[] findAllPlayerByTeamId(int id) throws SQLException{
        return membreDomaine().findAllPlayerByTeamId(id);
    }

    public static void createNewMembre(String nom) throws SQLException {
        membreDomaine().create(nom);
    }


    private static MysqlMembreDomain membreDomaine() {
        Connection dbConnect = MysqlClient.getConnection();
        return new MysqlMembreDomain();
    }
}

