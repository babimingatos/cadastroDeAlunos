package model;

import javax.swing.JOptionPane;
import conexao.Conexao;
import conexao.DadosModelagem2;
import java.io.FileInputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CadastroDados {
	ResultSet resultset = null;
	Conexao con2;

	public boolean salvar(DadosModelagem2 dm) throws Exception {
		con2 = new Conexao();
		String query = "INSERT INTO pessoas (nome,idade) VALUES (?,?)";

		PreparedStatement ps = this.con2.getConexao().prepareStatement(query);

		ps.setString(1, dm.getNome());
		ps.setInt(2, dm.getIdade());

		if (ps.executeUpdate() > 0) {
			return true;
		} else {
			return false;
		}
	}

	public void listar() {
		con2 = new Conexao();
		String lista = "Id:  Nome:     -   Idade:" + "\n";
		try {
			String query = "SELECT * from pessoas";
			this.resultset = Conexao.statement.executeQuery(query);

			while (this.resultset.next()) {
				System.out.println("Id: " + this.resultset.getInt("id") + "\tNome: " + this.resultset.getString("nome")
						+ "\t\tIdade: " + this.resultset.getString("idade"));
				lista += this.resultset.getInt("id") + "    " + this.resultset.getString("nome") + "               "
						+ this.resultset.getString("idade") + "\n";
			}
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
		JOptionPane.showMessageDialog(null, lista);
	}

	public DadosModelagem2 Pesquisar(int id) throws Exception {
		// m�todo vai retornar um objeto e recebe como par�metro um int que � o id
		con2 = new Conexao();
		DadosModelagem2 objDm = null;
		String query = "Select * from pessoas where id = ?";

		/*
		 * PreparedStatement(Declara��o Preparada): um interface que padroniza as
		 * consultas SQL, ex: SELECT * FROM alunos WHERE nome = ?, onde o que muda �
		 * sempre o dado A linha de consulta, neste caso, est� guardada na String SQL O
		 * SQL fica mais r�pido: otimiza os dados e envia os dados em bin�rio ao inv�s
		 * de texto N�o � preciso se preocupar com a formata��o dos dados. Se usar:
		 * aspas, caracteres especiais, quebras de linha etc... na pesquisa, vai gerar
		 * erro, O PreparedStatement impede estes erros.
		 */

		PreparedStatement ps = con2.getConexao().prepareStatement(query);
		ps.setInt(1, id);

		// ResultSet (Conjunto de resultados): � uma interface utilizada para guardar
		// dados vindos de um banco de dados.
		// Basicamente, ela guarda o resultado de uma pesquisa numa estrutura de dados
		// que pode ser percorrida, de forma que
		// voc� possa ler os dados do banco. � preciso usar em conjunto com
		// PreparedStatement e Connection
		// ResultSet rs = ps.executeQuery(); // executeQuery(): faz a pesquisa e captura
		// as informa��es

		ResultSet rs = ps.executeQuery();

		// ExecQuery: pesquisa e captura as informa��es no BD ResultSset = guarda as
		// informa��es vinda do BD

		while (rs.next()) { // enquanto achar um registro, percorre o ResultSet
			objDm = new DadosModelagem2();
			objDm.setId(rs.getInt("id"));
			objDm.setNome(rs.getString("nome")); // passa as informa��es capturadas pelo rs e coloca no objeto. Var
													// banda = ao bd em min�scula
			objDm.setIdade(rs.getInt("idade"));
		}

		return objDm; // retorna o objeto preenchido caso encontre. se n�o encontrar retorna nulo

	}

	public boolean deletar(int id) throws SQLException {
		con2 = new Conexao();
		String query = "delete  from pessoas where id = ?";
		PreparedStatement ps = con2.getConexao().prepareStatement(query);
		ps.setInt(1, id);

		if (ps.executeUpdate() > 0) {
			return true;
		} else {
			return false;
		}
	}

	public void desconectar() {
		try {
			Conexao.connection.close();
			JOptionPane.showMessageDialog(null, "Conex�o encerrada!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

	public boolean editar(DadosModelagem2 objDm) throws Exception {
		con2 = new Conexao();

		String query = "UPDATE pessoas set nome = ?, idade = ? where pessoas.id= ? ";

		PreparedStatement ps = this.con2.getConexao().prepareStatement(query);

		// ps.setInt(1,objDm.getId());
		ps.setString(1, objDm.getNome());
		ps.setInt(2, objDm.getIdade());
		ps.setInt(3, objDm.getId());
		ps.executeUpdate();

		if (ps.executeUpdate() > 0) { // m�todo executeUpdate retorna o n� de linhas afetadas no banco de dados
			return true;
		} else
			return false;

	}

}
