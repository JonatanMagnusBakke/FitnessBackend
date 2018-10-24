package models;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import models.Exercise;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-24T11:25:26")
@StaticMetamodel(Workout.class)
public class Workout_ { 

    public static volatile SingularAttribute<Workout, String> image;
    public static volatile ListAttribute<Workout, Exercise> exercises;
    public static volatile SingularAttribute<Workout, String> name;
    public static volatile SingularAttribute<Workout, String> description;
    public static volatile SingularAttribute<Workout, Long> id;

}