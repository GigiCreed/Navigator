package navigator.database.dao.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.Reader;

public class MyBatisUtil {
    private static final Logger LOGGER = LogManager.getLogger(MyBatisUtil.class);
    private static SqlSessionFactory factory;

    private MyBatisUtil(){
    }
    static
    {
        Reader reader = null;
        try {
            reader = Resources.getResourceAsReader("mybatisfiles/mybatis-config.xml");
        }catch (IOException e){
            LOGGER.error(e);
        }
        factory = new SqlSessionFactoryBuilder().build(reader);
    }

    public static SqlSessionFactory getSqlSessionFactory(){
        return factory;
    }
}