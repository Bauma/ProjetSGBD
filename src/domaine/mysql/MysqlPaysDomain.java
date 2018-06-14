package domaine.mysql;

import database.mysql.MysqlClient;
import domaine.PaysDomain;
import modele.Pays;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MysqlPaysDomain implements PaysDomain {

    private static final String CREATE = "INSERT INTO pays (nomPays) VALUES (?)";
    private static final String DELETE = "DELETE FROM pays WHERE nomPays = ?";
    private static final String SELECTALL = "SELECT * FROM pays";
    private static final String FINDBYID = "SELECT * FROM pays where id = ?";
    private static final String FINDBYNAME = "SELECT id FROM pays where nomPays = ?";

    public MysqlPaysDomain() {}



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
    public Pays[] getAll() throws SQLException {
        Connection dbConnect = MysqlClient.getConnection();
        PreparedStatement pStatement = dbConnect.prepareStatement(SELECTALL);
        ResultSet rs = pStatement.executeQuery();
        List<Pays> listPays = new ArrayList<>();
        Conversion conversion = new Conversion();
        while(rs.next()){
            listPays.add(conversion.sqlToPays(rs));
        }
        pStatement.close();

        return listPays.toArray(new Pays[listPays.size()]);
    }

    @Override
    public Pays findById(int id) throws SQLException {
        Connection dbConnect = MysqlClient.getConnection();
        PreparedStatement pStatement = dbConnect.prepareStatement(FINDBYID);
        pStatement.setInt(1, id);
        ResultSet rs = pStatement.executeQuery();
        pStatement.close();
        Conversion conversion = new Conversion();
        return conversion.sqlToPays(rs);
    }

    @Override
    public int findByName(String nom) throws SQLException {
        int idPays;
        Connection dbConnect = MysqlClient.getConnection();
        PreparedStatement pStatement = dbConnect.prepareStatement(FINDBYNAME);
        pStatement.setString(1, nom);
        ResultSet rs = pStatement.executeQuery();
        rs.next();
        idPays = rs.getInt(1);
        pStatement.close();
        return idPays;
    }



}
