package main.com.config;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MySqlSessionFactory {
    private static String resource = "main/resource/config/Configuration.xml";
    private static volatile SqlSessionFactory sqlSessionFactory;

    private MySqlSessionFactory() {} // Private constructor to prevent instantiation

    public static SqlSessionFactory getSqlSessionFactory() {
        if (sqlSessionFactory == null) {
            try (InputStream inputStream = Resources.getResourceAsStream(resource)) {
                // Create SqlSessionFactory
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("Failed to initialize SqlSessionFactory: " + e.getMessage(), e);
            }
        }
        return sqlSessionFactory;
    }

    public static SqlSession openSession() {
        return getSqlSessionFactory().openSession();
    }
}