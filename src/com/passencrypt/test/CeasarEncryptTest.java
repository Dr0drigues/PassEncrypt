package com.passencrypt.test;

import com.passencrypt.exception.EncryptException;
import com.passencrypt.types.CeasarEncrypt;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.*;

/**
 * Created by Dimitri RODRIGUES-OLIVEIRA on 20/11/2014.
 */
@RunWith(JUnit4.class)
public class CeasarEncryptTest {

    @Test
    public void constructorTest() {
        CeasarEncrypt ceasarEncryptOK = new CeasarEncrypt("Toto", 1);
        CeasarEncrypt ceasarEncryptKO = new CeasarEncrypt("", 0);

        assertEquals("Toto", ceasarEncryptOK.getPasswd());
        assertEquals(1, ceasarEncryptOK.getDecalage());
        assertFalse(ceasarEncryptKO.getDecalage() > 0);
        assertFalse(!"".equals(ceasarEncryptKO.getPasswd()));
    }

    @Test
    public void encryptTest() {
        CeasarEncrypt ceasarEncryptOK = new CeasarEncrypt("Azerty1", 7);

        try {
            assertTrue("Hglyaf9".equals(ceasarEncryptOK.getRetour()));
        } catch (EncryptException e) {
            fail("Encryption failed");
        }
    }

}
