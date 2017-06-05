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
@Table(name = "SERVICIO_OFRECIDO", catalog = "", schema = "GEEAC")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ServicioOfrecido.findAll", query = "SELECT s FROM ServicioOfrecido s")
    , @NamedQuery(name = "ServicioOfrecido.findBySroId", query = "SELECT s FROM ServicioOfrecido s WHERE s.sroId = :sroId")
    , @NamedQuery(name = "ServicioOfrecido.findBySroDescripcion", query = "SELECT s FROM ServicioOfrecido s WHERE s.sroDescripcion = :sroDescripcion")
    , @NamedQuery(name = "ServicioOfrecido.findByFecCrea", query = "SELECT s FROM ServicioOfrecido s WHERE s.fecCrea = :fecCrea")
    , @NamedQuery(name = "ServicioOfrecido.findByUsuCrea", query = "SELECT s FROM ServicioOfrecido s WHERE s.usuCrea = :usuCrea")
    , @NamedQuery(name = "ServicioOfrecido.findByFecModi", query = "SELECT s FROM ServicioOfrecido s WHERE s.fecModi = :fecModi")
    , @NamedQuery(name = "ServicioOfrecido.findByUsuModi", query = "SELECT s FROM ServicioOfrecido s WHERE s.usuModi = :usuModi")
    , @NamedQuery(name = "ServicioOfrecido.findByRegActivo", query = "SELECT s FROM ServicioOfrecido s WHERE s.regActivo = :regActivo")})
public class ServicioOfrecido implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "SRO_ID")
    private Integer sroId;
    @Size(max = 4000)
    @Column(name = "SRO_DESCRIPCION")
    private String sroDescripcion;
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
    @JoinColumn(name = "SRO_EMP_ID", referencedColumnName = "EMP_ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private EmpresaServicio sroEmpId;
    @JoinColumn(name = "SRO_TPS_ID", referencedColumnName = "TPS_ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TipoServicio sroTpsId;

    public ServicioOfrecido() {
    }

    public ServicioOfrecido(Integer sroId) {
        this.sroId = sroId;
    }

    public ServicioOfrecido(Integer sroId, Date fecCrea, String usuCrea, short regActivo) {
        this.sroId = sroId;
        this.fecCrea = fecCrea;
        this.usuCrea = usuCrea;
        this.regActivo = regActivo;
    }

    public Integer getSroId() {
        return sroId;
    }

    public void setSroId(Integer sroId) {
        this.sroId = sroId;
    }

    public String getSroDescripcion() {
        return sroDescripcion;
    }

    public void setSroDescripcion(String sroDescripcion) {
        this.sroDescripcion = sroDescripcion;
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

    public EmpresaServicio getSroEmpId() {
        return sroEmpId;
    }

    public void setSroEmpId(EmpresaServicio sroEmpId) {
        this.sroEmpId = sroEmpId;
    }

    public TipoServicio getSroTpsId() {
        return sroTpsId;
    }

    public void setSroTpsId(TipoServicio sroTpsId) {
        this.sroTpsId = sroTpsId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sroId != null ? sroId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ServicioOfrecido)) {
            return false;
        }
        ServicioOfrecido other = (ServicioOfrecido) object;
        if ((this.sroId == null && other.sroId != null) || (this.sroId != null && !this.sroId.equals(other.sroId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.app.sigeeac.model.ServicioOfrecido[ sroId=" + sroId + " ]";
    }
    
}
