/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rasmijati.controller;

import com.rasmijati.model.Category;
import com.rasmijati.model.Product;
import com.rasmijati.model.ProductCategory;
import com.rasmijati.repository.ProductRepository;
import java.math.BigDecimal;

/**
 *
 * @author admin
 */
public class ProductController {
    private static ProductRepository productRepository;
    
    public static void main(String[] args) {
        productRepository =  new ProductRepository();
        ProductCategory pc = new ProductCategory(1L, "moisturizer", "cream");
        Category c = new Category(2L, "sdhgshd", "sjdjd");
        Product p = new Product(1L, "vlcc", new BigDecimal(1000) , "moisturizer", "moisdhj", pc , c);
        productRepository.create(p);
        System.out.println("Record " + productRepository.allRecord());
        System.out.println("?By id : "  +  productRepository.recordById(1L));
        productRepository.delete(p);
        System.out.println("deletion success : " + productRepository.allRecord());
    }
}
