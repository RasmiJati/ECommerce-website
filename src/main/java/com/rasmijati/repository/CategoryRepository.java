/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rasmijati.repository;

import com.rasmijati.model.Category;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class CategoryRepository {
    
    private List<Category> categoryList;
    
    public CategoryRepository() {
        categoryList = new ArrayList<>();
    }
    
    public void create(Category c) {
        this.categoryList.add(c);
    }
    
    public List<Category> allRecord() {
        return this.categoryList;
    }
    
    public Category recordById(Long id) {
        for (Category c : categoryList) {
            if (c.getId().equals(id)) {
                return c;
            }
        }
        return null;
    }
    
    public void delete(Category c) {
        this.categoryList.remove(c);
    }
    
    public void edit(Category c) {
        this.categoryList.stream().filter(x -> x.getId().equals(c.getId())).forEach(category -> {
            category.setTitle(c.getTitle());
            category.setDescription(c.getDescription());
        });
    }
}
