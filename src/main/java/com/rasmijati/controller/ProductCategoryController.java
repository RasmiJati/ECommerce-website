/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rasmijati.controller;

import com.rasmijati.model.ProductCategory;
import com.rasmijati.repository.ProductCategoryRepository;

/**
 *
 * @author admin
 */
public class ProductCategoryController {

    private static ProductCategoryRepository productCategoryRepository;

    public static void main(String[] args) {
        productCategoryRepository = new ProductCategoryRepository();
        ProductCategory pc = new ProductCategory(1L, "abc", "food");
        productCategoryRepository.create(pc);
        System.out.println("Creation Successful");
        
        System.out.println("Display" + productCategoryRepository.allRecord());
       
        productCategoryRepository.delete(pc);        
        System.out.println("Deletion Successful!!: ");
        System.out.println("Display" + productCategoryRepository.allRecord());

    }
}