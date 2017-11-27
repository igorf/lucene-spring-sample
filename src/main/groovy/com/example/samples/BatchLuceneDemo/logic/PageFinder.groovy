package com.example.samples.BatchLuceneDemo.logic

import com.example.samples.BatchLuceneDemo.domain.WikiPage

interface PageFinder {
    List<WikiPage> find(String keyword) throws Exception
}