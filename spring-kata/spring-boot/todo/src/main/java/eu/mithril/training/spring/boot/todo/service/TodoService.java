package eu.mithril.training.spring.boot.todo.service;

import java.util.List;

import eu.mithril.training.spring.boot.todo.model.Todo;

public interface TodoService {

    Todo saveTodo(Todo todo);

    Todo getTodo(String todoId);

    List<Todo> getAllTodos(Boolean includeInactiveFlag);

    List<Todo> getTodosByAssignee(String assignee);

    Todo updateTodo(String todoId, Todo todo);

    Todo deleteTodo(String todoId);
}
