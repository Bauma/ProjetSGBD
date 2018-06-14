package domaine;

import java.sql.SQLException;
import java.util.List;

import modele.Pays;

public interface PaysDomain {

    void create(String nom) throws SQLException;
    void delete(String nom) throws SQLException;
    Pays[] getAll() throws SQLException;
    Pays findById(int id) throws SQLException;
    int findByName(String nom) throws SQLException;
}
