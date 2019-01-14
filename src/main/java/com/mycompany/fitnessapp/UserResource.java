/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.fitnessapp;

import DBAccess.DBAccessSingleton;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import models.Catagory;
import models.User;
import models.Workout;
import models.WorkoutHistory;

/**
 * REST Web Service
 *
 * @author jmb
 */
@Path("users")
public class UserResource {
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GenericResource
     */
    public UserResource() {
    }

    /**
     * Retrieves representation of an instance of com.mycompany.fitnessapp.GenericResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getWorkouts() {
        List<User> workouts = DBAccessSingleton.getInstance().getAllUsers();
        return Response.ok().entity(gson.toJson(workouts)).build();
    }

    /**
     * PUT method for updating or creating an instance of GenericResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response putJson(String content) {
        User u = gson.fromJson(content, User.class);
        try{
            DBAccessSingleton.getInstance().createUser(u);
        }
        catch(Exception e)
        {
            return Response.serverError().build();
        }
        return Response.ok().build();
    }
    
    @Path("/{id}")
    @GET
    public Response getUser(@PathParam("id") long id) {
        User res = DBAccessSingleton.getInstance().getUserById(id);
        if(res == null)
        {
            return Response.status(404).build();
        }
        return Response.ok().entity(gson.toJson(res)).build();
    }
    
    @Path("/{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addHistory(String content, @PathParam("id") long id) {
        WorkoutHistory wh = gson.fromJson(content, WorkoutHistory.class);
        DBAccessSingleton.getInstance().addWorkoutHistoryToUser(id, wh);
        return Response.ok().build();
    }
    
}
