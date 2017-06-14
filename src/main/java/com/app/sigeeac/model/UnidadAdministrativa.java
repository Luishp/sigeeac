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
@Table(name = "UNIDAD_ADMINISTRATIVA", catalog = "", schema = "GEEAC")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UnidadAdministrativa.findAll", query = "SELECT u FROM UnidadAdministrativa u")
    , @NamedQuery(name = "UnidadAdministrativa.findByUadId", query = "SELECT u FROM UnidadAdministrativa u WHERE u.uadId = :uadId")
    , @NamedQuery(name = "UnidadAdministrativa.findByUadNombre", query = "SELECT u FROM UnidadAdministrativa u WHERE u.uadNombre = :uadNombre")
    , @NamedQuery(name = "UnidadAdministrativa.findByUadDepartamento", query = "SELECT u FROM UnidadAdministrativa u WHERE u.uadDepartamento = :uadDepartamento")
    , @NamedQuery(name = "UnidadAdministrativa.findByUadMunicipio", query = "SELECT u FROM UnidadAdministrativa u WHERE u.uadMunicipio = :uadMunicipio")
    , @NamedQuery(name = "UnidadAdministrativa.findByUadJefeUnidad", query = "SELECT u FROM UnidadAdministrativa u WHERE u.uadJefeUnidad = :uadJefeUnidad")
    , @NamedQuery(name = "UnidadAdministrativa.findByUadDescripcion", query = "SELECT u FROM UnidadAdministrativa u WHERE u.uadDescripcion = :uadDescripcion")
    , @NamedQuery(name = "UnidadAdministrativa.findByFecCrea", query = "SELECT u FROM UnidadAdministrativa u WHERE u.fecCrea = :fecCrea")
    , @NamedQuery(name = "UnidadAdministrativa.findByUsuCrea", query = "SELECT u FROM UnidadAdministrativa u WHERE u.usuCrea = :usuCrea")
    , @NamedQuery(name = "UnidadAdministrativa.findByFecModi", query = "SELECT u FROM UnidadAdministrativa u WHERE u.fecModi = :fecModi")
    , @NamedQuery(name = "UnidadAdministrativa.findByUsuModi", query = "SELECT u FROM UnidadAdministrativa u WHERE u.usuModi = :usuModi")
    , @NamedQuery(name = "UnidadAdministrativa.findByRegActivo", query = "SELECT u FROM UnidadAdministrativa u WHERE u.regActivo = :regActivo")})
public class UnidadAdministrativa implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "UAD_ID")
    public Integer uadId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "UAD_NOMBRE")
    public String uadNombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "UAD_DEPARTAMENTO")
    public String uadDepartamento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "UAD_MUNICIPIO")
    public String uadMunicipio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "UAD_JEFE_UNIDAD")
    public String uadJefeUnidad;
    @Size(max = 4000)
    @Column(name = "UAD_DESCRIPCION")
    public String uadDescripcion;
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
    @JoinColumn(name = "UAD_ING_ID", referencedColumnName = "ING_ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    public InstitucionGubernamental uadIngId;
    /*@OneToMany(cascade = CascadeType.ALL, mappedBy = "solUadId", fetch = FetchType.LAZY)
    public Set<SolicitudCompra> solicitudCompraSet;
    @OneToMany(mappedBy = "eqeUadId", fetch = FetchType.LAZY)
    public Set<EquipoElectrico> equipoElectricoSet;*/

    public UnidadAdministrativa() {
    }

    public UnidadAdministrativa(Integer uadId) {
        this.uadId = uadId;
    }

    public UnidadAdministrativa(Integer uadId, String uadNombre, String uadDepartamento, String uadMunicipio, String uadJefeUnidad, Date fecCrea, String usuCrea, short regActivo) {
        this.uadId = uadId;
        this.uadNombre = uadNombre;
        this.uadDepartamento = uadDepartamento;
        this.uadMunicipio = uadMunicipio;
        this.uadJefeUnidad = uadJefeUnidad;
        this.fecCrea = fecCrea;
        this.usuCrea = usuCrea;
        this.regActivo = regActivo;
    }

    public Integer getUadId() {
        return uadId;
    }

    public void setUadId(Integer uadId) {
        this.uadId = uadId;
    }

    public String getUadNombre() {
        return uadNombre;
    }

    public void setUadNombre(String uadNombre) {
        this.uadNombre = uadNombre;
    }

    public String getUadDepartamento() {
        return uadDepartamento;
    }

    public void setUadDepartamento(String uadDepartamento) {
        this.uadDepartamento = uadDepartamento;
    }

    public String getUadMunicipio() {
        return uadMunicipio;
    }

    public void setUadMunicipio(String uadMunicipio) {
        this.uadMunicipio = uadMunicipio;
    }

    public String getUadJefeUnidad() {
        return uadJefeUnidad;
    }

    public void setUadJefeUnidad(String uadJefeUnidad) {
        this.uadJefeUnidad = uadJefeUnidad;
    }

    public String getUadDescripcion() {
        return uadDescripcion;
    }

    public void setUadDescripcion(String uadDescripcion) {
        this.uadDescripcion = uadDescripcion;
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

    public InstitucionGubernamental getUadIngId() {
        return uadIngId;
    }

    public void setUadIngId(InstitucionGubernamental uadIngId) {
        this.uadIngId = uadIngId;
    }

    /*@XmlTransient
    public Set<SolicitudCompra> getSolicitudCompraSet() {
        return solicitudCompraSet;
    }

    public void setSolicitudCompraSet(Set<SolicitudCompra> solicitudCompraSet) {
        this.solicitudCompraSet = solicitudCompraSet;
    }

    @XmlTransient
    public Set<EquipoElectrico> getEquipoElectricoSet() {
        return equipoElectricoSet;
    }

    public void setEquipoElectricoSet(Set<EquipoElectrico> equipoElectricoSet) {
        this.equipoElectricoSet = equipoElectricoSet;
    }*/

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (uadId != null ? uadId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UnidadAdministrativa)) {
            return false;
        }
        UnidadAdministrativa other = (UnidadAdministrativa) object;
        if ((this.uadId == null && other.uadId != null) || (this.uadId != null && !this.uadId.equals(other.uadId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.app.sigeeac.model.UnidadAdministrativa[ uadId=" + uadId + " ]";
    }
    
}
