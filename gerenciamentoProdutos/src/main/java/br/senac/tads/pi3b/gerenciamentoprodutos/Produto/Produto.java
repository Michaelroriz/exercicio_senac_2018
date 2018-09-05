/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3b.gerenciamentoprodutos.Produto;

public class Produto {

    private long id;
    private String nome;
    private String descricao;
    private float precoDeVenda;
    private float precoDeCompra;
    private int quantidade;

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {

        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getprecoDeVenda() {
        return precoDeVenda;
    }

    public void setprecoDeVenda(float precoDeVenda) {
        this.precoDeVenda = precoDeVenda;
    }

    public float getprecoDeCompra() {
        return precoDeCompra;
    }

    public void setprecoDeCompra(float precoDeCompra) {
        this.precoDeCompra = precoDeCompra;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
}
