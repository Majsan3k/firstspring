package com.example.firstspring.models;

import java.util.Date;

public class TodoItemUpdate {

    private int id;
    private String name;
    private String description;
    private Date dueDate;

    public TodoItemUpdate(){
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

    public void setId(int id) {
        this.id = id;
    }
}
