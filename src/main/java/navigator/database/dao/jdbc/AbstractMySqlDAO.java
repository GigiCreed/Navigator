package navigator.database.dao.jdbc;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class AbstractMySqlDAO {
    private static final Logger LOGGER = LogManager.getLogger(AbstractMySqlDAO.class);
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            LOGGER.error("Class Not found");
        }
    }
}