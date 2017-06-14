/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.sigeeac.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.Set;
import javax.persistence.Basic;
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
@Table(name = "ORDEN_COMPRA_DET", catalog = "", schema = "GEEAC")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrdenCompraDet.findAll", query = "SELECT o FROM OrdenCompraDet o")
    , @NamedQuery(name = "OrdenCompraDet.findByCmdId", query = "SELECT o FROM OrdenCompraDet o WHERE o.cmdId = :cmdId")
    , @NamedQuery(name = "OrdenCompraDet.findByCmdCantidad", query = "SELECT o FROM OrdenCompraDet o WHERE o.cmdCantidad = :cmdCantidad")
    , @NamedQuery(name = "OrdenCompraDet.findByCmdPrecioUnitario", query = "SELECT o FROM OrdenCompraDet o WHERE o.cmdPrecioUnitario = :cmdPrecioUnitario")
    , @NamedQuery(name = "OrdenCompraDet.findByCmdGarantia", query = "SELECT o FROM OrdenCompraDet o WHERE o.cmdGarantia = :cmdGarantia")
    , @NamedQuery(name = "OrdenCompraDet.findByCmdDescripcion", query = "SELECT o FROM OrdenCompraDet o WHERE o.cmdDescripcion = :cmdDescripcion")
    , @NamedQuery(name = "OrdenCompraDet.findByFecCrea", query = "SELECT o FROM OrdenCompraDet o WHERE o.fecCrea = :fecCrea")
    , @NamedQuery(name = "OrdenCompraDet.findByUsuCrea", query = "SELECT o FROM OrdenCompraDet o WHERE o.usuCrea = :usuCrea")
    , @NamedQuery(name = "OrdenCompraDet.findByFecModi", query = "SELECT o FROM OrdenCompraDet o WHERE o.fecModi = :fecModi")
    , @NamedQuery(name = "OrdenCompraDet.findByUsuModi", query = "SELECT o FROM OrdenCompraDet o WHERE o.usuModi = :usuModi")
    , @NamedQuery(name = "OrdenCompraDet.findByRegActivo", query = "SELECT o FROM OrdenCompraDet o WHERE o.regActivo = :regActivo")})
public class OrdenCompraDet implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CMD_ID")
    public Integer cmdId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CMD_CANTIDAD")
    public BigInteger cmdCantidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CMD_PRECIO_UNITARIO")
    public BigDecimal cmdPrecioUnitario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CMD_GARANTIA")
    public BigInteger cmdGarantia;
    @Size(max = 4000)
    @Column(name = "CMD_DESCRIPCION")
    public String cmdDescripcion;
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
    @JoinColumn(name = "CMD_CMP_ID", referencedColumnName = "CMP_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    public OrdenCompra cmdCmpId;
    /*@OneToMany(mappedBy = "eqeCmdId", fetch = FetchType.LAZY)
    public Set<EquipoElectrico> equipoElectricoSet;*/

    public OrdenCompraDet() {
    }

    public OrdenCompraDet(Integer cmdId) {
        this.cmdId = cmdId;
    }

    public OrdenCompraDet(Integer cmdId, BigInteger cmdCantidad, BigDecimal cmdPrecioUnitario, BigInteger cmdGarantia, Date fecCrea, String usuCrea, short regActivo) {
        this.cmdId = cmdId;
        this.cmdCantidad = cmdCantidad;
        this.cmdPrecioUnitario = cmdPrecioUnitario;
        this.cmdGarantia = cmdGarantia;
        this.fecCrea = fecCrea;
        this.usuCrea = usuCrea;
        this.regActivo = regActivo;
    }

    public Integer getCmdId() {
        return cmdId;
    }

    public void setCmdId(Integer cmdId) {
        this.cmdId = cmdId;
    }

    public BigInteger getCmdCantidad() {
        return cmdCantidad;
    }

    public void setCmdCantidad(BigInteger cmdCantidad) {
        this.cmdCantidad = cmdCantidad;
    }

    public BigDecimal getCmdPrecioUnitario() {
        return cmdPrecioUnitario;
    }

    public void setCmdPrecioUnitario(BigDecimal cmdPrecioUnitario) {
        this.cmdPrecioUnitario = cmdPrecioUnitario;
    }

    public BigInteger getCmdGarantia() {
        return cmdGarantia;
    }

    public void setCmdGarantia(BigInteger cmdGarantia) {
        this.cmdGarantia = cmdGarantia;
    }

    public String getCmdDescripcion() {
        return cmdDescripcion;
    }

    public void setCmdDescripcion(String cmdDescripcion) {
        this.cmdDescripcion = cmdDescripcion;
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

    public OrdenCompra getCmdCmpId() {
        return cmdCmpId;
    }

    public void setCmdCmpId(OrdenCompra cmdCmpId) {
        this.cmdCmpId = cmdCmpId;
    }

    /*@XmlTransient
    public Set<EquipoElectrico> getEquipoElectricoSet() {
        return equipoElectricoSet;
    }

    public void setEquipoElectricoSet(Set<EquipoElectrico> equipoElectricoSet) {
        this.equipoElectricoSet = equipoElectricoSet;
    }*/

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cmdId != null ? cmdId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrdenCompraDet)) {
            return false;
        }
        OrdenCompraDet other = (OrdenCompraDet) object;
        if ((this.cmdId == null && other.cmdId != null) || (this.cmdId != null && !this.cmdId.equals(other.cmdId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.app.sigeeac.model.OrdenCompraDet[ cmdId=" + cmdId + " ]";
    }
    
}
