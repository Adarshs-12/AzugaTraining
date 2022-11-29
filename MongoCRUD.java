package org.example;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoException;
import com.mongodb.client.*;
import com.mongodb.client.model.UpdateOptions;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.apache.log4j.Logger;

import org.json.JSONObject;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Projections.exclude;

//
public class MongoCRUD {
//
    final Logger log = Logger.getLogger(MongoCRUD.class);
    public String FindOne() {

        String uri = "mongodb://localhost:27017";
        try (MongoClient mongoClient = MongoClients.create(uri))  {
            log.info("connecting to the MongoDB database using :" +uri);

            MongoDatabase database = mongoClient.getDatabase("museumDB");


            MongoCollection<Document> collection = database.getCollection("museum");
            log.info("museum collection created in Database successfully");

            FindIterable<Document> iterDoc = collection.find();

            StringBuilder read=new StringBuilder("[");

            System.out.println("Listing All Mongo Documents");

            for (Document document : iterDoc) {
                document.remove("_id");
                read.append(document.toJson()).append(",");
            }
            read.replace(read.length()-1,read.length(),"");
            read.append("]");

            log.debug("Data from museumDB is :" + read);

            return read.toString();
        } catch (MongoException e) {
            log.error("MongoException : " + e.getMessage() );

        }
        return  null;
    }


    public String InsertOne(String s) {
        String uri = "mongodb://localhost:27017";
        try (MongoClient mongoClient = MongoClients.create(uri)) {
            log.info("connecting to the database");

            MongoDatabase database = mongoClient.getDatabase("museumDB");

            log.info("collection created successfully");
            MongoCollection<Document> collection = database.getCollection("museum");

            log.debug(Document.parse(s));
            collection.insertOne(Document.parse(s));

            return "Data inserted in Database";
        }

        catch (MongoException e) {
            log.error("MongoException : " + e.getMessage() );
        }

//        return "{\'messgae\': \'Duplicate Entries\'}";
        return null;

    }

    public void UpdateOne(String s) {

        String uri = "mongodb://localhost:27017";
        try (MongoClient mongoClient = MongoClients.create(uri)) {
            log.info("connecting to the database");

            MongoDatabase database = mongoClient.getDatabase("museumDB");

            log.info("collection created successfully");
            MongoCollection<Document> collection = database.getCollection("museum");
            JSONObject jsonObject=new JSONObject(s);
            Document query = new Document().append("objectID", Integer.parseInt(String.valueOf(jsonObject.get("objectID"))) );

            Bson updates = Updates.combine(
                    Updates.set("objectID",Integer.parseInt(String.valueOf(jsonObject.get("objectID")))),
                    Updates.set("isHighlight", jsonObject.get("isHighlight")),
                    Updates.set("accessionNumber",jsonObject.get("accessionNumber")),
                    Updates.set("accessionYear", jsonObject.get("accessionYear")),
                    Updates.set("isPublicDomain", jsonObject.get("isPublicDomain")));


            UpdateOptions options = new UpdateOptions().upsert(true);
            try {
                UpdateResult result = collection.updateOne(query, updates, options);
                log.debug("Modified document: " + result.getModifiedCount());
                System.out.println("Upserted id: " + result.getUpsertedId());
            } catch (MongoException e) {
                log.error("MongoException : " + e.getMessage() );
            }
        }
    }

    public String DeleteOne(int ObjectID) {

        String uri = "mongodb://localhost:27017";
        try (MongoClient mongoClient = MongoClients.create(uri)) {
            log.info("connecting to the database");

            MongoDatabase database = mongoClient.getDatabase("museumDB");

            log.info("collection created successfully");
            MongoCollection<Document> collection = database.getCollection("museum");
            Bson query = eq("objectID", ObjectID);
            try {
                DeleteResult result = collection.deleteOne(query);
                log.info("Delete data from collection");
                System.out.println("Deleted document count: " + result.getDeletedCount());
                return "Deleted";
            } catch (MongoException e) {
                log.error("MongoException : " + e.getMessage() );            }
        }

//        return "{\'messgae\': \'Data is not present\'}";
        return null;
    }


}
