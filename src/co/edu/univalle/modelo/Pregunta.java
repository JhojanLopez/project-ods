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
@Table(name = "pregunta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pregunta.findAll", query = "SELECT p FROM Pregunta p")
    , @NamedQuery(name = "Pregunta.findByCodigo", query = "SELECT p FROM Pregunta p WHERE p.codigo = :codigo")
    , @NamedQuery(name = "Pregunta.findByEnunciado", query = "SELECT p FROM Pregunta p WHERE p.enunciado = :enunciado")
    , @NamedQuery(name = "Pregunta.findByRespuesta", query = "SELECT p FROM Pregunta p WHERE p.respuesta = :respuesta")
    ,@NamedQuery(name = "Pregunta.findByExamen", query = "SELECT p FROM Pregunta p WHERE p.codigoExamen = :codigoExamen")

})
public class Pregunta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo")
    private Long codigo;
    @Basic(optional = false)
    @Column(name = "enunciado")
    private String enunciado;
    @Basic(optional = false)
    @Column(name = "respuesta")
    private String respuesta;
    @JoinColumn(name = "codigo_metodologia", referencedColumnName = "codigo")
    @ManyToOne(optional = false)
    private Metodologia codigoMetodologia;
    @JoinColumn(name = "codigo_profesor", referencedColumnName = "codigo")
    @ManyToOne(optional = false)
    private Profesor codigoProfesor;
    @JoinColumn(name = "codigo_examen", referencedColumnName = "codigo")
    @ManyToOne(optional = false)
    private Examen codigoExamen;

    public Pregunta() {
    }

    public Pregunta(Long codigo) {
        this.codigo = codigo;
    }

    public Pregunta(Long codigo, String enunciado, String respuesta) {
        this.codigo = codigo;
        this.enunciado = enunciado;
        this.respuesta = respuesta;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public Metodologia getCodigoMetodologia() {
        return codigoMetodologia;
    }

    public void setCodigoMetodologia(Metodologia codigoMetodologia) {
        this.codigoMetodologia = codigoMetodologia;
    }

    public Profesor getCodigoProfesor() {
        return codigoProfesor;
    }

    public void setCodigoProfesor(Profesor codigoProfesor) {
        this.codigoProfesor = codigoProfesor;
    }

    public Examen getCodigoExamen() {
        return codigoExamen;
    }

    public void setCodigoExamen(Examen codigoExamen) {
        this.codigoExamen = codigoExamen;
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
        if (!(object instanceof Pregunta)) {
            return false;
        }
        Pregunta other = (Pregunta) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.univalle.modelo.Pregunta[ codigo=" + codigo + " ]";
    }

}
