package com.sparta.blog.service;

import com.sparta.blog.models.Blog;
import com.sparta.blog.repository.BlogRepository;
import com.sparta.blog.Dto.BlogRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class BlogService {

    private final BlogRepository blogRepository;

    @Transactional
    public Long update(Long id, BlogRequestDto requestDto) {
        Blog blog = blogRepository.findById(id).orElseThrow(
                () -> new NullPointerException("아이디가 존재하지 않습니다.")
        );
        blog.update(requestDto);
        return id;
    }
}
