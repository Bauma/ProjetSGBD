package domain.mysql;

import database.mysql.MysqlClient;
import domain.PaysDomain;
import models.Pays;

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

    private Connection dbConnect;

    public MysqlPaysDomain(Connection connexion) {
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
    public List<Pays> getAll() throws SQLException {
        PreparedStatement pStatement = this.dbConnect.prepareStatement(SELECTALL);
        ResultSet rs = pStatement.executeQuery();
        List<Pays> listPays = new ArrayList<>();
        Conversion conversion = new Conversion();
        while(rs.next()){
            listPays.add(conversion.sqlToPays(rs));
        }
        pStatement.close();

        return listPays;
    }

    @Override
    public Pays findById(int id) throws SQLException {
        PreparedStatement pStatement = this.dbConnect.prepareStatement(FINDBYID);
        pStatement.setInt(1, id);
        ResultSet rs = pStatement.executeQuery();
        pStatement.close();
        Conversion conversion = new Conversion();
        return conversion.sqlToPays(rs);
    }



}
