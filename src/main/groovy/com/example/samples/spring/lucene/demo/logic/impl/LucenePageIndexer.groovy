package com.example.samples.spring.lucene.demo.logic.impl

import com.example.samples.spring.lucene.demo.domain.WikiPage
import com.example.samples.spring.lucene.demo.domain.WikiPageDocumentMarshaller
import com.example.samples.spring.lucene.demo.logic.PageIndexer
import org.apache.lucene.index.IndexWriter

class LucenePageIndexer implements PageIndexer {
    private IndexWriter indexWriter

    void setIndexWriter(IndexWriter indexWriter) {
        this.indexWriter = indexWriter
    }

    @Override
    void index(WikiPage page) throws Exception {
        indexWriter.addDocument(WikiPageDocumentMarshaller.documentByPage(page))
        indexWriter.commit()
    }
}
