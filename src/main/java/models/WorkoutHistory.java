/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Jbakke
 */
@Entity
public class WorkoutHistory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String workoutName, timeEnded;

    public WorkoutHistory() {
    }

    public WorkoutHistory(String workoutName, String timeEnded) {
        this.workoutName = workoutName;
        this.timeEnded = timeEnded;
    }

    
    
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getWorkoutName() {
        return workoutName;
    }

    public String getTimeEnded() {
        return timeEnded;
    }

    public void setWorkoutName(String workoutName) {
        this.workoutName = workoutName;
    }

    public void setDate(String date) {
        this.timeEnded = date;
    }
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WorkoutHistory)) {
            return false;
        }
        WorkoutHistory other = (WorkoutHistory) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "WorkoutHistory{" + "id=" + id + ", workoutName=" + workoutName + ", timeEnded=" + timeEnded + '}';
    }

   
    
}
