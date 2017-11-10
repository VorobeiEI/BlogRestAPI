package com.company.blog.controller;

import com.company.blog.entites.Comment;
import com.company.blog.entites.Post;
import com.company.blog.requests.CreatePostRequest;
import com.company.blog.requests.UpdatePostRequest;
import com.company.blog.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by jacksparrow on 10.11.17.
 */
@RestController
@RequestMapping("/post")
public class PostController {

    private PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/sortByRating")
    public Page<Post> sortByRating(Pageable pageable){
        Sort sortByDate = new Sort(new Sort.Order(Sort.Direction.DESC,"numberOfViews"));
        pageable = new PageRequest(0,Integer.MAX_VALUE,sortByDate);
        Page<Post> postsByDate = postService.listAllByPage(pageable);
        return postsByDate;
    }
    @GetMapping("/sortByDate")
    public Page<Post> sortByDateMethod(Pageable pageable){
        Sort sortByDate = new Sort(new Sort.Order(Sort.Direction.ASC,"creationDate"));
        pageable = new PageRequest(0,Integer.MAX_VALUE,sortByDate);
        Page<Post> postsByDate = postService.listAllByPage(pageable);
        return postsByDate;
    }
    @GetMapping("/pagination")
    public Page<Post> takeWithPagination(Pageable pageable){
        Page<Post> posts = postService.listAllByPage(pageable);
        return posts;
    }

    @PostMapping("/addcomment")
    public ResponseEntity<?> addComment(@RequestParam Long postId, @RequestBody CreatePostRequest request){
        Post post = postService.findOneById(postId);
        post.addComment(new Comment(request.text));
        postService.saveOrUpdate(post);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @PostMapping
    public ResponseEntity<?> newPost(@RequestBody CreatePostRequest request){
        Post post = new Post();
        post.setContent(request.text);
        postService.saveOrUpdate(post);
        return new ResponseEntity<> (post.getId(), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public Post showPostById(@PathVariable Long id){
        Post post = postService.findOneById(id);
        Long currentViews = post.getNumberOfViews();
        post.setNumberOfViews(currentViews+1);
        postService.saveOrUpdate(post);
        return post;
    }

    @PutMapping("/{id}/update")
    public ResponseEntity<?> updatePost(@RequestBody UpdatePostRequest updatePostRequest, @PathVariable Long id){
        Post post = postService.findOneById(id);
        if(post==null){
            return new ResponseEntity<>("Not found", HttpStatus.NOT_FOUND);
        }
        post.setContent(updatePostRequest.getUpdatedText());
        postService.saveOrUpdate(post);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);

    }

    @DeleteMapping("/{id}/delete")
    public void deletePost(@PathVariable Long id){
        postService.deleteLongId(id);
    }


}
