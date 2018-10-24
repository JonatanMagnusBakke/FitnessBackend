/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBAccess;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import models.Catagory;
import models.Workout;

/**
 *
 * @author jmb
 */
public class Facade {
    EntityManagerFactory emf;
    
    public Facade(EntityManagerFactory emf){
        this.emf = emf;
    }
    
    private EntityManager getEntityManager(){
        return emf.createEntityManager();
    }
    
    public  void createWorkout(Workout w){
        EntityManager em = getEntityManager();
//        Catagory c = em.find(Catagory.class, w.getCatagory().getId());
//        w.setCatagory(c);
        em.getTransaction().begin();
        em.persist(w);
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
    
    public boolean removeCatagory(long id)
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
