package com.ttom_codes.cassette_library.cassette_library.client;

import com.ttom_codes.cassette_library.cassette_library.dto.DiscogsResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

@HttpExchange
public interface DiscogsClient {

    String GET_RECORD_BY_RELEASE_TITLE_BARCODE_ARTIST = "?token=" + "HWiFdStcHwaqgBqEAoEjjvCFhQUNnZHqZFuelXuZ" + "&release_title={release_title}&artist={artist}&barcode={barcode}";

    /**
     * @param release_title the release title
     * @param artist the artist
     * @param barcode the barcode
     * @return ResponseEntity<byte[]> -> Xml file.
     */
    @GetExchange(GET_RECORD_BY_RELEASE_TITLE_BARCODE_ARTIST)
    ResponseEntity<DiscogsResponseDto> getRecord(@PathVariable(value = "release_title", required = false) String release_title, @PathVariable(value = "artist", required = false) String artist, @PathVariable(value = "barcode", required = false) String barcode);

}
