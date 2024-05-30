package com.ttom_codes.cassette_library.cassette_library.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DiscogsResultDto {

    private String country;
    private String year;
    private List<String> label;
    private List<String> genre;
    private List<String> style;
    private Long id;
    private String title;
    private String thumb;
    @JsonProperty("cover_image")
    private String coverImage;
    @JsonProperty("resource_url")
    private String resourceUrl;
}
