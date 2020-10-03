package com.famcs;

import org.junit.Test;
import static org.junit.Assert.*;
import static com.famcs.TextSplitting.textSplit;

public class TextSplitTest {

    @Test
    public static void textSplitTests() {
        String text = new String("0123 56789\n01 3 56\n");
        String expectedText = new String("0123\n" + " 56789\n" + "01 3\n" + " 56\n");
        int k = 4;
        text = textSplit(text,k);
        assertEquals(text,expectedText);
    }

};