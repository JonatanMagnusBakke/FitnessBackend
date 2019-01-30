/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBAccess;

import com.mycompany.fitnessapp.GeneratorData;
import java.util.ArrayList;
import javax.persistence.Persistence;
import models.Catagory;
import models.Exercise;
import models.User;
import models.Workout;
import models.WorkoutHistory;

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
        GeneratorData.generateData();
    }
}
