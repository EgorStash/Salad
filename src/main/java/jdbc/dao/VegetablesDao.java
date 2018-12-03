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

public class VegetablesDao {

    public static Ingredients parse(int id) {
        Ingredients vegetable = null;
        try (Connection connection = ConnectorManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQLQuery.SELECT_VEGETABLES_)) {
            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String title = resultSet.getString(1);
                int calories = resultSet.getInt(2);
                int day = resultSet.getInt(3);
                int month = resultSet.getInt(4);
                int year = resultSet.getInt(5);
                int validTime = resultSet.getInt(6);
                String type = resultSet.getString(7);
                String productionType = resultSet.getString(8);
                return Creator.getSomeVegetables(title, calories, LocalDate.of(year, month, day), validTime, type, productionType);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vegetable;
    }
}
