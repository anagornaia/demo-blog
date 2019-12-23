package com.endava.anagornaia.demoblog.persistence.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@Entity
@Table(name = "t_post")
public class PostEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "post_id_generator")
    @SequenceGenerator(name="post_id_generator", sequenceName = "post_id_seq")
    private Long id;

    @Column(name = "uuid", unique = true)
    private String uuid;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name = "create_date")
    @Temporal(TemporalType.TIME)
    private Date createDate;

    @Column(name = "update_time")
    @Temporal(TemporalType.TIME)
    private Date updateTime;

    @ManyToOne
    @JoinColumn(name="author_id")
    UserEntity user;
}
