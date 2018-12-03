package jdbc.dao;

import salad.Creator;
import salad.ingredients.*;

import jdbc.ConnectorManager;
import jdbc.SQLQuery;
import salad.Salad;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SaladDao {

    public static List<Salad> parse() {
        List<Salad> salads = new ArrayList<>();
        try (Connection connection = ConnectorManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQLQuery.GET_SALAD_TITLE)) {
            ResultSet resultSet = statement.executeQuery();
            int id =1;
            while (resultSet.next()) {
                String title = resultSet.getString(1);
                Ingredients meat = MeatDao.parse(id);
                Ingredients vegetables = VegetablesDao.parse(id);
                Ingredients souce = SouceDao.parse(id);
                Salad salad = Creator.createSalad(title, meat, vegetables, souce);
                salads.add(salad);
                id ++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return salads;
    }

}
