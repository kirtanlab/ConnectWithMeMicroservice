package com.ConnectWithMe.Users.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "UserLinks")
@Entity
public class UserLinksEntity {
    @Id
    @GeneratedValue
    private Integer id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "LinkNameID" , referencedColumnName = "id")
    private LinkNamesEntity LinkTitle;

    private String Link;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "UserID" , referencedColumnName = "id")
    private UsersEntity user;
}
