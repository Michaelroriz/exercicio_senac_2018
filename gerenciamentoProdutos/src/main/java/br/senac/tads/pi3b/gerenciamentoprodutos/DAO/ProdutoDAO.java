package br.senac.tads.pi3b.gerenciamentoprodutos.DAO;

import br.senac.tads.pi3.gerenciamentoprodutos.db.utils.ConnectionUtils;
import br.senac.tads.pi3b.gerenciamentoprodutos.Produto.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author michael.aroriz
 */
public class ProdutoDAO extends ConnectionUtils{

    public Produto obterProduto(long idProduto) {
        PreparedStatement stmt = null;
        Connection conn = null;
        Produto p = null;

        String sql = "SELECT NOME, DESCRICAO, PRECO_COMPRA, PRECO_VENDA, QUANTIDADE, DT_CADASTRO WHERE ID = ?";
//em desenvolvimento...
//        try {
//            conn = obterConexao();
//            stmt = conn.prepareStatement(sql);
//            stmt.setLong(1, idProduto);
//            ResultSet resultados = stmt.executeQuery();
//        }
        return p;
    }
}
