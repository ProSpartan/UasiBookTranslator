package com.company.translator;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IrregularWordsTest {
    IrregularWords irregularWords;

    @Before
    public void Before() {
        irregularWords  = IrregularWords.create("me");
    }

    @Test
    public void getWord() {
        assertEquals(irregularWords.getWord(), "me");
    }

    @Test
    public void getTranslatedWord() {
        assertEquals(irregularWords.getTranslatedWord(), "ma");
    }
}