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
@Table(name = "EMPRESA_SERVICIO", catalog = "", schema = "GEEAC")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EmpresaServicio.findAll", query = "SELECT e FROM EmpresaServicio e")
    , @NamedQuery(name = "EmpresaServicio.findByEmpId", query = "SELECT e FROM EmpresaServicio e WHERE e.empId = :empId")
    , @NamedQuery(name = "EmpresaServicio.findByEmpNombre", query = "SELECT e FROM EmpresaServicio e WHERE e.empNombre = :empNombre")
    , @NamedQuery(name = "EmpresaServicio.findByEmpDireccion", query = "SELECT e FROM EmpresaServicio e WHERE e.empDireccion = :empDireccion")
    , @NamedQuery(name = "EmpresaServicio.findByEmpNombreContacto", query = "SELECT e FROM EmpresaServicio e WHERE e.empNombreContacto = :empNombreContacto")
    , @NamedQuery(name = "EmpresaServicio.findByEmpTelContacto", query = "SELECT e FROM EmpresaServicio e WHERE e.empTelContacto = :empTelContacto")
    , @NamedQuery(name = "EmpresaServicio.findByEmpCorreoElectronico", query = "SELECT e FROM EmpresaServicio e WHERE e.empCorreoElectronico = :empCorreoElectronico")
    , @NamedQuery(name = "EmpresaServicio.findByEmpNit", query = "SELECT e FROM EmpresaServicio e WHERE e.empNit = :empNit")
    , @NamedQuery(name = "EmpresaServicio.findByEmpLogo", query = "SELECT e FROM EmpresaServicio e WHERE e.empLogo = :empLogo")
    , @NamedQuery(name = "EmpresaServicio.findByEmpDescripcion", query = "SELECT e FROM EmpresaServicio e WHERE e.empDescripcion = :empDescripcion")
    , @NamedQuery(name = "EmpresaServicio.findByFecCrea", query = "SELECT e FROM EmpresaServicio e WHERE e.fecCrea = :fecCrea")
    , @NamedQuery(name = "EmpresaServicio.findByUsuCrea", query = "SELECT e FROM EmpresaServicio e WHERE e.usuCrea = :usuCrea")
    , @NamedQuery(name = "EmpresaServicio.findByFecModi", query = "SELECT e FROM EmpresaServicio e WHERE e.fecModi = :fecModi")
    , @NamedQuery(name = "EmpresaServicio.findByUsuModi", query = "SELECT e FROM EmpresaServicio e WHERE e.usuModi = :usuModi")
    , @NamedQuery(name = "EmpresaServicio.findByRegActivo", query = "SELECT e FROM EmpresaServicio e WHERE e.regActivo = :regActivo")})
