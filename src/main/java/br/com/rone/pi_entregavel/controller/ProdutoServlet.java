/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rone.pi_entregavel.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.com.rone.pi_entregavel.model.Produto;
import br.com.rone.pi_entregavel.model.Categoria;
import br.com.rone.pi_entregavel.dao.ProdutoDAO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rbezerra
 */
@WebServlet(name = "InclusaoProdutoServlet", urlPatterns = {"/produto/inclusao"})
public class ProdutoServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        
        // Carregar aqui os departamentos
        List<Categoria> categorias = new ArrayList<Categoria>();

        try {
           categorias = ProdutoDAO.obterCategoria();
        } catch (Exception e) {
             e.printStackTrace();
        }
          
        request.setAttribute("categoria", categorias);
        
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/WEB-INF/Produto/form.jsp");
        dispatcher.forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String nome = request.getParameter("nome");
        String descricao = request.getParameter("descricao");
        String precoCompraStr = request.getParameter("prcompra");
        String precoVendaStr = request.getParameter("prvenda");
        String qtdStr = request.getParameter("qtd");
        String dispStr = request.getParameter("disp");
        String[] categorias = request.getParameterValues("cat");

        Double precoCompra = new Double(precoCompraStr);
        Double precoVenda = new Double(precoVendaStr);
        int qtd = Integer.parseInt(qtdStr);
        int disp = Integer.parseInt(dispStr);

        Produto p = new Produto(nome, descricao, precoCompra, precoVenda, qtd, disp, categorias);
        
        try {
           ProdutoDAO.inserir(p);
        } catch (Exception e) {

        }
        
        request.setAttribute("prod", p);
        
        RequestDispatcher dispatcher
                = request.getRequestDispatcher(
                        "/WEB-INF/Produto/resultado.jsp");
        dispatcher.forward(request, response);
        
    }
}
