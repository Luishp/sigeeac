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
@Table(name = "SOLICITUD_COMPRA", catalog = "", schema = "GEEAC")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SolicitudCompra.findAll", query = "SELECT s FROM SolicitudCompra s")
    , @NamedQuery(name = "SolicitudCompra.findBySolId", query = "SELECT s FROM SolicitudCompra s WHERE s.solId = :solId")
    , @NamedQuery(name = "SolicitudCompra.findBySolNumeroSolicitud", query = "SELECT s FROM SolicitudCompra s WHERE s.solNumeroSolicitud = :solNumeroSolicitud")
    , @NamedQuery(name = "SolicitudCompra.findBySolNombreSolicitud", query = "SELECT s FROM SolicitudCompra s WHERE s.solNombreSolicitud = :solNombreSolicitud")
    , @NamedQuery(name = "SolicitudCompra.findBySolCantidad", query = "SELECT s FROM SolicitudCompra s WHERE s.solCantidad = :solCantidad")
    , @NamedQuery(name = "SolicitudCompra.findBySolFechaSolicitud", query = "SELECT s FROM SolicitudCompra s WHERE s.solFechaSolicitud = :solFechaSolicitud")
    , @NamedQuery(name = "SolicitudCompra.findBySolEstado", query = "SELECT s FROM SolicitudCompra s WHERE s.solEstado = :solEstado")
    , @NamedQuery(name = "SolicitudCompra.findBySolJustificacion", query = "SELECT s FROM SolicitudCompra s WHERE s.solJustificacion = :solJustificacion")
    , @NamedQuery(name = "SolicitudCompra.findBySolObjetivo", query = "SELECT s FROM SolicitudCompra s WHERE s.solObjetivo = :solObjetivo")
    , @NamedQuery(name = "SolicitudCompra.findBySolEspecificacionTecnica", query = "SELECT s FROM SolicitudCompra s WHERE s.solEspecificacionTecnica = :solEspecificacionTecnica")
    , @NamedQuery(name = "SolicitudCompra.findByFecCrea", query = "SELECT s FROM SolicitudCompra s WHERE s.fecCrea = :fecCrea")
    , @NamedQuery(name = "SolicitudCompra.findByUsuCrea", query = "SELECT s FROM SolicitudCompra s WHERE s.usuCrea = :usuCrea")
    , @NamedQuery(name = "SolicitudCompra.findByFecModi", query = "SELECT s FROM SolicitudCompra s WHERE s.fecModi = :fecModi")
    , @NamedQuery(name = "SolicitudCompra.findByUsuModi", query = "SELECT s FROM SolicitudCompra s WHERE s.usuModi = :usuModi")
    , @NamedQuery(name = "SolicitudCompra.findByRegActivo", query = "SELECT s FROM SolicitudCompra s WHERE s.regActivo = :regActivo")})
