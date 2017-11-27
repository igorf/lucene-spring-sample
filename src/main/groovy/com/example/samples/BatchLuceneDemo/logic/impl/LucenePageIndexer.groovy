package com.example.samples.BatchLuceneDemo.logic.impl

import com.example.samples.BatchLuceneDemo.domain.WikiPage
import com.example.samples.BatchLuceneDemo.logic.PageIndexer
import org.apache.lucene.document.Document
import org.apache.lucene.document.Field
import org.apache.lucene.document.FieldType
import org.apache.lucene.index.IndexOptions
import org.apache.lucene.index.IndexWriter

class LucenePageIndexer implements PageIndexer {
    private IndexWriter indexWriter

    void setIndexWriter(IndexWriter indexWriter) {
        this.indexWriter = indexWriter
    }

    @Override
    void index(WikiPage page) throws Exception {
        this.indexWriter.addDocument(documentFromWikiPage(page))
    }

    private static Document documentFromWikiPage(WikiPage wikiPage) {
        final Document document = new Document()

        final FieldType textIndexedType = new FieldType()
        textIndexedType.setStored(true)
        textIndexedType.setIndexOptions(IndexOptions.DOCS)
        textIndexedType.setTokenized(true)

        Field title = new Field("title", wikiPage.title, textIndexedType)
        Field content = new Field("content", wikiPage.text, textIndexedType)

        document.add(title)
        document.add(content)
        return document
    }
}
