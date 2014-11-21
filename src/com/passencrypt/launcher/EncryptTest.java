package com.passencrypt.launcher;

import com.passencrypt.types.CeasarEncrypt;
import com.passencrypt.types.HebraicEncrypt;
import com.passencrypt.types.RandomEncrypt;

/**
 * Created by Timmy Parkwayd on 20/11/2014.
 */
public class EncryptTest {
    public static void main(String[] args) {
        CeasarEncrypt ceasarEncrypt = new CeasarEncrypt("Johnny254", 7);
        HebraicEncrypt hebraicEncrypt = new HebraicEncrypt("Johnny254");
        RandomEncrypt randomEncrypt = new RandomEncrypt(8);
        try {
            System.out.println(ceasarEncrypt.getRetour());
            System.out.println(hebraicEncrypt.getRetour());
            System.out.println(randomEncrypt.getRetour());
        } catch (com.passencrypt.exception.EncryptException e) {
            e.printStackTrace();
        }
    }
}
