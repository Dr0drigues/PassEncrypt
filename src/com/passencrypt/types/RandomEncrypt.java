package com.passencrypt.types;

import com.passencrypt.exception.EncryptException;

/**
 * Created by Timmy Parkwayd on 21/11/2014.
 */
public class RandomEncrypt extends Encrypt {

    private int length;

    public RandomEncrypt(int length) {
        super();
        setLength(length);
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public String encrypt() throws EncryptException {
        int flag = 0;
        String retour = "";
        int size = getLength();
        boolean isOK = false;
        int min = 0, max;

        while (!isOK) {
            size--;
            max = 3;
            flag = (int) (Math.random() * (max - min));
            switch (flag) {
                case 0: // Number
                    max = 10;
                    retour += (int) (Math.random() * (max - min));
                    break;
                case 1: // Upper
                    max = 26;
                    retour += (char) ((int) (Math.random() * (max - min)) + 65);
                    break;
                case 2: // Lower
                    max = 26;
                    retour += (char) ((int) (Math.random() * (max - min)) + 97);
                    break;
            }
            isOK = (size == 0);
        }

        return retour;
    }
}
