package domaine;


import modele.Membre;

import java.sql.SQLException;


public interface MembreDomain {

    void create(String nom, int nationnalite) throws SQLException;
    void delete(String nom) throws SQLException;
    void leaveEquipe(int nomMembre) throws SQLException;
    void updateNomMembre(String nom, int id) throws SQLException;
    Membre[] getMembre() throws SQLException;
    Membre findById(int id) throws SQLException;
    Membre[] getAll() throws SQLException;
    Membre[] findTrainerByTeamId(int equipeId) throws SQLException;
    Membre[] findAllPlayerByTeamId(int equipeId) throws SQLException;
    void updateMembreEquipe(int idMembre, int idEquipe, int isJoueur, int isEntraineur, String nomMembre) throws SQLException;
    void createMembreEquipe(int idMembre, int idEquipe, int isJoueur, int isEntraineur) throws SQLException;

}
