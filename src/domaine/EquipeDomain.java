package domaine;

import modele.Equipe;

import java.sql.SQLException;
import java.util.List;

public interface EquipeDomain {

    void create(String nom) throws SQLException;
    void delete(int id) throws SQLException;
    Equipe[] getAll() throws SQLException;
    Equipe findById(int id) throws SQLException;
    Equipe[] findByPaysId(int paysId) throws SQLException;
}
