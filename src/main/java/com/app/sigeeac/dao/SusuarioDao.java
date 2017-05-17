/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.sigeeac.dao;

import com.app.sigeeac.model.Susuario;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author luish
 */
public interface SusuarioDao extends CrudRepository<Susuario, Integer> {
    Integer findByUsrId();
    String findByUsrCarnet();
    String findByUsrNombre();
    String findByUsrApellido();
    String findByUsrDui();
    String findByUsrNit();
    String findByUsrUsuario();
    String findByUsrContrasenia();
    //String findByFecCrea();
}
