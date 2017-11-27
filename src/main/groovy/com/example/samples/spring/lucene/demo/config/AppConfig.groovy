package com.example.samples.spring.lucene.demo.config

import com.example.samples.spring.lucene.demo.logic.PageCreator
import com.example.samples.spring.lucene.demo.logic.PageIndexer
import com.example.samples.spring.lucene.demo.logic.impl.DefaultPageCreator
import com.example.samples.spring.lucene.demo.logic.impl.LucenePageFinder
import com.example.samples.spring.lucene.demo.logic.impl.LucenePageIndexer
import com.example.samples.spring.lucene.demo.logic.PageFinder
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
