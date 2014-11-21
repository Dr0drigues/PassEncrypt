package com.passencrypt.types;

import com.passencrypt.exception.EncryptException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Timmy Parkwayd on 20/11/2014.
 */
public class HebraicEncrypt extends Encrypt {

    private List<Character> orderList;

    public HebraicEncrypt(String passwd) {
        super(passwd);
        initLists();
    }

    private void initLists() {
        orderList = new ArrayList<Character>() {{
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
    }

    @Override
    public String encrypt() throws EncryptException {
        List<Integer> index = new ArrayList<Integer>() {{
            for (Character character : getPasswd().toCharArray()) {
                add(orderList.indexOf(character));
            }
        }};

        String retour = "";

        Collections.reverse(orderList);

        for (Integer integer : index) {
            retour += orderList.get(integer);
        }

        return retour;
    }
}
