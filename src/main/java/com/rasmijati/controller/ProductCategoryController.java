/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rasmijati.controller;

import com.rasmijati.model.ProductCategory;
import com.rasmijati.repository.ProductCategoryRepository;
import java.util.Scanner;

/**
 *
 * @author admin
 */
public class ProductCategoryController {

    private static ProductCategoryRepository productCategoryRepository;

    public void options(ProductCategoryRepository productCategoryRepository){
        this.productCategoryRepository = productCategoryRepository;
        Scanner sc = new Scanner(System.in);
        String choice;
        System.out.println("*******************");
        System.out.println("Product Category Operation");
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
        String description = null;
        Scanner sc = new Scanner(System.in);
        while (id == null) {
            System.out.println("Enter Product Category id:");
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
        while (description == null || description.isEmpty()) {
            System.out.println("Enter description: ");
            description = sc.nextLine();
            break;
        }
        ProductCategory pc = new ProductCategory(id, title, description);
        productCategoryRepository.create(pc);
        System.out.println("Creation Successfull!!");
    }

    public static void list() {
        System.out.println("________________");
        System.out.println("Product Category's Info");
        System.out.println("________________");
        System.out.println();
        System.out.println("*****************************************************************************");
        productCategoryRepository.allRecord().stream().forEach(x -> System.out.println(x));
        System.out.println("*****************************************************************************");
        System.out.println();
    }

    public static void delete() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter product category's Id: ");
        Long id = sc.nextLong();
        ProductCategory pc = productCategoryRepository.recordById(id);
        if (pc == null) {
            System.out.println("Product Category's ID " + id + " not found");
        } else {
            productCategoryRepository.delete(pc);
            System.out.println("Product Category of id " + id + " deleted succesfully!!");
            list();
        }
    }

    public static void edit() {
        Long id = null;
        String title = null;
        String description = null;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter id of product category to edit: ");
        id = sc.nextLong();
        sc.nextLine(); // Consume the newline character left in the input buffer. 
        ProductCategory p = productCategoryRepository.recordById(id);
        if (p == null) {
            System.out.println("Product Category with id: " + id + " not found");

        } else {
            while (title == null || title.isEmpty()) {
                System.out.println("Enter Title: ");
                title = sc.nextLine();
                break;
            }
            while (description == null || description.isEmpty()) {
                System.out.println("Enter description: ");
                description = sc.nextLine();
//                sc.next()--> reads a single word until the next space 
//                sc.nextLine() to read the entire line
                break;
            }
            ProductCategory pc = new ProductCategory(id, title, description);
            productCategoryRepository.edit(pc);
            System.out.println("Product Category of id " + id + " edited succesfully!!");
        }
    }

}
