package com.example.samples.spring.lucene.demo.domain

import org.apache.lucene.document.Document
import org.apache.lucene.document.Field
import org.apache.lucene.document.FieldType
import org.apache.lucene.index.IndexOptions

class WikiPageDocumentMarshaller {
    private final static String FIELD_TITLE = "title"
    private final static String FIELD_CONTENT = "content"

    static Document documentByPage(WikiPage page) {
        final Document document = new Document()

        final FieldType textIndexedType = new FieldType()
        textIndexedType.setStored(true)
        textIndexedType.setIndexOptions(IndexOptions.DOCS)
        textIndexedType.setTokenized(true)

        Field title = new Field(FIELD_TITLE, page.title, textIndexedType)
        Field content = new Field(FIELD_CONTENT, page.text, textIndexedType)

        document.add(title)
        document.add(content)

        document
    }

    static WikiPage pageByDocument(Document document) {
        new WikiPage(
                title: document.get(FIELD_TITLE),
                text: document.get(FIELD_CONTENT)
        )
    }
}
