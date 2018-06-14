package modele;

import database.mysql.MysqlClient;
import domaine.mysql.MysqlEquipeDomain;

import java.sql.Connection;
import java.sql.SQLException;


public class Equipe {
    private int id;
    private String nomEquipe;
    private String pays;



    // CONSTRUCTEUR
    public Equipe(int id, String nomEquipe, String pays) {
        this.id = id;
        this.nomEquipe = nomEquipe;
        this.pays = pays;
    }

    //ACCESSEURS
    public int getId(){
        return id;
    }
    public String getNomEquipe() {
        return nomEquipe;
    }

    public String getPays() {
        return pays;
    }

    //SETTERS
    public void setNomEquipe(String nomEquipe) {
        this.nomEquipe = nomEquipe;
    }

    public static Equipe[] getAllEquipe() throws SQLException {
        return equipeDomaine().getAll();
    }

    public static Equipe[] getEquipesForPays(int paysId) throws SQLException {
        return equipeDomaine().findByPaysId(paysId);
    }
    public static void createNewEquipe(String nom, int nationnalite) throws SQLException {
        equipeDomaine().create(nom, nationnalite);
    }
    public static void updateEquipe(String nom, int id) throws SQLException{
        equipeDomaine().updateNomEquipe(nom, id);
    }

    public static void deleteEquipe(int id) throws  SQLException{
        equipeDomaine().delete(id);
    }

    private static MysqlEquipeDomain equipeDomaine() {
        Connection dbConnect = MysqlClient.getConnection();
        return new MysqlEquipeDomain();
    }

    public String toString() {
        return String.format("%s %s %s",
                id,
                nomEquipe,
                pays);
    }





}
