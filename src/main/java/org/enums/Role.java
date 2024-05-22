package org.enums;

public enum Role {
    ADMIN("admin"),
    CLIENT("client"),
    SUPERVISOR("supervisor");

    private final String roleName;

    Role(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleName() {
        return roleName;
    }

    @Override
    public String toString() {
        return roleName;
    }
}
