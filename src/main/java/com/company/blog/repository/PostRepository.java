package com.company.blog.repository;

import com.company.blog.entites.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Date;
import java.util.List;


public interface PostRepository extends PagingAndSortingRepository<Post, Long>{

}
