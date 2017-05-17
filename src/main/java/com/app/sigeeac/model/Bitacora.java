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
import javax.persistence.Id;
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
@Table(name = "BITACORA", catalog = "", schema = "GEEAC")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bitacora.findAll", query = "SELECT b FROM Bitacora b")
    , @NamedQuery(name = "Bitacora.findByBitId", query = "SELECT b FROM Bitacora b WHERE b.bitId = :bitId")
    , @NamedQuery(name = "Bitacora.findByBitNombreTabla", query = "SELECT b FROM Bitacora b WHERE b.bitNombreTabla = :bitNombreTabla")
    , @NamedQuery(name = "Bitacora.findByBitEstadoAnterior", query = "SELECT b FROM Bitacora b WHERE b.bitEstadoAnterior = :bitEstadoAnterior")
    , @NamedQuery(name = "Bitacora.findByBitEstadoNuevo", query = "SELECT b FROM Bitacora b WHERE b.bitEstadoNuevo = :bitEstadoNuevo")
    , @NamedQuery(name = "Bitacora.findByFecCrea", query = "SELECT b FROM Bitacora b WHERE b.fecCrea = :fecCrea")
    , @NamedQuery(name = "Bitacora.findByUsuCrea", query = "SELECT b FROM Bitacora b WHERE b.usuCrea = :usuCrea")
    , @NamedQuery(name = "Bitacora.findByFecModi", query = "SELECT b FROM Bitacora b WHERE b.fecModi = :fecModi")
    , @NamedQuery(name = "Bitacora.findByUsuModi", query = "SELECT b FROM Bitacora b WHERE b.usuModi = :usuModi")
    , @NamedQuery(name = "Bitacora.findByRegActivo", query = "SELECT b FROM Bitacora b WHERE b.regActivo = :regActivo")})
public class Bitacora implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "BIT_ID")
    private Integer bitId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "BIT_NOMBRE_TABLA")
    private String bitNombreTabla;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4000)
    @Column(name = "BIT_ESTADO_ANTERIOR")
    private String bitEstadoAnterior;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4000)
    @Column(name = "BIT_ESTADO_NUEVO")
    private String bitEstadoNuevo;
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

    public Bitacora() {
    }

    public Bitacora(Integer bitId) {
        this.bitId = bitId;
    }

    public Bitacora(Integer bitId, String bitNombreTabla, String bitEstadoAnterior, String bitEstadoNuevo, Date fecCrea, String usuCrea, short regActivo) {
        this.bitId = bitId;
        this.bitNombreTabla = bitNombreTabla;
        this.bitEstadoAnterior = bitEstadoAnterior;
        this.bitEstadoNuevo = bitEstadoNuevo;
        this.fecCrea = fecCrea;
        this.usuCrea = usuCrea;
        this.regActivo = regActivo;
    }

    public Integer getBitId() {
        return bitId;
    }

    public void setBitId(Integer bitId) {
        this.bitId = bitId;
    }

    public String getBitNombreTabla() {
        return bitNombreTabla;
    }

    public void setBitNombreTabla(String bitNombreTabla) {
        this.bitNombreTabla = bitNombreTabla;
    }

    public String getBitEstadoAnterior() {
        return bitEstadoAnterior;
    }

    public void setBitEstadoAnterior(String bitEstadoAnterior) {
        this.bitEstadoAnterior = bitEstadoAnterior;
    }

    public String getBitEstadoNuevo() {
        return bitEstadoNuevo;
    }

    public void setBitEstadoNuevo(String bitEstadoNuevo) {
        this.bitEstadoNuevo = bitEstadoNuevo;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bitId != null ? bitId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bitacora)) {
            return false;
        }
        Bitacora other = (Bitacora) object;
        if ((this.bitId == null && other.bitId != null) || (this.bitId != null && !this.bitId.equals(other.bitId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.app.sigeeac.model.Bitacora[ bitId=" + bitId + " ]";
    }
    
}
