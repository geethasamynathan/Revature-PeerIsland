package com.techgenie.mongojdbc.app;

import com.techgenie.mongojdbc.config.MongoConnection;
import com.techgenie.mongojdbc.dao.ProductDao;
import com.techgenie.mongojdbc.dao.ProductDaoImpl;
import com.techgenie.mongojdbc.model.Product;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final ProductDao productDao = new ProductDaoImpl();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n========= MongoDB Java Driver Demo =========");
            System.out.println("1. Test Connection");
            System.out.println("2. View All Products");
            System.out.println("3. Find Product By Id");
            System.out.println("4. Insert Product");
            System.out.println("5. Update Product");
            System.out.println("6. Delete Product");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    productDao.testConnection();
                    break;
                case 2:
                    viewAllProducts();
                    break;
                case 3:
                    findById(scanner);
                    break;
                case 4:
                    insertProduct(scanner);
                    break;
                case 5:
                    updateProduct(scanner);
                    break;
                case 6:
                    deleteProduct(scanner);
                    break;
                case 0:
                    System.out.println("Application closed.");
                    MongoConnection.closeConnection();
                    break;
                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 0);

        scanner.close();
    }

    private static void viewAllProducts() {
        List<Product> products = productDao.findAll();
        if (products.isEmpty()) {
            System.out.println("No products found.");
        } else {
            products.forEach(System.out::println);
        }
    }

    private static void findById(Scanner scanner) {
        System.out.print("Enter product id: ");
        int id = Integer.parseInt(scanner.nextLine());

        Product product = productDao.findById(id);
        if (product == null) {
            System.out.println("Product not found.");
        } else {
            System.out.println(product);
        }
    }

    private static void insertProduct(Scanner scanner) {
        System.out.print("Enter product id: ");
        int id = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter product name: ");
        String name = scanner.nextLine();

        System.out.print("Enter price: ");
        double price = Double.parseDouble(scanner.nextLine());

        Product product = new Product(id, name, price, new Date());
        productDao.insert(product);

        System.out.println("Product inserted successfully.");
    }

    private static void updateProduct(Scanner scanner) {
        System.out.print("Enter product id to update: ");
        int id = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter new product name: ");
        String name = scanner.nextLine();

        System.out.print("Enter new price: ");
        double price = Double.parseDouble(scanner.nextLine());

        Product product = new Product(id, name, price, new Date());
        productDao.update(product);

        System.out.println("Product updated successfully.");
    }

    private static void deleteProduct(Scanner scanner) {
        System.out.print("Enter product id to delete: ");
        int id = Integer.parseInt(scanner.nextLine());

        productDao.deleteById(id);
        System.out.println("Product deleted successfully.");
    }
}
