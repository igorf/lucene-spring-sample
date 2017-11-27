package com.example.samples.BatchLuceneDemo.logic

import com.example.samples.BatchLuceneDemo.domain.WikiPage

interface PageCreator {
    WikiPage createFromURL(String url) throws Exception
}
