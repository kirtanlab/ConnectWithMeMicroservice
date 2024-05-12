package com.ConnectWithMe.Users.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Users")
@Entity
public class UsersEntity {
    @Id
    @GeneratedValue
    private Integer id;
    private String ProfilePicture; //
    private String password; //
    private String Name; //

    @Column(unique = true)
    private String email; //

    private Date createdAt;
    private Date updatedAt;
    private boolean active;
    private boolean status;
    private String bio;
    private String headline; //
    private Integer visits;

    //location , college , degree , in which year , headline Done
}
