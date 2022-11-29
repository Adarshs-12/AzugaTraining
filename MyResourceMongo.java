package org.example;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("myresource1")
public class MyResourceMongo {
//
    @GET
    @Path("/select")
    @Produces(MediaType.TEXT_PLAIN)
    public String get(){
        MongoCRUD operations = new MongoCRUD();
        return operations.FindOne();
    }


    @PUT
    @Path("/update")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.TEXT_PLAIN)
    public String update(String s) {
        MongoCRUD operations = new MongoCRUD();
        operations.UpdateOne(s);
        System.out.println("update");
        return "updated";
    }


    @DELETE
    @Path("/delete/{objectID}")
    @Produces(MediaType.TEXT_PLAIN)
    public String delete(@PathParam("objectID") String objectID){
        MongoCRUD operations = new MongoCRUD();
        return operations.DeleteOne(Integer.parseInt(objectID));
    }

    @POST
    @Path("/insert")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.TEXT_PLAIN)
    public String insert(String s) {
        MongoCRUD operations = new MongoCRUD();

        return operations.InsertOne(s);
    }




}
