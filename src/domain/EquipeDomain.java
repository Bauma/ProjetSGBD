package domain;

import models.Equipe;

import java.sql.SQLException;
import java.util.List;

public interface EquipeDomain {

    void create(String nom) throws SQLException;
    void delete(String nom) throws SQLException;
    List<Equipe> getAll() throws SQLException;
    Equipe findById(int id) throws SQLException;
}
