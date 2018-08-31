package br.senac.tads.pi3b.gerenciamentoprodutos;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author michael.aroriz
 */
public class Menu {

    private Connection obterConexao() throws ClassNotFoundException, SQLException {
        Connection conn = null;
        Class.forName("com.mysql.jdbc.Driver");
        conn = (Connection) DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/gerenciador-produto",
                "root",
                "");
        return conn;
    }

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
  
        System.out.println("Digite a opção desejada abaixo:");
        System.out.println("(1) Consultar produto");
        System.out.println("(2) Incluir produto");
        System.out.println("(3) Alterar produto");
        System.out.println("(4) Excluir produto");
        System.out.println("(0) Sair");
        int opcao = entrada.nextInt();
        do{        
        
            switch (opcao) {
                case 1:
                case 2:
                case 3:
                case 4:
                default:
                    System.out.print("opcao inválida, digite novamente");
                    opcao = entrada.nextInt();
                    break;
            }
        }while(opcao!=0);

    }
}
