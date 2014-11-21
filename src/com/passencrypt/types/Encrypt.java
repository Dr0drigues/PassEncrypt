package com.passencrypt.types;

import com.passencrypt.exception.EncryptException;

/**
 * Created by Timmy Parkwayd on 20/11/2014.
 */
public abstract class Encrypt {
    private String passwd;

    private String retour;

    public Encrypt(String passwd) {
        this.passwd = passwd;
    }

    public Encrypt() {
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getRetour() throws EncryptException {
        return encrypt();
    }

    public abstract String encrypt() throws EncryptException;

}
