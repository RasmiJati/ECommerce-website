/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rasmijati.repository;

import com.rasmijati.model.Category;
/**
 *
 * @author admin
 */
public class CategoryRepository extends AbstractRepository<Category> {

    @Override
    public void edit(Category c) {
        super.allRecord().stream().filter(x -> x.getId().equals(c.getId())).forEach(category -> {
            category.setTitle(c.getTitle());
            category.setDescription(c.getDescription());
        });
    }
}
