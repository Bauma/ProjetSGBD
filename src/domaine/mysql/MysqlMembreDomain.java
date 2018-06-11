package domaine.mysql;

import database.mysql.MysqlClient;
import domaine.MembreDomain;
import modele.Membre;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MysqlMembreDomain implements MembreDomain {

    private static final String CREATE = "INSERT INTO membre (nomMembre) VALUES (?)";
    private static final String DELETE = "DELETE FROM membre WHERE nomMembre = ?";
    private static final String SELECTMEMBRE = "SELECT membre.id, membre.nomMembre, pays.nomPays FROM membre LEFT JOIN pays ON membre.paysMembre = pays.id";
    private static final String FINDBYID = SELECTMEMBRE + " WHERE membre.id =?";
    private static final String SELECTALL = "SELECT membre.id, membre.nomMembre, pays.nomPays, equipe.nomEquipe , membreequipe.joueur, membreequipe.entraineur " +
            "FROM (((membre LEFT JOIN membreequipe ON membre.id = membreequipe.membre) LEFT JOIN equipe ON membreequipe.equipe = equipe.Id) " +
            "LEFT JOIN pays ON membre.paysMembre = pays.id)";
    private static final String SELECTTRAINER = "SELECT membre.id, membre.nomMembre, pays.nomPays, equipe.nomEquipe, membreequipe.joueur, membreequipe.entraineur FROM (((equipe LEFT JOIN membreequipe ON equipe.id = membreequipe.equipe) LEFT JOIN membre ON membreequipe.membre = membre.Id) LEFT JOIN pays ON membre.paysMembre = pays.id) WHERE equipe.id = ? AND membreequipe.entraineur = 1";
    private static final String SELECTALLPLAYER = "SELECT membre.id, membre.nomMembre, pays.nomPays, equipe.nomEquipe, membreequipe.joueur, membreequipe.entraineur FROM (((equipe LEFT JOIN membreequipe ON equipe.id = membreequipe.equipe) LEFT JOIN membre ON membreequipe.membre = membre.Id) LEFT JOIN pays ON membre.paysMembre = pays.id) WHERE equipe.id = ? AND membreequipe.joueur = 1";

    @Override
    public void create(String nom) throws SQLException {
        Connection dbConnect = MysqlClient.getConnection();
        PreparedStatement pStatement = dbConnect.prepareStatement(CREATE);
        pStatement.setString(1, nom);
        pStatement.executeUpdate();
        pStatement.close();
    }

    @Override
    public void delete(String nom) throws SQLException {
        Connection dbConnect = MysqlClient.getConnection();
        PreparedStatement pStatement = dbConnect.prepareStatement(DELETE);
        pStatement.setString(1, nom);
        pStatement.executeUpdate();
        pStatement.close();
    }

    @Override
    public Membre[] getMembre() throws SQLException {
        Connection dbConnect = MysqlClient.getConnection();
        PreparedStatement pStatement = dbConnect.prepareStatement(SELECTMEMBRE);
        ResultSet rs = pStatement.executeQuery();
        List<Membre> listMembre = new ArrayList<>();
        Conversion conversion = new Conversion();
        while (rs.next()) {
            listMembre.add(conversion.sqlToMembre(rs));
        }
        pStatement.close();

        return listMembre.toArray(new Membre[listMembre.size()]);
    }

    @Override
    public Membre[] getAll() throws SQLException {
        Connection dbConnect = MysqlClient.getConnection();
        PreparedStatement pStatement = dbConnect.prepareStatement(SELECTALL);
        ResultSet rs = pStatement.executeQuery();
        List<Membre> listMembre = new ArrayList<>();
        Conversion conversion = new Conversion();
        while (rs.next()) {
            listMembre.add(conversion.sqlToMembre(rs));
        }
        pStatement.close();

        return listMembre.toArray(new Membre[listMembre.size()]);
    }

    @Override
    public Membre findById(int id) throws SQLException {
        Connection dbConnect = MysqlClient.getConnection();
        PreparedStatement pStatement = dbConnect.prepareStatement(FINDBYID);
        pStatement.setInt(1, id);
        ResultSet rs = pStatement.executeQuery();
        pStatement.close();
        Conversion conversion = new Conversion();
        return conversion.sqlToMembre(rs);
    }

    @Override
    public Membre[] findTrainerByTeamId(int id) throws SQLException {
        Connection dbConnect = MysqlClient.getConnection();
        PreparedStatement pStatement = dbConnect.prepareStatement(SELECTTRAINER);
        pStatement.setInt(1, id);
        ResultSet rs = pStatement.executeQuery();
        List<Membre> listMembre = new ArrayList<>();
        Conversion conversion = new Conversion();
        while (rs.next()) {
            listMembre.add(conversion.sqlToMembre(rs));
        }
        pStatement.close();

        return listMembre.toArray(new Membre[listMembre.size()]);
    }

    public Membre[] findAllPlayerByTeamId(int id) throws SQLException {
        Connection dbConnect = MysqlClient.getConnection();
        PreparedStatement pStatement = dbConnect.prepareStatement(SELECTALLPLAYER);
        pStatement.setInt(1, id);
        ResultSet rs = pStatement.executeQuery();
        List<Membre> listMembre = new ArrayList<>();
        Conversion conversion = new Conversion();
        while (rs.next()) {
            listMembre.add(conversion.sqlToMembre(rs));
        }
        pStatement.close();

        return listMembre.toArray(new Membre[listMembre.size()]);
    }

}
