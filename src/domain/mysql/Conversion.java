package domain.mysql;

import models.Equipe;
import models.Membre;
import models.Pays;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Conversion {

    public Conversion(){}

    public Pays sqlToPays(ResultSet resultSet) throws SQLException {
        return new Pays(resultSet.getInt(1), resultSet.getString(2));
    }

    public Membre sqlToMembre(ResultSet resultSet) throws SQLException {
        return new Membre(
                resultSet.getInt(1),
                resultSet.getString(2),
                resultSet.getString(3)
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
