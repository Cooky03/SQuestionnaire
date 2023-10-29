package com.demo1.dao.entity;

public class TempQuestionEntity {
    private String id;
    private String tempId;
    private String questionType;
    private String questionTitle;
    private String questionOrder;
    private String questionNum;

    @Override
    public String toString() {
        return "TempQuestionEntity{" +
                "id='" + id + '\'' +
                ", tempId='" + tempId + '\'' +
                ", questionType='" + questionType + '\'' +
                ", questionTitle='" + questionTitle + '\'' +
                ", questionOrder='" + questionOrder + '\'' +
                ", questionNum='" + questionNum + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTempId() {
        return tempId;
    }

    public void setTempId(String tempId) {
        this.tempId = tempId;
    }

    public String getQuestionType() {
        return questionType;
    }

    public void setQuestionType(String questionType) {
        this.questionType = questionType;
    }

    public String getQuestionTitle() {
        return questionTitle;
    }

    public void setQuestionTitle(String questionTitle) {
        this.questionTitle = questionTitle;
    }

    public String getQuestionOrder() {
        return questionOrder;
    }

    public void setQuestionOrder(String questionOrder) {
        this.questionOrder = questionOrder;
    }

    public String getQuestionNum() {
        return questionNum;
    }

    public void setQuestionNum(String questionNum) {
        this.questionNum = questionNum;
    }
}
