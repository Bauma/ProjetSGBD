package modele;

import database.mysql.MysqlClient;
import domaine.mysql.MysqlPaysDomain;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class Pays {

    private int id;
    private String nomPays;


    // CONSTRUCTEUR
    public Pays(int id, String nomPays) {
        this.id = id;
        this.nomPays = nomPays;
    }

    //ACCESSEURS
    public String getNomPays() {
        return nomPays;
    }

    public int getId() {
        return id;
    }

    //SETTERS
    public void setNomPays(String nomPays) {
        this.nomPays = nomPays;
    }
    public static Pays findById(int id) throws SQLException {
        return paysDomaine().findById(id);
    }

    public static Pays[] getAllPays() throws SQLException {
        return paysDomaine().getAll();
    }
    public static int getidPaysByName(String nom) throws SQLException{
        return paysDomaine().findByName(nom);
    }

    public static void createNewPays(String nom) throws SQLException {
        paysDomaine().create(nom);
    }

    private static MysqlPaysDomain paysDomaine() {
        Connection dbConnect = MysqlClient.getConnection();
        return new MysqlPaysDomain();
    }

    public String toString() {
        return String.format("%s %s",
                id,
                nomPays);
    }
}



