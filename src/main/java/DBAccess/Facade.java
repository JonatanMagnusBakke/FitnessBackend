/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBAccess;

import com.mycompany.fitnessapp.GeneratorData;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import models.Catagory;
import models.Exercise;
import models.User;
import models.Workout;
import models.WorkoutHistory;

/**
 *
 * @author jmb
 */
public class Facade {
    EntityManagerFactory emf;
    
    public Facade(EntityManagerFactory emf){
        this.emf = emf;
//        Catagory c = new Catagory("Test Catagory");
//        //DBAccessSingleton.getInstance().createCatagory(c);
//        Workout w1 = new Workout("TestWorkout", "This is a dummy workout for testing", "https://image.shutterstock.com/image-vector/stick-figure-celebration-cheer-260nw-331595411.jpg");
//        w1.addExercise(new Exercise("FirstTestExercise", "This is the first test exercise", "https://image.shutterstock.com/image-vector/stick-figure-celebration-cheer-260nw-331595411.jpg"));
//        w1.addExercise(new Exercise("SecondTestExercise", "This is the second test exercise", "https://image.shutterstock.com/image-vector/stick-figure-celebration-cheer-260nw-331595411.jpg"));
//        w1.addExercise(new Exercise("ThirdTestExercise", "This is the third test exercise", "https://image.shutterstock.com/image-vector/stick-figure-celebration-cheer-260nw-331595411.jpg"));
//        w1.setCatagory(c);
//        createWorkout(w1);
//        System.out.println("Done");
    }
    
    private EntityManager getEntityManager(){
        return emf.createEntityManager();
    }
    
    public  void createWorkout(Workout w){
        EntityManager em = getEntityManager();
        Catagory c = em.find(Catagory.class, w.getCatagory().getCatagory());
        if(c == null)
        {
            createCatagory(w.getCatagory());
            c = em.find(Catagory.class, w.getCatagory().getCatagory());
        }
        w.setCatagory(c);
        em.getTransaction().begin();
        em.persist(w);
        em.getTransaction().commit();
    }
    
    public boolean createUser(User u)
    {
        User ref = getUserByUsername(u.getUsername());
        if(ref == null)
        {
            EntityManager em = getEntityManager();
            em.getTransaction().begin();
            em.persist(u);
            em.getTransaction().commit();
            return true;
        }
        return false;
    }
    
    public List<User> getAllUsers()
    {
        List<User> list = null;
        EntityManager em = getEntityManager();
        list = (List<User>)em.createQuery("SELECT u FROM User u").getResultList();
        return list;
    }
    
    public void addWorkoutHistoryToUser(long id, WorkoutHistory wh)
    {
        EntityManager em = getEntityManager();
        User u = em.find(User.class, id);
        em.getTransaction().begin();
        u.addWorkoutToHistory(wh);
        em.getTransaction().commit();
    }
    
    public boolean addWorkoutToFavorite(long userId, long workOutId)
    {
        EntityManager em = getEntityManager();
        User u = em.find(User.class, userId);
        if(u == null)
        {
            return false;
        }
        Workout ref = em.find(Workout.class, workOutId);
        em.getTransaction().begin();
        boolean res = u.addWorkoutToFavorite(ref);
        em.getTransaction().commit();
        return res;
    }
    
    public boolean removeWorkoutFromFavorites(long userId, long workoutId)
    {
        EntityManager em = getEntityManager();
        User u = em.find(User.class, userId);
        if(u == null)
        {
            return false;
        }
        Workout ref = em.find(Workout.class, workoutId);
        if(ref == null)
        {
            return false;
        }
        em.getTransaction().begin();
        boolean res = u.removeFromFavorites(workoutId);
        em.getTransaction().commit();
        return res;
    }
    
    public void addWorkoutHistoryToUser(String username, WorkoutHistory wh)
    {
        EntityManager em = getEntityManager();
        User u = (User)em.createQuery("SELECT u FROM User u WHERE u.username = '" + username + "'").getSingleResult();
        em.getTransaction().begin();
        u.addWorkoutToHistory(wh);
        em.getTransaction().commit();
    }
    
    public void createCatagory(Catagory c)
    {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.persist(c);
        em.getTransaction().commit();
    }
    
    public List<Workout> getAllWorkouts()
    {
        List<Workout> list = new ArrayList<Workout>();
        EntityManager em = getEntityManager();
        Query q = em.createQuery("SELECT w FROM Workout w");
        list = (List<Workout>)q.getResultList();
        return list;
    }
    
    public User getUserByUsername(String s)
    {
        User u = null;
        EntityManager em = getEntityManager();
        try{
        u = (User)em.createQuery("SELECT u FROM User u WHERE u.username = '" + s + "'").getSingleResult();
        } catch(Exception e)
        {
            return null;
        }
        return u;
    }
    
    public User login(String username, String password)
    {
        User u = getUserByUsername(username);
        if(u == null)
        {
            return null;
        }
        if(u.getPassword().equals(password))
        {
            return u;
        }
        return null;
    }
    
    public List<Catagory> getAllCatagorys()
    {
        List<Catagory> list = new ArrayList<Catagory>();
        EntityManager em = getEntityManager();
        Query q = em.createQuery("SELECT c FROM Catagory c");
        list = (List<Catagory>)q.getResultList();
        return list;
    }
    
    public Workout getWorkout(long id)
    {
        EntityManager em = getEntityManager();
        return em.find(Workout.class, id);
    }
    
    public User getUserById(long id)
    {
        EntityManager em = getEntityManager();
        return em.find(User.class, id);
    }
    
    public boolean removeWorkout(long id)
    {
        try{
            EntityManager em = getEntityManager();
        Workout d = em.find(Workout.class, id);
        em.getTransaction().begin();
        em.remove(d);
        em.getTransaction().commit();
        }
        catch(Exception e)
        {
            return false;
        }
        
        return true;
    }
    
    public boolean removeCatagory(String id)
    {
        try{
            
            EntityManager em = getEntityManager();
            List<Workout> list = new ArrayList<Workout>();
        Query q = em.createQuery("SELECT w FROM Workout w");
        list = (List<Workout>)q.getResultList();
        
        Catagory d = em.find(Catagory.class, id);
        em.getTransaction().begin();
        for(Workout wo : list)
        {
//            if(wo.getCatagory().getId() == id)
//            {
//                em.remove(wo);
//            }
            
        }
        em.remove(d);
        em.getTransaction().commit();
        }
        catch(Exception e)
        {
            return false;
        }
        
        return true;
    }
//    
//    public static void main(String[] args)
//    {
//        Persistence.generateSchema("FitnessAppPer", null);
//        System.out.println("done");
//    }
}
