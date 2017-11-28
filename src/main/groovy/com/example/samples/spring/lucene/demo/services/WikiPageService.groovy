package com.example.samples.spring.lucene.demo.services

import com.example.samples.spring.lucene.demo.domain.WikiPage
import com.example.samples.spring.lucene.demo.logic.PageCreator
import com.example.samples.spring.lucene.demo.logic.PageFinder
import com.example.samples.spring.lucene.demo.logic.PageIndexer
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
