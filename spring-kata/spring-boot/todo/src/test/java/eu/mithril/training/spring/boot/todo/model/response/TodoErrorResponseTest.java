package eu.mithril.training.spring.boot.todo.model.response;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class TodoErrorResponseTest {

    private TodoErrorResponse todoErrorResponse1;
    private TodoErrorResponse todoErrorResponse2;
    private TodoErrorResponse todoErrorResponse3;
    private TodoErrorResponse todoErrorResponse4;

    @BeforeEach
    public void setUp() throws Exception {

        Issue issue1 = new Issue();
        issue1.setIssueCode("IssueCode");
        issue1.setIssueMessage("IssueMessage");

        Metadata metadata1 = new Metadata();
        metadata1.setDescription("Description");
        metadata1.setRequestId("requestId");
        metadata1.setRequestTimestamp("requestTimestamp");
        metadata1.setResponseId("responseId");
        metadata1.setResponseTimestamp("responseTimestamp");
        metadata1.setServiceName("serviceName");
        metadata1.setServiceVersion("serviceVersion");
        metadata1.setStatus(null);

        todoErrorResponse1 = new TodoErrorResponse();
        todoErrorResponse1.setIssues(Collections.singletonList(issue1));

        todoErrorResponse2 = new TodoErrorResponse();
        todoErrorResponse2.setIssues(Collections.singletonList(issue1));

        todoErrorResponse3 = new TodoErrorResponse();
        todoErrorResponse3.setMetadata(metadata1);

        todoErrorResponse4 = new TodoErrorResponse();
    }

    @Test
    public void testEquals() {

        assertEquals(
                todoErrorResponse1,
                todoErrorResponse2,
                "TodoErrorResponse1 and TodoErrorResponse2 " +
                        "should be equal");

        assertNotEquals(
                todoErrorResponse1,
                todoErrorResponse3,
                "TodoErrorResponse1 and TodoErrorResponse3 " +
                        "should not be equal");

        assertNotEquals(
                todoErrorResponse1,
                todoErrorResponse4,
                "TodoErrorResponse1 and TodoErrorResponse3 " +
                        "should not be equal");
    }

    @Test
    public void testHashCode() {

        assertEquals(
                todoErrorResponse1.hashCode(),
                todoErrorResponse2.hashCode(),
                "TodoErrorResponse1 and TodoErrorResponse2 " +
                        "should have the same hashCode");

        assertNotEquals(
                todoErrorResponse1.hashCode(),
                todoErrorResponse3.hashCode(),
                "TodoErrorResponse1 and TodoErrorResponse3 " +
                        "should not have the same hashCode");

        assertNotEquals(
                todoErrorResponse1.hashCode(),
                todoErrorResponse4.hashCode(),
                "TodoErrorResponse1 and TodoErrorResponse3 " +
                        "should not have the same hashCode");
    }

    @Test
    public void testToString() {

        assertEquals(
                todoErrorResponse1.toString(),
                todoErrorResponse2.toString(),
                "TodoErrorResponse1 and TodoErrorResponse2 " +
                        "should have the same toString");

        assertNotEquals(
                todoErrorResponse1.toString(),
                todoErrorResponse3.toString(),
                "TodoErrorResponse1 and TodoErrorResponse3 " +
                        "should not have the same toString");

        assertNotEquals(
                todoErrorResponse1.toString(),
                todoErrorResponse4.toString(),
                "TodoErrorResponse1 and TodoErrorResponse3 " +
                        "should not have the same toString");
    }
}