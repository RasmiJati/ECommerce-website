/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rasmijati.controller;

import com.rasmijati.model.User;
import com.rasmijati.model.UserType;
import com.rasmijati.repository.UserRepository;

/**
 *
 * @author admin
 */
public class UserController {

    private static UserRepository userRepository;

    public static void main(String[] args) {
        userRepository = new UserRepository();
        User u = new User(1L, "rasmi", "dfdf", "9852634178","rasmi@gmail.com", "rasmi", "rasmi", UserType.USER);
        userRepository.create(u);
        System.out.println("User list : " + userRepository.allRecord());
        User u1 = new User(1L, "admin","addih","9585255555", "admin@gmail.com", "admin", "admin", UserType.ADMIN);
        userRepository.edit(u1);
        System.out.println("User list edit : " + userRepository.allRecord());
        System.out.println("By id : " + userRepository.recordById(1L));

        userRepository.delete(u);
        System.out.println("Delteion" + userRepository.allRecord());

    }
}
