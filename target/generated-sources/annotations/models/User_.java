package models;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import models.WorkoutHistory;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-01-13T19:24:30")
@StaticMetamodel(User.class)
public class User_ { 

    public static volatile SingularAttribute<User, String> firstName;
    public static volatile SingularAttribute<User, String> lastName;
    public static volatile SingularAttribute<User, String> password;
    public static volatile SingularAttribute<User, Long> id;
    public static volatile ListAttribute<User, WorkoutHistory> workoutHistory;
    public static volatile SingularAttribute<User, String> username;

}