package com.example.samples.spring.lucene.demo.logic.impl

import com.example.samples.spring.lucene.demo.domain.WikiPage
import com.example.samples.spring.lucene.demo.logic.PageFinder
import org.apache.lucene.index.IndexReader
import org.apache.lucene.index.Term
import org.apache.lucene.search.*

import java.text.ParseException

class LucenePageFinder implements PageFinder {
    private final static int DEFAULT_LIMIT = 1000
    private final static int DEFAULT_FUZZY_DEPTH = 2
    private IndexReader indexReader

    void setIndexReader(IndexReader indexReader) {
        this.indexReader = indexReader
    }

    @Override
    List<WikiPage> find(String keyword) throws Exception {
        final def result = []
        for (ScoreDoc sd: fuzzySearch(keyword, "content", DEFAULT_LIMIT)) {
            result << scoreDocToWikiPage(sd)
        }
        result
    }

    private ScoreDoc[] fuzzySearch(final String toSearch, final String searchField, final int limit)
            throws IOException, ParseException {
        final IndexSearcher indexSearcher = new IndexSearcher(indexReader)
        final Term term = new Term(searchField, toSearch)
        final Query query = new FuzzyQuery(term, DEFAULT_FUZZY_DEPTH)
        final TopDocs search = indexSearcher.search(query, limit)

        search.scoreDocs
    }

    private WikiPage scoreDocToWikiPage(final ScoreDoc scoreDoc) {
        new WikiPage(
                title: indexReader.document(scoreDoc.doc).get("title"),
                text: indexReader.document(scoreDoc.doc).get("content")
        )
    }
}
