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
@Table(name = "SUSUARIO", catalog = "", schema = "GEEAC")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Susuario.findAll", query = "SELECT s FROM Susuario s")
    , @NamedQuery(name = "Susuario.findByUsrId", query = "SELECT s FROM Susuario s WHERE s.usrId = :usrId")
    , @NamedQuery(name = "Susuario.findByUsrCarnet", query = "SELECT s FROM Susuario s WHERE s.usrCarnet = :usrCarnet")
    , @NamedQuery(name = "Susuario.findByUsrNombre", query = "SELECT s FROM Susuario s WHERE s.usrNombre = :usrNombre")
    , @NamedQuery(name = "Susuario.findByUsrApellido", query = "SELECT s FROM Susuario s WHERE s.usrApellido = :usrApellido")
    , @NamedQuery(name = "Susuario.findByUsrDui", query = "SELECT s FROM Susuario s WHERE s.usrDui = :usrDui")
    , @NamedQuery(name = "Susuario.findByUsrNit", query = "SELECT s FROM Susuario s WHERE s.usrNit = :usrNit")
    , @NamedQuery(name = "Susuario.findByUsrTelefono", query = "SELECT s FROM Susuario s WHERE s.usrTelefono = :usrTelefono")
    , @NamedQuery(name = "Susuario.findByUsrCelular", query = "SELECT s FROM Susuario s WHERE s.usrCelular = :usrCelular")
    , @NamedQuery(name = "Susuario.findByUsrCorreoElectronico", query = "SELECT s FROM Susuario s WHERE s.usrCorreoElectronico = :usrCorreoElectronico")
    , @NamedQuery(name = "Susuario.findByUsrUsuario", query = "SELECT s FROM Susuario s WHERE s.usrUsuario = :usrUsuario")
    , @NamedQuery(name = "Susuario.findByUsrContrasenia", query = "SELECT s FROM Susuario s WHERE s.usrContrasenia = :usrContrasenia")
    , @NamedQuery(name = "Susuario.findByUsrFoto", query = "SELECT s FROM Susuario s WHERE s.usrFoto = :usrFoto")
    , @NamedQuery(name = "Susuario.findByUsrDescripcion", query = "SELECT s FROM Susuario s WHERE s.usrDescripcion = :usrDescripcion")
    , @NamedQuery(name = "Susuario.findByFecCrea", query = "SELECT s FROM Susuario s WHERE s.fecCrea = :fecCrea")
    , @NamedQuery(name = "Susuario.findByUsuCrea", query = "SELECT s FROM Susuario s WHERE s.usuCrea = :usuCrea")
    , @NamedQuery(name = "Susuario.findByFecModi", query = "SELECT s FROM Susuario s WHERE s.fecModi = :fecModi")
    , @NamedQuery(name = "Susuario.findByUsuModi", query = "SELECT s FROM Susuario s WHERE s.usuModi = :usuModi")
    , @NamedQuery(name = "Susuario.findByRegActivo", query = "SELECT s FROM Susuario s WHERE s.regActivo = :regActivo")})
