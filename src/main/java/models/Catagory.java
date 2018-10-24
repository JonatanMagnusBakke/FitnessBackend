/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author jmb
 */
@Entity
public class Catagory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(unique=true)
    private String catagory;

    public Catagory() {
    }
    
    

    public Catagory(String catagory) {
        this.catagory = catagory;
    }

    public String getCatagory() {
        return catagory;
    }

    public void setCatagory(String catagory) {
        this.catagory = catagory;
    }

    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (catagory != null ? catagory.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Catagory)) {
            return false;
        }
        Catagory other = (Catagory) object;
        if ((this.catagory == null && other.catagory != null) || (this.catagory != null && !this.catagory.equals(other.catagory))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Catagory[ catagory=" + catagory + " ]";
    }
    
}
