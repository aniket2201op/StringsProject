package com.company.tasks;
import com.mongodb.client.MongoClients;
import org.bson.Document;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;

public class Connection {

    private static final String DATABASE_NAME = "WSDB";
    private static final String CONNECTION_STRING = "mongodb+srv://AniketOP:Aniket10@sample.3e78dll.mongodb.net/?retryWrites=true&w=majority";

    private static MongoClient mongoClient;
    private static MongoDatabase database;

    public static MongoDatabase getDatabase() {
        if (database == null) {
    	   
       
            mongoClient = MongoClients.create(CONNECTION_STRING);
            database = mongoClient.getDatabase(DATABASE_NAME);
        }
        return database;
    }

    public static MongoCollection<Document> getCollection(String collectionName) {
        return getDatabase().getCollection(collectionName);
    }
}


