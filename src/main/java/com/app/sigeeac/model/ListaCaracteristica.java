/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.sigeeac.model;

import java.io.Serializable;
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
@Table(name = "LISTA_CARACTERISTICA", catalog = "", schema = "GEEAC")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ListaCaracteristica.findAll", query = "SELECT l FROM ListaCaracteristica l")
    , @NamedQuery(name = "ListaCaracteristica.findByLscId", query = "SELECT l FROM ListaCaracteristica l WHERE l.lscId = :lscId")
    , @NamedQuery(name = "ListaCaracteristica.findByLscNombre", query = "SELECT l FROM ListaCaracteristica l WHERE l.lscNombre = :lscNombre")
    , @NamedQuery(name = "ListaCaracteristica.findByLscTipoValor", query = "SELECT l FROM ListaCaracteristica l WHERE l.lscTipoValor = :lscTipoValor")
    , @NamedQuery(name = "ListaCaracteristica.findByLscDescripcion", query = "SELECT l FROM ListaCaracteristica l WHERE l.lscDescripcion = :lscDescripcion")
    , @NamedQuery(name = "ListaCaracteristica.findByFecCrea", query = "SELECT l FROM ListaCaracteristica l WHERE l.fecCrea = :fecCrea")
    , @NamedQuery(name = "ListaCaracteristica.findByUsuCrea", query = "SELECT l FROM ListaCaracteristica l WHERE l.usuCrea = :usuCrea")
    , @NamedQuery(name = "ListaCaracteristica.findByFecModi", query = "SELECT l FROM ListaCaracteristica l WHERE l.fecModi = :fecModi")
    , @NamedQuery(name = "ListaCaracteristica.findByUsuModi", query = "SELECT l FROM ListaCaracteristica l WHERE l.usuModi = :usuModi")
    , @NamedQuery(name = "ListaCaracteristica.findByRegActivo", query = "SELECT l FROM ListaCaracteristica l WHERE l.regActivo = :regActivo")})
public class ListaCaracteristica implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "LSC_ID")
    private Integer lscId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "LSC_NOMBRE")
    private String lscNombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "LSC_TIPO_VALOR")
    private String lscTipoValor;
    @Size(max = 4000)
    @Column(name = "LSC_DESCRIPCION")
    private String lscDescripcion;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vcaLscId", fetch = FetchType.LAZY)
    private Set<ValorCaracteristica> valorCaracteristicaSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cteLscId", fetch = FetchType.LAZY)
    private Set<Caracteristica> caracteristicaSet;

    public ListaCaracteristica() {
    }

    public ListaCaracteristica(Integer lscId) {
        this.lscId = lscId;
    }

    public ListaCaracteristica(Integer lscId, String lscNombre, String lscTipoValor, Date fecCrea, String usuCrea, short regActivo) {
        this.lscId = lscId;
        this.lscNombre = lscNombre;
        this.lscTipoValor = lscTipoValor;
        this.fecCrea = fecCrea;
        this.usuCrea = usuCrea;
        this.regActivo = regActivo;
    }

    public Integer getLscId() {
        return lscId;
    }

    public void setLscId(Integer lscId) {
        this.lscId = lscId;
    }

    public String getLscNombre() {
        return lscNombre;
    }

    public void setLscNombre(String lscNombre) {
        this.lscNombre = lscNombre;
    }

    public String getLscTipoValor() {
        return lscTipoValor;
    }

    public void setLscTipoValor(String lscTipoValor) {
        this.lscTipoValor = lscTipoValor;
    }

    public String getLscDescripcion() {
        return lscDescripcion;
    }

    public void setLscDescripcion(String lscDescripcion) {
        this.lscDescripcion = lscDescripcion;
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
    public Set<ValorCaracteristica> getValorCaracteristicaSet() {
        return valorCaracteristicaSet;
    }

    public void setValorCaracteristicaSet(Set<ValorCaracteristica> valorCaracteristicaSet) {
        this.valorCaracteristicaSet = valorCaracteristicaSet;
    }

    @XmlTransient
    public Set<Caracteristica> getCaracteristicaSet() {
        return caracteristicaSet;
    }

    public void setCaracteristicaSet(Set<Caracteristica> caracteristicaSet) {
        this.caracteristicaSet = caracteristicaSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (lscId != null ? lscId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ListaCaracteristica)) {
            return false;
        }
        ListaCaracteristica other = (ListaCaracteristica) object;
        if ((this.lscId == null && other.lscId != null) || (this.lscId != null && !this.lscId.equals(other.lscId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.app.sigeeac.model.ListaCaracteristica[ lscId=" + lscId + " ]";
    }
    
}
