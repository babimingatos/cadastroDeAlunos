package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class Conexao {
	public static Statement statement = null;
	public static Connection connection = null;

	public Conexao() {
		String servidor = "jdbc:mysql://localhost:3306/cadastro";
		String usuario = "root";
		String senha = "";
		String driver = "com.mysql.jdbc.Driver"; // o driver tem que estar na pasta

		try {
			Class.forName(driver);
			connection = (Connection) DriverManager.getConnection(servidor, usuario, senha);
			statement = connection.createStatement();
			JOptionPane.showMessageDialog(null, "Conexão efetuada");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}

	}

	public Connection getConexao() {
		return connection;
	}

}
