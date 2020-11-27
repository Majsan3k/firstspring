package com.example.firstspring.controllers;

import com.example.firstspring.models.TodoItem;
import com.example.firstspring.models.TodoItemUpdate;
import com.example.firstspring.services.TodoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/todoList")
public class TodoListController {

    @Autowired
    TodoListService todoListService;

    @GetMapping("/getTodolist")
    public ArrayList<TodoItem> getTodolist(HttpServletResponse response){
        return todoListService.getTodoList();
    }

    @GetMapping("/addTodo")
    public ModelAndView addItem(TodoItem todoItem){
        return new ModelAndView("createTodo").addObject("todoItem", todoItem);
    }

    @PostMapping("/addTodoForm")
    public String addTodoFromForm(TodoItem todoItem){
        todoListService.addTodoItem(todoItem);
        return "The todo \""  + todoItem.getName() + "\" is added to the list";
    }

    @PostMapping("/addTodo")
    public String addTodo(@RequestBody TodoItem todoItem){
        todoListService.addTodoItem(todoItem);
        return "The todo \""  + todoItem.getName() + "\" is added to the list";
    }

    @RequestMapping(value = "/deleteTodo/{id}", method= DELETE)
    public String deleteTodo(@PathVariable int id){

        boolean removed = todoListService.removeItem(id);

        if(removed) {
            return "The todo with id " + id + " was deleted";
        }else{
            return "There is no todo with id " + id;
        }
    }

    @PutMapping("/update/{id}")
    public String updateTodo(@PathVariable int id, @RequestBody TodoItemUpdate todoItemUpdate){
        boolean updated = todoListService.updateItem(id, todoItemUpdate);

        if(updated) {
            return "Your element is updated!";
        }else{
            return "There is no todo with id " + id;
        }
    }
}
