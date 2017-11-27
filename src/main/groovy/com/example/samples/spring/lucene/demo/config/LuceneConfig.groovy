package com.example.samples.spring.lucene.demo.config

import org.apache.lucene.index.DirectoryReader
import org.apache.lucene.index.IndexReader
import org.apache.lucene.index.IndexWriter
import org.apache.lucene.index.IndexWriterConfig
import org.apache.lucene.store.Directory
import org.apache.lucene.store.FSDirectory
import org.apache.lucene.store.SimpleFSDirectory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

import java.nio.file.Paths

@Configuration
class LuceneConfig {
    private final static INDEX_DIR = "/tmp"

    @Bean(name="luceneWriter")
    IndexWriter getLuceneWriter() {
        Directory indexDirectory = new SimpleFSDirectory(Paths.get(INDEX_DIR))
        IndexWriter writer = new IndexWriter(
                indexDirectory,
                new IndexWriterConfig()
        )

        return writer
    }

    @Bean(name="luceneReader")
    IndexReader getLuceneReader() {
        final Directory dir = FSDirectory.open(Paths.get(INDEX_DIR))
        return DirectoryReader.open(dir)
    }
}
