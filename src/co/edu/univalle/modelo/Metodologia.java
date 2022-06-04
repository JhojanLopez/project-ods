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
@Table(name = "metodologia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Metodologia.findAll", query = "SELECT m FROM Metodologia m")
    , @NamedQuery(name = "Metodologia.findByCodigo", query = "SELECT m FROM Metodologia m WHERE m.codigo = :codigo")
    , @NamedQuery(name = "Metodologia.findByTipo", query = "SELECT m FROM Metodologia m WHERE m.tipo = :tipo")})
public class Metodologia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo")
    private Integer codigo;
    @Basic(optional = false)
    @Column(name = "tipo")
    private String tipo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoMetodologia")
    private Collection<Pregunta> preguntaCollection;

    public Metodologia() {
    }

    public Metodologia(Integer codigo) {
        this.codigo = codigo;
    }

    public Metodologia(Integer codigo, String tipo) {
        this.codigo = codigo;
        this.tipo = tipo;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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
        if (!(object instanceof Metodologia)) {
            return false;
        }
        Metodologia other = (Metodologia) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.univalle.modelo.Metodologia[ codigo=" + codigo + " ]";
    }
    
}
