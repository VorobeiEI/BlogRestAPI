package com.company.blog.entites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.*;
import org.springframework.aop.target.LazyInitTargetSource;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
public class Comment extends BaseEntity {

    private String content;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Comment> childList;


    @CreationTimestamp
    private Date dateTime;

    public Comment(String content) {
        this.content = content;
    }

    public void addChildComment(Comment comment){
        childList.add(comment);
    }
}
