package com.vg.controller;

import com.vg.dao.EmpresaDao;
import com.vg.model.Empresas;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import oracle.net.aso.e;

@Named(value = "empresaController")
@SessionScoped
public class EmpresaController implements Serializable {

    Empresas emp = new Empresas();
    EmpresaDao dao;
    private List<Empresas> item;
    private Empresas selected;
    private String est = "A";
    
    @PostConstruct
    public void inicio(){
        dao = new EmpresaDao();
        try {
            listarEmpresas();
        } catch (Exception ex) {
            Logger.getLogger(EmpresaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void listarEmpresas() throws Exception{
        try {
            item = dao.lstEmpresas(est);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void agregar() throws Exception{
        try {
            dao.agregarEmp(emp);
            listarEmpresas();
        } catch (Exception e) {
            throw e;
        }
    }

    public Empresas getEmp() {
        return emp;
    }

    public void setEmp(Empresas emp) {
        this.emp = emp;
    }

    public List<Empresas> getItem() {
        return item;
    }

    public void setItem(List<Empresas> item) {
        this.item = item;
    }

    public Empresas getSelected() {
        return selected;
    }

    public void setSelected(Empresas selected) {
        this.selected = selected;
    }

    public String getEst() {
        return est;
    }

    public void setEst(String est) {
        this.est = est;
    }
    
}
