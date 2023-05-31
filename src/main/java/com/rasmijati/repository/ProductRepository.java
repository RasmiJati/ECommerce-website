/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rasmijati.repository;

import com.rasmijati.model.Product;

/**
 *
 * @author admin
 */
public class ProductRepository extends AbstractRepository<Product>{

    @Override
    public void edit(Product p){
        super.allRecord().stream().filter(x->x.getId().equals(p.getId())).forEach(product -> {
            product.setTitle(p.getTitle());
            product.setDescription(p.getDescription());
            product.setKeyword(p.getKeyword());
            product.setPrice(p.getPrice());
            product.setProductCategory(p.getProductCategory());
            product.setCategory(p.getCategory());
        });
    }
}
