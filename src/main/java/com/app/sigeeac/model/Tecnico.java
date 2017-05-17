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
@Table(name = "TECNICO", catalog = "", schema = "GEEAC")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tecnico.findAll", query = "SELECT t FROM Tecnico t")
    , @NamedQuery(name = "Tecnico.findByTecId", query = "SELECT t FROM Tecnico t WHERE t.tecId = :tecId")
    , @NamedQuery(name = "Tecnico.findByTecNombre", query = "SELECT t FROM Tecnico t WHERE t.tecNombre = :tecNombre")
    , @NamedQuery(name = "Tecnico.findByTecApellido", query = "SELECT t FROM Tecnico t WHERE t.tecApellido = :tecApellido")
    , @NamedQuery(name = "Tecnico.findByTecDescripcion", query = "SELECT t FROM Tecnico t WHERE t.tecDescripcion = :tecDescripcion")
    , @NamedQuery(name = "Tecnico.findByFecCrea", query = "SELECT t FROM Tecnico t WHERE t.fecCrea = :fecCrea")
    , @NamedQuery(name = "Tecnico.findByUsuCrea", query = "SELECT t FROM Tecnico t WHERE t.usuCrea = :usuCrea")
    , @NamedQuery(name = "Tecnico.findByFecModi", query = "SELECT t FROM Tecnico t WHERE t.fecModi = :fecModi")
    , @NamedQuery(name = "Tecnico.findByUsuModi", query = "SELECT t FROM Tecnico t WHERE t.usuModi = :usuModi")
    , @NamedQuery(name = "Tecnico.findByRegActivo", query = "SELECT t FROM Tecnico t WHERE t.regActivo = :regActivo")})
public class Tecnico implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "TEC_ID")
    private Integer tecId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "TEC_NOMBRE")
    private String tecNombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "TEC_APELLIDO")
    private String tecApellido;
    @Size(max = 4000)
    @Column(name = "TEC_DESCRIPCION")
    private String tecDescripcion;
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
    @JoinColumn(name = "TEC_EMP_ID", referencedColumnName = "EMP_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private EmpresaServicio tecEmpId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tcbTecId", fetch = FetchType.LAZY)
    private Set<TecnicoBloqueado> tecnicoBloqueadoSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eqtTecId", fetch = FetchType.LAZY)
    private Set<EquipoTrabajo> equipoTrabajoSet;

    public Tecnico() {
    }

    public Tecnico(Integer tecId) {
        this.tecId = tecId;
    }

    public Tecnico(Integer tecId, String tecNombre, String tecApellido, Date fecCrea, String usuCrea, short regActivo) {
        this.tecId = tecId;
        this.tecNombre = tecNombre;
        this.tecApellido = tecApellido;
        this.fecCrea = fecCrea;
        this.usuCrea = usuCrea;
        this.regActivo = regActivo;
    }

    public Integer getTecId() {
        return tecId;
    }

    public void setTecId(Integer tecId) {
        this.tecId = tecId;
    }

    public String getTecNombre() {
        return tecNombre;
    }

    public void setTecNombre(String tecNombre) {
        this.tecNombre = tecNombre;
    }

    public String getTecApellido() {
        return tecApellido;
    }

    public void setTecApellido(String tecApellido) {
        this.tecApellido = tecApellido;
    }

    public String getTecDescripcion() {
        return tecDescripcion;
    }

    public void setTecDescripcion(String tecDescripcion) {
        this.tecDescripcion = tecDescripcion;
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

    public EmpresaServicio getTecEmpId() {
        return tecEmpId;
    }

    public void setTecEmpId(EmpresaServicio tecEmpId) {
        this.tecEmpId = tecEmpId;
    }

    @XmlTransient
    public Set<TecnicoBloqueado> getTecnicoBloqueadoSet() {
        return tecnicoBloqueadoSet;
    }

    public void setTecnicoBloqueadoSet(Set<TecnicoBloqueado> tecnicoBloqueadoSet) {
        this.tecnicoBloqueadoSet = tecnicoBloqueadoSet;
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
        hash += (tecId != null ? tecId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tecnico)) {
            return false;
        }
        Tecnico other = (Tecnico) object;
        if ((this.tecId == null && other.tecId != null) || (this.tecId != null && !this.tecId.equals(other.tecId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.app.sigeeac.model.Tecnico[ tecId=" + tecId + " ]";
    }
    
}
