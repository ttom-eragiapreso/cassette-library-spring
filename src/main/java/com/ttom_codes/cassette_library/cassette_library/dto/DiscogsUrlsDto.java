package com.ttom_codes.cassette_library.cassette_library.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DiscogsUrlsDto {

        private String last;
        private String next;
        private String prev;
        private String first;
}
