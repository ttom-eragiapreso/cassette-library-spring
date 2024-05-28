package com.ttom_codes.cassette_library.cassette_library.client;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

@HttpExchange
public interface DiscogsClient {

    String GET_RECORD_BY_RELEASE_TITLE_BARCODE_ARTIST = "&release_title={releaseTitle}&artist={artist}&barcode={barcode}";

    /**
     * @param releaseTitle the release title
     * @param artist the artist
     * @param barcode the barcode
     * @return ResponseEntity<byte[]> -> Xml file.
     */
    @GetExchange(GET_RECORD_BY_RELEASE_TITLE_BARCODE_ARTIST)
    ResponseEntity<byte[]> getRecord(@PathVariable("release_title") String releaseTitle, @PathVariable("artist") String artist, @PathVariable("barcode") String barcode);

}
