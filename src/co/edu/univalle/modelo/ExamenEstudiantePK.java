/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.univalle.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author JHOJAN L
 */
@Embeddable
public class ExamenEstudiantePK implements Serializable {

    @Basic(optional = false)
    @Column(name = "codigo_estudiante")
    private long codigoEstudiante;
    @Basic(optional = false)
    @Column(name = "codigo_examen")
    private int codigoExamen;

    public ExamenEstudiantePK() {
    }

    public ExamenEstudiantePK(long codigoEstudiante, int codigoExamen) {
        this.codigoEstudiante = codigoEstudiante;
        this.codigoExamen = codigoExamen;
    }

    public long getCodigoEstudiante() {
        return codigoEstudiante;
    }

    public void setCodigoEstudiante(long codigoEstudiante) {
        this.codigoEstudiante = codigoEstudiante;
    }

    public int getCodigoExamen() {
        return codigoExamen;
    }

    public void setCodigoExamen(int codigoExamen) {
        this.codigoExamen = codigoExamen;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codigoEstudiante;
        hash += (int) codigoExamen;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ExamenEstudiantePK)) {
            return false;
        }
        ExamenEstudiantePK other = (ExamenEstudiantePK) object;
        if (this.codigoEstudiante != other.codigoEstudiante) {
            return false;
        }
        if (this.codigoExamen != other.codigoExamen) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.univalle.modelo.ExamenEstudiantePK[ codigoEstudiante=" + codigoEstudiante + ", codigoExamen=" + codigoExamen + " ]";
    }
    
}
