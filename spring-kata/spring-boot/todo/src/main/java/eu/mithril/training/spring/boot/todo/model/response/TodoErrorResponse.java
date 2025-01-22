package eu.mithril.training.spring.boot.todo.model.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "metadata",
        "issues"
})
public class TodoErrorResponse implements TodoResponse {

    private static final long serialVersionUID = -6220322296496963477L;

    @JsonProperty("metadata")
    @ApiModelProperty(notes = "Container for any metadata for this request/response")
    private Metadata metadata = new Metadata();

    @JsonProperty("issues")
    @ApiModelProperty(notes = "Container for any issues or failure messages for the request")
    private List<Issue> issues;

    public TodoErrorResponse() {
    }

    public Metadata getMetadata() {
        return metadata;
    }

    public void setMetadata(final Metadata metadata) {
        this.metadata = metadata;
    }

    public List<Issue> getIssues() {
        return issues;
    }

    public void setIssues(final List<Issue> issues) {
        this.issues = issues;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TodoErrorResponse that = (TodoErrorResponse) o;

        if (metadata != null ? !metadata.equals(that.metadata) : that.metadata != null) return false;
        return issues != null ? issues.equals(that.issues) : that.issues == null;
    }

    @Override
    public int hashCode() {
        int result = metadata != null ? metadata.hashCode() : 0;
        result = 31 * result + (issues != null ? issues.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TodoServiceResponse{");
        sb.append("metadata=").append(metadata);
        sb.append(", issues=").append(issues);
        sb.append('}');
        return sb.toString();
    }
}
