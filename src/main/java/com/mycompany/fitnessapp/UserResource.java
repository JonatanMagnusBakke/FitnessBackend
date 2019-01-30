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
import models.Errormessage;
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
    @Produces(MediaType.APPLICATION_JSON)
    public String putJson(String content) {
        User u = gson.fromJson(content, User.class);
        boolean res = DBAccessSingleton.getInstance().createUser(u);
        if(res == false)
        {
            return gson.toJson(new Errormessage(true));
        }
        
        
        return gson.toJson(new Errormessage(false));
    }
    
    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getUser(@PathParam("id") long id) {
        User res = DBAccessSingleton.getInstance().getUserById(id);
        if(res == null)
        {
            return gson.toJson(new Errormessage(true));
        }
        return gson.toJson(res);
    }
    
    @Path("/{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addHistory(String content, @PathParam("id") long id) {
        WorkoutHistory wh = gson.fromJson(content, WorkoutHistory.class);
        DBAccessSingleton.getInstance().addWorkoutHistoryToUser(id, wh);
        return Response.ok().build();
    }
    
    
    @Path("/{id}/favorites/{id2}")
    @GET
    public String getUserFavorites(@PathParam("id") long id, @PathParam("id2") long id2)
    {
        boolean res = DBAccessSingleton.getInstance().addWorkoutToFavorite(id, id2);
        if(res)
        {
            return gson.toJson(new Errormessage(false));
        }
        return gson.toJson(new Errormessage(true));
        
    }
    
    @Path("/{id}/removefavorites/{id2}")
    @GET
    public String removeUserFavorites(@PathParam("id") long id, @PathParam("id2") long id2)
    {
        boolean res = DBAccessSingleton.getInstance().removeWorkoutFromFavorites(id, id2);
        if(res)
        {
            return gson.toJson(new Errormessage(false));
        }
        return gson.toJson(new Errormessage(true));
        
    }
    
    @Path("/login")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String login(String content)
    {
        User u = gson.fromJson(content, User.class);
        User res = DBAccessSingleton.getInstance().login(u.getUsername(), u.getPassword());
        if(res == null)
        {
            return gson.toJson(new Errormessage(true));
        }
        
        String person = gson.toJson(res);
        return person;
    }
    @Path("/register")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String addUser(String content) {
        User u = gson.fromJson(content, User.class);
        boolean res = DBAccessSingleton.getInstance().createUser(u);
        if(res == false)
        {
            return gson.toJson(new Errormessage(true));
        }
        
        
        return gson.toJson(new Errormessage(false));
    }
}
