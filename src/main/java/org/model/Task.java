package org.model;


import org.enums.Priority;
import org.enums.Status;

import java.sql.Date;

public class Task {
    private Long id;
    private String title;
    private String type;
    private Date start_date;
    private Date end_date;
    private Priority priority;
    private Status status;

    public Task(Long id, String title, String type, Date start_date, Date end_date, Priority priority, Status status) {
        this.id = id;
        this.title = title;
        this.type = type;
        this.start_date = start_date;
        this.end_date = end_date;
        this.priority = priority;
        this.status = status;
    }

    public Task() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", type='" + type + '\'' +
                ", start_date=" + start_date +
                ", end_date=" + end_date +
                ", priority=" + priority +
                ", status=" + status +
                '}';
    }
}
