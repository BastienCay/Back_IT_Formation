package com.bac.itformation.model;

public enum TypeDeCompte {

    Users_Normal('u'),
    Admin('a'),
    Formateur('f');

    private char lettreTypeDeCompte;

    TypeDeCompte(char lettreTypeDeCompte) {
        this.lettreTypeDeCompte = lettreTypeDeCompte;
    }

    public char getLettreTypeDeCompte() {
        return lettreTypeDeCompte;
    }
}
