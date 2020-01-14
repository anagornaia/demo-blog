package com.endava.anagornaia.demoblog.persistence.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Data
@Entity
@Table(name = "t_comment")
public class CommentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "comment_id_generator")
    @SequenceGenerator(name = "comment_id_generator", sequenceName = "seq_comment", allocationSize = 10)
    private Long id;

    @Column(name = "uuid", unique = true)
    private String uuid;

    @Column(name = "content")
    private String content;

    @Column(name = "author_name")
    private String authorName;

    @Email
    @Column(name = "email")
    private String email;

    @ManyToOne
    @JoinColumn(name = "blog_post_id")
    BlogPostEntity blogPost;
}
