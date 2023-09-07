package beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public Connection criaConexao() {
        String url = "jdbc:h2:./banco/db";
        String log = "sa";
        String senha = "";

        try {
            return DriverManager.getConnection(url, log, senha);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
