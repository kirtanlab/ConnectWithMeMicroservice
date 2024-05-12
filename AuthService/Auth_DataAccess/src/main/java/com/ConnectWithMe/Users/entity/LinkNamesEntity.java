package com.ConnectWithMe.Users.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "LinkNames")
@Entity
public class LinkNamesEntity {
    @Id
    @GeneratedValue
    private Integer id;

    private String linkName;
}
