/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.sigeeac.dao;

import com.app.sigeeac.model.TipoMantenimiento;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author luish
 */
public interface TipoMantenimientoDao extends CrudRepository<TipoMantenimiento, Integer> {
    
}
