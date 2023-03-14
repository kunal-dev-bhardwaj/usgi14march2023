package com.universalsompo.meta.metaapp.health.fragment.myissues.model;

public class MyIssuesStatus {
    private String Comment;
    private String IssueCommentDate;
    private String IssueStatus;

    public MyIssuesStatus(String comment, String issueCommentDate, String issueStatus)
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
