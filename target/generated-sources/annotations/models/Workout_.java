package models;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import models.Catagory;
import models.Exercise;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-01-28T18:55:53")
@StaticMetamodel(Workout.class)
public class Workout_ { 

    public static volatile SingularAttribute<Workout, Catagory> catagory;
    public static volatile SingularAttribute<Workout, String> image;
    public static volatile ListAttribute<Workout, Exercise> exercises;
    public static volatile SingularAttribute<Workout, String> name;
    public static volatile SingularAttribute<Workout, String> description;
    public static volatile SingularAttribute<Workout, Long> id;

}