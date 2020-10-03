package org.example.onetoone;

import javax.persistence.*;

@Entity
public class Question {
    @Id
    @Column(name = "question_id")
    private int questionId;
    private String question;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fKey_answer_id")
    private Answer answer;

    public Question(int questionId, String question, Answer answer) {
        this.questionId = questionId;
        this.question = question;
        this.answer = answer;
    }

    public Question() {
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }
}
