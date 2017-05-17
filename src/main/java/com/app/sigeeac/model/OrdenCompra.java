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
@Table(name = "ORDEN_COMPRA", catalog = "", schema = "GEEAC")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrdenCompra.findAll", query = "SELECT o FROM OrdenCompra o")
    , @NamedQuery(name = "OrdenCompra.findByCmpId", query = "SELECT o FROM OrdenCompra o WHERE o.cmpId = :cmpId")
    , @NamedQuery(name = "OrdenCompra.findByCmpFechaCompra", query = "SELECT o FROM OrdenCompra o WHERE o.cmpFechaCompra = :cmpFechaCompra")
    , @NamedQuery(name = "OrdenCompra.findByCmpNumeroComprobante", query = "SELECT o FROM OrdenCompra o WHERE o.cmpNumeroComprobante = :cmpNumeroComprobante")
    , @NamedQuery(name = "OrdenCompra.findByCmpLugar", query = "SELECT o FROM OrdenCompra o WHERE o.cmpLugar = :cmpLugar")
    , @NamedQuery(name = "OrdenCompra.findByCmpFormaPago", query = "SELECT o FROM OrdenCompra o WHERE o.cmpFormaPago = :cmpFormaPago")
    , @NamedQuery(name = "OrdenCompra.findByCmpNumRequerimiento", query = "SELECT o FROM OrdenCompra o WHERE o.cmpNumRequerimiento = :cmpNumRequerimiento")
    , @NamedQuery(name = "OrdenCompra.findByCmpDescripcion", query = "SELECT o FROM OrdenCompra o WHERE o.cmpDescripcion = :cmpDescripcion")
    , @NamedQuery(name = "OrdenCompra.findByFecCrea", query = "SELECT o FROM OrdenCompra o WHERE o.fecCrea = :fecCrea")
    , @NamedQuery(name = "OrdenCompra.findByUsuCrea", query = "SELECT o FROM OrdenCompra o WHERE o.usuCrea = :usuCrea")
    , @NamedQuery(name = "OrdenCompra.findByFecModi", query = "SELECT o FROM OrdenCompra o WHERE o.fecModi = :fecModi")
    , @NamedQuery(name = "OrdenCompra.findByUsuModi", query = "SELECT o FROM OrdenCompra o WHERE o.usuModi = :usuModi")
    , @NamedQuery(name = "OrdenCompra.findByRegActivo", query = "SELECT o FROM OrdenCompra o WHERE o.regActivo = :regActivo")})
public class OrdenCompra implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CMP_ID")
    private Integer cmpId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CMP_FECHA_COMPRA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cmpFechaCompra;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "CMP_NUMERO_COMPROBANTE")
    private String cmpNumeroComprobante;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "CMP_LUGAR")
    private String cmpLugar;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "CMP_FORMA_PAGO")
    private String cmpFormaPago;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "CMP_NUM_REQUERIMIENTO")
    private String cmpNumRequerimiento;
    @Size(max = 4000)
    @Column(name = "CMP_DESCRIPCION")
    private String cmpDescripcion;
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
    @OneToMany(mappedBy = "cmdCmpId", fetch = FetchType.LAZY)
    private Set<OrdenCompraDet> ordenCompraDetSet;
    @JoinColumn(name = "CMP_EMP_ID", referencedColumnName = "EMP_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private EmpresaServicio cmpEmpId;
    @JoinColumn(name = "CMP_ING_ID", referencedColumnName = "ING_ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private InstitucionGubernamental cmpIngId;
    @JoinColumn(name = "CMP_USR_ID", referencedColumnName = "USR_ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Susuario cmpUsrId;
    @JoinColumn(name = "CMP_TPC_ID", referencedColumnName = "TPC_ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TipoCompra cmpTpcId;

    public OrdenCompra() {
    }

    public OrdenCompra(Integer cmpId) {
        this.cmpId = cmpId;
    }

    public OrdenCompra(Integer cmpId, Date cmpFechaCompra, String cmpNumeroComprobante, String cmpLugar, String cmpFormaPago, String cmpNumRequerimiento, Date fecCrea, String usuCrea, short regActivo) {
        this.cmpId = cmpId;
        this.cmpFechaCompra = cmpFechaCompra;
        this.cmpNumeroComprobante = cmpNumeroComprobante;
        this.cmpLugar = cmpLugar;
        this.cmpFormaPago = cmpFormaPago;
        this.cmpNumRequerimiento = cmpNumRequerimiento;
        this.fecCrea = fecCrea;
        this.usuCrea = usuCrea;
        this.regActivo = regActivo;
    }

    public Integer getCmpId() {
        return cmpId;
    }

    public void setCmpId(Integer cmpId) {
        this.cmpId = cmpId;
    }

    public Date getCmpFechaCompra() {
        return cmpFechaCompra;
    }

    public void setCmpFechaCompra(Date cmpFechaCompra) {
        this.cmpFechaCompra = cmpFechaCompra;
    }

    public String getCmpNumeroComprobante() {
        return cmpNumeroComprobante;
    }

    public void setCmpNumeroComprobante(String cmpNumeroComprobante) {
        this.cmpNumeroComprobante = cmpNumeroComprobante;
    }

    public String getCmpLugar() {
        return cmpLugar;
    }

    public void setCmpLugar(String cmpLugar) {
        this.cmpLugar = cmpLugar;
    }

    public String getCmpFormaPago() {
        return cmpFormaPago;
    }

    public void setCmpFormaPago(String cmpFormaPago) {
        this.cmpFormaPago = cmpFormaPago;
    }

    public String getCmpNumRequerimiento() {
        return cmpNumRequerimiento;
    }

    public void setCmpNumRequerimiento(String cmpNumRequerimiento) {
        this.cmpNumRequerimiento = cmpNumRequerimiento;
    }

    public String getCmpDescripcion() {
        return cmpDescripcion;
    }

    public void setCmpDescripcion(String cmpDescripcion) {
        this.cmpDescripcion = cmpDescripcion;
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
    public Set<OrdenCompraDet> getOrdenCompraDetSet() {
        return ordenCompraDetSet;
    }

    public void setOrdenCompraDetSet(Set<OrdenCompraDet> ordenCompraDetSet) {
        this.ordenCompraDetSet = ordenCompraDetSet;
    }

    public EmpresaServicio getCmpEmpId() {
        return cmpEmpId;
    }

    public void setCmpEmpId(EmpresaServicio cmpEmpId) {
        this.cmpEmpId = cmpEmpId;
    }

    public InstitucionGubernamental getCmpIngId() {
        return cmpIngId;
    }

    public void setCmpIngId(InstitucionGubernamental cmpIngId) {
        this.cmpIngId = cmpIngId;
    }

    public Susuario getCmpUsrId() {
        return cmpUsrId;
    }

    public void setCmpUsrId(Susuario cmpUsrId) {
        this.cmpUsrId = cmpUsrId;
    }

    public TipoCompra getCmpTpcId() {
        return cmpTpcId;
    }

    public void setCmpTpcId(TipoCompra cmpTpcId) {
        this.cmpTpcId = cmpTpcId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cmpId != null ? cmpId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrdenCompra)) {
            return false;
        }
        OrdenCompra other = (OrdenCompra) object;
        if ((this.cmpId == null && other.cmpId != null) || (this.cmpId != null && !this.cmpId.equals(other.cmpId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.app.sigeeac.model.OrdenCompra[ cmpId=" + cmpId + " ]";
    }
    
}
