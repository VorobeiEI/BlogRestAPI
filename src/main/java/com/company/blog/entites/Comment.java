package com.company.blog.entites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.Transient;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@NoArgsConstructor
@Data
public class Comment extends BaseEntity {

    private String content;


    @CreationTimestamp
    private Date dateTime;

    public Comment(String content) {
        this.content = content;
    }
}
