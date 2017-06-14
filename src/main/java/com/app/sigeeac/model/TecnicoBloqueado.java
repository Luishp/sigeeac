/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.sigeeac.model;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "TECNICO_BLOQUEADO", catalog = "", schema = "GEEAC")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TecnicoBloqueado.findAll", query = "SELECT t FROM TecnicoBloqueado t")
    , @NamedQuery(name = "TecnicoBloqueado.findByTcbId", query = "SELECT t FROM TecnicoBloqueado t WHERE t.tcbId = :tcbId")
    , @NamedQuery(name = "TecnicoBloqueado.findByTcbDescripcion", query = "SELECT t FROM TecnicoBloqueado t WHERE t.tcbDescripcion = :tcbDescripcion")
    , @NamedQuery(name = "TecnicoBloqueado.findByFecCrea", query = "SELECT t FROM TecnicoBloqueado t WHERE t.fecCrea = :fecCrea")
    , @NamedQuery(name = "TecnicoBloqueado.findByUsuCrea", query = "SELECT t FROM TecnicoBloqueado t WHERE t.usuCrea = :usuCrea")
    , @NamedQuery(name = "TecnicoBloqueado.findByFecModi", query = "SELECT t FROM TecnicoBloqueado t WHERE t.fecModi = :fecModi")
    , @NamedQuery(name = "TecnicoBloqueado.findByUsuModi", query = "SELECT t FROM TecnicoBloqueado t WHERE t.usuModi = :usuModi")
    , @NamedQuery(name = "TecnicoBloqueado.findByRegActivo", query = "SELECT t FROM TecnicoBloqueado t WHERE t.regActivo = :regActivo")})
public class TecnicoBloqueado implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "TCB_ID")
    public Integer tcbId;
    @Size(max = 4000)
    @Column(name = "TCB_DESCRIPCION")
    public String tcbDescripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FEC_CREA")
    @Temporal(TemporalType.TIMESTAMP)
    public Date fecCrea;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "USU_CREA")
    public String usuCrea;
    @Column(name = "FEC_MODI")
    @Temporal(TemporalType.TIMESTAMP)
    public Date fecModi;
    @Size(max = 6)
    @Column(name = "USU_MODI")
    public String usuModi;
    @Basic(optional = false)
    @NotNull
    @Column(name = "REG_ACTIVO")
    public short regActivo;
    @JoinColumn(name = "TCB_ING_ID", referencedColumnName = "ING_ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    public InstitucionGubernamental tcbIngId;
    @JoinColumn(name = "TCB_TEC_ID", referencedColumnName = "TEC_ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    public Tecnico tcbTecId;

    public TecnicoBloqueado() {
    }

    public TecnicoBloqueado(Integer tcbId) {
        this.tcbId = tcbId;
    }

    public TecnicoBloqueado(Integer tcbId, Date fecCrea, String usuCrea, short regActivo) {
        this.tcbId = tcbId;
        this.fecCrea = fecCrea;
        this.usuCrea = usuCrea;
        this.regActivo = regActivo;
    }

    public Integer getTcbId() {
        return tcbId;
    }

    public void setTcbId(Integer tcbId) {
        this.tcbId = tcbId;
    }

    public String getTcbDescripcion() {
        return tcbDescripcion;
    }

    public void setTcbDescripcion(String tcbDescripcion) {
        this.tcbDescripcion = tcbDescripcion;
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

    public InstitucionGubernamental getTcbIngId() {
        return tcbIngId;
    }

    public void setTcbIngId(InstitucionGubernamental tcbIngId) {
        this.tcbIngId = tcbIngId;
    }

    public Tecnico getTcbTecId() {
        return tcbTecId;
    }

    public void setTcbTecId(Tecnico tcbTecId) {
        this.tcbTecId = tcbTecId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tcbId != null ? tcbId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TecnicoBloqueado)) {
            return false;
        }
        TecnicoBloqueado other = (TecnicoBloqueado) object;
        if ((this.tcbId == null && other.tcbId != null) || (this.tcbId != null && !this.tcbId.equals(other.tcbId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.app.sigeeac.model.TecnicoBloqueado[ tcbId=" + tcbId + " ]";
    }
    
}
