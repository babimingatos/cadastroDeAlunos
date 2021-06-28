
package telaPrincipal;

import java.awt.Dimension;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import model.CadastroDados;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import conexao.Conexao;
import conexao.DadosModelagem2;


public class TelaPrincipal2 extends JFrame {

	private DadosModelagem2 objDm;
	private CadastroDados dao;
	Conexao con2;
	
	private JPanel contentPane;
	private JTextField tfNome;
	private JTextField tfIdade;
	
	
	private JTextField tfId;
	private JButton btnSalvar;
	private JButton btnNovo;
	private JButton btnLimpar;
	private JButton btnEditar;
	private JButton btnDeletar;
	private JButton btnPesquisar;
	private JButton btnSair;
	private JButton btnListar;
	private JButton btnConectar;
	private JButton btnXampp;
	private JButton btnDesconectar;
	private JButton btnRelatorio;
	
	private int acao = 1;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal2 frame = new TelaPrincipal2();
					frame.setVisible(true);
					Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
					frame.setLocation((tela.width - frame.getSize().width)/2,(tela.height - frame.getSize().height)/2);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TelaPrincipal2() throws SQLException {
		setTitle("Etec Prof. Alfredo de Barros Santos - Desenvolvimento de Sistemas");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Carlos\\Documents\\Informatica\\pessoa.jpg"));
		dao = new CadastroDados();
		
		setResizable(false);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 521, 611);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 153));
		panel.setBorder(new LineBorder(new Color(30, 144, 255), 3, true));
		panel.setBounds(23, 11, 469, 55);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cadastro de Clientes");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 441, 33);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 153));
		panel_1.setBorder(new TitledBorder(new LineBorder(new Color(30, 144, 255), 3, true), "Dados:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 128)));
		panel_1.setBounds(23, 77, 469, 155);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblId = new JLabel("Id:");
		lblId.setHorizontalAlignment(SwingConstants.CENTER);
		lblId.setBounds(10, 29, 58, 40);
		panel_1.add(lblId);
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 24));
		
		tfId = new JTextField();
		tfId.setBackground(new Color(224, 255, 255));
		tfId.setBounds(102, 26, 110, 44);
		panel_1.add(tfId);
		tfId.setHorizontalAlignment(SwingConstants.CENTER);
		tfId.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tfId.setColumns(10);
		
		JLabel lblIdade = new JLabel("Idade:");
		lblIdade.setBounds(233, 23, 83, 47);
		panel_1.add(lblIdade);
		lblIdade.setFont(new Font("Tahoma", Font.PLAIN, 24));
		
		tfIdade = new JTextField();
		tfIdade.setBackground(new Color(224, 255, 255));
		tfIdade.setEditable(false);
		tfIdade.setBounds(334, 23, 110, 47);
		panel_1.add(tfIdade);
		tfIdade.setHorizontalAlignment(SwingConstants.CENTER);
		tfIdade.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tfIdade.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 92, 89, 45);
		panel_1.add(lblNome);
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 24));
		
		tfNome = new JTextField();
		tfNome.setBackground(new Color(224, 255, 255));
		tfNome.setEditable(false);
		tfNome.setBounds(102, 93, 342, 44);
		panel_1.add(tfNome);
		tfNome.setHorizontalAlignment(SwingConstants.LEFT);
		tfNome.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tfNome.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 153));
		panel_2.setBorder(new TitledBorder(new LineBorder(new Color(30, 144, 255), 3, true), "Op\u00E7\u00F5es:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 128)));
		panel_2.setBounds(23, 243, 469, 215);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(169, 23, 129, 37);
		panel_2.add(btnSalvar);
		btnSalvar.setFont(new Font("Dialog", Font.PLAIN, 20));
		
		btnDeletar = new JButton("Deletar");
		btnDeletar.setBounds(319, 71, 129, 37);
		panel_2.add(btnDeletar);
		btnDeletar.setFont(new Font("Dialog", Font.PLAIN, 20));
		
	
		btnListar = new JButton("Listar");
		btnListar.setBounds(319, 119, 129, 37);
		panel_2.add(btnListar);
		btnListar.setFont(new Font("Dialog", Font.PLAIN, 20));
		
		btnConectar = new JButton("Conectar");
		btnConectar.setBounds(21, 167, 129, 37);
		panel_2.add(btnConectar);
		btnConectar.setFont(new Font("Dialog", Font.PLAIN, 20));
		
		btnLimpar = new JButton("LImpar");
		btnLimpar.setEnabled(false);
		btnLimpar.setBounds(21, 71, 129, 37);
		panel_2.add(btnLimpar);
		btnLimpar.setFont(new Font("Dialog", Font.PLAIN, 20));
		
		btnSair = new JButton("Sair");
		btnSair.setBounds(169, 119, 129, 37);
		panel_2.add(btnSair);
		btnSair.setFont(new Font("Dialog", Font.PLAIN, 20));
		
		btnNovo = new JButton("Novo");
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				btnNovo.setEnabled(false);
				btnSalvar.setEnabled(true);
				btnLimpar.setEnabled(true);
				btnPesquisar.setEnabled(false);
				tfNome.setEditable(true);
				tfIdade.setEditable(true);
				tfId.setEditable(false);
				btnDeletar.setEnabled(false);
				btnListar.setEnabled(false); 
				tfNome.requestFocus();
			}
		});
		btnNovo.setFont(new Font("Dialog", Font.PLAIN, 20));
		btnNovo.setBounds(21, 23, 129, 37);
		panel_2.add(btnNovo);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelar();
			}
		});
		btnCancelar.setFont(new Font("Dialog", Font.PLAIN, 20));
		btnCancelar.setBounds(319, 23, 129, 37);
		panel_2.add(btnCancelar);
		
		btnEditar = new JButton("Editar");
		btnEditar.setBounds(169, 71, 129, 37);
		panel_2.add(btnEditar);
		btnEditar.setFont(new Font("Dialog", Font.PLAIN, 20));
		
		btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setBounds(21, 119, 129, 37);
		panel_2.add(btnPesquisar);
		btnPesquisar.setFont(new Font("Dialog", Font.PLAIN, 20));
		
		btnDesconectar = new JButton("Desconectar");
		btnDesconectar.setBounds(319, 167, 129, 37);
		panel_2.add(btnDesconectar);
		btnDesconectar.setFont(new Font("Dialog", Font.PLAIN, 16));
		
		btnXampp = new JButton("");
		btnXampp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					abrirArquivo();
			}
		});
		btnXampp.setFont(new Font("Dialog", Font.PLAIN, 20));
		btnXampp.setBounds(169, 167, 129, 37);
		panel_2.add(btnXampp);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 153));
		panel_3.setBorder(new TitledBorder(new LineBorder(new Color(30, 144, 255), 3, true), "Gerar relat\u00F3rio:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 128)));
		panel_3.setBounds(23, 470, 469, 91);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		btnRelatorio = new JButton("Relat\u00F3rio");
		btnRelatorio.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnRelatorio.setBounds(10, 20, 449, 55);
		panel_3.add(btnRelatorio);
		btnRelatorio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				con2 = new Conexao();
				con2.getConexao();
				
				try {
					con2 = new Conexao();
					con2.getConexao();
					// classe JasperPrint: usada para preparar a impressão do relatório
					// teste.jasper é o nome do relatório criado no iReport
					JasperPrint print = JasperFillManager.fillReport("C:/Reports/teste.jasper", null, con2.getConexao());
					
					// JasperViewer: exibe o relatório
					JasperViewer.viewReport(print,false); 
				}catch (Exception er) {
					JOptionPane.showMessageDialog(null, "Erro: \n" + er.getMessage());
				}
			}// fim do método
		});
		btnDesconectar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dao.desconectar();
			}
		});
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{  // é obrigatório por causa do trows no método Pesquisar
						if(tfId.getText().equals("")){
							JOptionPane.showMessageDialog(null, "Preenha o campo Id");
							tfId.requestFocus();
						}else{
							DadosModelagem2 objDm = dao.Pesquisar(Integer.parseInt(tfId.getText()));  // pega o conteúdo da cx para pesquisa
							if(objDm == null){
								JOptionPane.showMessageDialog(null, "Não foi possível encontrar o registro");
								tfId.setText("");
								tfId.requestFocus();
							}else{
								tfId.setText(String.valueOf(objDm.getId()));
								tfNome.setText(objDm.getNome());
								tfIdade.setText(String.valueOf(objDm.getIdade()));
								
							}
						}
				}catch (Exception erro ) {
						JOptionPane.showMessageDialog(null, "Erro " + erro.getMessage()); 
				}
					cancelar();
				}
		
			
		});
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				edicao(); 
			}
		});
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int resp = JOptionPane.showConfirmDialog(null,"Deseja sair do programa?","Sair", JOptionPane.YES_NO_OPTION);
				if(resp == 0){
					System.exit(0);
				}
			}
		});
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limpar();
			}
		});
		btnConectar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Conexao con2 = new Conexao();
				con2.getConexao();
			}
		});
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dao.listar();
			}
		});
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if(tfId.equals("")) {
						JOptionPane.showMessageDialog(null, "Preencha o campo Id");
					}else if(dao.deletar(Integer.parseInt(tfId.getText()))) {	
						JOptionPane.showMessageDialog(null, "Registro excluido com sucesso");
						limpar();
					}else {
						JOptionPane.showMessageDialog(null, "Nao foi possível excluir o registro");
						limpar();
					}
				}catch (Exception e) {
					JOptionPane.showMessageDialog(null, "ERRO - Preencha o campo Idade \n" + e.getMessage());
					limpar();
				}
				
				cancelar();
			}
		});
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try { 
					
					if(acao == 1) {
							    if(preencherObjetoSalvar()) { 
									if(validarCampos()) { 
												if(dao.salvar(objDm)) {
													JOptionPane.showMessageDialog(null, "Salvo com sucesso");
													limpar();
												}
									} else { // validar
										JOptionPane.showMessageDialog(null, "Não inserido");
									}
									
								} 	//preenchar objeto	
									
					} // ação
					
					
					if(acao == 2) {
							
									
							if(validarCampos()) {	
										  if(preencherObjetoEditar()) {
												if(dao.editar(objDm)) {
													JOptionPane.showMessageDialog(null, "Salvo com sucesso");
													limpar();
													acao = 1;
												}
										  } // preencherobjetoEditar
							} else { // validar
								JOptionPane.showMessageDialog(null, "Não inserido");
							}
					}
								
						
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "ERRO SALVAR: " + e.getMessage());
				}
				cancelar();
			} // fim do método
		});
	}
	
	
	public void limpar() {
		tfNome.setText(null);
		tfIdade.setText(null);
		tfId.setText(null);
		tfId.requestFocus();
	}
	
	
		
	public boolean preencherObjetoEditar(){ // método que verifica se o objeto está preenchido
		objDm = new DadosModelagem2();
		objDm.setId(Integer.parseInt(tfId.getText()));
		objDm.setNome(tfNome.getText()); 
		objDm.setIdade(Integer.parseInt(tfIdade.getText()));
		return true;
	}
	
	public boolean validarCampos(){
		if(tfNome.getText().equals("")){
			JOptionPane.showMessageDialog(null, "Preencha o campo Nome");
			tfNome.requestFocus();
			return false;
		}
		
		if(tfIdade.getText().equals("")){
			JOptionPane.showMessageDialog(null, "Preencha o campo Idade");
			tfIdade.requestFocus();
			return false;
		}
		
		return true;
	}
	
	 
	
	public boolean preencherObjetoSalvar(){ // método que verifica se o objeto está preenchido
		objDm = new DadosModelagem2();
		objDm.setNome(tfNome.getText());  
		objDm.setIdade(Integer.parseInt(tfIdade.getText()));
		//JOptionPane.showMessageDialog(null, "Preencha o campo Idade" + objDm);
		return true;
	}
		
	public void edicao() {
		acao = 2;
		tfIdade.setEditable(true);
		tfNome.setEditable(true);
		btnSair.setEnabled(true);	
	}
	
	
	public void cancelar() {
		btnNovo.setEnabled(true);
		btnSalvar.setEnabled(false);
		btnLimpar.setEnabled(true);
		btnPesquisar.setEnabled(true);
		tfNome.setEditable(false);
		tfIdade.setEditable(false);
		tfId.setEditable(true);
		btnDeletar.setEnabled(true);
		btnListar.setEnabled(true);
		tfId.requestFocus(); 
	}
	
	
	public void abrirArquivo() {
		 try {
			 Runtime.getRuntime().exec("cmd.exe /c start C:\\xampp");
	      } catch(IOException iOException) {
	    	  iOException.printStackTrace();
	      }
	}
	
	
}