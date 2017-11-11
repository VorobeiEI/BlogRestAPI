package com.company.blog.entites;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Post extends BaseEntity {

    @NotBlank
    @Length(min = 5, max = 5000)
    private String content;

    @CreationTimestamp
    @JsonFormat(pattern = "yy-MM-dd")
    private Date creationDate;

    private Long numberOfViews=0L;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Comment> comments;

    public void addComment(Comment comment){
        comments.add(comment);
    }

    public Comment getCommentById(Long id){
        return comments.get(id.intValue());
    }

}
