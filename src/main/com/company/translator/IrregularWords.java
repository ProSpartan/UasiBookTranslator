package com.company.translator;

import com.google.common.base.Preconditions;

import java.util.HashMap;
import java.util.Map;

public class IrregularWords {
    final Map<String, String> IRREGULAR_WORDS = new HashMap<>();
    final String word;

    private IrregularWords(final String word) {
        IRREGULAR_WORDS.put("me", "ma");
        IRREGULAR_WORDS.put("she", "sha");
        IRREGULAR_WORDS.put("he", "ha");
        IRREGULAR_WORDS.put("we", "wa");
        IRREGULAR_WORDS.put("be", "ba");
        IRREGULAR_WORDS.put("do", "da");
        IRREGULAR_WORDS.put("to", "ta");
        IRREGULAR_WORDS.put("a", "ikaku");
        IRREGULAR_WORDS.put("an", "ikaku");
        IRREGULAR_WORDS.put("the", "osi");
        IRREGULAR_WORDS.put("what", "ako");
        IRREGULAR_WORDS.put("and", "upa");
        this.word = word;
    }

    public String getWord() {
        return word;
    }

    public String getTranslatedWord() {
        return IRREGULAR_WORDS.get(word);
    }

    public static IrregularWords create(final String word) {
        Preconditions.checkNotNull(word, "word cannot be null");
        return new IrregularWords(word);
    }
}
