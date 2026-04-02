package com.techgenie.mongojdbc.dao;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.techgenie.mongojdbc.config.MongoConnection;
import com.techgenie.mongojdbc.model.Product;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements  ProductDao{

    private final MongoCollection<Document> collection;

    public ProductDaoImpl(){
        MongoDatabase database= MongoConnection.getDatabase();
        collection=database.getCollection("products");
    }
    @Override
    public void testConnection() {
        try{
            long count=collection.countDocuments();
            System.out.println("Connected successfully to Mongodb");
            System.out.println(" Total Document in products collection  : " +count);
        }catch(Exception e){
            System.out.println("Connection Failed");
            e.printStackTrace();
        }

    }

    @Override
    public List<Product> findAll() {
        List<Product> products = new ArrayList<>();

        for (Document doc : collection.find()) {
            Product product = new Product();
            product.setId(doc.getInteger("_id", 0));
            product.setProductName(doc.getString("productname"));
            product.setPrice(doc.get("price") != null ? ((Number) doc.get("price")).doubleValue() : 0.0);
            product.setReleaseDate(doc.getDate("releaseDate"));
            products.add(product);
        }

        return products;
    }

    @Override
    public Product findById(int id) {
      Document doc= collection.find(Filters.eq("_id",id)).first();
      if(doc==null)
      {
          return null;
      }
        Product product = new Product();
        product.setId(doc.getInteger("_id", 0));
        product.setProductName(doc.getString("productname"));
        product.setPrice(doc.get("price") != null ? ((Number) doc.get("price")).doubleValue() : 0.0);
        product.setReleaseDate(doc.getDate("releaseDate"));
        return product;
    }

    @Override
    public void insert(Product product) {
    Document doc=new Document("_id",product.getId())
            .append("productname",product.getProductName())
            .append("price",product.getPrice())
            .append("releaseDate",product.getReleaseDate());
    collection.insertOne(doc);
    }

    @Override
    public void update(Product product) {
collection.updateOne(
        Filters.eq("_id",product.getId()),
        Updates.combine(
                Updates.set("productname",product.getProductName()),
                Updates.set("price",product.getPrice()),
                Updates.set("releaseDate",product.getReleaseDate())
        )
);
    }

    @Override
    public void deleteById(int id) {
    collection.deleteOne(Filters.eq("_id",id));
    }
}
