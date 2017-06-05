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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "SMENU", catalog = "", schema = "GEEAC")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Smenu.findAll", query = "SELECT s FROM Smenu s")
    , @NamedQuery(name = "Smenu.findByMnuId", query = "SELECT s FROM Smenu s WHERE s.mnuId = :mnuId")
    , @NamedQuery(name = "Smenu.findByMnuNombre", query = "SELECT s FROM Smenu s WHERE s.mnuNombre = :mnuNombre")
    , @NamedQuery(name = "Smenu.findByMnuUrl", query = "SELECT s FROM Smenu s WHERE s.mnuUrl = :mnuUrl")
    , @NamedQuery(name = "Smenu.findByMnuDescripcion", query = "SELECT s FROM Smenu s WHERE s.mnuDescripcion = :mnuDescripcion")
    , @NamedQuery(name = "Smenu.findByFecCrea", query = "SELECT s FROM Smenu s WHERE s.fecCrea = :fecCrea")
    , @NamedQuery(name = "Smenu.findByUsuCrea", query = "SELECT s FROM Smenu s WHERE s.usuCrea = :usuCrea")
    , @NamedQuery(name = "Smenu.findByFecModi", query = "SELECT s FROM Smenu s WHERE s.fecModi = :fecModi")
    , @NamedQuery(name = "Smenu.findByUsuModi", query = "SELECT s FROM Smenu s WHERE s.usuModi = :usuModi")
    , @NamedQuery(name = "Smenu.findByRegActivo", query = "SELECT s FROM Smenu s WHERE s.regActivo = :regActivo")})
public class Smenu implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "MNU_ID")
    private Integer mnuId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "MNU_NOMBRE")
    private String mnuNombre;
    @Size(max = 250)
    @Column(name = "MNU_URL")
    private String mnuUrl;
    @Size(max = 4000)
    @Column(name = "MNU_DESCRIPCION")
    private String mnuDescripcion;
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
    @OneToMany(mappedBy = "mnuPadreId", fetch = FetchType.LAZY)
    private Set<Smenu> smenuSet;
    @JoinColumn(name = "MNU_PADRE_ID", referencedColumnName = "MNU_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Smenu mnuPadreId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "perMnuId", fetch = FetchType.LAZY)
    private Set<Spermiso> spermisoSet;

    public Smenu() {
    }

    public Smenu(Integer mnuId) {
        this.mnuId = mnuId;
    }

    public Smenu(Integer mnuId, String mnuNombre, Date fecCrea, String usuCrea, short regActivo) {
        this.mnuId = mnuId;
        this.mnuNombre = mnuNombre;
        this.fecCrea = fecCrea;
        this.usuCrea = usuCrea;
        this.regActivo = regActivo;
    }

    public Integer getMnuId() {
        return mnuId;
    }

    public void setMnuId(Integer mnuId) {
        this.mnuId = mnuId;
    }

    public String getMnuNombre() {
        return mnuNombre;
    }

    public void setMnuNombre(String mnuNombre) {
        this.mnuNombre = mnuNombre;
    }

    public String getMnuUrl() {
        return mnuUrl;
    }

    public void setMnuUrl(String mnuUrl) {
        this.mnuUrl = mnuUrl;
    }

    public String getMnuDescripcion() {
        return mnuDescripcion;
    }

    public void setMnuDescripcion(String mnuDescripcion) {
        this.mnuDescripcion = mnuDescripcion;
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
    public Set<Smenu> getSmenuSet() {
        return smenuSet;
    }

    public void setSmenuSet(Set<Smenu> smenuSet) {
        this.smenuSet = smenuSet;
    }

    public Smenu getMnuPadreId() {
        return mnuPadreId;
    }

    public void setMnuPadreId(Smenu mnuPadreId) {
        this.mnuPadreId = mnuPadreId;
    }

    @XmlTransient
    public Set<Spermiso> getSpermisoSet() {
        return spermisoSet;
    }

    public void setSpermisoSet(Set<Spermiso> spermisoSet) {
        this.spermisoSet = spermisoSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mnuId != null ? mnuId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Smenu)) {
            return false;
        }
        Smenu other = (Smenu) object;
        if ((this.mnuId == null && other.mnuId != null) || (this.mnuId != null && !this.mnuId.equals(other.mnuId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.app.sigeeac.model.Smenu[ mnuId=" + mnuId + " ]";
    }
    
}
