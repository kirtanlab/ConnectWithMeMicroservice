package com.ConnectWithMe.Users.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Skills")
@Entity
public class SkillsEntity {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(unique = true)
    private String skillName;
}
