package domain.mysql;

import database.mysql.MysqlClient;
import domain.EquipeDomain;
import models.Equipe;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MysqlEquipeDomain implements EquipeDomain {

    private static final String CREATE = "INSERT INTO equipe (nomEquipe) VALUES (?)";
    private static final String DELETE = "DELETE FROM equipe WHERE nomEquipe = ?";
    private static final String SELECTALL = "SELECT equipe.id, equipe.nomEquipe, pays.nomPays FROM equipe JOIN pays ON equipe.paysEquipe = pays.id";
    private static final String FINDBYID = SELECTALL + " WHERE equipe.id = ?";

    private Connection dbConnect;

    public MysqlEquipeDomain(Connection connexion) {
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
    public List<Equipe> getAll() throws SQLException {
        PreparedStatement pStatement = this.dbConnect.prepareStatement(SELECTALL);
        ResultSet rs = pStatement.executeQuery();
        List<Equipe> listEquipe = new ArrayList<>();
        Conversion conversion = new Conversion();
        while (rs.next()) {
            listEquipe.add(conversion.sqlToEquipe(rs));
        }
        pStatement.close();

        return listEquipe;
    }

    @Override
    public Equipe findById(int id) throws SQLException {
        PreparedStatement pStatement = this.dbConnect.prepareStatement(FINDBYID);
        pStatement.setInt(1, id);
        ResultSet rs = pStatement.executeQuery();
        pStatement.close();
        Conversion conversion = new Conversion();
        return conversion.sqlToEquipe(rs);
    }
}

