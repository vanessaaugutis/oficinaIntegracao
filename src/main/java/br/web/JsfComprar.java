/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package br.web;

import br.data.model.ItemCompra;
import br.data.model.Produto;
import br.model.rules.Comprar;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author default
 */
@Named(value = "jsfComprar")
@SessionScoped
public class JsfComprar implements Serializable {

    /**
     * Creates a new instance of JsfComprar
     */
    private Comprar comprar;
    
    public JsfComprar() {
        comprar = new Comprar();
    }
    
    public ArrayList<ItemCompra> getLista(){
        return comprar.getAll();
    }
    
    public void add(Produto produto){
        comprar.addProduto(produto);
    }
    
    public void remove(Produto produto){
        comprar.removeProduto(produto);
    }
    
    public void saidera(){
        comprar.saidera();
    }
}