public class Susuario implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "USR_ID")
    private Integer usrId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "USR_CARNET")
    private String usrCarnet;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "USR_NOMBRE")
    private String usrNombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "USR_APELLIDO")
    private String usrApellido;
    @Size(max = 10)
    @Column(name = "USR_DUI")
    private String usrDui;
    @Size(max = 17)
    @Column(name = "USR_NIT")
    private String usrNit;
    @Size(max = 20)
    @Column(name = "USR_TELEFONO")
    private String usrTelefono;
    @Size(max = 20)
    @Column(name = "USR_CELULAR")
    private String usrCelular;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "USR_CORREO_ELECTRONICO")
    private String usrCorreoElectronico;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "USR_USUARIO")
    private String usrUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "USR_CONTRASENIA")
    private String usrContrasenia;
    @Size(max = 250)
    @Column(name = "USR_FOTO")
    private String usrFoto;
    @Size(max = 4000)
    @Column(name = "USR_DESCRIPCION")
    private String usrDescripcion;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cmpUsrId", fetch = FetchType.LAZY)
    private Set<OrdenCompra> ordenCompraSet;
    @JoinColumn(name = "USR_ING_ID", referencedColumnName = "ING_ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private InstitucionGubernamental usrIngId;
    @JoinColumn(name = "USR_ROL_ID", referencedColumnName = "ROL_ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Srol usrRolId;

    public Susuario() {
    }

    public Susuario(Integer usrId) {
        this.usrId = usrId;
    }

    public Susuario(Integer usrId, String usrCarnet, String usrNombre, String usrApellido, String usrCorreoElectronico, String usrUsuario, String usrContrasenia, Date fecCrea, String usuCrea, short regActivo) {
        this.usrId = usrId;
        this.usrCarnet = usrCarnet;
        this.usrNombre = usrNombre;
        this.usrApellido = usrApellido;
        this.usrCorreoElectronico = usrCorreoElectronico;
        this.usrUsuario = usrUsuario;
        this.usrContrasenia = usrContrasenia;
        this.fecCrea = fecCrea;
        this.usuCrea = usuCrea;
        this.regActivo = regActivo;
    }

    public Integer getUsrId() {
        return usrId;
    }

    public void setUsrId(Integer usrId) {
        this.usrId = usrId;
    }

    public String getUsrCarnet() {
        return usrCarnet;
    }

    public void setUsrCarnet(String usrCarnet) {
        this.usrCarnet = usrCarnet;
    }

    public String getUsrNombre() {
        return usrNombre;
    }

    public void setUsrNombre(String usrNombre) {
        this.usrNombre = usrNombre;
    }

    public String getUsrApellido() {
        return usrApellido;
    }

    public void setUsrApellido(String usrApellido) {
        this.usrApellido = usrApellido;
    }

    public String getUsrDui() {
        return usrDui;
    }

    public void setUsrDui(String usrDui) {
        this.usrDui = usrDui;
    }

    public String getUsrNit() {
        return usrNit;
    }

    public void setUsrNit(String usrNit) {
        this.usrNit = usrNit;
    }

    public String getUsrTelefono() {
        return usrTelefono;
    }

    public void setUsrTelefono(String usrTelefono) {
        this.usrTelefono = usrTelefono;
    }

    public String getUsrCelular() {
        return usrCelular;
    }

    public void setUsrCelular(String usrCelular) {
        this.usrCelular = usrCelular;
    }

    public String getUsrCorreoElectronico() {
        return usrCorreoElectronico;
    }

    public void setUsrCorreoElectronico(String usrCorreoElectronico) {
        this.usrCorreoElectronico = usrCorreoElectronico;
    }

    public String getUsrUsuario() {
        return usrUsuario;
    }

    public void setUsrUsuario(String usrUsuario) {
        this.usrUsuario = usrUsuario;
    }

    public String getUsrContrasenia() {
        return usrContrasenia;
    }

    public void setUsrContrasenia(String usrContrasenia) {
        this.usrContrasenia = usrContrasenia;
    }

    public String getUsrFoto() {
        return usrFoto;
    }

    public void setUsrFoto(String usrFoto) {
        this.usrFoto = usrFoto;
    }

    public String getUsrDescripcion() {
        return usrDescripcion;
    }

    public void setUsrDescripcion(String usrDescripcion) {
        this.usrDescripcion = usrDescripcion;
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
    public Set<OrdenCompra> getOrdenCompraSet() {
        return ordenCompraSet;
    }

    public void setOrdenCompraSet(Set<OrdenCompra> ordenCompraSet) {
        this.ordenCompraSet = ordenCompraSet;
    }

    public InstitucionGubernamental getUsrIngId() {
        return usrIngId;
    }

    public void setUsrIngId(InstitucionGubernamental usrIngId) {
        this.usrIngId = usrIngId;
    }

    public Srol getUsrRolId() {
        return usrRolId;
    }

    public void setUsrRolId(Srol usrRolId) {
        this.usrRolId = usrRolId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usrId != null ? usrId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Susuario)) {
            return false;
        }
        Susuario other = (Susuario) object;
        if ((this.usrId == null && other.usrId != null) || (this.usrId != null && !this.usrId.equals(other.usrId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.app.sigeeac.model.Susuario[ usrId=" + usrId + " ]";
    }
    
}
