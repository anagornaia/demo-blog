package com.endava.anagornaia.demoblog.persistence.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import java.util.Collection;

@Data
@Entity
@Table(name = "t_user")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_id_generator")
    @SequenceGenerator(name="user_id_generator", sequenceName = "user_id_seq")
    private Long id;

    @Column(name = "uuid", unique = true)
    private String uuid;

    @Column(name = "username")
    private String username;

    @Email
    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "secret")
    private String secret;

    @OneToMany (mappedBy = "user")
    Collection<PostEntity> posts;
}
