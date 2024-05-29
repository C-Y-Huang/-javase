package edu.uestc.angel.commons;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;


public class JdbcHelper {
    private static DataSource dataSource;
    private static JdbcHelper instance;
    static {
        try {
            Properties prop = new Properties();
            prop.load(JdbcHelper.class.getClassLoader().getResourceAsStream("datasource.properties"));
            dataSource = DruidDataSourceFactory.createDataSource(prop);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
    private JdbcHelper() {

    }

    public static JdbcHelper getInstance() {
        if (instance == null){
            synchronized (JdbcHelper.class){
                if (instance == null){
                    instance = new JdbcHelper();
                }
            }
        }
        return instance;
    }
    public Connection getConnection(){
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public void free(Connection conn){
        if (conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
