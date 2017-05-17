/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.sigeeac.dao;

import com.app.sigeeac.model.InstitucionGubernamental;
import java.math.BigDecimal;
import java.util.Date;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author luish
 */
public interface InstitucionGubernamentalDao extends CrudRepository<InstitucionGubernamental, Integer> {
    public Integer findByIngId();
    public String findByIngCodigo();
    public String findByIngNombre();
    public String findByIngDireccion();
    public String findByIngTelefono();
    public String findByIngCorreoElectronico();
    public String findByIngDescripcion();
    //public Date pfindByFecCrea();
    public String findByUsuCrea();
    //public Date findByFecModi();
    public String findByUsuModi();
    public String findByRegActivo();
                    
}
