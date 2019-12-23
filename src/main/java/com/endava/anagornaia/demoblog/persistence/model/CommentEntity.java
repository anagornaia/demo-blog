package com.endava.anagornaia.demoblog.persistence.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@Entity
@Table(name = "t_comment")
public class CommentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "comment_id_generator")
    @SequenceGenerator(name="comment_id_generator", sequenceName = "comment_id_seq")
    private Long id;

    @Column(name = "uuid", unique = true)
    private String uuid;

    @Column(name = "content")
    private String content;

    @Column(name = "create_time")
    @Temporal(TemporalType.TIME)
    private Date createTime;

    @Column(name = "author_name")
    private String authorName;

    @Email
    @Column(name = "email")
    private String email;

    @Column(name = "post_id")
    private Long postId;

    //if user is registered
    @Column(name = "author_id")
    private Long authorId;

}
