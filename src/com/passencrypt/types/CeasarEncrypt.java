package com.passencrypt.types;

import com.passencrypt.exception.CeasarEncryptException;

import java.util.ArrayList;

/**
 * Created by Dimitri RODRIGUES-OLIVEIRA on 19/11/2014.
 */
public class CeasarEncrypt {

    private String passwd;
    private int decalage;
    private ArrayList<Character> minTable;
    private ArrayList<Character> majTable;
    private ArrayList<Character> nmbTable;

    private String retour;

    public CeasarEncrypt(String passwd, int decalage) {
        this.decalage = decalage;
        this.passwd = passwd;
        initTables();
        try {
            this.retour = getRetour();
        } catch (CeasarEncryptException e) {
            e.printStackTrace();
        }
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
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

    public String getRetour() throws CeasarEncryptException {
        return encrypt();
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

    private String encrypt() throws CeasarEncryptException {
        String toEncrypt = getPasswd();
        int decalage = getDecalage() + 1;
        String toReturn = "";

        for (Character c : toEncrypt.toCharArray()) {
            if (getMinTable().contains(c)) {
                int i = (getMinTable().indexOf(c) + decalage > getMinTable().size()) ? (getMinTable().size() - decalage) - 1 : getMinTable().indexOf(c) + decalage - 1;
                toReturn += getMinTable().get(i);
            } else if (getMajTable().contains(c)) {
                int i = (getMajTable().indexOf(c) + decalage > getMajTable().size()) ? (getMajTable().size() - decalage) - 1 : getMajTable().indexOf(c) + decalage - 1;
                toReturn += getMajTable().get(i);
            } else if (getMinTable().contains(c)) {
                int i = (getNmbTable().indexOf(c) + decalage);
                while (i > getNmbTable().size()) {
                    i = (i > getNmbTable().size()) ? (getNmbTable().size() - decalage) - 1 : getNmbTable().indexOf(c) + decalage - 1;
                }
                toReturn += getNmbTable().get(i);
            } else {
                throw new CeasarEncryptException("Encryption problem");
            }
        }
        return toReturn;
    }

}
