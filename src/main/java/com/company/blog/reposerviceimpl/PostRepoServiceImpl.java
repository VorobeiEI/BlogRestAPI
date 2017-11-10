package com.company.blog.reposerviceimpl;

import com.company.blog.entites.Post;
import com.company.blog.repository.PostRepository;
import com.company.blog.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PostRepoServiceImpl implements PostService {
    private PostRepository postRepository;

    @Autowired
    public PostRepoServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public Post findOneById(Long id) {
        return postRepository.findOne(id);
    }

    @Override
    public Long saveOrUpdate(Post domainObject) {
        postRepository.save(domainObject);
        return domainObject.getId();
    }

    @Override
    public List<Post> findAll() {
        return (List<Post>) postRepository.findAll();
    }

    @Override
    public void deleteLongId(Long id) {
        postRepository.delete(id);
    }

    @Override
    public Page<Post> listAllByPage(Pageable pageable) {
        return postRepository.findAll(pageable);
    }


//    @Override
//    public Post getPostByDate(Date date) {
//        return postRepository.getPostsByDate(date);
//    }


}
