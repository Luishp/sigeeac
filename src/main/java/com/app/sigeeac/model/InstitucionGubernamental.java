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
@Table(name = "INSTITUCION_GUBERNAMENTAL", catalog = "", schema = "GEEAC")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InstitucionGubernamental.findAll", query = "SELECT i FROM InstitucionGubernamental i")
    , @NamedQuery(name = "InstitucionGubernamental.findByIngId", query = "SELECT i FROM InstitucionGubernamental i WHERE i.ingId = :ingId")
    , @NamedQuery(name = "InstitucionGubernamental.findByIngCodigo", query = "SELECT i FROM InstitucionGubernamental i WHERE i.ingCodigo = :ingCodigo")
    , @NamedQuery(name = "InstitucionGubernamental.findByIngNombre", query = "SELECT i FROM InstitucionGubernamental i WHERE i.ingNombre = :ingNombre")
    , @NamedQuery(name = "InstitucionGubernamental.findByIngDireccion", query = "SELECT i FROM InstitucionGubernamental i WHERE i.ingDireccion = :ingDireccion")
    , @NamedQuery(name = "InstitucionGubernamental.findByIngTelefono", query = "SELECT i FROM InstitucionGubernamental i WHERE i.ingTelefono = :ingTelefono")
    , @NamedQuery(name = "InstitucionGubernamental.findByIngCorreoElectronico", query = "SELECT i FROM InstitucionGubernamental i WHERE i.ingCorreoElectronico = :ingCorreoElectronico")
    , @NamedQuery(name = "InstitucionGubernamental.findByIngDescripcion", query = "SELECT i FROM InstitucionGubernamental i WHERE i.ingDescripcion = :ingDescripcion")
    , @NamedQuery(name = "InstitucionGubernamental.findByFecCrea", query = "SELECT i FROM InstitucionGubernamental i WHERE i.fecCrea = :fecCrea")
    , @NamedQuery(name = "InstitucionGubernamental.findByUsuCrea", query = "SELECT i FROM InstitucionGubernamental i WHERE i.usuCrea = :usuCrea")
    , @NamedQuery(name = "InstitucionGubernamental.findByFecModi", query = "SELECT i FROM InstitucionGubernamental i WHERE i.fecModi = :fecModi")
    , @NamedQuery(name = "InstitucionGubernamental.findByUsuModi", query = "SELECT i FROM InstitucionGubernamental i WHERE i.usuModi = :usuModi")
    , @NamedQuery(name = "InstitucionGubernamental.findByRegActivo", query = "SELECT i FROM InstitucionGubernamental i WHERE i.regActivo = :regActivo")})
