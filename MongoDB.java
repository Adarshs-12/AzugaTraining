package org.example;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import org.bson.Document;

import java.util.Iterator;

public class MongoDB {

    public static void main(String[] args) {

        // Creating a Mongo client
        MongoClient mongo = null;
        try {

            mongo = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
            System.out.println("Created Mongo Connection successfully");

            MongoDatabase db = mongo.getDatabase("School");
            System.out.println("Get database is successful");

            //creating collection or get collection if exists.
            MongoCollection<Document> collection = db.getCollection("student");
            System.out.println("collection created ");

            //Inserting sample records by creating documents.
            Document doc =new Document("name","abc");
            doc.append("id",101);
            doc.append("marks",100);
            doc.append("subject", "Programming");
            collection.insertOne(doc);
            System.out.println("Insert is completed");

            Document doc2 =new Document("name","bcd");
            doc2.append("id",102);
            doc2.append("marks",24);
            doc2.append("subject", "Maths");
            collection.insertOne(doc2); System.out.println("Insert is completed");


            //Listing All Mongo Documents in Collection
            FindIterable<Document> iterDoc = collection.find();
            int i = 1;
            // Getting the iterator
            System.out.println("Listing All Mongo Documents");
            Iterator it = iterDoc.iterator();
            while (it.hasNext()) {
                System.out.println(it.next());
                i++;
            }
            //specific document retrieving in a collection
            BasicDBObject searchQuery = new BasicDBObject();
            searchQuery.put("name", "abc");
            System.out.println("Retrieving specific Mongo Document");
            MongoCursor<Document> cursor = collection.find(searchQuery).iterator();
            while (cursor.hasNext()) {
                System.out.println(cursor.next());
            }


            collection.updateOne(Filters.eq("name", "abc"), Updates.set("subject", "Coding"));
            System.out.println("Document updated successfully...");
            int j = 1;
            Iterator<Document> itrNew = iterDoc.iterator();
            System.out.println("Document after update");
            while (itrNew.hasNext()) {
                System.out.println(itrNew.next()); j++;
            }


             collection.deleteOne(Filters.eq("name", "abc"));
             System.out.println("Document deleted successfully");

             int k = 1;
             Iterator<Document> itrNew2 = iterDoc.iterator();
             while (itrNew2.hasNext()) {
                 System.out.println(itrNew2.next());
                 k++;
             }


//             Dropping a Collection
            collection.drop();
            System.out.println("Collection dropped successfully");


        } catch (Exception e) {
            System.out.println("error" + e.getMessage());
        }

    }
}