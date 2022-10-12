package navigator.database.dao.jdbc;

import navigator.database.dao.conectionpool.ConnectionPool;
import navigator.database.dao.interfaces.IBaseDAO;
import navigator.database.models.Cities;
import navigator.database.models.Road;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CitiesDAO implements IBaseDAO<Cities> {
    private static final Logger LOGGER = LogManager.getLogger(CitiesDAO.class);

    @Override
    public Cities getById(Long id) {
        Connection connection = ConnectionPool.getInstance().retrieve();
        PreparedStatement preparedStatement =null;
        ResultSet resultSet = null;
        Cities cities = new Cities();
        try {
            preparedStatement = connection.prepareStatement("Select * from cities Where id = ?");
            preparedStatement.setLong(1,id);
            resultSet =preparedStatement.executeQuery();
            while (resultSet.next()){
                cities.setId(resultSet.getLong("id"));
                cities.setName(resultSet.getString("name"));
                cities.setLatitudeX(resultSet.getDouble("latitude_x"));
                cities.setLongitudeY(resultSet.getDouble("longitude_y"));
            }
        }catch (SQLException e){
            LOGGER.error(e);
        }finally {
            try {
                assert preparedStatement != null;
                preparedStatement.close();
                resultSet.close();
            }catch (SQLException e) {
             LOGGER.error(e);
            }
        }
        return cities;
    }

    @Override
    public List<Cities> getAll() {
        Connection connection = ConnectionPool.getInstance().retrieve();
        List<Cities> citiesList = new ArrayList<>();
        Statement statement=null;
        ResultSet resultSet = null;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("Select * from cities");
            while (resultSet.next()){
                Cities cities = new Cities();

                cities.setId(resultSet.getLong("id"));
                cities.setName(resultSet.getString("name"));
                cities.setLatitudeX(resultSet.getDouble("latitude_x"));
                cities.setLongitudeY(resultSet.getDouble("longitude_y"));


                citiesList.add(cities);
            }

        }catch (SQLException e){
            LOGGER.error(e);
        }finally {
            try {
                assert statement != null;
                statement.close();
                assert resultSet != null;
                resultSet.close();
            } catch (SQLException e) {
                LOGGER.error(e);
            }
            ConnectionPool.getInstance().putback(connection);
        }
        return citiesList;
    }
}
