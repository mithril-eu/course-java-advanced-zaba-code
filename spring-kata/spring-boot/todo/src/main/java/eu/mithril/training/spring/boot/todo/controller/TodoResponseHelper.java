package eu.mithril.training.spring.boot.todo.controller;


import eu.mithril.training.spring.boot.todo.model.response.Metadata;
import eu.mithril.training.spring.boot.todo.model.response.Status;
import org.springframework.http.HttpStatus;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;
import java.util.UUID;

public class TodoResponseHelper {

    // Helper methods.
    Status createSuccessStatus() {
        Status status = new Status();
        status.setSuccess(true);
        status.setStatusCode(HttpStatus.OK.getReasonPhrase());
        return status;
    }

    Status createFailureStatus(String message, String statusCode) {
        Status status = new Status();
        status.setSuccess(false);
        status.setStatusCode(statusCode);
        status.setStatusDescription(message);
        return status;
    }

    void updateMetadata(Metadata metadata) {
    }

    Metadata createRequestMetadata(HttpServletRequest request) {
        Metadata metadata = new Metadata();
        metadata.setRequestId(UUID.randomUUID().toString());
        metadata.setRequestTimestamp("" + Instant.now().toEpochMilli());
        metadata.setServiceName("Todo Service");
        metadata.setServiceVersion("1.0");
        metadata.setResponseId(UUID.randomUUID().toString());
        metadata.setResponseTimestamp("" + Instant.now().toEpochMilli());
        return metadata;
    }

}
