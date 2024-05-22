package org.enums;

public enum Priority {
    HIGH("High"),
    MEDIUM("Medium"),
    LOW("Low");

    private final String PriorityName;

    Priority(String PriorityName) {
        this.PriorityName = PriorityName;
    }

    public String getPriorityName() {
        return PriorityName;
    }

    @Override
    public String toString() {
        return PriorityName;
    }
}
