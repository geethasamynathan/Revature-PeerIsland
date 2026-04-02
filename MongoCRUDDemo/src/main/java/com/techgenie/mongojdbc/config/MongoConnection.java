package com.techgenie.mongojdbc.config;

import  com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;


public class MongoConnection {
    private static final String CONNECTION_STRING="mongodb://localhost:27017";
    private static  final String DATABASE_NAME="peersdb";

    private  static MongoClient mongoClient;
    public MongoConnection(){}

    public static MongoDatabase getDatabase(){
        if(mongoClient==null){
            mongoClient= MongoClients.create(CONNECTION_STRING);
        }
        return mongoClient.getDatabase(DATABASE_NAME);

    }

    public static void closeConnection(){
        if(mongoClient!=null) {
            mongoClient.close();
        }

    }
}
