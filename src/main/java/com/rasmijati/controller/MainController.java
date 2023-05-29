/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rasmijati.controller;

import com.rasmijati.repository.CategoryRepository;
import com.rasmijati.repository.ProductCategoryRepository;
import com.rasmijati.repository.ProductRepository;
import java.util.Scanner;

/**
 *
 * @author admin
 */
public class MainController {

    public static void main(String[] args) {

        ProductCategoryController productCategoryController = new ProductCategoryController();
        CategoryController categoryController = new CategoryController();
        ProductController productController = new ProductController();

        ProductCategoryRepository productCategoryRepository = new ProductCategoryRepository();
        CategoryRepository categoryRepository = new CategoryRepository();
        ProductRepository productRepository = new ProductRepository();
        Scanner sc = new Scanner(System.in);
        String choice;
        System.out.println("*******************");
        System.out.println("Choose Operation for");
        System.out.println("*******************");
        do {
            System.out.println("Enter 1 for Product Category");
            System.out.println("Enter 2 for Category ");
            System.out.println("Enter 3 to Product");
            System.out.println("Enter 4 to Exit");
            choice = sc.next();
            switch (choice) {
                case "1":
                    productCategoryController.options(productCategoryRepository);
                    break;
                case "2":
                    categoryController.options(categoryRepository);
                    break;
                case "3":
                    productController.options(productRepository, productCategoryRepository, categoryRepository);
                    break;
                case "4":
                    return;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        } while (!choice.equals("0"));
    }
}
