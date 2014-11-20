package com.passencrypt.launcher;

import com.passencrypt.exception.CeasarEncryptException;
import com.passencrypt.types.CeasarEncrypt;

/**
 * Created by Timmy Parkwayd on 20/11/2014.
 */
public class EncryptTest {
    public static void main(String[] args) {
        CeasarEncrypt ceasarEncrypt = new CeasarEncrypt("Johnny254", 7);
        try {
            System.out.println(ceasarEncrypt.getRetour());
        } catch (CeasarEncryptException e) {
            e.printStackTrace();
        }
    }
}
