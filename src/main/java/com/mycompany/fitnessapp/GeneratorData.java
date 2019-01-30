/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.fitnessapp;

import DBAccess.DBAccessSingleton;
import models.Catagory;
import models.Exercise;
import models.Workout;

/**
 *
 * @author Jbakke
 */
public class GeneratorData {
    public static void generateData()
    {
        addArmExercise();
        addLegExercise();
        
    }
    
    static void addArmExercise()
    {
        Catagory c = new Catagory("Arms");
        //DBAccessSingleton.getInstance().createCatagory(c);
        Workout w1 = new Workout("Arm Building Workout", "A good workout for bulding biceps and triceps", "https://www.bodybuilding.com/images/2016/december/5-arm-blasting-workouts-for-mass-2-700xh.jpg");
        w1.addExercise(new Exercise("Close-Grip Barbell Bench Press", "3 sets, 4-6 reps", "https://www.bodybuilding.com/exercises/exerciseImages/sequences/23/Male/m/23_2.jpg"));
        w1.addExercise(new Exercise("Cable Rope Overhead Triceps Extension", "2 sets, 8-12 reps", "https://www.bodybuilding.com/exercises/exerciseImages/sequences/220/Male/m/220_2.jpg"));
        w1.addExercise(new Exercise("Triceps Pushdown", "2 sets, 15 reps", "https://www.bodybuilding.com/exercises/exerciseImages/sequences/343/Male/m/343_2.jpg"));
        w1.addExercise(new Exercise("Barbell Curl", "3 sets, 4-6 reps", "https://www.bodybuilding.com/exercises/exerciseImages/sequences/169/Male/m/169_1.jpg"));
        w1.addExercise(new Exercise("Dumbbell Alternate Bicep Curl", "2 sets, 8-12 reps", "https://www.bodybuilding.com/exercises/exerciseImages/sequences/234/Male/m/234_1.jpg"));
        w1.addExercise(new Exercise("Standing Biceps Cable Curl", "3 sets, 15 reps", "https://www.bodybuilding.com/exercises/exerciseImages/sequences/131/Male/m/131_2.jpg"));
        w1.setCatagory(c);
        DBAccessSingleton.getInstance().createWorkout(w1);
        System.out.println("Added arms");
    }
    
    static void addLegExercise()
    {
        
        Catagory c = new Catagory("Legs");
        //DBAccessSingleton.getInstance().createCatagory(c);
        Workout w1 = new Workout("Leg Building Workout", "A good workout to get big legs", "https://www.bodybuilding.com/images/2016/june/5-leg-workouts-for-mass-header-v2-830x467.jpg");
        w1.addExercise(new Exercise("Barbell Squat", "4 sets, 4-6 reps", "https://www.bodybuilding.com/exercises/exerciseImages/sequences/3861/Male/m/3861_2.jpg"));
        w1.addExercise(new Exercise("Dumbbell Lunges", "4 sets, 12 reps each leg", "https://www.bodybuilding.com/exercises/exerciseImages/sequences/32/Male/m/32_2.jpg"));
        w1.addExercise(new Exercise("Leg Press", "3 sets, 12-15 reps", "https://www.bodybuilding.com/exercises/exerciseImages/sequences/57/Male/m/57_1.jpg"));
        w1.addExercise(new Exercise("Lying Leg Curls", "3 sets, 12 reps", "https://www.bodybuilding.com/exercises/exerciseImages/sequences/52/Male/m/52_2.jpg"));
        w1.addExercise(new Exercise("Leg Extensions", "3 sets, 20 reps", "https://www.bodybuilding.com/exercises/exerciseImages/sequences/53/Male/m/53_2.jpg"));
        w1.addExercise(new Exercise("Standing Calf Raises", "4 sets, 12 reps", "https://www.bodybuilding.com/exercises/exerciseImages/sequences/48/Male/m/48_2.jpg"));
        w1.setCatagory(c);
        DBAccessSingleton.getInstance().createWorkout(w1);
        System.out.println("Added legs");
    }
}
