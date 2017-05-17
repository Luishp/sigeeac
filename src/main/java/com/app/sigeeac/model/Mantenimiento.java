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
@Table(name = "MANTENIMIENTO", catalog = "", schema = "GEEAC")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mantenimiento.findAll", query = "SELECT m FROM Mantenimiento m")
    , @NamedQuery(name = "Mantenimiento.findByMttId", query = "SELECT m FROM Mantenimiento m WHERE m.mttId = :mttId")
    , @NamedQuery(name = "Mantenimiento.findByMttFecInicio", query = "SELECT m FROM Mantenimiento m WHERE m.mttFecInicio = :mttFecInicio")
    , @NamedQuery(name = "Mantenimiento.findByMttFecFin", query = "SELECT m FROM Mantenimiento m WHERE m.mttFecFin = :mttFecFin")
    , @NamedQuery(name = "Mantenimiento.findByMttEstadoEquipoInicio", query = "SELECT m FROM Mantenimiento m WHERE m.mttEstadoEquipoInicio = :mttEstadoEquipoInicio")
    , @NamedQuery(name = "Mantenimiento.findByMttEstadoEquipoFin", query = "SELECT m FROM Mantenimiento m WHERE m.mttEstadoEquipoFin = :mttEstadoEquipoFin")
    , @NamedQuery(name = "Mantenimiento.findByMttEstadoMantenimiento", query = "SELECT m FROM Mantenimiento m WHERE m.mttEstadoMantenimiento = :mttEstadoMantenimiento")
    , @NamedQuery(name = "Mantenimiento.findByMttDescripcion", query = "SELECT m FROM Mantenimiento m WHERE m.mttDescripcion = :mttDescripcion")
    , @NamedQuery(name = "Mantenimiento.findByFecCrea", query = "SELECT m FROM Mantenimiento m WHERE m.fecCrea = :fecCrea")
    , @NamedQuery(name = "Mantenimiento.findByUsuCrea", query = "SELECT m FROM Mantenimiento m WHERE m.usuCrea = :usuCrea")
    , @NamedQuery(name = "Mantenimiento.findByFecModi", query = "SELECT m FROM Mantenimiento m WHERE m.fecModi = :fecModi")
    , @NamedQuery(name = "Mantenimiento.findByUsuModi", query = "SELECT m FROM Mantenimiento m WHERE m.usuModi = :usuModi")
    , @NamedQuery(name = "Mantenimiento.findByRegActivo", query = "SELECT m FROM Mantenimiento m WHERE m.regActivo = :regActivo")})
public class Mantenimiento implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "MTT_ID")
    private Integer mttId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MTT_FEC_INICIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date mttFecInicio;
    @Column(name = "MTT_FEC_FIN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date mttFecFin;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4000)
    @Column(name = "MTT_ESTADO_EQUIPO_INICIO")
    private String mttEstadoEquipoInicio;
    @Size(max = 4000)
    @Column(name = "MTT_ESTADO_EQUIPO_FIN")
    private String mttEstadoEquipoFin;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MTT_ESTADO_MANTENIMIENTO")
    private short mttEstadoMantenimiento;
    @Size(max = 4000)
    @Column(name = "MTT_DESCRIPCION")
    private String mttDescripcion;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "arcMttId", fetch = FetchType.LAZY)
    private Set<Archivo> archivoSet;
    @JoinColumn(name = "MTT_EMP_ID", referencedColumnName = "EMP_ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private EmpresaServicio mttEmpId;
    @JoinColumn(name = "MTT_EQE_ID", referencedColumnName = "EQE_ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private EquipoElectrico mttEqeId;
    @JoinColumn(name = "MTT_TMT_ID", referencedColumnName = "TMT_ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TipoMantenimiento mttTmtId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eqtMttId", fetch = FetchType.LAZY)
    private Set<EquipoTrabajo> equipoTrabajoSet;

    public Mantenimiento() {
    }

    public Mantenimiento(Integer mttId) {
        this.mttId = mttId;
    }

    public Mantenimiento(Integer mttId, Date mttFecInicio, String mttEstadoEquipoInicio, short mttEstadoMantenimiento, Date fecCrea, String usuCrea, short regActivo) {
        this.mttId = mttId;
        this.mttFecInicio = mttFecInicio;
        this.mttEstadoEquipoInicio = mttEstadoEquipoInicio;
        this.mttEstadoMantenimiento = mttEstadoMantenimiento;
        this.fecCrea = fecCrea;
        this.usuCrea = usuCrea;
        this.regActivo = regActivo;
    }

    public Integer getMttId() {
        return mttId;
    }

    public void setMttId(Integer mttId) {
        this.mttId = mttId;
    }

    public Date getMttFecInicio() {
        return mttFecInicio;
    }

    public void setMttFecInicio(Date mttFecInicio) {
        this.mttFecInicio = mttFecInicio;
    }

    public Date getMttFecFin() {
        return mttFecFin;
    }

    public void setMttFecFin(Date mttFecFin) {
        this.mttFecFin = mttFecFin;
    }

    public String getMttEstadoEquipoInicio() {
        return mttEstadoEquipoInicio;
    }

    public void setMttEstadoEquipoInicio(String mttEstadoEquipoInicio) {
        this.mttEstadoEquipoInicio = mttEstadoEquipoInicio;
    }

    public String getMttEstadoEquipoFin() {
        return mttEstadoEquipoFin;
    }

    public void setMttEstadoEquipoFin(String mttEstadoEquipoFin) {
        this.mttEstadoEquipoFin = mttEstadoEquipoFin;
    }

    public short getMttEstadoMantenimiento() {
        return mttEstadoMantenimiento;
    }

    public void setMttEstadoMantenimiento(short mttEstadoMantenimiento) {
        this.mttEstadoMantenimiento = mttEstadoMantenimiento;
    }

    public String getMttDescripcion() {
        return mttDescripcion;
    }

    public void setMttDescripcion(String mttDescripcion) {
        this.mttDescripcion = mttDescripcion;
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
    public Set<Archivo> getArchivoSet() {
        return archivoSet;
    }

    public void setArchivoSet(Set<Archivo> archivoSet) {
        this.archivoSet = archivoSet;
    }

    public EmpresaServicio getMttEmpId() {
        return mttEmpId;
    }

    public void setMttEmpId(EmpresaServicio mttEmpId) {
        this.mttEmpId = mttEmpId;
    }

    public EquipoElectrico getMttEqeId() {
        return mttEqeId;
    }

    public void setMttEqeId(EquipoElectrico mttEqeId) {
        this.mttEqeId = mttEqeId;
    }

    public TipoMantenimiento getMttTmtId() {
        return mttTmtId;
    }

    public void setMttTmtId(TipoMantenimiento mttTmtId) {
        this.mttTmtId = mttTmtId;
    }

    @XmlTransient
    public Set<EquipoTrabajo> getEquipoTrabajoSet() {
        return equipoTrabajoSet;
    }

    public void setEquipoTrabajoSet(Set<EquipoTrabajo> equipoTrabajoSet) {
        this.equipoTrabajoSet = equipoTrabajoSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mttId != null ? mttId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mantenimiento)) {
            return false;
        }
        Mantenimiento other = (Mantenimiento) object;
        if ((this.mttId == null && other.mttId != null) || (this.mttId != null && !this.mttId.equals(other.mttId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.app.sigeeac.model.Mantenimiento[ mttId=" + mttId + " ]";
    }
    
}
