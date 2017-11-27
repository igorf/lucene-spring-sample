package com.example.samples.BatchLuceneDemo.config

import com.example.samples.BatchLuceneDemo.logic.PageCreator
import com.example.samples.BatchLuceneDemo.logic.PageFinder
import com.example.samples.BatchLuceneDemo.logic.PageIndexer
import com.example.samples.BatchLuceneDemo.logic.impl.DefaultPageCreator
import com.example.samples.BatchLuceneDemo.logic.impl.LucenePageFinder
import com.example.samples.BatchLuceneDemo.logic.impl.LucenePageIndexer
import org.apache.lucene.index.IndexReader
import org.apache.lucene.index.IndexWriter
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class AppConfig {
    @Autowired private IndexWriter luceneWriter
    @Autowired private IndexReader luceneReader

    @Bean
    PageCreator getPageCreator() {
        return new DefaultPageCreator()
    }

    @Bean
    PageIndexer getPageIndexer() {
        LucenePageIndexer idx = new LucenePageIndexer()
        idx.setIndexWriter(luceneWriter)
        return idx
    }

    @Bean
    PageFinder getPageFinder() {
        LucenePageFinder finder = new LucenePageFinder()
        finder.setIndexReader(luceneReader)
        return finder
    }
}
