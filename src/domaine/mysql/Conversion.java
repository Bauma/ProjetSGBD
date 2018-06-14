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
        String pays = null, equipe = null;


        Membre membre=  new Membre(
                resultSet.getInt(1),
                resultSet.getString(2),
                pays,
                equipe,
                resultSet.getBoolean(5),
                resultSet.getBoolean(6)
        );

        pays=resultSet.getString(3);
        if (!resultSet.wasNull()) membre.setPays(pays);
        equipe=resultSet.getString(4);
        if (!resultSet.wasNull()) membre.setEquipe(equipe);

        return membre;
    }

    public Equipe sqlToEquipe(ResultSet resultSet) throws SQLException {
        return new Equipe(
                resultSet.getInt(1),
                resultSet.getString(2),
                resultSet.getString(3)
        );

    }
}
