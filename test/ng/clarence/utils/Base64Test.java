package ng.clarence.utils;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Base64Test {
    @Test
    public void base() {
        assertEquals("MQ==", Base64.encode("1"));
        assertEquals("MTI=", Base64.encode("12"));
        assertEquals("MTIz", Base64.encode("123"));
        assertEquals("MTIzNA==", Base64.encode("1234"));
        assertEquals("YSBiIGM=", Base64.encode("a b c"));
    }
}
