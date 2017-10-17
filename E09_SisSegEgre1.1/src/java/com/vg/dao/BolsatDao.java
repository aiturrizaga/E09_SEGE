package com.vg.dao;

import com.vg.model.Bolsat;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BolsatDao extends Dao{

    public List<Bolsat> lstBolsaTrabajo() throws Exception{
        List<Bolsat> lista;
        ResultSet rs;
        try {
            this.Conexion();
            String sql = "SELECT * FROM BOLSATRABAJO";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            rs = ps.executeQuery();
            lista = new ArrayList();
            Bolsat bol;
            while(rs.next()){
                bol = new Bolsat();
                bol.setCod_bol(rs.getInt("COD_BOL"));
                bol.setEsp_bol(rs.getString("ESP_BOL"));
                bol.setNom_emp(rs.getString("NOM_EMP"));
                bol.setDes_bol(rs.getString("DES_BOL"));
                lista.add(bol);
            }
        } catch (SQLException e) {
            throw e;
        }
        return lista;
    }
    
}
