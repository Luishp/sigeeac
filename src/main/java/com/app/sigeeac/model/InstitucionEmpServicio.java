/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.sigeeac.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author luish
 */
@Entity
@Table(name = "INSTITUCION_EMP_SERVICIO", catalog = "", schema = "GEEAC")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InstitucionEmpServicio.findAll", query = "SELECT i FROM InstitucionEmpServicio i")
    , @NamedQuery(name = "InstitucionEmpServicio.findByIesId", query = "SELECT i FROM InstitucionEmpServicio i WHERE i.iesId = :iesId")
    , @NamedQuery(name = "InstitucionEmpServicio.findByIesDescripcion", query = "SELECT i FROM InstitucionEmpServicio i WHERE i.iesDescripcion = :iesDescripcion")
    , @NamedQuery(name = "InstitucionEmpServicio.findByFecCrea", query = "SELECT i FROM InstitucionEmpServicio i WHERE i.fecCrea = :fecCrea")
    , @NamedQuery(name = "InstitucionEmpServicio.findByUsuCrea", query = "SELECT i FROM InstitucionEmpServicio i WHERE i.usuCrea = :usuCrea")
    , @NamedQuery(name = "InstitucionEmpServicio.findByFecModi", query = "SELECT i FROM InstitucionEmpServicio i WHERE i.fecModi = :fecModi")
    , @NamedQuery(name = "InstitucionEmpServicio.findByUsuModi", query = "SELECT i FROM InstitucionEmpServicio i WHERE i.usuModi = :usuModi")
    , @NamedQuery(name = "InstitucionEmpServicio.findByRegActivo", query = "SELECT i FROM InstitucionEmpServicio i WHERE i.regActivo = :regActivo")})
public class InstitucionEmpServicio implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IES_ID")
    private Integer iesId;
    @Size(max = 4000)
    @Column(name = "IES_DESCRIPCION")
    private String iesDescripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FEC_CREA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecCrea;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "USU_CREA")
    private String usuCrea;
    @Column(name = "FEC_MODI")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecModi;
    @Size(max = 6)
    @Column(name = "USU_MODI")
    private String usuModi;
    @Basic(optional = false)
    @NotNull
    @Column(name = "REG_ACTIVO")
    private short regActivo;
    @JoinColumn(name = "IES_EMP_ID", referencedColumnName = "EMP_ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private EmpresaServicio iesEmpId;
    @JoinColumn(name = "IES_ING_ID", referencedColumnName = "ING_ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private InstitucionGubernamental iesIngId;

    public InstitucionEmpServicio() {
    }

    public InstitucionEmpServicio(Integer iesId) {
        this.iesId = iesId;
    }

    public InstitucionEmpServicio(Integer iesId, Date fecCrea, String usuCrea, short regActivo) {
        this.iesId = iesId;
        this.fecCrea = fecCrea;
        this.usuCrea = usuCrea;
        this.regActivo = regActivo;
    }

    public Integer getIesId() {
        return iesId;
    }

    public void setIesId(Integer iesId) {
        this.iesId = iesId;
    }

    public String getIesDescripcion() {
        return iesDescripcion;
    }

    public void setIesDescripcion(String iesDescripcion) {
        this.iesDescripcion = iesDescripcion;
    }

    public Date getFecCrea() {
        return fecCrea;
    }

    public void setFecCrea(Date fecCrea) {
        this.fecCrea = fecCrea;
    }

    public String getUsuCrea() {
        return usuCrea;
    }

    public void setUsuCrea(String usuCrea) {
        this.usuCrea = usuCrea;
    }

    public Date getFecModi() {
        return fecModi;
    }

    public void setFecModi(Date fecModi) {
        this.fecModi = fecModi;
    }

    public String getUsuModi() {
        return usuModi;
    }

    public void setUsuModi(String usuModi) {
        this.usuModi = usuModi;
    }

    public short getRegActivo() {
        return regActivo;
    }

    public void setRegActivo(short regActivo) {
        this.regActivo = regActivo;
    }

    public EmpresaServicio getIesEmpId() {
        return iesEmpId;
    }

    public void setIesEmpId(EmpresaServicio iesEmpId) {
        this.iesEmpId = iesEmpId;
    }

    public InstitucionGubernamental getIesIngId() {
        return iesIngId;
    }

    public void setIesIngId(InstitucionGubernamental iesIngId) {
        this.iesIngId = iesIngId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iesId != null ? iesId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InstitucionEmpServicio)) {
            return false;
        }
        InstitucionEmpServicio other = (InstitucionEmpServicio) object;
        if ((this.iesId == null && other.iesId != null) || (this.iesId != null && !this.iesId.equals(other.iesId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.app.sigeeac.model.InstitucionEmpServicio[ iesId=" + iesId + " ]";
    }
    
}
