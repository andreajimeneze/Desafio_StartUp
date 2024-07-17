package cl.praxis.startup2.connection;

import lombok.Getter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Getter
public class MySqlConnection  {
    private static MySqlConnection instance;
    private Connection connection;
    private String jdbcURL = "jdbc:mysql://localhost:3306/startup";
    private String jdbcUserName = "root";
    private String jdbcPassword = "1234";

    private MySqlConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection(jdbcURL, jdbcUserName, jdbcPassword);
        } catch(ClassNotFoundException | SQLException e) {
            throw new SQLException(e);
        }
    }

    public static MySqlConnection getInstance() throws SQLException {
        if(instance == null) {
            instance = new MySqlConnection();
        } else if(instance.getConnection().isClosed()) {
            instance = new MySqlConnection();
        }
        return instance;
    }
}