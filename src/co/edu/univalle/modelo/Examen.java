/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.univalle.modelo;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author JHOJAN L
 */
@Entity
@Table(name = "examen")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Examen.findAll", query = "SELECT e FROM Examen e")
    , @NamedQuery(name = "Examen.findByCodigo", query = "SELECT e FROM Examen e WHERE e.codigo = :codigo")
    , @NamedQuery(name = "Examen.findByNombre", query = "SELECT e FROM Examen e WHERE e.nombre = :nombre")})
public class Examen implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo")
    private Integer codigo;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "examen")
    private Collection<ExamenEstudiante> examenEstudianteCollection;
    @JoinColumn(name = "codigo_profesor", referencedColumnName = "codigo")
    @ManyToOne(optional = false)
    private Profesor codigoProfesor;
    @JoinColumn(name = "codigo_clase", referencedColumnName = "codigo")
    @ManyToOne(optional = false)
    private Clase codigoClase;
    @JoinColumn(name = "codigo_modulo", referencedColumnName = "codigo")
    @ManyToOne(optional = false)
    private Modulo codigoModulo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoExamen")
    private Collection<Pregunta> preguntaCollection;

    public Examen() {
    }

    public Examen(Integer codigo) {
        this.codigo = codigo;
    }

    public Examen(Integer codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public Examen(String nombre, Profesor profesor, Clase clase, Modulo modulo) {
        this.nombre = nombre;
        this.codigoProfesor = profesor;
        this.codigoClase = clase;
        this.codigoModulo = modulo;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public Collection<ExamenEstudiante> getExamenEstudianteCollection() {
        return examenEstudianteCollection;
    }

    public void setExamenEstudianteCollection(Collection<ExamenEstudiante> examenEstudianteCollection) {
        this.examenEstudianteCollection = examenEstudianteCollection;
    }

    public Profesor getCodigoProfesor() {
        return codigoProfesor;
    }

    public void setCodigoProfesor(Profesor codigoProfesor) {
        this.codigoProfesor = codigoProfesor;
    }

    public Clase getCodigoClase() {
        return codigoClase;
    }

    public void setCodigoClase(Clase codigoClase) {
        this.codigoClase = codigoClase;
    }

    public Modulo getCodigoModulo() {
        return codigoModulo;
    }

    public void setCodigoModulo(Modulo codigoModulo) {
        this.codigoModulo = codigoModulo;
    }

    @XmlTransient
    public Collection<Pregunta> getPreguntaCollection() {
        return preguntaCollection;
    }

    public void setPreguntaCollection(Collection<Pregunta> preguntaCollection) {
        this.preguntaCollection = preguntaCollection;
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
        if (!(object instanceof Examen)) {
            return false;
        }
        Examen other = (Examen) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.univalle.modelo.Examen[ codigo=" + codigo + " ]";
    }

}
