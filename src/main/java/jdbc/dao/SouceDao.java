package jdbc.dao;

import salad.Creator;
import salad.ingredients.Ingredients;
import jdbc.ConnectorManager;
import jdbc.SQLQuery;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class SouceDao {

    public static Ingredients parse(int id) {
        Ingredients souce = null;
        try (Connection connection = ConnectorManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQLQuery.SELECT_SOUCE_)) {
            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String title = resultSet.getString(1);
                int calories = resultSet.getInt(2);
                int day = resultSet.getInt(3);
                int month = resultSet.getInt(4);
                int year = resultSet.getInt(5);
                int validTime = resultSet.getInt(6);
                String sourness = resultSet.getString(7);
                String sweetness = resultSet.getString(8);
                String salty = resultSet.getString(9);
                return Creator.getSomeSouce(title, calories, LocalDate.of(year, month, day), validTime, sourness, sweetness, salty);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return souce;
    }
}
