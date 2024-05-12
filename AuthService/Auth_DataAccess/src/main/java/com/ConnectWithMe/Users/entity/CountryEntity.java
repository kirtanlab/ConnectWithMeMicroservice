package com.ConnectWithMe.Users.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Country")
@Entity
public class CountryEntity {
    @Id
    @GeneratedValue
    private Integer id;
    private String CountryName;
}
