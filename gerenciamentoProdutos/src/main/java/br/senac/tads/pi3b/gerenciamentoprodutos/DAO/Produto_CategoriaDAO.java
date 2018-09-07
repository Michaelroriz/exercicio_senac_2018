/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3b.gerenciamentoprodutos.DAO;

import Produto_Categoria.Produto_Categoria;
import br.senac.tads.pi3.gerenciamentoprodutos.db.utils.ConnectionUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author michael.aroriz
 */
public class Produto_CategoriaDAO extends ConnectionUtils {
    public void consultarProdutoCategorizado(long idProduto) {
        PreparedStatement stmt = null;
        Connection conn = null;

        String sql = "SELECT ID_PRODUTO, ID_CATEGORIA FROM PRODUTOBD.PRODUTO_CATEGORIA WHERE ID_PRODUTO = ?";

        try {
            conn = obterConexao();
            stmt = conn.prepareStatement(sql);
            stmt.setLong(1, idProduto);
            ResultSet resultado = stmt.executeQuery();
            while (resultado.next()) {
                
                System.out.println("ID_PRODUTO: "+resultado.getString(1) + " ID_CATEGORIA: "
                        + resultado.getString(2));
                
            }
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
    public void categorizarProduto(long id_produto) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Defina a categoria abaixo do produto: ");
        System.out.println("(1) Categoria 1");
        System.out.println("(2) Categoria 2");
        System.out.println("(3) Categoria 3");
        System.out.println("(4) Categoria 4");
        System.out.println("(5) Categoria 5");
        int categoria = entrada.nextInt();
        // 1) Abrir conexao
        PreparedStatement stmt = null;
        Connection conn = null;

        String sql = "INSERT INTO PRODUTOBD.PRODUTO_CATEGORIA (ID_PRODUTO, ID_CATEGORIA)"
                + "VALUES (?, ?)";

        try {
            conn = obterConexao();
            stmt = conn.prepareStatement(sql);
            stmt.setLong(1, id_produto);
            stmt.setLong(2, categoria);
            
            // 2) Executar SQL
            stmt.executeUpdate();
            System.out.println("Produto categorizado com sucesso");

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
    public List<Produto_Categoria> listar() {
        PreparedStatement stmt = null;
        Connection conn = null;

        String sql = "SELECT ID_PRODUTO, ID_CATEGORIA FROM PRODUTOBD.PRODUTO_CATEGORIA";

        List<Produto_Categoria> lista = new ArrayList<Produto_Categoria>();
        try {
            conn = obterConexao();
            stmt = conn.prepareStatement(sql);
            ResultSet resultados = stmt.executeQuery(sql);

            while (resultados.next()) {
                Long id_categoria = resultados.getLong("ID_CATEGORIA");
                int id_prod = resultados.getInt("ID_PRODUTO");                
                System.out.println(id_prod+" " +id_categoria);
                
            }

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
        return lista;
    }
}
