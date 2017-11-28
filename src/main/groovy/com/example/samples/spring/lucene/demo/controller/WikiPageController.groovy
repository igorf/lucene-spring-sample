package com.example.samples.spring.lucene.demo.controller

import com.example.samples.spring.lucene.demo.domain.IndexingAddress
import com.example.samples.spring.lucene.demo.domain.SearchInput
import com.example.samples.spring.lucene.demo.domain.WikiPage
import com.example.samples.spring.lucene.demo.services.WikiPageService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
class WikiPageController {

    @Autowired private WikiPageService wikiPageService
    private static final Logger logger = LoggerFactory.getLogger(WikiPageController.class)

    @RequestMapping(value = "/page/add", method = RequestMethod.POST)
    ResponseEntity<Void> indexPage(@RequestBody IndexingAddress indexingAddress) {
        try {
            wikiPageService.index(indexingAddress.url)
            return new ResponseEntity<Void>(HttpStatus.OK)
        } catch (Exception ex) {
            logger.error(ex.message)
            return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @RequestMapping(value = "/page/find", method = RequestMethod.POST)
    ResponseEntity<List<WikiPage>> findPages(@RequestBody SearchInput searchInput) {
        try {
            List<WikiPage> result = wikiPageService.findByKeyword(searchInput.searchPhrase)
            return new ResponseEntity<List<WikiPage>>(result, HttpStatus.OK)
        } catch (Exception ex) {
            logger.error(ex.message)
            return new ResponseEntity<List<WikiPage>>([], HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }
}
