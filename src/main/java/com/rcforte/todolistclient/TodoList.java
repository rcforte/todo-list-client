package com.rcforte.todolistclient;

import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TodoList {

  private String id;
  private String name;

  private List<TodoListItem> items = Lists.newArrayList();
}
