/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.model.rules;

import br.data.model.ItemCompra;
import br.data.model.Produto;
import java.util.ArrayList;

/**
 *
 * @author default
 */
public class Comprar {
    private ArrayList<ItemCompra> litems;

    public Comprar() {
        litems = new ArrayList<>();
    }
    
    public ArrayList<ItemCompra> getAll(){
        return litems;
    }
    
    public void addProduto(Produto produto){
        boolean achou=false;
        for (ItemCompra litem : litems) {
            if(litem.getProduto().getCodigo()==produto.getCodigo()){
                litem.setQuantidade(litem.getQuantidade()+1);
                achou=true;
                break;
            }
        }
        if(!achou){
            litems.add(new ItemCompra(produto));
        }
    }
    
    public void saidera(){ //encerrar compra
         
        litems.clear();
        
    }
    
    public void removeProduto(Produto produto){
        ItemCompra lctemp=null;
        for (ItemCompra litem : litems) {
            if(litem.getProduto().getCodigo()==produto.getCodigo()){
                litem.setQuantidade(litem.getQuantidade()-1);
                if(litem.getQuantidade()==0){
                   lctemp=litem;
                }
            }
        }
        litems.remove(lctemp);
      
    }
}
