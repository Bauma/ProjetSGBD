package domaine.mysql;

import modele.Equipe;
import modele.Membre;
import modele.Pays;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Conversion {
    public Pays sqlToPays(ResultSet resultSet) throws SQLException {
        return new Pays(resultSet.getInt(1), resultSet.getString(2));
    }

    public Membre sqlToMembre(ResultSet resultSet) throws SQLException {
        return new Membre(
                resultSet.getInt(1),
                resultSet.getString(2),
                resultSet.getString(3),
                resultSet.getString(4),
                resultSet.getBoolean(5),
                resultSet.getBoolean(6)
        );



    }

    public Equipe sqlToEquipe(ResultSet resultSet) throws SQLException {
        return new Equipe(
                resultSet.getInt(1),
                resultSet.getString(2),
                resultSet.getString(3)
        );

    }
}
