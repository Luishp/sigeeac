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
@Table(name = "EQUIPO_ELECTRICO", catalog = "", schema = "GEEAC")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EquipoElectrico.findAll", query = "SELECT e FROM EquipoElectrico e")
    , @NamedQuery(name = "EquipoElectrico.findByEqeId", query = "SELECT e FROM EquipoElectrico e WHERE e.eqeId = :eqeId")
    , @NamedQuery(name = "EquipoElectrico.findByEqeNumInventario", query = "SELECT e FROM EquipoElectrico e WHERE e.eqeNumInventario = :eqeNumInventario")
    , @NamedQuery(name = "EquipoElectrico.findByEqeMarca", query = "SELECT e FROM EquipoElectrico e WHERE e.eqeMarca = :eqeMarca")
    , @NamedQuery(name = "EquipoElectrico.findByEqeModelo", query = "SELECT e FROM EquipoElectrico e WHERE e.eqeModelo = :eqeModelo")
    , @NamedQuery(name = "EquipoElectrico.findByEqeFecFabricacion", query = "SELECT e FROM EquipoElectrico e WHERE e.eqeFecFabricacion = :eqeFecFabricacion")
    , @NamedQuery(name = "EquipoElectrico.findByEqeFoto", query = "SELECT e FROM EquipoElectrico e WHERE e.eqeFoto = :eqeFoto")
    , @NamedQuery(name = "EquipoElectrico.findByEqeDescripcion", query = "SELECT e FROM EquipoElectrico e WHERE e.eqeDescripcion = :eqeDescripcion")
    , @NamedQuery(name = "EquipoElectrico.findByFecCrea", query = "SELECT e FROM EquipoElectrico e WHERE e.fecCrea = :fecCrea")
    , @NamedQuery(name = "EquipoElectrico.findByUsuCrea", query = "SELECT e FROM EquipoElectrico e WHERE e.usuCrea = :usuCrea")
    , @NamedQuery(name = "EquipoElectrico.findByFecModi", query = "SELECT e FROM EquipoElectrico e WHERE e.fecModi = :fecModi")
    , @NamedQuery(name = "EquipoElectrico.findByUsuModi", query = "SELECT e FROM EquipoElectrico e WHERE e.usuModi = :usuModi")
    , @NamedQuery(name = "EquipoElectrico.findByRegActivo", query = "SELECT e FROM EquipoElectrico e WHERE e.regActivo = :regActivo")})
public class EquipoElectrico implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "EQE_ID")
    private Integer eqeId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "EQE_NUM_INVENTARIO")
    private String eqeNumInventario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "EQE_MARCA")
    private String eqeMarca;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "EQE_MODELO")
    private String eqeModelo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "EQE_FEC_FABRICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date eqeFecFabricacion;
    @Size(max = 250)
    @Column(name = "EQE_FOTO")
    private String eqeFoto;
    @Size(max = 4000)
    @Column(name = "EQE_DESCRIPCION")
    private String eqeDescripcion;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vcaEqeId", fetch = FetchType.LAZY)
    private Set<ValorCaracteristica> valorCaracteristicaSet;
    @JoinColumn(name = "EQE_CMD_ID", referencedColumnName = "CMD_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private OrdenCompraDet eqeCmdId;
    @JoinColumn(name = "EQE_TEQ_ID", referencedColumnName = "TEQ_ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TipoEquipoElectrico eqeTeqId;
    @JoinColumn(name = "EQE_UAD_ID", referencedColumnName = "UAD_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private UnidadAdministrativa eqeUadId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mttEqeId", fetch = FetchType.LAZY)
    private Set<Mantenimiento> mantenimientoSet;

    public EquipoElectrico() {
    }

    public EquipoElectrico(Integer eqeId) {
        this.eqeId = eqeId;
    }

    public EquipoElectrico(Integer eqeId, String eqeNumInventario, String eqeMarca, String eqeModelo, Date eqeFecFabricacion, Date fecCrea, String usuCrea, short regActivo) {
        this.eqeId = eqeId;
        this.eqeNumInventario = eqeNumInventario;
        this.eqeMarca = eqeMarca;
        this.eqeModelo = eqeModelo;
        this.eqeFecFabricacion = eqeFecFabricacion;
        this.fecCrea = fecCrea;
        this.usuCrea = usuCrea;
        this.regActivo = regActivo;
    }

    public Integer getEqeId() {
        return eqeId;
    }

    public void setEqeId(Integer eqeId) {
        this.eqeId = eqeId;
    }

    public String getEqeNumInventario() {
        return eqeNumInventario;
    }

    public void setEqeNumInventario(String eqeNumInventario) {
        this.eqeNumInventario = eqeNumInventario;
    }

    public String getEqeMarca() {
        return eqeMarca;
    }

    public void setEqeMarca(String eqeMarca) {
        this.eqeMarca = eqeMarca;
    }

    public String getEqeModelo() {
        return eqeModelo;
    }

    public void setEqeModelo(String eqeModelo) {
        this.eqeModelo = eqeModelo;
    }

    public Date getEqeFecFabricacion() {
        return eqeFecFabricacion;
    }

    public void setEqeFecFabricacion(Date eqeFecFabricacion) {
        this.eqeFecFabricacion = eqeFecFabricacion;
    }

    public String getEqeFoto() {
        return eqeFoto;
    }

    public void setEqeFoto(String eqeFoto) {
        this.eqeFoto = eqeFoto;
    }

    public String getEqeDescripcion() {
        return eqeDescripcion;
    }

    public void setEqeDescripcion(String eqeDescripcion) {
        this.eqeDescripcion = eqeDescripcion;
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
    public Set<ValorCaracteristica> getValorCaracteristicaSet() {
        return valorCaracteristicaSet;
    }

    public void setValorCaracteristicaSet(Set<ValorCaracteristica> valorCaracteristicaSet) {
        this.valorCaracteristicaSet = valorCaracteristicaSet;
    }

    public OrdenCompraDet getEqeCmdId() {
        return eqeCmdId;
    }

    public void setEqeCmdId(OrdenCompraDet eqeCmdId) {
        this.eqeCmdId = eqeCmdId;
    }

    public TipoEquipoElectrico getEqeTeqId() {
        return eqeTeqId;
    }

    public void setEqeTeqId(TipoEquipoElectrico eqeTeqId) {
        this.eqeTeqId = eqeTeqId;
    }

    public UnidadAdministrativa getEqeUadId() {
        return eqeUadId;
    }

    public void setEqeUadId(UnidadAdministrativa eqeUadId) {
        this.eqeUadId = eqeUadId;
    }

    @XmlTransient
    public Set<Mantenimiento> getMantenimientoSet() {
        return mantenimientoSet;
    }

    public void setMantenimientoSet(Set<Mantenimiento> mantenimientoSet) {
        this.mantenimientoSet = mantenimientoSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (eqeId != null ? eqeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EquipoElectrico)) {
            return false;
        }
        EquipoElectrico other = (EquipoElectrico) object;
        if ((this.eqeId == null && other.eqeId != null) || (this.eqeId != null && !this.eqeId.equals(other.eqeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.app.sigeeac.model.EquipoElectrico[ eqeId=" + eqeId + " ]";
    }
    
}
