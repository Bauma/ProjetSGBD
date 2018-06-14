package domaine.mysql;

import database.mysql.MysqlClient;
import domaine.EquipeDomain;
import modele.Equipe;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MysqlEquipeDomain implements EquipeDomain {

    private static final String CREATE = "INSERT INTO Equipe (nomEquipe, paysEquipe) VALUES (?,?)";
    private static final String DELETE = "DELETE FROM equipe WHERE id = ?";
    private static final String SELECTALL = "SELECT equipe.id, equipe.nomEquipe, pays.nomPays FROM equipe JOIN pays ON equipe.paysEquipe = pays.id";
    private static final String FINDBYID = SELECTALL + " WHERE equipe.id = ?";
    private static final String FINDBYPAYSID = SELECTALL + " WHERE pays.id = ?";
    private static final String UPDATE = "UPDATE equipe SET nomEquipe = ? WHERE id = ?";

    @Override
    public void create(String nom, int nationnalite) throws SQLException {
        Connection dbConnect = MysqlClient.getConnection();
        PreparedStatement pStatement = dbConnect.prepareStatement(CREATE);
        pStatement.setString(1, nom);
        pStatement.setInt(2,nationnalite);
        pStatement.executeUpdate();
        pStatement.close();
    }

    @Override
    public void delete(int id) throws SQLException {
        Connection dbConnect = MysqlClient.getConnection();
        PreparedStatement pStatement = dbConnect.prepareStatement(DELETE);
        pStatement.setInt(1, id);
        pStatement.executeUpdate();
        pStatement.close();
    }

    @Override
    public Equipe[] getAll() throws SQLException {
        Connection dbConnect = MysqlClient.getConnection();
        PreparedStatement pStatement = dbConnect.prepareStatement(SELECTALL);
        ResultSet rs = pStatement.executeQuery();
        List<Equipe> listEquipe = new ArrayList<>();
        Conversion conversion = new Conversion();
        while (rs.next()) {
            listEquipe.add(conversion.sqlToEquipe(rs));
        }
        pStatement.close();

        return listEquipe.toArray(new Equipe[listEquipe.size()]);
    }

    @Override
    public Equipe findById(int id) throws SQLException {
        Connection dbConnect = MysqlClient.getConnection();
        PreparedStatement pStatement = dbConnect.prepareStatement(FINDBYID);
        pStatement.setInt(1, id);
        ResultSet rs = pStatement.executeQuery();
        pStatement.close();
        Conversion conversion = new Conversion();
        return conversion.sqlToEquipe(rs);
    }

    public Equipe[] findByPaysId(int paysId) throws SQLException {
        Connection dbConnect = MysqlClient.getConnection();
        PreparedStatement pStatement = dbConnect.prepareStatement(FINDBYPAYSID);
        pStatement.setInt(1, paysId);
        ResultSet rs = pStatement.executeQuery();
        List<Equipe> listEquipe = new ArrayList<>();
        Conversion conversion = new Conversion();
        while (rs.next()) {
            listEquipe.add(conversion.sqlToEquipe(rs));
        }
        pStatement.close();

        return listEquipe.toArray(new Equipe[listEquipe.size()]);
    }

    public void updateNomEquipe(String nom, int id) throws SQLException {

            Connection dbConnect = MysqlClient.getConnection();
            PreparedStatement pStatement = dbConnect.prepareStatement(UPDATE);
            pStatement.setString(1, nom);
            pStatement.setInt(2, id);
            pStatement.executeUpdate();
            pStatement.close();

    }

}

