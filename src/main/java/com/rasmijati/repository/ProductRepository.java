/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rasmijati.repository;

import com.rasmijati.model.Product;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class ProductRepository {
    private List<Product> productList;

    public ProductRepository() {
        this.productList = new ArrayList<>();
    }
    
    public void create(Product p){
        this.productList.add(p);
    }
    
    public List<Product> allRecord(){
        return this.productList;
    }
    
    public Product recordById(Long id){
        for(Product p : productList){
            if(p.getId().equals(id))
                return p;
        }
        return null;
    }
    
    public void delete(Product p){
        this.productList.remove(p);
    }
    
    public void edit(Product p){
        this.productList.stream().filter(x->x.getId().equals(p.getId())).forEach(product -> {
            product.setTitle(p.getTitle());
            product.setDescription(p.getDescription());
            product.setKeyword(p.getKeyword());
            product.setPrice(p.getPrice());
            product.setProductCategory(p.getProductCategory());
            product.setCategory(p.getCategory());
        });
    }
}
