package com.example.samples.BatchLuceneDemo.services

import com.example.samples.BatchLuceneDemo.domain.WikiPage
import com.example.samples.BatchLuceneDemo.logic.PageCreator
import com.example.samples.BatchLuceneDemo.logic.PageFinder
import com.example.samples.BatchLuceneDemo.logic.PageIndexer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class WikiPageService {
    @Autowired private PageIndexer pageIndexer
    @Autowired private PageCreator pageCreator
    @Autowired private PageFinder pageFinder

    void index(String url) throws Exception {
        WikiPage page = pageCreator.createFromURL(url)
        pageIndexer.index(page)
    }

    List<WikiPage> findByKeyword(String keyword) throws Exception {
        pageFinder.find(keyword)
    }
}
