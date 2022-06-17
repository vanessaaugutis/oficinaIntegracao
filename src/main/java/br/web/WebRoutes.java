/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.web;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named(value = "webRoutes")
@RequestScoped
/**
 *
 * @author victor
 */
public class WebRoutes {

    public String goTo(String page) {
        System.out.println("Indo para a página " + page);
        return page + ".xhtml";
    }
    
}
