/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.univalle.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "examen_estudiante")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ExamenEstudiante.findAll", query = "SELECT e FROM ExamenEstudiante e")
    , @NamedQuery(name = "ExamenEstudiante.findByCodigoEstudiante", query = "SELECT e FROM ExamenEstudiante e WHERE e.examenEstudiantePK.codigoEstudiante = :codigoEstudiante")
    , @NamedQuery(name = "ExamenEstudiante.findByCodigoExamen", query = "SELECT e FROM ExamenEstudiante e WHERE e.examenEstudiantePK.codigoExamen = :codigoExamen")
    , @NamedQuery(name = "ExamenEstudiante.findByNota", query = "SELECT e FROM ExamenEstudiante e WHERE e.nota = :nota")})
public class ExamenEstudiante implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ExamenEstudiantePK examenEstudiantePK;
    @Basic(optional = false)
    @Column(name = "nota")
    private float nota;
    @JoinColumn(name = "codigo_estudiante", referencedColumnName = "codigo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Estudiante estudiante;
    @JoinColumn(name = "codigo_examen", referencedColumnName = "codigo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Examen examen;

    public ExamenEstudiante() {
    }

    public ExamenEstudiante(ExamenEstudiantePK examenEstudiantePK) {
        this.examenEstudiantePK = examenEstudiantePK;
    }

    public ExamenEstudiante(ExamenEstudiantePK examenEstudiantePK, float nota) {
        this.examenEstudiantePK = examenEstudiantePK;
        this.nota = nota;
    }

    public ExamenEstudiante(long codigoEstudiante, int codigoExamen) {
        this.examenEstudiantePK = new ExamenEstudiantePK(codigoEstudiante, codigoExamen);
    }

    public ExamenEstudiantePK getExamenEstudiantePK() {
        return examenEstudiantePK;
    }

    public void setExamenEstudiantePK(ExamenEstudiantePK examenEstudiantePK) {
        this.examenEstudiantePK = examenEstudiantePK;
    }

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Examen getExamen() {
        return examen;
    }

    public void setExamen(Examen examen) {
        this.examen = examen;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (examenEstudiantePK != null ? examenEstudiantePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ExamenEstudiante)) {
            return false;
        }
        ExamenEstudiante other = (ExamenEstudiante) object;
        if ((this.examenEstudiantePK == null && other.examenEstudiantePK != null) || (this.examenEstudiantePK != null && !this.examenEstudiantePK.equals(other.examenEstudiantePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.univalle.modelo.ExamenEstudiante[ examenEstudiantePK=" + examenEstudiantePK + " ]";
    }
    
}
