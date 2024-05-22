package org.model;

public class Employee {
    private Long id;
    private String name;
    private String jobType;
    private String picture;
    private Boolean availability;

    public Employee(Long id, String name, String jobType, String picture, Boolean availability) {
        this.id = id;
        this.name = name;
        this.jobType = jobType;
        this.picture = picture;
        this.availability = availability;
    }

    public Employee() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", jobType='" + jobType + '\'' +
                ", picture='" + picture + '\'' +
                ", availability=" + availability +
                '}';
    }
}
