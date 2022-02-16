package com.sparta.blog.Dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class BlogRequestDto {
    private String title;
    private String name;
    private String contents;
}
