package com.example.samples.spring.lucene.demo.logic

import com.example.samples.spring.lucene.demo.domain.WikiPage

interface PageFinder {
    List<WikiPage> find(String keyword) throws Exception
}