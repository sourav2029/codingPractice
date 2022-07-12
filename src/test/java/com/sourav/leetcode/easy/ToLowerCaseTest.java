package com.sourav.leetcode.easy;

import org.junit.jupiter.api.Test;

import static com.sourav.leetcode.easy.easy.ToLowerCase.toLowerCase;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ToLowerCaseTest {
    @Test
    public void toLowerCase_Test1(){
        final String expected = "areyou insane";
        final String obtained = toLowerCase("AreYou Insane");
        assertEquals(expected, obtained);
    }
}
