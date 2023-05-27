/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rasmijati.controller;

import com.rasmijati.model.Category;
import com.rasmijati.repository.CategoryRepository;

/**
 *
 * @author admin
 */
public class CategoryController {

    private static CategoryRepository categoryRepository;

    public static void main(String[] args) {
        categoryRepository = new CategoryRepository();
        Category c = new Category(1L, "food", "food");
        categoryRepository.create(c);
        
        System.out.println("Records : " + categoryRepository.allRecord());
        
        System.out.println("Records by id : " + categoryRepository.recordById(1L));
       
        Category c1 = new Category(2L, "hsgdh", "hsgjd");
        categoryRepository.edit(c1);
        System.out.println("edition " + categoryRepository.allRecord());

        categoryRepository.delete(c);
        System.out.println(" Delete successfull : " + categoryRepository.allRecord());
    }
}
