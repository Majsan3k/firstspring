package com.example.firstspring.services;

import com.example.firstspring.models.TodoItem;
import com.example.firstspring.models.TodoItemUpdate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;

@Component
public class TodoListService {

    private ArrayList<TodoItem> todoList = new ArrayList<>();

    public TodoListService() {
        todoList.add(new TodoItem("Be a spring pro", "Just do it, I know you can", new Date(2018 - 11 - 10)));
    }

    public ArrayList<TodoItem> getTodoList() {
        return todoList;
    }

    public void addTodoItem(TodoItem newItem) {
        todoList.add(newItem);
    }

    public boolean removeItem(int id) {
        return todoList.removeIf((TodoItem item) -> item.getId() == id);
    }

    public boolean updateItem(int id, TodoItemUpdate todoItemUpdate) {
        for(TodoItem todoItem : todoList){
            if(todoItem.getId() == id){
                todoItem.setDescription(todoItemUpdate.getDescription());
                todoItem.setName(todoItemUpdate.getName());
                todoItem.setDueDate(todoItemUpdate.getDueDate());
                return true;
            }
        }

        return false;
    }
}
