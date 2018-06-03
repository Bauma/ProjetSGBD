package domain;

import models.Membre;

import java.sql.SQLException;
import java.util.List;

public interface MembreDomain {

    void create(String nom) throws SQLException;
    void delete(String nom) throws SQLException;
    List<Membre> getAll() throws SQLException;
    Membre findById(int id) throws SQLException;
}
