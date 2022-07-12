package com.sourav.arrayandstring;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomSortTest {
    @Test
    public void customSort_shouldReturnTrue() {
        String input = "ffenfefbhefbiuf";
        final String order = "dfe";
        final String expected = "ffffffeeebbhinu";
        final String actual = CustomSort.customSortString(order, input);
        assertEquals(expected, actual);
    }
}
