package com.example.samples.BatchLuceneDemo.logic

import com.example.samples.BatchLuceneDemo.domain.WikiPage

interface PageIndexer {
    void index(WikiPage page) throws Exception
}