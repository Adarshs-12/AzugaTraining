package org.example;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.sql.SQLException;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {


    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
//    @GET
//    @Produces(MediaType.TEXT_PLAIN)
//    public String getIt() {
//        return "Got it!";
//    }


    @GET
    @Path("/select")
    @Produces(MediaType.TEXT_PLAIN)
    public String get(){
        CRUD operations = new CRUD();
        return  operations.select();
    }


    @PUT
    @Path("/update/{objectID}")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.TEXT_PLAIN)
    public String update(@PathParam("objectID") int objectID , String s) {
        CRUD operations = new CRUD();
        operations.update(objectID , s);
        return "updated";
    }


    @DELETE
    @Path("/delete/{objectID}")
    @Produces(MediaType.TEXT_PLAIN)
    public String delete(@PathParam("objectID") String objectID){
        CRUD operations = new CRUD();
         return operations.delete(objectID);
//        return "deleted";
    }

    @POST
    @Path("/insert")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.TEXT_PLAIN)
    public String insert(String s) {
        CRUD operations = new CRUD();
        return operations.insert(s);
    }


}