package com.example.samples.spring.lucene.demo.config

import com.example.samples.spring.lucene.demo.logic.PageCreator
import com.example.samples.spring.lucene.demo.logic.PageFinder
import com.example.samples.spring.lucene.demo.logic.PageIndexer
import com.example.samples.spring.lucene.demo.logic.impl.DefaultPageCreator
import com.example.samples.spring.lucene.demo.logic.impl.LucenePageFinder
import com.example.samples.spring.lucene.demo.logic.impl.LucenePageIndexer
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
        new DefaultPageCreator()
    }

    @Bean
    PageIndexer getPageIndexer() {
        new LucenePageIndexer()
    }

    @Bean
    PageFinder getPageFinder() {
        new LucenePageFinder()
    }
}
