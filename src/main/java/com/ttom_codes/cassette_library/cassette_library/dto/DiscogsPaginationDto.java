package com.ttom_codes.cassette_library.cassette_library.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DiscogsPaginationDto {

        @JsonProperty("per_page")
        private Integer perPage;
        private Integer items;
        private Integer page;
        private Integer pages;
        private DiscogsUrlsDto urls;
}
