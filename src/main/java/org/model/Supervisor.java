package org.model;

public class Supervisor extends Employee{

    public Supervisor(Long id, String name, String jobType, String picture, Boolean availability) {
        super(id, name, jobType, picture, availability);
    }

    public Supervisor() {
        super();
    }
}
