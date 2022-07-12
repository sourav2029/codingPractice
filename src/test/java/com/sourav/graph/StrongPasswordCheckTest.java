package com.sourav.graph;

import org.junit.jupiter.api.Test;

import static com.sourav.graph.StrongPasswordChecker.isStrongPassword;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StrongPasswordCheckTest {

    @Test
    public void isStrongPassword_lengthLessThan6Chars_ShouldReturnFalse(){
        String input = "aaas";
        boolean expected = false;
        boolean actual = isStrongPassword(input);
        assertEquals(expected, actual);
    }

    @Test
    public void isStrongPassword_threeConsecutiveCharacters_ShouldReturnFalse(){
        String input = "aaassss";
        boolean expected = false;
        boolean actual = isStrongPassword(input);
        assertEquals(expected, actual);
    }

    @Test
    public void isStrongPassword_notContainingDigit_ShouldReturnFalse(){
        String input = "aassdD";
        boolean expected = false;
        boolean actual = isStrongPassword(input);
        assertEquals(expected, actual);
    }

    @Test
    public void isStrongPassword_validInput_ShouldReturnTrue(){
        String input = "aassDq1";
        boolean expected = true;
        boolean actual = isStrongPassword(input);
        assertEquals(expected, actual);
    }


}
