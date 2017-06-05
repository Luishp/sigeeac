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
@Table(name = "TIPO_SERVICIO", catalog = "", schema = "GEEAC")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoServicio.findAll", query = "SELECT t FROM TipoServicio t")
    , @NamedQuery(name = "TipoServicio.findByTpsId", query = "SELECT t FROM TipoServicio t WHERE t.tpsId = :tpsId")
    , @NamedQuery(name = "TipoServicio.findByTpsNombre", query = "SELECT t FROM TipoServicio t WHERE t.tpsNombre = :tpsNombre")
    , @NamedQuery(name = "TipoServicio.findByTpsDescripcion", query = "SELECT t FROM TipoServicio t WHERE t.tpsDescripcion = :tpsDescripcion")
    , @NamedQuery(name = "TipoServicio.findByFecCrea", query = "SELECT t FROM TipoServicio t WHERE t.fecCrea = :fecCrea")
    , @NamedQuery(name = "TipoServicio.findByUsuCrea", query = "SELECT t FROM TipoServicio t WHERE t.usuCrea = :usuCrea")
    , @NamedQuery(name = "TipoServicio.findByFecModi", query = "SELECT t FROM TipoServicio t WHERE t.fecModi = :fecModi")
    , @NamedQuery(name = "TipoServicio.findByUsuModi", query = "SELECT t FROM TipoServicio t WHERE t.usuModi = :usuModi")
    , @NamedQuery(name = "TipoServicio.findByRegActivo", query = "SELECT t FROM TipoServicio t WHERE t.regActivo = :regActivo")})
public class TipoServicio implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "TPS_ID")
    private Integer tpsId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "TPS_NOMBRE")
    private String tpsNombre;
    @Size(max = 4000)
    @Column(name = "TPS_DESCRIPCION")
    private String tpsDescripcion;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sroTpsId", fetch = FetchType.LAZY)
    private Set<ServicioOfrecido> servicioOfrecidoSet;

    public TipoServicio() {
    }

    public TipoServicio(Integer tpsId) {
        this.tpsId = tpsId;
    }

    public TipoServicio(Integer tpsId, String tpsNombre, Date fecCrea, String usuCrea, short regActivo) {
        this.tpsId = tpsId;
        this.tpsNombre = tpsNombre;
        this.fecCrea = fecCrea;
        this.usuCrea = usuCrea;
        this.regActivo = regActivo;
    }

    public Integer getTpsId() {
        return tpsId;
    }

    public void setTpsId(Integer tpsId) {
        this.tpsId = tpsId;
    }

    public String getTpsNombre() {
        return tpsNombre;
    }

    public void setTpsNombre(String tpsNombre) {
        this.tpsNombre = tpsNombre;
    }

    public String getTpsDescripcion() {
        return tpsDescripcion;
    }

    public void setTpsDescripcion(String tpsDescripcion) {
        this.tpsDescripcion = tpsDescripcion;
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
    public Set<ServicioOfrecido> getServicioOfrecidoSet() {
        return servicioOfrecidoSet;
    }

    public void setServicioOfrecidoSet(Set<ServicioOfrecido> servicioOfrecidoSet) {
        this.servicioOfrecidoSet = servicioOfrecidoSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tpsId != null ? tpsId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoServicio)) {
            return false;
        }
        TipoServicio other = (TipoServicio) object;
        if ((this.tpsId == null && other.tpsId != null) || (this.tpsId != null && !this.tpsId.equals(other.tpsId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.app.sigeeac.model.TipoServicio[ tpsId=" + tpsId + " ]";
    }
    
}
