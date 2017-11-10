package com.company.blog.reposerviceimpl;

import com.company.blog.entites.Comment;
import com.company.blog.repository.CommentRepository;
import com.company.blog.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by jacksparrow on 10.11.17.
 */
@Service
public class CommentRepositoryServiceImpl implements CommentService {

    private CommentRepository commentRepository;

    @Autowired
    public CommentRepositoryServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }


    @Override
    public Comment findOneById(Long id) {
        return null;
    }

    @Override
    public Long saveOrUpdate(Comment domainObject) {
        return null;
    }

    @Override
    public List<Comment> findAll() {
        return null;
    }

    @Override
    public void deleteLongId(Long id) {

    }
}
