/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBAccess;

import java.util.ArrayList;
import javax.persistence.Persistence;
import models.Exercise;
import models.Workout;

/**
 *
 * @author jmb
 */
public class DBAccessSingleton {
    private static DummyFacade dummy;
    private static Facade f;
    public static DummyFacade getDummyInstance()
    {
        if(dummy == null)
        {
            dummy = new DummyFacade();
        }
        return dummy;
    }
    
    public static Facade getInstance()
    {
        if(f == null)
        {
            f = new Facade(Persistence.createEntityManagerFactory("FitnessAppPer"));
        }
        return f;
    }
    
    
    public static void main(String[] args)
    {
        Persistence.generateSchema("FitnessAppPer", null);
        Workout w1 = new Workout("TestWorkout", "This is a dummy workout for testing", "https://image.shutterstock.com/image-vector/stick-figure-celebration-cheer-260nw-331595411.jpg");
        w1.addExercise(new Exercise("FirstTestExercise", "This is the first test exercise", "https://image.shutterstock.com/image-vector/stick-figure-celebration-cheer-260nw-331595411.jpg"));
        w1.addExercise(new Exercise("SecondTestExercise", "This is the second test exercise", "https://image.shutterstock.com/image-vector/stick-figure-celebration-cheer-260nw-331595411.jpg"));
        w1.addExercise(new Exercise("ThirdTestExercise", "This is the third test exercise", "https://image.shutterstock.com/image-vector/stick-figure-celebration-cheer-260nw-331595411.jpg"));
        DBAccessSingleton.getInstance().createWorkout(w1);
        System.out.println("Done");
    }
}
