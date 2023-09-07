package beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
<<<<<<< HEAD

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
=======
	 
	public Connection criaConexao() {
		String url = "jdbc:h2:./banco/db;AUTO_SERVER=TRUE;";
		String log = "sa";
		String senha = "";
		
		try {
			return DriverManager.getConnection(url,log,senha);
		} catch(SQLException e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	
	
>>>>>>> 353abf6b4f7b5876ea2536dae5ea869534795748
}