public class SolicitudCompra implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "SOL_ID")
    public Integer solId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 254)
    @Column(name = "SOL_NUMERO_SOLICITUD")
    public String solNumeroSolicitud;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 254)
    @Column(name = "SOL_NOMBRE_SOLICITUD")
    public String solNombreSolicitud;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SOL_CANTIDAD")
    public BigInteger solCantidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SOL_FECHA_SOLICITUD")
    @Temporal(TemporalType.TIMESTAMP)
    public Date solFechaSolicitud;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "SOL_ESTADO")
    public String solEstado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4000)
    @Column(name = "SOL_JUSTIFICACION")
    public String solJustificacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4000)
    @Column(name = "SOL_OBJETIVO")
    public String solObjetivo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4000)
    @Column(name = "SOL_ESPECIFICACION_TECNICA")
    public String solEspecificacionTecnica;
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
    @JoinColumn(name = "SOL_CMP_ID", referencedColumnName = "CMP_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    public OrdenCompra solCmpId;
    @JoinColumn(name = "SOL_TEQ_ID", referencedColumnName = "TEQ_ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    public TipoEquipoElectrico solTeqId;
    @JoinColumn(name = "SOL_UAD_ID", referencedColumnName = "UAD_ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    public UnidadAdministrativa solUadId;

    public SolicitudCompra() {
    }

    public SolicitudCompra(Integer solId) {
        this.solId = solId;
    }

    public SolicitudCompra(Integer solId, String solNumeroSolicitud, String solNombreSolicitud, BigInteger solCantidad, Date solFechaSolicitud, String solEstado, String solJustificacion, String solObjetivo, String solEspecificacionTecnica, Date fecCrea, String usuCrea, short regActivo) {
        this.solId = solId;
        this.solNumeroSolicitud = solNumeroSolicitud;
        this.solNombreSolicitud = solNombreSolicitud;
        this.solCantidad = solCantidad;
        this.solFechaSolicitud = solFechaSolicitud;
        this.solEstado = solEstado;
        this.solJustificacion = solJustificacion;
        this.solObjetivo = solObjetivo;
        this.solEspecificacionTecnica = solEspecificacionTecnica;
        this.fecCrea = fecCrea;
        this.usuCrea = usuCrea;
        this.regActivo = regActivo;
    }

    public Integer getSolId() {
        return solId;
    }

    public void setSolId(Integer solId) {
        this.solId = solId;
    }

    public String getSolNumeroSolicitud() {
        return solNumeroSolicitud;
    }

    public void setSolNumeroSolicitud(String solNumeroSolicitud) {
        this.solNumeroSolicitud = solNumeroSolicitud;
    }

    public String getSolNombreSolicitud() {
        return solNombreSolicitud;
    }

    public void setSolNombreSolicitud(String solNombreSolicitud) {
        this.solNombreSolicitud = solNombreSolicitud;
    }

    public BigInteger getSolCantidad() {
        return solCantidad;
    }

    public void setSolCantidad(BigInteger solCantidad) {
        this.solCantidad = solCantidad;
    }

    public Date getSolFechaSolicitud() {
        return solFechaSolicitud;
    }

    public void setSolFechaSolicitud(Date solFechaSolicitud) {
        this.solFechaSolicitud = solFechaSolicitud;
    }

    public String getSolEstado() {
        return solEstado;
    }

    public void setSolEstado(String solEstado) {
        this.solEstado = solEstado;
    }

    public String getSolJustificacion() {
        return solJustificacion;
    }

    public void setSolJustificacion(String solJustificacion) {
        this.solJustificacion = solJustificacion;
    }

    public String getSolObjetivo() {
        return solObjetivo;
    }

    public void setSolObjetivo(String solObjetivo) {
        this.solObjetivo = solObjetivo;
    }

    public String getSolEspecificacionTecnica() {
        return solEspecificacionTecnica;
    }

    public void setSolEspecificacionTecnica(String solEspecificacionTecnica) {
        this.solEspecificacionTecnica = solEspecificacionTecnica;
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

    public OrdenCompra getSolCmpId() {
        return solCmpId;
    }

    public void setSolCmpId(OrdenCompra solCmpId) {
        this.solCmpId = solCmpId;
    }

    public TipoEquipoElectrico getSolTeqId() {
        return solTeqId;
    }

    public void setSolTeqId(TipoEquipoElectrico solTeqId) {
        this.solTeqId = solTeqId;
    }

    public UnidadAdministrativa getSolUadId() {
        return solUadId;
    }

    public void setSolUadId(UnidadAdministrativa solUadId) {
        this.solUadId = solUadId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (solId != null ? solId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SolicitudCompra)) {
            return false;
        }
        SolicitudCompra other = (SolicitudCompra) object;
        if ((this.solId == null && other.solId != null) || (this.solId != null && !this.solId.equals(other.solId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.app.sigeeac.model.SolicitudCompra[ solId=" + solId + " ]";
    }
    
}
