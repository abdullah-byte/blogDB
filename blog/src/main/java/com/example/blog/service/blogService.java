package com.example.blog.service;

import com.example.blog.dto.blogDTO;
import com.example.blog.model.blog;
import com.example.blog.repository.BlogRepository;
import org.springframework.stereotype.Service;

@Service
public class blogService {
    private static BlogRepository blogRepository = null;

    public blogService(BlogRepository blogRepository){
        this.blogRepository = blogRepository;
    }

    public static Object createBlog(blogDTO BlogDTO){
        blog Blog = new blog();

        Blog.setTitle(BlogDTO.getContent());
        Blog.setContent(BlogDTO.getContent());
        Blog.setDateCreated(BlogDTO.getDateCreated());
        Blog.setDateUpdated(BlogDTO.getDateUpdated());

        return blogRepository.save(Blog);
    }

    public static Object getBlog() {
        return null;
    }

    public Object fetchAllBlog(){
        return blogRepository.findAll();
    }

    public Object fetchABlog(BlogRepository blogRepository, Long id){
        return blogRepository.findById(id);
    }

    public static Object updateBlog(blogDTO BlogDTO, Long id){
        blog Blog = blogRepository.findById(id).orElseThrow(() -> new RuntimeException("Blog post not found"));

        Blog.setTitle(BlogDTO.getTitle());
        Blog.setContent(BlogDTO.getContent());
        Blog.setDateCreated(BlogDTO.getDateCreated());
        Blog.setDateUpdated(BlogDTO.getDateUpdated());

        return blogRepository.save(Blog);
    }

    public static Object deleteBlog(long id) {
        blog Blog = blogRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Blog not found"));

        blogRepository.delete(Blog);
        return "Blog has been deleted";
    }
}
