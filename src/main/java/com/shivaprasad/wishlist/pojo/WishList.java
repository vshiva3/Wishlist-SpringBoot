package com.shivaprasad.wishlist.pojo;

import java.util.Date;
import java.util.UUID;

import org.springframework.format.annotation.DateTimeFormat;

import com.shivaprasad.wishlist.customconstraints.Category;

import jakarta.validation.constraints.NotBlank;

public class WishList {
    @Category(message = "Must be from list")
    private String category;
    @NotBlank(message = "Must not be blank")
    private String name;
    @NotBlank(message = "Enter amount")
    private String cost;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;
    private String id;


    public WishList() {
        this.id = UUID.randomUUID().toString();
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCost() {
        return this.cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
