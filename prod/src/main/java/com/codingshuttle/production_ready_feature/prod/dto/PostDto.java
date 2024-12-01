package com.codingshuttle.production_ready_feature.prod.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostDto {

    private Long id;
    private String title;

    private String description;

}
