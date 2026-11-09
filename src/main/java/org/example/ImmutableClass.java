package org.example;

public final class ImmutableClass {
    private final String fullName;

    public ImmutableClass(String fullName) {
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }

    @Override
    public String toString() {
        return "ImmutableClass{" +
                "fullName='" + fullName + '\'' +
                '}';
    }
}
