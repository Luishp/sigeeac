/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.sigeeac.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author luish
 */
@Entity
@Table(name = "TIPO_COMPRA", catalog = "", schema = "GEEAC")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoCompra.findAll", query = "SELECT t FROM TipoCompra t")
    , @NamedQuery(name = "TipoCompra.findByTpcId", query = "SELECT t FROM TipoCompra t WHERE t.tpcId = :tpcId")
    , @NamedQuery(name = "TipoCompra.findByTpcNombre", query = "SELECT t FROM TipoCompra t WHERE t.tpcNombre = :tpcNombre")
    , @NamedQuery(name = "TipoCompra.findByTpcDescripcion", query = "SELECT t FROM TipoCompra t WHERE t.tpcDescripcion = :tpcDescripcion")
    , @NamedQuery(name = "TipoCompra.findByFecCrea", query = "SELECT t FROM TipoCompra t WHERE t.fecCrea = :fecCrea")
    , @NamedQuery(name = "TipoCompra.findByUsuCrea", query = "SELECT t FROM TipoCompra t WHERE t.usuCrea = :usuCrea")
    , @NamedQuery(name = "TipoCompra.findByFecModi", query = "SELECT t FROM TipoCompra t WHERE t.fecModi = :fecModi")
    , @NamedQuery(name = "TipoCompra.findByUsuModi", query = "SELECT t FROM TipoCompra t WHERE t.usuModi = :usuModi")
    , @NamedQuery(name = "TipoCompra.findByRegActivo", query = "SELECT t FROM TipoCompra t WHERE t.regActivo = :regActivo")})
public class TipoCompra implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "TPC_ID")
    private Integer tpcId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "TPC_NOMBRE")
    private String tpcNombre;
    @Size(max = 4000)
    @Column(name = "TPC_DESCRIPCION")
    private String tpcDescripcion;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cmpTpcId", fetch = FetchType.LAZY)
    private Set<OrdenCompra> ordenCompraSet;

    public TipoCompra() {
    }

    public TipoCompra(Integer tpcId) {
        this.tpcId = tpcId;
    }

    public TipoCompra(Integer tpcId, String tpcNombre, Date fecCrea, String usuCrea, short regActivo) {
        this.tpcId = tpcId;
        this.tpcNombre = tpcNombre;
        this.fecCrea = fecCrea;
        this.usuCrea = usuCrea;
        this.regActivo = regActivo;
    }

    public Integer getTpcId() {
        return tpcId;
    }

    public void setTpcId(Integer tpcId) {
        this.tpcId = tpcId;
    }

    public String getTpcNombre() {
        return tpcNombre;
    }

    public void setTpcNombre(String tpcNombre) {
        this.tpcNombre = tpcNombre;
    }

    public String getTpcDescripcion() {
        return tpcDescripcion;
    }

    public void setTpcDescripcion(String tpcDescripcion) {
        this.tpcDescripcion = tpcDescripcion;
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

    @XmlTransient
    public Set<OrdenCompra> getOrdenCompraSet() {
        return ordenCompraSet;
    }

    public void setOrdenCompraSet(Set<OrdenCompra> ordenCompraSet) {
        this.ordenCompraSet = ordenCompraSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tpcId != null ? tpcId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoCompra)) {
            return false;
        }
        TipoCompra other = (TipoCompra) object;
        if ((this.tpcId == null && other.tpcId != null) || (this.tpcId != null && !this.tpcId.equals(other.tpcId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.app.sigeeac.model.TipoCompra[ tpcId=" + tpcId + " ]";
    }
    
}
