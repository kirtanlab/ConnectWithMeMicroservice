package com.ConnectWithMe.Users.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "UserProjects")
@Entity
public class UserProjectsEntity {
    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "UserId" , referencedColumnName = "id")
    private UsersEntity user;

    private String ProjectTitle;
    private String ProjectDescription;
    private Integer Stars;
    private Integer visits;
    private Date createdAt;
    private Date UpdatedAt;
}
