package com.company.blog.repository;

import com.company.blog.entites.Comment;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by jacksparrow on 10.11.17.
 */
public interface CommentRepository extends PagingAndSortingRepository<Comment, Long> {
}
