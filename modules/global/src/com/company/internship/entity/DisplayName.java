package com.company.internship.entity;

import com.haulmont.chile.core.datatypes.impl.EnumClass;

import javax.annotation.Nullable;


public enum DisplayName implements EnumClass<String> {

    NICKNAME("nickname"),
    USERNAME("username");

    private String id;

    DisplayName(String value) {
        this.id = value;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static DisplayName fromId(String id) {
        for (DisplayName at : DisplayName.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}