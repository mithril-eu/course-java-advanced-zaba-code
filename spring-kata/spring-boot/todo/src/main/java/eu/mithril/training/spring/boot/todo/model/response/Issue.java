package eu.mithril.training.spring.boot.todo.model.response;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "issueCode",
        "issueMessage"
})
public class Issue implements Serializable {

    private static final long serialVersionUID = -1999991689883562777L;

    @JsonProperty("issueCode")
    @ApiModelProperty(notes = "The issue code associated with this issue message.")
    private String issueCode;

    @JsonProperty("issueMessage")
    @ApiModelProperty(notes = "The issue code message.")
    private String issueMessage;

    public Issue() {
    }

    public String getIssueCode() {
        return issueCode;
    }

    public void setIssueCode(final String issueCode) {
        this.issueCode = issueCode;
    }

    public String getIssueMessage() {
        return issueMessage;
    }

    public void setIssueMessage(final String issueMessage) {
        this.issueMessage = issueMessage;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Issue issue = (Issue) o;

        if (issueCode != null ? !issueCode.equals(issue.issueCode) : issue.issueCode != null) return false;
        return issueMessage != null ? issueMessage.equals(issue.issueMessage) : issue.issueMessage == null;
    }

    @Override
    public int hashCode() {
        int result = issueCode != null ? issueCode.hashCode() : 0;
        result = 31 * result + (issueMessage != null ? issueMessage.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Issue{");
        sb.append("issueCode='").append(issueCode).append('\'');
        sb.append(", issueMessage='").append(issueMessage).append('\'');
        sb.append('}');
        return sb.toString();
    }
}