public class InstitucionGubernamental implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ING_ID")
    public Integer ingId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "ING_CODIGO")
    public String ingCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "ING_NOMBRE")
    public String ingNombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "ING_DIRECCION")
    public String ingDireccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "ING_TELEFONO")
    public String ingTelefono;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "ING_CORREO_ELECTRONICO")
    public String ingCorreoElectronico;
    @Size(max = 4000)
    @Column(name = "ING_DESCRIPCION")
    public String ingDescripcion;
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
    /*@OneToMany(cascade = CascadeType.ALL, mappedBy = "uadIngId", fetch = FetchType.LAZY)
    private Set<UnidadAdministrativa> unidadAdministrativaSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cmpIngId", fetch = FetchType.LAZY)
    private Set<OrdenCompra> ordenCompraSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "alrIngId", fetch = FetchType.LAZY)
    private Set<AlertasMantenimiento> alertasMantenimientoSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tcbIngId", fetch = FetchType.LAZY)
    private Set<TecnicoBloqueado> tecnicoBloqueadoSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "incIngId", fetch = FetchType.LAZY)
    private Set<InstitucionConfiguracion> institucionConfiguracionSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iesIngId", fetch = FetchType.LAZY)
    private Set<InstitucionEmpServicio> institucionEmpServicioSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rmcIngId", fetch = FetchType.LAZY)
    private Set<RestringeMontoCompra> restringeMontoCompraSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usrIngId", fetch = FetchType.LAZY)
    private Set<Susuario> susuarioSet;*/

    public InstitucionGubernamental() {
    }

    public InstitucionGubernamental(Integer ingId) {
        this.ingId = ingId;
    }

    public InstitucionGubernamental(Integer ingId, String ingCodigo, String ingNombre, String ingDireccion, String ingTelefono, String ingCorreoElectronico, Date fecCrea, String usuCrea, short regActivo) {
        this.ingId = ingId;
        this.ingCodigo = ingCodigo;
        this.ingNombre = ingNombre;
        this.ingDireccion = ingDireccion;
        this.ingTelefono = ingTelefono;
        this.ingCorreoElectronico = ingCorreoElectronico;
        this.fecCrea = fecCrea;
        this.usuCrea = usuCrea;
        this.regActivo = regActivo;
    }

    public Integer getIngId() {
        return ingId;
    }

    public void setIngId(Integer ingId) {
        this.ingId = ingId;
    }

    public String getIngCodigo() {
        return ingCodigo;
    }

    public void setIngCodigo(String ingCodigo) {
        this.ingCodigo = ingCodigo;
    }

    public String getIngNombre() {
        return ingNombre;
    }

    public void setIngNombre(String ingNombre) {
        this.ingNombre = ingNombre;
    }

    public String getIngDireccion() {
        return ingDireccion;
    }

    public void setIngDireccion(String ingDireccion) {
        this.ingDireccion = ingDireccion;
    }

    public String getIngTelefono() {
        return ingTelefono;
    }

    public void setIngTelefono(String ingTelefono) {
        this.ingTelefono = ingTelefono;
    }

    public String getIngCorreoElectronico() {
        return ingCorreoElectronico;
    }

    public void setIngCorreoElectronico(String ingCorreoElectronico) {
        this.ingCorreoElectronico = ingCorreoElectronico;
    }

    public String getIngDescripcion() {
        return ingDescripcion;
    }

    public void setIngDescripcion(String ingDescripcion) {
        this.ingDescripcion = ingDescripcion;
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

    /*@XmlTransient
    public Set<UnidadAdministrativa> getUnidadAdministrativaSet() {
        return unidadAdministrativaSet;
    }

    public void setUnidadAdministrativaSet(Set<UnidadAdministrativa> unidadAdministrativaSet) {
        this.unidadAdministrativaSet = unidadAdministrativaSet;
    }

    @XmlTransient
    public Set<OrdenCompra> getOrdenCompraSet() {
        return ordenCompraSet;
    }

    public void setOrdenCompraSet(Set<OrdenCompra> ordenCompraSet) {
        this.ordenCompraSet = ordenCompraSet;
    }

    @XmlTransient
    public Set<AlertasMantenimiento> getAlertasMantenimientoSet() {
        return alertasMantenimientoSet;
    }

    public void setAlertasMantenimientoSet(Set<AlertasMantenimiento> alertasMantenimientoSet) {
        this.alertasMantenimientoSet = alertasMantenimientoSet;
    }

    @XmlTransient
    public Set<TecnicoBloqueado> getTecnicoBloqueadoSet() {
        return tecnicoBloqueadoSet;
    }

    public void setTecnicoBloqueadoSet(Set<TecnicoBloqueado> tecnicoBloqueadoSet) {
        this.tecnicoBloqueadoSet = tecnicoBloqueadoSet;
    }

    @XmlTransient
    public Set<InstitucionConfiguracion> getInstitucionConfiguracionSet() {
        return institucionConfiguracionSet;
    }

    public void setInstitucionConfiguracionSet(Set<InstitucionConfiguracion> institucionConfiguracionSet) {
        this.institucionConfiguracionSet = institucionConfiguracionSet;
    }

    @XmlTransient
    public Set<InstitucionEmpServicio> getInstitucionEmpServicioSet() {
        return institucionEmpServicioSet;
    }

    public void setInstitucionEmpServicioSet(Set<InstitucionEmpServicio> institucionEmpServicioSet) {
        this.institucionEmpServicioSet = institucionEmpServicioSet;
    }

    @XmlTransient
    public Set<RestringeMontoCompra> getRestringeMontoCompraSet() {
        return restringeMontoCompraSet;
    }

    public void setRestringeMontoCompraSet(Set<RestringeMontoCompra> restringeMontoCompraSet) {
        this.restringeMontoCompraSet = restringeMontoCompraSet;
    }

    @XmlTransient
    public Set<Susuario> getSusuarioSet() {
        return susuarioSet;
    }

    public void setSusuarioSet(Set<Susuario> susuarioSet) {
        this.susuarioSet = susuarioSet;
    }*/

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ingId != null ? ingId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InstitucionGubernamental)) {
            return false;
        }
        InstitucionGubernamental other = (InstitucionGubernamental) object;
        if ((this.ingId == null && other.ingId != null) || (this.ingId != null && !this.ingId.equals(other.ingId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.app.sigeeac.model.InstitucionGubernamental[ ingId=" + ingId + " ]";
    }
    
}
