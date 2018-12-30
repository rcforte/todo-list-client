package com.rcforte.todolistclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(serviceId = "todo-list-service")
public interface TodoListClient {

  @RequestMapping(method = RequestMethod.GET, value = "/api/v1/todo-list/")
  List<TodoList> findAll();

  @RequestMapping(method = RequestMethod.POST, value = "/api/v1/todo-list/")
  TodoList save(TodoList todoList);
}
