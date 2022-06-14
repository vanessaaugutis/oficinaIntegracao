/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package br.web;

import java.util.ArrayList;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author default
 */
@Named(value = "jsfMessages")
@ApplicationScoped
public class JsfMessages {

    /**
     * Creates a new instance of JsfMessages
     */
    
    private ArrayList<String> lmessages;
    public JsfMessages() {
        lmessages = new ArrayList<>();
    }
    
    public ArrayList<String> getMessages(){
        return lmessages;
    }
    
    public void addMessage(){
        String mess = this.toString() + " : " + msg;
        lmessages.add(mess);
    }
    
    
    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    
    
}
