/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rasmijati.repository;

import com.rasmijati.model.ProductCategory;
/**
 *
 * @author admin
 */
public class ProductCategoryRepository extends AbstractRepository<ProductCategory>{
    
    @Override
    public void edit(ProductCategory p){
        super.allRecord().stream().filter(x->x.getId().equals(p.getId())).forEach(pc -> {
            pc.setTitle(p.getTitle());
            pc.setDescription(p.getDescription());
        });
    }
}

