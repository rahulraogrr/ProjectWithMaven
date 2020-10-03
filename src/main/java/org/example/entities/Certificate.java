package org.example.entities;

import javax.persistence.Embeddable;

@Embeddable
public class Certificate {

    private String course;
    private String duration;

    public Certificate(String course, String duration) {
        this.course = course;
        this.duration = duration;
    }

    public Certificate() {
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
}
