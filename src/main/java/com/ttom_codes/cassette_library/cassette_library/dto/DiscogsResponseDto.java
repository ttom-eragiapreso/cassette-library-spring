package com.ttom_codes.cassette_library.cassette_library.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DiscogsResponseDto {

    DiscogsPaginationDto pagination;
    List<DiscogsResultDto> results;

}
