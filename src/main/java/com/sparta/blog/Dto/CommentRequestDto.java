package com.sparta.blog.Dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@RequiredArgsConstructor
public class CommentRequestDto {

    private String name;
    private String comment;
    private Long blogId;

}
