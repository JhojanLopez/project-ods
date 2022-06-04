/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.univalle.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author JHOJAN L
 */
@Entity
@Table(name = "estudiante")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estudiante.findAll", query = "SELECT e FROM Estudiante e")
    , @NamedQuery(name = "Estudiante.findByCodigo", query = "SELECT e FROM Estudiante e WHERE e.codigo = :codigo")
    , @NamedQuery(name = "Estudiante.findByNombre", query = "SELECT e FROM Estudiante e WHERE e.nombre = :nombre")
    , @NamedQuery(name = "Estudiante.findByUsuario", query = "SELECT e FROM Estudiante e WHERE e.usuario = :usuario")
    , @NamedQuery(name = "Estudiante.findByEdad", query = "SELECT e FROM Estudiante e WHERE e.edad = :edad")
    , @NamedQuery(name = "Estudiante.findByGenero", query = "SELECT e FROM Estudiante e WHERE e.genero = :genero")
    , @NamedQuery(name = "Estudiante.findByContrasena", query = "SELECT e FROM Estudiante e WHERE e.contrasena = :contrasena")
    ,@NamedQuery(name = "Estudiante.findByCodigoClase", query = "SELECT e FROM Estudiante e WHERE e.codigoClase = :codigoClase")

})
public class Estudiante implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo")
    private Long codigo;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "usuario")
    private String usuario;
    @Basic(optional = false)
    @Column(name = "edad")
    private int edad;
    @Basic(optional = false)
    @Column(name = "genero")
    private String genero;
    @Basic(optional = false)
    @Column(name = "contrasena")
    private String contrasena;
    @JoinColumn(name = "codigo_avatar", referencedColumnName = "codigo")
    @ManyToOne(optional = false)
    private Avatar codigoAvatar;
    @JoinColumn(name = "codigo_clase", referencedColumnName = "codigo")
    @ManyToOne
    private Clase codigoClase;

    public Estudiante() {
    }

    public Estudiante(Long codigo) {
        this.codigo = codigo;
    }

    public Estudiante(Long codigo, String nombre, String usuario, int edad, String genero, String contrasena) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.usuario = usuario;
        this.edad = edad;
        this.genero = genero;
        this.contrasena = contrasena;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Avatar getCodigoAvatar() {
        return codigoAvatar;
    }

    public void setCodigoAvatar(Avatar codigoAvatar) {
        this.codigoAvatar = codigoAvatar;
    }

    public Clase getCodigoClase() {
        return codigoClase;
    }

    public void setCodigoClase(Clase codigoClase) {
        this.codigoClase = codigoClase;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estudiante)) {
            return false;
        }
        Estudiante other = (Estudiante) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.univalle.modelo.Estudiante[ codigo=" + codigo + " ]";
    }

}
