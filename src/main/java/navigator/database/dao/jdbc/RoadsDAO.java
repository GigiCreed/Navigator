package navigator.database.dao.jdbc;

import navigator.database.dao.conectionpool.ConnectionPool;
import navigator.database.dao.interfaces.IBaseDAO;
import navigator.database.models.Cities;
import navigator.database.models.Roads;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RoadsDAO implements IBaseDAO<Roads> {
    private static final Logger LOGGER = LogManager.getLogger(RoadsDAO.class);

    @Override
    public Roads getById(Long id) {
        Connection connection = ConnectionPool.getInstance().retrieve();
        PreparedStatement preparedStatement =null;
        ResultSet resultSet = null;
        Roads roads = new Roads();
        try {
            preparedStatement = connection.prepareStatement("Select * from Roads Where id = ?");
            preparedStatement.setLong(1,id);
            resultSet =preparedStatement.executeQuery();
            while (resultSet.next()){
                roads.setId(resultSet.getLong("id"));
                roads.setDistance(resultSet.getDouble("distance"));
            }
        }catch (SQLException e){
            LOGGER.error(e);
        }finally {
            try {
                assert preparedStatement != null;
                preparedStatement.close();
                assert resultSet != null;
                resultSet.close();
            }catch (SQLException e) {
                LOGGER.error(e);
            }
            ConnectionPool.getInstance().putback(connection);
        }
        return roads;
    }

    @Override
    public List<Roads> getAll() {
        Connection connection = ConnectionPool.getInstance().retrieve();
        List<Roads> RoadsList = new ArrayList<>();
        Statement statement=null;
        ResultSet resultSet = null;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("Select * from Roads");
            while (resultSet.next()){
                Roads Roads = new Roads();

                Roads.setId(resultSet.getLong("id"));
                Roads.setDistance(resultSet.getDouble("distance"));

                RoadsList.add(Roads);
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
        return RoadsList;
    }
}
