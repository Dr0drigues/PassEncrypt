package com.passencrypt.types;

import com.passencrypt.exception.CeasarEncryptException;
import com.passencrypt.exception.EncryptException;

import java.util.ArrayList;

/**
 * Created by Dimitri RODRIGUES-OLIVEIRA on 19/11/2014.
 */
public class CeasarEncrypt extends Encrypt {

    private int decalage;
    private ArrayList<Character> minTable;
    private ArrayList<Character> majTable;
    private ArrayList<Character> nmbTable;

    public CeasarEncrypt(String passwd, int decalage) {
        super(passwd);
        this.decalage = decalage;
        initTables();
        try {
            getRetour();
        } catch (EncryptException e) {
            e.printStackTrace();
        }
    }

    public int getDecalage() {
        return decalage;
    }

    public void setDecalage(int decalage) {
        this.decalage = decalage;
    }

    public ArrayList<Character> getMinTable() {
        return minTable;
    }

    public void setMinTable(ArrayList<Character> minTable) {
        this.minTable = minTable;
    }

    public ArrayList<Character> getMajTable() {
        return majTable;
    }

    public void setMajTable(ArrayList<Character> majTable) {
        this.majTable = majTable;
    }

    public ArrayList<Character> getNmbTable() {
        return nmbTable;
    }

    public void setNmbTable(ArrayList<Character> nmbTable) {
        this.nmbTable = nmbTable;
    }

    private void initTables() {
        nmbTable = new ArrayList<Character>() {{
            add('0');
            add('1');
            add('2');
            add('3');
            add('4');
            add('5');
            add('6');
            add('7');
            add('8');
            add('9');
        }};
        minTable = new ArrayList<Character>() {{
            add('a');
            add('b');
            add('c');
            add('d');
            add('e');
            add('f');
            add('g');
            add('h');
            add('i');
            add('j');
            add('k');
            add('l');
            add('m');
            add('n');
            add('o');
            add('p');
            add('q');
            add('r');
            add('s');
            add('t');
            add('u');
            add('v');
            add('w');
            add('x');
            add('y');
            add('z');
        }};
        majTable = new ArrayList<Character>() {{
            add('A');
            add('B');
            add('C');
            add('D');
            add('E');
            add('F');
            add('G');
            add('H');
            add('I');
            add('J');
            add('K');
            add('L');
            add('M');
            add('N');
            add('O');
            add('P');
            add('Q');
            add('R');
            add('S');
            add('T');
            add('U');
            add('V');
            add('W');
            add('X');
            add('Y');
            add('Z');
        }};
    }

    public String encrypt() throws CeasarEncryptException {
        String toEncrypt = getPasswd();
        int decalage = getDecalage() + 1;
        String toReturn = "";

        for (Character c : toEncrypt.toCharArray()) {
            int length;
            int i;
            int actual;
            int index;

            if (getMinTable().contains(c)) {
                index = getMinTable().indexOf(c);
                length = getMinTable().size();
                actual = index + decalage;
                i = (actual > length) ? ((actual - length) - 1) : (actual - 1);
                toReturn += getMinTable().get(i);
            } else if (getMajTable().contains(c)) {
                index = getMajTable().indexOf(c);
                actual = index + decalage;
                length = getMajTable().size();
                i = (actual > length) ? ((actual - length) - 1) : (actual - 1);
                toReturn += getMajTable().get(i);
            } else if (getNmbTable().contains(c)) {
                index = getNmbTable().indexOf(c);
                actual = index + decalage - 1;
                length = getNmbTable().size();
                i = (actual >= 10) ? (actual - 9) : actual;
                while (i > length) {
                    i = (i > length) ? ((actual - length) - 1) : (actual - 1);
                }
                toReturn += getNmbTable().get(i);
            } else {
                throw new CeasarEncryptException("Encryption problem");
            }
        }
        return toReturn;
    }

}
