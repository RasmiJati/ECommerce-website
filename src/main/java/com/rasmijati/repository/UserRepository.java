/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rasmijati.repository;

import com.rasmijati.model.User;

/**
 *
 * @author admin
 */
public class UserRepository extends AbstractRepository<User>{
    
    @Override
    public void edit(User u){
        super.allRecord().stream().filter(x->x.getId().equals(u.getId())).forEach(user -> {
            user.setName(u.getName());
            user.setAddress(u.getAddress());
            user.setPhone(u.getPhone());
            user.setEmail(u.getEmail());
            user.setPassword(u.getPassword());
            user.setRepassword(u.getRepassword());
            user.setUserType(u.getUserType());
        });
    }
}
