/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rasmijati.controller;

import com.rasmijati.model.Category;
import com.rasmijati.model.Product;
import com.rasmijati.model.ProductCategory;
import com.rasmijati.repository.CategoryRepository;
import com.rasmijati.repository.ProductCategoryRepository;
import com.rasmijati.repository.ProductRepository;
import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author admin
 */
public class ProductController {

    private static ProductRepository productRepository;
    private static ProductCategoryRepository productCategoryRepository;
    private static CategoryRepository categoryRepository;

    public void options(ProductRepository productRepository, ProductCategoryRepository productCategoryRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.productCategoryRepository = productCategoryRepository;
        this.categoryRepository = categoryRepository;
        Scanner sc = new Scanner(System.in);
        String choice;
        System.out.println("*******************");
        System.out.println("Product Operation");
        System.out.println("*******************");
        do {
            System.out.println("Enter 1 to create");
            System.out.println("Enter 2 to list ");
            System.out.println("Enter 3 to delete");
            System.out.println("Enter 4 to edit");
            System.out.println("Enter 5 to Exit");
            choice = sc.next();
            switch (choice) {
                case "1":
                    create();
                    break;
                case "2":
                    list();
                    break;
                case "3":
                    delete();
                    break;
                case "4":
                    edit();
                    break;
                case "5":
                    return;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        } while (!choice.equals("0"));

    }

    public static void create() {
        Long id = null;
        String title = null;
        BigDecimal price = null;
        String keyword = null;
        String description = null;
        ProductCategory productCategory = null;
        Category category = null;

        List<ProductCategory> productCategoryList = productCategoryRepository.allRecord();
        List<Category> categoryList = categoryRepository.allRecord();

        Scanner sc = new Scanner(System.in);
        while (id == null) {
            System.out.println("Enter Product  id:");
            String cid = sc.nextLine();
            try {
                id = Long.parseLong(cid);
            } catch (Exception e) {
                System.out.println("Error");
                id = null;
            }
        }
        while (title == null || title.isEmpty()) {
            System.out.println("Enter Title: ");
            title = sc.nextLine();
            break;
        }
        while (price == null) {
            System.out.println("Enter Price: ");
            title = sc.nextLine();
            break;
        }
        while (keyword == null || keyword.isEmpty()) {
            System.out.println("Enter Some Keywords: ");
            title = sc.nextLine();
            break;
        }
        while (description == null || description.isEmpty()) {
            System.out.println("Enter description: ");
            description = sc.nextLine();
            break;
        }
        while (productCategory == null) {
            System.out.println("Product Category Info : ");
            System.out.println(productCategoryList);

            Long productCategoryId = null;
            while (productCategoryId == null) {
                System.out.println("Enter Id for Product Category from list : ");
                productCategoryId = sc.nextLong();

            }
            productCategory = productCategoryRepository.recordById(productCategoryId);
        }

        while (category == null) {
            System.out.println("Category Info : ");
            System.out.println(categoryList);

            Long categoryId = null;
            while (categoryId == null) {
                System.out.println("Enter Id for Category from list : ");
                categoryId = sc.nextLong();

            }
            category = categoryRepository.recordById(categoryId);
        }
        Product product = new Product(id, title, price, keyword, description, productCategory, category);
        product.setProductCategory(productCategory);
        product.setCategory(category);
        productRepository.create(product);
        System.out.println("Creation Successfull !!!");
    }

    public static void list() {
        System.out.println("________________");
        System.out.println("Product's Info");
        System.out.println("________________");
        System.out.println();
        System.out.println("*****************************************************************************");
        productRepository.allRecord().stream().forEach(x -> System.out.println(x));
        System.out.println("*****************************************************************************");
        System.out.println();
    }

    public static void delete() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter product's Id: ");
        Long id = sc.nextLong();
        Product product = productRepository.recordById(id);
        if (product == null) {
            System.out.println("Product's ID " + id + "not found");
        } else {
            productRepository.delete(product);
            System.out.println("Product of id " + id + " deleted succesfully!!");
            list();
        }
    }

    public static void edit() {
        Long id = null;
        String title = null;
        BigDecimal price = null;
        String keyword = null;
        String description = null;

        ProductCategory productCategory = null;
        List<ProductCategory> productCategoryList = productCategoryRepository.allRecord();

        Category category = null;
        List<Category> categoryList = categoryRepository.allRecord();

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter id of product category to edit: ");
        id = sc.nextLong();
        sc.nextLine(); // Consume the newline character left in the input buffer. 
        Product product = productRepository.recordById(id);
        if (product == null) {
            System.out.println("Product Category with id: " + id + " not found");

        } else {
            while (title == null || title.isEmpty()) {
                System.out.println("Enter Title: ");
                title = sc.nextLine();
                break;
            }
            while (price == null) {
                System.out.println("Enter Price: ");
                title = sc.nextLine();
                break;
            }
            while (keyword == null || keyword.isEmpty()) {
                System.out.println("Enter Some Keywords: ");
                title = sc.nextLine();
                break;
            }
            while (description == null || description.isEmpty()) {
                System.out.println("Enter description: ");
                description = sc.nextLine();
                break;
            }
            while (productCategory == null) {
                System.out.println("Product Category Info : ");
                System.out.println(productCategoryList);

                Long productCategoryId = null;
                while (productCategoryId == null) {
                    System.out.println("Enter Id for Product Category from list : ");
                    productCategoryId = sc.nextLong();

                }
                productCategory = productCategoryRepository.recordById(productCategoryId);
            }

            while (category == null) {
                System.out.println("Category Info : ");
                System.out.println(categoryList);

                Long categoryId = null;
                while (categoryId == null) {
                    System.out.println("Enter Id for Category from list : ");
                    categoryId = sc.nextLong();

                }
                category = categoryRepository.recordById(categoryId);
            }
            Product prod = new Product(id, title, price, keyword, description, productCategory, category);
            productRepository.edit(prod);
            System.out.println("Product of id " + id + " edited succesfully!!");
        }
    }

}
