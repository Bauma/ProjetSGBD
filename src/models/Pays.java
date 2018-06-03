package models;

import database.mysql.MysqlClient;
import domain.mysql.MysqlPaysDomain;

import java.sql.Connection;
import java.sql.SQLException;

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

    //SETTERS
    public void setNomPays(String nomPays) {
        this.nomPays = nomPays;
    }

    public static Pays findById(int id) throws SQLException {
        return paysDomaine().findById(id);
    }

    private static MysqlPaysDomain paysDomaine() {
        Connection dbConnect = MysqlClient.getConnection();
        return new MysqlPaysDomain(dbConnect);
    }
}


