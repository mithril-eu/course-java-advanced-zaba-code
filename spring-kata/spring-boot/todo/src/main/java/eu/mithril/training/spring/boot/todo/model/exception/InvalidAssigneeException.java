package eu.mithril.training.spring.boot.todo.model.exception;

public class InvalidAssigneeException extends RuntimeException {
    public InvalidAssigneeException(final String message, final String assignee) {
        super(String.format(message, assignee));
    }
}
