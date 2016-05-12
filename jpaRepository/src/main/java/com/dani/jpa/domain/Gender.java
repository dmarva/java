package com.dani.jpa.domain;

public enum Gender {
    MALE((byte) 1), FEMALE((byte) 2);

    private byte value;

    Gender(byte value) {
        this.value = value;
    }

    public byte getValue() {
        return value;
    }

    public void setValue(byte value) {
        this.value = value;
    }

    public static Gender translate(byte value) {
        Gender[] values = Gender.values();
        for (Gender gender : values) {
            if (gender.getValue() == value) {
                return gender;
            }
        }
        throw new IllegalArgumentException(String.format("No matching found for value: %s", value));
    }
}
