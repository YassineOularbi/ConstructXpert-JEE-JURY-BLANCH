package org.enums;

public enum Status {
    TODO("ToDo"),
    IN_PROGRESS("InProgress"),
    COMPLETED("Completed");

    private final String statusName;

    Status(String statusName) {
        this.statusName = statusName;
    }

    public String getStatusName() {
        return statusName;
    }

    @Override
    public String toString() {
        return statusName;
    }
}

