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
@Table(name = "SPERMISO", catalog = "", schema = "GEEAC")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Spermiso.findAll", query = "SELECT s FROM Spermiso s")
    , @NamedQuery(name = "Spermiso.findByPerId", query = "SELECT s FROM Spermiso s WHERE s.perId = :perId")
    , @NamedQuery(name = "Spermiso.findByPerNombre", query = "SELECT s FROM Spermiso s WHERE s.perNombre = :perNombre")
    , @NamedQuery(name = "Spermiso.findByPerDescripcion", query = "SELECT s FROM Spermiso s WHERE s.perDescripcion = :perDescripcion")
    , @NamedQuery(name = "Spermiso.findByFecCrea", query = "SELECT s FROM Spermiso s WHERE s.fecCrea = :fecCrea")
    , @NamedQuery(name = "Spermiso.findByUsuCrea", query = "SELECT s FROM Spermiso s WHERE s.usuCrea = :usuCrea")
    , @NamedQuery(name = "Spermiso.findByFecModi", query = "SELECT s FROM Spermiso s WHERE s.fecModi = :fecModi")
    , @NamedQuery(name = "Spermiso.findByUsuModi", query = "SELECT s FROM Spermiso s WHERE s.usuModi = :usuModi")
    , @NamedQuery(name = "Spermiso.findByRegActivo", query = "SELECT s FROM Spermiso s WHERE s.regActivo = :regActivo")})
public class Spermiso implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PER_ID")
    private Integer perId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "PER_NOMBRE")
    private String perNombre;
    @Size(max = 4000)
    @Column(name = "PER_DESCRIPCION")
    private String perDescripcion;
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
    @JoinColumn(name = "PER_MNU_ID", referencedColumnName = "MNU_ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Smenu perMnuId;
    @JoinColumn(name = "PER_ROL_ID", referencedColumnName = "ROL_ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Srol perRolId;

    public Spermiso() {
    }

    public Spermiso(Integer perId) {
        this.perId = perId;
    }

    public Spermiso(Integer perId, String perNombre, Date fecCrea, String usuCrea, short regActivo) {
        this.perId = perId;
        this.perNombre = perNombre;
        this.fecCrea = fecCrea;
        this.usuCrea = usuCrea;
        this.regActivo = regActivo;
    }

    public Integer getPerId() {
        return perId;
    }

    public void setPerId(Integer perId) {
        this.perId = perId;
    }

    public String getPerNombre() {
        return perNombre;
    }

    public void setPerNombre(String perNombre) {
        this.perNombre = perNombre;
    }

    public String getPerDescripcion() {
        return perDescripcion;
    }

    public void setPerDescripcion(String perDescripcion) {
        this.perDescripcion = perDescripcion;
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

    public Smenu getPerMnuId() {
        return perMnuId;
    }

    public void setPerMnuId(Smenu perMnuId) {
        this.perMnuId = perMnuId;
    }

    public Srol getPerRolId() {
        return perRolId;
    }

    public void setPerRolId(Srol perRolId) {
        this.perRolId = perRolId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (perId != null ? perId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Spermiso)) {
            return false;
        }
        Spermiso other = (Spermiso) object;
        if ((this.perId == null && other.perId != null) || (this.perId != null && !this.perId.equals(other.perId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.app.sigeeac.model.Spermiso[ perId=" + perId + " ]";
    }
    
}
