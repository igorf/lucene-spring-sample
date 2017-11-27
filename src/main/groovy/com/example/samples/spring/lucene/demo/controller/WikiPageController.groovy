package com.example.samples.spring.lucene.demo.controller

import com.example.samples.spring.lucene.demo.domain.IndexResult
import com.example.samples.spring.lucene.demo.domain.IndexingAddress
import com.example.samples.spring.lucene.demo.domain.SearchInput
import com.example.samples.spring.lucene.demo.domain.WikiPage
import com.example.samples.spring.lucene.demo.services.WikiPageService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
class WikiPageController {

    @Autowired
    private WikiPageService wikiPageService

    @RequestMapping(value = "/page/add", method = RequestMethod.POST)
    ResponseEntity<IndexResult> indexPage(@RequestBody IndexingAddress indexingAddress) {
        try {
            wikiPageService.index(indexingAddress.url)
            return new ResponseEntity<IndexResult>(new IndexResult(result: true, message: "ok"), HttpStatus.OK)
        } catch (Exception ex) {
            return new ResponseEntity<IndexResult>(new IndexResult(result: false, message: ex.message), HttpStatus.BAD_REQUEST)
        }
    }

    @RequestMapping("/page/find")
    ResponseEntity<List<WikiPage>> findPages(@RequestBody SearchInput searchInput) {
        try {
            List<WikiPage> result = wikiPageService.findByKeyword(searchInput.searchPhrase)
            return new ResponseEntity<List<WikiPage>>(result, HttpStatus.OK)
        } catch (Exception ex) {
            return new ResponseEntity<List<WikiPage>>([], HttpStatus.BAD_REQUEST)
        }
    }
}
