package com.example.blog.controller;


import com.example.blog.dto.blogDTO;
import com.example.blog.service.blogService;
import com.example.blog.service.blogService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class blogController {

    //Dependency Injection

    private final blogService BlogService;

    public blogController(blogService BlogService) {
        this.BlogService = BlogService;
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }

    // CRUD Create Read Update Delete
    //POST
    @PostMapping(value = "/blog/create")
    public Object createBlog(@RequestBody blogDTO BlogDTO) {
        return blogService.createBlog(BlogDTO);
    }

    //GET
    @GetMapping("/blog")
    public Object getBlog() {
        return blogService.getBlog();
    }

    //PUT
    @PutMapping("/blog/{id}")
    public Object updateBlog(@RequestBody blogDTO BlogDTO, @PathVariable long id) {
        blogDTO blogDTO = null;
        return blogService.updateBlog(blogDTO, id);
    }

    //DELETE
    @DeleteMapping("/blog/{id}")
    public Object deleteBlog(@PathVariable long id) {
        return blogService.deleteBlog(id);
    }
}