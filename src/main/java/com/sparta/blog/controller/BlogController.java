package com.sparta.blog.controller;

import com.sparta.blog.Dto.*;
import com.sparta.blog.models.Blog;
import com.sparta.blog.models.Comment;
import com.sparta.blog.repository.BlogRepository;
import com.sparta.blog.repository.CommentRepository;
import com.sparta.blog.service.BlogService;
import com.sparta.blog.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class BlogController {

    private final BlogRepository blogRepository;
    private final CommentRepository commentRepository;
    private final BlogService blogService;
    private final CommentService commentService;

    @PostMapping("/api/blogs")
    public Blog creatBlog (@RequestBody BlogRequestDto blogrequestDto){
        Blog blog = new Blog(blogrequestDto);
        return blogRepository.save(blog);
    }

    @GetMapping("/api/blogs")
    public List<Blog> readAllBlog() {
        return blogRepository.findAllByOrderByModifiedAtDesc();
    }


    @PutMapping("/api/blogs/{id}")
    public Long updateBlog(@PathVariable Long id, @RequestBody BlogRequestDto blogrequestDto){
        blogService.update(id, blogrequestDto);
        return id;
    }


    @DeleteMapping("/api/blogs/{id}")
    public Long deleteBlog(@PathVariable Long id) {
        blogRepository.deleteById(id);
        commentRepository.deleteCommentByBlogId(id);
        return id;
    }
/////////////////////////////////////////////////////////////////////////////////////////여기부턴 댓글 request
    @PostMapping("/api/comment")
    public Comment creatComment (@RequestBody CommentRequestDto commentrequestDto) {
        Comment comment = new Comment (commentrequestDto);
        return commentRepository.save(comment);
    }

    @GetMapping("/api/comment/{blogId}")
    public List<Comment> readComment (@PathVariable Long blogId) {
        return commentRepository.findByBlogIdOrderByCreatedAtDesc(blogId);
    }

    @PutMapping("/api/comment/{id}")
    public Long updateComment(@PathVariable Long id, @RequestBody CommentRequestDto commentrequestDto) {
        commentService.updateComment(id, commentrequestDto);
        return id;
    }
    @DeleteMapping("/api/comment/{id}")
    public Long deleteComment(@PathVariable Long id) {
        commentRepository.deleteById(id);
        return id;
    }
}
