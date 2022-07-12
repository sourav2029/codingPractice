package com.sourav.leetcode.easy;

import org.junit.jupiter.api.Test;

import static com.sourav.leetcode.easy.easy.DefangingAnIpAddress.defangIPaddr;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DefangingAnIpAddressTest {
    @Test
    public void defangIPaddr_Test1(){
        final String expected = "1[.]1[.]1[.]1";
        final String obtained = defangIPaddr("1.1.1.1");
        assertEquals(expected, obtained);
    }

    @Test
    public void defangIPaddr_Test2(){
        final String expected = "255[.]100[.]50[.]0";
        final String obtained = defangIPaddr("255.100.50.0");
        assertEquals(expected, obtained);
    }
}
