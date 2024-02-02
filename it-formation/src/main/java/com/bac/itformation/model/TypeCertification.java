package com.bac.itformation.model;

public enum TypeCertification {

    DIPLOME("Diplome"),
    CERTIFICATION("Certification"),
    RIEN(" --- ");

    private String type;

    TypeCertification(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
