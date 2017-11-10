package com.company.blog.services;

import com.company.blog.entites.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.Date;
import java.util.List;

public interface PostService extends CRUDservice<Post> {

    Page<Post> listAllByPage(Pageable pageable);

}
