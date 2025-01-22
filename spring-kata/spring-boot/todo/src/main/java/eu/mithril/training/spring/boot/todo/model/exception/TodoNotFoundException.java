package eu.mithril.training.spring.boot.todo.model.exception;

public class TodoNotFoundException extends RuntimeException {
    public TodoNotFoundException(final String message, final Long todoId) {
        super(String.format(message, todoId));
    }
}
