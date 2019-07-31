package com.company.internship.entity;

import com.haulmont.chile.core.datatypes.impl.EnumClass;

import javax.annotation.Nullable;


public enum AdminColorScheme implements EnumClass<String> {

    DEFAULT("Default"),
    LIGHT("Light"),
    BLUE("Blue"),
    COFFEE("Coffee"),
    ECTOPLASM("Ectoplasm"),
    MIDNIGHT("Midnight"),
    OCEAN("Ocean"),
    SUNRISE("Sunrise");

    private String id;

    AdminColorScheme(String value) {
        this.id = value;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static AdminColorScheme fromId(String id) {
        for (AdminColorScheme at : AdminColorScheme.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}