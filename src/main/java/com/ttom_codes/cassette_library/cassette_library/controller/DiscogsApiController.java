package com.ttom_codes.cassette_library.cassette_library.controller;

import com.ttom_codes.cassette_library.cassette_library.client.DiscogsClient;
import com.ttom_codes.cassette_library.cassette_library.dto.DiscogsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api-discogs")
@RequestMapping(value = "/api-discogs", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class DiscogsApiController {

    private final DiscogsClient client;

    @GetMapping
    public DiscogsResponseDto getDiscogs(@RequestParam(required = false, name = "release_title") String release_title, @RequestParam(required = false) String artist, @RequestParam(required = false) String barcode) {
        ResponseEntity<DiscogsResponseDto> response = client.getRecord(release_title, artist, barcode);
        if(response.getStatusCode().is4xxClientError()){
            throw new RuntimeException("Client error: " + response.getStatusCode());
        }
        if(response.getStatusCode().is5xxServerError()){
            throw new RuntimeException("Server error: " + response.getStatusCode());
        }
        return response.getBody();
    }
}
