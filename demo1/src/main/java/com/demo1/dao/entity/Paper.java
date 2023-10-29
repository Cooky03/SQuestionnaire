package com.demo1.dao.entity;

import java.util.Date;

public class Paper {
    private String id;
    private String questionnaireId;
    private String submitDate;

    private String answerSource;


    @Override
    public String toString() {
        return "Paper{" +
                "id='" + id + '\'' +
                ", questionnaireId='" + questionnaireId + '\'' +
                ", submitDate=" + submitDate +
                ", answerSource='" + answerSource + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getQuestionnaireId() {
        return questionnaireId;
    }

    public void setQuestionnaireId(String questionnaireId) {
        this.questionnaireId = questionnaireId;
    }

    public String getSubmitDate() {
        return submitDate;
    }

    public void setSubmitDate(String submitDate) {
        this.submitDate = submitDate;
    }

    public String getAnswerSource() { return answerSource; }

    public void setAnswerSource(String answerSource) { this.answerSource = answerSource; }
}
