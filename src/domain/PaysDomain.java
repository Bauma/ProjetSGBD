package domain;

import java.sql.SQLException;
import java.util.List;

import models.Pays;

public interface PaysDomain {

    void create(String nom) throws SQLException;
    void delete(String nom) throws SQLException;
    List<Pays> getAll() throws SQLException;
    Pays findById(int id) throws SQLException;
}
