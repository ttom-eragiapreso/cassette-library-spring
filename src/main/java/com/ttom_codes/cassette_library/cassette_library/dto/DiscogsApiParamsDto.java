package com.ttom_codes.cassette_library.cassette_library.dto;

import lombok.Data;

@Data
public class DiscogsApiParamsDto {
    private String releaseTitle;
    private String artist;
    private String barcode;
}
