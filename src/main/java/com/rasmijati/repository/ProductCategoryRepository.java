/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rasmijati.repository;

import com.rasmijati.model.ProductCategory;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class ProductCategoryRepository {

    private List<ProductCategory> productCategoryList;

    public ProductCategoryRepository() {
        this.productCategoryList = new ArrayList<>();
    }

    public void create(ProductCategory p) {
        this.productCategoryList.add(p);
    }

    public List<ProductCategory> allRecord() {
        return this.productCategoryList;
    }

    public void delete(ProductCategory p) {
        this.productCategoryList.remove(p);
    }

    public ProductCategory recordById(Long id) {
        for (ProductCategory p : productCategoryList) {
            if (p.getId().equals(id)) {
                return p;
            }
        }
        return null;
    }

    public void edit(ProductCategory p){
        this.productCategoryList.stream().filter(x->x.getId().equals(p.getId())).forEach(pc -> {
            pc.setTitle(p.getTitle());
            pc.setDescription(p.getDescription());
        });
    }
}

