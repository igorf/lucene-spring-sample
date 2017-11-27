package com.example.samples.BatchLuceneDemo.logic.impl

import com.example.samples.BatchLuceneDemo.domain.WikiPage
import com.example.samples.BatchLuceneDemo.logic.PageCreator
import org.htmlcleaner.HtmlCleaner
import org.htmlcleaner.TagNode

class DefaultPageCreator implements PageCreator {

    private final static HtmlCleaner cleaner = new HtmlCleaner()
    private final static String DEFAULT_HEADER = "UNKNOWN DOCUMENT"
    private final static String DEFAULT_TEXT = ""
    private final static String WIKI_HEADER_XPATH = ".//h1[@id='firstHeading']"
    private final static String WIKI_CONTENT_XPATH = ".//div[@id='mw-content-text']"

    @Override
    WikiPage createFromURL(String url) throws Exception {
        TagNode root = cleaner.clean(new URL(url))
        String header = textFromNode(root, WIKI_HEADER_XPATH, DEFAULT_HEADER)
        String contents = textFromNode(root, WIKI_CONTENT_XPATH, DEFAULT_TEXT)

        return new WikiPage(title: header, text: contents)
    }

    private static String textFromNode(TagNode root, String xpath, String defaultText) {
        if (root == null) {
            return defaultText
        }
        def elements = root.evaluateXPath(xpath)
        if (elements.length > 0) {
            TagNode tn = (TagNode) elements[0]
            return tn?.text ?: defaultText
        }
        defaultText
    }
}
