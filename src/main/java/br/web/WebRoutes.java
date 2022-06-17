/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.web;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

@Named(value = "webRoutes")
@RequestScoped
/**
 *
 * @author victor
 */
public class WebRoutes {

    public String goTo(String page) {
        System.out.println("regra de algo -- indo para a p1");
        return page + ".xhtml";
    }
    
}
