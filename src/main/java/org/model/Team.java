package org.model;

public class Team extends Employee{
    private Integer number;

    public Team(Long id, String name, String jobType, String picture, Boolean availability, Integer number) {
        super(id, name, jobType, picture, availability);
        this.number = number;
    }

    public Team(Integer number) {
        super();
        this.number = number;
    }

    public Team() {
        super();
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Team{" +
                "number=" + number +
                '}';
    }
}
