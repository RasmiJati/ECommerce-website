/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rasmijati.controller;

import com.rasmijati.repository.CategoryRepository;
import com.rasmijati.repository.ProductCategoryRepository;
import com.rasmijati.repository.ProductRepository;
import com.rasmijati.repository.UserRepository;
import java.util.Scanner;

/**
 *
 * @author admin
 */
public class MainController {

    public static void main(String[] args) {

        UserController userController = new UserController();
        ProductCategoryController productCategoryController = new ProductCategoryController();
        CategoryController categoryController = new CategoryController();
        ProductController productController = new ProductController();

        UserRepository userRepository = new UserRepository();
        ProductCategoryRepository productCategoryRepository = new ProductCategoryRepository();
        CategoryRepository categoryRepository = new CategoryRepository();
        ProductRepository productRepository = new ProductRepository();
        Scanner sc = new Scanner(System.in);
        String choice;
        System.out.println("*******************");
        System.out.println("Choose Operation for");
        System.out.println("*******************");
        do {
            System.out.println("Enter 1 for User");
            System.out.println("Enter 2 for Product Category");
            System.out.println("Enter 3 for Category ");
            System.out.println("Enter 4 to Product");
            System.out.println("Enter 5 to Exit");
            choice = sc.next();
            switch (choice) {
                case "1":
                    userController.options(userRepository);
                    break;
                case "2":
                    productCategoryController.options(productCategoryRepository);
                    break;
                case "3":
                    categoryController.options(categoryRepository);
                    break;
                case "4":
                    productController.options(productRepository, productCategoryRepository, categoryRepository);
                    break;
                case "5":
                    return;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        } while (!choice.equals("0"));
    }
}
