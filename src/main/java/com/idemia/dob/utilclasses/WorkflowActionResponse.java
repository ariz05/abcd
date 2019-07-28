package com.idemia.dob.utilclasses;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.idemia.dob.utils.WorkflowActionsEnum;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "workflowAction",
        "workflowResponse",
        "responseStatus"
})
public class WorkflowActionResponse {

    public WorkflowActionsEnum getWorkflowAction() {
        return workflowAction;
    }

    public void setWorkflowAction(WorkflowActionsEnum workflowAction) {
        this.workflowAction = workflowAction;
    }

    public List<WorkflowActionResponseBody> getWorkflowResponse() {
        return workflowResponse;
    }

    public void setWorkflowResponse(List<WorkflowActionResponseBody> workflowResponse) {
        this.workflowResponse = workflowResponse;
    }

    public String getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(String responseStatus) {
        this.responseStatus = responseStatus;
    }

    @JsonProperty("workflowAction")
    private WorkflowActionsEnum workflowAction;

    @JsonProperty("workflowResponse")
    private List<WorkflowActionResponseBody> workflowResponse;
    @JsonProperty("responseStatus")
    private String responseStatus;

    @Override public String toString() {
        return "WorkflowActionResponse{" + "workflowAction=" + workflowAction
                + ", workflowResponse=" + workflowResponse + ", responseStatus='" + responseStatus
                + '\'' + '}';
    }
}
