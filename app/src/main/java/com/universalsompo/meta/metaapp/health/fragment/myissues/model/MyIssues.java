package com.universalsompo.meta.metaapp.health.fragment.myissues.model;

public class MyIssues {
    private String Category;
    private String Comment;
    private String IssueDate;
    private String IssueID;
    private String IssueStatus;

    public MyIssues(String category, String comment, String issueDate, String issueID, String issueStatus)
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
