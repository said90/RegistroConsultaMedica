/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appconsultas.controller;


import com.appconsultas.model.Usuario;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuElement;
import org.primefaces.model.menu.MenuModel;

/**
 *
 * @author bsf_o
 */
@Named
@SessionScoped
public class LoginController implements Serializable {

    
  
    private MenuModel model;
  

    @PostConstruct
    public void init() {

        this.listarMenus();
        model = new DefaultMenuModel();

    }

    public void listarMenus() {
        try {

        } catch (Exception e) {
        }

    }

    public void establecerPermisos() {

        Usuario us = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
        DefaultSubMenu sub;
        List<MenuElement> elementos = model.getElements();

      
            
    }

    public void cerrarSesion() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
    }





    public MenuModel getModel() {
        return model;
    }

    public void setModel(MenuModel model) {
        this.model = model;
    }

 

}
