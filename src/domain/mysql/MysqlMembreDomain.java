package domain.mysql;

import database.mysql.MysqlClient;
import domain.MembreDomain;
import models.Membre;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MysqlMembreDomain implements MembreDomain {

    private static final String CREATE = "INSERT INTO membre (nomMembre) VALUES (?)";
    private static final String DELETE = "DELETE FROM membre WHERE nomMembre = ?";
    private static final String SELECTALL = "SELECT membre.id, membre.nomMembre, pays.nomPays FROM membre JOIN pays ON membre.paysMembre = pays.id";
    private static final String FINDBYID = SELECTALL + " WHERE membre.id =?";

    private Connection dbConnect;

    public MysqlMembreDomain(Connection connexion) {
        if (connexion == null) {
            this.dbConnect = MysqlClient.getConnection();
        }
    }

    @Override
    public void create(String nom) throws SQLException {
        PreparedStatement pStatement = this.dbConnect.prepareStatement(CREATE);
        pStatement.setString(1, nom);
        pStatement.executeUpdate();
        pStatement.close();
    }

    @Override
    public void delete(String nom) throws SQLException {
        PreparedStatement pStatement = this.dbConnect.prepareStatement(DELETE);
        pStatement.setString(1, nom);
        pStatement.executeUpdate();
        pStatement.close();
    }

    @Override
    public List<Membre> getAll() throws SQLException {
        PreparedStatement pStatement = this.dbConnect.prepareStatement(SELECTALL);
        ResultSet rs = pStatement.executeQuery();
        List<Membre> listMembre = new ArrayList<>();
        Conversion conversion = new Conversion();
        while (rs.next()) {
            listMembre.add(conversion.sqlToMembre(rs));
        }
        pStatement.close();

        return listMembre;
    }

    @Override
    public Membre findById(int id) throws SQLException {
        PreparedStatement pStatement = this.dbConnect.prepareStatement(FINDBYID);
        pStatement.setInt(1, id);
        ResultSet rs = pStatement.executeQuery();
        pStatement.close();
        Conversion conversion = new Conversion();
        return conversion.sqlToMembre(rs);
    }
}
