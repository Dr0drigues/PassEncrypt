package com.passencrypt.test;

import com.passencrypt.exception.CeasarEncryptException;
import com.passencrypt.types.CeasarEncrypt;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * Created by Dimitri RODRIGUES-OLIVEIRA on 20/11/2014.
 */
@RunWith(JUnit4.class)
public class CeasarEncryptTest {
    @Test
    public void encryptTest() {
        CeasarEncrypt ceasarEncryptOK = new CeasarEncrypt("Azerty1", 7);

        try {
            assertTrue("Hglyaf9".equals(ceasarEncryptOK.getRetour()));
        } catch (CeasarEncryptException e) {
            fail("Encryption failed");
        }
    }

}
