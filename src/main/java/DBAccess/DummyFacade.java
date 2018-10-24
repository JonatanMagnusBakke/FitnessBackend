/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBAccess;

import java.util.ArrayList;
import java.util.List;
import models.Exercise;
import models.Workout;

/**
 *
 * @author jmb
 */
public class DummyFacade {

    private List<Workout> workouts;
    public DummyFacade() 
    {
        workouts = new ArrayList<>();
        Workout w1 = new Workout(1L, "TestWorkout", "This is a dummy workout for testing", "https://image.shutterstock.com/image-vector/stick-figure-celebration-cheer-260nw-331595411.jpg");
        w1.addExercise(new Exercise(1L, "FirstTestExercise", "This is the first test exercise", "https://image.shutterstock.com/image-vector/stick-figure-celebration-cheer-260nw-331595411.jpg"));
        w1.addExercise(new Exercise(2L, "SecondTestExercise", "This is the second test exercise", "https://image.shutterstock.com/image-vector/stick-figure-celebration-cheer-260nw-331595411.jpg"));
        w1.addExercise(new Exercise(3L, "ThirdTestExercise", "This is the third test exercise", "https://image.shutterstock.com/image-vector/stick-figure-celebration-cheer-260nw-331595411.jpg"));
        workouts.add(w1);
        workouts.add(new Workout(2L, "TestWorkout2", "This is an empty shell", "https://image.shutterstock.com/image-vector/stick-figure-celebration-cheer-260nw-331595411.jpg"));
    }

    public List<Workout> getWorkouts() {
        return workouts;
    }
    
    
    public boolean addWorkout(Workout w)
    {
        w.setId(workouts.size() + 1L);
        workouts.add(w);
        return true;
    }
    
    public void removeWorkout(long id)
    {
        Workout toBeRemoved = null;
        for(Workout w : workouts)
        {
            if(w.getId() == id)
            {
                toBeRemoved = w;
            }
        }
        if(toBeRemoved != null)
        {
            workouts.remove(toBeRemoved);
        }
        
    }
    
    public Workout getWorkout(long id)
    {
        Workout res = null;
        for(Workout w : workouts)
        {
            if(id == w.getId())
            {
                res = w;
            }
        }
        return res;
    }
}
