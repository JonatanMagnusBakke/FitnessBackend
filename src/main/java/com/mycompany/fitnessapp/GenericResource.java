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
import models.Workout;

/**
 * REST Web Service
 *
 * @author jmb
 */
@Path("workouts")
public class GenericResource {
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GenericResource
     */
    public GenericResource() {
    }

    /**
     * Retrieves representation of an instance of com.mycompany.fitnessapp.GenericResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getWorkouts() {
        List<Workout> workouts = DBAccessSingleton.getInstance().getAllWorkouts();
        return Response.ok().entity(gson.toJson(workouts)).build();
    }

    /**
     * PUT method for updating or creating an instance of GenericResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
        Workout w = gson.fromJson(content, Workout.class);
        DBAccessSingleton.getInstance().createWorkout(w);
    }
    
    @Path("/{id}")
    @GET
    public Response getWorkout(@PathParam("id") long id) {
        Workout res = DBAccessSingleton.getInstance().getWorkout(id);
        if(res == null)
        {
            return Response.status(404).build();
        }
        return Response.ok().entity(gson.toJson(res)).build();
    }
    
    
    @Path("/{id}")
    @DELETE
    public Response deleteWorkout(@PathParam("id") long id) {
        boolean res = DBAccessSingleton.getInstance().removeWorkout(id);
        if(!res)
        {
            return Response.status(404).build();
        }
        return Response.ok().build();
    }
    
    @Path("/catagorys")
    @GET
    public Response getAllCatagorys()
    {
        List<Catagory> res = DBAccessSingleton.getInstance().getAllCatagorys();
        return Response.ok().entity(gson.toJson(res)).build();
    }
    
    
    @Path("/catagorys")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void addCatagory(String content) {
        Catagory w = gson.fromJson(content, Catagory.class);
        DBAccessSingleton.getInstance().createCatagory(w);
    }
    
    @Path("/catagorys/{id}")
    @DELETE
    public Response deleteCatagory(@PathParam("id") String id) {
        boolean res = DBAccessSingleton.getInstance().removeCatagory(id);
        if(!res)
        {
            return Response.status(404).build();
        }
        return Response.ok().build();
    }
    
    @Path("/generate")
    @GET
    public Response generate()
    {
        GeneratorData.generateData();
        return Response.ok().build();
    }
}