public class EmpresaServicio implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "EMP_ID")
    public Integer empId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "EMP_NOMBRE")
    public String empNombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "EMP_DIRECCION")
    public String empDireccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "EMP_NOMBRE_CONTACTO")
    public String empNombreContacto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "EMP_TEL_CONTACTO")
    public String empTelContacto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "EMP_CORREO_ELECTRONICO")
    public String empCorreoElectronico;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 17)
    @Column(name = "EMP_NIT")
    public String empNit;
    @Size(max = 250)
    @Column(name = "EMP_LOGO")
    public String empLogo;
    @Size(max = 4000)
    @Column(name = "EMP_DESCRIPCION")
    public String empDescripcion;
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
    /*@OneToMany(mappedBy = "tecEmpId", fetch = FetchType.LAZY)
    private Set<Tecnico> tecnicoSet;
    @OneToMany(mappedBy = "cmpEmpId", fetch = FetchType.LAZY)
    private Set<OrdenCompra> ordenCompraSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eqeEmpId", fetch = FetchType.LAZY)
    private Set<EquipoElectrico> equipoElectricoSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sroEmpId", fetch = FetchType.LAZY)
    private Set<ServicioOfrecido> servicioOfrecidoSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mttEmpId", fetch = FetchType.LAZY)
    private Set<Mantenimiento> mantenimientoSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iesEmpId", fetch = FetchType.LAZY)
    private Set<InstitucionEmpServicio> institucionEmpServicioSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rmcEmpId", fetch = FetchType.LAZY)
    private Set<RestringeMontoCompra> restringeMontoCompraSet;*/

    public EmpresaServicio() {
    }

    public EmpresaServicio(Integer empId) {
        this.empId = empId;
    }

    public EmpresaServicio(Integer empId, String empNombre, String empDireccion, String empNombreContacto, String empTelContacto, String empCorreoElectronico, String empNit, Date fecCrea, String usuCrea, short regActivo) {
        this.empId = empId;
        this.empNombre = empNombre;
        this.empDireccion = empDireccion;
        this.empNombreContacto = empNombreContacto;
        this.empTelContacto = empTelContacto;
        this.empCorreoElectronico = empCorreoElectronico;
        this.empNit = empNit;
        this.fecCrea = fecCrea;
        this.usuCrea = usuCrea;
        this.regActivo = regActivo;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getEmpNombre() {
        return empNombre;
    }

    public void setEmpNombre(String empNombre) {
        this.empNombre = empNombre;
    }

    public String getEmpDireccion() {
        return empDireccion;
    }

    public void setEmpDireccion(String empDireccion) {
        this.empDireccion = empDireccion;
    }

    public String getEmpNombreContacto() {
        return empNombreContacto;
    }

    public void setEmpNombreContacto(String empNombreContacto) {
        this.empNombreContacto = empNombreContacto;
    }

    public String getEmpTelContacto() {
        return empTelContacto;
    }

    public void setEmpTelContacto(String empTelContacto) {
        this.empTelContacto = empTelContacto;
    }

    public String getEmpCorreoElectronico() {
        return empCorreoElectronico;
    }

    public void setEmpCorreoElectronico(String empCorreoElectronico) {
        this.empCorreoElectronico = empCorreoElectronico;
    }

    public String getEmpNit() {
        return empNit;
    }

    public void setEmpNit(String empNit) {
        this.empNit = empNit;
    }

    public String getEmpLogo() {
        return empLogo;
    }

    public void setEmpLogo(String empLogo) {
        this.empLogo = empLogo;
    }

    public String getEmpDescripcion() {
        return empDescripcion;
    }

    public void setEmpDescripcion(String empDescripcion) {
        this.empDescripcion = empDescripcion;
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
    public Set<Tecnico> getTecnicoSet() {
        return tecnicoSet;
    }

    public void setTecnicoSet(Set<Tecnico> tecnicoSet) {
        this.tecnicoSet = tecnicoSet;
    }

    @XmlTransient
    public Set<OrdenCompra> getOrdenCompraSet() {
        return ordenCompraSet;
    }

    public void setOrdenCompraSet(Set<OrdenCompra> ordenCompraSet) {
        this.ordenCompraSet = ordenCompraSet;
    }

    @XmlTransient
    public Set<EquipoElectrico> getEquipoElectricoSet() {
        return equipoElectricoSet;
    }

    public void setEquipoElectricoSet(Set<EquipoElectrico> equipoElectricoSet) {
        this.equipoElectricoSet = equipoElectricoSet;
    }

    @XmlTransient
    public Set<ServicioOfrecido> getServicioOfrecidoSet() {
        return servicioOfrecidoSet;
    }

    public void setServicioOfrecidoSet(Set<ServicioOfrecido> servicioOfrecidoSet) {
        this.servicioOfrecidoSet = servicioOfrecidoSet;
    }

    @XmlTransient
    public Set<Mantenimiento> getMantenimientoSet() {
        return mantenimientoSet;
    }

    public void setMantenimientoSet(Set<Mantenimiento> mantenimientoSet) {
        this.mantenimientoSet = mantenimientoSet;
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
    }*/

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (empId != null ? empId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmpresaServicio)) {
            return false;
        }
        EmpresaServicio other = (EmpresaServicio) object;
        if ((this.empId == null && other.empId != null) || (this.empId != null && !this.empId.equals(other.empId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.app.sigeeac.model.EmpresaServicio[ empId=" + empId + " ]";
    }
    
}
