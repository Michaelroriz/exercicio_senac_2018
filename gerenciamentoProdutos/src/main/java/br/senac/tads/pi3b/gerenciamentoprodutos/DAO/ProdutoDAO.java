package br.senac.tads.pi3b.gerenciamentoprodutos.DAO;

import br.senac.tads.pi3.gerenciamentoprodutos.db.utils.ConnectionUtils;
import br.senac.tads.pi3b.gerenciamentoprodutos.Produto.Produto;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

/**
 *
 * @author michael.aroriz
 */
public class ProdutoDAO extends ConnectionUtils {

    public void consultarProduto(long idProduto) {
        PreparedStatement stmt = null;
        Connection conn = null;

        String sql = "SELECT NOME, DESCRICAO, PRECO_COMPRA, PRECO_VENDA,"
                + "QUANTIDADE, DT_CADASTRO FROM PRODUTOBD.PRODUTO WHERE ID = ?";

        try {
            conn = obterConexao();
            stmt = conn.prepareStatement(sql);
            stmt.setLong(1, idProduto);
            ResultSet resultado = stmt.executeQuery();
        } catch (Exception e) {
            System.out.println("Não foi possivel exibir as informações, falha "
                    + "de conexão com o Banco de Dados" + e);
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    System.out.println("Erro ao fechar stmt.");
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    System.out.println("Erro ao fechar conn.");
                }
            }
        }
    }

    public void incluirProduto() {
        Scanner entrada = new Scanner(System.in);
        System.out.print("Nome do produto: ");
        String nome = entrada.nextLine();
        System.out.print("Descrição do produto: ");
        String descricao = entrada.nextLine();
        System.out.print("Preço de compra: ");
        float preco_compra = entrada.nextFloat();
        System.out.print("Preço de venda: ");
        float preco_venda = entrada.nextFloat();
        System.out.print("Quantidade: ");
        int qtd = entrada.nextInt();
        // 1) Abrir conexao
        PreparedStatement stmt = null;
        Connection conn = null;

        String sql = "INSERT INTO PRODUTOBD.PRODUTO (NOME, DESCRICAO, "
                + "PRECO_COMPRA, PRECO_VENDA, QUANTIDADE, DT_CADASTRO"
                + "VALUES (?, ?, ?, ?, ?, ?)";

        try {
            conn = obterConexao();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, nome);
            stmt.setString(2, descricao);
            stmt.setFloat(3, preco_compra);
            stmt.setFloat(4, preco_venda);
            stmt.setInt(5, qtd);
            //java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
    Calendar currenttime = Calendar.getInstance();
    Date sqldate = new Date((currenttime.getTime()).getTime());

            //String dStr = java.text.DateFormat.getDateInstance(DateFormat.MEDIUM).format(date);
            stmt.setDate(6, sqldate);

            // 2) Executar SQL
            stmt.executeUpdate();
            stmt.close();
            System.out.println("Contato cadastrado com sucesso");

        } catch (SQLException e) {
            System.out.println("Não foi possível executar.");
        } catch (ClassNotFoundException e) {
            System.out.println("Não foi possível executar.");
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    System.out.println("Erro ao fechar stmt.");
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    System.out.println("Erro ao fechar conn.");
                }
            }
        }
    }

    public void excluirProduto(long idProduto) {
        PreparedStatement stmt = null;
        Connection conn = null;

        String sql = "DELETE FROM PRODUTOBD.PRODUTO WHERE ID =" + idProduto;
        try {
            conn = obterConexao();
            stmt = conn.prepareStatement(sql);
            stmt.executeUpdate();
            System.out.println("Contato excluido com sucesso");
        } catch (ClassNotFoundException e) {
            System.out.println("Não foi possível executar.");
        } catch (Exception e) {
            System.out.println("Não foi possivel exibir as informações, falha "
                    + "de conexão com o Banco de Dados" + e);
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    System.out.println("Erro ao fechar stmt.");
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    System.out.println("Erro ao fechar conn.");
                }
            }
        }
    }

    public void alterarDados(long idProduto) {
        PreparedStatement stmt = null;
        Connection conn = null;
        Produto p = new Produto();
        String sql = "UPDATE PRODUTOBD.PRODUTO SET NOME=?, DESCRICAO=?, "
                + "PRECO_COMPRA=?, PRECO_VENDA=?, QUANTIDADE=?, DT_CADASTRO=? "
                + "FROM PRODUTOBD.PRODUTO WHERE ID=" + idProduto;
        try {
            conn = obterConexao();
            stmt = conn.prepareStatement(sql);

            stmt.setString(1, p.getNome());
            stmt.setString(2, p.getDescricao());
            stmt.setFloat(3, p.getprecoDeCompra());
            stmt.setFloat(4, p.getprecoDeVenda());
            stmt.setInt(5, p.getQuantidade());
            stmt.setDate(6, new java.sql.Date(System.currentTimeMillis()));
            // 2) Executar SQL
            stmt.executeUpdate();
            System.out.println("Produto alterado com sucesso");
        } catch (SQLException e) {
            System.out.println("Não foi possível executar." + e);
        } catch (ClassNotFoundException e) {
            System.out.println("Não foi possível executar.");
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    System.out.println("Erro ao fechar stmt.");
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    System.out.println("Erro ao fechar conn.");
                }
            }
        }
    }
}
