/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package br.web;

import br.data.crud.CrudProduto;
import br.data.model.Produto;
import java.util.ArrayList;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author default
 */
@Named(value = "jsfProduto")
@RequestScoped
public class jsfProduto {

    /**
     * Creates a new instance of jsfProduto
     */
    public jsfProduto() {
    }
    
    public ArrayList<Produto> getAll(){
      return new CrudProduto().getAll();
    }
}
