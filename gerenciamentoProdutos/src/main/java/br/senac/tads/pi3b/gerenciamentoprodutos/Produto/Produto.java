/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3b.gerenciamentoprodutos.Produto;


public class Produto {
    
    private String nome;
    private String descricao;
    private Float precoDeVenda;
    private Float precoDeCompra;
    
    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        
        this.nome = nome;
    }
    public String getDescricao(){
        return descricao;
    }
    
   }
