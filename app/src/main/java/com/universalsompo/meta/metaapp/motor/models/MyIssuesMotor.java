package com.universalsompo.meta.metaapp.motor.models;

public class MyIssuesMotor {
    private String Category;
    private String Comment;
    private String IssueDate;
    private String IssueID;
    private String IssueStatus;

    public MyIssuesMotor(String category, String comment, String issueDate, String issueID, String issueStatus)
    {
        Category = category;
        Comment = comment;
        IssueDate = issueDate;
        IssueID = issueID;
        IssueStatus = issueStatus;
    }

    public String getCategory() {
        return Category;
    }

    public String getComment() {
        return Comment;
    }

    public String getIssueDate() {
        return IssueDate;
    }

    public String getIssueID() {
        return IssueID;
    }

    public String getIssueStatus() {
        return IssueStatus;
    }
}
