package com.SEP.BusinessManagementSystem.Entity;

import javax.persistence.*;

@Entity
@Table
public class HRApplication {
    @Id
    @SequenceGenerator(name="HRApplication_Sequence", sequenceName = "HRApplication_Sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "HRApplication_Sequence")
    private Long id;
    private String requestingDept;
    private String jobTitle;
    private String commentFromHR;

    public HRApplication() {
    }

    public HRApplication(String requestingDept, String jobTitle, String commentFromHR) {
        this.requestingDept = requestingDept;
        this.jobTitle = jobTitle;
        this.commentFromHR = commentFromHR;
    }

    public HRApplication(Long id, String requestingDept, String jobTitle, String commentFromHR) {
        this.id = id;
        this.requestingDept = requestingDept;
        this.jobTitle = jobTitle;
        this.commentFromHR = commentFromHR;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRequestingDept() {
        return requestingDept;
    }

    public void setRequestingDept(String requestingDept) {
        this.requestingDept = requestingDept;
    }


    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getCommentFromHR() {
        return commentFromHR;
    }

    public void setCommentFromHR(String commentFromHR) {
        this.commentFromHR = commentFromHR;
    }

    @Override
    public String toString() {
        return "HRApplication{" +
                "id=" + id +
                ", requestingDept='" + requestingDept + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                ", commentFromHR='" + commentFromHR + '\'' +
                '}';
    }
}
