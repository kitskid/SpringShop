package com.example.securityapplication.models;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "provider")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Provider {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotEmpty(message = "Имя не может быть пустым")
    @Size(min = 5, max = 100, message = "Имя должно быть от 5 и до 100 символов")
    @Column(name = "login")
    private String login;
    @NotEmpty(message = "Email не может быть пустой")
    @Column(name = "email")
    private String email;
    @Column(name = "phone")
    private String phone;
    @NotEmpty(message = "Пароль не может быть пустым")
    @Size(min = 5, max = 100, message = "Пароль должен быть от 5 и до 100 символов")
    @Column(name = "password")
    private String password;

    @Column(name = "role")
    private String role;

    @Column(name = "filename")
    private String fileName;
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "provider")
    private List<Product> products = new ArrayList<>();



    public Provider() {
    }

    public Provider(String login, String email, String phone, String password, String role, String fileName) {
        this.login = login;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.role = role;
        this.fileName = fileName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}

