package domaine;

import modele.Equipe;
import modele.Membre;

import java.sql.SQLException;
import java.util.List;

public interface MembreDomain {

    void create(String nom) throws SQLException;
    void delete(String nom) throws SQLException;
    Membre[] getMembre() throws SQLException;
    Membre findById(int id) throws SQLException;
    Membre[] getAll() throws SQLException;
    Membre[] findTrainerByTeamId(int equipeId) throws SQLException;
    Membre[] findAllPlayerByTeamId(int equipeId) throws SQLException;
}
