package com.example.firstspring.models;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class TodoItem {

    private static int countId = 1;
    private int id;
    private String name;
    private String description;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dueDate;

    public TodoItem(){
        this.id = countId++;
    }

    public TodoItem(String name, String description, Date dueDate){
        this.name = name;
        this.description = description;
        this.dueDate = dueDate;
        this.id = countId++;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public int getId(){
        return id;
    }
}
