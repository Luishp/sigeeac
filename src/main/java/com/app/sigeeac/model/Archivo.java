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
@Table(name = "ARCHIVO", catalog = "", schema = "GEEAC")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Archivo.findAll", query = "SELECT a FROM Archivo a")
    , @NamedQuery(name = "Archivo.findByArcId", query = "SELECT a FROM Archivo a WHERE a.arcId = :arcId")
    , @NamedQuery(name = "Archivo.findByArcNombre", query = "SELECT a FROM Archivo a WHERE a.arcNombre = :arcNombre")
    , @NamedQuery(name = "Archivo.findByArcArchivo", query = "SELECT a FROM Archivo a WHERE a.arcArchivo = :arcArchivo")
    , @NamedQuery(name = "Archivo.findByArcTipo", query = "SELECT a FROM Archivo a WHERE a.arcTipo = :arcTipo")
    , @NamedQuery(name = "Archivo.findByArcDescripcion", query = "SELECT a FROM Archivo a WHERE a.arcDescripcion = :arcDescripcion")
    , @NamedQuery(name = "Archivo.findByFecCrea", query = "SELECT a FROM Archivo a WHERE a.fecCrea = :fecCrea")
    , @NamedQuery(name = "Archivo.findByUsuCrea", query = "SELECT a FROM Archivo a WHERE a.usuCrea = :usuCrea")
    , @NamedQuery(name = "Archivo.findByFecModi", query = "SELECT a FROM Archivo a WHERE a.fecModi = :fecModi")
    , @NamedQuery(name = "Archivo.findByUsuModi", query = "SELECT a FROM Archivo a WHERE a.usuModi = :usuModi")
    , @NamedQuery(name = "Archivo.findByRegActivo", query = "SELECT a FROM Archivo a WHERE a.regActivo = :regActivo")})
public class Archivo implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ARC_ID")
    private Integer arcId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "ARC_NOMBRE")
    private String arcNombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "ARC_ARCHIVO")
    private String arcArchivo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "ARC_TIPO")
    private String arcTipo;
    @Size(max = 4000)
    @Column(name = "ARC_DESCRIPCION")
    private String arcDescripcion;
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
    @JoinColumn(name = "ARC_MTT_ID", referencedColumnName = "MTT_ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Mantenimiento arcMttId;

    public Archivo() {
    }

    public Archivo(Integer arcId) {
        this.arcId = arcId;
    }

    public Archivo(Integer arcId, String arcNombre, String arcArchivo, String arcTipo, Date fecCrea, String usuCrea, short regActivo) {
        this.arcId = arcId;
        this.arcNombre = arcNombre;
        this.arcArchivo = arcArchivo;
        this.arcTipo = arcTipo;
        this.fecCrea = fecCrea;
        this.usuCrea = usuCrea;
        this.regActivo = regActivo;
    }

    public Integer getArcId() {
        return arcId;
    }

    public void setArcId(Integer arcId) {
        this.arcId = arcId;
    }

    public String getArcNombre() {
        return arcNombre;
    }

    public void setArcNombre(String arcNombre) {
        this.arcNombre = arcNombre;
    }

    public String getArcArchivo() {
        return arcArchivo;
    }

    public void setArcArchivo(String arcArchivo) {
        this.arcArchivo = arcArchivo;
    }

    public String getArcTipo() {
        return arcTipo;
    }

    public void setArcTipo(String arcTipo) {
        this.arcTipo = arcTipo;
    }

    public String getArcDescripcion() {
        return arcDescripcion;
    }

    public void setArcDescripcion(String arcDescripcion) {
        this.arcDescripcion = arcDescripcion;
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

    public Mantenimiento getArcMttId() {
        return arcMttId;
    }

    public void setArcMttId(Mantenimiento arcMttId) {
        this.arcMttId = arcMttId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (arcId != null ? arcId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Archivo)) {
            return false;
        }
        Archivo other = (Archivo) object;
        if ((this.arcId == null && other.arcId != null) || (this.arcId != null && !this.arcId.equals(other.arcId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.app.sigeeac.model.Archivo[ arcId=" + arcId + " ]";
    }
    
}
