package com.sparta.blog.models;

import com.sparta.blog.Dto.CommentRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
public class Comment extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String comment;

    @Column(nullable = false)
    private Long blogId;

    public Comment(CommentRequestDto requestDto){
        this.name = requestDto.getName();
        this.comment = requestDto.getComment();
        this.blogId = requestDto.getBlogId();
    }

    public void update(CommentRequestDto requestDto) {
        this.name = requestDto.getName();
        this.comment = requestDto.getComment();
        this.blogId = requestDto.getBlogId();
    }

}
