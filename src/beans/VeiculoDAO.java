package beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class VeiculoDAO {
    private Connection conexao;

    // Construtor que recebe a conexão como parâmetro
    public VeiculoDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public void adiciona(Veiculo veiculo) {
        try {
            String sqlInsert = "INSERT INTO TB_VEICULOS (MARCA, MODELO, TIPO, CARGA, ANO) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement comandoDeInsercao = conexao.prepareStatement(sqlInsert);
            comandoDeInsercao.setString(1, veiculo.getMarca());
            comandoDeInsercao.setString(2, veiculo.getModelo());
            comandoDeInsercao.setString(3, veiculo.getTipo());
            comandoDeInsercao.setString(4, veiculo.getCarga());
            comandoDeInsercao.setString(5, veiculo.getAno());

            comandoDeInsercao.executeUpdate();
            comandoDeInsercao.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
