package com.demo1.dao.entity;

import java.util.Date;

public class TemplateEntity {
    private String id;
    private String tempName;
    private Date creationTime;
    private String authorId;
    private String typeId;
    private int questionCount;
    private String status;

    @Override
    public String toString() {
        return "TemplateEntity{" +
                "id='" + id + '\'' +
                ", tempName='" + tempName + '\'' +
                ", creationTime=" + creationTime +
                ", authorId='" + authorId + '\'' +
                ", typeId='" + typeId + '\'' +
                ", questionCount=" + questionCount +
                ", status='" + status + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTempName() {
        return tempName;
    }

    public void setTempName(String tempName) {
        this.tempName = tempName;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public int getQuestionCount() {
        return questionCount;
    }

    public void setQuestionCount(int questionCount) {
        this.questionCount = questionCount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
