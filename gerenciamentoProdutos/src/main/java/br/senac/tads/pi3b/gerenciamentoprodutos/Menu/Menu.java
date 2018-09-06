package br.senac.tads.pi3b.gerenciamentoprodutos.Menu;

import br.senac.tads.pi3b.gerenciamentoprodutos.DAO.ProdutoDAO;
import java.util.Scanner;

/**
 *
 * @author michael.aroriz
 */
public class Menu {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        ProdutoDAO p = new ProdutoDAO();
        int opcao = -1;
        do{ 
        System.out.println("Digite a opção desejada abaixo:");
        System.out.println("(1) Consultar produto");
        System.out.println("(2) Incluir produto");
        System.out.println("(3) Alterar produto");
        System.out.println("(4) Excluir produto");
        System.out.println("(5) Listar produto");
        System.out.println("(0) Sair");
        opcao = entrada.nextInt();
               
        
            switch (opcao) {
                case 1:
                    System.out.println("ID do produto a ser consultado: ");
                    long id_concultar = entrada.nextLong();
                    p.consultarProduto(id_concultar);
                    break;
                case 2:
                    p.incluirProduto();
                    break;
                case 3:
                    System.out.println("ID do produto a ser alterado: ");
                    long id_alterar = entrada.nextLong();
                    p.alterarDados(id_alterar);
                    break;
                case 4:
                    System.out.println("ID do produto a ser excluido: ");
                    long id_excluir = entrada.nextLong();
                    p.excluirProduto(id_excluir);
                    break;
                case 5:
                    p.listar();
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("opcao inválida, digite novamente");                   
                    break;
            }
        }while(opcao!=0);

    }
}
