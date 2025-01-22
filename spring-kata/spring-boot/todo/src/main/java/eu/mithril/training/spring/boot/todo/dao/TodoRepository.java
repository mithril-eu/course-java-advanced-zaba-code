package eu.mithril.training.spring.boot.todo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import eu.mithril.training.spring.boot.todo.model.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long> {

    List<Todo> findByAssignee(String assignee);

    List<Todo> findByActiveFlagTrue();

    List<Todo> findByActiveFlagTrueAndAssignee(String assignee);

    // See: http://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.query-creation
    Optional<List<Todo>> findByNotesContaining(String value);

    @Query(value = "SELECT t FROM Todo t WHERE t.notes LIKE %:value% ")
    Optional<List<Todo>> findCustomNotes(@Param("value") String value);

}
