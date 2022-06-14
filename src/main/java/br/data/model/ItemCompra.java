/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.data.model;

import lombok.Data;

/**
 *
 * @author default
 */
@Data
public class ItemCompra {
    private Produto produto;
    private int quantidade;

    public ItemCompra(Produto produto) {
        this.produto = produto;
        this.quantidade = 1;
    }
    
    
}
