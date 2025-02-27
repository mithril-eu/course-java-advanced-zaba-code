package eu.mithril.training.spring.boot.todo.service;

import eu.mithril.training.spring.boot.todo.TodoConstants;
import eu.mithril.training.spring.boot.todo.dao.TodoRepository;
import eu.mithril.training.spring.boot.todo.model.Todo;
import eu.mithril.training.spring.boot.todo.model.exception.InvalidAssigneeException;
import eu.mithril.training.spring.boot.todo.model.exception.InvalidIdException;
import eu.mithril.training.spring.boot.todo.model.exception.TodoNotFoundException;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoServiceImpl implements TodoService {

    private TodoRepository todoRepository;

    @Autowired
    public TodoServiceImpl(final TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public Todo saveTodo(final Todo todo) {

        Todo todo1 = todoRepository.save(todo);
        return todo1;
    }

    @Override
    public Todo getTodo(final String todoId) {

        validateId(todoId);

        Long id = NumberUtils.createLong(todoId);

        Optional<Todo> optionalTodo = todoRepository.findById(id);

        return optionalTodo.orElse(null);
    }

    @Override
    public List<Todo> getAllTodos(final Boolean includeInactive) {
        boolean includeInactiveFlag = BooleanUtils.toBooleanDefaultIfNull(includeInactive, false);

        if (includeInactiveFlag) {
            return todoRepository.findAll();
        } else {
            return todoRepository.findByActiveFlagTrue();
        }
    }

    @Override
    public List<Todo> getTodosByAssignee(final String assignee) {

        validateAssignee(assignee);

        return todoRepository.findByAssignee(assignee);
    }

    @Override
    public Todo updateTodo(final String todoId, final Todo todo) {

        validateId(todoId);

        Long id = NumberUtils.createLong(todoId);
        validateIdExists(id);

        return todoRepository.saveAndFlush(todo);
    }

    @Override
    public Todo deleteTodo(final String todoId) {

        validateId(todoId);

        Long id = NumberUtils.createLong(todoId);
        validateIdExists(id);

        Optional<Todo> optionalTodo = todoRepository.findById(id);

        if (optionalTodo.isPresent()) {
            Todo todo = optionalTodo.get();
            // Override the delete and simply set the active flag to false (soft-delete)
            todo.setActiveFlag(false);
            return todoRepository.save(todo);
        }

        return null;
    }

    // Validations
    private void validateId(final String todoId) {

        if (!NumberUtils.isDigits(todoId)) {
            throw new InvalidIdException(TodoConstants.INVALID_ID_MESSAGE, todoId);
        }
    }

    private void validateAssignee(final String assignee) {

        if (StringUtils.isBlank(assignee)) {
            throw new InvalidAssigneeException(TodoConstants.INVALID_NULL_ASSIGNEE_MESSAGE, assignee);
        }

        if ((assignee.length() < 6) || (assignee.length() > 7)) {
            throw new InvalidAssigneeException(TodoConstants.INVALID_ASSIGNEE_LENGTH_MESSAGE, assignee);
        }
    }

    private void validateIdExists(final Long id) {

        Optional<Todo> optionalTodo = todoRepository.findById(id);
        if (optionalTodo.isEmpty()) {
            throw new TodoNotFoundException(TodoConstants.TODO_NOT_FOUND_EXCEPTION, id);
        }
    }

}
