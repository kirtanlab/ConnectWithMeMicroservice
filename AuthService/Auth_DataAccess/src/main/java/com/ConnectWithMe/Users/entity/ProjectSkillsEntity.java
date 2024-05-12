package com.ConnectWithMe.Users.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ProjectSkills")
@Entity
public class ProjectSkillsEntity {
    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ProjectID" , referencedColumnName = "id")
    private UserProjectsEntity project;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Skills" , referencedColumnName = "id")
    private SkillsEntity skills;
}
