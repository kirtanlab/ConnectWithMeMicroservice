package com.ConnectWithMe.Users.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Token")
@Entity
public class TokenEntity {
    @Id
    @GeneratedValue
    private Integer id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userID" , referencedColumnName = "id")
    private UsersEntity userID;

    private String access_token;
}
