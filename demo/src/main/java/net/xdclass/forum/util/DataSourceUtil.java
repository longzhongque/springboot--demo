package net.xdclass.forum.util;

import org.apache.commons.dbcp2.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.util.Properties;

public class DataSourceUtil {

    private static DataSource dataSource;

    static {
        try {
            InputStream inputStream = DataSourceUtil.class.getClassLoader().getResourceAsStream("database.properties");
            Properties p = new Properties();
            p.load(inputStream);
            dataSource = BasicDataSourceFactory.createDataSource(p);
        }catch (Exception e){
            e.printStackTrace();
            throw new ExceptionInInitializerError("初始化失败");
        }

    }

    public static DataSource getDataSource(){
        return dataSource;
    }
}
