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
@Table(name = "CARACTERISTICA", catalog = "", schema = "GEEAC")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Caracteristica.findAll", query = "SELECT c FROM Caracteristica c")
    , @NamedQuery(name = "Caracteristica.findByCteId", query = "SELECT c FROM Caracteristica c WHERE c.cteId = :cteId")
    , @NamedQuery(name = "Caracteristica.findByCteDescripcion", query = "SELECT c FROM Caracteristica c WHERE c.cteDescripcion = :cteDescripcion")
    , @NamedQuery(name = "Caracteristica.findByFecCrea", query = "SELECT c FROM Caracteristica c WHERE c.fecCrea = :fecCrea")
    , @NamedQuery(name = "Caracteristica.findByUsuCrea", query = "SELECT c FROM Caracteristica c WHERE c.usuCrea = :usuCrea")
    , @NamedQuery(name = "Caracteristica.findByFecModi", query = "SELECT c FROM Caracteristica c WHERE c.fecModi = :fecModi")
    , @NamedQuery(name = "Caracteristica.findByUsuModi", query = "SELECT c FROM Caracteristica c WHERE c.usuModi = :usuModi")
    , @NamedQuery(name = "Caracteristica.findByRegActivo", query = "SELECT c FROM Caracteristica c WHERE c.regActivo = :regActivo")})
public class Caracteristica implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CTE_ID")
    private Integer cteId;
    @Size(max = 4000)
    @Column(name = "CTE_DESCRIPCION")
    private String cteDescripcion;
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
    @JoinColumn(name = "CTE_LSC_ID", referencedColumnName = "LSC_ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ListaCaracteristica cteLscId;
    @JoinColumn(name = "CTE_TEQ_ID", referencedColumnName = "TEQ_ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TipoEquipoElectrico cteTeqId;

    public Caracteristica() {
    }

    public Caracteristica(Integer cteId) {
        this.cteId = cteId;
    }

    public Caracteristica(Integer cteId, Date fecCrea, String usuCrea, short regActivo) {
        this.cteId = cteId;
        this.fecCrea = fecCrea;
        this.usuCrea = usuCrea;
        this.regActivo = regActivo;
    }

    public Integer getCteId() {
        return cteId;
    }

    public void setCteId(Integer cteId) {
        this.cteId = cteId;
    }

    public String getCteDescripcion() {
        return cteDescripcion;
    }

    public void setCteDescripcion(String cteDescripcion) {
        this.cteDescripcion = cteDescripcion;
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

    public ListaCaracteristica getCteLscId() {
        return cteLscId;
    }

    public void setCteLscId(ListaCaracteristica cteLscId) {
        this.cteLscId = cteLscId;
    }

    public TipoEquipoElectrico getCteTeqId() {
        return cteTeqId;
    }

    public void setCteTeqId(TipoEquipoElectrico cteTeqId) {
        this.cteTeqId = cteTeqId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cteId != null ? cteId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Caracteristica)) {
            return false;
        }
        Caracteristica other = (Caracteristica) object;
        if ((this.cteId == null && other.cteId != null) || (this.cteId != null && !this.cteId.equals(other.cteId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.app.sigeeac.model.Caracteristica[ cteId=" + cteId + " ]";
    }
    
}
