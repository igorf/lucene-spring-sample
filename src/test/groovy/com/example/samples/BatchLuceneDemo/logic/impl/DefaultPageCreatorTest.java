package com.example.samples.BatchLuceneDemo.logic.impl;

import com.example.samples.BatchLuceneDemo.domain.WikiPage;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class DefaultPageCreatorTest {
    @Test
    public void createFromURL() throws Exception {
        WikiPage wp = new DefaultPageCreator().createFromURL("https://ru.wikipedia.org/wiki/%D0%A1%D0%BF%D0%B8%D1%81%D0%BE%D0%BA_%D1%84%D0%B8%D0%BB%D1%8C%D0%BC%D0%BE%D0%B2_%D0%90%D1%80%D0%B3%D0%B5%D0%BD%D1%82%D0%B8%D0%BD%D1%8B_2000");
        assertNotNull(wp);
    }
}