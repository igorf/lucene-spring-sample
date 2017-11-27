package com.example.samples.spring.lucene.demo.logic

import com.example.samples.spring.lucene.demo.domain.WikiPage

interface PageIndexer {
    void index(WikiPage page) throws Exception
}