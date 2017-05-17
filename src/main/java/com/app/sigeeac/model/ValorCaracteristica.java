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
@Table(name = "VALOR_CARACTERISTICA", catalog = "", schema = "GEEAC")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ValorCaracteristica.findAll", query = "SELECT v FROM ValorCaracteristica v")
    , @NamedQuery(name = "ValorCaracteristica.findByVcaId", query = "SELECT v FROM ValorCaracteristica v WHERE v.vcaId = :vcaId")
    , @NamedQuery(name = "ValorCaracteristica.findByFecCrea", query = "SELECT v FROM ValorCaracteristica v WHERE v.fecCrea = :fecCrea")
    , @NamedQuery(name = "ValorCaracteristica.findByUsuCrea", query = "SELECT v FROM ValorCaracteristica v WHERE v.usuCrea = :usuCrea")
    , @NamedQuery(name = "ValorCaracteristica.findByFecModi", query = "SELECT v FROM ValorCaracteristica v WHERE v.fecModi = :fecModi")
    , @NamedQuery(name = "ValorCaracteristica.findByUsuModi", query = "SELECT v FROM ValorCaracteristica v WHERE v.usuModi = :usuModi")
    , @NamedQuery(name = "ValorCaracteristica.findByRegActivo", query = "SELECT v FROM ValorCaracteristica v WHERE v.regActivo = :regActivo")})
public class ValorCaracteristica implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "VCA_ID")
    private Integer vcaId;
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
    @JoinColumn(name = "VCA_EQE_ID", referencedColumnName = "EQE_ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private EquipoElectrico vcaEqeId;
    @JoinColumn(name = "VCA_LSC_ID", referencedColumnName = "LSC_ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ListaCaracteristica vcaLscId;

    public ValorCaracteristica() {
    }

    public ValorCaracteristica(Integer vcaId) {
        this.vcaId = vcaId;
    }

    public ValorCaracteristica(Integer vcaId, Date fecCrea, String usuCrea, short regActivo) {
        this.vcaId = vcaId;
        this.fecCrea = fecCrea;
        this.usuCrea = usuCrea;
        this.regActivo = regActivo;
    }

    public Integer getVcaId() {
        return vcaId;
    }

    public void setVcaId(Integer vcaId) {
        this.vcaId = vcaId;
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

    public EquipoElectrico getVcaEqeId() {
        return vcaEqeId;
    }

    public void setVcaEqeId(EquipoElectrico vcaEqeId) {
        this.vcaEqeId = vcaEqeId;
    }

    public ListaCaracteristica getVcaLscId() {
        return vcaLscId;
    }

    public void setVcaLscId(ListaCaracteristica vcaLscId) {
        this.vcaLscId = vcaLscId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vcaId != null ? vcaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ValorCaracteristica)) {
            return false;
        }
        ValorCaracteristica other = (ValorCaracteristica) object;
        if ((this.vcaId == null && other.vcaId != null) || (this.vcaId != null && !this.vcaId.equals(other.vcaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.app.sigeeac.model.ValorCaracteristica[ vcaId=" + vcaId + " ]";
    }
    
}
