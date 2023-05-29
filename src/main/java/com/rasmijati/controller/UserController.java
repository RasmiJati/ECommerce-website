/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rasmijati.controller;

import com.rasmijati.model.User;
import com.rasmijati.model.UserType;
import com.rasmijati.repository.UserRepository;
import java.util.Scanner;

/**
 *
 * @author admin
 */
public class UserController {

    private static UserRepository userRepository;

    public void options(UserRepository userRepository) {
        this.userRepository = userRepository;
        Scanner sc = new Scanner(System.in);
        String choice;
        System.out.println("*******************");
        System.out.println("User Operation");
        System.out.println("*******************");
        do {
            System.out.println("Enter 1 to create");
            System.out.println("Enter 2 to list ");
            System.out.println("Enter 3 to delete");
            System.out.println("Enter 4 to edit");
            System.out.println("Enter 5 to Exit");
            choice = sc.next();
            switch (choice) {
                case "1":
                    create();
                    break;
                case "2":
                    list();
                    break;
                case "3":
                    delete();
                    break;
                case "4":
                    edit();
                    break;
                case "5":
                    return;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        } while (!choice.equals("0"));

    }

    public static void create() {
        Long id = null;
        String name = null;
        String address = null;
        String phone = null;
        String email = null;
        String password = null;
        String repassword = null;
        UserType userType = null;
        Scanner sc = new Scanner(System.in);
        while (id == null) {
            System.out.println("Enter user id:");
            String cid = sc.nextLine();
            try {
                id = Long.parseLong(cid);
            } catch (Exception e) {
                System.out.println("Error");
                id = null;
            }
        }
        while (name == null || name.isEmpty()) {
            System.out.println("Enter name: ");
            name = sc.nextLine();
            break;
        }
        while (address == null || address.isEmpty()) {
            System.out.println("Enter address :  ");
            address = sc.nextLine();
            break;
        }
        while (phone == null || phone.isEmpty()) {
            System.out.println("Enter phone: ");
            phone = sc.nextLine();
            break;
        }
        while (email == null || email.isEmpty()) {
            System.out.println("Enter email :  ");
            email = sc.nextLine();
            break;
        }
        while (password == null || password.isEmpty()) {
            System.out.println("Enter password :  ");
            password = sc.nextLine();
            break;
        }
        while (repassword == null || repassword.isEmpty()) {
            System.out.println("Enter Confirm Password: ");
            repassword = sc.nextLine();
            break;
        }
        while (userType == null) {
            System.out.println("Enter user type: ");
            String input = sc.nextLine().toUpperCase();

            try {
                userType = UserType.valueOf(input);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid user type. Please try again.");
            }
        }

        System.out.println("Selected user type: " + userType);

        User user = new User(id, name, address, phone, email, password, repassword, userType);
        userRepository.create(user);
        System.out.println("Creation Successfull !!!");
    }

    public static void list() {
        System.out.println("________________");
        System.out.println("User's Info");
        System.out.println("________________");
        System.out.println();
        System.out.println("*****************************************************************************");
        userRepository.allRecord().stream().forEach(x -> System.out.println(x));
        System.out.println("*****************************************************************************");
        System.out.println();
    }

    public static void delete() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter user's Id: ");
        Long id = sc.nextLong();
        User user = userRepository.recordById(id);
        if (user == null) {
            System.out.println("User's ID " + id + " not found");
        } else {
            userRepository.delete(user);
            System.out.println("Category of id " + id + " deleted succesfully!!");
            list();
        }
    }

    public static void edit() {
        Long id = null;
        String name = null;
        String address = null;
        String phone = null;
        String email = null;
        String password = null;
        String repassword = null;
        UserType userType = null;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter id of user to edit: ");
        id = sc.nextLong();
        sc.nextLine();
        User user = userRepository.recordById(id);
        if (user == null) {
            System.out.println("User with id: " + id + " not found");

        } else {
            while (name == null || name.isEmpty()) {
                System.out.println("Enter name: ");
                name = sc.nextLine();
                break;
            }
            while (address == null || address.isEmpty()) {
                System.out.println("Enter address :  ");
                address = sc.nextLine();
                break;
            }
            while (phone == null || phone.isEmpty()) {
                System.out.println("Enter phone: ");
                phone = sc.nextLine();
                break;
            }
            while (email == null || email.isEmpty()) {
                System.out.println("Enter email :  ");
                email = sc.nextLine();
                break;
            }
            while (password == null || password.isEmpty()) {
                System.out.println("Enter password :  ");
                password = sc.nextLine();
                break;
            }
            while (repassword == null || repassword.isEmpty()) {
                System.out.println("Enter Confirm Password: ");
                repassword = sc.nextLine();
                break;
            }
            while (userType == null) {
                System.out.println("Enter user type: ");
                String input = sc.nextLine().toUpperCase();

                try {
                    userType = UserType.valueOf(input);
                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid user type. Please try again.");
                }
            }

            System.out.println("Selected user type: " + userType);
            User usr = new User(id, name, address, phone, email, password, repassword, userType);
            userRepository.edit(usr);
            System.out.println("Edited Successfully!");
        }
    }
}
