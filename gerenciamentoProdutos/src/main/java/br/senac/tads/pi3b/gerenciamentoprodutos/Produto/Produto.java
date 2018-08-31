/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3b.gerenciamentoprodutos.Produto;


public class Produto {
    private Long id;
    private String nome;
    private String descricao;
    private Float precoDeVenda;
    private Float precoDeCompra;
    
    
    public Long getId(){
        return id;
    }
    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        
        this.nome = nome;
    }
    public String getDescricao(){
        return descricao;
    }
    public void setDescricao(String descricao)
    {
        this.descricao = descricao;
    }
    public Float getprecoDeVenda(){
        return precoDeVenda;
    }
    public void setprecoDeVenda(Float precoDeVenda){
        this.precoDeVenda = precoDeVenda;
    }
    public Float getprecoDeCompra(){
        return precoDeCompra;
    }
    public void getprecoDeCompra(Float precoDeCompra){
        this.precoDeCompra = precoDeCompra;
    }
   }
