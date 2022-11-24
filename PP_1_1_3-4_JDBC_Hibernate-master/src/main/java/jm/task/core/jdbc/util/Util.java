package jm.task.core.jdbc.util;

import org.hibernate.engine.jdbc.spi.SqlExceptionHelper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    static final String url = "jdbc:postgresql://localhost:5432/postgres";
    static final String user = "postgres";
    static final String password = "postgres";


    public static Connection getConnection(){
        Connection connection = null;
        try{
            connection = DriverManager.getConnection(url, user, password);
        }
        catch(SQLException e){
            System.out.println("connection failed");
        }
        return connection;
    }
}
