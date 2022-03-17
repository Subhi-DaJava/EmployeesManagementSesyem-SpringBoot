package net.javaguides.springboot.backed.model;

import lombok.Data;

import javax.persistence.*;
//Générer automatiquement la table employees dans la base de donné EMS
@Data
@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    //Column annotation
    @Column(name = "first_name",nullable = false)
    private String firsName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;
}
