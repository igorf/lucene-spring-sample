package com.example.samples.spring.lucene.demo.logic

import com.example.samples.spring.lucene.demo.domain.WikiPage

interface PageCreator {
    WikiPage createFromURL(String url) throws Exception
}
