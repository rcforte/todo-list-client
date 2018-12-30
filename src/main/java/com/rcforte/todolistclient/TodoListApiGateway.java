package com.rcforte.todolistclient;

import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/todo-list/")
@Log
public class TodoListApiGateway {

  private final TodoListClient todoListClient;

  public TodoListApiGateway(TodoListClient todoListClient) {
    this.todoListClient = todoListClient;
  }

  @GetMapping
  public List<TodoList> findAll() {
    return todoListClient.findAll();
  }

  @PostMapping
  public TodoList save(@RequestBody  TodoList todoList) {
    log.info("save: " + todoList);
    return todoListClient.save(todoList);
  }

  @GetMapping("/gateway/")
  public List<Map<String, String>> gateway() {
    // get todo lists
    // get todo lists items
    // make big object and return it to client
    return null;
  }
}
