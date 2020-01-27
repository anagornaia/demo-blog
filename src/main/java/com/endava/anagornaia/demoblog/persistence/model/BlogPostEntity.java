package com.endava.anagornaia.demoblog.persistence.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Data
@Entity
@Table(name = "t_blog_post")
public class BlogPostEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "blog_post_id_generator")
    @SequenceGenerator(name = "blog_post_id_generator", sequenceName = "seq_blog_post", allocationSize = 10)
    private Long id;

    @Column(name = "uuid", unique = true)
    private String uuid;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @ManyToOne
    @JoinColumn(name = "author_id")
    UserEntity user;

    @OneToMany(mappedBy = "blogPost")
    Collection<CommentEntity> comments;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "t_blog_post_tag", joinColumns = { @JoinColumn(name = "blog_post_id") }, inverseJoinColumns = { @JoinColumn(name = "tag_id") })
    Set<TagEntity> tags;
}
