/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rasmijati.repository;

import com.rasmijati.model.User;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class UserRepository {
    private List<User> userList;

    public UserRepository() {
        this.userList = new ArrayList<>();
    }
    
    public void create(User u){
        this.userList.add(u);
    }
    
    public List<User> allRecord(){
        return this.userList;
    }
    
    public User recordById(Long id){
        for(User u : userList){
            if(u.getId().equals(id)){
                return u;
            }
        }
        return null;
    }
    
    public void delete(User u){
        this.userList.remove(u);
    }
    
    public void edit(User u){
        this.userList.stream().filter(x->x.getId().equals(u.getId())).forEach(user -> {
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
