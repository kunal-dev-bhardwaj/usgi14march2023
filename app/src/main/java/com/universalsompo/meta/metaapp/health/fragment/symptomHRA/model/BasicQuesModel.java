package com.universalsompo.meta.metaapp.health.fragment.symptomHRA.model;

public class BasicQuesModel {
    private String basic_userid, basic_username, basic_interviewid, basic_symptomid;
    private String basic_sympname;
    private String basic_init;
    private String basic_choiceid;
    private String basic_date;
    private String basic_fragment_name;

    public BasicQuesModel(String basic_userid, String basic_username, String basic_interviewid, String basic_symptomid, String basic_sympname, String basic_init, String basic_choiceid, String basic_date, String basic_fragment_name){
        this.basic_userid = basic_userid;
        this.basic_username = basic_username;
        this.basic_interviewid = basic_interviewid;
        this.basic_symptomid = basic_symptomid;
        this.basic_sympname = basic_sympname;
        this.basic_init = basic_init;
        this.basic_choiceid = basic_choiceid;
        this.basic_date = basic_date;
        this.basic_fragment_name = basic_fragment_name;
    }

    public String getbasic_userid() {
        return basic_userid;
    }

    public void setbasic_userid(String basic_userid) {
        this.basic_userid = basic_userid;
    }

    public String getbasic_username() {
        return basic_username;
    }

    public void setbasic_username(String basic_username) {
        this.basic_username = basic_username;
    }

    public String getbasic_interviewid() {
        return basic_interviewid;
    }

    public void setbasic_interviewid(String basic_interviewid) {
        this.basic_interviewid = basic_interviewid;
    }

    public String getbasic_symptomid() {
        return basic_symptomid;
    }

    public void setbasic_symptomid(String basic_symptomid) {
        this.basic_symptomid = basic_symptomid;
    }

    public String getbasic_sympname() {
        return basic_sympname;
    }

    public void setbasic_sympname(String basic_sympname) {
        this.basic_sympname = basic_sympname;
    }

    public String getbasic_init() {
        return basic_init;
    }

    public void setbasic_init(String basic_init) {
        this.basic_init = basic_init;
    }

    public String getbasic_choiceid() {
        return basic_choiceid;
    }

    public void setbasic_choiceid(String basic_choiceid) {
        this.basic_choiceid = basic_choiceid;
    }

    public String getbasicDate() {
        return basic_date;
    }

    public void setbasicDate(String basic_date) {
        this.basic_date = basic_date;
    }

    public String getbasicFragmentname() {
        return basic_fragment_name;
    }

    public void setbasicFragmentname(String basic_fragment_name) {
        this.basic_fragment_name = basic_fragment_name;
    }
}
