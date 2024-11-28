package org.jzou.dto;

import org.jzou.domain.Genre;

public record MovieDto(Integer id,
                       String title,
                       Integer releaseYear,
                       Genre genre) {
}
