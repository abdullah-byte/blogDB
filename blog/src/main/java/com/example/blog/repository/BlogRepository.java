package com.example.blog.repository;

import com.example.blog.model.blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository  extends JpaRepository<blog, Long>{
}
