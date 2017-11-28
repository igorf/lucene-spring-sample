package com.example.samples.spring.lucene.demo.logic.impl

import com.example.samples.spring.lucene.demo.domain.WikiPage
import com.example.samples.spring.lucene.demo.domain.WikiPageDocumentMarshaller
import com.example.samples.spring.lucene.demo.logic.PageIndexer
import org.apache.lucene.index.IndexWriter
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Configurable

@Configurable
class LucenePageIndexer implements PageIndexer {
    @Autowired private IndexWriter indexWriter

    @Override
    void index(WikiPage page) throws Exception {
        indexWriter.addDocument(WikiPageDocumentMarshaller.documentByPage(page))
        indexWriter.commit()
    }
}
