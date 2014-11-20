package com.passencrypt.beans;

/**
 * Created by Timmy Parkwayd on 19/11/2014.
 */
public enum Encryption {
    X_CEASAR(0, "Décalage de lettres sur valeur"),
    HEBRAIC(1, "Cryptage Hébraïque"),
    RANDOM(2, "Mode aléatoire sur taille");

    private final int id;
    private final String text;

    Encryption(int id, String text) {
        this.id = id;
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }
}
