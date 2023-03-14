package com.universalsompo.meta.metaapp.motor.models;

public class MyIssuesMotorStatus {
    private String Comment;
    private String IssueCommentDate;
    private String IssueStatus;

    public MyIssuesMotorStatus(String comment, String issueCommentDate, String issueStatus)
    {
        Comment = comment;
        IssueCommentDate = issueCommentDate;
        IssueStatus = issueStatus;
    }

    public String getComment() {
        return Comment;
    }

    public String getIssueCommentDate() {
        return IssueCommentDate;
    }

    public String getIssueStatus() {
        return IssueStatus;
    }
}
